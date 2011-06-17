package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.sql.Clob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AssmtResponse generated by hbm2java
 */
@Entity
@Table(name="ASSMT_RESPONSE"
)
public class AssmtResponse  implements java.io.Serializable {


     private BigDecimal id;
     private AssmtAttemptEvent assmtAttemptEvent;
     private AssmtAttemptItem assmtAttemptItem;
     private String ident;
     private int position;
     private String resType;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private String smallValue;
     private Clob largeValue;
     private BigDecimal numValue;
     private Integer exponent;

    public AssmtResponse() {
    }

	
    public AssmtResponse(BigDecimal id, AssmtAttemptEvent assmtAttemptEvent, String ident, int position, String resType, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.assmtAttemptEvent = assmtAttemptEvent;
        this.ident = ident;
        this.position = position;
        this.resType = resType;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public AssmtResponse(BigDecimal id, AssmtAttemptEvent assmtAttemptEvent, AssmtAttemptItem assmtAttemptItem, String ident, int position, String resType, BigDecimal createTs, BigDecimal lastmodifyTs, String smallValue, Clob largeValue, BigDecimal numValue, Integer exponent) {
       this.id = id;
       this.assmtAttemptEvent = assmtAttemptEvent;
       this.assmtAttemptItem = assmtAttemptItem;
       this.ident = ident;
       this.position = position;
       this.resType = resType;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.smallValue = smallValue;
       this.largeValue = largeValue;
       this.numValue = numValue;
       this.exponent = exponent;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ATTEMPT_EVENT_ID", nullable=false)
    public AssmtAttemptEvent getAssmtAttemptEvent() {
        return this.assmtAttemptEvent;
    }
    
    public void setAssmtAttemptEvent(AssmtAttemptEvent assmtAttemptEvent) {
        this.assmtAttemptEvent = assmtAttemptEvent;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ATTEMPT_ITEM_ID")
    public AssmtAttemptItem getAssmtAttemptItem() {
        return this.assmtAttemptItem;
    }
    
    public void setAssmtAttemptItem(AssmtAttemptItem assmtAttemptItem) {
        this.assmtAttemptItem = assmtAttemptItem;
    }

    
    @Column(name="IDENT", nullable=false, length=768)
    public String getIdent() {
        return this.ident;
    }
    
    public void setIdent(String ident) {
        this.ident = ident;
    }

    
    @Column(name="POSITION", nullable=false, precision=8, scale=0)
    public int getPosition() {
        return this.position;
    }
    
    public void setPosition(int position) {
        this.position = position;
    }

    
    @Column(name="RES_TYPE", nullable=false, length=10)
    public String getResType() {
        return this.resType;
    }
    
    public void setResType(String resType) {
        this.resType = resType;
    }

    
    @Column(name="CREATE_TS", nullable=false, precision=20, scale=0)
    public BigDecimal getCreateTs() {
        return this.createTs;
    }
    
    public void setCreateTs(BigDecimal createTs) {
        this.createTs = createTs;
    }

    
    @Column(name="LASTMODIFY_TS", nullable=false, precision=20, scale=0)
    public BigDecimal getLastmodifyTs() {
        return this.lastmodifyTs;
    }
    
    public void setLastmodifyTs(BigDecimal lastmodifyTs) {
        this.lastmodifyTs = lastmodifyTs;
    }

    
    @Column(name="SMALL_VALUE", length=4000)
    public String getSmallValue() {
        return this.smallValue;
    }
    
    public void setSmallValue(String smallValue) {
        this.smallValue = smallValue;
    }

    
    @Column(name="LARGE_VALUE")
    public Clob getLargeValue() {
        return this.largeValue;
    }
    
    public void setLargeValue(Clob largeValue) {
        this.largeValue = largeValue;
    }

    
    @Column(name="NUM_VALUE", precision=30, scale=10)
    public BigDecimal getNumValue() {
        return this.numValue;
    }
    
    public void setNumValue(BigDecimal numValue) {
        this.numValue = numValue;
    }

    
    @Column(name="EXPONENT", precision=5, scale=0)
    public Integer getExponent() {
        return this.exponent;
    }
    
    public void setExponent(Integer exponent) {
        this.exponent = exponent;
    }




}


