package com.example.ui;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.BorderStrokeKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.KeyboardArrowDownKt;
import androidx.compose.material.icons.filled.KeyboardArrowUpKt;
import androidx.compose.material3.CardColors;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardElevation;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateMap;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.window.AndroidDialog_androidKt;
import androidx.compose.ui.window.DialogProperties;
import com.example.BuildConfig;
import com.example.MainActivityKt;
import com.example.data.AzanTiming;
import com.example.data.PrayerLog;
import com.example.ui.theme.AppStrings;
import com.example.ui.theme.StringsKt;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* compiled from: TrackerBoard.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0002\b\u0003\u001a\u000e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003\u001a \u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u001a\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\b\u001as\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0018\u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u00112\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u00132 \b\u0002\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a9\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0004\b\"\u0010#\u001a\u0015\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010&\u001aG\u0010'\u001a\u00020\r2\u0006\u0010(\u001a\u00020)2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0018\u0010*\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u00112\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010+\u001a/\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u00032\u0006\u00100\u001a\u00020\u001fH\u0007¢\u0006\u0004\b1\u00102\u001a'\u00103\u001a\u00020\r2\n\u00104\u001a\u00060\u0001j\u0002`52\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u0018H\u0007¢\u0006\u0002\u00106\u001a\u0017\u00107\u001a\u00020\r2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u00108\u001au\u00109\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\n\u0010:\u001a\u00060\u0001j\u0002`52\b\b\u0002\u0010;\u001a\u00020<2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u001e\u0010\u0015\u001a\u001a\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u00162\u0018\u0010>\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\r0\u0011H\u0007¢\u0006\u0002\u0010?\u001aW\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u00142\u0006\u0010B\u001a\u00020\u00142\b\u0010C\u001a\u0004\u0018\u00010\t2\u0006\u0010D\u001a\u00020\u001f2\u0006\u0010E\u001a\u00020<2\b\u0010F\u001a\u0004\u0018\u00010G2\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r0\u0013H\u0007¢\u0006\u0004\bH\u0010I\u001a \u0010J\u001a\u00020<2\u0006\u0010E\u001a\u00020<2\u0006\u0010K\u001a\u00020\u00142\b\u0010F\u001a\u0004\u0018\u00010G\u001a\u000e\u0010L\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u0003*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006M²\u0006\u0018\u0010N\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u00020<X\u008a\u008e\u0002²\u0006\n\u0010O\u001a\u00020<X\u008a\u008e\u0002²\u0006\n\u0010P\u001a\u00020<X\u008a\u008e\u0002²\u0006\n\u0010Q\u001a\u00020RX\u008a\u0084\u0002²\u0006\n\u0010S\u001a\u00020\u0014X\u008a\u008e\u0002²\u0006\n\u0010T\u001a\u00020\u0003X\u008a\u008e\u0002²\u0006\n\u0010U\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"TrackerStrings", "Lcom/example/ui/theme/AppStrings;", "getMaxDaysOfMonth", "", "month", "calculateStreaks", "Lkotlin/Pair;", "allLogs", "", "Lcom/example/data/PrayerLog;", "getRamazan2027Schedule", "Lcom/example/ui/RamazanSchedule;", "TrackerBoardDialog", "", "uiState", "Lcom/example/ui/UIState;", "onDateSelected", "Lkotlin/Function2;", "onLanguageSelect", "Lkotlin/Function1;", "", "onTogglePrayer", "Lkotlin/Function3;", "onDismiss", "Lkotlin/Function0;", "(Lcom/example/ui/UIState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "StatCard", "title", "value", "subtitle", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "StatCard-uDo3WH8", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "getPointColor", "count", "(ILandroidx/compose/runtime/Composer;I)J", "BigCalendarCard", "selectedDate", "Ljava/util/Calendar;", "onDateClick", "(Ljava/util/Calendar;Ljava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PrayerTableRow", "name", "completed", "missed", "accentColor", "PrayerTableRow-Bx497Mc", "(Ljava/lang/String;IIJLandroidx/compose/runtime/Composer;I)V", "ZakatCalculatorDialog", "strings", "Lcom/example/ui/TrackerStrings;", "(Lcom/example/ui/theme/AppStrings;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "GoldenPotliIcon", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "MonthPointHistoryCalendar", "curStrings", "isCalendarExpanded", "", "onToggleCalendar", "onSelectDay", "(Lcom/example/ui/UIState;Lcom/example/ui/theme/AppStrings;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "DayPrayerEditorCard", "label", "dateString", "log", "badgeColor", "isToday", "todayTimings", "Lcom/example/data/AzanTiming;", "DayPrayerEditorCard-fWhpE4E", "(Ljava/lang/String;Ljava/lang/String;Lcom/example/data/PrayerLog;JZLcom/example/data/AzanTiming;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "isPrayerTimeArrived", "prayerName", "getMonthShort", "app", "selectedDayInfo", "isRamazanExpanded", "showZakatPopup", "scale", "", "netWealth", "displayMonth", "displayYear"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class TrackerBoardKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BigCalendarCard$lambda$116(Calendar calendar, List list, Function2 function2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        BigCalendarCard(calendar, list, function2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DayPrayerEditorCard_fWhpE4E$lambda$202(String str, String str2, PrayerLog prayerLog, long j, boolean z, AzanTiming azanTiming, Function1 function1, int i, Composer composer, int i2) {
        m5DayPrayerEditorCardfWhpE4E(str, str2, prayerLog, j, z, azanTiming, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit GoldenPotliIcon$lambda$139(Modifier modifier, int i, int i2, Composer composer, int i3) {
        GoldenPotliIcon(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MonthPointHistoryCalendar$lambda$191(UIState uIState, AppStrings appStrings, boolean z, Function0 function0, Function3 function3, Function2 function2, int i, int i2, Composer composer, int i3) {
        MonthPointHistoryCalendar(uIState, appStrings, z, function0, function3, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrayerTableRow_Bx497Mc$lambda$118(String str, int i, int i2, long j, int i3, Composer composer, int i4) {
        m6PrayerTableRowBx497Mc(str, i, i2, j, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StatCard_uDo3WH8$lambda$97(String str, String str2, String str3, long j, Modifier modifier, int i, int i2, Composer composer, int i3) {
        m7StatCarduDo3WH8(str, str2, str3, j, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$94(UIState uIState, Function2 function2, Function1 function1, Function3 function3, Function0 function0, int i, int i2, Composer composer, int i3) {
        TrackerBoardDialog(uIState, function2, function1, function3, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ZakatCalculatorDialog$lambda$134(AppStrings appStrings, Function0 function0, int i, Composer composer, int i2) {
        ZakatCalculatorDialog(appStrings, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final int getMaxDaysOfMonth(int month) {
        switch (month) {
            case 1:
                return 31;
            case 2:
                return 28;
            case BuildConfig.VERSION_CODE /* 3 */:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
            default:
                return 30;
            case 5:
                return 31;
            case 7:
                return 31;
            case 8:
                return 31;
            case 10:
                return 31;
            case 12:
                return 31;
        }
    }

    public static final Pair<Integer, Integer> calculateStreaks(List<PrayerLog> list) {
        int d;
        Intrinsics.checkNotNullParameter(list, "allLogs");
        Collection arrayList = new ArrayList();
        for (Object obj : list) {
            if (((PrayerLog) obj).isPerfectDay()) {
                arrayList.add(obj);
            }
        }
        Iterable<PrayerLog> iterable = (List) arrayList;
        Collection arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (PrayerLog prayerLog : iterable) {
            arrayList2.add(prayerLog.getMonth() + "-" + prayerLog.getDay());
        }
        Set perfectDays = CollectionsKt.toSet((List) arrayList2);
        int longest = 0;
        int currentCount = 0;
        for (int m = 1; m < 13; m++) {
            int maxDays = getMaxDaysOfMonth(m);
            if (1 <= maxDays) {
                while (true) {
                    String key = m + "-" + d;
                    if (perfectDays.contains(key)) {
                        currentCount++;
                        if (currentCount > longest) {
                            longest = currentCount;
                        }
                    } else {
                        currentCount = 0;
                    }
                    d = d != maxDays ? d + 1 : 1;
                }
            }
        }
        int currentStreak = 0;
        Calendar tracker = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
        boolean isChecking = true;
        int daysBack = 0;
        while (isChecking && daysBack < 366) {
            int m2 = tracker.get(2) + 1;
            String key2 = m2 + "-" + tracker.get(5);
            if (perfectDays.contains(key2)) {
                currentStreak++;
                tracker.add(6, -1);
                daysBack++;
            } else if (daysBack == 0) {
                tracker.add(6, -1);
                daysBack++;
            } else {
                isChecking = false;
            }
        }
        return new Pair<>(Integer.valueOf(currentStreak), Integer.valueOf(longest));
    }

    public static final List<RamazanSchedule> getRamazan2027Schedule() {
        String str;
        boolean z;
        List list = new ArrayList();
        Calendar startCal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
        int i = 1;
        startCal.set(1, 2027);
        startCal.set(2, 1);
        startCal.set(5, 9);
        startCal.set(11, 0);
        startCal.set(12, 0);
        startCal.set(13, 0);
        startCal.set(14, 0);
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyyy", Locale.ENGLISH);
        SimpleDateFormat dayFormat = new SimpleDateFormat("EEEE", Locale.ENGLISH);
        int i2 = 0;
        while (i2 < 30) {
            Object clone = startCal.clone();
            Intrinsics.checkNotNull(clone, "null cannot be cast to non-null type java.util.Calendar");
            Calendar currentCal = (Calendar) clone;
            currentCal.add(6, i2);
            int sMin = 30 - (i2 / 2);
            int iMin = (i2 / 3) + 25;
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String seharStr = String.format(Locale.US, "05:%02d AM", Arrays.copyOf(new Object[]{Integer.valueOf(sMin)}, i));
            Intrinsics.checkNotNullExpressionValue(seharStr, "format(...)");
            StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
            String iftarStr = String.format(Locale.US, "06:%02d PM", Arrays.copyOf(new Object[]{Integer.valueOf(iMin)}, i));
            Intrinsics.checkNotNullExpressionValue(iftarStr, "format(...)");
            String format = dateFormat.format(currentCal.getTime());
            Intrinsics.checkNotNullExpressionValue(format, "format(...)");
            String format2 = dayFormat.format(currentCal.getTime());
            Intrinsics.checkNotNullExpressionValue(format2, "format(...)");
            if (currentCal.get(7) == 6) {
                str = format;
                z = true;
            } else {
                str = format;
                z = false;
            }
            list.add(new RamazanSchedule(i2, currentCal, str, format2, z, seharStr, iftarStr));
            i2++;
            i = 1;
        }
        return list;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$4$lambda$3(int i, int i2, String str) {
        Intrinsics.checkNotNullParameter(str, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final void TrackerBoardDialog(final UIState uiState, final Function2<? super Integer, ? super Integer, Unit> function2, final Function1<? super String, Unit> function1, Function3<? super Integer, ? super Integer, ? super String, Unit> function3, final Function0<Unit> function0, Composer $composer, final int $changed, final int i) {
        Function3 function32;
        final Function3 onTogglePrayer;
        Object obj;
        AppStrings curStrings;
        int i2;
        Object valueOf;
        Object valueOf2;
        Object calculateStreaks;
        final Function3 onTogglePrayer2;
        Object obj2;
        Intrinsics.checkNotNullParameter(uiState, "uiState");
        Intrinsics.checkNotNullParameter(function2, "onDateSelected");
        Intrinsics.checkNotNullParameter(function1, "onLanguageSelect");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer2 = $composer.startRestartGroup(-1026941744);
        ComposerKt.sourceInformation($composer2, "C(TrackerBoardDialog)P(4!1,2,3)176@6023L14,179@6096L50,187@6380L73,188@6476L85,189@6580L63,198@6925L38755,193@6753L38927:TrackerBoard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changedInstance(uiState) ? 4 : 2;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changedInstance(function1) ? 256 : 128;
        }
        int i3 = i & 8;
        if (i3 != 0) {
            $dirty |= 3072;
            function32 = function3;
        } else if (($changed & 3072) == 0) {
            function32 = function3;
            $dirty |= $composer2.changedInstance(function32) ? 2048 : 1024;
        } else {
            function32 = function3;
        }
        if (($changed & 24576) == 0) {
            $dirty |= $composer2.changedInstance(function0) ? 16384 : 8192;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 9347) == 9346 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            onTogglePrayer2 = function32;
        } else {
            if (i3 != 0) {
                ComposerKt.sourceInformationMarkerStart($composer2, 951468094, "CC(remember):TrackerBoard.kt#9igjgp");
                Object rememberedValue = $composer2.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    obj2 = new Function3() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda0
                        public final Object invoke(Object obj3, Object obj4, Object obj5) {
                            return TrackerBoardKt.TrackerBoardDialog$lambda$4$lambda$3(((Integer) obj3).intValue(), ((Integer) obj4).intValue(), (String) obj5);
                        }
                    };
                    $composer2.updateRememberedValue(obj2);
                } else {
                    obj2 = rememberedValue;
                }
                onTogglePrayer = (Function3) obj2;
                ComposerKt.sourceInformationMarkerEnd($composer2);
            } else {
                onTogglePrayer = function32;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1026941744, $dirty2, -1, "com.example.ui.TrackerBoardDialog (TrackerBoard.kt:178)");
            }
            ComposerKt.sourceInformationMarkerStart($composer2, 951470466, "CC(remember):TrackerBoard.kt#9igjgp");
            Object rememberedValue2 = $composer2.rememberedValue();
            if (rememberedValue2 == Composer.Companion.getEmpty()) {
                obj = SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer2.updateRememberedValue(obj);
            } else {
                obj = rememberedValue2;
            }
            final MutableState selectedDayInfo$delegate = (MutableState) obj;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            String language = uiState.getLanguage();
            AppStrings curStrings2 = Intrinsics.areEqual(language, "hi") ? StringsKt.getHindiStrings() : Intrinsics.areEqual(language, "ur") ? StringsKt.getUrduStrings() : StringsKt.getEnglishStrings();
            List<PrayerLog> allLogs = uiState.getAllLogs();
            ComposerKt.sourceInformationMarkerStart($composer2, 951479577, "CC(remember):TrackerBoard.kt#9igjgp");
            boolean changed = $composer2.changed(allLogs);
            Object rememberedValue3 = $composer2.rememberedValue();
            if (changed || rememberedValue3 == Composer.Companion.getEmpty()) {
                curStrings = curStrings2;
                Iterable allLogs2 = uiState.getAllLogs();
                if ((allLogs2 instanceof Collection) && ((Collection) allLogs2).isEmpty()) {
                    i2 = 0;
                } else {
                    i2 = 0;
                    Iterator it = allLogs2.iterator();
                    while (it.hasNext()) {
                        if (((PrayerLog) it.next()).isPerfectDay() && (i2 = i2 + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                }
                valueOf = Integer.valueOf(i2);
                $composer2.updateRememberedValue(valueOf);
            } else {
                curStrings = curStrings2;
                valueOf = rememberedValue3;
            }
            final int totalPerfectDays = ((Number) valueOf).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            List<PrayerLog> allLogs3 = uiState.getAllLogs();
            ComposerKt.sourceInformationMarkerStart($composer2, 951482661, "CC(remember):TrackerBoard.kt#9igjgp");
            boolean changed2 = $composer2.changed(allLogs3);
            Object rememberedValue4 = $composer2.rememberedValue();
            if (changed2 || rememberedValue4 == Composer.Companion.getEmpty()) {
                Iterator<T> it2 = uiState.getAllLogs().iterator();
                int i4 = 0;
                while (it2.hasNext()) {
                    i4 += ((PrayerLog) it2.next()).getCompletedPrayersCount();
                }
                valueOf2 = Integer.valueOf(i4);
                $composer2.updateRememberedValue(valueOf2);
            } else {
                valueOf2 = rememberedValue4;
            }
            final int totalPoints = ((Number) valueOf2).intValue();
            ComposerKt.sourceInformationMarkerEnd($composer2);
            List<PrayerLog> allLogs4 = uiState.getAllLogs();
            ComposerKt.sourceInformationMarkerStart($composer2, 951485967, "CC(remember):TrackerBoard.kt#9igjgp");
            boolean changed3 = $composer2.changed(allLogs4);
            Object rememberedValue5 = $composer2.rememberedValue();
            if (changed3 || rememberedValue5 == Composer.Companion.getEmpty()) {
                calculateStreaks = calculateStreaks(uiState.getAllLogs());
                $composer2.updateRememberedValue(calculateStreaks);
            } else {
                calculateStreaks = rememberedValue5;
            }
            Pair streaks = (Pair) calculateStreaks;
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final int currentStreak = ((Number) streaks.getFirst()).intValue();
            final int longestStreak = ((Number) streaks.getSecond()).intValue();
            final AppStrings curStrings3 = curStrings;
            Function3 onTogglePrayer3 = onTogglePrayer;
            AndroidDialog_androidKt.Dialog(function0, new DialogProperties(false, false, false, 3, (DefaultConstructorMarker) null), ComposableLambdaKt.rememberComposableLambda(-1495944153, true, new Function2() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj3, Object obj4) {
                    return TrackerBoardKt.TrackerBoardDialog$lambda$93(curStrings3, uiState, function1, function0, onTogglePrayer, totalPoints, totalPerfectDays, currentStreak, longestStreak, selectedDayInfo$delegate, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, $composer2, 54), $composer2, (($dirty2 >> 12) & 14) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            onTogglePrayer2 = onTogglePrayer3;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda22
                public final Object invoke(Object obj3, Object obj4) {
                    return TrackerBoardKt.TrackerBoardDialog$lambda$94(UIState.this, function2, function1, onTogglePrayer2, function0, $changed, i, (Composer) obj3, ((Integer) obj4).intValue());
                }
            });
        }
    }

    private static final Pair<Integer, Integer> TrackerBoardDialog$lambda$6(MutableState<Pair<Integer, Integer>> mutableState) {
        return (Pair) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93(final AppStrings $curStrings, final UIState $uiState, final Function1 $onLanguageSelect, final Function0 $onDismiss, final Function3 $onTogglePrayer, final int $totalPoints, final int $totalPerfectDays, final int $currentStreak, final int $longestStreak, final MutableState $selectedDayInfo$delegate, Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        Object obj3;
        final MutableState mutableState;
        ComposerKt.sourceInformation($composer, "C199@7018L27713,199@6935L27796:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1495944153, $changed, -1, "com.example.ui.TrackerBoardDialog.<anonymous> (TrackerBoard.kt:199)");
            }
            CompositionLocalKt.CompositionLocalProvider(StringsKt.getLocalAppStrings().provides($curStrings), ComposableLambdaKt.rememberComposableLambda(827947239, true, new Function2() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda12
                public final Object invoke(Object obj4, Object obj5) {
                    return TrackerBoardKt.TrackerBoardDialog$lambda$93$lambda$70(UIState.this, $onLanguageSelect, $onDismiss, $curStrings, $onTogglePrayer, $totalPoints, $totalPerfectDays, $currentStreak, $longestStreak, $selectedDayInfo$delegate, (Composer) obj4, ((Integer) obj5).intValue());
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            Pair<Integer, Integer> TrackerBoardDialog$lambda$6 = TrackerBoardDialog$lambda$6($selectedDayInfo$delegate);
            if (TrackerBoardDialog$lambda$6 == null) {
                $composer.startReplaceGroup(-1063653714);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-1063653713);
                ComposerKt.sourceInformation($composer, "*661@34916L7,662@34947L81,665@35173L141,675@35762L26,675@35790L9882,675@35736L9936");
                final int intValue = ((Number) TrackerBoardDialog$lambda$6.component1()).intValue();
                final int intValue2 = ((Number) TrackerBoardDialog$lambda$6.component2()).intValue();
                Iterator<T> it = $uiState.getAllLogs().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    PrayerLog prayerLog = (PrayerLog) obj;
                    if (((prayerLog.getMonth() == intValue && prayerLog.getDay() == intValue2) ? 1 : null) != null) {
                        break;
                    }
                }
                final PrayerLog prayerLog2 = (PrayerLog) obj;
                CompositionLocal localAppStrings = StringsKt.getLocalAppStrings();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(localAppStrings);
                ComposerKt.sourceInformationMarkerEnd($composer);
                final AppStrings appStrings = (AppStrings) consume;
                ComposerKt.sourceInformationMarkerStart($composer, 1426478691, "CC(remember):TrackerBoard.kt#9igjgp");
                Object rememberedValue = $composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    obj2 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
                    $composer.updateRememberedValue(obj2);
                } else {
                    obj2 = rememberedValue;
                }
                Calendar calendar = (Calendar) obj2;
                ComposerKt.sourceInformationMarkerEnd($composer);
                int i = calendar.get(2) + 1;
                int i2 = calendar.get(5);
                ComposerKt.sourceInformationMarkerStart($composer, 1426485983, "CC(remember):TrackerBoard.kt#9igjgp");
                Object rememberedValue2 = $composer.rememberedValue();
                if (rememberedValue2 == Composer.Companion.getEmpty()) {
                    Calendar calendar2 = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
                    calendar2.add(6, -1);
                    obj3 = calendar2;
                    $composer.updateRememberedValue(obj3);
                } else {
                    obj3 = rememberedValue2;
                }
                Calendar calendar3 = (Calendar) obj3;
                ComposerKt.sourceInformationMarkerEnd($composer);
                int i3 = calendar3.get(2) + 1;
                int i4 = calendar3.get(5);
                final boolean z = intValue == i && intValue2 == i2;
                boolean z2 = intValue == i3 && intValue2 == i4;
                boolean z3 = z || z2;
                final int completedPrayersCount = prayerLog2 != null ? prayerLog2.getCompletedPrayersCount() : 0;
                ComposerKt.sourceInformationMarkerStart($composer, 1426504716, "CC(remember):TrackerBoard.kt#9igjgp");
                Object rememberedValue3 = $composer.rememberedValue();
                if (rememberedValue3 == Composer.Companion.getEmpty()) {
                    mutableState = $selectedDayInfo$delegate;
                    rememberedValue3 = new Function0() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda13
                        public final Object invoke() {
                            return TrackerBoardKt.TrackerBoardDialog$lambda$93$lambda$92$lambda$76$lambda$75(mutableState);
                        }
                    };
                    $composer.updateRememberedValue(rememberedValue3);
                } else {
                    mutableState = $selectedDayInfo$delegate;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                final boolean z4 = z2;
                final boolean z5 = z3;
                final MutableState mutableState2 = mutableState;
                AndroidDialog_androidKt.Dialog((Function0) rememberedValue3, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(-204999365, true, new Function2() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda14
                    public final Object invoke(Object obj4, Object obj5) {
                        return TrackerBoardKt.TrackerBoardDialog$lambda$93$lambda$92$lambda$91(z5, appStrings, prayerLog2, intValue2, intValue, z, z4, mutableState2, $uiState, $onTogglePrayer, completedPrayersCount, (Composer) obj4, ((Integer) obj5).intValue());
                    }
                }, $composer, 54), $composer, 390, 2);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$70(final UIState $uiState, final Function1 $onLanguageSelect, final Function0 $onDismiss, final AppStrings $curStrings, final Function3 $onTogglePrayer, final int $totalPoints, final int $totalPerfectDays, final int $currentStreak, final int $longestStreak, final MutableState $selectedDayInfo$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C203@7121L15,207@7264L27461,200@7032L27693:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(827947239, $changed, -1, "com.example.ui.TrackerBoardDialog.<anonymous>.<anonymous> (TrackerBoard.kt:200)");
            }
            SurfaceKt.Surface-T9BRK9s(WindowInsetsPadding_androidKt.navigationBarsPadding(WindowInsetsPadding_androidKt.statusBarsPadding(MainActivityKt.appBackground(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), $composer, 6))), (Shape) null, Color.Companion.getTransparent-0d7_KjU(), 0L, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(865818498, true, new Function2() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda33
                public final Object invoke(Object obj, Object obj2) {
                    return TrackerBoardKt.TrackerBoardDialog$lambda$93$lambda$70$lambda$69(UIState.this, $onLanguageSelect, $onDismiss, $curStrings, $onTogglePrayer, $totalPoints, $totalPerfectDays, $currentStreak, $longestStreak, $selectedDayInfo$delegate, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer, 54), $composer, 12583296, 122);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0cf2  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0d25  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0d74  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0dc0  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0df1  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x0e4c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0e77  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0ebf  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0f8d  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0fe1  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x103e  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x106a  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x1114  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x11b9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x1205  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x12ef  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x1244  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x11c7  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x112d  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x1040  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x0ff7  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0fa5  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0f75  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0e57  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0e27  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0dd0  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0d87  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0d35  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0d00  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0cc4  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0b2e  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0ae7  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0994 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:237:0x094f  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0780  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0744  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x06ef  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x065b  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x05f1  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x05ba  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0554 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x039b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04f9  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0505  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x053e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05b3  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x05eb  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0658  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x06e8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0779  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x093f  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x094b  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x097e  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0ad5  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0ae1  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0b18  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0cab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69(com.example.ui.UIState r164, kotlin.jvm.functions.Function1 r165, kotlin.jvm.functions.Function0 r166, final com.example.ui.theme.AppStrings r167, kotlin.jvm.functions.Function3 r168, int r169, int r170, int r171, int r172, final androidx.compose.runtime.MutableState r173, androidx.compose.runtime.Composer r174, int r175) {
        /*
            Method dump skipped, instructions count: 4853
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.TrackerBoardDialog$lambda$93$lambda$70$lambda$69(com.example.ui.UIState, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, com.example.ui.theme.AppStrings, kotlin.jvm.functions.Function3, int, int, int, int, androidx.compose.runtime.MutableState, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$16$lambda$15$lambda$13(AppStrings $curStrings, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C240@8980L11,237@8784L310:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1396749899, $changed, -1, "com.example.ui.TrackerBoardDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TrackerBoard.kt:237)");
            }
            IconKt.Icon-ww6aTOc(CloseKt.getClose(Icons.Filled.INSTANCE), $curStrings.getClose(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), $composer, 384, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$19(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$20(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$22$lambda$21(MutableState $isCalendarExpanded$delegate) {
        TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$20($isCalendarExpanded$delegate, !TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$19($isCalendarExpanded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$24$lambda$23(MutableState $selectedDayInfo$delegate, int month, int day) {
        $selectedDayInfo$delegate.setValue(new Pair(Integer.valueOf(month), Integer.valueOf(day)));
        return Unit.INSTANCE;
    }

    private static final boolean TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$26(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$27(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:111:0x08e4  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x08f0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0a13  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0a1f  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0a58  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0af0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0c6b  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0c77  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0cb0  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0e15  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x0e21  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0e5a  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0f76  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0e70  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0e27  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0cc6 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0c7d  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0b72  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0a6e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0a25  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x08f6  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x1067  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0591  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x1098  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x05fb  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$58(boolean r195, java.util.List r196, final androidx.compose.runtime.MutableState r197, final com.example.ui.theme.AppStrings r198, final int r199, final int r200, java.util.Calendar r201, final androidx.compose.runtime.snapshots.SnapshotStateMap r202, final android.content.Context r203, final android.content.SharedPreferences r204, androidx.compose.foundation.layout.ColumnScope r205, androidx.compose.runtime.Composer r206, int r207) {
        /*
            Method dump skipped, instructions count: 4254
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$58(boolean, java.util.List, androidx.compose.runtime.MutableState, com.example.ui.theme.AppStrings, int, int, java.util.Calendar, androidx.compose.runtime.snapshots.SnapshotStateMap, android.content.Context, android.content.SharedPreferences, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$58$lambda$57$lambda$39$lambda$38(MutableState $isRamazanExpanded$delegate) {
        TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$27($isRamazanExpanded$delegate, !TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$26($isRamazanExpanded$delegate));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01d6  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0557  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0563  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x059a  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0611  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x06b8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0677  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x05b0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0569  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x034a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$58$lambda$57$lambda$56$lambda$45(int r110, com.example.ui.theme.AppStrings r111, int r112, androidx.compose.foundation.layout.ColumnScope r113, androidx.compose.runtime.Composer r114, int r115) {
        /*
            Method dump skipped, instructions count: 1726
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$58$lambda$57$lambda$56$lambda$45(int, com.example.ui.theme.AppStrings, int, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$58$lambda$57$lambda$56$lambda$55$lambda$54$lambda$51$lambda$50(boolean $isDayEnabled, Context $context, AppStrings $curStrings, int $currentState, SnapshotStateMap $rojaStates, RamazanSchedule $day, SharedPreferences $prefs) {
        int nextState = 0;
        if (!$isDayEnabled) {
            Toast.makeText($context, $curStrings.getCannotTickBeforeDateToast(), 0).show();
        } else {
            switch ($currentState) {
                case 0:
                    nextState = 1;
                    break;
                case 1:
                    nextState = 2;
                    break;
            }
            ((Map) $rojaStates).put(Integer.valueOf($day.getId()), Integer.valueOf(nextState));
            $prefs.edit().putInt("roja_state_" + $day.getId(), nextState).apply();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$58$lambda$57$lambda$56$lambda$55$lambda$54$lambda$53(int $currentState, AppStrings $curStrings, boolean $isDayEnabled, Composer $composer, int $changed) {
        int i;
        ComposerKt.sourceInformation($composer, "C:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(392399933, $changed, -1, "com.example.ui.TrackerBoardDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TrackerBoard.kt:574)");
            }
            switch ($currentState) {
                case 1:
                    $composer.startReplaceGroup(-914427806);
                    ComposerKt.sourceInformation($composer, "577@30180L453");
                    IconKt.Icon-ww6aTOc(CheckCircleKt.getCheckCircle(Icons.Filled.INSTANCE), $curStrings.getRozaCompletedLabel(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), ColorKt.Color(4280669030L), $composer, 3456, 0);
                    $composer.endReplaceGroup();
                    break;
                case 2:
                    $composer.startReplaceGroup(-913710931);
                    ComposerKt.sourceInformation($composer, "586@30887L1140");
                    Modifier modifier = BorderKt.border-xT4_qwU(BackgroundKt.background-bw27NRU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(20)), Color.copy-wmQWz5c$default(ColorKt.Color(4293212469L), 0.2f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.getCircleShape()), Dp.constructor-impl((float) 1.5d), ColorKt.Color(4293212469L), RoundedCornerShapeKt.getCircleShape());
                    Alignment center = Alignment.Companion.getCenter();
                    ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                    CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
                    Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
                    Function0 constructor = ComposeUiNode.Companion.getConstructor();
                    int i2 = ((((48 << 3) & 112) << 6) & 896) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!($composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    $composer.startReusableNode();
                    if ($composer.getInserting()) {
                        $composer.createNode(constructor);
                    } else {
                        $composer.useNode();
                    }
                    Composer composer = Updater.constructor-impl($composer);
                    Updater.set-impl(composer, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                    Updater.set-impl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                    Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                    if (!composer.getInserting()) {
                        i = i2;
                        if (Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                            Updater.set-impl(composer, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                            int i3 = (i >> 6) & 14;
                            ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                            BoxScope boxScope = BoxScopeInstance.INSTANCE;
                            int i4 = ((48 >> 6) & 112) | 6;
                            ComposerKt.sourceInformationMarkerStart($composer, 983009661, "C593@31505L464:TrackerBoard.kt#naom5h");
                            IconKt.Icon-ww6aTOc(CloseKt.getClose(Icons.Filled.INSTANCE), $curStrings.getRozaMissedLabel(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(13)), ColorKt.Color(4293212469L), $composer, 3456, 0);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endNode();
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            ComposerKt.sourceInformationMarkerEnd($composer);
                            $composer.endReplaceGroup();
                            break;
                        }
                    } else {
                        i = i2;
                    }
                    composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    Updater.set-impl(composer, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                    int i32 = (i >> 6) & 14;
                    ComposerKt.sourceInformationMarkerStart($composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                    int i42 = ((48 >> 6) & 112) | 6;
                    ComposerKt.sourceInformationMarkerStart($composer, 983009661, "C593@31505L464:TrackerBoard.kt#naom5h");
                    IconKt.Icon-ww6aTOc(CloseKt.getClose(Icons.Filled.INSTANCE), $curStrings.getRozaMissedLabel(), SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(13)), ColorKt.Color(4293212469L), $composer, 3456, 0);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    ComposerKt.sourceInformationMarkerEnd($composer);
                    $composer.endReplaceGroup();
                default:
                    $composer.startReplaceGroup(-912339987);
                    ComposerKt.sourceInformation($composer, "603@32274L670");
                    BoxKt.Box(BorderKt.border-xT4_qwU(SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), Dp.constructor-impl((float) 1.5d), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), $isDayEnabled ? 0.45f : 0.18f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.getCircleShape()), $composer, 0);
                    $composer.endReplaceGroup();
                    break;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final boolean TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$60(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$61(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$63$lambda$62(MutableState $showZakatPopup$delegate) {
        TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$61($showZakatPopup$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$64(AppStrings $curStrings, RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C635@33952L17,636@33990L39,637@34050L120:TrackerBoard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(664955343, $changed, -1, "com.example.ui.TrackerBoardDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TrackerBoard.kt:635)");
            }
            GoldenPotliIcon(null, $composer, 0, 1);
            SpacerKt.Spacer(SizeKt.width-3ABfNKs(Modifier.Companion, Dp.constructor-impl(8)), $composer, 6);
            TextKt.Text--4IGK_g($curStrings.getZakatCalcBtn(), (Modifier) null, Color.Companion.getWhite-0d7_KjU(), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, TextUnitKt.getSp(1), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 12782976, 0, 130898);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$66$lambda$65(MutableState $showZakatPopup$delegate) {
        TrackerBoardDialog$lambda$93$lambda$70$lambda$69$lambda$68$lambda$67$lambda$61($showZakatPopup$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$92$lambda$76$lambda$75(MutableState $selectedDayInfo$delegate) {
        $selectedDayInfo$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$92$lambda$91(final boolean $isEditable, final AppStrings $appStrings, final PrayerLog $log, final int $day, final int $month, final boolean $isToday, final boolean $isYesterday, final MutableState $selectedDayInfo$delegate, final UIState $uiState, final Function3 $onTogglePrayer, final int $totalCompleted, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C679@35966L46,681@36130L9532,676@35804L9858:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-204999365, $changed, -1, "com.example.ui.TrackerBoardDialog.<anonymous>.<anonymous>.<anonymous> (TrackerBoard.kt:676)");
            }
            CardKt.Card(PaddingKt.padding-3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(16)), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), CardDefaults.INSTANCE.cardColors-ro_MJ88(ColorKt.Color(4279178530L), 0L, 0L, 0L, $composer, (CardDefaults.$stable << 12) | 6, 14), (CardElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl(1), ColorKt.Color($isEditable ? 4293571336L : 4280232253L)), ComposableLambdaKt.rememberComposableLambda(-1628303607, true, new Function3() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda38
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TrackerBoardKt.TrackerBoardDialog$lambda$93$lambda$92$lambda$91$lambda$90($appStrings, $log, $isEditable, $day, $month, $isToday, $isYesterday, $selectedDayInfo$delegate, $uiState, $onTogglePrayer, $totalCompleted, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 196614, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0a41  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x09d8  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x091e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:106:0x08da  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0828  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x07fd  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x07d2  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x07a7  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x076a  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x06d3  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0654  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x05af  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0477 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x034d A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0237  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x02fe  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x041c  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0428  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0461  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x064f  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0662  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x06c5  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0760  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x07a1  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x07cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x07f7  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0822  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x08ca  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x08d6  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0908  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x09cc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit TrackerBoardDialog$lambda$93$lambda$92$lambda$91$lambda$90(final com.example.ui.theme.AppStrings r142, com.example.data.PrayerLog r143, boolean r144, int r145, int r146, boolean r147, boolean r148, final androidx.compose.runtime.MutableState r149, com.example.ui.UIState r150, kotlin.jvm.functions.Function3 r151, int r152, androidx.compose.foundation.layout.ColumnScope r153, androidx.compose.runtime.Composer r154, int r155) {
        /*
            Method dump skipped, instructions count: 2631
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.TrackerBoardDialog$lambda$93$lambda$92$lambda$91$lambda$90(com.example.ui.theme.AppStrings, com.example.data.PrayerLog, boolean, int, int, boolean, boolean, androidx.compose.runtime.MutableState, com.example.ui.UIState, kotlin.jvm.functions.Function3, int, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$92$lambda$91$lambda$90$lambda$89$lambda$82$lambda$80$lambda$79(MutableState $selectedDayInfo$delegate) {
        $selectedDayInfo$delegate.setValue(null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$92$lambda$91$lambda$90$lambda$89$lambda$82$lambda$81(AppStrings $appStrings, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C725@38820L81:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-285542350, $changed, -1, "com.example.ui.TrackerBoardDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TrackerBoard.kt:725)");
            }
            IconKt.Icon-ww6aTOc(CloseKt.getClose(Icons.Filled.INSTANCE), $appStrings.getClose(), (Modifier) null, com.example.ui.theme.ColorKt.getTextMuted(), $composer, 3072, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x015f, code lost:
    
        if (r111.changed(r5) == false) goto L57;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:0x06f0  */
    /* JADX WARN: Removed duplicated region for block: B:101:0x06f7  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x058d  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0546  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x048b  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0492  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x044c  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0455  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x02c5  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0396  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x03a2  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x03db  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x043f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0460  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x046f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0534  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0540  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0577  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x05ec A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0639 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:84:0x06e5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0716 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0787  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0738  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final void TrackerBoardDialog$lambda$93$lambda$92$lambda$91$lambda$90$lambda$89$InteractivePrayerRow(final boolean r98, com.example.ui.UIState r99, final com.example.ui.theme.AppStrings r100, final android.content.Context r101, final boolean r102, final kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> r103, final int r104, final int r105, java.lang.String r106, final java.lang.String r107, boolean r108, long r109, androidx.compose.runtime.Composer r111, int r112) {
        /*
            Method dump skipped, instructions count: 1956
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.TrackerBoardDialog$lambda$93$lambda$92$lambda$91$lambda$90$lambda$89$InteractivePrayerRow(boolean, com.example.ui.UIState, com.example.ui.theme.AppStrings, android.content.Context, boolean, kotlin.jvm.functions.Function3, int, int, java.lang.String, java.lang.String, boolean, long, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit TrackerBoardDialog$lambda$93$lambda$92$lambda$91$lambda$90$lambda$89$InteractivePrayerRow$lambda$84$lambda$83(boolean $isToday, boolean $isArrived, String $prayerTimeStr, AppStrings $appStrings, String $name, Context $context, boolean $isEditable, Function3 $onTogglePrayer, int $month, int $day, String $systemName) {
        String msg;
        if ($isToday && !$isArrived) {
            if ($prayerTimeStr != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                msg = String.format($appStrings.getPrayerTimeNotArrivedToast(), Arrays.copyOf(new Object[]{$name, $prayerTimeStr}, 2));
                Intrinsics.checkNotNullExpressionValue(msg, "format(...)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                msg = String.format($appStrings.getPrayerTimeNotStartedToast(), Arrays.copyOf(new Object[]{$name}, 1));
                Intrinsics.checkNotNullExpressionValue(msg, "format(...)");
            }
            Toast.makeText($context, msg, 0).show();
        } else if ($isEditable) {
            $onTogglePrayer.invoke(Integer.valueOf($month), Integer.valueOf($day), $systemName);
        }
        return Unit.INSTANCE;
    }

    /* renamed from: StatCard-uDo3WH8, reason: not valid java name */
    public static final void m7StatCarduDo3WH8(final String title, final String value, final String subtitle, final long color, Modifier modifier, Composer $composer, final int $changed, final int i) {
        long j;
        Modifier modifier2;
        Modifier modifier3;
        final Modifier modifier4;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(subtitle, "subtitle");
        Composer $composer2 = $composer.startRestartGroup(1954034522);
        ComposerKt.sourceInformation($composer2, "C(StatCard)P(3,4,2,0:c#ui.graphics.Color)854@45895L46,857@46047L872,852@45830L1089:TrackerBoard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer2.changed(value) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer2.changed(subtitle) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            j = color;
            $dirty |= $composer2.changed(j) ? 2048 : 1024;
        } else {
            j = color;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer2.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 9363) == 9362 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
            modifier4 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1954034522, $dirty, -1, "com.example.ui.StatCard (TrackerBoard.kt:851)");
            }
            CardColors cardColors = CardDefaults.INSTANCE.cardColors-ro_MJ88(ColorKt.Color(4279178530L), 0L, 0L, 0L, $composer2, (CardDefaults.$stable << 12) | 6, 14);
            $composer2 = $composer2;
            final long j2 = j;
            Modifier modifier5 = modifier3;
            CardKt.Card(modifier5, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(12)), cardColors, (CardElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl(1), ColorKt.Color(4280232253L)), ComposableLambdaKt.rememberComposableLambda(-548307508, true, new Function3() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda45
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TrackerBoardKt.StatCard_uDo3WH8$lambda$96(title, value, j2, subtitle, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer2, 54), $composer2, (($dirty >> 12) & 14) | 221184, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier5;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda46
                public final Object invoke(Object obj, Object obj2) {
                    return TrackerBoardKt.StatCard_uDo3WH8$lambda$97(title, value, subtitle, color, modifier4, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit StatCard_uDo3WH8$lambda$96(String $title, String $value, long $color, String $subtitle, ColumnScope $this$Card, Composer $composer, int $changed) {
        Function0 function0;
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C858@46057L856:TrackerBoard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-548307508, $changed, -1, "com.example.ui.StatCard.<anonymous> (TrackerBoard.kt:858)");
            }
            Modifier modifier = PaddingKt.padding-VpY3zN4(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(6), Dp.constructor-impl(4));
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            ComposerKt.sourceInformationMarkerStart($composer, -483455358, "CC(Column)P(2,3,1)85@4251L61,86@4317L133:Column.kt#2w3rfo");
            MeasurePolicy columnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, $composer, ((438 >> 3) & 14) | ((438 >> 3) & 112));
            ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer, modifier);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i = ((((438 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer.startReusableNode();
            if ($composer.getInserting()) {
                function0 = constructor;
                $composer.createNode(function0);
            } else {
                function0 = constructor;
                $composer.useNode();
            }
            Composer composer = Updater.constructor-impl($composer);
            Updater.set-impl(composer, columnMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i2 = (i >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer, -384862393, "C87@4365L9:Column.kt#2w3rfo");
            ColumnScope columnScope = ColumnScopeInstance.INSTANCE;
            int i3 = ((438 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer, -2070291068, "C863@46298L208,870@46519L206,877@46738L165:TrackerBoard.kt#naom5h");
            TextKt.Text--4IGK_g($title, (Modifier) null, com.example.ui.theme.ColorKt.getTextMuted(), TextUnitKt.getSp(9), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 200064, 0, 130514);
            TextKt.Text--4IGK_g($value, (Modifier) null, $color, TextUnitKt.getSp(14), (FontStyle) null, FontWeight.Companion.getBlack(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 199680, 0, 130514);
            TextKt.Text--4IGK_g($subtitle, (Modifier) null, com.example.ui.theme.ColorKt.getTextMuted(), TextUnitKt.getSp(7), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 3456, 0, 130546);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            $composer.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerEnd($composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final long getPointColor(int count, Composer $composer, int $changed) {
        long Color;
        ComposerKt.sourceInformationMarkerStart($composer, 529097646, "C(getPointColor):TrackerBoard.kt#naom5h");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(529097646, $changed, -1, "com.example.ui.getPointColor (TrackerBoard.kt:888)");
        }
        switch (count) {
            case 0:
                Color = ColorKt.Color(4293212469L);
                break;
            case 1:
                Color = ColorKt.Color(4294930499L);
                break;
            case 2:
                Color = ColorKt.Color(4294948685L);
                break;
            case BuildConfig.VERSION_CODE /* 3 */:
                Color = ColorKt.Color(4294961979L);
                break;
            case 4:
                Color = ColorKt.Color(4286695300L);
                break;
            default:
                Color = ColorKt.Color(4281236786L);
                break;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return Color;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x079a  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0a8a  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0a96  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0b3c  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0bbf  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x0c08  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0b54  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x0a9c  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x0d1c  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0558 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:228:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x03dd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:233:0x0308  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x04fd  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0542  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x05c2 A[LOOP:0: B:90:0x05bc->B:92:0x05c2, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0660  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void BigCalendarCard(final java.util.Calendar r145, final java.util.List<com.example.data.PrayerLog> r146, final kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> r147, androidx.compose.ui.Modifier r148, androidx.compose.runtime.Composer r149, final int r150, final int r151) {
        /*
            Method dump skipped, instructions count: 3386
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.BigCalendarCard(java.util.Calendar, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final float BigCalendarCard$lambda$105(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit BigCalendarCard$lambda$115$lambda$114$lambda$111$lambda$110(Function2 $onDateClick, int $currentMonth, int $day) {
        $onDateClick.invoke(Integer.valueOf($currentMonth), Integer.valueOf($day));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x02e6  */
    /* renamed from: PrayerTableRow-Bx497Mc, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m6PrayerTableRowBx497Mc(final java.lang.String r74, final int r75, final int r76, final long r77, androidx.compose.runtime.Composer r79, final int r80) {
        /*
            Method dump skipped, instructions count: 770
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.m6PrayerTableRowBx497Mc(java.lang.String, int, int, long, androidx.compose.runtime.Composer, int):void");
    }

    public static final void ZakatCalculatorDialog(final AppStrings strings, final Function0<Unit> function0, Composer $composer, final int $changed) {
        Object obj;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(strings, "strings");
        Intrinsics.checkNotNullParameter(function0, "onDismiss");
        Composer $composer3 = $composer.startRestartGroup(1309493469);
        ComposerKt.sourceInformation($composer3, "C(ZakatCalculatorDialog)P(1)1057@53847L31,1060@54024L5816,1060@53987L5853:TrackerBoard.kt#naom5h");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(strings) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changedInstance(function0) ? 32 : 16;
        }
        int $dirty2 = $dirty;
        if (($dirty2 & 19) == 18 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1309493469, $dirty2, -1, "com.example.ui.ZakatCalculatorDialog (TrackerBoard.kt:1056)");
            }
            ComposerKt.sourceInformationMarkerStart($composer3, -2190500, "CC(remember):TrackerBoard.kt#9igjgp");
            Object rememberedValue = $composer3.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                obj = SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
                $composer3.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            final MutableState netWealth$delegate = (MutableState) obj;
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Double doubleOrNull = kotlin.text.StringsKt.toDoubleOrNull(ZakatCalculatorDialog$lambda$120(netWealth$delegate));
            final double zakatAmount = doubleOrNull != null ? doubleOrNull.doubleValue() * 0.025d : 0.0d;
            $composer2 = $composer3;
            AndroidDialog_androidKt.Dialog(function0, (DialogProperties) null, ComposableLambdaKt.rememberComposableLambda(-1003309772, true, new Function2() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda1
                public final Object invoke(Object obj2, Object obj3) {
                    return TrackerBoardKt.ZakatCalculatorDialog$lambda$133(strings, function0, zakatAmount, netWealth$delegate, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer3, 54), $composer2, (($dirty2 >> 3) & 14) | 384, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj2, Object obj3) {
                    return TrackerBoardKt.ZakatCalculatorDialog$lambda$134(strings, function0, $changed, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    private static final String ZakatCalculatorDialog$lambda$120(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ZakatCalculatorDialog$lambda$133(final AppStrings $strings, final Function0 $onDismiss, final double $zakatAmount, final MutableState $netWealth$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1063@54149L46,1066@54313L5521,1061@54034L5800:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1003309772, $changed, -1, "com.example.ui.ZakatCalculatorDialog.<anonymous> (TrackerBoard.kt:1061)");
            }
            CardKt.Card(PaddingKt.padding-VpY3zN4$default(SizeKt.fillMaxWidth$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(8), 0.0f, 2, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(16)), CardDefaults.INSTANCE.cardColors-ro_MJ88(ColorKt.Color(4278849306L), 0L, 0L, 0L, $composer, (CardDefaults.$stable << 12) | 6, 14), (CardElevation) null, BorderStrokeKt.BorderStroke-cXLIe8U(Dp.constructor-impl(1), ColorKt.Color(4280232253L)), ComposableLambdaKt.rememberComposableLambda(238197286, true, new Function3() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda44
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return TrackerBoardKt.ZakatCalculatorDialog$lambda$133$lambda$132($strings, $onDismiss, $zakatAmount, $netWealth$delegate, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 221190, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0b7f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0858 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:120:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x05fc  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x05f6  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x055e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0515  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x043a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:128:0x03f1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x03eb  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0503  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x050f  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0548  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05f4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x05f9  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x07fd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0809  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0842  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x08b8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0a0d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit ZakatCalculatorDialog$lambda$133$lambda$132(com.example.ui.theme.AppStrings r107, kotlin.jvm.functions.Function0 r108, double r109, final androidx.compose.runtime.MutableState r111, androidx.compose.foundation.layout.ColumnScope r112, androidx.compose.runtime.Composer r113, int r114) {
        /*
            Method dump skipped, instructions count: 2949
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.ZakatCalculatorDialog$lambda$133$lambda$132(com.example.ui.theme.AppStrings, kotlin.jvm.functions.Function0, double, androidx.compose.runtime.MutableState, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ZakatCalculatorDialog$lambda$133$lambda$132$lambda$131$lambda$130$lambda$129$lambda$127$lambda$126(String $key, MutableState $netWealth$delegate) {
        if (!Intrinsics.areEqual($key, "C")) {
            if (Intrinsics.areEqual($key, "⌫")) {
                if (ZakatCalculatorDialog$lambda$120($netWealth$delegate).length() > 0) {
                    $netWealth$delegate.setValue(kotlin.text.StringsKt.dropLast(ZakatCalculatorDialog$lambda$120($netWealth$delegate), 1));
                }
            } else if (ZakatCalculatorDialog$lambda$120($netWealth$delegate).length() < 12) {
                $netWealth$delegate.setValue(ZakatCalculatorDialog$lambda$120($netWealth$delegate) + $key);
            }
        } else {
            $netWealth$delegate.setValue("");
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ZakatCalculatorDialog$lambda$133$lambda$132$lambda$131$lambda$130$lambda$129$lambda$128(String $key, RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C1177@59456L224:TrackerBoard.kt#naom5h");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(593159722, $changed, -1, "com.example.ui.ZakatCalculatorDialog.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TrackerBoard.kt:1177)");
            }
            TextKt.Text--4IGK_g($key, (Modifier) null, 0L, TextUnitKt.getSp(24), (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 199680, 0, 131030);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void GoldenPotliIcon(final Modifier modifier, Composer $composer, final int $changed, final int i) {
        Object obj;
        Composer $composer2 = $composer.startRestartGroup(90385076);
        ComposerKt.sourceInformation($composer2, "C(GoldenPotliIcon)1194@59953L1225,1194@59913L1265:TrackerBoard.kt#naom5h");
        int $dirty = $changed;
        int i2 = i & 1;
        if (i2 != 0) {
            $dirty |= 6;
        } else if (($changed & 6) == 0) {
            $dirty |= $composer2.changed(modifier) ? 4 : 2;
        }
        if (($dirty & 3) == 2 && $composer2.getSkipping()) {
            $composer2.skipToGroupEnd();
        } else {
            if (i2 != 0) {
                modifier = (Modifier) Modifier.Companion;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(90385076, $dirty, -1, "com.example.ui.GoldenPotliIcon (TrackerBoard.kt:1193)");
            }
            Modifier modifier2 = SizeKt.size-3ABfNKs(modifier, Dp.constructor-impl(20));
            ComposerKt.sourceInformationMarkerStart($composer2, 960716829, "CC(remember):TrackerBoard.kt#9igjgp");
            Object rememberedValue = $composer2.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                obj = new Function1() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda15
                    public final Object invoke(Object obj2) {
                        return TrackerBoardKt.GoldenPotliIcon$lambda$138$lambda$137((DrawScope) obj2);
                    }
                };
                $composer2.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer2);
            CanvasKt.Canvas(modifier2, (Function1) obj, $composer2, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.ui.TrackerBoardKt$$ExternalSyntheticLambda16
                public final Object invoke(Object obj2, Object obj3) {
                    return TrackerBoardKt.GoldenPotliIcon$lambda$139(modifier, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit GoldenPotliIcon$lambda$138$lambda$137(DrawScope $this$Canvas) {
        Intrinsics.checkNotNullParameter($this$Canvas, "$this$Canvas");
        float w = Size.getWidth-impl($this$Canvas.getSize-NH-jbRc());
        float h = Size.getHeight-impl($this$Canvas.getSize-NH-jbRc());
        long goldPrimary = ColorKt.Color(4294956800L);
        long goldDark = ColorKt.Color(4291201815L);
        long cordColor = ColorKt.Color(4294963574L);
        Path bodyPath = AndroidPath_androidKt.Path();
        bodyPath.moveTo(0.35f * w, h * 0.38f);
        bodyPath.cubicTo(w * 0.05f, h * 0.5f, 0.05f * w, h * 0.95f, w * 0.5f, h * 0.95f);
        bodyPath.cubicTo(w * 0.95f, h * 0.95f, w * 0.95f, h * 0.5f, 0.65f * w, h * 0.38f);
        bodyPath.close();
        DrawScope.drawPath-GBMwjPU$default($this$Canvas, bodyPath, Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(goldPrimary), Color.box-impl(goldDark)}), 0.0f, 0.0f, 0, 14, (Object) null), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        Path frillPath = AndroidPath_androidKt.Path();
        frillPath.moveTo(0.32f * w, h * 0.38f);
        frillPath.lineTo(0.18f * w, h * 0.16f);
        frillPath.lineTo(w * 0.5f, 0.24f * h);
        frillPath.lineTo(0.82f * w, 0.16f * h);
        frillPath.lineTo(0.68f * w, h * 0.38f);
        frillPath.close();
        DrawScope.drawPath-LG529CI$default($this$Canvas, frillPath, goldPrimary, 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        DrawScope.drawLine-NGM6Ib0$default($this$Canvas, cordColor, OffsetKt.Offset(0.25f * w, h * 0.38f), OffsetKt.Offset(0.75f * w, 0.38f * h), 3.0f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
        DrawScope.drawCircle-VaOC9Bg$default($this$Canvas, goldPrimary, 2.5f, OffsetKt.Offset(w * 0.5f, 0.45f * h), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x035b A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:111:0x032c A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:114:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0341  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void MonthPointHistoryCalendar(final com.example.ui.UIState r43, final com.example.ui.theme.AppStrings r44, boolean r45, kotlin.jvm.functions.Function0<kotlin.Unit> r46, final kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> r47, final kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> r48, androidx.compose.runtime.Composer r49, final int r50, final int r51) {
        /*
            Method dump skipped, instructions count: 1101
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.MonthPointHistoryCalendar(com.example.ui.UIState, com.example.ui.theme.AppStrings, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final int MonthPointHistoryCalendar$lambda$146(MutableIntState $displayMonth$delegate) {
        return ((IntState) $displayMonth$delegate).getIntValue();
    }

    private static final int MonthPointHistoryCalendar$lambda$149(MutableIntState $displayYear$delegate) {
        return ((IntState) $displayYear$delegate).getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:101:0x02ab  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0295  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x03b7  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x04dc  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x04e8  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0521  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x063b  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0647  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x067e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x072f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x093d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x09b2  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x09f9  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0734  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0694 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x064d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0537 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x04ee  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03cd A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0384  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit MonthPointHistoryCalendar$lambda$190(final kotlin.jvm.functions.Function0 r126, final boolean r127, final com.example.ui.theme.AppStrings r128, final int r129, final int r130, com.example.data.PrayerLog r131, final com.example.ui.UIState r132, final kotlin.jvm.functions.Function3 r133, final int r134, final int r135, com.example.data.PrayerLog r136, final java.lang.String r137, final androidx.compose.runtime.MutableIntState r138, final int r139, final int r140, final androidx.compose.runtime.MutableIntState r141, final java.util.List r142, final int r143, final int r144, final kotlin.jvm.functions.Function2 r145, androidx.compose.foundation.layout.ColumnScope r146, androidx.compose.runtime.Composer r147, int r148) {
        /*
            Method dump skipped, instructions count: 2559
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.MonthPointHistoryCalendar$lambda$190(kotlin.jvm.functions.Function0, boolean, com.example.ui.theme.AppStrings, int, int, com.example.data.PrayerLog, com.example.ui.UIState, kotlin.jvm.functions.Function3, int, int, com.example.data.PrayerLog, java.lang.String, androidx.compose.runtime.MutableIntState, int, int, androidx.compose.runtime.MutableIntState, java.util.List, int, int, kotlin.jvm.functions.Function2, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MonthPointHistoryCalendar$lambda$190$lambda$189$lambda$158$lambda$157(Function0 $onToggleCalendar) {
        $onToggleCalendar.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MonthPointHistoryCalendar$lambda$190$lambda$189$lambda$163$lambda$162(boolean $isCalendarExpanded, AppStrings $appStrings, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1339@66139L11,1336@65837L343:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(956382175, $changed, -1, "com.example.ui.MonthPointHistoryCalendar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (TrackerBoard.kt:1336)");
            }
            Icons.Filled filled = Icons.Filled.INSTANCE;
            IconKt.Icon-ww6aTOc($isCalendarExpanded ? KeyboardArrowUpKt.getKeyboardArrowUp(filled) : KeyboardArrowDownKt.getKeyboardArrowDown(filled), $isCalendarExpanded ? $appStrings.getTapToCollapse() : $appStrings.getTapToExpand(), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), $composer, 0, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:100:0x0d5f  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0d6b  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0da4  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0e29  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0f6c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0f78  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0fb1  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x1026  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x1164  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x01d8  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x11f3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x1224  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x122d  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x1296  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x1325  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x13c5  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x14b3  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x14bf  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x14f8  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x156f  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x157d  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x160a  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x160f  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x1584  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x1574  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x150e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:253:0x14c5  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x13d2  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x132a  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x12ad  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x1245  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x1229  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x121a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:314:0x174c  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0fc7 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x034f  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x0f7e  */
    /* JADX WARN: Removed duplicated region for block: B:322:0x0dba A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0d71  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0c0e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:326:0x0bc5  */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0a76 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:329:0x0a2d  */
    /* JADX WARN: Removed duplicated region for block: B:331:0x08d9 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:332:0x0890  */
    /* JADX WARN: Removed duplicated region for block: B:334:0x073b A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:335:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:337:0x0610 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:338:0x05c7  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:341:0x03aa A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:342:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:343:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:346:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0394  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x05b5  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x05c1  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x05fa  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x06e0  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x06ec  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0725  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x087e  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x088a  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x08c3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0a1b  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0a27  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0a60  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0bb3  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0bbf  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0bf8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit MonthPointHistoryCalendar$lambda$190$lambda$189$lambda$184(int r176, int r177, androidx.compose.runtime.MutableIntState r178, final androidx.compose.runtime.MutableIntState r179, java.lang.String r180, com.example.ui.theme.AppStrings r181, java.util.List r182, int r183, int r184, int r185, int r186, int r187, int r188, com.example.ui.UIState r189, final kotlin.jvm.functions.Function2 r190, androidx.compose.animation.AnimatedVisibilityScope r191, androidx.compose.runtime.Composer r192, int r193) {
        /*
            Method dump skipped, instructions count: 5970
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.MonthPointHistoryCalendar$lambda$190$lambda$189$lambda$184(int, int, androidx.compose.runtime.MutableIntState, androidx.compose.runtime.MutableIntState, java.lang.String, com.example.ui.theme.AppStrings, java.util.List, int, int, int, int, int, int, com.example.ui.UIState, kotlin.jvm.functions.Function2, androidx.compose.animation.AnimatedVisibilityScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MonthPointHistoryCalendar$lambda$190$lambda$189$lambda$184$lambda$183$lambda$169$lambda$165$lambda$164(MutableIntState $displayMonth$delegate, MutableIntState $displayYear$delegate) {
        if (MonthPointHistoryCalendar$lambda$146($displayMonth$delegate) == 1) {
            $displayMonth$delegate.setIntValue(12);
            $displayYear$delegate.setIntValue(MonthPointHistoryCalendar$lambda$149($displayYear$delegate) - 1);
        } else {
            $displayMonth$delegate.setIntValue(MonthPointHistoryCalendar$lambda$146($displayMonth$delegate) - 1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MonthPointHistoryCalendar$lambda$190$lambda$189$lambda$184$lambda$183$lambda$169$lambda$168$lambda$167(MutableIntState $displayMonth$delegate, MutableIntState $displayYear$delegate) {
        if (MonthPointHistoryCalendar$lambda$146($displayMonth$delegate) == 12) {
            $displayMonth$delegate.setIntValue(1);
            $displayYear$delegate.setIntValue(MonthPointHistoryCalendar$lambda$149($displayYear$delegate) + 1);
        } else {
            $displayMonth$delegate.setIntValue(MonthPointHistoryCalendar$lambda$146($displayMonth$delegate) + 1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MonthPointHistoryCalendar$lambda$190$lambda$189$lambda$184$lambda$183$lambda$182$lambda$181$lambda$179$lambda$178(Function2 $onSelectDay, int $dayNumber, MutableIntState $displayMonth$delegate) {
        $onSelectDay.invoke(Integer.valueOf(MonthPointHistoryCalendar$lambda$146($displayMonth$delegate)), Integer.valueOf($dayNumber));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MonthPointHistoryCalendar$lambda$190$lambda$189$lambda$186$lambda$185(Function3 $onTogglePrayer, int $yesterdayMonth, int $yesterdayDay, String prayerName) {
        Intrinsics.checkNotNullParameter(prayerName, "prayerName");
        $onTogglePrayer.invoke(Integer.valueOf($yesterdayMonth), Integer.valueOf($yesterdayDay), prayerName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit MonthPointHistoryCalendar$lambda$190$lambda$189$lambda$188$lambda$187(Function3 $onTogglePrayer, int $todayMonth, int $todayDay, String prayerName) {
        Intrinsics.checkNotNullParameter(prayerName, "prayerName");
        $onTogglePrayer.invoke(Integer.valueOf($todayMonth), Integer.valueOf($todayDay), prayerName);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x04dd  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x04e9  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0522  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x06cd  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x07a7  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x07b3  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x07e4  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0864  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0c27  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0c33  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0d57  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0d63  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0d9c  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0e00 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0e22 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0e8b  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0e99 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0f08 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0eb5  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x0ebe  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0e90  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x0e3e  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0e45  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x0e0d  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x0e16  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0db2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:229:0x0d69  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0c39  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x100a  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x07fa  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x07b7  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x06d9  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0538 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04ef  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x03bb  */
    /* renamed from: DayPrayerEditorCard-fWhpE4E, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m5DayPrayerEditorCardfWhpE4E(final java.lang.String r180, final java.lang.String r181, final com.example.data.PrayerLog r182, final long r183, final boolean r185, final com.example.data.AzanTiming r186, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r187, androidx.compose.runtime.Composer r188, final int r189) {
        /*
            Method dump skipped, instructions count: 4162
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.TrackerBoardKt.m5DayPrayerEditorCardfWhpE4E(java.lang.String, java.lang.String, com.example.data.PrayerLog, long, boolean, com.example.data.AzanTiming, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit DayPrayerEditorCard_fWhpE4E$lambda$201$lambda$200$lambda$199$lambda$195$lambda$194(boolean $isToday, boolean $isArrived, String $prayerTimeStr, AppStrings $appStrings, String $displayName, Context $context, Function1 $onTogglePrayer, String $systemName) {
        String msg;
        if ($isToday && !$isArrived) {
            if ($prayerTimeStr != null) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                msg = String.format($appStrings.getPrayerTimeNotArrivedToast(), Arrays.copyOf(new Object[]{$displayName, $prayerTimeStr}, 2));
                Intrinsics.checkNotNullExpressionValue(msg, "format(...)");
            } else {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                msg = String.format($appStrings.getPrayerTimeNotStartedToast(), Arrays.copyOf(new Object[]{$displayName}, 1));
                Intrinsics.checkNotNullExpressionValue(msg, "format(...)");
            }
            Toast.makeText($context, msg, 0).show();
        } else {
            $onTogglePrayer.invoke($systemName);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static final boolean isPrayerTimeArrived(boolean isToday, String prayerName, AzanTiming todayTimings) {
        String timeStr;
        Integer intOrNull;
        Intrinsics.checkNotNullParameter(prayerName, "prayerName");
        if (!isToday) {
            return true;
        }
        if (todayTimings == null) {
            return false;
        }
        String lowerCase = prayerName.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        switch (lowerCase.hashCode()) {
            case -733643531:
                if (lowerCase.equals("tahajjud")) {
                    timeStr = "01:30";
                    break;
                }
                timeStr = null;
                break;
            case 96896:
                if (lowerCase.equals("asr")) {
                    timeStr = todayTimings.getAsr();
                    break;
                }
                timeStr = null;
                break;
            case 3135299:
                if (lowerCase.equals("fajr")) {
                    timeStr = todayTimings.getFajr();
                    break;
                }
                timeStr = null;
                break;
            case 3241891:
                if (lowerCase.equals("isha")) {
                    timeStr = todayTimings.getIsha();
                    break;
                }
                timeStr = null;
                break;
            case 95566139:
                if (lowerCase.equals("dhuhr")) {
                    timeStr = todayTimings.getDhuhr();
                    break;
                }
                timeStr = null;
                break;
            case 829014902:
                if (lowerCase.equals("maghrib")) {
                    timeStr = todayTimings.getMaghrib();
                    break;
                }
                timeStr = null;
                break;
            default:
                timeStr = null;
                break;
        }
        if (timeStr == null) {
            return false;
        }
        List parts = kotlin.text.StringsKt.split$default(timeStr, new String[]{":"}, false, 0, 6, (Object) null);
        if (parts.size() != 2 || (intOrNull = kotlin.text.StringsKt.toIntOrNull((String) parts.get(0))) == null) {
            return false;
        }
        int hour = intOrNull.intValue();
        Integer intOrNull2 = kotlin.text.StringsKt.toIntOrNull((String) parts.get(1));
        if (intOrNull2 == null) {
            return false;
        }
        int minute = intOrNull2.intValue();
        Calendar now = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
        Calendar prayerCal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
        prayerCal.set(11, hour);
        prayerCal.set(12, minute);
        prayerCal.set(13, 0);
        prayerCal.set(14, 0);
        return true ^ now.before(prayerCal);
    }

    public static final String getMonthShort(int month) {
        switch (month) {
            case 1:
                return "Jan";
            case 2:
                return "Feb";
            case BuildConfig.VERSION_CODE /* 3 */:
                return "Mar";
            case 4:
                return "Apr";
            case 5:
                return "May";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Aug";
            case 9:
                return "Sep";
            case 10:
                return "Oct";
            case 11:
                return "Nov";
            case 12:
                return "Dec";
            default:
                return "";
        }
    }
}
