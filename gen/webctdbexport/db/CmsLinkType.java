package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * CmsLinkType generated by hbm2java
 */
@Entity
@Table(name="CMS_LINK_TYPE"
)
public class CmsLinkType  implements java.io.Serializable {


     private BigDecimal id;
     private String name;
     private boolean renameEvent;
     private boolean moveEvent;
     private boolean deleteEvent;
     private boolean updateEvent;
     private char pathReachableFlag;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private Set<CmsLink> cmsLinks = new HashSet<CmsLink>(0);

    public CmsLinkType() {
    }

	
    public CmsLinkType(BigDecimal id, String name, boolean renameEvent, boolean moveEvent, boolean deleteEvent, boolean updateEvent, char pathReachableFlag, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.name = name;
        this.renameEvent = renameEvent;
        this.moveEvent = moveEvent;
        this.deleteEvent = deleteEvent;
        this.updateEvent = updateEvent;
        this.pathReachableFlag = pathReachableFlag;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public CmsLinkType(BigDecimal id, String name, boolean renameEvent, boolean moveEvent, boolean deleteEvent, boolean updateEvent, char pathReachableFlag, BigDecimal createTs, BigDecimal lastmodifyTs, Set<CmsLink> cmsLinks) {
       this.id = id;
       this.name = name;
       this.renameEvent = renameEvent;
       this.moveEvent = moveEvent;
       this.deleteEvent = deleteEvent;
       this.updateEvent = updateEvent;
       this.pathReachableFlag = pathReachableFlag;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.cmsLinks = cmsLinks;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="NAME", unique=true, nullable=false, length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="RENAME_EVENT", nullable=false, precision=1, scale=0)
    public boolean isRenameEvent() {
        return this.renameEvent;
    }
    
    public void setRenameEvent(boolean renameEvent) {
        this.renameEvent = renameEvent;
    }

    
    @Column(name="MOVE_EVENT", nullable=false, precision=1, scale=0)
    public boolean isMoveEvent() {
        return this.moveEvent;
    }
    
    public void setMoveEvent(boolean moveEvent) {
        this.moveEvent = moveEvent;
    }

    
    @Column(name="DELETE_EVENT", nullable=false, precision=1, scale=0)
    public boolean isDeleteEvent() {
        return this.deleteEvent;
    }
    
    public void setDeleteEvent(boolean deleteEvent) {
        this.deleteEvent = deleteEvent;
    }

    
    @Column(name="UPDATE_EVENT", nullable=false, precision=1, scale=0)
    public boolean isUpdateEvent() {
        return this.updateEvent;
    }
    
    public void setUpdateEvent(boolean updateEvent) {
        this.updateEvent = updateEvent;
    }

    
    @Column(name="PATH_REACHABLE_FLAG", nullable=false, length=1)
    public char getPathReachableFlag() {
        return this.pathReachableFlag;
    }
    
    public void setPathReachableFlag(char pathReachableFlag) {
        this.pathReachableFlag = pathReachableFlag;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="cmsLinkType")
    public Set<CmsLink> getCmsLinks() {
        return this.cmsLinks;
    }
    
    public void setCmsLinks(Set<CmsLink> cmsLinks) {
        this.cmsLinks = cmsLinks;
    }




}


