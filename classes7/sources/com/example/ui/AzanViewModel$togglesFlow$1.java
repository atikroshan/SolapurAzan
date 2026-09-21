package com.example.ui;

import com.example.BuildConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function6;

/* compiled from: AzanViewModel.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000b\n\u0002\b\u0005\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "", "f", "d", "a", "m", "i"}, k = BuildConfig.VERSION_CODE, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.example.ui.AzanViewModel$togglesFlow$1", f = "AzanViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: /tmp/decompiled/resources/classes7.dex */
final class AzanViewModel$togglesFlow$1 extends SuspendLambda implements Function6<Boolean, Boolean, Boolean, Boolean, Boolean, Continuation<? super List<? extends Boolean>>, Object> {
    /* synthetic */ boolean Z$0;
    /* synthetic */ boolean Z$1;
    /* synthetic */ boolean Z$2;
    /* synthetic */ boolean Z$3;
    /* synthetic */ boolean Z$4;
    int label;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AzanViewModel$togglesFlow$1(Continuation<? super AzanViewModel$togglesFlow$1> continuation) {
        super(6, continuation);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke(((Boolean) obj).booleanValue(), ((Boolean) obj2).booleanValue(), ((Boolean) obj3).booleanValue(), ((Boolean) obj4).booleanValue(), ((Boolean) obj5).booleanValue(), (Continuation<? super List<Boolean>>) obj6);
    }

    public final Object invoke(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, Continuation<? super List<Boolean>> continuation) {
        AzanViewModel$togglesFlow$1 azanViewModel$togglesFlow$1 = new AzanViewModel$togglesFlow$1(continuation);
        azanViewModel$togglesFlow$1.Z$0 = z;
        azanViewModel$togglesFlow$1.Z$1 = z2;
        azanViewModel$togglesFlow$1.Z$2 = z3;
        azanViewModel$togglesFlow$1.Z$3 = z4;
        azanViewModel$togglesFlow$1.Z$4 = z5;
        return azanViewModel$togglesFlow$1.invokeSuspend(Unit.INSTANCE);
    }

    public final Object invokeSuspend(Object $result) {
        boolean f = this.Z$0;
        boolean d = this.Z$1;
        boolean a = this.Z$2;
        boolean m = this.Z$3;
        boolean i = this.Z$4;
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                return CollectionsKt.listOf(new Boolean[]{Boxing.boxBoolean(f), Boxing.boxBoolean(d), Boxing.boxBoolean(a), Boxing.boxBoolean(m), Boxing.boxBoolean(i)});
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
