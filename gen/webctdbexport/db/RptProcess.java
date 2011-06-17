package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RptProcess generated by hbm2java
 */
@Entity
@Table(name="RPT_PROCESS"
)
public class RptProcess  implements java.io.Serializable {


     private BigDecimal id;
     private String viewName;
     private BigDecimal startDate;
     private BigDecimal endDate;

    public RptProcess() {
    }

	
    public RptProcess(BigDecimal id, String viewName, BigDecimal startDate) {
        this.id = id;
        this.viewName = viewName;
        this.startDate = startDate;
    }
    public RptProcess(BigDecimal id, String viewName, BigDecimal startDate, BigDecimal endDate) {
       this.id = id;
       this.viewName = viewName;
       this.startDate = startDate;
       this.endDate = endDate;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="VIEW_NAME", nullable=false, length=30)
    public String getViewName() {
        return this.viewName;
    }
    
    public void setViewName(String viewName) {
        this.viewName = viewName;
    }

    
    @Column(name="START_DATE", nullable=false, precision=20, scale=0)
    public BigDecimal getStartDate() {
        return this.startDate;
    }
    
    public void setStartDate(BigDecimal startDate) {
        this.startDate = startDate;
    }

    
    @Column(name="END_DATE", precision=20, scale=0)
    public BigDecimal getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(BigDecimal endDate) {
        this.endDate = endDate;
    }




}


