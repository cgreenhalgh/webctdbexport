package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * ProxyToolInstanceBakId generated by hbm2java
 */
@Embeddable
public class ProxyToolInstanceBakId  implements java.io.Serializable {


     private BigDecimal id;
     private String name;
     private boolean newWindowFlag;
     private BigDecimal toolDefId;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public ProxyToolInstanceBakId() {
    }

    public ProxyToolInstanceBakId(BigDecimal id, String name, boolean newWindowFlag, BigDecimal toolDefId, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.name = name;
       this.newWindowFlag = newWindowFlag;
       this.toolDefId = toolDefId;
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


    @Column(name="NAME", nullable=false, length=1000)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }


    @Column(name="NEW_WINDOW_FLAG", nullable=false, precision=1, scale=0)
    public boolean isNewWindowFlag() {
        return this.newWindowFlag;
    }
    
    public void setNewWindowFlag(boolean newWindowFlag) {
        this.newWindowFlag = newWindowFlag;
    }


    @Column(name="TOOL_DEF_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getToolDefId() {
        return this.toolDefId;
    }
    
    public void setToolDefId(BigDecimal toolDefId) {
        this.toolDefId = toolDefId;
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


