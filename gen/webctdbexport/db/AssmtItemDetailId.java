package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AssmtItemDetailId generated by hbm2java
 */
@Embeddable
public class AssmtItemDetailId  implements java.io.Serializable {


     private BigDecimal deliveryContextId;
     private BigDecimal assmtId;
     private BigDecimal questionId;
     private BigDecimal assmtItemId;
     private BigDecimal assmtItemPoints;
     private String questionType;

    public AssmtItemDetailId() {
    }

    public AssmtItemDetailId(BigDecimal deliveryContextId, BigDecimal assmtId, BigDecimal questionId, BigDecimal assmtItemId, BigDecimal assmtItemPoints, String questionType) {
       this.deliveryContextId = deliveryContextId;
       this.assmtId = assmtId;
       this.questionId = questionId;
       this.assmtItemId = assmtItemId;
       this.assmtItemPoints = assmtItemPoints;
       this.questionType = questionType;
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


    @Column(name="QUESTION_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getQuestionId() {
        return this.questionId;
    }
    
    public void setQuestionId(BigDecimal questionId) {
        this.questionId = questionId;
    }


    @Column(name="ASSMT_ITEM_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getAssmtItemId() {
        return this.assmtItemId;
    }
    
    public void setAssmtItemId(BigDecimal assmtItemId) {
        this.assmtItemId = assmtItemId;
    }


    @Column(name="ASSMT_ITEM_POINTS", nullable=false, precision=8, scale=4)
    public BigDecimal getAssmtItemPoints() {
        return this.assmtItemPoints;
    }
    
    public void setAssmtItemPoints(BigDecimal assmtItemPoints) {
        this.assmtItemPoints = assmtItemPoints;
    }


    @Column(name="QUESTION_TYPE", nullable=false, length=100)
    public String getQuestionType() {
        return this.questionType;
    }
    
    public void setQuestionType(String questionType) {
        this.questionType = questionType;
    }




}


