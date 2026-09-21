package com.example.ui;

import com.example.BuildConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: AzanViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.AzanViewModel$togglePrayerForDate$1", f = "AzanViewModel.kt", i = {0, 0, 1, 1, 1, 1, 2, 2, 2, 2, 2}, l = {99, 112, 148}, m = "invokeSuspend", n = {"todayCal", "isToday", "todayCal", "currentLog", "isToday", "isCurrentlyPrayed", "todayCal", "currentLog", "updatedLog", "isToday", "isCurrentlyPrayed"}, s = {"L$0", "I$0", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "L$2", "I$0", "I$1"})
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class AzanViewModel$togglePrayerForDate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $day;
    final /* synthetic */ int $month;
    final /* synthetic */ String $name;
    int I$0;
    int I$1;
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ AzanViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AzanViewModel$togglePrayerForDate$1(int i, int i2, AzanViewModel azanViewModel, String str, Continuation<? super AzanViewModel$togglePrayerForDate$1> continuation) {
        super(2, continuation);
        this.$month = i;
        this.$day = i2;
        this.this$0 = azanViewModel;
        this.$name = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AzanViewModel$togglePrayerForDate$1(this.$month, this.$day, this.this$0, this.$name, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0018. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x019f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0342 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0343  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0255  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r31) {
        /*
            Method dump skipped, instructions count: 934
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.AzanViewModel$togglePrayerForDate$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
