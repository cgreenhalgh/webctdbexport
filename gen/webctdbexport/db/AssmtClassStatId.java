package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AssmtClassStatId generated by hbm2java
 */
@Embeddable
public class AssmtClassStatId  implements java.io.Serializable {


     private BigDecimal processId;
     private BigDecimal deliveryContextId;
     private BigDecimal assmtId;
     private BigDecimal attempts;
     private BigDecimal meanScore;
     private BigDecimal medianScore;
     private BigDecimal deviationScore;

    public AssmtClassStatId() {
    }

    public AssmtClassStatId(BigDecimal processId, BigDecimal deliveryContextId, BigDecimal assmtId, BigDecimal attempts, BigDecimal meanScore, BigDecimal medianScore, BigDecimal deviationScore) {
       this.processId = processId;
       this.deliveryContextId = deliveryContextId;
       this.assmtId = assmtId;
       this.attempts = attempts;
       this.meanScore = meanScore;
       this.medianScore = medianScore;
       this.deviationScore = deviationScore;
    }
   


    @Column(name="PROCESS_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getProcessId() {
        return this.processId;
    }
    
    public void setProcessId(BigDecimal processId) {
        this.processId = processId;
    }


    @Column(name="DELIVERY_CONTEXT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getDeliveryContextId() {
        return this.deliveryContextId;
    }
    
    public void setDeliveryContextId(BigDecimal deliveryContextId) {
        this.deliveryContextId = deliveryContextId;
    }


    @Column(name="ASSMT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getAssmtId() {
        return this.assmtId;
    }
    
    public void setAssmtId(BigDecimal assmtId) {
        this.assmtId = assmtId;
    }


    @Column(name="ATTEMPTS", nullable=false, precision=22, scale=0)
    public BigDecimal getAttempts() {
        return this.attempts;
    }
    
    public void setAttempts(BigDecimal attempts) {
        this.attempts = attempts;
    }


    @Column(name="MEAN_SCORE", nullable=false, precision=22, scale=0)
    public BigDecimal getMeanScore() {
        return this.meanScore;
    }
    
    public void setMeanScore(BigDecimal meanScore) {
        this.meanScore = meanScore;
    }


    @Column(name="MEDIAN_SCORE", nullable=false, precision=22, scale=0)
    public BigDecimal getMedianScore() {
        return this.medianScore;
    }
    
    public void setMedianScore(BigDecimal medianScore) {
        this.medianScore = medianScore;
    }


    @Column(name="DEVIATION_SCORE", nullable=false, precision=22, scale=0)
    public BigDecimal getDeviationScore() {
        return this.deviationScore;
    }
    
    public void setDeviationScore(BigDecimal deviationScore) {
        this.deviationScore = deviationScore;
    }




}


