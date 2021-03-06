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
 * BackgroundJobTypes generated by hbm2java
 */
@Entity
@Table(name="BACKGROUND_JOB_TYPES"
)
public class BackgroundJobTypes  implements java.io.Serializable {


     private String jobType;
     private String pojo;
     private int defaultMaxConcurrentThreads;
     private int defaultPriority;
     private String reportingKey;
     private BigDecimal createTs;
     private BigDecimal lastmodifiedTs;
     private Set<BackgroundJobs> backgroundJobses = new HashSet<BackgroundJobs>(0);

    public BackgroundJobTypes() {
    }

	
    public BackgroundJobTypes(String jobType, String pojo, int defaultMaxConcurrentThreads, int defaultPriority, String reportingKey, BigDecimal createTs, BigDecimal lastmodifiedTs) {
        this.jobType = jobType;
        this.pojo = pojo;
        this.defaultMaxConcurrentThreads = defaultMaxConcurrentThreads;
        this.defaultPriority = defaultPriority;
        this.reportingKey = reportingKey;
        this.createTs = createTs;
        this.lastmodifiedTs = lastmodifiedTs;
    }
    public BackgroundJobTypes(String jobType, String pojo, int defaultMaxConcurrentThreads, int defaultPriority, String reportingKey, BigDecimal createTs, BigDecimal lastmodifiedTs, Set<BackgroundJobs> backgroundJobses) {
       this.jobType = jobType;
       this.pojo = pojo;
       this.defaultMaxConcurrentThreads = defaultMaxConcurrentThreads;
       this.defaultPriority = defaultPriority;
       this.reportingKey = reportingKey;
       this.createTs = createTs;
       this.lastmodifiedTs = lastmodifiedTs;
       this.backgroundJobses = backgroundJobses;
    }
   
     @Id 

    
    @Column(name="JOB_TYPE", nullable=false, length=100)
    public String getJobType() {
        return this.jobType;
    }
    
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    
    @Column(name="POJO", nullable=false, length=500)
    public String getPojo() {
        return this.pojo;
    }
    
    public void setPojo(String pojo) {
        this.pojo = pojo;
    }

    
    @Column(name="DEFAULT_MAX_CONCURRENT_THREADS", nullable=false, precision=5, scale=0)
    public int getDefaultMaxConcurrentThreads() {
        return this.defaultMaxConcurrentThreads;
    }
    
    public void setDefaultMaxConcurrentThreads(int defaultMaxConcurrentThreads) {
        this.defaultMaxConcurrentThreads = defaultMaxConcurrentThreads;
    }

    
    @Column(name="DEFAULT_PRIORITY", nullable=false, precision=5, scale=0)
    public int getDefaultPriority() {
        return this.defaultPriority;
    }
    
    public void setDefaultPriority(int defaultPriority) {
        this.defaultPriority = defaultPriority;
    }

    
    @Column(name="REPORTING_KEY", nullable=false, length=200)
    public String getReportingKey() {
        return this.reportingKey;
    }
    
    public void setReportingKey(String reportingKey) {
        this.reportingKey = reportingKey;
    }

    
    @Column(name="CREATE_TS", nullable=false, precision=20, scale=0)
    public BigDecimal getCreateTs() {
        return this.createTs;
    }
    
    public void setCreateTs(BigDecimal createTs) {
        this.createTs = createTs;
    }

    
    @Column(name="LASTMODIFIED_TS", nullable=false, precision=20, scale=0)
    public BigDecimal getLastmodifiedTs() {
        return this.lastmodifiedTs;
    }
    
    public void setLastmodifiedTs(BigDecimal lastmodifiedTs) {
        this.lastmodifiedTs = lastmodifiedTs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="backgroundJobTypes")
    public Set<BackgroundJobs> getBackgroundJobses() {
        return this.backgroundJobses;
    }
    
    public void setBackgroundJobses(Set<BackgroundJobs> backgroundJobses) {
        this.backgroundJobses = backgroundJobses;
    }




}


