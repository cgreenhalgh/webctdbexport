package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AssmtItemClassStatId generated by hbm2java
 */
@Embeddable
public class AssmtItemClassStatId  implements java.io.Serializable {


     private BigDecimal processId;
     private BigDecimal deliveryContextId;
     private BigDecimal assmtId;
     private BigDecimal assmtItemId;
     private BigDecimal questionId;
     private BigDecimal attempts;
     private BigDecimal meanScore;
     private BigDecimal medianScore;
     private BigDecimal deviationScore;
     private BigDecimal percentCorrectWhole;
     private BigDecimal percentCorrectLower;
     private BigDecimal percentCorrectUpper;
     private BigDecimal correlation;

    public AssmtItemClassStatId() {
    }

    public AssmtItemClassStatId(BigDecimal processId, BigDecimal deliveryContextId, BigDecimal assmtId, BigDecimal assmtItemId, BigDecimal questionId, BigDecimal attempts, BigDecimal meanScore, BigDecimal medianScore, BigDecimal deviationScore, BigDecimal percentCorrectWhole, BigDecimal percentCorrectLower, BigDecimal percentCorrectUpper, BigDecimal correlation) {
       this.processId = processId;
       this.deliveryContextId = deliveryContextId;
       this.assmtId = assmtId;
       this.assmtItemId = assmtItemId;
       this.questionId = questionId;
       this.attempts = attempts;
       this.meanScore = meanScore;
       this.medianScore = medianScore;
       this.deviationScore = deviationScore;
       this.percentCorrectWhole = percentCorrectWhole;
       this.percentCorrectLower = percentCorrectLower;
       this.percentCorrectUpper = percentCorrectUpper;
       this.correlation = correlation;
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


    @Column(name="ASSMT_ITEM_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getAssmtItemId() {
        return this.assmtItemId;
    }
    
    public void setAssmtItemId(BigDecimal assmtItemId) {
        this.assmtItemId = assmtItemId;
    }


    @Column(name="QUESTION_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(BigDecimal questionId) {
        this.questionId = questionId;
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


    @Column(name="PERCENT_CORRECT_WHOLE", nullable=false, precision=22, scale=0)
    public BigDecimal getPercentCorrectWhole() {
        return this.percentCorrectWhole;
    }
    
    public void setPercentCorrectWhole(BigDecimal percentCorrectWhole) {
        this.percentCorrectWhole = percentCorrectWhole;
    }


    @Column(name="PERCENT_CORRECT_LOWER", nullable=false, precision=22, scale=0)
    public BigDecimal getPercentCorrectLower() {
        return this.percentCorrectLower;
    }
    
    public void setPercentCorrectLower(BigDecimal percentCorrectLower) {
        this.percentCorrectLower = percentCorrectLower;
    }


    @Column(name="PERCENT_CORRECT_UPPER", nullable=false, precision=22, scale=0)
    public BigDecimal getPercentCorrectUpper() {
        return this.percentCorrectUpper;
    }
    
    public void setPercentCorrectUpper(BigDecimal percentCorrectUpper) {
        this.percentCorrectUpper = percentCorrectUpper;
    }


    @Column(name="CORRELATION", nullable=false, precision=22, scale=0)
    public BigDecimal getCorrelation() {
        return this.correlation;
    }
    
    public void setCorrelation(BigDecimal correlation) {
        this.correlation = correlation;
    }




}


