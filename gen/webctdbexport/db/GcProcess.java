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
 * GcProcess generated by hbm2java
 */
@Entity
@Table(name="GC_PROCESS"
)
public class GcProcess  implements java.io.Serializable {


     private BigDecimal id;
     private BigDecimal startDate;
     private BigDecimal endDate;
     private Set<GcTask> gcTasks = new HashSet<GcTask>(0);

    public GcProcess() {
    }

	
    public GcProcess(BigDecimal id, BigDecimal startDate) {
        this.id = id;
        this.startDate = startDate;
    }
    public GcProcess(BigDecimal id, BigDecimal startDate, BigDecimal endDate, Set<GcTask> gcTasks) {
       this.id = id;
       this.startDate = startDate;
       this.endDate = endDate;
       this.gcTasks = gcTasks;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="gcProcess")
    public Set<GcTask> getGcTasks() {
        return this.gcTasks;
    }
    
    public void setGcTasks(Set<GcTask> gcTasks) {
        this.gcTasks = gcTasks;
    }




}


