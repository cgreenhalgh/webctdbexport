package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AssmtItemMemberStatId generated by hbm2java
 */
@Embeddable
public class AssmtItemMemberStatId  implements java.io.Serializable {


     private BigDecimal processId;
     private BigDecimal deliveryContextId;
     private BigDecimal memberId;
     private BigDecimal assmtId;
     private BigDecimal assmtItemId;
     private BigDecimal assmtItemPoints;
     private BigDecimal assmtItemScore;
     private BigDecimal assmtItemRatioScore;

    public AssmtItemMemberStatId() {
    }

    public AssmtItemMemberStatId(BigDecimal processId, BigDecimal deliveryContextId, BigDecimal memberId, BigDecimal assmtId, BigDecimal assmtItemId, BigDecimal assmtItemPoints, BigDecimal assmtItemScore, BigDecimal assmtItemRatioScore) {
       this.processId = processId;
       this.deliveryContextId = deliveryContextId;
       this.memberId = memberId;
       this.assmtId = assmtId;
       this.assmtItemId = assmtItemId;
       this.assmtItemPoints = assmtItemPoints;
       this.assmtItemScore = assmtItemScore;
       this.assmtItemRatioScore = assmtItemRatioScore;
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


    @Column(name="MEMBER_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getMemberId() {
        return this.memberId;
    }
    
    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
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


    @Column(name="ASSMT_ITEM_POINTS", nullable=false, precision=6)
    public BigDecimal getAssmtItemPoints() {
        return this.assmtItemPoints;
    }
    
    public void setAssmtItemPoints(BigDecimal assmtItemPoints) {
        this.assmtItemPoints = assmtItemPoints;
    }


    @Column(name="ASSMT_ITEM_SCORE", nullable=false, precision=22, scale=0)
    public BigDecimal getAssmtItemScore() {
        return this.assmtItemScore;
    }
    
    public void setAssmtItemScore(BigDecimal assmtItemScore) {
        this.assmtItemScore = assmtItemScore;
    }


    @Column(name="ASSMT_ITEM_RATIO_SCORE", nullable=false, precision=22, scale=0)
    public BigDecimal getAssmtItemRatioScore() {
        return this.assmtItemRatioScore;
    }
    
    public void setAssmtItemRatioScore(BigDecimal assmtItemRatioScore) {
        this.assmtItemRatioScore = assmtItemRatioScore;
    }




}


