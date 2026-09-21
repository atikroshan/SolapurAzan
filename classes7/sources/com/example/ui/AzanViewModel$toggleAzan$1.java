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
@DebugMetadata(c = "com.example.ui.AzanViewModel$toggleAzan$1", f = "AzanViewModel.kt", i = {}, l = {249, 253}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class AzanViewModel$toggleAzan$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ String $name;
    int label;
    final /* synthetic */ AzanViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AzanViewModel$toggleAzan$1(AzanViewModel azanViewModel, String str, boolean z, Continuation<? super AzanViewModel$toggleAzan$1> continuation) {
        super(2, continuation);
        this.this$0 = azanViewModel;
        this.$name = str;
        this.$enabled = z;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AzanViewModel$toggleAzan$1(this.this$0, this.$name, this.$enabled, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0006. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            switch(r1) {
                case 0: goto L19;
                case 1: goto L15;
                case 2: goto L11;
                default: goto L9;
            }
        L9:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L11:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L5a
        L15:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L33
        L19:
            kotlin.ResultKt.throwOnFailure(r7)
            com.example.ui.AzanViewModel r1 = r6.this$0
            com.example.data.PreferencesRepository r1 = com.example.ui.AzanViewModel.access$getPrefs$p(r1)
            java.lang.String r2 = r6.$name
            boolean r3 = r6.$enabled
            r4 = r6
            kotlin.coroutines.Continuation r4 = (kotlin.coroutines.Continuation) r4
            r5 = 1
            r6.label = r5
            java.lang.Object r1 = r1.setAzanToggle(r2, r3, r4)
            if (r1 != r0) goto L33
            return r0
        L33:
            boolean r1 = r6.$enabled
            if (r1 != 0) goto L45
            com.example.worker.PrayerWorkScheduler r0 = com.example.worker.PrayerWorkScheduler.INSTANCE
            com.example.ui.AzanViewModel r1 = r6.this$0
            android.content.Context r1 = com.example.ui.AzanViewModel.access$getContext$p(r1)
            java.lang.String r2 = r6.$name
            r0.cancelPrayerNotification(r1, r2)
            goto L5b
        L45:
            com.example.worker.PrayerWorkScheduler r1 = com.example.worker.PrayerWorkScheduler.INSTANCE
            com.example.ui.AzanViewModel r2 = r6.this$0
            android.content.Context r2 = com.example.ui.AzanViewModel.access$getContext$p(r2)
            r3 = r6
            kotlin.coroutines.Continuation r3 = (kotlin.coroutines.Continuation) r3
            r4 = 2
            r6.label = r4
            java.lang.Object r1 = r1.scheduleAllPrayerNotifications(r2, r3)
            if (r1 != r0) goto L5a
            return r0
        L5a:
        L5b:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.AzanViewModel$toggleAzan$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
