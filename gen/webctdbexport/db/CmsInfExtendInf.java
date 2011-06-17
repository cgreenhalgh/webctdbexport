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
 * CmsInfExtendInf generated by hbm2java
 */
@Entity
@Table(name="CMS_INF_EXTEND_INF"
)
public class CmsInfExtendInf  implements java.io.Serializable {


     private BigDecimal id;
     private CmsInterfaceType cmsInterfaceTypeBySubInfId;
     private CmsInterfaceType cmsInterfaceTypeByInfId;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public CmsInfExtendInf() {
    }

    public CmsInfExtendInf(BigDecimal id, CmsInterfaceType cmsInterfaceTypeBySubInfId, CmsInterfaceType cmsInterfaceTypeByInfId, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.cmsInterfaceTypeBySubInfId = cmsInterfaceTypeBySubInfId;
       this.cmsInterfaceTypeByInfId = cmsInterfaceTypeByInfId;
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
    @JoinColumn(name="SUB_INF_ID", nullable=false)
    public CmsInterfaceType getCmsInterfaceTypeBySubInfId() {
        return this.cmsInterfaceTypeBySubInfId;
    }
    
    public void setCmsInterfaceTypeBySubInfId(CmsInterfaceType cmsInterfaceTypeBySubInfId) {
        this.cmsInterfaceTypeBySubInfId = cmsInterfaceTypeBySubInfId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="INF_ID", nullable=false)
    public CmsInterfaceType getCmsInterfaceTypeByInfId() {
        return this.cmsInterfaceTypeByInfId;
    }
    
    public void setCmsInterfaceTypeByInfId(CmsInterfaceType cmsInterfaceTypeByInfId) {
        this.cmsInterfaceTypeByInfId = cmsInterfaceTypeByInfId;
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


