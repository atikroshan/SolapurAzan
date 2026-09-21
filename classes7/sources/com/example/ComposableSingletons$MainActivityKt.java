package com.example;

import android.content.Context;
import android.os.Build;
import androidx.activity.compose.ActivityResultRegistryKt;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.DateRangeKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocal;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import com.example.data.AzanDatabase;
import com.example.data.AzanRepository;
import com.example.data.PreferencesRepository;
import com.example.service.AlarmScheduler;
import com.example.ui.AzanViewModel;
import com.example.ui.UIState;
import com.example.ui.theme.AppStrings;
import com.example.ui.theme.StringsKt;
import com.example.ui.theme.ThemeKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: MainActivity.kt */
@Metadata(k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class ComposableSingletons$MainActivityKt {
    public static final ComposableSingletons$MainActivityKt INSTANCE = new ComposableSingletons$MainActivityKt();

    /* renamed from: lambda$-601144069, reason: not valid java name */
    private static Function2<Composer, Integer, Unit> f0lambda$601144069 = ComposableLambdaKt.composableLambdaInstance(-601144069, false, new Function2() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda4
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainActivityKt.lambda__601144069$lambda$11((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function2<Composer, Integer, Unit> lambda$580705031 = ComposableLambdaKt.composableLambdaInstance(580705031, false, new Function2() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda5
        public final Object invoke(Object obj, Object obj2) {
            return ComposableSingletons$MainActivityKt.lambda_580705031$lambda$12((Composer) obj, ((Integer) obj2).intValue());
        }
    });
    private static Function4<AnimatedContentScope, Character, Composer, Integer, Unit> lambda$2071870587 = ComposableLambdaKt.composableLambdaInstance(2071870587, false, new Function4() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda6
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$MainActivityKt.lambda_2071870587$lambda$13((AnimatedContentScope) obj, ((Character) obj2).charValue(), (Composer) obj3, ((Integer) obj4).intValue());
        }
    });

    /* renamed from: lambda$-76186299, reason: not valid java name */
    private static Function4<AnimatedContentScope, Character, Composer, Integer, Unit> f1lambda$76186299 = ComposableLambdaKt.composableLambdaInstance(-76186299, false, new Function4() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda7
        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            return ComposableSingletons$MainActivityKt.lambda__76186299$lambda$14((AnimatedContentScope) obj, ((Character) obj2).charValue(), (Composer) obj3, ((Integer) obj4).intValue());
        }
    });
    private static Function3<RowScope, Composer, Integer, Unit> lambda$893846484 = ComposableLambdaKt.composableLambdaInstance(893846484, false, new Function3() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda8
        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ComposableSingletons$MainActivityKt.lambda_893846484$lambda$15((RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
        }
    });

    /* renamed from: getLambda$-601144069$app, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m0getLambda$601144069$app() {
        return f0lambda$601144069;
    }

    /* renamed from: getLambda$-76186299$app, reason: not valid java name */
    public final Function4<AnimatedContentScope, Character, Composer, Integer, Unit> m1getLambda$76186299$app() {
        return f1lambda$76186299;
    }

    public final Function4<AnimatedContentScope, Character, Composer, Integer, Unit> getLambda$2071870587$app() {
        return lambda$2071870587;
    }

    public final Function2<Composer, Integer, Unit> getLambda$580705031$app() {
        return lambda$580705031;
    }

    public final Function3<RowScope, Composer, Integer, Unit> getLambda$893846484$app() {
        return lambda$893846484;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__601144069$lambda$11(Composer $composer, int $changed) {
        Object obj;
        Object obj2;
        Object obj3;
        Object obj4;
        CreationExtras creationExtras;
        Object obj5;
        ComposableSingletons$MainActivityKt$lambda$601144069$1$1$1 composableSingletons$MainActivityKt$lambda$601144069$1$1$1;
        ComposerKt.sourceInformation($composer, "C107@4502L7,123@5240L46,124@5310L69,125@5404L43,126@5476L36,133@5829L28,135@5890L739,135@5871L758:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-601144069, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-601144069.<anonymous> (MainActivity.kt:107)");
            }
            CompositionLocal localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object consume = $composer.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer);
            final Context context = (Context) consume;
            if (Build.VERSION.SDK_INT >= 33) {
                $composer.startReplaceGroup(1330815992);
                ComposerKt.sourceInformation($composer, "112@4791L79,110@4663L207,116@4925L278,116@4904L299");
                ActivityResultContract requestPermission = new ActivityResultContracts.RequestPermission();
                ComposerKt.sourceInformationMarkerStart($composer, 2121145290, "CC(remember):MainActivity.kt#9igjgp");
                Object rememberedValue = $composer.rememberedValue();
                if (rememberedValue == Composer.Companion.getEmpty()) {
                    obj5 = new Function1() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda1
                        public final Object invoke(Object obj6) {
                            Unit unit;
                            ((Boolean) obj6).booleanValue();
                            unit = Unit.INSTANCE;
                            return unit;
                        }
                    };
                    $composer.updateRememberedValue(obj5);
                } else {
                    obj5 = rememberedValue;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                ManagedActivityResultLauncher permissionLauncher = ActivityResultRegistryKt.rememberLauncherForActivityResult(requestPermission, (Function1) obj5, $composer, 48);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart($composer, 2121149777, "CC(remember):MainActivity.kt#9igjgp");
                boolean changedInstance = $composer.changedInstance(context) | $composer.changedInstance(permissionLauncher);
                Object rememberedValue2 = $composer.rememberedValue();
                if (changedInstance || rememberedValue2 == Composer.Companion.getEmpty()) {
                    composableSingletons$MainActivityKt$lambda$601144069$1$1$1 = new ComposableSingletons$MainActivityKt$lambda$601144069$1$1$1(context, permissionLauncher, null);
                    $composer.updateRememberedValue(composableSingletons$MainActivityKt$lambda$601144069$1$1$1);
                } else {
                    composableSingletons$MainActivityKt$lambda$601144069$1$1$1 = rememberedValue2;
                }
                ComposerKt.sourceInformationMarkerEnd($composer);
                EffectsKt.LaunchedEffect(unit, (Function2) composableSingletons$MainActivityKt$lambda$601144069$1$1$1, $composer, 6);
            } else {
                $composer.startReplaceGroup(1326238439);
            }
            $composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart($composer, 2121159625, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue3 = $composer.rememberedValue();
            if (rememberedValue3 == Composer.Companion.getEmpty()) {
                obj = AzanDatabase.Companion.getDatabase(context);
                $composer.updateRememberedValue(obj);
            } else {
                obj = rememberedValue3;
            }
            AzanDatabase db = (AzanDatabase) obj;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 2121161888, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue4 = $composer.rememberedValue();
            if (rememberedValue4 == Composer.Companion.getEmpty()) {
                obj2 = new AzanRepository(context, db.azanDao(), db.prayerLogDao());
                $composer.updateRememberedValue(obj2);
            } else {
                obj2 = rememberedValue4;
            }
            final AzanRepository repo = (AzanRepository) obj2;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 2121164870, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue5 = $composer.rememberedValue();
            if (rememberedValue5 == Composer.Companion.getEmpty()) {
                obj3 = new PreferencesRepository(context);
                $composer.updateRememberedValue(obj3);
            } else {
                obj3 = rememberedValue5;
            }
            final PreferencesRepository prefs = (PreferencesRepository) obj3;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ComposerKt.sourceInformationMarkerStart($composer, 2121167167, "CC(remember):MainActivity.kt#9igjgp");
            Object rememberedValue6 = $composer.rememberedValue();
            if (rememberedValue6 == Composer.Companion.getEmpty()) {
                obj4 = new AlarmScheduler(context);
                $composer.updateRememberedValue(obj4);
            } else {
                obj4 = rememberedValue6;
            }
            final AlarmScheduler scheduler = (AlarmScheduler) obj4;
            ComposerKt.sourceInformationMarkerEnd($composer);
            ViewModelProvider.Factory factory = new ViewModelProvider.Factory() { // from class: com.example.ComposableSingletons$MainActivityKt$lambda$-601144069$1$factory$1
                public <T extends ViewModel> T create(Class<T> cls, CreationExtras creationExtras2) {
                    return (T) super.create(cls, creationExtras2);
                }

                public <T extends ViewModel> T create(KClass<T> kClass, CreationExtras creationExtras2) {
                    return (T) super.create(kClass, creationExtras2);
                }

                public <T extends ViewModel> T create(Class<T> modelClass) {
                    Intrinsics.checkNotNullParameter(modelClass, "modelClass");
                    Context applicationContext = context.getApplicationContext();
                    Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                    return new AzanViewModel(applicationContext, repo, prefs, scheduler);
                }
            };
            $composer.startReplaceableGroup(1729797275);
            ComposerKt.sourceInformation($composer, "CC(viewModel)P(3,2,1)*54@2502L7,64@2877L63:ViewModel.kt#3tja67");
            HasDefaultViewModelProviderFactory current = LocalViewModelStoreOwner.INSTANCE.getCurrent($composer, 6);
            if (current == null) {
                throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
            }
            if (current instanceof HasDefaultViewModelProviderFactory) {
                creationExtras = current.getDefaultViewModelCreationExtras();
            } else {
                creationExtras = CreationExtras.Empty.INSTANCE;
            }
            ViewModel viewModel = ViewModelKt.viewModel(Reflection.getOrCreateKotlinClass(AzanViewModel.class), current, (String) null, factory, creationExtras, $composer, ((0 << 3) & 57344) | ((0 << 3) & 896) | ((0 << 3) & 112) | ((0 << 3) & 7168), 0);
            $composer.endReplaceableGroup();
            final AzanViewModel viewModel2 = (AzanViewModel) viewModel;
            ThemeKt.MyApplicationTheme(ComposableLambdaKt.rememberComposableLambda(1357938057, true, new Function2() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda2
                public final Object invoke(Object obj6, Object obj7) {
                    return ComposableSingletons$MainActivityKt.lambda__601144069$lambda$11$lambda$10(AzanViewModel.this, (Composer) obj6, ((Integer) obj7).intValue());
                }
            }, $composer, 54), $composer, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__601144069$lambda$11$lambda$10(final AzanViewModel $viewModel, Composer $composer, int $changed) {
        AppStrings strings;
        ComposerKt.sourceInformation($composer, "C136@5941L29,144@6262L353,144@6203L412:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1357938057, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-601144069.<anonymous>.<anonymous> (MainActivity.kt:136)");
            }
            final State uiState$delegate = FlowExtKt.collectAsStateWithLifecycle($viewModel.getUiState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, $composer, 0, 7);
            String language = lambda__601144069$lambda$11$lambda$10$lambda$7(uiState$delegate).getLanguage();
            if (Intrinsics.areEqual(language, "hi")) {
                strings = StringsKt.getHindiStrings();
            } else {
                strings = Intrinsics.areEqual(language, "ur") ? StringsKt.getUrduStrings() : StringsKt.getEnglishStrings();
            }
            CompositionLocalKt.CompositionLocalProvider(StringsKt.getLocalAppStrings().provides(strings), ComposableLambdaKt.rememberComposableLambda(-847564599, true, new Function2() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda3
                public final Object invoke(Object obj, Object obj2) {
                    return ComposableSingletons$MainActivityKt.lambda__601144069$lambda$11$lambda$10$lambda$9(AzanViewModel.this, uiState$delegate, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, $composer, 54), $composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final UIState lambda__601144069$lambda$11$lambda$10$lambda$7(State<UIState> state) {
        return (UIState) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__601144069$lambda$11$lambda$10$lambda$9(final AzanViewModel $viewModel, final State $uiState$delegate, Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C145@6328L269,145@6284L313:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-847564599, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-601144069.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:145)");
            }
            ScaffoldKt.Scaffold-TvnljyQ(SizeKt.fillMaxSize$default(Modifier.Companion, 0.0f, 1, (Object) null), (Function2) null, (Function2) null, (Function2) null, (Function2) null, 0, 0L, 0L, (WindowInsets) null, ComposableLambdaKt.rememberComposableLambda(-1429143014, true, new Function3() { // from class: com.example.ComposableSingletons$MainActivityKt$$ExternalSyntheticLambda0
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ComposableSingletons$MainActivityKt.lambda__601144069$lambda$11$lambda$10$lambda$9$lambda$8(AzanViewModel.this, $uiState$delegate, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, $composer, 54), $composer, 805306374, 510);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__601144069$lambda$11$lambda$10$lambda$9$lambda$8(AzanViewModel $viewModel, State $uiState$delegate, PaddingValues innerPadding, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
        ComposerKt.sourceInformation($composer, "C146@6370L205:MainActivity.kt#to5c3");
        int $dirty = $changed;
        if (($changed & 6) == 0) {
            $dirty |= $composer.changed(innerPadding) ? 4 : 2;
        }
        if (($dirty & 19) == 18 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1429143014, $dirty, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-601144069.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainActivity.kt:146)");
            }
            MainActivityKt.AzanScreen($viewModel, lambda__601144069$lambda$11$lambda$10$lambda$7($uiState$delegate), PaddingKt.padding(Modifier.Companion, innerPadding), $composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_580705031$lambda$12(Composer $composer, int $changed) {
        ComposerKt.sourceInformation($composer, "C323@13099L11,320@12932L249:MainActivity.kt#to5c3");
        if (($changed & 3) == 2 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(580705031, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$580705031.<anonymous> (MainActivity.kt:320)");
            }
            IconKt.Icon-ww6aTOc(DateRangeKt.getDateRange(Icons.Filled.INSTANCE), "Prayer Board & Streak Tracker", SizeKt.size-3ABfNKs(Modifier.Companion, Dp.constructor-impl(18)), MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getPrimary-0d7_KjU(), $composer, 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_2071870587$lambda$13(AnimatedContentScope $this$AnimatedContent, char c, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedContent, "$this$AnimatedContent");
        ComposerKt.sourceInformation($composer, "C560@21542L568:MainActivity.kt#to5c3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2071870587, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$2071870587.<anonymous> (MainActivity.kt:560)");
        }
        TextKt.Text--4IGK_g(String.valueOf(c), (Modifier) null, 0L, TextUnitKt.getSp(52), (FontStyle) null, FontWeight.Companion.getBlack(), (FontFamily) null, TextUnitKt.getSp(-1), (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, new TextStyle(Brush.Companion.verticalGradient-8A-3gB4$default(Brush.Companion, CollectionsKt.listOf(new Color[]{Color.box-impl(ColorKt.Color(4294172302L)), Color.box-impl(ColorKt.Color(4289952828L))}), 0.0f, 0.0f, 0, 14, (Object) null), 0.0f, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 33554430, (DefaultConstructorMarker) null), $composer, 12782592, 1572864, 65366);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda__76186299$lambda$14(AnimatedContentScope $this$AnimatedContent, char c, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$AnimatedContent, "$this$AnimatedContent");
        ComposerKt.sourceInformation($composer, "C593@23251L11,589@23010L296:MainActivity.kt#to5c3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-76186299, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$-76186299.<anonymous> (MainActivity.kt:589)");
        }
        TextKt.Text--4IGK_g(String.valueOf(c), (Modifier) null, MaterialTheme.INSTANCE.getColorScheme($composer, MaterialTheme.$stable).getSecondary-0d7_KjU(), TextUnitKt.getSp(20), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 199680, 0, 131026);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static final Unit lambda_893846484$lambda$15(RowScope $this$Button, Composer $composer, int $changed) {
        Intrinsics.checkNotNullParameter($this$Button, "$this$Button");
        ComposerKt.sourceInformation($composer, "C856@35698L60:MainActivity.kt#to5c3");
        if (($changed & 17) == 16 && $composer.getSkipping()) {
            $composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(893846484, $changed, -1, "com.example.ComposableSingletons$MainActivityKt.lambda$893846484.<anonymous> (MainActivity.kt:856)");
            }
            TextKt.Text--4IGK_g("Stop", (Modifier) null, 0L, TextUnitKt.getSp(12), (FontStyle) null, FontWeight.Companion.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1) null, (TextStyle) null, $composer, 199686, 0, 131030);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}
