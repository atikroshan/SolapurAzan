package com.example

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.SizeTransform
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.AzanDatabase
import com.example.data.AzanRepository
import com.example.data.PreferencesRepository
import com.example.service.AlarmScheduler
import com.example.ui.AzanViewModel
import com.example.ui.theme.*
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material.icons.filled.VolumeOff
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        java.util.TimeZone.setDefault(java.util.TimeZone.getTimeZone("Asia/Kolkata"))
        
        com.example.service.AzanForegroundService.initFromPrefs(this)
        com.example.worker.PrayerWorkScheduler.scheduleDailySync(applicationContext)
        
        val isAlarm = intent.getBooleanExtra("FROM_ALARM", false)
        if (isAlarm) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O_MR1) {
                setShowWhenLocked(true)
                setTurnScreenOn(true)
            } else {
                @Suppress("DEPRECATION")
                window.addFlags(
                    android.view.WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED or
                    android.view.WindowManager.LayoutParams.FLAG_TURN_SCREEN_ON
                )
            }
        }

        enableEdgeToEdge()
        setContent {
            val context = LocalContext.current
            
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                val permissionLauncher = androidx.activity.compose.rememberLauncherForActivityResult(
                    contract = ActivityResultContracts.RequestPermission()
                ) { isGranted ->
                    // Handle permission grant
                }
                
                LaunchedEffect(Unit) {
                    if (ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
                        permissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
                    }
                }
            }

            val db = remember { AzanDatabase.getDatabase(context) }
            val repo = remember { AzanRepository(context, db.azanDao(), db.prayerLogDao()) }
            val prefs = remember { PreferencesRepository(context) }
            val scheduler = remember { AlarmScheduler(context) }

            val factory = object : ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return AzanViewModel(context.applicationContext, repo, prefs, scheduler) as T
                }
            }
            val viewModel: AzanViewModel = viewModel(factory = factory)

            MyApplicationTheme {
                val uiState by viewModel.uiState.collectAsStateWithLifecycle()
                
                val strings = when (uiState.language) {
                    "hi" -> HindiStrings
                    "ur" -> UrduStrings
                    else -> EnglishStrings
                }

                CompositionLocalProvider(LocalAppStrings provides strings) {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        AzanScreen(
                            viewModel = viewModel,
                            uiState = uiState,
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AzanScreen(viewModel: AzanViewModel, uiState: com.example.ui.UIState, modifier: Modifier = Modifier) {
    var selectedTab by remember { mutableStateOf("home") } // "record", "home", or "ramazan"

    val homeLabel = when (uiState.language) {
        "ur" -> "ہوم"
        "hi" -> "होम"
        else -> "Home"
    }
    val taqwaLabel = when (uiState.language) {
        "ur" -> "تقویٰ"
        "hi" -> "तक़वा"
        else -> "Taqwa"
    }
    val ramazanLabel = when (uiState.language) {
        "ur" -> "رمضان"
        "hi" -> "रमज़ान"
        else -> "Ramazan"
    }

    Scaffold(
        modifier = modifier.fillMaxSize(),
        containerColor = Color.Transparent,
        bottomBar = {
            Surface(
                color = Color(0xFF0A1610).copy(alpha = 0.96f),
                contentColor = Color(0xFFF3DE8E),
                tonalElevation = 8.dp,
                modifier = Modifier
                    .fillMaxWidth()
                    .border(BorderStroke(0.5.dp, Color(0xFFF3DE8E).copy(alpha = 0.2f)))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 4.dp),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    // Left: Taqwa Button (Circle shape)
                    NavCircleItem(
                        selected = selectedTab == "record",
                        onClick = { selectedTab = "record" },
                        icon = if (selectedTab == "record") Icons.Filled.DateRange else Icons.Outlined.DateRange,
                        label = taqwaLabel,
                        testTag = "nav_taqwa_button"
                    )

                    // Center: Home Button (Circle shape)
                    NavCircleItem(
                        selected = selectedTab == "home",
                        onClick = { selectedTab = "home" },
                        icon = if (selectedTab == "home") Icons.Filled.Home else Icons.Outlined.Home,
                        label = homeLabel,
                        testTag = "nav_home_button"
                    )

                    // Right: Ramazan Section Button (Circle shape)
                    NavCircleItem(
                        selected = selectedTab == "ramazan",
                        onClick = { selectedTab = "ramazan" },
                        icon = if (selectedTab == "ramazan") Icons.Filled.NightsStay else Icons.Outlined.NightsStay,
                        label = ramazanLabel,
                        testTag = "nav_ramazan_button"
                    )
                }
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .appBackground()
                .padding(innerPadding)
        ) {
            Image(
                painter = painterResource(id = R.drawable.kaaba_overlay_1780650663524),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop,
                alpha = 0.05f
            )

            AnimatedContent(
                targetState = selectedTab,
                transitionSpec = {
                    fadeIn(animationSpec = tween(200)) togetherWith fadeOut(animationSpec = tween(200))
                },
                label = "screenTransition"
            ) { tab ->
                when (tab) {
                    "record" -> {
                        com.example.ui.TrackerBoardContent(
                            uiState = uiState,
                            onDateSelected = { month, day ->
                                viewModel.selectDate(month, day)
                            },
                            onLanguageSelect = { viewModel.setLanguage(it) },
                            onTogglePrayer = { month, day, prayerName ->
                                viewModel.togglePrayerForDate(month, day, prayerName)
                            }
                        )
                    }
                    "ramazan" -> {
                        com.example.ui.RamazanScreenContent(
                            uiState = uiState,
                            onLanguageSelect = { viewModel.setLanguage(it) }
                        )
                    }
                    else -> {
                        AzanHomeContent(
                            viewModel = viewModel,
                            uiState = uiState
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun AzanHomeContent(
    viewModel: AzanViewModel,
    uiState: com.example.ui.UIState,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            // Replaced Header: Time, Gregorian Date & Urdu Date
            ClockDisplay(
                selectedDate = uiState.selectedDate,
                language = uiState.language,
                todayTimings = uiState.todayTimings,
                onPrevDay = { viewModel.previousDay() },
                onNextDay = { viewModel.nextDay() },
                onToday = { viewModel.selectToday() },
                modifier = Modifier.fillMaxWidth()
            )

            // Language Switcher Row (Header)
            LanguageToggleRow(uiState.language) { viewModel.setLanguage(it) }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Dynamic Azan Active Slots Column
                AzanList(
                    viewModel = viewModel,
                    uiState = uiState,
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        Text(
            text = "Powered by @tek",
            fontSize = 10.sp,
            color = Color.White.copy(alpha = 0.3f),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 4.dp),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun LanguageToggleRow(currentLang: String, onLangSelect: (String) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF0F1522), RoundedCornerShape(12.dp))
            .border(1.dp, Color(0xFF1F293D), RoundedCornerShape(12.dp))
            .padding(4.dp),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        LanguageButton("English", "en", currentLang, onLangSelect, Modifier.weight(1f))
        LanguageButton("हिंदी", "hi", currentLang, onLangSelect, Modifier.weight(1f))
        LanguageButton("اردو", "ur", currentLang, onLangSelect, Modifier.weight(1f))
    }
}

@Composable
fun LanguageButton(
    label: String,
    langCode: String,
    currentLang: String,
    onClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    val isActive = currentLang == langCode
    Box(
        modifier = modifier
            .padding(horizontal = 4.dp)
            .height(34.dp)
            .background(
                brush = if (isActive) {
                    Brush.verticalGradient(
                        listOf(Color(0xFFF3DE8E), Color(0xFFB37C3C))
                    )
                } else {
                    Brush.verticalGradient(
                        listOf(Color(0xFF131926), Color(0xFF131926))
                    )
                },
                shape = RoundedCornerShape(8.dp)
            )
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick(langCode) },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = label,
            fontWeight = if (isActive) FontWeight.ExtraBold else FontWeight.Bold,
            fontSize = if (isActive) 14.sp else 12.sp,
            color = if (isActive) Color(0xFF0C101B) else Color.White.copy(alpha = 0.7f),
            textAlign = TextAlign.Center
        )
    }
}

fun parseTimeToCalendar(timeStr: String, baseCal: Calendar): Calendar {
    val parts = timeStr.split(":")
    val targetCal = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata")).apply {
        timeInMillis = baseCal.timeInMillis
        if (parts.size == 2) {
            set(Calendar.HOUR_OF_DAY, parts[0].toIntOrNull() ?: 0)
            set(Calendar.MINUTE, parts[1].toIntOrNull() ?: 0)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
    }
    return targetCal
}

@Composable
fun ClockDisplay(
    selectedDate: Calendar,
    language: String,
    todayTimings: com.example.data.AzanTiming?,
    onPrevDay: () -> Unit,
    onNextDay: () -> Unit,
    onToday: () -> Unit,
    modifier: Modifier = Modifier
) {
    var currentTime by remember { mutableStateOf(Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata"))) }

    LaunchedEffect(Unit) {
        while (true) {
            kotlinx.coroutines.delay(1000)
            currentTime = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata"))
        }
    }

    val strings = LocalAppStrings.current

    val locale = remember(language) {
        when (language) {
            "hi" -> Locale("hi", "IN")
            "ur" -> Locale("ur")
            else -> Locale.ENGLISH
        }
    }

    val timeFormat = remember(locale) { 
        SimpleDateFormat("hh:mm", locale).apply { 
            timeZone = java.util.TimeZone.getTimeZone("Asia/Kolkata") 
        } 
    }
    val amPmFormat = remember(locale) { 
        SimpleDateFormat("a", locale).apply { 
            timeZone = java.util.TimeZone.getTimeZone("Asia/Kolkata") 
        } 
    }
    val dateFormat = remember(locale) { 
        SimpleDateFormat("EEEE, dd MMM yyyy", locale).apply { 
            timeZone = java.util.TimeZone.getTimeZone("Asia/Kolkata") 
        } 
    }
    
    val secondsFormat = remember(locale) { 
        SimpleDateFormat("ss", locale).apply { 
            timeZone = java.util.TimeZone.getTimeZone("Asia/Kolkata") 
        } 
    }
    val seconds = secondsFormat.format(currentTime.time)

    val today = Calendar.getInstance(java.util.TimeZone.getTimeZone("Asia/Kolkata"))
    val isToday = selectedDate.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
            selectedDate.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)

    val isAfterMaghrib = if (isToday && todayTimings != null) {
        val mToday = parseTimeToCalendar(todayTimings.maghrib, currentTime)
        currentTime.after(mToday)
    } else {
        false
    }

    val islamicDateText = remember(selectedDate, isAfterMaghrib, language) {
        try {
            val gYear = selectedDate.get(Calendar.YEAR)
            val gMonth = selectedDate.get(Calendar.MONTH) + 1
            val gDay = selectedDate.get(Calendar.DAY_OF_MONTH)
            
            val baseLocalDate = java.time.LocalDate.of(gYear, gMonth, gDay)
            val localDate = if (isAfterMaghrib) baseLocalDate else baseLocalDate.minusDays(1)
            val hijrahDate = java.time.chrono.HijrahDate.from(localDate)
            val hYear = hijrahDate.get(java.time.temporal.ChronoField.YEAR)
            val hMonth = hijrahDate.get(java.time.temporal.ChronoField.MONTH_OF_YEAR)
            val hDay = hijrahDate.get(java.time.temporal.ChronoField.DAY_OF_MONTH)
            
            val urduDigits = listOf('۰', '۱', '۲', '۳', '۴', '۵', '۶', '۷', '۸', '۹')
            val hDayUrdu = hDay.toString().map { if (it in '0'..'9') urduDigits[it - '0'] else it }.joinToString("")
            val hYearUrdu = hYear.toString().map { if (it in '0'..'9') urduDigits[it - '0'] else it }.joinToString("")

            val monthNameUrdu = when (hMonth) {
                1 -> "محرم"
                2 -> "صفر"
                3 -> "ربیع الاول"
                4 -> "ربیع الثانی"
                5 -> "جمادی الاول"
                6 -> "جمادی الثانی"
                7 -> "رجب"
                8 -> "شعبان"
                9 -> "رمضان"
                10 -> "شوال"
                11 -> "ذوالقعدہ"
                12 -> "ذوالحجہ"
                else -> ""
            }

            val urduDateFormatted = "$hDayUrdu $monthNameUrdu $hYearUrdu ہجری"

            when (language) {
                "ur" -> "اسلامی تاریخ: $urduDateFormatted"
                "hi" -> {
                    val monthNameHi = when (hMonth) {
                        1 -> "मुहर्रम"
                        2 -> "सफ़र"
                        3 -> "रबी अल-अव्वल"
                        4 -> "रबी अउ-थानी"
                        5 -> "जमाद अल-अव्वल"
                        6 -> "जमाद अउ-थानी"
                        7 -> "रजब"
                        8 -> "शबान"
                        9 -> "रमज़ान"
                        10 -> "शव्वाल"
                        11 -> "ज़ु अल-क़ादा"
                        12 -> "ज़ु अल-हिज्जह"
                        else -> ""
                    }
                    "इस्लामिक तारीख: $hDay $monthNameHi $hYear हिजरी"
                }
                else -> {
                    val monthNameEn = when (hMonth) {
                        1 -> "Muharram"
                        2 -> "Safar"
                        3 -> "Rabi-ul-Awwal"
                        4 -> "Rabi-us-Sani"
                        5 -> "Jamadi-ul-Awwal"
                        6 -> "Jamadi-us-Sani"
                        7 -> "Rajab"
                        8 -> "Shaban"
                        9 -> "Ramadan"
                        10 -> "Shawaal"
                        11 -> "Zul-Qadah"
                        12 -> "Zul-Hijjah"
                        else -> ""
                    }
                    "Islamic Date: $hDay $monthNameEn $hYear AH"
                }
            }
        } catch (e: Exception) {
            ""
        }
    }

    Box(
        modifier = modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(top = 0.dp, bottom = 4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.Bottom,
                horizontalArrangement = Arrangement.Center
            ) {
                val timeString = timeFormat.format(currentTime.time)
                Row {
                    timeString.forEachIndexed { index, char ->
                        AnimatedContent(
                            targetState = char,
                            transitionSpec = {
                                (slideInVertically { height -> height } + fadeIn()) togetherWith
                                        (slideOutVertically { height -> -height } + fadeOut())
                            },
                            label = "TimeCharAnimation$index"
                        ) { c ->
                            Text(
                                text = c.toString(),
                                fontSize = 52.sp,
                                fontWeight = FontWeight.Black,
                                style = androidx.compose.ui.text.TextStyle(
                                    brush = Brush.verticalGradient(
                                        colors = listOf(Color(0xFFF3DE8E), Color(0xFFB37C3C))
                                    )
                                ),
                                letterSpacing = (-1).sp
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.width(6.dp))
                Column(
                    modifier = Modifier.padding(bottom = 10.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Row {
                        seconds.forEachIndexed { index, char ->
                            AnimatedContent(
                                targetState = char,
                                transitionSpec = {
                                    (slideInVertically { height -> height } + fadeIn()) togetherWith
                                            (slideOutVertically { height -> -height } + fadeOut())
                                },
                                label = "SecondCharAnimation$index"
                            ) { c ->
                                Text(
                                    text = c.toString(),
                                    fontSize = 20.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = MaterialTheme.colorScheme.secondary
                                )
                            }
                        }
                    }
                    Text(
                        text = amPmFormat.format(currentTime.time).uppercase(),
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                        color = TextColor
                    )
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                val isFriday = selectedDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY
                val dateColor = if (isFriday) Color(0xFF25D366) else Color.White
                val dayName = strings.getDayOfWeekFull(selectedDate.get(Calendar.DAY_OF_WEEK)).uppercase()
                val dayNum = selectedDate.get(Calendar.DAY_OF_MONTH)
                val monthShort = strings.getMonthShortName(selectedDate.get(Calendar.MONTH) + 1).uppercase()
                val yearNum = selectedDate.get(Calendar.YEAR)
                val formattedDate = "$dayName, $dayNum $monthShort $yearNum"
                Text(
                    text = formattedDate,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.Bold,
                    color = dateColor,
                    letterSpacing = 1.5.sp,
                    modifier = Modifier.padding(horizontal = 4.dp),
                    textAlign = TextAlign.Center
                )
            }
            
            if (islamicDateText.isNotEmpty()) {
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .background(
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.12f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = MaterialTheme.colorScheme.primary.copy(alpha = 0.35f),
                            shape = RoundedCornerShape(16.dp)
                        )
                        .padding(horizontal = 14.dp, vertical = 6.dp)
                ) {
                    Text(
                        text = islamicDateText,
                        fontSize = if (language == "ur") 14.sp else 12.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.secondary,
                        letterSpacing = if (language == "ur") 0.sp else 0.5.sp,
                        textAlign = TextAlign.Center
                    )
                }
            }

            if (!isToday) {
                Spacer(modifier = Modifier.height(4.dp))
                Box(
                    modifier = Modifier
                        .clickable { onToday() }
                        .border(1.dp, MaterialTheme.colorScheme.primary.copy(alpha = 0.7f), RoundedCornerShape(10.dp))
                        .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.15f), RoundedCornerShape(10.dp))
                        .padding(horizontal = 10.dp, vertical = 2.dp)
                ) {
                    Text(
                        text = strings.goToToday,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.ExtraBold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Composable
fun AzanList(viewModel: AzanViewModel, uiState: com.example.ui.UIState, modifier: Modifier = Modifier) {
    val strings = LocalAppStrings.current
    
    // Determine next azan based on time (highlighted accordion stays open)
    val initialNextIndex = remember(uiState.todayTimings) {
        val nowMs = System.currentTimeMillis()
        val isAudioPlaying = com.example.service.AzanForegroundService.isPlayingAzan.value
        val lastFinishedTime = com.example.service.AzanForegroundService.lastAudioFinishedTime.value
        val lastAudioIdx = com.example.service.AzanForegroundService.lastAudioPrayerIndex.value
        val fifteenMinMs = 15 * 60 * 1000L

        if (isAudioPlaying && lastAudioIdx in 0..5) {
            lastAudioIdx
        } else if (lastAudioIdx in 0..5 && lastFinishedTime > 0L && (nowMs - lastFinishedTime) < fifteenMinMs) {
            lastAudioIdx
        } else {
            val timings = uiState.todayTimings
            if (timings != null) {
                val cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"))
                val currentMinutes = cal.get(Calendar.HOUR_OF_DAY) * 60 + cal.get(Calendar.MINUTE)
                val prayerSlots = listOf(timings.fajr, timings.dhuhr, timings.asr, timings.maghrib, timings.isha)
                val minutesSlots = prayerSlots.map { 
                    val p = it.split(":")
                    if (p.size == 2) p[0].toInt() * 60 + p[1].toInt() else 0
                }
                val idx = minutesSlots.indexOfFirst { it > currentMinutes }
                if (idx != -1) idx else 0
            } else 0
        }
    }
    var currentNextIndex by remember { mutableIntStateOf(initialNextIndex) }
    var lastTriggeredMinute by remember { mutableStateOf("") }
    val context = androidx.compose.ui.platform.LocalContext.current
    
    LaunchedEffect(uiState.todayTimings, uiState.fajrEnabled, uiState.dhuhrEnabled, uiState.asrEnabled, uiState.maghribEnabled, uiState.ishaEnabled) {
        while (true) {
            viewModel.refreshDate()
            val timings = uiState.todayTimings
            if (timings != null) {
                val cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"))
                val currentHour = cal.get(Calendar.HOUR_OF_DAY)
                val currentMin = cal.get(Calendar.MINUTE)
                val currentMinutes = currentHour * 60 + currentMin
                val currentTimeStr = String.format("%02d:%02d", currentHour, currentMin)
                
                val slots = listOf(timings.fajr, timings.dhuhr, timings.asr, timings.maghrib, timings.isha, "01:30")
                val minutesSlots = slots.map { 
                    val p = it.split(":")
                    if(p.size == 2) p[0].toInt() * 60 + p[1].toInt() else 0
                }
                
                val idx = minutesSlots.indexOfFirst { it > currentMinutes }
                val calculatedNext = if (idx != -1) idx else 0 // loop to fajr if all passed
                
                val nowMs = System.currentTimeMillis()
                val isAudioPlaying = com.example.service.AzanForegroundService.isPlayingAzan.value
                val lastFinishedTime = com.example.service.AzanForegroundService.lastAudioFinishedTime.value
                val audioPrayerIdx = com.example.service.AzanForegroundService.lastAudioPrayerIndex.value
                val fifteenMinMs = 15 * 60 * 1000L

                if (isAudioPlaying && audioPrayerIdx in 0..5) {
                    currentNextIndex = audioPrayerIdx
                } else if (audioPrayerIdx in 0..5 && lastFinishedTime > 0L && (nowMs - lastFinishedTime) < fifteenMinMs) {
                    // For 15 minutes after audio finishes, keep highlighted on this prayer!
                    currentNextIndex = audioPrayerIdx
                } else {
                    // After 15 minutes have passed since audio finished, advance to the next upcoming prayer!
                    currentNextIndex = calculatedNext
                }

                // In-app prayer time audio playback trigger (plays user audio once and closes)
                val prayerPairs = listOf(
                    "Fajr" to (timings.fajr to uiState.fajrEnabled),
                    "Dhuhr" to (timings.dhuhr to uiState.dhuhrEnabled),
                    "Asr" to (timings.asr to uiState.asrEnabled),
                    "Maghrib" to (timings.maghrib to uiState.maghribEnabled),
                    "Isha" to (timings.isha to uiState.ishaEnabled)
                )
                val dayOfYear = cal.get(Calendar.DAY_OF_YEAR)
                for ((name, pair) in prayerPairs) {
                    val (timeStr, isEnabled) = pair
                    if (isEnabled && timeStr == currentTimeStr) {
                        val triggerKey = "$name-$currentTimeStr-$dayOfYear"
                        if (lastTriggeredMinute != triggerKey) {
                            lastTriggeredMinute = triggerKey
                            val serviceIntent = Intent(context, com.example.service.AzanForegroundService::class.java).apply {
                                putExtra("AZAN_NAME", name)
                            }
                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                                context.startForegroundService(serviceIntent)
                            } else {
                                context.startService(serviceIntent)
                            }
                        }
                    }
                }
            }
            delay(1000L)
        }
    }

    val isFridayToday = uiState.selectedDate.get(java.util.Calendar.DAY_OF_WEEK) == java.util.Calendar.FRIDAY
    val dhuhrLabel = if (isFridayToday) strings.jumah else strings.dhuhr.uppercase()
    val slots = listOf(
        Triple("Fajr", strings.fajr.uppercase(), uiState.todayTimings?.fajr ?: "--:--"),
        Triple("Dhuhr", dhuhrLabel, uiState.todayTimings?.dhuhr ?: if (isFridayToday) "12:30" else "--:--"),
        Triple("Asr", strings.asr.uppercase(), uiState.todayTimings?.asr ?: "--:--"),
        Triple("Maghrib", strings.maghrib.uppercase(), uiState.todayTimings?.maghrib ?: "--:--"),
        Triple("Isha", strings.isha.uppercase(), uiState.todayTimings?.isha ?: "--:--"),
        Triple("Tahajjud", strings.tahajjud.uppercase(), "01:30")
    )
    val toggles = listOf(
        uiState.fajrEnabled, uiState.dhuhrEnabled, uiState.asrEnabled, uiState.maghribEnabled, uiState.ishaEnabled, false // no audio for tahajjud
    )

    // Icons assigned representing the visual path of the day/night
    val icons = listOf(
        Icons.Outlined.WbTwilight, // Fajr
        Icons.Outlined.WbSunny,    // Dhuhr
        Icons.Outlined.WbCloudy,   // Asr
        Icons.Outlined.NightsStay, // Maghrib (moon with cloud)
        Icons.Outlined.Nightlight, // Isha
        Icons.Outlined.StarRate    // Tahajjud
    )

    val today = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"))
    val isToday = uiState.selectedDate.get(Calendar.YEAR) == today.get(Calendar.YEAR) &&
            uiState.selectedDate.get(Calendar.DAY_OF_YEAR) == today.get(Calendar.DAY_OF_YEAR)

    val prayedList = listOf(
        uiState.fajrPrayed,
        uiState.dhuhrPrayed,
        uiState.asrPrayed,
        uiState.maghribPrayed,
        uiState.ishaPrayed,
        uiState.tahajjudPrayed
    )

    var expandedIndex by remember(currentNextIndex) { mutableIntStateOf(currentNextIndex) }

    val isPlayingAzan by com.example.service.AzanForegroundService.isPlayingAzan.collectAsState()

    LaunchedEffect(currentNextIndex, isToday) {
        if (isToday && currentNextIndex != -1) {
            expandedIndex = currentNextIndex
        }
    }

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        if (isPlayingAzan) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 6.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFF1E293B)),
                shape = RoundedCornerShape(12.dp),
                border = BorderStroke(1.dp, Color(0xFFEAB308))
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Filled.VolumeUp,
                            contentDescription = "Azan Playing",
                            tint = Color(0xFFEAB308),
                            modifier = Modifier.size(22.dp)
                        )
                        Column {
                            Text(
                                text = "Azan Playing",
                                fontWeight = FontWeight.Bold,
                                fontSize = 13.sp,
                                color = Color.White
                            )
                            Text(
                                text = "Playing once • Auto closing",
                                fontSize = 10.sp,
                                color = Color.White.copy(alpha = 0.7f)
                            )
                        }
                    }
                    Button(
                        onClick = {
                            val stopIntent = Intent(context, com.example.service.AzanForegroundService::class.java).apply {
                                action = "STOP_AZAN"
                            }
                            context.startService(stopIntent)
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFDC2626),
                            contentColor = Color.White
                        ),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 4.dp),
                        shape = RoundedCornerShape(8.dp)
                    ) {
                        Text("Stop", fontSize = 12.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        slots.forEachIndexed { index, triple ->
            val isNext = isToday && (index == currentNextIndex)
            val isExpanded = (index == expandedIndex)
            
            AzanSlot(
                systemName = triple.first,
                displayName = triple.second,
                time = triple.third,
                enabled = toggles[index],
                isNext = isNext,
                icon = icons[index],
                prayed = prayedList[index],
                expanded = isExpanded,
                showAudioToggle = triple.first != "Tahajjud",
                onHeaderClick = {
                    expandedIndex = if (isExpanded) -1 else index
                },
                modifier = Modifier.animateContentSize(),
                onToggle = { enabled -> viewModel.toggleAzan(triple.first, enabled) },
                onPrayedToggle = {
                    if (isToday && !prayedList[index]) {
                        val prayerCal = parseTimeToCalendar(triple.third, Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"))).apply {
                            add(Calendar.MINUTE, 20)
                        }
                        val now = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"))
                        if (now.before(prayerCal)) {
                            val msg = String.format(strings.prayerTimeNotArrivedToast, triple.second, triple.third)
                            android.widget.Toast.makeText(
                                context,
                                msg,
                                android.widget.Toast.LENGTH_SHORT
                            ).show()
                            return@AzanSlot
                        }
                    }
                    viewModel.togglePrayerPrayed(triple.first)
                }
            )
        }
    }
}

fun getRakatSegments(prayerName: String, strings: com.example.ui.theme.AppStrings, isJumuah: Boolean = false): List<Pair<String, Int>> {
    return when (prayerName) {
        "Fajr" -> listOf(
            Pair(strings.sunnat, 2),
            Pair(strings.farz, 2)
        )
        "Dhuhr" -> if (isJumuah) {
            listOf(
                Pair(strings.sunnat, 4),
                Pair(strings.farz, 2),
                Pair(strings.sunnat, 4),
                Pair(strings.sunnat, 2),
                Pair(strings.nafil, 2)
            )
        } else {
            listOf(
                Pair(strings.sunnat, 4),
                Pair(strings.farz, 4),
                Pair(strings.sunnat, 2),
                Pair(strings.nafil, 2)
            )
        }
        "Asr" -> listOf(
            Pair(strings.sunnat, 4),
            Pair(strings.farz, 4)
        )
        "Maghrib" -> listOf(
            Pair(strings.farz, 3),
            Pair(strings.sunnat, 2),
            Pair(strings.nafil, 2)
        )
        "Isha" -> listOf(
            Pair(strings.sunnat, 4),
            Pair(strings.farz, 4),
            Pair(strings.sunnat, 2),
            Pair(strings.nafil, 2),
            Pair(strings.witr, 3),
            Pair(strings.nafil, 2)
        )
        "Tahajjud" -> listOf(
            Pair(strings.nafil, 2)
        )
        else -> emptyList()
    }
}

@Composable
fun AzanSlot(
    systemName: String,
    displayName: String,
    time: String,
    enabled: Boolean,
    isNext: Boolean,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    prayed: Boolean,
    expanded: Boolean,
    onHeaderClick: () -> Unit,
    modifier: Modifier = Modifier,
    showAudioToggle: Boolean = true,
    onToggle: (Boolean) -> Unit,
    onPrayedToggle: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition(label = "trimTransition")
    
    val flareProgress by infiniteTransition.animateFloat(
        initialValue = -1f,
        targetValue = 2f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 2500, easing = androidx.compose.animation.core.LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "flare"
    )
    
    val pulseAlpha by infiniteTransition.animateFloat(
        initialValue = 0.35f,
        targetValue = 0.8f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "pulse"
    )

    val tintColor = MaterialTheme.colorScheme.primary
    val strings = LocalAppStrings.current

    val googleColors = listOf(
        Color(0xFF4285F4),
        Color(0xFFEA4335),
        Color(0xFFFBBC05),
        Color(0xFF34A853),
        Color(0xFF4285F4)
    )

    Card(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onHeaderClick() }
            .background(
                brush = Brush.verticalGradient(
                    colors = if (isNext) listOf(
                        Color.White.copy(alpha = 0.05f * pulseAlpha),
                        Color.White.copy(alpha = 0.02f)
                    ) else listOf(
                        Color.White.copy(alpha = 0.08f),
                        Color(0xFF0E131F).copy(alpha = 0.35f),
                        Color.Black.copy(alpha = 0.3f)
                    )
                ),
                shape = RoundedCornerShape(16.dp)
            )
            .drawWithContent {
                drawContent()
                if (isNext) {
                    val strokeWidth = 1.5.dp.toPx()
                    val halfStroke = strokeWidth / 2f
                    val stroke = Stroke(width = strokeWidth)
                    val corner = androidx.compose.ui.geometry.CornerRadius(16.dp.toPx() - halfStroke)
                    val topLeft = androidx.compose.ui.geometry.Offset(halfStroke, halfStroke)
                    val borderSize = androidx.compose.ui.geometry.Size(size.width - strokeWidth, size.height - strokeWidth)
                    
                    val center = flareProgress * size.width
                    val span = size.width * 0.7f
                    
                    // Sharp shining animated border (Google speech style)
                    drawRoundRect(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                Color.Transparent,
                                googleColors[0],
                                googleColors[1],
                                googleColors[2],
                                googleColors[3],
                                Color.Transparent
                            ),
                            startX = center - span,
                            endX = center + span
                        ),
                        topLeft = topLeft,
                        size = borderSize,
                        style = stroke,
                        cornerRadius = corner
                    )
                } else {
                    // Glass border for inactive slots
                    val strokeWidth = 1.dp.toPx()
                    val halfStroke = strokeWidth / 2f
                    drawRoundRect(
                        color = Color.White.copy(alpha = 0.08f),
                        topLeft = androidx.compose.ui.geometry.Offset(halfStroke, halfStroke),
                        size = androidx.compose.ui.geometry.Size(size.width - strokeWidth, size.height - strokeWidth),
                        style = Stroke(width = strokeWidth),
                        cornerRadius = androidx.compose.ui.geometry.CornerRadius(16.dp.toPx() - halfStroke)
                    )
                }
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = if (isNext) 22.dp else 7.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier.weight(1f).padding(end = 2.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Glow icon wrapper
                    Box(
                        modifier = Modifier
                            .size(38.dp)
                            .background(
                                color = if (isNext) MaterialTheme.colorScheme.secondary.copy(alpha = 0.2f) else Color(0xFF1A2234),
                                shape = RoundedCornerShape(10.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = icon,
                            contentDescription = displayName,
                            tint = if (isNext) MaterialTheme.colorScheme.secondary else MaterialTheme.colorScheme.primary,
                            modifier = Modifier.size(20.dp)
                        )
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = displayName,
                            fontSize = if (isNext) {
                                if (systemName == "Maghrib") 18.sp else 22.sp
                            } else 16.sp,
                            fontWeight = if (isNext) FontWeight.Black else FontWeight.Bold,
                            color = if (isNext) MaterialTheme.colorScheme.secondary else TextColor,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                        if (isNext) {
                            Spacer(modifier = Modifier.height(2.dp))
                            Text(
                                text = strings.next,
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Black,
                                color = Color.Black,
                                style = androidx.compose.ui.text.TextStyle(
                                    platformStyle = androidx.compose.ui.text.PlatformTextStyle(
                                        includeFontPadding = false
                                    ),
                                    lineHeight = 8.sp
                                ),
                                modifier = Modifier
                                    .background(Color(0xFFFFD700), RoundedCornerShape(3.dp))
                                    .padding(horizontal = 6.dp, vertical = 2.dp)
                            )
                        }
                    }
                }
                
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    PrayerTimeDisplay(time24 = time, isNext = isNext)
                    
                    IconButton(onClick = onPrayedToggle, modifier = Modifier.size(32.dp)) {
                        Icon(
                            imageVector = if (prayed) Icons.Filled.CheckCircle else Icons.Outlined.CheckCircle,
                            contentDescription = "Mark as Prayed",
                            tint = if (prayed) Color(0xFF25D366) else TextMuted,
                            modifier = Modifier.size(22.dp)
                        )
                    }
                    
                    if (showAudioToggle) {
                        IconButton(onClick = { onToggle(!enabled) }, modifier = Modifier.size(32.dp)) {
                            if (enabled) {
                                Icon(
                                    imageVector = Icons.Filled.VolumeUp,
                                    contentDescription = "Toggle Audio",
                                    tint = MaterialTheme.colorScheme.secondary
                                )
                            } else {
                                Box(
                                    modifier = Modifier
                                        .size(24.dp)
                                        .drawWithContent {
                                            drawCircle(
                                                color = Color.Red,
                                                radius = size.minDimension / 2,
                                                style = Stroke(width = 2.dp.toPx())
                                            )
                                            drawLine(
                                                color = Color.Red,
                                                start = Offset(4.dp.toPx(), 4.dp.toPx()),
                                                end = Offset(size.width - 4.dp.toPx(), size.height - 4.dp.toPx()),
                                                strokeWidth = 2.dp.toPx()
                                            )
                                            drawContent()
                                        },
                                    contentAlignment = Alignment.Center
                                ) {
                                    Icon(
                                        imageVector = Icons.Filled.VolumeUp,
                                        contentDescription = "Toggle Audio",
                                        tint = Color.White,
                                        modifier = Modifier.size(14.dp)
                                    )
                                }
                            }
                        }
                    }
                    
                    Icon(
                        imageVector = if (expanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = "Toggle Rak'at Accordion",
                        tint = if (isNext) MaterialTheme.colorScheme.secondary else TextMuted,
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
            
            androidx.compose.animation.AnimatedVisibility(visible = expanded) {
                val isJumuah = systemName == "Dhuhr" && (displayName.equals("JUMAH", ignoreCase = true) || displayName.equals(strings.jumah, ignoreCase = true))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 12.dp)
                        .background(Color(0xFF0F1522), RoundedCornerShape(12.dp))
                        .border(1.dp, Color(0xFF1F293D), RoundedCornerShape(12.dp))
                        .padding(10.dp)
                ) {
                    val segments = getRakatSegments(systemName, strings, isJumuah)
                    val totalRakat = segments.sumOf { it.second }
                    
                    val typeHeader = strings.prayerType
                    val countHeader = strings.rakats

                    Column(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        // Table Header Row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFF162035), RoundedCornerShape(topStart = 8.dp, topEnd = 8.dp))
                                .padding(vertical = 8.dp, horizontal = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = typeHeader,
                                modifier = Modifier.weight(1f),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.secondary,
                                letterSpacing = 0.5.sp
                            )
                            Text(
                                text = countHeader,
                                modifier = Modifier.width(80.dp),
                                fontSize = 11.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.secondary,
                                textAlign = TextAlign.End,
                                letterSpacing = 0.5.sp
                            )
                        }

                        // Data rows below
                        segments.forEachIndexed { idx, segment ->
                            val color = when {
                                segment.first.contains(strings.sunnat) -> Color(0xFF00C853)
                                segment.first == strings.farz -> Color(0xFFFFD600)
                                segment.first == strings.nafil -> Color(0xFF00B0FF)
                                segment.first == strings.witr -> Color(0xFFAA00FF)
                                else -> MaterialTheme.colorScheme.primary
                            }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(if (idx % 2 == 0) Color(0xFF0C1220) else Color(0xFF0F1522))
                                    .padding(vertical = 8.dp, horizontal = 12.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Row(
                                    modifier = Modifier.weight(1f),
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    Box(
                                        modifier = Modifier
                                            .size(8.dp)
                                            .background(color, RoundedCornerShape(2.dp))
                                    )
                                    Text(
                                        text = segment.first,
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = TextColor
                                    )
                                }
                                Text(
                                    text = "${segment.second}",
                                    modifier = Modifier.width(80.dp),
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.ExtraBold,
                                    color = TextColor,
                                    textAlign = TextAlign.End
                                )
                            }
                        }

                        // Total Row
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color(0xFF162035), RoundedCornerShape(bottomStart = 8.dp, bottomEnd = 8.dp))
                                .padding(vertical = 8.dp, horizontal = 12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = strings.total,
                                modifier = Modifier.weight(1f),
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Black,
                                color = MaterialTheme.colorScheme.secondary
                            )
                            Text(
                                text = "$totalRakat",
                                modifier = Modifier.width(80.dp),
                                fontSize = 13.sp,
                                fontWeight = FontWeight.Black,
                                color = MaterialTheme.colorScheme.secondary,
                                textAlign = TextAlign.End
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Modifier.appBackground(): Modifier {
    val primaryColor = MaterialTheme.colorScheme.primary
    return this
        .background(
            Brush.verticalGradient(
                colors = listOf(
                    Color(0xFF030509),
                    Color(0xFF070B12),
                    Color(0xFF030509)
                )
            )
        )
        .islamicStarBackground(primaryColor)
        .animatedWavingLines(primaryColor)
}

// Draw starry sky decoration with Islamic overlay overlay
fun Modifier.islamicStarBackground(primaryColor: Color) = this.drawBehind {
    val width = size.width
    val height = size.height

    // 1. Draw large subtle crescent in the background
    val moonCenter = Offset(width * 0.85f, height * 0.18f)
    val moonRadius = width * 0.15f
    val cutoutCenter = Offset(width * 0.79f, height * 0.15f)

    val moonPath = androidx.compose.ui.graphics.Path().apply {
        addOval(androidx.compose.ui.geometry.Rect(moonCenter, moonRadius))
    }
    val cutoutPath = androidx.compose.ui.graphics.Path().apply {
        addOval(androidx.compose.ui.geometry.Rect(cutoutCenter, moonRadius * 1.05f))
    }
    val crescentPath = androidx.compose.ui.graphics.Path().apply {
        op(moonPath, cutoutPath, androidx.compose.ui.graphics.PathOperation.Difference)
    }
    drawPath(
        path = crescentPath,
        color = primaryColor.copy(alpha = 0.08f)
    )

    // 2. Draw Mosque Silhouette at the bottom
    val base = height
    val silhouettePath = androidx.compose.ui.graphics.Path().apply {
        moveTo(0f, base)
        lineTo(0f, base - height * 0.08f)
        
        // Left small dome
        quadraticBezierTo(width * 0.12f, base - height * 0.14f, width * 0.25f, base - height * 0.08f)
        
        // Left minaret
        lineTo(width * 0.28f, base - height * 0.08f)
        lineTo(width * 0.28f, base - height * 0.22f)
        lineTo(width * 0.3f, base - height * 0.25f)
        lineTo(width * 0.32f, base - height * 0.22f)
        lineTo(width * 0.32f, base - height * 0.08f)
        
        // Main dome
        lineTo(width * 0.35f, base - height * 0.08f)
        cubicTo(
            width * 0.4f, base - height * 0.26f,
            width * 0.6f, base - height * 0.26f,
            width * 0.65f, base - height * 0.08f
        )
        
        // Right minaret
        lineTo(width * 0.68f, base - height * 0.08f)
        lineTo(width * 0.68f, base - height * 0.22f)
        lineTo(width * 0.7f, base - height * 0.25f)
        lineTo(width * 0.72f, base - height * 0.22f)
        lineTo(width * 0.72f, base - height * 0.08f)
        
        // Right small dome
        lineTo(width * 0.75f, base - height * 0.08f)
        quadraticBezierTo(width * 0.88f, base - height * 0.14f, width, base - height * 0.08f)
        
        lineTo(width, base)
        close()
    }
    drawPath(
        path = silhouettePath,
        color = primaryColor.copy(alpha = 0.05f)
    )

    // 3. Draw outer arch frame
    val outlineTop = height * 0.25f
    val outlinePath = androidx.compose.ui.graphics.Path().apply {
        moveTo(0f, height)
        lineTo(0f, outlineTop + height * 0.1f)
        cubicTo(
            0f, outlineTop,
            width, outlineTop,
            width, outlineTop + height * 0.1f
        )
        lineTo(width, height)
    }
    
    drawPath(
        path = outlinePath,
        color = primaryColor.copy(alpha = 0.1f),
        style = Stroke(width = 5f)
    )

    // 4. Draw stars
    val stars = listOf(
        0.1f to 0.15f, 0.88f to 0.10f, 0.18f to 0.42f, 0.85f to 0.38f, 0.12f to 0.65f, 0.78f to 0.75f, 0.5f to 0.08f,
        0.75f to 0.32f, 0.25f to 0.22f, 0.95f to 0.58f, 0.08f to 0.55f
    )
    stars.forEach { (xPct, yPct) ->
        val cx = xPct * width
        val cy = yPct * height
        // Draw elegant glowing cross stars represent celestial Islamic starry theme
        drawCircle(
            color = primaryColor.copy(alpha = 0.08f),
            radius = 16f,
            center = Offset(cx, cy)
        )
        drawLine(
            color = primaryColor.copy(alpha = 0.3f),
            start = Offset(cx - 8f, cy),
            end = Offset(cx + 8f, cy),
            strokeWidth = 1.5f
        )
        drawLine(
            color = primaryColor.copy(alpha = 0.3f),
            start = Offset(cx, cy - 8f),
            end = Offset(cx, cy + 8f),
            strokeWidth = 1.5f
        )
    }
}



fun formatTo12Hour(time24: String): String {
    if (time24 == "--:--" || !time24.contains(":")) return time24
    val parts = time24.split(":")
    if (parts.size < 2) return time24
    val hour = parts[0].toIntOrNull() ?: return time24
    val minute = parts[1].toIntOrNull() ?: return time24
    
    val suffix = if (hour >= 12) "PM" else "AM"
    val displayHour = when {
        hour == 0 -> 12
        hour > 12 -> hour - 12
        else -> hour
    }
    return String.format(java.util.Locale.US, "%02d:%02d %s", displayHour, minute, suffix)
}

@Composable
fun PrayerTimeDisplay(time24: String, isNext: Boolean) {
    val formatted = formatTo12Hour(time24)
    val parts = formatted.split(" ")
    val timeStr = parts.getOrNull(0) ?: time24
    val suffixStr = parts.getOrNull(1) ?: ""
    
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        Text(
            text = timeStr,
            fontSize = if (isNext) 22.sp else 16.sp,
            fontWeight = if (isNext) FontWeight.Black else FontWeight.Medium,
            style = androidx.compose.ui.text.TextStyle(
                brush = Brush.verticalGradient(
                    colors = listOf(Color(0xFFF3DE8E), Color(0xFFB37C3C))
                )
            )
        )
        if (suffixStr.isNotEmpty()) {
            Text(
                text = suffixStr,
                fontSize = if (isNext) 14.sp else 10.sp,
                fontWeight = if (isNext) FontWeight.Black else FontWeight.Medium,
                color = if (isNext) MaterialTheme.colorScheme.secondary else TextMuted
            )
        }
    }
}

fun Modifier.animatedWavingLines(primaryColor: Color) = composed {
    val infiniteTransition = rememberInfiniteTransition(label = "wave")
    val phase by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 2f * Math.PI.toFloat(),
        animationSpec = infiniteRepeatable(
            animation = tween(15000, easing = androidx.compose.animation.core.LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "phase"
    )

    this.drawBehind {
        val width = size.width
        val height = size.height
        val centerY = height * 0.70f
        
        for (i in 0 until 3) {
            val amplitude = 25f + (i * 20f)
            val frequency = 1.5f
            
            val path = androidx.compose.ui.graphics.Path()
            path.moveTo(0f, centerY)
            
            val steps = 50
            for (step in 0..steps) {
                val x = (step.toFloat() / steps) * width
                val angle = (x / width) * (2f * Math.PI.toFloat() * frequency) + phase + (i * 1.5f)
                val y = centerY + kotlin.math.sin(angle).toFloat() * amplitude
                path.lineTo(x, y)
            }
            
            drawPath(
                path = path,
                color = primaryColor.copy(alpha = 0.03f + (i * 0.015f)),
                style = Stroke(width = 3f)
            )
        }
    }
}

@Composable
private fun NavCircleItem(
    selected: Boolean,
    onClick: () -> Unit,
    icon: ImageVector,
    label: String,
    testTag: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = onClick
            )
            .testTag(testTag)
            .padding(horizontal = 10.dp, vertical = 4.dp)
    ) {
        Box(
            modifier = Modifier
                .size(46.dp)
                .clip(CircleShape)
                .background(
                    if (selected) Color(0xFFF3DE8E) else Color(0xFF14261B)
                )
                .border(
                    width = if (selected) 2.dp else 1.dp,
                    color = if (selected) Color(0xFFFFD700) else Color(0xFFF3DE8E).copy(alpha = 0.3f),
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = label,
                tint = if (selected) Color(0xFF0F2618) else Color(0xFFF3DE8E).copy(alpha = 0.85f),
                modifier = Modifier.size(24.dp)
            )
        }
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = label,
            fontWeight = if (selected) FontWeight.Bold else FontWeight.Medium,
            fontSize = 11.sp,
            color = if (selected) Color(0xFFF3DE8E) else Color.White.copy(alpha = 0.65f),
            textAlign = TextAlign.Center
        )
    }
}

