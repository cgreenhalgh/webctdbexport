package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * LogRepository generated by hbm2java
 */
@Entity
@Table(name="LOG_REPOSITORY"
)
public class LogRepository  implements java.io.Serializable {


     private BigDecimal id;
     private String logCategory;
     private String logNdc;
     private BigDecimal logTime;
     private String logPriority;
     private String logMessage;
     private String nodeName;
     private LogException logException;

    public LogRepository() {
    }

	
    public LogRepository(BigDecimal id, String logCategory, String logNdc, BigDecimal logTime, String nodeName) {
        this.id = id;
        this.logCategory = logCategory;
        this.logNdc = logNdc;
        this.logTime = logTime;
        this.nodeName = nodeName;
    }
    public LogRepository(BigDecimal id, String logCategory, String logNdc, BigDecimal logTime, String logPriority, String logMessage, String nodeName, LogException logException) {
       this.id = id;
       this.logCategory = logCategory;
       this.logNdc = logNdc;
       this.logTime = logTime;
       this.logPriority = logPriority;
       this.logMessage = logMessage;
       this.nodeName = nodeName;
       this.logException = logException;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="LOG_CATEGORY", nullable=false, length=100)
    public String getLogCategory() {
        return this.logCategory;
    }
    
    public void setLogCategory(String logCategory) {
        this.logCategory = logCategory;
    }

    
    @Column(name="LOG_NDC", nullable=false, length=800)
    public String getLogNdc() {
        return this.logNdc;
    }
    
    public void setLogNdc(String logNdc) {
        this.logNdc = logNdc;
    }

    
    @Column(name="LOG_TIME", nullable=false, precision=20, scale=0)
    public BigDecimal getLogTime() {
        return this.logTime;
    }
    
    public void setLogTime(BigDecimal logTime) {
        this.logTime = logTime;
    }

    
    @Column(name="LOG_PRIORITY", length=20)
    public String getLogPriority() {
        return this.logPriority;
    }
    
    public void setLogPriority(String logPriority) {
        this.logPriority = logPriority;
    }

    
    @Column(name="LOG_MESSAGE", length=4000)
    public String getLogMessage() {
        return this.logMessage;
    }
    
    public void setLogMessage(String logMessage) {
        this.logMessage = logMessage;
    }

    
    @Column(name="NODE_NAME", nullable=false, length=100)
    public String getNodeName() {
        return this.nodeName;
    }
    
    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="logRepository")
    public LogException getLogException() {
        return this.logException;
    }
    
    public void setLogException(LogException logException) {
        this.logException = logException;
    }




}


