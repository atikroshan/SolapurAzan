package com.example.ui;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.automirrored.filled.ArrowBackKt;
import androidx.compose.material.icons.filled.CloseKt;
import androidx.compose.material.icons.filled.KeyboardArrowLeftKt;
import androidx.compose.material.icons.filled.KeyboardArrowRightKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.example.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* compiled from: TrackerBoard.kt */
@Metadata(k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class ComposableSingletons$TrackerBoardKt {
    public static final ComposableSingletons$TrackerBoardKt INSTANCE = new ComposableSingletons$TrackerBoardKt();
    private static Function2<Composer, Integer, Unit> lambda$1535370718 = ComposableLambdaKt.composableLambdaInstance(1535370718, false, new Function2() { // from class: com.example.ui.ComposableSingletons$TrackerBoardKt$$ExternalSyntheticLambda0
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TrackerBoardKt.lambda_1535370718$lambda$0((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: lambda$-1098904675, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f2lambda$1098904675 = ComposableLambdaKt.composableLambdaInstance(-1098904675, false, new Function2() { // from class: com.example.ui.ComposableSingletons$TrackerBoardKt$$ExternalSyntheticLambda1
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TrackerBoardKt.lambda__1098904675$lambda$1((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$2054694189 = ComposableLambdaKt.composableLambdaInstance(2054694189, false, new Function2() { // from class: com.example.ui.ComposableSingletons$TrackerBoardKt$$ExternalSyntheticLambda2
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TrackerBoardKt.lambda_2054694189$lambda$2((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$1815129188 = ComposableLambdaKt.composableLambdaInstance(1815129188, false, new Function2() { // from class: com.example.ui.ComposableSingletons$TrackerBoardKt$$ExternalSyntheticLambda3
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$TrackerBoardKt.lambda_1815129188$lambda$3((Composer) obj, ((Integer) obj2).intValue());
        }
    });

    /* renamed from: getLambda$-1098904675$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4getLambda$1098904675$app() {
        return f2lambda$1098904675;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1535370718$app() {
        return lambda$1535370718;
    }

    public final Function2<Composer, Integer, Unit> getLambda$1815129188$app() {
        return lambda$1815129188;
    }

    public final Function2<Composer, Integer, Unit> getLambda$2054694189$app() {
        return lambda$2054694189;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1535370718$lambda$0(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C292@12150L11,289@11947L317:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1535370718, $changed, -1, "com.example.ui.ComposableSingletons$TrackerBoardKt.lambda$1535370718.<anonymous> (TrackerBoard.kt:289)");
            }
            IconKt.Icon-ww6aTOc(ArrowBackKt.getArrowBack(Icons.AutoMirrored.Filled.INSTANCE), "Back", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(16)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), $composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__1098904675$lambda$1(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1090@55324L74:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1098904675, $changed, -1, "com.example.ui.ComposableSingletons$TrackerBoardKt.lambda$-1098904675.<anonymous> (TrackerBoard.kt:1090)");
            }
            IconKt.Icon-ww6aTOc(CloseKt.getClose(Icons.Filled.INSTANCE), "Close", (Modifier) null, Color.Companion.getWhite-0d7_KjU(), $composer, 3120, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_2054694189$lambda$2(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1370@67554L11,1367@67346L257:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2054694189, $changed, -1, "com.example.ui.ComposableSingletons$TrackerBoardKt.lambda$2054694189.<anonymous> (TrackerBoard.kt:1367)");
            }
            IconKt.Icon-ww6aTOc(KeyboardArrowLeftKt.getKeyboardArrowLeft(Icons.Filled.INSTANCE), "Previous Month", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_1815129188$lambda$3(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C1404@69144L11,1401@68939L254:TrackerBoard.kt#naom5h");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1815129188, $changed, -1, "com.example.ui.ComposableSingletons$TrackerBoardKt.lambda$1815129188.<anonymous> (TrackerBoard.kt:1401)");
            }
            IconKt.Icon-ww6aTOc(KeyboardArrowRightKt.getKeyboardArrowRight(Icons.Filled.INSTANCE), "Next Month", (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), $composer, 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
