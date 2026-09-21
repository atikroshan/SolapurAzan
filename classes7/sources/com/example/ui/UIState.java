package com.example.ui;

import com.example.data.AzanTiming;
import com.example.data.PrayerLog;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AzanViewModel.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B¥\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0007\u0012\b\b\u0002\u0010\n\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0007\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0007\u0012\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010/\u001a\u00020\u0007HÆ\u0003J\t\u00100\u001a\u00020\u0007HÆ\u0003J\t\u00101\u001a\u00020\u0007HÆ\u0003J\t\u00102\u001a\u00020\u0007HÆ\u0003J\t\u00103\u001a\u00020\u0007HÆ\u0003J\t\u00104\u001a\u00020\rHÆ\u0003J\t\u00105\u001a\u00020\u0007HÆ\u0003J\t\u00106\u001a\u00020\u0007HÆ\u0003J\t\u00107\u001a\u00020\u0007HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\u0007HÆ\u0003J\t\u0010:\u001a\u00020\u0007HÆ\u0003J\u000f\u0010;\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0003J§\u0001\u0010<\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00072\b\b\u0002\u0010\n\u001a\u00020\u00072\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\b\b\u0002\u0010\u0010\u001a\u00020\u00072\b\b\u0002\u0010\u0011\u001a\u00020\u00072\b\b\u0002\u0010\u0012\u001a\u00020\u00072\b\b\u0002\u0010\u0013\u001a\u00020\u00072\u000e\b\u0002\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015HÆ\u0001J\u0013\u0010=\u001a\u00020\u00072\b\u0010>\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010?\u001a\u00020@HÖ\u0001J\t\u0010A\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001eR\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001eR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b#\u0010$R\u0011\u0010\u000e\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001eR\u0011\u0010\u0010\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001eR\u0011\u0010\u0011\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001eR\u0011\u0010\u0012\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\u001eR\u0011\u0010\u0013\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u001eR\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015¢\u0006\b\n\u0000\u001a\u0004\b+\u0010,¨\u0006B"}, d2 = {"Lcom/example/ui/UIState;", "", "language", "", "todayTimings", "Lcom/example/data/AzanTiming;", "fajrEnabled", "", "dhuhrEnabled", "asrEnabled", "maghribEnabled", "ishaEnabled", "selectedDate", "Ljava/util/Calendar;", "fajrPrayed", "dhuhrPrayed", "asrPrayed", "maghribPrayed", "ishaPrayed", "tahajjudPrayed", "allLogs", "", "Lcom/example/data/PrayerLog;", "<init>", "(Ljava/lang/String;Lcom/example/data/AzanTiming;ZZZZZLjava/util/Calendar;ZZZZZZLjava/util/List;)V", "getLanguage", "()Ljava/lang/String;", "getTodayTimings", "()Lcom/example/data/AzanTiming;", "getFajrEnabled", "()Z", "getDhuhrEnabled", "getAsrEnabled", "getMaghribEnabled", "getIshaEnabled", "getSelectedDate", "()Ljava/util/Calendar;", "getFajrPrayed", "getDhuhrPrayed", "getAsrPrayed", "getMaghribPrayed", "getIshaPrayed", "getTahajjudPrayed", "getAllLogs", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "component11", "component12", "component13", "component14", "component15", "copy", "equals", "other", "hashCode", "", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final /* data */ class UIState {
    public static final int $stable = 8;
    private final List<PrayerLog> allLogs;
    private final boolean asrEnabled;
    private final boolean asrPrayed;
    private final boolean dhuhrEnabled;
    private final boolean dhuhrPrayed;
    private final boolean fajrEnabled;
    private final boolean fajrPrayed;
    private final boolean ishaEnabled;
    private final boolean ishaPrayed;
    private final String language;
    private final boolean maghribEnabled;
    private final boolean maghribPrayed;
    private final Calendar selectedDate;
    private final boolean tahajjudPrayed;
    private final AzanTiming todayTimings;

    public UIState() {
        this(null, null, false, false, false, false, false, null, false, false, false, false, false, false, null, 32767, null);
    }

    /* renamed from: component1, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    /* renamed from: component10, reason: from getter */
    public final boolean getDhuhrPrayed() {
        return this.dhuhrPrayed;
    }

    /* renamed from: component11, reason: from getter */
    public final boolean getAsrPrayed() {
        return this.asrPrayed;
    }

    /* renamed from: component12, reason: from getter */
    public final boolean getMaghribPrayed() {
        return this.maghribPrayed;
    }

    /* renamed from: component13, reason: from getter */
    public final boolean getIshaPrayed() {
        return this.ishaPrayed;
    }

    /* renamed from: component14, reason: from getter */
    public final boolean getTahajjudPrayed() {
        return this.tahajjudPrayed;
    }

    public final List<PrayerLog> component15() {
        return this.allLogs;
    }

    /* renamed from: component2, reason: from getter */
    public final AzanTiming getTodayTimings() {
        return this.todayTimings;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getFajrEnabled() {
        return this.fajrEnabled;
    }

    /* renamed from: component4, reason: from getter */
    public final boolean getDhuhrEnabled() {
        return this.dhuhrEnabled;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getAsrEnabled() {
        return this.asrEnabled;
    }

    /* renamed from: component6, reason: from getter */
    public final boolean getMaghribEnabled() {
        return this.maghribEnabled;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIshaEnabled() {
        return this.ishaEnabled;
    }

    /* renamed from: component8, reason: from getter */
    public final Calendar getSelectedDate() {
        return this.selectedDate;
    }

    /* renamed from: component9, reason: from getter */
    public final boolean getFajrPrayed() {
        return this.fajrPrayed;
    }

    public final UIState copy(String language, AzanTiming todayTimings, boolean fajrEnabled, boolean dhuhrEnabled, boolean asrEnabled, boolean maghribEnabled, boolean ishaEnabled, Calendar selectedDate, boolean fajrPrayed, boolean dhuhrPrayed, boolean asrPrayed, boolean maghribPrayed, boolean ishaPrayed, boolean tahajjudPrayed, List<PrayerLog> allLogs) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
        Intrinsics.checkNotNullParameter(allLogs, "allLogs");
        return new UIState(language, todayTimings, fajrEnabled, dhuhrEnabled, asrEnabled, maghribEnabled, ishaEnabled, selectedDate, fajrPrayed, dhuhrPrayed, asrPrayed, maghribPrayed, ishaPrayed, tahajjudPrayed, allLogs);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof UIState)) {
            return false;
        }
        UIState uIState = (UIState) other;
        return Intrinsics.areEqual(this.language, uIState.language) && Intrinsics.areEqual(this.todayTimings, uIState.todayTimings) && this.fajrEnabled == uIState.fajrEnabled && this.dhuhrEnabled == uIState.dhuhrEnabled && this.asrEnabled == uIState.asrEnabled && this.maghribEnabled == uIState.maghribEnabled && this.ishaEnabled == uIState.ishaEnabled && Intrinsics.areEqual(this.selectedDate, uIState.selectedDate) && this.fajrPrayed == uIState.fajrPrayed && this.dhuhrPrayed == uIState.dhuhrPrayed && this.asrPrayed == uIState.asrPrayed && this.maghribPrayed == uIState.maghribPrayed && this.ishaPrayed == uIState.ishaPrayed && this.tahajjudPrayed == uIState.tahajjudPrayed && Intrinsics.areEqual(this.allLogs, uIState.allLogs);
    }

    public int hashCode() {
        return (((((((((((((((((((((((((((this.language.hashCode() * 31) + (this.todayTimings == null ? 0 : this.todayTimings.hashCode())) * 31) + Boolean.hashCode(this.fajrEnabled)) * 31) + Boolean.hashCode(this.dhuhrEnabled)) * 31) + Boolean.hashCode(this.asrEnabled)) * 31) + Boolean.hashCode(this.maghribEnabled)) * 31) + Boolean.hashCode(this.ishaEnabled)) * 31) + this.selectedDate.hashCode()) * 31) + Boolean.hashCode(this.fajrPrayed)) * 31) + Boolean.hashCode(this.dhuhrPrayed)) * 31) + Boolean.hashCode(this.asrPrayed)) * 31) + Boolean.hashCode(this.maghribPrayed)) * 31) + Boolean.hashCode(this.ishaPrayed)) * 31) + Boolean.hashCode(this.tahajjudPrayed)) * 31) + this.allLogs.hashCode();
    }

    public String toString() {
        return "UIState(language=" + this.language + ", todayTimings=" + this.todayTimings + ", fajrEnabled=" + this.fajrEnabled + ", dhuhrEnabled=" + this.dhuhrEnabled + ", asrEnabled=" + this.asrEnabled + ", maghribEnabled=" + this.maghribEnabled + ", ishaEnabled=" + this.ishaEnabled + ", selectedDate=" + this.selectedDate + ", fajrPrayed=" + this.fajrPrayed + ", dhuhrPrayed=" + this.dhuhrPrayed + ", asrPrayed=" + this.asrPrayed + ", maghribPrayed=" + this.maghribPrayed + ", ishaPrayed=" + this.ishaPrayed + ", tahajjudPrayed=" + this.tahajjudPrayed + ", allLogs=" + this.allLogs + ")";
    }

    public UIState(String language, AzanTiming todayTimings, boolean fajrEnabled, boolean dhuhrEnabled, boolean asrEnabled, boolean maghribEnabled, boolean ishaEnabled, Calendar selectedDate, boolean fajrPrayed, boolean dhuhrPrayed, boolean asrPrayed, boolean maghribPrayed, boolean ishaPrayed, boolean tahajjudPrayed, List<PrayerLog> list) {
        Intrinsics.checkNotNullParameter(language, "language");
        Intrinsics.checkNotNullParameter(selectedDate, "selectedDate");
        Intrinsics.checkNotNullParameter(list, "allLogs");
        this.language = language;
        this.todayTimings = todayTimings;
        this.fajrEnabled = fajrEnabled;
        this.dhuhrEnabled = dhuhrEnabled;
        this.asrEnabled = asrEnabled;
        this.maghribEnabled = maghribEnabled;
        this.ishaEnabled = ishaEnabled;
        this.selectedDate = selectedDate;
        this.fajrPrayed = fajrPrayed;
        this.dhuhrPrayed = dhuhrPrayed;
        this.asrPrayed = asrPrayed;
        this.maghribPrayed = maghribPrayed;
        this.ishaPrayed = ishaPrayed;
        this.tahajjudPrayed = tahajjudPrayed;
        this.allLogs = list;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public /* synthetic */ UIState(java.lang.String r17, com.example.data.AzanTiming r18, boolean r19, boolean r20, boolean r21, boolean r22, boolean r23, java.util.Calendar r24, boolean r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, java.util.List r31, int r32, kotlin.jvm.internal.DefaultConstructorMarker r33) {
        /*
            r16 = this;
            r0 = r32
            r1 = r0 & 1
            if (r1 == 0) goto L9
            java.lang.String r1 = "en"
            goto Lb
        L9:
            r1 = r17
        Lb:
            r2 = r0 & 2
            if (r2 == 0) goto L11
            r2 = 0
            goto L13
        L11:
            r2 = r18
        L13:
            r3 = r0 & 4
            r4 = 1
            if (r3 == 0) goto L1a
            r3 = r4
            goto L1c
        L1a:
            r3 = r19
        L1c:
            r5 = r0 & 8
            if (r5 == 0) goto L22
            r5 = r4
            goto L24
        L22:
            r5 = r20
        L24:
            r6 = r0 & 16
            if (r6 == 0) goto L2a
            r6 = r4
            goto L2c
        L2a:
            r6 = r21
        L2c:
            r7 = r0 & 32
            if (r7 == 0) goto L32
            r7 = r4
            goto L34
        L32:
            r7 = r22
        L34:
            r8 = r0 & 64
            if (r8 == 0) goto L39
            goto L3b
        L39:
            r4 = r23
        L3b:
            r8 = r0 & 128(0x80, float:1.8E-43)
            if (r8 == 0) goto L4f
            java.lang.String r8 = "Asia/Kolkata"
            java.util.TimeZone r8 = java.util.TimeZone.getTimeZone(r8)
            java.util.Calendar r8 = java.util.Calendar.getInstance(r8)
            java.lang.String r9 = "getInstance(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)
            goto L51
        L4f:
            r8 = r24
        L51:
            r9 = r0 & 256(0x100, float:3.59E-43)
            r10 = 0
            if (r9 == 0) goto L58
            r9 = r10
            goto L5a
        L58:
            r9 = r25
        L5a:
            r11 = r0 & 512(0x200, float:7.17E-43)
            if (r11 == 0) goto L60
            r11 = r10
            goto L62
        L60:
            r11 = r26
        L62:
            r12 = r0 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L68
            r12 = r10
            goto L6a
        L68:
            r12 = r27
        L6a:
            r13 = r0 & 2048(0x800, float:2.87E-42)
            if (r13 == 0) goto L70
            r13 = r10
            goto L72
        L70:
            r13 = r28
        L72:
            r14 = r0 & 4096(0x1000, float:5.74E-42)
            if (r14 == 0) goto L78
            r14 = r10
            goto L7a
        L78:
            r14 = r29
        L7a:
            r15 = r0 & 8192(0x2000, float:1.148E-41)
            if (r15 == 0) goto L7f
            goto L81
        L7f:
            r10 = r30
        L81:
            r0 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r0 == 0) goto L8a
            java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
            goto L8c
        L8a:
            r0 = r31
        L8c:
            r17 = r16
            r32 = r0
            r18 = r1
            r19 = r2
            r20 = r3
            r24 = r4
            r21 = r5
            r22 = r6
            r23 = r7
            r25 = r8
            r26 = r9
            r31 = r10
            r27 = r11
            r28 = r12
            r29 = r13
            r30 = r14
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.ui.UIState.<init>(java.lang.String, com.example.data.AzanTiming, boolean, boolean, boolean, boolean, boolean, java.util.Calendar, boolean, boolean, boolean, boolean, boolean, boolean, java.util.List, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getLanguage() {
        return this.language;
    }

    public final AzanTiming getTodayTimings() {
        return this.todayTimings;
    }

    public final boolean getFajrEnabled() {
        return this.fajrEnabled;
    }

    public final boolean getDhuhrEnabled() {
        return this.dhuhrEnabled;
    }

    public final boolean getAsrEnabled() {
        return this.asrEnabled;
    }

    public final boolean getMaghribEnabled() {
        return this.maghribEnabled;
    }

    public final boolean getIshaEnabled() {
        return this.ishaEnabled;
    }

    public final Calendar getSelectedDate() {
        return this.selectedDate;
    }

    public final boolean getFajrPrayed() {
        return this.fajrPrayed;
    }

    public final boolean getDhuhrPrayed() {
        return this.dhuhrPrayed;
    }

    public final boolean getAsrPrayed() {
        return this.asrPrayed;
    }

    public final boolean getMaghribPrayed() {
        return this.maghribPrayed;
    }

    public final boolean getIshaPrayed() {
        return this.ishaPrayed;
    }

    public final boolean getTahajjudPrayed() {
        return this.tahajjudPrayed;
    }

    public final List<PrayerLog> getAllLogs() {
        return this.allLogs;
    }
}
