package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CalendarEntryDetail generated by hbm2java
 */
@Entity
@Table(name="CALENDAR_ENTRY_DETAIL"
)
public class CalendarEntryDetail  implements java.io.Serializable {


     private BigDecimal id;
     private CalendarEntry calendarEntry;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private BigDecimal calStartDateTime;
     private BigDecimal calEndDateTime;
     private Set<Syllitem> syllitems = new HashSet<Syllitem>(0);

    public CalendarEntryDetail() {
    }

	
    public CalendarEntryDetail(BigDecimal id, CalendarEntry calendarEntry, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.calendarEntry = calendarEntry;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public CalendarEntryDetail(BigDecimal id, CalendarEntry calendarEntry, BigDecimal createTs, BigDecimal lastmodifyTs, BigDecimal calStartDateTime, BigDecimal calEndDateTime, Set<Syllitem> syllitems) {
       this.id = id;
       this.calendarEntry = calendarEntry;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.calStartDateTime = calStartDateTime;
       this.calEndDateTime = calEndDateTime;
       this.syllitems = syllitems;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CALENDAR_ENTRY_ID", nullable=false)
    public CalendarEntry getCalendarEntry() {
        return this.calendarEntry;
    }
    
    public void setCalendarEntry(CalendarEntry calendarEntry) {
        this.calendarEntry = calendarEntry;
    }

    
    @Column(name="CREATE_TS", nullable=false, precision=20, scale=0)
    public BigDecimal getCreateTs() {
        return this.createTs;
    }
    
    public void setCreateTs(BigDecimal createTs) {
        this.createTs = createTs;
    }

    
    @Column(name="LASTMODIFY_TS", nullable=false, precision=20, scale=0)
    public BigDecimal getLastmodifyTs() {
        return this.lastmodifyTs;
    }
    
    public void setLastmodifyTs(BigDecimal lastmodifyTs) {
        this.lastmodifyTs = lastmodifyTs;
    }

    
    @Column(name="CAL_START_DATE_TIME", precision=20, scale=0)
    public BigDecimal getCalStartDateTime() {
        return this.calStartDateTime;
    }
    
    public void setCalStartDateTime(BigDecimal calStartDateTime) {
        this.calStartDateTime = calStartDateTime;
    }

    
    @Column(name="CAL_END_DATE_TIME", precision=20, scale=0)
    public BigDecimal getCalEndDateTime() {
        return this.calEndDateTime;
    }
    
    public void setCalEndDateTime(BigDecimal calEndDateTime) {
        this.calEndDateTime = calEndDateTime;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="calendarEntryDetail")
    public Set<Syllitem> getSyllitems() {
        return this.syllitems;
    }
    
    public void setSyllitems(Set<Syllitem> syllitems) {
        this.syllitems = syllitems;
    }




}


