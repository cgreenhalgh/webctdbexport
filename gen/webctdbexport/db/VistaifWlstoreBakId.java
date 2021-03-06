package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * VistaifWlstoreBakId generated by hbm2java
 */
@Embeddable
public class VistaifWlstoreBakId  implements java.io.Serializable {


     private BigDecimal id;
     private BigDecimal type;
     private BigDecimal handle;
     private byte[] record;

    public VistaifWlstoreBakId() {
    }

    public VistaifWlstoreBakId(BigDecimal id, BigDecimal type, BigDecimal handle, byte[] record) {
       this.id = id;
       this.type = type;
       this.handle = handle;
       this.record = record;
    }
   


    @Column(name="ID", nullable=false, precision=22, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }


    @Column(name="TYPE", nullable=false, precision=22, scale=0)
    public BigDecimal getType() {
        return this.type;
    }
    
    public void setType(BigDecimal type) {
        this.type = type;
    }


    @Column(name="HANDLE", nullable=false, precision=22, scale=0)
    public BigDecimal getHandle() {
        return this.handle;
    }
    
    public void setHandle(BigDecimal handle) {
        this.handle = handle;
    }


    @Column(name="RECORD", nullable=false)
    public byte[] getRecord() {
        return this.record;
    }
    
    public void setRecord(byte[] record) {
        this.record = record;
    }




}


