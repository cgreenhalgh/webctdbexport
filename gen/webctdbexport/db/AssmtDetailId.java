package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * AssmtDetailId generated by hbm2java
 */
@Embeddable
public class AssmtDetailId  implements java.io.Serializable {


     private BigDecimal deliveryContextId;
     private BigDecimal assmtId;
     private BigDecimal assmtPoints;

    public AssmtDetailId() {
    }

    public AssmtDetailId(BigDecimal deliveryContextId, BigDecimal assmtId, BigDecimal assmtPoints) {
       this.deliveryContextId = deliveryContextId;
       this.assmtId = assmtId;
       this.assmtPoints = assmtPoints;
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


    @Column(name="ASSMT_POINTS", nullable=false, precision=12, scale=4)
    public BigDecimal getAssmtPoints() {
        return this.assmtPoints;
    }
    
    public void setAssmtPoints(BigDecimal assmtPoints) {
        this.assmtPoints = assmtPoints;
    }




}


