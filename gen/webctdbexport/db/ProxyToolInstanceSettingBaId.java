package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProxyToolInstanceSettingBaId generated by hbm2java
 */
@Embeddable
public class ProxyToolInstanceSettingBaId  implements java.io.Serializable {


     private BigDecimal id;
     private BigDecimal toolInstanceId;
     private String name;
     private String value;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public ProxyToolInstanceSettingBaId() {
    }

    public ProxyToolInstanceSettingBaId(BigDecimal id, BigDecimal toolInstanceId, String name, String value, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.toolInstanceId = toolInstanceId;
       this.name = name;
       this.value = value;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
    }
   


    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }


    @Column(name="TOOL_INSTANCE_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getToolInstanceId() {
        return this.toolInstanceId;
    }
    
    public void setToolInstanceId(BigDecimal toolInstanceId) {
        this.toolInstanceId = toolInstanceId;
    }


    @Column(name="NAME", nullable=false, length=800)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    @Column(name="VALUE", nullable=false, length=800)
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
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




}


