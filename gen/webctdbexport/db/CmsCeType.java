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
 * CmsCeType generated by hbm2java
 */
@Entity
@Table(name="CMS_CE_TYPE"
)
public class CmsCeType  implements java.io.Serializable {


     private String name;
     private BigDecimal id;
     private char compositeFlag;
     private boolean uniqueNameFlag;
     private String uniquenessGroup;
     private char pathReachableFlag;
     private byte ringOrder;
     private boolean deletedFlag;
     private boolean shareableContentFlag;
     private boolean requiresCopyFlag;
     private boolean localPresenceFlag;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private Set<CmsCeSubtype> cmsCeSubtypes = new HashSet<CmsCeSubtype>(0);
     private Set<CmsEntryImplInf> cmsEntryImplInfs = new HashSet<CmsEntryImplInf>(0);
     private Set<CalendarEntry> calendarEntries = new HashSet<CalendarEntry>(0);

    public CmsCeType() {
    }

	
    public CmsCeType(String name, BigDecimal id, char compositeFlag, boolean uniqueNameFlag, String uniquenessGroup, char pathReachableFlag, byte ringOrder, boolean deletedFlag, boolean shareableContentFlag, boolean requiresCopyFlag, boolean localPresenceFlag, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.name = name;
        this.id = id;
        this.compositeFlag = compositeFlag;
        this.uniqueNameFlag = uniqueNameFlag;
        this.uniquenessGroup = uniquenessGroup;
        this.pathReachableFlag = pathReachableFlag;
        this.ringOrder = ringOrder;
        this.deletedFlag = deletedFlag;
        this.shareableContentFlag = shareableContentFlag;
        this.requiresCopyFlag = requiresCopyFlag;
        this.localPresenceFlag = localPresenceFlag;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public CmsCeType(String name, BigDecimal id, char compositeFlag, boolean uniqueNameFlag, String uniquenessGroup, char pathReachableFlag, byte ringOrder, boolean deletedFlag, boolean shareableContentFlag, boolean requiresCopyFlag, boolean localPresenceFlag, BigDecimal createTs, BigDecimal lastmodifyTs, Set<CmsCeSubtype> cmsCeSubtypes, Set<CmsEntryImplInf> cmsEntryImplInfs, Set<CalendarEntry> calendarEntries) {
       this.name = name;
       this.id = id;
       this.compositeFlag = compositeFlag;
       this.uniqueNameFlag = uniqueNameFlag;
       this.uniquenessGroup = uniquenessGroup;
       this.pathReachableFlag = pathReachableFlag;
       this.ringOrder = ringOrder;
       this.deletedFlag = deletedFlag;
       this.shareableContentFlag = shareableContentFlag;
       this.requiresCopyFlag = requiresCopyFlag;
       this.localPresenceFlag = localPresenceFlag;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.cmsCeSubtypes = cmsCeSubtypes;
       this.cmsEntryImplInfs = cmsEntryImplInfs;
       this.calendarEntries = calendarEntries;
    }
   
     @Id 

    
    @Column(name="NAME", nullable=false, length=100)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="ID", unique=true, nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="COMPOSITE_FLAG", nullable=false, length=1)
    public char getCompositeFlag() {
        return this.compositeFlag;
    }
    
    public void setCompositeFlag(char compositeFlag) {
        this.compositeFlag = compositeFlag;
    }

    
    @Column(name="UNIQUE_NAME_FLAG", nullable=false, precision=1, scale=0)
    public boolean isUniqueNameFlag() {
        return this.uniqueNameFlag;
    }
    
    public void setUniqueNameFlag(boolean uniqueNameFlag) {
        this.uniqueNameFlag = uniqueNameFlag;
    }

    
    @Column(name="UNIQUENESS_GROUP", nullable=false, length=100)
    public String getUniquenessGroup() {
        return this.uniquenessGroup;
    }
    
    public void setUniquenessGroup(String uniquenessGroup) {
        this.uniquenessGroup = uniquenessGroup;
    }

    
    @Column(name="PATH_REACHABLE_FLAG", nullable=false, length=1)
    public char getPathReachableFlag() {
        return this.pathReachableFlag;
    }
    
    public void setPathReachableFlag(char pathReachableFlag) {
        this.pathReachableFlag = pathReachableFlag;
    }

    
    @Column(name="RING_ORDER", nullable=false, precision=2, scale=0)
    public byte getRingOrder() {
        return this.ringOrder;
    }
    
    public void setRingOrder(byte ringOrder) {
        this.ringOrder = ringOrder;
    }

    
    @Column(name="DELETED_FLAG", nullable=false, precision=1, scale=0)
    public boolean isDeletedFlag() {
        return this.deletedFlag;
    }
    
    public void setDeletedFlag(boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    
    @Column(name="SHAREABLE_CONTENT_FLAG", nullable=false, precision=1, scale=0)
    public boolean isShareableContentFlag() {
        return this.shareableContentFlag;
    }
    
    public void setShareableContentFlag(boolean shareableContentFlag) {
        this.shareableContentFlag = shareableContentFlag;
    }

    
    @Column(name="REQUIRES_COPY_FLAG", nullable=false, precision=1, scale=0)
    public boolean isRequiresCopyFlag() {
        return this.requiresCopyFlag;
    }
    
    public void setRequiresCopyFlag(boolean requiresCopyFlag) {
        this.requiresCopyFlag = requiresCopyFlag;
    }

    
    @Column(name="LOCAL_PRESENCE_FLAG", nullable=false, precision=1, scale=0)
    public boolean isLocalPresenceFlag() {
        return this.localPresenceFlag;
    }
    
    public void setLocalPresenceFlag(boolean localPresenceFlag) {
        this.localPresenceFlag = localPresenceFlag;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="cmsCeType")
    public Set<CmsCeSubtype> getCmsCeSubtypes() {
        return this.cmsCeSubtypes;
    }
    
    public void setCmsCeSubtypes(Set<CmsCeSubtype> cmsCeSubtypes) {
        this.cmsCeSubtypes = cmsCeSubtypes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cmsCeType")
    public Set<CmsEntryImplInf> getCmsEntryImplInfs() {
        return this.cmsEntryImplInfs;
    }
    
    public void setCmsEntryImplInfs(Set<CmsEntryImplInf> cmsEntryImplInfs) {
        this.cmsEntryImplInfs = cmsEntryImplInfs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="cmsCeType")
    public Set<CalendarEntry> getCalendarEntries() {
        return this.calendarEntries;
    }
    
    public void setCalendarEntries(Set<CalendarEntry> calendarEntries) {
        this.calendarEntries = calendarEntries;
    }




}


