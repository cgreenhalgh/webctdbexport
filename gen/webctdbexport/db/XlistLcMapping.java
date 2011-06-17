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
 * XlistLcMapping generated by hbm2java
 */
@Entity
@Table(name="XLIST_LC_MAPPING"
)
public class XlistLcMapping  implements java.io.Serializable {


     private BigDecimal id;
     private LearningContext learningContextByChildLcid;
     private LearningContext learningContextByMasterLcid;
     private String childSourceId;
     private String childSourceName;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public XlistLcMapping() {
    }

    public XlistLcMapping(BigDecimal id, LearningContext learningContextByChildLcid, LearningContext learningContextByMasterLcid, String childSourceId, String childSourceName, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.learningContextByChildLcid = learningContextByChildLcid;
       this.learningContextByMasterLcid = learningContextByMasterLcid;
       this.childSourceId = childSourceId;
       this.childSourceName = childSourceName;
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
    @JoinColumn(name="CHILD_LCID", unique=true, nullable=false)
    public LearningContext getLearningContextByChildLcid() {
        return this.learningContextByChildLcid;
    }
    
    public void setLearningContextByChildLcid(LearningContext learningContextByChildLcid) {
        this.learningContextByChildLcid = learningContextByChildLcid;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="MASTER_LCID", nullable=false)
    public LearningContext getLearningContextByMasterLcid() {
        return this.learningContextByMasterLcid;
    }
    
    public void setLearningContextByMasterLcid(LearningContext learningContextByMasterLcid) {
        this.learningContextByMasterLcid = learningContextByMasterLcid;
    }

    
    @Column(name="CHILD_SOURCE_ID", nullable=false, length=768)
    public String getChildSourceId() {
        return this.childSourceId;
    }
    
    public void setChildSourceId(String childSourceId) {
        this.childSourceId = childSourceId;
    }

    
    @Column(name="CHILD_SOURCE_NAME", nullable=false, length=510)
    public String getChildSourceName() {
        return this.childSourceName;
    }
    
    public void setChildSourceName(String childSourceName) {
        this.childSourceName = childSourceName;
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


