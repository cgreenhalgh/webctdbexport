package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TrkSummaryReportTId generated by hbm2java
 */
@Embeddable
public class TrkSummaryReportTId  implements java.io.Serializable {


     private BigDecimal lcId;
     private Long totalsession;
     private BigDecimal averagesessionlength;
     private Integer averagesessionperday;
     private Integer averagesessionperdayweekday;
     private Integer averagesessionperdayweekend;
     private Date mostactiveday;
     private Date leastactivday;
     private Integer mostactivehour;
     private Integer leastactivehous;

    public TrkSummaryReportTId() {
    }

    public TrkSummaryReportTId(BigDecimal lcId, Long totalsession, BigDecimal averagesessionlength, Integer averagesessionperday, Integer averagesessionperdayweekday, Integer averagesessionperdayweekend, Date mostactiveday, Date leastactivday, Integer mostactivehour, Integer leastactivehous) {
       this.lcId = lcId;
       this.totalsession = totalsession;
       this.averagesessionlength = averagesessionlength;
       this.averagesessionperday = averagesessionperday;
       this.averagesessionperdayweekday = averagesessionperdayweekday;
       this.averagesessionperdayweekend = averagesessionperdayweekend;
       this.mostactiveday = mostactiveday;
       this.leastactivday = leastactivday;
       this.mostactivehour = mostactivehour;
       this.leastactivehous = leastactivehous;
    }
   


    @Column(name="LC_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getLcId() {
        return this.lcId;
    }
    
    public void setLcId(BigDecimal lcId) {
        this.lcId = lcId;
    }


    @Column(name="TOTALSESSION", nullable=false, precision=10, scale=0)
    public Long getTotalsession() {
        return this.totalsession;
    }
    
    public void setTotalsession(Long totalsession) {
        this.totalsession = totalsession;
    }


    @Column(name="AVERAGESESSIONLENGTH", nullable=false, precision=20, scale=0)
    public BigDecimal getAveragesessionlength() {
        return this.averagesessionlength;
    }
    
    public void setAveragesessionlength(BigDecimal averagesessionlength) {
        this.averagesessionlength = averagesessionlength;
    }


    @Column(name="AVERAGESESSIONPERDAY", nullable=false, precision=5, scale=0)
    public Integer getAveragesessionperday() {
        return this.averagesessionperday;
    }
    
    public void setAveragesessionperday(Integer averagesessionperday) {
        this.averagesessionperday = averagesessionperday;
    }


    @Column(name="AVERAGESESSIONPERDAYWEEKDAY", nullable=false, precision=5, scale=0)
    public Integer getAveragesessionperdayweekday() {
        return this.averagesessionperdayweekday;
    }
    
    public void setAveragesessionperdayweekday(Integer averagesessionperdayweekday) {
        this.averagesessionperdayweekday = averagesessionperdayweekday;
    }


    @Column(name="AVERAGESESSIONPERDAYWEEKEND", nullable=false, precision=5, scale=0)
    public Integer getAveragesessionperdayweekend() {
        return this.averagesessionperdayweekend;
    }
    
    public void setAveragesessionperdayweekend(Integer averagesessionperdayweekend) {
        this.averagesessionperdayweekend = averagesessionperdayweekend;
    }


    @Column(name="MOSTACTIVEDAY", nullable=false, length=7)
    public Date getMostactiveday() {
        return this.mostactiveday;
    }
    
    public void setMostactiveday(Date mostactiveday) {
        this.mostactiveday = mostactiveday;
    }


    @Column(name="LEASTACTIVDAY", nullable=false, length=7)
    public Date getLeastactivday() {
        return this.leastactivday;
    }
    
    public void setLeastactivday(Date leastactivday) {
        this.leastactivday = leastactivday;
    }


    @Column(name="MOSTACTIVEHOUR", nullable=false, precision=5, scale=0)
    public Integer getMostactivehour() {
        return this.mostactivehour;
    }
    
    public void setMostactivehour(Integer mostactivehour) {
        this.mostactivehour = mostactivehour;
    }


    @Column(name="LEASTACTIVEHOUS", nullable=false, precision=5, scale=0)
    public Integer getLeastactivehous() {
        return this.leastactivehous;
    }
    
    public void setLeastactivehous(Integer leastactivehous) {
        this.leastactivehous = leastactivehous;
    }




}


