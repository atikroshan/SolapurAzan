package com.example;

import android.content.Context;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import com.example.ui.AzanViewModel;
import com.example.ui.UIState;
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
@DebugMetadata(c = "com.example.MainActivityKt$AzanList$1$1", f = "MainActivity.kt", i = {0}, l = {749}, m = "invokeSuspend", n = {"timings"}, s = {"L$0"})
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class MainActivityKt$AzanList$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ MutableIntState $currentNextIndex$delegate;
    final /* synthetic */ MutableState<String> $lastTriggeredMinute$delegate;
    final /* synthetic */ UIState $uiState;
    final /* synthetic */ AzanViewModel $viewModel;
    Object L$0;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MainActivityKt$AzanList$1$1(AzanViewModel azanViewModel, UIState uIState, Context context, MutableIntState mutableIntState, MutableState<String> mutableState, Continuation<? super MainActivityKt$AzanList$1$1> continuation) {
        super(2, continuation);
        this.$viewModel = azanViewModel;
        this.$uiState = uIState;
        this.$context = context;
        this.$currentNextIndex$delegate = mutableIntState;
        this.$lastTriggeredMinute$delegate = mutableState;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new MainActivityKt$AzanList$1$1(this.$viewModel, this.$uiState, this.$context, this.$currentNextIndex$delegate, this.$lastTriggeredMinute$delegate, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:2:0x0008. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x02b7 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x029f  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:49:0x02b8 -> B:7:0x02bd). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r34) {
        /*
            Method dump skipped, instructions count: 714
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.MainActivityKt$AzanList$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
