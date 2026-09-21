package com.example.ui;

import com.example.BuildConfig;
import com.example.data.AzanTiming;
import com.example.data.PrayerLog;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AzanViewModel.kt */
@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00052\b\u0010\f\u001a\u0004\u0018\u00010\rH\n"}, d2 = {"<anonymous>", "Lcom/example/ui/UIState;", "language", "", "toggles", "", "", "cal", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "allLogs", "Lcom/example/data/PrayerLog;", "timings", "Lcom/example/data/AzanTiming;"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.AzanViewModel$uiState$1", f = "AzanViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/decompiled/resources/classes7.dex */
final class AzanViewModel$uiState$1 extends SuspendLambda implements Function6<String, List<? extends Boolean>, Calendar, List<? extends PrayerLog>, AzanTiming, Continuation<? super UIState>, Object> {
    /* synthetic */ Object L$0;
    /* synthetic */ Object L$1;
    /* synthetic */ Object L$2;
    /* synthetic */ Object L$3;
    /* synthetic */ Object L$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AzanViewModel$uiState$1(Continuation<? super AzanViewModel$uiState$1> continuation) {
        super(6, continuation);
    }

    public final Object invoke(String str, List<Boolean> list, Calendar calendar, List<PrayerLog> list2, AzanTiming azanTiming, Continuation<? super UIState> continuation) {
        AzanViewModel$uiState$1 azanViewModel$uiState$1 = new AzanViewModel$uiState$1(continuation);
        azanViewModel$uiState$1.L$0 = str;
        azanViewModel$uiState$1.L$1 = list;
        azanViewModel$uiState$1.L$2 = calendar;
        azanViewModel$uiState$1.L$3 = list2;
        azanViewModel$uiState$1.L$4 = azanTiming;
        return azanViewModel$uiState$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        Object obj;
        String language = (String) this.L$0;
        List toggles = (List) this.L$1;
        Calendar cal = (Calendar) this.L$2;
        List allLogs = (List) this.L$3;
        AzanTiming timings = (AzanTiming) this.L$4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                int m = cal.get(2) + 1;
                int d = cal.get(5);
                Iterator it = allLogs.iterator();
                while (true) {
                    if (it.hasNext()) {
                        obj = it.next();
                        PrayerLog prayerLog = (PrayerLog) obj;
                        if (((prayerLog.getMonth() == m && prayerLog.getDay() == d) ? 1 : null) != null) {
                        }
                    } else {
                        obj = null;
                    }
                }
                PrayerLog currentLog = (PrayerLog) obj;
                boolean booleanValue = ((Boolean) toggles.get(0)).booleanValue();
                boolean booleanValue2 = ((Boolean) toggles.get(1)).booleanValue();
                boolean booleanValue3 = ((Boolean) toggles.get(2)).booleanValue();
                boolean booleanValue4 = ((Boolean) toggles.get(3)).booleanValue();
                boolean booleanValue5 = ((Boolean) toggles.get(4)).booleanValue();
                Intrinsics.checkNotNull(cal);
                return new UIState(language, timings, booleanValue, booleanValue2, booleanValue3, booleanValue4, booleanValue5, cal, currentLog != null ? currentLog.getFajrPrayed() : false, currentLog != null ? currentLog.getDhuhrPrayed() : false, currentLog != null ? currentLog.getAsrPrayed() : false, currentLog != null ? currentLog.getMaghribPrayed() : false, currentLog != null ? currentLog.getIshaPrayed() : false, currentLog != null ? currentLog.getTahajjudPrayed() : false, allLogs);
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
