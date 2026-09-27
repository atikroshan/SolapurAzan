package com.example.ui

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Badge
import androidx.compose.material.icons.outlined.LocationOn
import androidx.compose.material.icons.outlined.Mosque
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.data.MasjidItem
import com.example.data.getLocalizedArea
import com.example.data.getLocalizedName

@Composable
fun FirstTimeSetupScreen(
    uiState: UIState,
    onSelectMasjid: (MasjidItem) -> Unit,
    onFinishSetup: (String) -> Unit,
    onBack: (() -> Unit)? = null,
    modifier: Modifier = Modifier
) {
    if (onBack != null) {
        BackHandler { onBack() }
    }

    var searchQuery by remember { mutableStateOf("") }
    var selectedMasjid by remember(uiState.selectedMasjid) { mutableStateOf(uiState.selectedMasjid) }

    val filteredList = remember(searchQuery, uiState.allMasajid, uiState.language) {
        val q = searchQuery.trim().lowercase()
        if (q.isEmpty()) {
            uiState.allMasajid
        } else {
            uiState.allMasajid.filter { m ->
                m.name.lowercase().contains(q) ||
                m.area.lowercase().contains(q) ||
                m.id.lowercase().contains(q) ||
                m.getLocalizedName(uiState.language).lowercase().contains(q) ||
                m.getLocalizedArea(uiState.language).lowercase().contains(q)
            }
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF090E17))
    ) {
        // TOP 50% SECTION: Masjid Photo from Google Link
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.48f)
                .background(Color(0xFF0F172A)),
            contentAlignment = Alignment.Center
        ) {
            if (selectedMasjid.photoUrl.isNotBlank()) {
                AsyncImage(
                    model = selectedMasjid.photoUrl,
                    contentDescription = selectedMasjid.name,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                // Placeholder illustration when photo not yet uploaded to Drive
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            Brush.verticalGradient(
                                listOf(Color(0xFF1E293B), Color(0xFF0F172A))
                            )
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.spacedBy(8.dp)
                    ) {
                        Box(
                            modifier = Modifier
                                .size(70.dp)
                                .background(Color(0xFF166534).copy(alpha = 0.3f), CircleShape)
                                .border(1.5.dp, Color(0xFF86EFAC).copy(alpha = 0.5f), CircleShape),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Mosque,
                                contentDescription = null,
                                tint = Color(0xFFF3DE8E),
                                modifier = Modifier.size(38.dp)
                            )
                        }
                        Text(
                            text = "MASJID PHOTO",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF3DE8E),
                            letterSpacing = 1.sp
                        )
                        Text(
                            text = "Photo from Google Drive link will display here",
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.6f)
                        )
                    }
                }
            }

            // Dark gradient overlay at the bottom of the photo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .background(
                        Brush.verticalGradient(
                            listOf(Color.Transparent, Color(0xFF090E17).copy(alpha = 0.95f))
                        )
                    )
                    .padding(horizontal = 16.dp, vertical = 12.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.Bottom,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        Box(
                            modifier = Modifier
                                .background(Color(0xFF166534), RoundedCornerShape(4.dp))
                                .padding(horizontal = 6.dp, vertical = 2.dp)
                        ) {
                            Text(
                                text = "SETUP • مرحباً",
                                fontSize = 9.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF86EFAC)
                            )
                        }
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = selectedMasjid.getLocalizedName(uiState.language),
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Black,
                            color = Color(0xFFF3DE8E)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .background(Color(0xFF1E293B).copy(alpha = 0.8f), RoundedCornerShape(6.dp))
                            .border(1.dp, Color(0xFFE5A93C).copy(alpha = 0.4f), RoundedCornerShape(6.dp))
                            .padding(horizontal = 8.dp, vertical = 3.dp)
                    ) {
                        Text(
                            text = "#${selectedMasjid.id}",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF3DE8E)
                        )
                    }
                }
            }

            if (onBack != null) {
                IconButton(
                    onClick = onBack,
                    modifier = Modifier
                        .statusBarsPadding()
                        .padding(start = 12.dp, top = 8.dp)
                        .align(Alignment.TopStart)
                        .background(Color.Black.copy(alpha = 0.6f), CircleShape)
                        .size(40.dp)
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = "Back",
                        tint = Color(0xFFF3DE8E),
                        modifier = Modifier.size(20.dp)
                    )
                }
            }
        }

        // BOTTOM 50% SECTION: Search + 3 Fields + Finish Button
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 10.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            // 1. Search Text Field
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = {
                    Text(
                        text = "Search Masjid Name, Address or ID...",
                        fontSize = 12.5.sp,
                        color = Color.White.copy(alpha = 0.45f)
                    )
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search",
                        tint = Color(0xFFF3DE8E),
                        modifier = Modifier.size(20.dp)
                    )
                },
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Clear",
                                tint = Color.White.copy(alpha = 0.6f),
                                modifier = Modifier.size(16.dp)
                            )
                        }
                    }
                },
                singleLine = true,
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,
                    focusedBorderColor = Color(0xFFF3DE8E),
                    unfocusedBorderColor = Color.White.copy(alpha = 0.2f),
                    focusedContainerColor = Color(0xFF131D2E),
                    unfocusedContainerColor = Color(0xFF131D2E)
                ),
                modifier = Modifier.fillMaxWidth()
            )

            // Quick suggestions row when searching or browsing
            if (filteredList.isNotEmpty()) {
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(filteredList, key = { it.id }) { item ->
                        val isSel = item.id == selectedMasjid.id
                        Box(
                            modifier = Modifier
                                .background(
                                    if (isSel) Color(0xFF166534) else Color(0xFF1E293B),
                                    RoundedCornerShape(8.dp)
                                )
                                .border(
                                    1.dp,
                                    if (isSel) Color(0xFF86EFAC) else Color.White.copy(alpha = 0.15f),
                                    RoundedCornerShape(8.dp)
                                )
                                .clickable {
                                    selectedMasjid = item
                                    onSelectMasjid(item)
                                }
                                .padding(horizontal = 10.dp, vertical = 6.dp)
                        ) {
                            Text(
                                text = item.name,
                                fontSize = 11.sp,
                                fontWeight = if (isSel) FontWeight.Bold else FontWeight.Normal,
                                color = if (isSel) Color(0xFF86EFAC) else Color.White
                            )
                        }
                    }
                }
            }

            // 2. Below search: 3 Fields (Masjid Name, Address, ID)
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color(0xFF111827), RoundedCornerShape(14.dp))
                    .border(1.dp, Color(0xFFE5A93C).copy(alpha = 0.3f), RoundedCornerShape(14.dp))
                    .padding(12.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                // Field 1: Masjid Name
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .background(Color(0xFF1E293B), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Mosque,
                            contentDescription = null,
                            tint = Color(0xFFF3DE8E),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "MASJID NAME",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFF3DE8E),
                            letterSpacing = 0.8.sp
                        )
                        Text(
                            text = selectedMasjid.name,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                HorizontalDivider(color = Color.White.copy(alpha = 0.08f))

                // Field 2: Address
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .background(Color(0xFF1E293B), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.LocationOn,
                            contentDescription = null,
                            tint = Color(0xFFE5A93C),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "ADDRESS",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFFE5A93C),
                            letterSpacing = 0.8.sp
                        )
                        Text(
                            text = "${selectedMasjid.area}, ${selectedMasjid.city}",
                            fontSize = 13.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White.copy(alpha = 0.9f),
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }
                }

                HorizontalDivider(color = Color.White.copy(alpha = 0.08f))

                // Field 3: ID
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Box(
                        modifier = Modifier
                            .size(34.dp)
                            .background(Color(0xFF1E293B), CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.Badge,
                            contentDescription = null,
                            tint = Color(0xFF86EFAC),
                            modifier = Modifier.size(18.dp)
                        )
                    }
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "MASJID ID",
                            fontSize = 9.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color(0xFF86EFAC),
                            letterSpacing = 0.8.sp
                        )
                        Text(
                            text = selectedMasjid.id,
                            fontSize = 13.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White.copy(alpha = 0.9f)
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(4.dp))

            // 3. Below that: FINISH in GREEN BUTTON
            Button(
                onClick = { onFinishSetup(selectedMasjid.id) },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF22C55E), // Green Button
                    contentColor = Color(0xFF052E16)
                ),
                shape = RoundedCornerShape(14.dp),
                elevation = ButtonDefaults.buttonElevation(defaultElevation = 4.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(52.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Check,
                        contentDescription = "Finish",
                        tint = Color(0xFF052E16),
                        modifier = Modifier.size(22.dp)
                    )
                    Text(
                        text = "FINISH",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Black,
                        letterSpacing = 1.sp
                    )
                }
            }
        }
    }
}
