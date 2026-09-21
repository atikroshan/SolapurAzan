package com.example;

import android.content.Context;
import androidx.activity.compose.ManagedActivityResultLauncher;
import androidx.core.content.ContextCompat;
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
@DebugMetadata(c = "com.example.ComposableSingletons$MainActivityKt$lambda$-601144069$1$1$1", f = "MainActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* renamed from: com.example.ComposableSingletons$MainActivityKt$lambda$-601144069$1$1$1, reason: invalid class name */
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class ComposableSingletons$MainActivityKt$lambda$601144069$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Context $context;
    final /* synthetic */ ManagedActivityResultLauncher<String, Boolean> $permissionLauncher;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ComposableSingletons$MainActivityKt$lambda$601144069$1$1$1(Context context, ManagedActivityResultLauncher<String, Boolean> managedActivityResultLauncher, Continuation<? super ComposableSingletons$MainActivityKt$lambda$601144069$1$1$1> continuation) {
        super(2, continuation);
        this.$context = context;
        this.$permissionLauncher = managedActivityResultLauncher;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ComposableSingletons$MainActivityKt$lambda$601144069$1$1$1(this.$context, this.$permissionLauncher, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                if (ContextCompat.checkSelfPermission(this.$context, "android.permission.POST_NOTIFICATIONS") != 0) {
                    this.$permissionLauncher.launch("android.permission.POST_NOTIFICATIONS");
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
