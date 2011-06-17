package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * CmToolUsed generated by hbm2java
 */
@Entity
@Table(name="CM_TOOL_USED"
)
public class CmToolUsed  implements java.io.Serializable {


     private BigDecimal id;
     private CmTool cmTool;
     private CmCoursemenu cmCoursemenu;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public CmToolUsed() {
    }

    public CmToolUsed(BigDecimal id, CmTool cmTool, CmCoursemenu cmCoursemenu, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.cmTool = cmTool;
       this.cmCoursemenu = cmCoursemenu;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
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
    @JoinColumn(name="TOOL_ID", nullable=false)
    public CmTool getCmTool() {
        return this.cmTool;
    }
    
    public void setCmTool(CmTool cmTool) {
        this.cmTool = cmTool;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="COURSEMENU_ID", nullable=false)
    public CmCoursemenu getCmCoursemenu() {
        return this.cmCoursemenu;
    }
    
    public void setCmCoursemenu(CmCoursemenu cmCoursemenu) {
        this.cmCoursemenu = cmCoursemenu;
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


