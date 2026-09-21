package com.example;

import androidx.compose.runtime.MutableState;
import java.util.Calendar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.MainActivityKt$ClockDisplay$1$1", f = "MainActivity.kt", i = {}, l = {415}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class MainActivityKt$ClockDisplay$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableState<Calendar> $currentTime$delegate;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$ClockDisplay$1$1(MutableState<Calendar> mutableState, Continuation<? super MainActivityKt$ClockDisplay$1$1> continuation) {
        super(2, continuation);
        this.$currentTime$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$ClockDisplay$1$1(this.$currentTime$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0029 A[RETURN] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:9:0x0027 -> B:7:0x002a). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            switch(r1) {
                case 0: goto L16;
                case 1: goto L11;
                default: goto L9;
            }
        L9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L11:
            kotlin.ResultKt.throwOnFailure(r6)
            r1 = r5
            goto L2a
        L16:
            kotlin.ResultKt.throwOnFailure(r6)
            r1 = r5
        L1a:
            r2 = r1
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            r3 = 1
            r1.label = r3
            r3 = 1000(0x3e8, double:4.94E-321)
            java.lang.Object r2 = kotlinx.coroutines.DelayKt.delay(r3, r2)
            if (r2 != r0) goto L2a
            return r0
        L2a:
            androidx.compose.runtime.MutableState<java.util.Calendar> r2 = r1.$currentTime$delegate
            java.lang.String r3 = "Asia/Kolkata"
            java.util.TimeZone r3 = java.util.TimeZone.getTimeZone(r3)
            java.util.Calendar r3 = java.util.Calendar.getInstance(r3)
            com.example.MainActivityKt.access$ClockDisplay$lambda$39(r2, r3)
            goto L1a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt$ClockDisplay$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
