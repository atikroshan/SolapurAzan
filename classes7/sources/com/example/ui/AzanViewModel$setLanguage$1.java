package com.example.ui;

import com.example.BuildConfig;
import com.example.data.PreferencesRepository;
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
/* compiled from: AzanViewModel.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.AzanViewModel$setLanguage$1", f = "AzanViewModel.kt", i = {}, l = {243}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final class AzanViewModel$setLanguage$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $lang;
    int label;
    final /* synthetic */ AzanViewModel this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AzanViewModel$setLanguage$1(AzanViewModel azanViewModel, String str, Continuation<? super AzanViewModel$setLanguage$1> continuation) {
        super(2, continuation);
        this.this$0 = azanViewModel;
        this.$lang = str;
    }

    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new AzanViewModel$setLanguage$1(this.this$0, this.$lang, continuation);
    }

    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return create(coroutineScope, continuation).invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        PreferencesRepository preferencesRepository;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                preferencesRepository = this.this$0.prefs;
                this.label = 1;
                if (preferencesRepository.setLanguage(this.$lang, (Continuation) this) == coroutine_suspended) {
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
