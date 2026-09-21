package com.example;

import androidx.compose.runtime.MutableIntState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.MainActivityKt$AzanList$2$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class MainActivityKt$AzanList$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ MutableIntState $currentNextIndex$delegate;
    final /* synthetic */ MutableIntState $expandedIndex$delegate;
    final /* synthetic */ boolean $isToday;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$AzanList$2$1(boolean z, MutableIntState mutableIntState, MutableIntState mutableIntState2, Continuation<? super MainActivityKt$AzanList$2$1> continuation) {
        super(2, continuation);
        this.$isToday = z;
        this.$currentNextIndex$delegate = mutableIntState;
        this.$expandedIndex$delegate = mutableIntState2;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$AzanList$2$1(this.$isToday, this.$currentNextIndex$delegate, this.$expandedIndex$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        int AzanList$lambda$77;
        int AzanList$lambda$772;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (this.$isToday) {
                    AzanList$lambda$77 = MainActivityKt.AzanList$lambda$77(this.$currentNextIndex$delegate);
                    if (AzanList$lambda$77 != -1) {
                        MutableIntState mutableIntState = this.$expandedIndex$delegate;
                        AzanList$lambda$772 = MainActivityKt.AzanList$lambda$77(this.$currentNextIndex$delegate);
                        mutableIntState.setIntValue(AzanList$lambda$772);
                    }
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
