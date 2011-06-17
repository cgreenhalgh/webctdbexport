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
 * MlChangeQueue generated by hbm2java
 */
@Entity
@Table(name="ML_CHANGE_QUEUE"
)
public class MlChangeQueue  implements java.io.Serializable {


     private BigDecimal id;
     private CoTemplate coTemplate;
     private MlEntry mlEntry;
     private String name;
     private BigDecimal changeDate;
     private String changeType;
     private boolean linkType;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public MlChangeQueue() {
    }

    public MlChangeQueue(BigDecimal id, CoTemplate coTemplate, MlEntry mlEntry, String name, BigDecimal changeDate, String changeType, boolean linkType, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.coTemplate = coTemplate;
       this.mlEntry = mlEntry;
       this.name = name;
       this.changeDate = changeDate;
       this.changeType = changeType;
       this.linkType = linkType;
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
    @JoinColumn(name="TEMPLATE_ID", nullable=false)
    public CoTemplate getCoTemplate() {
        return this.coTemplate;
    }
    
    public void setCoTemplate(CoTemplate coTemplate) {
        this.coTemplate = coTemplate;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="ENTRY_ID", nullable=false)
    public MlEntry getMlEntry() {
        return this.mlEntry;
    }
    
    public void setMlEntry(MlEntry mlEntry) {
        this.mlEntry = mlEntry;
    }

    
    @Column(name="NAME", nullable=false, length=1000)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="CHANGE_DATE", nullable=false, precision=20, scale=0)
    public BigDecimal getChangeDate() {
        return this.changeDate;
    }
    
    public void setChangeDate(BigDecimal changeDate) {
        this.changeDate = changeDate;
    }

    
    @Column(name="CHANGE_TYPE", nullable=false, length=40)
    public String getChangeType() {
        return this.changeType;
    }
    
    public void setChangeType(String changeType) {
        this.changeType = changeType;
    }

    
    @Column(name="LINK_TYPE", nullable=false, precision=1, scale=0)
    public boolean isLinkType() {
        return this.linkType;
    }
    
    public void setLinkType(boolean linkType) {
        this.linkType = linkType;
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


