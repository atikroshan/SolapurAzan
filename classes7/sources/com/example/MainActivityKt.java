package com.example;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import androidx.compose.animation.AnimatedContentKt;
import androidx.compose.animation.AnimatedContentTransitionScope;
import androidx.compose.animation.ContentTransform;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.RepeatMode;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckCircleKt;
import androidx.compose.material.icons.filled.VolumeUpKt;
import androidx.compose.material3.CardDefaults;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.IntState;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.CornerRadiusKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.RectKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.PathOperation;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.example.data.AzanTiming;
import com.example.service.AzanForegroundService;
import com.example.ui.AzanViewModel;
import com.example.ui.UIState;
import com.example.ui.theme.AppStrings;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\t\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u001b\u0010\t\u001a\u00020\u00012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010\f\u001a)\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001aC\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u00112\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0017\u001a\u0016\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u0019\u001a[\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u001e\u001a\u00020\u000f2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010$\u001a'\u0010%\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b\u001a2\u0010&\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020)0(0'2\u0006\u0010*\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020,2\b\b\u0002\u0010-\u001a\u00020.\u001a\u0091\u0001\u0010/\u001a\u00020\u00012\u0006\u00100\u001a\u00020\u000f2\u0006\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\u000f2\u0006\u00103\u001a\u00020.2\u0006\u00104\u001a\u00020.2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u00020.2\u0006\u00108\u001a\u00020.2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010:\u001a\u00020.2\u0012\u0010;\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00010\u000bH\u0007¢\u0006\u0002\u0010=\u001a\u0017\u0010>\u001a\u00020\u00012\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010?\u001a/\u0010@\u001a\u00020\u00012\u0006\u0010A\u001a\u00020\u000f2\u0006\u0010B\u001a\u00020\u000f2\u0006\u0010C\u001a\u00020\u000f2\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010D\u001a\u0011\u0010E\u001a\u00020\u0007*\u00020\u0007H\u0007¢\u0006\u0002\u0010F\u001a\u0019\u0010G\u001a\u00020\u0007*\u00020\u00072\u0006\u0010H\u001a\u00020I¢\u0006\u0004\bJ\u0010K\u001a\u000e\u0010L\u001a\u00020\u000f2\u0006\u0010M\u001a\u00020\u000f\u001a\u001d\u0010N\u001a\u00020\u00012\u0006\u0010M\u001a\u00020\u000f2\u0006\u00104\u001a\u00020.H\u0007¢\u0006\u0002\u0010O\u001a\u0019\u0010P\u001a\u00020\u0007*\u00020\u00072\u0006\u0010H\u001a\u00020I¢\u0006\u0004\bQ\u0010K¨\u0006R²\u0006\n\u0010S\u001a\u00020.X\u008a\u008e\u0002²\u0006\n\u0010T\u001a\u00020UX\u008a\u0084\u0002²\u0006\u0012\u0010V\u001a\n W*\u0004\u0018\u00010\u00190\u0019X\u008a\u008e\u0002²\u0006\n\u0010X\u001a\u00020)X\u008a\u008e\u0002²\u0006\n\u0010Y\u001a\u00020\u000fX\u008a\u008e\u0002²\u0006\n\u0010Z\u001a\u00020)X\u008a\u008e\u0002²\u0006\n\u0010[\u001a\u00020.X\u008a\u0084\u0002²\u0006\n\u0010\\\u001a\u00020UX\u008a\u0084\u0002²\u0006\n\u0010]\u001a\u00020UX\u008a\u0084\u0002²\u0006\n\u0010^\u001a\u00020UX\u008a\u0084\u0002"}, d2 = {"AzanScreen", "", "viewModel", "Lcom/example/ui/AzanViewModel;", "uiState", "Lcom/example/ui/UIState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/example/ui/AzanViewModel;Lcom/example/ui/UIState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AppHeaderSection", "onTrackerClick", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "LanguageToggleRow", "currentLang", "", "onLangSelect", "Lkotlin/Function1;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "LanguageButton", "label", "langCode", "onClick", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "parseTimeToCalendar", "Ljava/util/Calendar;", "timeStr", "baseCal", "ClockDisplay", "selectedDate", "language", "todayTimings", "Lcom/example/data/AzanTiming;", "onPrevDay", "onNextDay", "onToday", "(Ljava/util/Calendar;Ljava/lang/String;Lcom/example/data/AzanTiming;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AzanList", "getRakatSegments", "", "Lkotlin/Pair;", "", "prayerName", "strings", "Lcom/example/ui/theme/AppStrings;", "isJumuah", "", "AzanSlot", "systemName", "displayName", "time", "enabled", "isNext", "icon", "Landroidx/compose/ui/graphics/vector/ImageVector;", "prayed", "expanded", "onHeaderClick", "showAudioToggle", "onToggle", "onPrayedToggle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZLandroidx/compose/ui/graphics/vector/ImageVector;ZZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;III)V", "EidInfoRow", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "EidCard", "title", "date", "day", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "appBackground", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "islamicStarBackground", "primaryColor", "Landroidx/compose/ui/graphics/Color;", "islamicStarBackground-4WTKRHQ", "(Landroidx/compose/ui/Modifier;J)Landroidx/compose/ui/Modifier;", "formatTo12Hour", "time24", "PrayerTimeDisplay", "(Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "animatedWavingLines", "animatedWavingLines-4WTKRHQ", "app", "showTrackerBoard", "scale", "", "currentTime", "kotlin.jvm.PlatformType", "currentNextIndex", "lastTriggeredMinute", "expandedIndex", "isPlayingAzan", "flareProgress", "pulseAlpha", "phase"}, k = 2, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class MainActivityKt {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AppHeaderSection$lambda$29(Function0 function0, int i, Composer composer, int i2) {
        AppHeaderSection(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanList$lambda$103(AzanViewModel azanViewModel, UIState uIState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AzanList(azanViewModel, uIState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanScreen$lambda$25(AzanViewModel azanViewModel, UIState uIState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AzanScreen(azanViewModel, uIState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanSlot$lambda$133(String str, String str2, String str3, boolean z, boolean z2, ImageVector imageVector, boolean z3, boolean z4, Function0 function0, Modifier modifier, boolean z5, Function1 function1, Function0 function02, int i, int i2, int i3, Composer composer, int i4) {
        AzanSlot(str, str2, str3, z, z2, imageVector, z3, z4, function0, modifier, z5, function1, function02, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClockDisplay$lambda$72(Calendar calendar, String str, AzanTiming azanTiming, Function0 function0, Function0 function02, Function0 function03, Modifier modifier, int i, int i2, Composer composer, int i3) {
        ClockDisplay(calendar, str, azanTiming, function0, function02, function03, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit EidCard$lambda$138(String str, String str2, String str3, Modifier modifier, int i, int i2, Composer composer, int i3) {
        EidCard(str, str2, str3, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit EidInfoRow$lambda$135(Modifier modifier, int i, int i2, Composer composer, int i3) {
        EidInfoRow(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LanguageButton$lambda$35(String str, String str2, String str3, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        LanguageButton(str, str2, str3, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LanguageToggleRow$lambda$31(String str, Function1 function1, int i, Composer composer, int i2) {
        LanguageToggleRow(str, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit PrayerTimeDisplay$lambda$147(String str, boolean z, int i, Composer composer, int i2) {
        PrayerTimeDisplay(str, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0609  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0642  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x067a  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x074d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0759  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0903  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x07a1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x075d  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0687 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x064f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0616 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:139:0x05cf  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0598  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0524 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:143:0x04db  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x04c9  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x050e  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x058a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x05c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AzanScreen(final com.example.ui.AzanViewModel r107, final com.example.ui.UIState r108, androidx.compose.ui.Modifier r109, androidx.compose.runtime.Composer r110, final int r111, final int r112) {
        /*
            Method dump skipped, instructions count: 2334
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.AzanScreen(com.example.ui.AzanViewModel, com.example.ui.UIState, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final boolean AzanScreen$lambda$1(MutableState<Boolean> mutableState) {
        return ((Boolean) ((State) mutableState).getValue()).booleanValue();
    }

    private static final void AzanScreen$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanScreen$lambda$4$lambda$3(AzanViewModel $viewModel, int month, int day) {
        $viewModel.selectDate(month, day);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanScreen$lambda$6$lambda$5(AzanViewModel $viewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewModel.setLanguage(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanScreen$lambda$8$lambda$7(AzanViewModel $viewModel, int month, int day, String prayerName) {
        Intrinsics.checkNotNullParameter(prayerName, "prayerName");
        $viewModel.togglePrayerForDate(month, day, prayerName);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanScreen$lambda$10$lambda$9(MutableState $showTrackerBoard$delegate) {
        AzanScreen$lambda$2($showTrackerBoard$delegate, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanScreen$lambda$24$lambda$23$lambda$22$lambda$12$lambda$11(MutableState $showTrackerBoard$delegate) {
        AzanScreen$lambda$2($showTrackerBoard$delegate, true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanScreen$lambda$24$lambda$23$lambda$22$lambda$14$lambda$13(AzanViewModel $viewModel, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $viewModel.setLanguage(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanScreen$lambda$24$lambda$23$lambda$22$lambda$16$lambda$15(AzanViewModel $viewModel) {
        $viewModel.previousDay();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanScreen$lambda$24$lambda$23$lambda$22$lambda$18$lambda$17(AzanViewModel $viewModel) {
        $viewModel.nextDay();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanScreen$lambda$24$lambda$23$lambda$22$lambda$20$lambda$19(AzanViewModel $viewModel) {
        $viewModel.selectToday();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x022a  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0261  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x030c  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0423  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0466  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x05c3  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0469  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0277  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0230  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AppHeaderSection(kotlin.jvm.functions.Function0<kotlin.Unit> r111, androidx.compose.runtime.Composer r112, final int r113) {
        /*
            Method dump skipped, instructions count: 1493
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.AppHeaderSection(kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int):void");
    }

    private static final float AppHeaderSection$lambda$28$lambda$27(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x0242  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void LanguageToggleRow(java.lang.String r37, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40) {
        /*
            Method dump skipped, instructions count: 596
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.LanguageToggleRow(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.runtime.Composer, int):void");
    }

    public static final void LanguageButton(final String label, final String langCode, final String currentLang, final Function1<? super String, Unit> function1, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Brush brush;
        Object obj;
        Composer $composer2;
        final Modifier modifier4;
        Intrinsics.checkNotNullParameter(label, "label");
        Intrinsics.checkNotNullParameter(langCode, "langCode");
        Intrinsics.checkNotNullParameter(currentLang, "currentLang");
        Intrinsics.checkNotNullParameter(function1, "onClick");
        Composer $composer3 = $composer.startRestartGroup(-1163134936);
        ComposerKt.sourceInformation($composer3, "C(LanguageButton)P(1,2!1,4)373@14736L21,356@14127L1006:MainActivity.kt#to5c3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(label) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(langCode) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(currentLang) ? 256 : 128;
        }
        if (($changed & 3072) == 0) {
            $dirty |= $composer3.changedInstance(function1) ? 2048 : 1024;
        }
        int i2 = i & 16;
        if (i2 != 0) {
            $dirty |= 24576;
            modifier2 = modifier;
        } else if (($changed & 24576) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 16384 : 8192;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 9363) == 9362 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            $composer2 = $composer3;
            modifier4 = modifier2;
        } else {
            if (i2 != 0) {
                modifier3 = (Modifier) Modifier.Companion;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1163134936, $dirty, -1, "com.example.LanguageButton (MainActivity.kt:354)");
            }
            boolean isActive = Intrinsics.areEqual(currentLang, langCode);
            Modifier modifier5 = SizeKt.height-3ABfNKs(PaddingKt.padding-VpY3zN4$default(modifier3, Dp.constructor-impl(4), 0.0f, 2, (Object) null), Dp.constructor-impl(34));
            if (isActive) {
                brush = Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4294172302L)), Color.box-impl(ColorKt.Color(4289952828L))}), 0.0f, 0.0f, 0, 14, (Object) null);
            } else {
                brush = Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4279441702L)), Color.box-impl(ColorKt.Color(4279441702L))}), 0.0f, 0.0f, 0, 14, (Object) null);
            }
            Modifier clip = ClipKt.clip(BackgroundKt.background$default(modifier5, brush, RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)), 0.0f, 4, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(8)));
            ComposerKt.sourceInformationMarkerStart($composer3, -1081150179, "CC(remember):MainActivity.kt#9igjgp");
            boolean z = (($dirty & 7168) == 2048) | (($dirty & 112) == 32);
            Object rememberedValue = $composer3.rememberedValue();
            if (z || rememberedValue == Composer.Companion.getEmpty()) {
                obj = new Function0() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda40
                    public final Object invoke() {
                        return MainActivityKt.LanguageButton$lambda$33$lambda$32(function1, langCode);
                    }
                };
                $composer3.updateRememberedValue(obj);
            } else {
                obj = rememberedValue;
            }
            ComposerKt.sourceInformationMarkerEnd($composer3);
            Modifier modifier6 = ClickableKt.clickable-XHw0xAI$default(clip, false, (String) null, (Role) null, (Function0) obj, 7, (Object) null);
            Alignment center = Alignment.Companion.getCenter();
            ComposerKt.sourceInformationMarkerStart($composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart($composer3, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer3, 0);
            CompositionLocalMap currentCompositionLocalMap = $composer3.getCurrentCompositionLocalMap();
            Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer3, modifier6);
            Function0 constructor = ComposeUiNode.Companion.getConstructor();
            int i3 = ((((48 << 3) & 112) << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!($composer3.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            $composer3.startReusableNode();
            if ($composer3.getInserting()) {
                $composer3.createNode(constructor);
            } else {
                $composer3.useNode();
            }
            Composer composer = Updater.constructor-impl($composer3);
            Updater.set-impl(composer, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
            Updater.set-impl(composer, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
            Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
            if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composer.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.set-impl(composer, materializeModifier, ComposeUiNode.Companion.getSetModifier());
            int i4 = (i3 >> 6) & 14;
            ComposerKt.sourceInformationMarkerStart($composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScope boxScope = BoxScopeInstance.INSTANCE;
            int i5 = ((48 >> 6) & 112) | 6;
            ComposerKt.sourceInformationMarkerStart($composer3, -970474131, "C376@14819L308:MainActivity.kt#to5c3");
            FontWeight.Companion companion = FontWeight.Companion;
            Modifier modifier7 = modifier3;
            $composer2 = $composer3;
            TextKt.Text--4IGK_g(label, (Modifier) null, isActive ? ColorKt.Color(4278980635L) : Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, (Object) null), TextUnitKt.getSp(isActive ? 14 : 12), (FontStyle) null, isActive ? companion.getExtraBold() : companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer3, $dirty & 14, 0, 130514);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            $composer3.endNode();
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            ComposerKt.sourceInformationMarkerEnd($composer3);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier4 = modifier7;
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda41
                public final Object invoke(Object obj2, Object obj3) {
                    return MainActivityKt.LanguageButton$lambda$35(label, langCode, currentLang, function1, modifier4, $changed, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit LanguageButton$lambda$33$lambda$32(Function1 $onClick, String $langCode) {
        $onClick.invoke($langCode);
        return Unit.INSTANCE;
    }

    public static final Calendar parseTimeToCalendar(String timeStr, Calendar baseCal) {
        Intrinsics.checkNotNullParameter(timeStr, "timeStr");
        Intrinsics.checkNotNullParameter(baseCal, "baseCal");
        List parts = StringsKt.split$default(timeStr, new String[]{":"}, false, 0, 6, (Object) null);
        Calendar targetCal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
        targetCal.setTimeInMillis(baseCal.getTimeInMillis());
        if (parts.size() == 2) {
            Integer intOrNull = StringsKt.toIntOrNull((String) parts.get(0));
            targetCal.set(11, intOrNull != null ? intOrNull.intValue() : 0);
            Integer intOrNull2 = StringsKt.toIntOrNull((String) parts.get(1));
            targetCal.set(12, intOrNull2 != null ? intOrNull2.intValue() : 0);
            targetCal.set(13, 0);
            targetCal.set(14, 0);
        }
        Intrinsics.checkNotNull(targetCal);
        return targetCal;
    }

    /* JADX WARN: Can't wrap try/catch for region: R(80:(1:44)|45|(1:47)|48|(1:50)(1:377)|51|(1:53)(1:376)|54|(1:56)(1:375)|57|(67:61|62|(64:66|67|(61:71|72|(58:76|77|(39:81|82|(1:357)(1:86)|87|(1:356)(1:90)|91|(1:93)(1:355)|94|(14:279|280|281|282|283|284|285|(1:287)(3:346|347|348)|288|(1:290)(2:316|(1:318)(1:332))|292|(1:294)(2:300|(1:302)(1:303))|295|296)(1:98)|99|(1:101)|102|(1:104)(1:278)|105|(24:109|110|(1:112)|113|(1:115)(1:275)|116|(17:120|121|(1:123)|124|(1:126)(1:272)|127|(10:131|132|(1:134)|135|(1:137)(1:269)|138|(3:142|143|(2:144|(3:146|(2:148|149)(2:151|152)|150)(17:153|154|(1:156)|157|(1:159)(1:266)|160|(10:164|165|(1:167)|168|(1:170)(1:263)|171|(3:175|176|(2:177|(3:179|(2:181|182)(2:184|185)|183)(19:186|187|(1:189)|190|(1:192)(1:260)|193|(12:197|198|(1:200)(1:257)|(1:202)(1:256)|203|(1:205)(1:255)|(8:207|(1:209)|210|(1:212)(1:253)|213|(2:215|(2:217|218))(1:252)|251|218)(1:254)|219|(12:221|(1:223)(1:249)|224|(1:248)(1:228)|229|(1:231)|232|(1:234)(1:247)|235|(2:237|(2:239|240))(1:246)|245|240)(1:250)|241|(1:243)|244)|258|198|(0)(0)|(0)(0)|203|(0)(0)|(0)(0)|219|(0)(0)|241|(0)|244)))|261|176|(3:177|(0)(0)|183))|264|165|(0)|168|(0)(0)|171|(1:262)(4:173|175|176|(3:177|(0)(0)|183))|261|176|(3:177|(0)(0)|183))))|267|143|(3:144|(0)(0)|150))|270|132|(0)|135|(0)(0)|138|(1:268)(4:140|142|143|(3:144|(0)(0)|150))|267|143|(3:144|(0)(0)|150))|273|121|(0)|124|(0)(0)|127|(1:271)(11:129|131|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|276|110|(0)|113|(0)(0)|116|(1:274)(18:118|120|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|358|82|(1:84)|357|87|(0)|356|91|(0)(0)|94|(1:96)|279|280|281|282|283|284|285|(0)(0)|288|(0)(0)|292|(0)(0)|295|296|99|(0)|102|(0)(0)|105|(1:277)(25:107|109|110|(0)|113|(0)(0)|116|(0)(0)|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|276|110|(0)|113|(0)(0)|116|(0)(0)|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|360|77|(1:359)(56:79|81|82|(0)|357|87|(0)|356|91|(0)(0)|94|(0)|279|280|281|282|283|284|285|(0)(0)|288|(0)(0)|292|(0)(0)|295|296|99|(0)|102|(0)(0)|105|(0)(0)|276|110|(0)|113|(0)(0)|116|(0)(0)|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|358|82|(0)|357|87|(0)|356|91|(0)(0)|94|(0)|279|280|281|282|283|284|285|(0)(0)|288|(0)(0)|292|(0)(0)|295|296|99|(0)|102|(0)(0)|105|(0)(0)|276|110|(0)|113|(0)(0)|116|(0)(0)|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|362|72|(1:361)(59:74|76|77|(0)(0)|358|82|(0)|357|87|(0)|356|91|(0)(0)|94|(0)|279|280|281|282|283|284|285|(0)(0)|288|(0)(0)|292|(0)(0)|295|296|99|(0)|102|(0)(0)|105|(0)(0)|276|110|(0)|113|(0)(0)|116|(0)(0)|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|360|77|(0)(0)|358|82|(0)|357|87|(0)|356|91|(0)(0)|94|(0)|279|280|281|282|283|284|285|(0)(0)|288|(0)(0)|292|(0)(0)|295|296|99|(0)|102|(0)(0)|105|(0)(0)|276|110|(0)|113|(0)(0)|116|(0)(0)|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|364|67|(1:363)(62:69|71|72|(0)(0)|360|77|(0)(0)|358|82|(0)|357|87|(0)|356|91|(0)(0)|94|(0)|279|280|281|282|283|284|285|(0)(0)|288|(0)(0)|292|(0)(0)|295|296|99|(0)|102|(0)(0)|105|(0)(0)|276|110|(0)|113|(0)(0)|116|(0)(0)|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|362|72|(0)(0)|360|77|(0)(0)|358|82|(0)|357|87|(0)|356|91|(0)(0)|94|(0)|279|280|281|282|283|284|285|(0)(0)|288|(0)(0)|292|(0)(0)|295|296|99|(0)|102|(0)(0)|105|(0)(0)|276|110|(0)|113|(0)(0)|116|(0)(0)|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|366|(1:368)(2:370|(1:372)(1:373))|369|62|(1:365)(65:64|66|67|(0)(0)|362|72|(0)(0)|360|77|(0)(0)|358|82|(0)|357|87|(0)|356|91|(0)(0)|94|(0)|279|280|281|282|283|284|285|(0)(0)|288|(0)(0)|292|(0)(0)|295|296|99|(0)|102|(0)(0)|105|(0)(0)|276|110|(0)|113|(0)(0)|116|(0)(0)|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150))|364|67|(0)(0)|362|72|(0)(0)|360|77|(0)(0)|358|82|(0)|357|87|(0)|356|91|(0)(0)|94|(0)|279|280|281|282|283|284|285|(0)(0)|288|(0)(0)|292|(0)(0)|295|296|99|(0)|102|(0)(0)|105|(0)(0)|276|110|(0)|113|(0)(0)|116|(0)(0)|273|121|(0)|124|(0)(0)|127|(0)(0)|270|132|(0)|135|(0)(0)|138|(0)(0)|267|143|(3:144|(0)(0)|150)) */
    /* JADX WARN: Code restructure failed: missing block: B:351:0x04c3, code lost:
    
        r33 = r14;
     */
    /* JADX WARN: Code restructure failed: missing block: B:354:0x04c9, code lost:
    
        r33 = r14;
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x054a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0556  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x058f  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x069d  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x06a9  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x06e2  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x07ca  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x07d6  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x080f  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x08f6  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0902  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x093b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x09c0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0a46 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0c1c  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0c28  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0ce6  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0d6a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0f41  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0f46  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x1036  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x103b  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x1245  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x14b8  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x1479  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x123a  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x1038  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0f50  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0f43  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0c2e  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0951 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0908  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x0825 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:272:0x07dc  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x06f8 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x06af  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x05a5 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:278:0x055c  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:290:0x03ed A[Catch: Exception -> 0x04c0, TryCatch #0 {Exception -> 0x04c0, blocks: (B:288:0x03be, B:290:0x03ed, B:292:0x047e, B:295:0x0495, B:300:0x048a, B:316:0x0424, B:318:0x042a, B:332:0x0455, B:348:0x03ba), top: B:347:0x03ba }] */
    /* JADX WARN: Removed duplicated region for block: B:294:0x0487  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x048a A[Catch: Exception -> 0x04c0, TryCatch #0 {Exception -> 0x04c0, blocks: (B:288:0x03be, B:290:0x03ed, B:292:0x047e, B:295:0x0495, B:300:0x048a, B:316:0x0424, B:318:0x042a, B:332:0x0455, B:348:0x03ba), top: B:347:0x03ba }] */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0424 A[Catch: Exception -> 0x04c0, TryCatch #0 {Exception -> 0x04c0, blocks: (B:288:0x03be, B:290:0x03ed, B:292:0x047e, B:295:0x0495, B:300:0x048a, B:316:0x0424, B:318:0x042a, B:332:0x0455, B:348:0x03ba), top: B:347:0x03ba }] */
    /* JADX WARN: Removed duplicated region for block: B:346:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:355:0x035a  */
    /* JADX WARN: Removed duplicated region for block: B:359:0x02c0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x0271 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:363:0x0223 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0214  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0262  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x031f A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x036f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void ClockDisplay(final java.util.Calendar r160, final java.lang.String r161, final com.example.data.AzanTiming r162, final kotlin.jvm.functions.Function0<kotlin.Unit> r163, final kotlin.jvm.functions.Function0<kotlin.Unit> r164, kotlin.jvm.functions.Function0<kotlin.Unit> r165, androidx.compose.ui.Modifier r166, androidx.compose.runtime.Composer r167, final int r168, final int r169) {
        /*
            Method dump skipped, instructions count: 5424
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.ClockDisplay(java.util.Calendar, java.lang.String, com.example.data.AzanTiming, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    private static final Calendar ClockDisplay$lambda$38(MutableState<Calendar> mutableState) {
        return (Calendar) ((State) mutableState).getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ContentTransform ClockDisplay$lambda$71$lambda$70$lambda$64$lambda$56$lambda$55$lambda$54$lambda$53(AnimatedContentTransitionScope $this$AnimatedContent) {
        Intrinsics.checkNotNullParameter($this$AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically$default((FiniteAnimationSpec) null, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda2
            public final Object invoke(Object obj) {
                return Integer.valueOf(MainActivityKt.ClockDisplay$lambda$71$lambda$70$lambda$64$lambda$56$lambda$55$lambda$54$lambda$53$lambda$51(((Integer) obj).intValue()));
            }
        }, 1, (Object) null).plus(EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null)), EnterExitTransitionKt.slideOutVertically$default((FiniteAnimationSpec) null, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda3
            public final Object invoke(Object obj) {
                return Integer.valueOf(MainActivityKt.ClockDisplay$lambda$71$lambda$70$lambda$64$lambda$56$lambda$55$lambda$54$lambda$53$lambda$52(((Integer) obj).intValue()));
            }
        }, 1, (Object) null).plus(EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int ClockDisplay$lambda$71$lambda$70$lambda$64$lambda$56$lambda$55$lambda$54$lambda$53$lambda$51(int height) {
        return height;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int ClockDisplay$lambda$71$lambda$70$lambda$64$lambda$56$lambda$55$lambda$54$lambda$53$lambda$52(int height) {
        return -height;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final ContentTransform ClockDisplay$lambda$71$lambda$70$lambda$64$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59(AnimatedContentTransitionScope $this$AnimatedContent) {
        Intrinsics.checkNotNullParameter($this$AnimatedContent, "$this$AnimatedContent");
        return AnimatedContentKt.togetherWith(EnterExitTransitionKt.slideInVertically$default((FiniteAnimationSpec) null, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda20
            public final Object invoke(Object obj) {
                return Integer.valueOf(MainActivityKt.ClockDisplay$lambda$71$lambda$70$lambda$64$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$57(((Integer) obj).intValue()));
            }
        }, 1, (Object) null).plus(EnterExitTransitionKt.fadeIn$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null)), EnterExitTransitionKt.slideOutVertically$default((FiniteAnimationSpec) null, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda21
            public final Object invoke(Object obj) {
                return Integer.valueOf(MainActivityKt.ClockDisplay$lambda$71$lambda$70$lambda$64$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(((Integer) obj).intValue()));
            }
        }, 1, (Object) null).plus(EnterExitTransitionKt.fadeOut$default((FiniteAnimationSpec) null, 0.0f, 3, (Object) null)));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int ClockDisplay$lambda$71$lambda$70$lambda$64$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$57(int height) {
        return height;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final int ClockDisplay$lambda$71$lambda$70$lambda$64$lambda$63$lambda$62$lambda$61$lambda$60$lambda$59$lambda$58(int height) {
        return -height;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit ClockDisplay$lambda$71$lambda$70$lambda$68$lambda$67(Function0 $onToday) {
        $onToday.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x06f2  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x07b0  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x07d8  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0898  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x08f2  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0916  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x08a6  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x07db  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x09ab  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x078b  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x068b  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x0644  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x058a A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0536  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0221  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x0245  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x057a  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x063e  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0675  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AzanList(final com.example.ui.AzanViewModel r74, final com.example.ui.UIState r75, androidx.compose.ui.Modifier r76, androidx.compose.runtime.Composer r77, final int r78, final int r79) {
        /*
            Method dump skipped, instructions count: 2503
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.AzanList(com.example.ui.AzanViewModel, com.example.ui.UIState, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AzanList$lambda$77(MutableIntState $currentNextIndex$delegate) {
        return ((IntState) $currentNextIndex$delegate).getIntValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String AzanList$lambda$80(MutableState<String> mutableState) {
        return (String) ((State) mutableState).getValue();
    }

    private static final int AzanList$lambda$84(MutableIntState $expandedIndex$delegate) {
        return ((IntState) $expandedIndex$delegate).getIntValue();
    }

    private static final boolean AzanList$lambda$102$lambda$87(State<Boolean> state) {
        return ((Boolean) state.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0329  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0527  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01f2  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AzanList$lambda$102$lambda$94(final android.content.Context r94, androidx.compose.foundation.layout.ColumnScope r95, androidx.compose.runtime.Composer r96, int r97) {
        /*
            Method dump skipped, instructions count: 1325
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.AzanList$lambda$102$lambda$94(android.content.Context, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanList$lambda$102$lambda$94$lambda$93$lambda$92$lambda$91(Context $context) {
        Intent stopIntent = new Intent($context, (Class<?>) AzanForegroundService.class);
        stopIntent.setAction("STOP_AZAN");
        $context.startService(stopIntent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanList$lambda$102$lambda$101$lambda$96$lambda$95(boolean $isExpanded, int $index, MutableIntState $expandedIndex$delegate) {
        $expandedIndex$delegate.setIntValue($isExpanded ? -1 : $index);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanList$lambda$102$lambda$101$lambda$98$lambda$97(AzanViewModel $viewModel, Triple $triple, boolean enabled) {
        $viewModel.toggleAzan((String) $triple.getFirst(), enabled);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanList$lambda$102$lambda$101$lambda$100$lambda$99(boolean $isToday, List $prayedList, int $index, Triple $triple, AppStrings $strings, Context $context, AzanViewModel $viewModel) {
        if ($isToday && !((Boolean) $prayedList.get($index)).booleanValue()) {
            String str = (String) $triple.getThird();
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
            Intrinsics.checkNotNullExpressionValue(calendar, "getInstance(...)");
            Calendar prayerCal = parseTimeToCalendar(str, calendar);
            Calendar now = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
            if (now.before(prayerCal)) {
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String msg = String.format($strings.getPrayerTimeNotArrivedToast(), Arrays.copyOf(new Object[]{$triple.getSecond(), $triple.getThird()}, 2));
                Intrinsics.checkNotNullExpressionValue(msg, "format(...)");
                Toast.makeText($context, msg, 0).show();
                return Unit.INSTANCE;
            }
        }
        $viewModel.togglePrayerPrayed((String) $triple.getFirst());
        return Unit.INSTANCE;
    }

    public static /* synthetic */ List getRakatSegments$default(String str, AppStrings appStrings, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        return getRakatSegments(str, appStrings, z);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0020. Please report as an issue. */
    public static final List<Pair<String, Integer>> getRakatSegments(String prayerName, AppStrings strings, boolean isJumuah) {
        Intrinsics.checkNotNullParameter(prayerName, "prayerName");
        Intrinsics.checkNotNullParameter(strings, "strings");
        switch (prayerName.hashCode()) {
            case -1801299114:
                if (prayerName.equals("Maghrib")) {
                    return CollectionsKt.listOf(new Pair[]{new Pair(strings.getFarz(), 3), new Pair(strings.getSunnat(), 2), new Pair(strings.getNafil(), 2)});
                }
                return CollectionsKt.emptyList();
            case -668999403:
                if (prayerName.equals("Tahajjud")) {
                    return CollectionsKt.listOf(new Pair(strings.getNafil(), 2));
                }
                return CollectionsKt.emptyList();
            case 66144:
                if (prayerName.equals("Asr")) {
                    return CollectionsKt.listOf(new Pair[]{new Pair(strings.getSunnat(), 4), new Pair(strings.getFarz(), 4)});
                }
                return CollectionsKt.emptyList();
            case 2181987:
                if (prayerName.equals("Fajr")) {
                    return CollectionsKt.listOf(new Pair[]{new Pair(strings.getSunnat(), 2), new Pair(strings.getFarz(), 2)});
                }
                return CollectionsKt.emptyList();
            case 2288579:
                if (prayerName.equals("Isha")) {
                    return CollectionsKt.listOf(new Pair[]{new Pair(strings.getSunnat(), 4), new Pair(strings.getFarz(), 4), new Pair(strings.getSunnat(), 2), new Pair(strings.getNafil(), 2), new Pair(strings.getWitr(), 3), new Pair(strings.getNafil(), 2)});
                }
                return CollectionsKt.emptyList();
            case 66013467:
                if (prayerName.equals("Dhuhr")) {
                    return isJumuah ? CollectionsKt.listOf(new Pair[]{new Pair(strings.getSunnat(), 4), new Pair(strings.getFarz(), 2), new Pair(strings.getSunnat(), 4), new Pair(strings.getSunnat(), 2), new Pair(strings.getNafil(), 2)}) : CollectionsKt.listOf(new Pair[]{new Pair(strings.getSunnat(), 4), new Pair(strings.getFarz(), 4), new Pair(strings.getSunnat(), 2), new Pair(strings.getNafil(), 2)});
                }
                return CollectionsKt.emptyList();
            default:
                return CollectionsKt.emptyList();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:109:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03d4  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x04ab  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x034a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void AzanSlot(final java.lang.String r45, final java.lang.String r46, final java.lang.String r47, final boolean r48, final boolean r49, final androidx.compose.ui.graphics.vector.ImageVector r50, final boolean r51, final boolean r52, final kotlin.jvm.functions.Function0<kotlin.Unit> r53, androidx.compose.ui.Modifier r54, boolean r55, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r56, final kotlin.jvm.functions.Function0<kotlin.Unit> r57, androidx.compose.runtime.Composer r58, final int r59, final int r60, final int r61) {
        /*
            Method dump skipped, instructions count: 1247
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.AzanSlot(java.lang.String, java.lang.String, java.lang.String, boolean, boolean, androidx.compose.ui.graphics.vector.ImageVector, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int, int):void");
    }

    private static final float AzanSlot$lambda$104(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    private static final float AzanSlot$lambda$105(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanSlot$lambda$107$lambda$106(Function0 $onHeaderClick) {
        $onHeaderClick.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit AzanSlot$lambda$109$lambda$108(boolean $isNext, List $googleColors, State $flareProgress$delegate, ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        $this$drawWithContent.drawContent();
        if ($isNext) {
            float strokeWidth = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl((float) 1.5d));
            float halfStroke = strokeWidth / 2.0f;
            DrawStyle stroke = new Stroke(strokeWidth, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null);
            long corner = CornerRadiusKt.CornerRadius$default($this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(16)) - halfStroke, 0.0f, 2, (Object) null);
            long topLeft = OffsetKt.Offset(halfStroke, halfStroke);
            long borderSize = androidx.compose.ui.geometry.SizeKt.Size(Size.getWidth-impl($this$drawWithContent.getSize-NH-jbRc()) - strokeWidth, Size.getHeight-impl($this$drawWithContent.getSize-NH-jbRc()) - strokeWidth);
            float center = AzanSlot$lambda$104($flareProgress$delegate) * Size.getWidth-impl($this$drawWithContent.getSize-NH-jbRc());
            float span = Size.getWidth-impl($this$drawWithContent.getSize-NH-jbRc()) * 0.7f;
            DrawScope.drawRoundRect-ZuiqVtQ$default((DrawScope) $this$drawWithContent, Brush.Companion.horizontalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.Companion.getTransparent-0d7_KjU()), $googleColors.get(0), $googleColors.get(1), $googleColors.get(2), $googleColors.get(3), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), center - span, center + span, 0, 8, (Object) null), topLeft, borderSize, corner, 0.0f, stroke, (ColorFilter) null, 0, 208, (Object) null);
        } else {
            float strokeWidth2 = $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(1));
            float halfStroke2 = strokeWidth2 / 2.0f;
            DrawScope.drawRoundRect-u-Aw5IA$default((DrawScope) $this$drawWithContent, Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null), OffsetKt.Offset(halfStroke2, halfStroke2), androidx.compose.ui.geometry.SizeKt.Size(Size.getWidth-impl($this$drawWithContent.getSize-NH-jbRc()) - strokeWidth2, Size.getHeight-impl($this$drawWithContent.getSize-NH-jbRc()) - strokeWidth2), CornerRadiusKt.CornerRadius$default($this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(16)) - halfStroke2, 0.0f, 2, (Object) null), new Stroke(strokeWidth2, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), 0.0f, (ColorFilter) null, 0, 224, (Object) null);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0a09  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0a95  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0aa2  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0b60  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0abd  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0a9a  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0a88  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x097a  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0933  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0872  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x074c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0729  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0719  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x06b2 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0669  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0589  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x051e A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x04d5  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x043c  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03b1 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:142:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x039b  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0410  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x04cf  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0508  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0571  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0657  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0663  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x069c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0705  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0724  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0731  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x078f  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0921  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x092d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0964  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AzanSlot$lambda$132(boolean r174, boolean r175, androidx.compose.ui.graphics.vector.ImageVector r176, final java.lang.String r177, final java.lang.String r178, final com.example.ui.theme.AppStrings r179, java.lang.String r180, kotlin.jvm.functions.Function0 r181, boolean r182, final kotlin.jvm.functions.Function1 r183, final boolean r184, final boolean r185, androidx.compose.foundation.layout.ColumnScope r186, androidx.compose.runtime.Composer r187, int r188) {
        /*
            Method dump skipped, instructions count: 2918
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.AzanSlot$lambda$132(boolean, boolean, androidx.compose.ui.graphics.vector.ImageVector, java.lang.String, java.lang.String, com.example.ui.theme.AppStrings, java.lang.String, kotlin.jvm.functions.Function0, boolean, kotlin.jvm.functions.Function1, boolean, boolean, androidx.compose.foundation.layout.ColumnScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanSlot$lambda$132$lambda$131$lambda$121$lambda$120$lambda$113(boolean $prayed, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1135@47233L351:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1183126478, $changed, -1, "com.example.AzanSlot.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:1135)");
            }
            IconKt.Icon-ww6aTOc($prayed ? CheckCircleKt.getCheckCircle(Icons.Filled.INSTANCE) : androidx.compose.material.icons.outlined.CheckCircleKt.getCheckCircle(Icons.Outlined.INSTANCE), "Mark as Prayed", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(22)), $prayed ? ColorKt.Color(4280669030L) : com.example.ui.theme.ColorKt.getTextMuted(), $composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanSlot$lambda$132$lambda$131$lambda$121$lambda$120$lambda$115$lambda$114(Function1 $onToggle, boolean $enabled) {
        $onToggle.invoke(Boolean.valueOf(!$enabled));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanSlot$lambda$132$lambda$131$lambda$121$lambda$120$lambda$119(boolean $enabled, Composer $composer, int $changed) {
        Object obj;
        Composer composer;
        int i;
        ComposerKt.sourceInformation($composer, "C:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1003233015, $changed, -1, "com.example.AzanSlot.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:1145)");
            }
            if ($enabled) {
                $composer.startReplaceGroup(-1362610173);
                ComposerKt.sourceInformation($composer, "1149@48059L11,1146@47850L264");
                IconKt.Icon-ww6aTOc(VolumeUpKt.getVolumeUp(Icons.Filled.INSTANCE), "Toggle Audio", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSecondary-0d7_KjU(), $composer, 48, 4);
                $composer.endReplaceGroup();
            } else {
                $composer.startReplaceGroup(-1362238669);
                ComposerKt.sourceInformation($composer, "1155@48355L880,1152@48184L1560");
                Modifier modifier = SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(24));
                ComposerKt.sourceInformationMarkerStart($composer, 2034272615, "CC(remember):MainActivity.kt#9igjgp");
                Object rememberedValue = $composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    obj = new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj2) {
                            return MainActivityKt.AzanSlot$lambda$132$lambda$131$lambda$121$lambda$120$lambda$119$lambda$117$lambda$116((ContentDrawScope) obj2);
                        }
                    };
                    $composer.updateRememberedValue(obj);
                } else {
                    obj = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                Modifier drawWithContent = DrawModifierKt.drawWithContent(modifier, (Function1) obj);
                Alignment center = Alignment.Companion.getCenter();
                ComposerKt.sourceInformationMarkerStart($composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy maybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart($composer, -1323940314, "CC(Layout)P(!1,2)78@3182L23,81@3333L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash($composer, 0);
                CompositionLocalMap currentCompositionLocalMap = $composer.getCurrentCompositionLocalMap();
                Modifier materializeModifier = ComposedModifierKt.materializeModifier($composer, drawWithContent);
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
                Composer composer2 = Updater.constructor-impl($composer);
                Updater.set-impl(composer2, maybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.set-impl(composer2, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2 setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (!composer2.getInserting()) {
                    composer = $composer;
                    i = 48;
                    if (Intrinsics.areEqual(composer2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                        int i3 = (i2 >> 6) & 14;
                        Composer composer3 = composer;
                        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                        BoxScope boxScope = BoxScopeInstance.INSTANCE;
                        int i4 = ((i >> 6) & 112) | 6;
                        ComposerKt.sourceInformationMarkerStart(composer3, 1035514349, "C1171@49381L329:MainActivity.kt#to5c3");
                        IconKt.Icon-ww6aTOc(VolumeUpKt.getVolumeUp(Icons.Filled.INSTANCE), "Toggle Audio", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), Color.Companion.getWhite-0d7_KjU(), composer3, 3504, 0);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        ComposerKt.sourceInformationMarkerEnd(composer);
                        $composer.endReplaceGroup();
                    }
                } else {
                    composer = $composer;
                    i = 48;
                }
                composer2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composer2.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                Updater.set-impl(composer2, materializeModifier, ComposeUiNode.Companion.getSetModifier());
                int i32 = (i2 >> 6) & 14;
                Composer composer32 = composer;
                ComposerKt.sourceInformationMarkerStart(composer32, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScope boxScope2 = BoxScopeInstance.INSTANCE;
                int i42 = ((i >> 6) & 112) | 6;
                ComposerKt.sourceInformationMarkerStart(composer32, 1035514349, "C1171@49381L329:MainActivity.kt#to5c3");
                IconKt.Icon-ww6aTOc(VolumeUpKt.getVolumeUp(Icons.Filled.INSTANCE), "Toggle Audio", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(14)), Color.Companion.getWhite-0d7_KjU(), composer32, 3504, 0);
                ComposerKt.sourceInformationMarkerEnd(composer32);
                ComposerKt.sourceInformationMarkerEnd(composer32);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                $composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit AzanSlot$lambda$132$lambda$131$lambda$121$lambda$120$lambda$119$lambda$117$lambda$116(ContentDrawScope $this$drawWithContent) {
        Intrinsics.checkNotNullParameter($this$drawWithContent, "$this$drawWithContent");
        DrawScope.drawCircle-VaOC9Bg$default((DrawScope) $this$drawWithContent, Color.Companion.getRed-0d7_KjU(), Size.getMinDimension-impl($this$drawWithContent.getSize-NH-jbRc()) / 2.0f, 0L, 0.0f, new Stroke($this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(2)), 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 108, (Object) null);
        DrawScope.drawLine-NGM6Ib0$default((DrawScope) $this$drawWithContent, Color.Companion.getRed-0d7_KjU(), OffsetKt.Offset($this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(4)), $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(4))), OffsetKt.Offset(Size.getWidth-impl($this$drawWithContent.getSize-NH-jbRc()) - $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(4)), Size.getHeight-impl($this$drawWithContent.getSize-NH-jbRc()) - $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(4))), $this$drawWithContent.toPx-0680j_4(Dp.constructor-impl(2)), 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
        $this$drawWithContent.drawContent();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0a9c  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0aa8  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0adf  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0c27  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x0af5  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0aae  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x0444 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x03fb  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x01dd A[LOOP:0: B:23:0x01d7->B:25:0x01dd, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x042e  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x057e  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0834  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0840  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0846  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final kotlin.Unit AzanSlot$lambda$132$lambda$131$lambda$130(java.lang.String r158, java.lang.String r159, com.example.ui.theme.AppStrings r160, androidx.compose.animation.AnimatedVisibilityScope r161, androidx.compose.runtime.Composer r162, int r163) {
        /*
            Method dump skipped, instructions count: 3117
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.AzanSlot$lambda$132$lambda$131$lambda$130(java.lang.String, java.lang.String, com.example.ui.theme.AppStrings, androidx.compose.animation.AnimatedVisibilityScope, androidx.compose.runtime.Composer, int):kotlin.Unit");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x01fc  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void EidInfoRow(androidx.compose.ui.Modifier r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 528
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.EidInfoRow(androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final void EidCard(final String title, final String date, final String day, Modifier modifier, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        Modifier modifier3;
        Composer $composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(date, "date");
        Intrinsics.checkNotNullParameter(day, "day");
        Composer $composer3 = $composer.startRestartGroup(418922687);
        ComposerKt.sourceInformation($composer3, "C(EidCard)P(3)1331@57281L66,1333@57425L38,1334@57470L908,1328@57130L1248:MainActivity.kt#to5c3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer3.changed(title) ? 4 : 2;
        }
        if (($changed & 48) == 0) {
            $dirty |= $composer3.changed(date) ? 32 : 16;
        }
        if (($changed & 384) == 0) {
            $dirty |= $composer3.changed(day) ? 256 : 128;
        }
        int i2 = i & 8;
        if (i2 != 0) {
            $dirty |= 3072;
            modifier2 = modifier;
        } else if (($changed & 3072) == 0) {
            modifier2 = modifier;
            $dirty |= $composer3.changed(modifier2) ? 2048 : 1024;
        } else {
            modifier2 = modifier;
        }
        if (($dirty & 1171) == 1170 && $composer3.getSkipping()) {
            $composer3.skipToGroupEnd();
            modifier3 = modifier2;
            $composer2 = $composer3;
        } else {
            Modifier modifier4 = i2 != 0 ? (Modifier) Modifier.Companion : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(418922687, $dirty, -1, "com.example.EidCard (MainActivity.kt:1327)");
            }
            modifier3 = modifier4;
            CardKt.Card(BorderKt.border-xT4_qwU(modifier4, Dp.constructor-impl(1), Color.copy-wmQWz5c$default(Color.Companion.getWhite-0d7_KjU(), 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(14))), RoundedCornerShapeKt.RoundedCornerShape-0680j_4(Dp.constructor-impl(14)), CardDefaults.INSTANCE.cardColors-ro_MJ88(Color.copy-wmQWz5c$default(ColorKt.Color(4279112479L), 0.35f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0L, 0L, 0L, $composer3, (CardDefaults.$stable << 12) | 6, 14), CardDefaults.INSTANCE.cardElevation-aqJV_2Y(Dp.constructor-impl(0), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, $composer3, (CardDefaults.$stable << 18) | 6, 62), (BorderStroke) null, ComposableLambdaKt.rememberComposableLambda(449089969, true, new Function3() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda36
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainActivityKt.EidCard$lambda$137(title, date, day, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer3, 54), $composer3, 196608, 16);
            $composer2 = $composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
            final Modifier modifier5 = modifier3;
            endRestartGroup.updateScope(new Function2() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda37
                public final Object invoke(Object obj, Object obj2) {
                    return MainActivityKt.EidCard$lambda$138(title, date, day, modifier5, $changed, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit EidCard$lambda$137(String $title, String $date, String $day, ColumnScope $this$Card, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Card, "$this$Card");
        ComposerKt.sourceInformation($composer, "C1335@57480L892:MainActivity.kt#to5c3");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(449089969, $changed, -1, "com.example.EidCard.<anonymous> (MainActivity.kt:1335)");
            }
            Modifier modifier = PaddingKt.padding-3ABfNKs(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), Dp.constructor-impl(8));
            Alignment.Horizontal centerHorizontally = Alignment.Companion.getCenterHorizontally();
            Arrangement.Vertical center = Arrangement.INSTANCE.getCenter();
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
                $composer.createNode(constructor);
            } else {
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
            ComposerKt.sourceInformationMarkerStart($composer, -361710594, "C1346@57879L11,1342@57724L234,1349@57971L40,1350@58024L162,1356@58199L163:MainActivity.kt#to5c3");
            TextKt.Text--4IGK_g($title, (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), TextUnitKt.getSp(13), (FontStyle) null, FontWeight.Companion.getBlack(), (FontFamily) null, 0L, (TextDecoration) null, TextAlign.box-impl(TextAlign.Companion.getCenter-e0LSkKk()), 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 199680, 0, 130514);
            SpacerKt.Spacer(SizeKt.height-3ABfNKs(Modifier.Companion, Dp.constructor-impl(2)), $composer, 6);
            TextKt.Text--4IGK_g($date, (Modifier) null, com.example.ui.theme.ColorKt.getTextColor(), TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 200064, 0, 131026);
            TextKt.Text--4IGK_g($day, (Modifier) null, com.example.ui.theme.ColorKt.getTextMuted(), TextUnitKt.getSp(10), (FontStyle) null, FontWeight.Companion.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 200064, 0, 131026);
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

    public static final Modifier appBackground(Modifier $this$appBackground, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$appBackground, "<this>");
        ComposerKt.sourceInformationMarkerStart($composer, -927688734, "C(appBackground)1368@58472L11:MainActivity.kt#to5c3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-927688734, $changed, -1, "com.example.appBackground (MainActivity.kt:1367)");
        }
        long primaryColor = MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU();
        Modifier m2animatedWavingLines4WTKRHQ = m2animatedWavingLines4WTKRHQ(m3islamicStarBackground4WTKRHQ(BackgroundKt.background$default(BackgroundKt.background$default($this$appBackground, Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4278321925L)), Color.box-impl(ColorKt.Color(4278519563L)), Color.box-impl(ColorKt.Color(4278321925L))}), 0.0f, 0.0f, 0, 14, (Object) null), (Shape) null, 0.0f, 6, (Object) null), Brush.Companion.radialGradient-P_Vx-Ks$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(Color.copy-wmQWz5c$default(primaryColor, 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null)), Color.box-impl(Color.Companion.getTransparent-0d7_KjU())}), OffsetKt.Offset(500.0f, 300.0f), 900.0f, 0, 8, (Object) null), (Shape) null, 0.0f, 6, (Object) null), primaryColor), primaryColor);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        return m2animatedWavingLines4WTKRHQ;
    }

    /* renamed from: islamicStarBackground-4WTKRHQ, reason: not valid java name */
    public static final Modifier m3islamicStarBackground4WTKRHQ(Modifier $this$islamicStarBackground_u2d4WTKRHQ, final long primaryColor) {
        Intrinsics.checkNotNullParameter($this$islamicStarBackground_u2d4WTKRHQ, "$this$islamicStarBackground");
        return DrawModifierKt.drawBehind($this$islamicStarBackground_u2d4WTKRHQ, new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda29
            public final Object invoke(Object obj) {
                return MainActivityKt.islamicStarBackground_4WTKRHQ$lambda$145(primaryColor, (DrawScope) obj);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit islamicStarBackground_4WTKRHQ$lambda$145(long $primaryColor, DrawScope $this$drawBehind) {
        Intrinsics.checkNotNullParameter($this$drawBehind, "$this$drawBehind");
        float width = Size.getWidth-impl($this$drawBehind.getSize-NH-jbRc());
        float height = Size.getHeight-impl($this$drawBehind.getSize-NH-jbRc());
        long moonCenter = OffsetKt.Offset(width * 0.85f, height * 0.18f);
        float moonRadius = width * 0.15f;
        long cutoutCenter = OffsetKt.Offset(0.79f * width, height * 0.15f);
        Path moonPath = AndroidPath_androidKt.Path();
        Path.addOval$default(moonPath, RectKt.Rect-3MmeM6k(moonCenter, moonRadius), (Path.Direction) null, 2, (Object) null);
        Path Path = AndroidPath_androidKt.Path();
        Path.addOval$default(Path, RectKt.Rect-3MmeM6k(cutoutCenter, moonRadius * 1.05f), (Path.Direction) null, 2, (Object) null);
        Path cutoutPath = Path;
        Path Path2 = AndroidPath_androidKt.Path();
        Path2.op-N5in7k0(moonPath, cutoutPath, PathOperation.Companion.getDifference-b3I0S0c());
        DrawScope.drawPath-LG529CI$default($this$drawBehind, Path2, Color.copy-wmQWz5c$default($primaryColor, 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        Path silhouettePath = AndroidPath_androidKt.Path();
        silhouettePath.moveTo(0.0f, height);
        Float valueOf = Float.valueOf(0.08f);
        silhouettePath.lineTo(0.0f, height - (height * 0.08f));
        silhouettePath.quadraticBezierTo(width * 0.12f, height - (height * 0.14f), width * 0.25f, height - (height * 0.08f));
        silhouettePath.lineTo(width * 0.28f, height - (height * 0.08f));
        silhouettePath.lineTo(0.28f * width, height - (height * 0.22f));
        silhouettePath.lineTo(0.3f * width, height - (height * 0.25f));
        silhouettePath.lineTo(width * 0.32f, height - (height * 0.22f));
        silhouettePath.lineTo(width * 0.32f, height - (height * 0.08f));
        silhouettePath.lineTo(0.35f * width, height - (height * 0.08f));
        silhouettePath.cubicTo(0.4f * width, height - (height * 0.26f), 0.6f * width, height - (0.26f * height), width * 0.65f, height - (height * 0.08f));
        silhouettePath.lineTo(width * 0.68f, height - (height * 0.08f));
        silhouettePath.lineTo(0.68f * width, height - (height * 0.22f));
        silhouettePath.lineTo(0.7f * width, height - (height * 0.25f));
        silhouettePath.lineTo(width * 0.72f, height - (height * 0.22f));
        silhouettePath.lineTo(0.72f * width, height - (height * 0.08f));
        Float valueOf2 = Float.valueOf(0.75f);
        silhouettePath.lineTo(0.75f * width, height - (height * 0.08f));
        silhouettePath.quadraticBezierTo(width * 0.88f, height - (0.14f * height), width, height - (0.08f * height));
        silhouettePath.lineTo(width, height);
        silhouettePath.close();
        DrawScope.drawPath-LG529CI$default($this$drawBehind, silhouettePath, Color.copy-wmQWz5c$default($primaryColor, 0.05f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 60, (Object) null);
        float outlineTop = height * 0.25f;
        Path outlinePath = AndroidPath_androidKt.Path();
        outlinePath.moveTo(0.0f, height);
        Float valueOf3 = Float.valueOf(0.1f);
        outlinePath.lineTo(0.0f, (height * 0.1f) + outlineTop);
        outlinePath.cubicTo(0.0f, outlineTop, width, outlineTop, width, outlineTop + (0.1f * height));
        float width2 = width;
        outlinePath.lineTo(width2, height);
        DrawScope.drawPath-LG529CI$default($this$drawBehind, outlinePath, Color.copy-wmQWz5c$default($primaryColor, 0.1f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, new Stroke(5.0f, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 52, (Object) null);
        List<Pair> stars = CollectionsKt.listOf(new Pair[]{TuplesKt.to(valueOf3, Float.valueOf(0.15f)), TuplesKt.to(Float.valueOf(0.88f), valueOf3), TuplesKt.to(Float.valueOf(0.18f), Float.valueOf(0.42f)), TuplesKt.to(Float.valueOf(0.85f), Float.valueOf(0.38f)), TuplesKt.to(Float.valueOf(0.12f), Float.valueOf(0.65f)), TuplesKt.to(Float.valueOf(0.78f), valueOf2), TuplesKt.to(Float.valueOf(0.5f), valueOf), TuplesKt.to(valueOf2, Float.valueOf(0.32f)), TuplesKt.to(Float.valueOf(0.25f), Float.valueOf(0.22f)), TuplesKt.to(Float.valueOf(0.95f), Float.valueOf(0.58f)), TuplesKt.to(valueOf, Float.valueOf(0.55f))});
        for (Pair pair : stars) {
            float floatValue = ((Number) pair.component1()).floatValue();
            float floatValue2 = ((Number) pair.component2()).floatValue();
            float f = floatValue * width2;
            float f2 = floatValue2 * height;
            DrawScope.drawCircle-VaOC9Bg$default($this$drawBehind, Color.copy-wmQWz5c$default($primaryColor, 0.08f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 16.0f, OffsetKt.Offset(f, f2), 0.0f, (DrawStyle) null, (ColorFilter) null, 0, 120, (Object) null);
            DrawScope.drawLine-NGM6Ib0$default($this$drawBehind, Color.copy-wmQWz5c$default($primaryColor, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), OffsetKt.Offset(f - 8.0f, f2), OffsetKt.Offset(f + 8.0f, f2), 1.5f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
            DrawScope.drawLine-NGM6Ib0$default($this$drawBehind, Color.copy-wmQWz5c$default($primaryColor, 0.3f, 0.0f, 0.0f, 0.0f, 14, (Object) null), OffsetKt.Offset(f, f2 - 8.0f), OffsetKt.Offset(f, f2 + 8.0f), 1.5f, 0, (PathEffect) null, 0.0f, (ColorFilter) null, 0, 496, (Object) null);
            width2 = width2;
            cutoutPath = cutoutPath;
            height = height;
            stars = stars;
            moonCenter = moonCenter;
        }
        return Unit.INSTANCE;
    }

    public static final String formatTo12Hour(String time24) {
        Intrinsics.checkNotNullParameter(time24, "time24");
        if (Intrinsics.areEqual(time24, "--:--") || !StringsKt.contains$default(time24, ":", false, 2, (Object) null)) {
            return time24;
        }
        List parts = StringsKt.split$default(time24, new String[]{":"}, false, 0, 6, (Object) null);
        if (parts.size() < 2) {
            return time24;
        }
        Integer intOrNull = StringsKt.toIntOrNull((String) parts.get(0));
        if (intOrNull == null) {
            return time24;
        }
        int hour = intOrNull.intValue();
        Integer intOrNull2 = StringsKt.toIntOrNull((String) parts.get(1));
        if (intOrNull2 == null) {
            return time24;
        }
        int minute = intOrNull2.intValue();
        int displayHour = 12;
        String suffix = hour >= 12 ? "PM" : "AM";
        if (hour != 0) {
            displayHour = hour > 12 ? hour - 12 : hour;
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String format = String.format(Locale.US, "%02d:%02d %s", Arrays.copyOf(new Object[]{Integer.valueOf(displayHour), Integer.valueOf(minute), suffix}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(...)");
        return format;
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0271  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void PrayerTimeDisplay(final java.lang.String r91, final boolean r92, androidx.compose.runtime.Composer r93, final int r94) {
        /*
            Method dump skipped, instructions count: 817
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt.PrayerTimeDisplay(java.lang.String, boolean, androidx.compose.runtime.Composer, int):void");
    }

    /* renamed from: animatedWavingLines-4WTKRHQ, reason: not valid java name */
    public static final Modifier m2animatedWavingLines4WTKRHQ(Modifier $this$animatedWavingLines_u2d4WTKRHQ, final long primaryColor) {
        Intrinsics.checkNotNullParameter($this$animatedWavingLines_u2d4WTKRHQ, "$this$animatedWavingLines");
        return ComposedModifierKt.composed$default($this$animatedWavingLines_u2d4WTKRHQ, (Function1) null, new Function3() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda43
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MainActivityKt.animatedWavingLines_4WTKRHQ$lambda$151(primaryColor, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, 1, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Modifier animatedWavingLines_4WTKRHQ$lambda$151(final long $primaryColor, Modifier $this$composed, Composer $composer, int $changed) {
        Object obj;
        Intrinsics.checkNotNullParameter($this$composed, "$this$composed");
        $composer.startReplaceGroup(1534304704);
        ComposerKt.sourceInformation($composer, "C1559@64891L42,1560@64970L308,1570@65300L899:MainActivity.kt#to5c3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1534304704, $changed, -1, "com.example.animatedWavingLines.<anonymous> (MainActivity.kt:1559)");
        }
        InfiniteTransition infiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("wave", $composer, 6, 0);
        final State phase$delegate = InfiniteTransitionKt.animateFloat(infiniteTransition, 0.0f, 6.2831855f, AnimationSpecKt.infiniteRepeatable-9IiC70o$default(AnimationSpecKt.tween$default(15000, 0, EasingKt.getLinearEasing(), 2, (Object) null), RepeatMode.Restart, 0L, 4, (Object) null), "phase", $composer, InfiniteTransition.$stable | 24624 | (InfiniteRepeatableSpec.$stable << 9), 0);
        ComposerKt.sourceInformationMarkerStart($composer, 1293052995, "CC(remember):MainActivity.kt#9igjgp");
        boolean changed = $composer.changed(phase$delegate) | $composer.changed($primaryColor);
        Object rememberedValue = $composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            obj = new Function1() { // from class: com.example.MainActivityKt$$ExternalSyntheticLambda11
                public final Object invoke(Object obj2) {
                    return MainActivityKt.animatedWavingLines_4WTKRHQ$lambda$151$lambda$150$lambda$149($primaryColor, phase$delegate, (DrawScope) obj2);
                }
            };
            $composer.updateRememberedValue(obj);
        } else {
            obj = rememberedValue;
        }
        ComposerKt.sourceInformationMarkerEnd($composer);
        Modifier drawBehind = DrawModifierKt.drawBehind($this$composed, (Function1) obj);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        $composer.endReplaceGroup();
        return drawBehind;
    }

    private static final float animatedWavingLines_4WTKRHQ$lambda$151$lambda$148(State<Float> state) {
        return ((Number) state.getValue()).floatValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit animatedWavingLines_4WTKRHQ$lambda$151$lambda$150$lambda$149(long $primaryColor, State $phase$delegate, DrawScope $this$drawBehind) {
        int step;
        DrawScope drawScope = $this$drawBehind;
        Intrinsics.checkNotNullParameter(drawScope, "$this$drawBehind");
        float width = Size.getWidth-impl(drawScope.getSize-NH-jbRc());
        float height = Size.getHeight-impl(drawScope.getSize-NH-jbRc());
        float centerY = height * 0.7f;
        int i = 0;
        while (i < 3) {
            float amplitude = (i * 20.0f) + 25.0f;
            Path path = AndroidPath_androidKt.Path();
            path.moveTo(0.0f, centerY);
            while (true) {
                float x = (step / 50) * width;
                float angle = ((x / width) * 6.2831855f * 1.5f) + animatedWavingLines_4WTKRHQ$lambda$151$lambda$148($phase$delegate) + (i * 1.5f);
                float y = (((float) Math.sin(angle)) * amplitude) + centerY;
                path.lineTo(x, y);
                step = step != 50 ? step + 1 : 0;
            }
            DrawScope.drawPath-LG529CI$default(drawScope, path, Color.copy-wmQWz5c$default($primaryColor, (i * 0.015f) + 0.03f, 0.0f, 0.0f, 0.0f, 14, (Object) null), 0.0f, new Stroke(3.0f, 0.0f, 0, 0, (PathEffect) null, 30, (DefaultConstructorMarker) null), (ColorFilter) null, 0, 52, (Object) null);
            i++;
            drawScope = $this$drawBehind;
        }
        return Unit.INSTANCE;
    }
}
