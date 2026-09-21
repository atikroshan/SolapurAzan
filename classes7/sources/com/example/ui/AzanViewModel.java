package com.example.ui;

import android.content.Context;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.BuildConfig;
import com.example.data.AzanRepository;
import com.example.data.AzanTiming;
import com.example.data.PreferencesRepository;
import com.example.service.AlarmScheduler;
import com.example.worker.PrayerWorkScheduler;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

/* compiled from: AzanViewModel.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001:\u0001/B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u0012\u001a\u00020\u0011J\u0006\u0010\u0013\u001a\u00020\u0011J\u0006\u0010\u0014\u001a\u00020\u0011J\u0016\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u000e\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001bJ\u001e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u000e\u0010+\u001a\u00020\u00112\u0006\u0010,\u001a\u00020\u001bJ\u0016\u0010-\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020 R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\f\u0012\n \u000f*\u0004\u0018\u00010\u000e0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020 0\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\"0\u001eX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b#\u0010$R\u001d\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&¢\u0006\u000e\n\u0000\u0012\u0004\b(\u0010$\u001a\u0004\b)\u0010*¨\u00060"}, d2 = {"Lcom/example/ui/AzanViewModel;", "Landroidx/lifecycle/ViewModel;", "context", "Landroid/content/Context;", "repository", "Lcom/example/data/AzanRepository;", "prefs", "Lcom/example/data/PreferencesRepository;", "alarmScheduler", "Lcom/example/service/AlarmScheduler;", "<init>", "(Landroid/content/Context;Lcom/example/data/AzanRepository;Lcom/example/data/PreferencesRepository;Lcom/example/service/AlarmScheduler;)V", "_currentCalendar", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "refreshDate", "", "nextDay", "previousDay", "selectToday", "selectDate", "month", "", "day", "togglePrayerPrayed", "name", "", "togglePrayerForDate", "togglesFlow", "Lkotlinx/coroutines/flow/Flow;", "", "", "timingsFlow", "Lcom/example/data/AzanTiming;", "getTimingsFlow$annotations", "()V", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "Lcom/example/ui/UIState;", "getUiState$annotations", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "setLanguage", "lang", "toggleAzan", "enabled", "AlarmScheduleState", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class AzanViewModel extends ViewModel {
    public static final int $stable = 8;
    private final MutableStateFlow<Calendar> _currentCalendar;
    private final AlarmScheduler alarmScheduler;
    private final Context context;
    private final PreferencesRepository prefs;
    private final AzanRepository repository;
    private final Flow<AzanTiming> timingsFlow;
    private final Flow<List<Boolean>> togglesFlow;
    private final StateFlow<UIState> uiState;

    private static /* synthetic */ void getTimingsFlow$annotations() {
    }

    public static /* synthetic */ void getUiState$annotations() {
    }

    public AzanViewModel(Context context, AzanRepository repository, PreferencesRepository prefs, AlarmScheduler alarmScheduler) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(repository, "repository");
        Intrinsics.checkNotNullParameter(prefs, "prefs");
        Intrinsics.checkNotNullParameter(alarmScheduler, "alarmScheduler");
        this.context = context;
        this.repository = repository;
        this.prefs = prefs;
        this.alarmScheduler = alarmScheduler;
        this._currentCalendar = StateFlowKt.MutableStateFlow(Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata")));
        this.togglesFlow = FlowKt.combine(this.prefs.isAzanEnabled("Fajr"), this.prefs.isAzanEnabled("Dhuhr"), this.prefs.isAzanEnabled("Asr"), this.prefs.isAzanEnabled("Maghrib"), this.prefs.isAzanEnabled("Isha"), new AzanViewModel$togglesFlow$1(null));
        this.timingsFlow = FlowKt.transformLatest(this._currentCalendar, new AzanViewModel$special$$inlined$flatMapLatest$1(null, this));
        this.uiState = FlowKt.stateIn(FlowKt.combine(this.prefs.getLanguageFlow(), this.togglesFlow, this._currentCalendar, this.repository.getAllLogs(), this.timingsFlow, new AzanViewModel$uiState$1(null)), ViewModelKt.getViewModelScope(this), SharingStarted.Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, (Object) null), new UIState(null, null, false, false, false, false, false, null, false, false, false, false, false, false, null, 32767, null));
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1(null), 3, (Object) null);
    }

    public final void refreshDate() {
        Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
    }

    public final void nextDay() {
        Calendar next = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
        next.setTimeInMillis(((Calendar) this._currentCalendar.getValue()).getTimeInMillis());
        next.add(5, 1);
        this._currentCalendar.setValue(next);
    }

    public final void previousDay() {
        Calendar prev = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
        prev.setTimeInMillis(((Calendar) this._currentCalendar.getValue()).getTimeInMillis());
        prev.add(5, -1);
        this._currentCalendar.setValue(prev);
    }

    public final void selectToday() {
        this._currentCalendar.setValue(Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata")));
    }

    public final void selectDate(int month, int day) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("Asia/Kolkata"));
        cal.set(2, month - 1);
        cal.set(5, day);
        this._currentCalendar.setValue(cal);
    }

    public final void togglePrayerPrayed(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Calendar cal = (Calendar) this._currentCalendar.getValue();
        int m = cal.get(2) + 1;
        int d = cal.get(5);
        togglePrayerForDate(m, d, name);
    }

    public final void togglePrayerForDate(int month, int day, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AzanViewModel$togglePrayerForDate$1(month, day, this, name, null), 3, (Object) null);
    }

    public final StateFlow<UIState> getUiState() {
        return this.uiState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: AzanViewModel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0082\b\u0018\u00002\u00020\u0001B9\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\tHÆ\u0003JG\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tHÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u00032\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020 HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006!"}, d2 = {"Lcom/example/ui/AzanViewModel$AlarmScheduleState;", "", "f", "", "d", "a", "m", "i", "timings", "Lcom/example/data/AzanTiming;", "<init>", "(ZZZZZLcom/example/data/AzanTiming;)V", "getF", "()Z", "getD", "getA", "getM", "getI", "getTimings", "()Lcom/example/data/AzanTiming;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* loaded from: /tmp/decompiled/resources/classes7.dex */
    public static final /* data */ class AlarmScheduleState {
        private final boolean a;
        private final boolean d;
        private final boolean f;
        private final boolean i;
        private final boolean m;
        private final AzanTiming timings;

        public static /* synthetic */ AlarmScheduleState copy$default(AlarmScheduleState alarmScheduleState, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, AzanTiming azanTiming, int i, Object obj) {
            if ((i & 1) != 0) {
                z = alarmScheduleState.f;
            }
            if ((i & 2) != 0) {
                z2 = alarmScheduleState.d;
            }
            if ((i & 4) != 0) {
                z3 = alarmScheduleState.a;
            }
            if ((i & 8) != 0) {
                z4 = alarmScheduleState.m;
            }
            if ((i & 16) != 0) {
                z5 = alarmScheduleState.i;
            }
            if ((i & 32) != 0) {
                azanTiming = alarmScheduleState.timings;
            }
            boolean z6 = z5;
            AzanTiming azanTiming2 = azanTiming;
            return alarmScheduleState.copy(z, z2, z3, z4, z6, azanTiming2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getF() {
            return this.f;
        }

        /* renamed from: component2, reason: from getter */
        public final boolean getD() {
            return this.d;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getA() {
            return this.a;
        }

        /* renamed from: component4, reason: from getter */
        public final boolean getM() {
            return this.m;
        }

        /* renamed from: component5, reason: from getter */
        public final boolean getI() {
            return this.i;
        }

        /* renamed from: component6, reason: from getter */
        public final AzanTiming getTimings() {
            return this.timings;
        }

        public final AlarmScheduleState copy(boolean f, boolean d, boolean a, boolean m, boolean i, AzanTiming timings) {
            return new AlarmScheduleState(f, d, a, m, i, timings);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof AlarmScheduleState)) {
                return false;
            }
            AlarmScheduleState alarmScheduleState = (AlarmScheduleState) other;
            return this.f == alarmScheduleState.f && this.d == alarmScheduleState.d && this.a == alarmScheduleState.a && this.m == alarmScheduleState.m && this.i == alarmScheduleState.i && Intrinsics.areEqual(this.timings, alarmScheduleState.timings);
        }

        public int hashCode() {
            return (((((((((Boolean.hashCode(this.f) * 31) + Boolean.hashCode(this.d)) * 31) + Boolean.hashCode(this.a)) * 31) + Boolean.hashCode(this.m)) * 31) + Boolean.hashCode(this.i)) * 31) + (this.timings == null ? 0 : this.timings.hashCode());
        }

        public String toString() {
            return "AlarmScheduleState(f=" + this.f + ", d=" + this.d + ", a=" + this.a + ", m=" + this.m + ", i=" + this.i + ", timings=" + this.timings + ")";
        }

        public AlarmScheduleState(boolean f, boolean d, boolean a, boolean m, boolean i, AzanTiming timings) {
            this.f = f;
            this.d = d;
            this.a = a;
            this.m = m;
            this.i = i;
            this.timings = timings;
        }

        public final boolean getF() {
            return this.f;
        }

        public final boolean getD() {
            return this.d;
        }

        public final boolean getA() {
            return this.a;
        }

        public final boolean getM() {
            return this.m;
        }

        public final boolean getI() {
            return this.i;
        }

        public final AzanTiming getTimings() {
            return this.timings;
        }
    }

    /* compiled from: AzanViewModel.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.example.ui.AzanViewModel$1", f = "AzanViewModel.kt", i = {0, 1}, l = {211, 212}, m = "invokeSuspend", n = {"$this$launch", "$this$launch"}, s = {"L$0", "L$0"})
    /* renamed from: com.example.ui.AzanViewModel$1, reason: invalid class name */
    /* loaded from: /tmp/decompiled/resources/classes7.dex */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Continuation<Unit> anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Failed to find 'out' block for switch in B:2:0x000b. Please report as an issue. */
        /* JADX WARN: Removed duplicated region for block: B:12:0x004c A[RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = r7.L$0
                r1 = r0
                kotlinx.coroutines.CoroutineScope r1 = (kotlinx.coroutines.CoroutineScope) r1
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r7.label
                switch(r2) {
                    case 0: goto L1e;
                    case 1: goto L1a;
                    case 2: goto L16;
                    default: goto Le;
                }
            Le:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r2)
                throw r0
            L16:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L4d
            L1a:
                kotlin.ResultKt.throwOnFailure(r8)
                goto L36
            L1e:
                kotlin.ResultKt.throwOnFailure(r8)
                com.example.ui.AzanViewModel r2 = com.example.ui.AzanViewModel.this
                com.example.data.AzanRepository r2 = com.example.ui.AzanViewModel.access$getRepository$p(r2)
                r3 = r7
                kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
                r7.L$0 = r1
                r4 = 1
                r7.label = r4
                java.lang.Object r2 = r2.initializeDatabaseIfNeeded(r3)
                if (r2 != r0) goto L36
                return r0
            L36:
                com.example.worker.PrayerWorkScheduler r2 = com.example.worker.PrayerWorkScheduler.INSTANCE
                com.example.ui.AzanViewModel r3 = com.example.ui.AzanViewModel.this
                android.content.Context r3 = com.example.ui.AzanViewModel.access$getContext$p(r3)
                r4 = r7
                kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
                r7.L$0 = r1
                r5 = 2
                r7.label = r5
                java.lang.Object r2 = r2.scheduleAllPrayerNotifications(r3, r4)
                if (r2 != r0) goto L4d
                return r0
            L4d:
                com.example.ui.AzanViewModel$1$1 r0 = new com.example.ui.AzanViewModel$1$1
                com.example.ui.AzanViewModel r2 = com.example.ui.AzanViewModel.this
                r3 = 0
                r0.<init>(r2, r3)
                r4 = r0
                kotlin.jvm.functions.Function2 r4 = (kotlin.jvm.functions.Function2) r4
                r5 = 3
                r6 = 0
                r2 = 0
                kotlinx.coroutines.BuildersKt.launch$default(r1, r2, r3, r4, r5, r6)
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.example.ui.AzanViewModel.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: AzanViewModel.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
        @DebugMetadata(c = "com.example.ui.AzanViewModel$1$1", f = "AzanViewModel.kt", i = {}, l = {226}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.example.ui.AzanViewModel$1$1, reason: invalid class name and collision with other inner class name */
        /* loaded from: /tmp/decompiled/resources/classes7.dex */
        public static final class C00001 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ AzanViewModel this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C00001(AzanViewModel azanViewModel, Continuation<? super C00001> continuation) {
                super(2, continuation);
                this.this$0 = azanViewModel;
            }

            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C00001(this.this$0, continuation);
            }

            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
            }

            public final Object invokeSuspend(Object $result) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (this.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        final Flow uiState = this.this$0.getUiState();
                        Flow distinctUntilChanged = FlowKt.distinctUntilChanged(new Flow<AlarmScheduleState>() { // from class: com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1
                            public Object collect(FlowCollector collector, Continuation $completion) {
                                Object collect = uiState.collect(new AnonymousClass2(collector), $completion);
                                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
                            }

                            /* compiled from: Emitters.kt */
                            @Metadata(k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
                            /* renamed from: com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1$2, reason: invalid class name */
                            /* loaded from: /tmp/decompiled/resources/classes7.dex */
                            public static final class AnonymousClass2<T> implements FlowCollector {
                                final /* synthetic */ FlowCollector $this_unsafeFlow;

                                @Metadata(k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
                                @DebugMetadata(c = "com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1$2", f = "AzanViewModel.kt", i = {0, 0, 0, 0, 0}, l = {50}, m = "emit", n = {"value", "$completion", "value", "$this$map_u24lambda_u245", "$i$a$-unsafeTransform-FlowKt__TransformKt$map$1\\1\\49\\0"}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"})
                                /* renamed from: com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1$2$1, reason: invalid class name */
                                /* loaded from: /tmp/decompiled/resources/classes7.dex */
                                public static final class AnonymousClass1 extends ContinuationImpl {
                                    int I$0;
                                    Object L$0;
                                    Object L$1;
                                    Object L$2;
                                    Object L$3;
                                    int label;
                                    /* synthetic */ Object result;

                                    public AnonymousClass1(Continuation continuation) {
                                        super(continuation);
                                    }

                                    public final Object invokeSuspend(Object obj) {
                                        this.result = obj;
                                        this.label |= Integer.MIN_VALUE;
                                        return AnonymousClass2.this.emit(null, (Continuation) this);
                                    }
                                }

                                public AnonymousClass2(FlowCollector flowCollector) {
                                    this.$this_unsafeFlow = flowCollector;
                                }

                                /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
                                /* JADX WARN: Removed duplicated region for block: B:14:0x0042  */
                                /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct add '--show-bad-code' argument
                                */
                                public final java.lang.Object emit(java.lang.Object r20, kotlin.coroutines.Continuation r21) {
                                    /*
                                        r19 = this;
                                        r0 = r19
                                        r1 = r21
                                        boolean r2 = r1 instanceof com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1
                                        if (r2 == 0) goto L18
                                        r2 = r1
                                        com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1$2$1 r2 = (com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r2
                                        int r3 = r2.label
                                        r4 = -2147483648(0xffffffff80000000, float:-0.0)
                                        r3 = r3 & r4
                                        if (r3 == 0) goto L18
                                        int r3 = r2.label
                                        int r3 = r3 - r4
                                        r2.label = r3
                                        goto L1d
                                    L18:
                                        com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1$2$1 r2 = new com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1$2$1
                                        r2.<init>(r1)
                                    L1d:
                                        java.lang.Object r3 = r2.result
                                        java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                        int r5 = r2.label
                                        switch(r5) {
                                            case 0: goto L42;
                                            case 1: goto L30;
                                            default: goto L28;
                                        }
                                    L28:
                                        java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
                                        java.lang.String r3 = "call to 'resume' before 'invoke' with coroutine"
                                        r2.<init>(r3)
                                        throw r2
                                    L30:
                                        int r4 = r2.I$0
                                        java.lang.Object r5 = r2.L$3
                                        kotlinx.coroutines.flow.FlowCollector r5 = (kotlinx.coroutines.flow.FlowCollector) r5
                                        java.lang.Object r6 = r2.L$2
                                        java.lang.Object r7 = r2.L$1
                                        com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1$2$1 r7 = (com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.AnonymousClass1) r7
                                        java.lang.Object r8 = r2.L$0
                                        kotlin.ResultKt.throwOnFailure(r3)
                                        goto L97
                                    L42:
                                        kotlin.ResultKt.throwOnFailure(r3)
                                        kotlinx.coroutines.flow.FlowCollector r5 = r0.$this_unsafeFlow
                                        r7 = r2
                                        r6 = r20
                                        r8 = 0
                                        r9 = r2
                                        kotlin.coroutines.Continuation r9 = (kotlin.coroutines.Continuation) r9
                                        r10 = r6
                                        com.example.ui.UIState r10 = (com.example.ui.UIState) r10
                                        r11 = 0
                                        com.example.ui.AzanViewModel$AlarmScheduleState r12 = new com.example.ui.AzanViewModel$AlarmScheduleState
                                        boolean r13 = r10.getFajrEnabled()
                                        boolean r14 = r10.getDhuhrEnabled()
                                        boolean r15 = r10.getAsrEnabled()
                                        boolean r16 = r10.getMaghribEnabled()
                                        boolean r17 = r10.getIshaEnabled()
                                        com.example.data.AzanTiming r18 = r10.getTodayTimings()
                                        r12.<init>(r13, r14, r15, r16, r17, r18)
                                        java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r20)
                                        r2.L$0 = r9
                                        java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
                                        r2.L$1 = r9
                                        java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                                        r2.L$2 = r9
                                        java.lang.Object r9 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                                        r2.L$3 = r9
                                        r2.I$0 = r8
                                        r9 = 1
                                        r2.label = r9
                                        java.lang.Object r9 = r5.emit(r12, r2)
                                        if (r9 != r4) goto L94
                                        return r4
                                    L94:
                                        r4 = r8
                                        r8 = r20
                                    L97:
                                        kotlin.Unit r4 = kotlin.Unit.INSTANCE
                                        return r4
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.example.ui.AzanViewModel$1$1$invokeSuspend$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                                }
                            }
                        });
                        final AzanViewModel azanViewModel = this.this$0;
                        this.label = 1;
                        if (distinctUntilChanged.collect(new FlowCollector() { // from class: com.example.ui.AzanViewModel.1.1.2
                            public /* bridge */ /* synthetic */ Object emit(Object value, Continuation $completion) {
                                return emit((AlarmScheduleState) value, (Continuation<? super Unit>) $completion);
                            }

                            public final Object emit(AlarmScheduleState s, Continuation<? super Unit> continuation) {
                                AzanTiming timings = s.getTimings();
                                if (timings != null) {
                                    AzanViewModel azanViewModel2 = AzanViewModel.this;
                                    if (s.getF()) {
                                        azanViewModel2.alarmScheduler.scheduleAzan("Fajr", timings.getFajr());
                                    } else {
                                        azanViewModel2.alarmScheduler.cancelAzan("Fajr");
                                    }
                                    if (s.getD()) {
                                        azanViewModel2.alarmScheduler.scheduleAzan("Dhuhr", timings.getDhuhr());
                                    } else {
                                        azanViewModel2.alarmScheduler.cancelAzan("Dhuhr");
                                    }
                                    if (s.getA()) {
                                        azanViewModel2.alarmScheduler.scheduleAzan("Asr", timings.getAsr());
                                    } else {
                                        azanViewModel2.alarmScheduler.cancelAzan("Asr");
                                    }
                                    if (s.getM()) {
                                        azanViewModel2.alarmScheduler.scheduleAzan("Maghrib", timings.getMaghrib());
                                    } else {
                                        azanViewModel2.alarmScheduler.cancelAzan("Maghrib");
                                    }
                                    if (s.getI()) {
                                        azanViewModel2.alarmScheduler.scheduleAzan("Isha", timings.getIsha());
                                    } else {
                                        azanViewModel2.alarmScheduler.cancelAzan("Isha");
                                    }
                                    Object scheduleAllPrayerNotifications = PrayerWorkScheduler.INSTANCE.scheduleAllPrayerNotifications(azanViewModel2.context, continuation);
                                    if (scheduleAllPrayerNotifications == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                                        return scheduleAllPrayerNotifications;
                                    }
                                }
                                return Unit.INSTANCE;
                            }
                        }, (Continuation) this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        break;
                    case 1:
                        ResultKt.throwOnFailure($result);
                        break;
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                return Unit.INSTANCE;
            }
        }
    }

    public final void setLanguage(String lang) {
        Intrinsics.checkNotNullParameter(lang, "lang");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AzanViewModel$setLanguage$1(this, lang, null), 3, (Object) null);
    }

    public final void toggleAzan(String name, boolean enabled) {
        Intrinsics.checkNotNullParameter(name, "name");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), (CoroutineContext) null, (CoroutineStart) null, new AzanViewModel$toggleAzan$1(this, name, enabled, null), 3, (Object) null);
    }
}
