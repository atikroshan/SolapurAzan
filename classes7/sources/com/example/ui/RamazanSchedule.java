package com.example.ui;

import java.util.Calendar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TrackerBoard.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u001b\b\u0087\b\u0018\u00002\u00020\u0001B?\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\u0006\u0010\f\u001a\u00020\u0007¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÆ\u0003JO\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0007HÆ\u0001J\u0013\u0010!\u001a\u00020\n2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010#\u001a\u00020\u0003HÖ\u0001J\t\u0010$\u001a\u00020\u0007HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0014R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0016R\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\f\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014¨\u0006%"}, d2 = {"Lcom/example/ui/RamazanSchedule;", "", "id", "", "cal", "Ljava/util/Calendar;", "dateStr", "", "dayStr", "isFriday", "", "seharTime", "iftarTime", "<init>", "(ILjava/util/Calendar;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V", "getId", "()I", "getCal", "()Ljava/util/Calendar;", "getDateStr", "()Ljava/lang/String;", "getDayStr", "()Z", "getSeharTime", "getIftarTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "app"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: /tmp/decompiled/resources/classes7.dex */
public final /* data */ class RamazanSchedule {
    public static final int $stable = 8;
    private final Calendar cal;
    private final String dateStr;
    private final String dayStr;
    private final int id;
    private final String iftarTime;
    private final boolean isFriday;
    private final String seharTime;

    public static /* synthetic */ RamazanSchedule copy$default(RamazanSchedule ramazanSchedule, int i, Calendar calendar, String str, String str2, boolean z, String str3, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = ramazanSchedule.id;
        }
        if ((i2 & 2) != 0) {
            calendar = ramazanSchedule.cal;
        }
        if ((i2 & 4) != 0) {
            str = ramazanSchedule.dateStr;
        }
        if ((i2 & 8) != 0) {
            str2 = ramazanSchedule.dayStr;
        }
        if ((i2 & 16) != 0) {
            z = ramazanSchedule.isFriday;
        }
        if ((i2 & 32) != 0) {
            str3 = ramazanSchedule.seharTime;
        }
        if ((i2 & 64) != 0) {
            str4 = ramazanSchedule.iftarTime;
        }
        String str5 = str3;
        String str6 = str4;
        boolean z2 = z;
        String str7 = str;
        return ramazanSchedule.copy(i, calendar, str7, str2, z2, str5, str6);
    }

    /* renamed from: component1, reason: from getter */
    public final int getId() {
        return this.id;
    }

    /* renamed from: component2, reason: from getter */
    public final Calendar getCal() {
        return this.cal;
    }

    /* renamed from: component3, reason: from getter */
    public final String getDateStr() {
        return this.dateStr;
    }

    /* renamed from: component4, reason: from getter */
    public final String getDayStr() {
        return this.dayStr;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsFriday() {
        return this.isFriday;
    }

    /* renamed from: component6, reason: from getter */
    public final String getSeharTime() {
        return this.seharTime;
    }

    /* renamed from: component7, reason: from getter */
    public final String getIftarTime() {
        return this.iftarTime;
    }

    public final RamazanSchedule copy(int id, Calendar cal, String dateStr, String dayStr, boolean isFriday, String seharTime, String iftarTime) {
        Intrinsics.checkNotNullParameter(cal, "cal");
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        Intrinsics.checkNotNullParameter(dayStr, "dayStr");
        Intrinsics.checkNotNullParameter(seharTime, "seharTime");
        Intrinsics.checkNotNullParameter(iftarTime, "iftarTime");
        return new RamazanSchedule(id, cal, dateStr, dayStr, isFriday, seharTime, iftarTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof RamazanSchedule)) {
            return false;
        }
        RamazanSchedule ramazanSchedule = (RamazanSchedule) other;
        return this.id == ramazanSchedule.id && Intrinsics.areEqual(this.cal, ramazanSchedule.cal) && Intrinsics.areEqual(this.dateStr, ramazanSchedule.dateStr) && Intrinsics.areEqual(this.dayStr, ramazanSchedule.dayStr) && this.isFriday == ramazanSchedule.isFriday && Intrinsics.areEqual(this.seharTime, ramazanSchedule.seharTime) && Intrinsics.areEqual(this.iftarTime, ramazanSchedule.iftarTime);
    }

    public int hashCode() {
        return (((((((((((Integer.hashCode(this.id) * 31) + this.cal.hashCode()) * 31) + this.dateStr.hashCode()) * 31) + this.dayStr.hashCode()) * 31) + Boolean.hashCode(this.isFriday)) * 31) + this.seharTime.hashCode()) * 31) + this.iftarTime.hashCode();
    }

    public String toString() {
        return "RamazanSchedule(id=" + this.id + ", cal=" + this.cal + ", dateStr=" + this.dateStr + ", dayStr=" + this.dayStr + ", isFriday=" + this.isFriday + ", seharTime=" + this.seharTime + ", iftarTime=" + this.iftarTime + ")";
    }

    public RamazanSchedule(int id, Calendar cal, String dateStr, String dayStr, boolean isFriday, String seharTime, String iftarTime) {
        Intrinsics.checkNotNullParameter(cal, "cal");
        Intrinsics.checkNotNullParameter(dateStr, "dateStr");
        Intrinsics.checkNotNullParameter(dayStr, "dayStr");
        Intrinsics.checkNotNullParameter(seharTime, "seharTime");
        Intrinsics.checkNotNullParameter(iftarTime, "iftarTime");
        this.id = id;
        this.cal = cal;
        this.dateStr = dateStr;
        this.dayStr = dayStr;
        this.isFriday = isFriday;
        this.seharTime = seharTime;
        this.iftarTime = iftarTime;
    }

    public final int getId() {
        return this.id;
    }

    public final Calendar getCal() {
        return this.cal;
    }

    public final String getDateStr() {
        return this.dateStr;
    }

    public final String getDayStr() {
        return this.dayStr;
    }

    public final boolean isFriday() {
        return this.isFriday;
    }

    public final String getSeharTime() {
        return this.seharTime;
    }

    public final String getIftarTime() {
        return this.iftarTime;
    }
}
