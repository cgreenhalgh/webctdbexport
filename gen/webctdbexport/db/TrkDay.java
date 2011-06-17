package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * TrkDay generated by hbm2java
 */
@Entity
@Table(name="TRK_DAY"
)
public class TrkDay  implements java.io.Serializable {


     private BigDecimal id;
     private long year;
     private long month;
     private byte dayOfMonth;
     private boolean dayOfWeek;
     private boolean inClass;
     private boolean holiday;
     private boolean weekend;
     private Set<TrkUserAction> trkUserActions = new HashSet<TrkUserAction>(0);

    public TrkDay() {
    }

	
    public TrkDay(BigDecimal id, long year, long month, byte dayOfMonth, boolean dayOfWeek, boolean inClass, boolean holiday, boolean weekend) {
        this.id = id;
        this.year = year;
        this.month = month;
        this.dayOfMonth = dayOfMonth;
        this.dayOfWeek = dayOfWeek;
        this.inClass = inClass;
        this.holiday = holiday;
        this.weekend = weekend;
    }
    public TrkDay(BigDecimal id, long year, long month, byte dayOfMonth, boolean dayOfWeek, boolean inClass, boolean holiday, boolean weekend, Set<TrkUserAction> trkUserActions) {
       this.id = id;
       this.year = year;
       this.month = month;
       this.dayOfMonth = dayOfMonth;
       this.dayOfWeek = dayOfWeek;
       this.inClass = inClass;
       this.holiday = holiday;
       this.weekend = weekend;
       this.trkUserActions = trkUserActions;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="YEAR", nullable=false, precision=15, scale=0)
    public long getYear() {
        return this.year;
    }
    
    public void setYear(long year) {
        this.year = year;
    }

    
    @Column(name="MONTH", nullable=false, precision=15, scale=0)
    public long getMonth() {
        return this.month;
    }
    
    public void setMonth(long month) {
        this.month = month;
    }

    
    @Column(name="DAY_OF_MONTH", nullable=false, precision=2, scale=0)
    public byte getDayOfMonth() {
        return this.dayOfMonth;
    }
    
    public void setDayOfMonth(byte dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

    
    @Column(name="DAY_OF_WEEK", nullable=false, precision=1, scale=0)
    public boolean isDayOfWeek() {
        return this.dayOfWeek;
    }
    
    public void setDayOfWeek(boolean dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    
    @Column(name="IN_CLASS", nullable=false, precision=1, scale=0)
    public boolean isInClass() {
        return this.inClass;
    }
    
    public void setInClass(boolean inClass) {
        this.inClass = inClass;
    }

    
    @Column(name="HOLIDAY", nullable=false, precision=1, scale=0)
    public boolean isHoliday() {
        return this.holiday;
    }
    
    public void setHoliday(boolean holiday) {
        this.holiday = holiday;
    }

    
    @Column(name="WEEKEND", nullable=false, precision=1, scale=0)
    public boolean isWeekend() {
        return this.weekend;
    }
    
    public void setWeekend(boolean weekend) {
        this.weekend = weekend;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trkDay")
    public Set<TrkUserAction> getTrkUserActions() {
        return this.trkUserActions;
    }
    
    public void setTrkUserActions(Set<TrkUserAction> trkUserActions) {
        this.trkUserActions = trkUserActions;
    }




}


