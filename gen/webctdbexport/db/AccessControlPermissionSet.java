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
 * AccessControlPermissionSet generated by hbm2java
 */
@Entity
@Table(name="ACCESS_CONTROL_PERMISSION_SET"
)
public class AccessControlPermissionSet  implements java.io.Serializable {


     private BigDecimal id;
     private String name;
     private boolean immutableFlag;
     private boolean aclRead;
     private boolean aclWrite;
     private boolean aclDelete;
     private boolean aclAccessArea;
     private boolean aclPreview;
     private boolean aclCreateFolder;
     private boolean aclCreateContent;
     private boolean aclUpload;
     private boolean aclRenameContent;
     private boolean aclRenameFolder;
     private boolean aclEditContent;
     private boolean aclDeclareCharacterset;
     private boolean aclDeleteContent;
     private boolean aclDeleteFolder;
     private boolean aclDeleteDeliveryContext;
     private boolean aclCopy;
     private boolean aclMove;
     private boolean aclPublishto;
     private boolean aclPublish;
     private boolean aclPackage;
     private boolean aclExtract;
     private boolean aclManageRepSettings;
     private boolean aclRenameRepository;
     private boolean aclSetPermission;
     private boolean aclViewContentUsage;
     private boolean aclListContent;
     private boolean systemFlag;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private Set<AccessControlEntry> accessControlEntries = new HashSet<AccessControlEntry>(0);

    public AccessControlPermissionSet() {
    }

	
    public AccessControlPermissionSet(BigDecimal id, String name, boolean immutableFlag, boolean aclRead, boolean aclWrite, boolean aclDelete, boolean aclAccessArea, boolean aclPreview, boolean aclCreateFolder, boolean aclCreateContent, boolean aclUpload, boolean aclRenameContent, boolean aclRenameFolder, boolean aclEditContent, boolean aclDeclareCharacterset, boolean aclDeleteContent, boolean aclDeleteFolder, boolean aclDeleteDeliveryContext, boolean aclCopy, boolean aclMove, boolean aclPublishto, boolean aclPublish, boolean aclPackage, boolean aclExtract, boolean aclManageRepSettings, boolean aclRenameRepository, boolean aclSetPermission, boolean aclViewContentUsage, boolean aclListContent, boolean systemFlag, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.name = name;
        this.immutableFlag = immutableFlag;
        this.aclRead = aclRead;
        this.aclWrite = aclWrite;
        this.aclDelete = aclDelete;
        this.aclAccessArea = aclAccessArea;
        this.aclPreview = aclPreview;
        this.aclCreateFolder = aclCreateFolder;
        this.aclCreateContent = aclCreateContent;
        this.aclUpload = aclUpload;
        this.aclRenameContent = aclRenameContent;
        this.aclRenameFolder = aclRenameFolder;
        this.aclEditContent = aclEditContent;
        this.aclDeclareCharacterset = aclDeclareCharacterset;
        this.aclDeleteContent = aclDeleteContent;
        this.aclDeleteFolder = aclDeleteFolder;
        this.aclDeleteDeliveryContext = aclDeleteDeliveryContext;
        this.aclCopy = aclCopy;
        this.aclMove = aclMove;
        this.aclPublishto = aclPublishto;
        this.aclPublish = aclPublish;
        this.aclPackage = aclPackage;
        this.aclExtract = aclExtract;
        this.aclManageRepSettings = aclManageRepSettings;
        this.aclRenameRepository = aclRenameRepository;
        this.aclSetPermission = aclSetPermission;
        this.aclViewContentUsage = aclViewContentUsage;
        this.aclListContent = aclListContent;
        this.systemFlag = systemFlag;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public AccessControlPermissionSet(BigDecimal id, String name, boolean immutableFlag, boolean aclRead, boolean aclWrite, boolean aclDelete, boolean aclAccessArea, boolean aclPreview, boolean aclCreateFolder, boolean aclCreateContent, boolean aclUpload, boolean aclRenameContent, boolean aclRenameFolder, boolean aclEditContent, boolean aclDeclareCharacterset, boolean aclDeleteContent, boolean aclDeleteFolder, boolean aclDeleteDeliveryContext, boolean aclCopy, boolean aclMove, boolean aclPublishto, boolean aclPublish, boolean aclPackage, boolean aclExtract, boolean aclManageRepSettings, boolean aclRenameRepository, boolean aclSetPermission, boolean aclViewContentUsage, boolean aclListContent, boolean systemFlag, BigDecimal createTs, BigDecimal lastmodifyTs, Set<AccessControlEntry> accessControlEntries) {
       this.id = id;
       this.name = name;
       this.immutableFlag = immutableFlag;
       this.aclRead = aclRead;
       this.aclWrite = aclWrite;
       this.aclDelete = aclDelete;
       this.aclAccessArea = aclAccessArea;
       this.aclPreview = aclPreview;
       this.aclCreateFolder = aclCreateFolder;
       this.aclCreateContent = aclCreateContent;
       this.aclUpload = aclUpload;
       this.aclRenameContent = aclRenameContent;
       this.aclRenameFolder = aclRenameFolder;
       this.aclEditContent = aclEditContent;
       this.aclDeclareCharacterset = aclDeclareCharacterset;
       this.aclDeleteContent = aclDeleteContent;
       this.aclDeleteFolder = aclDeleteFolder;
       this.aclDeleteDeliveryContext = aclDeleteDeliveryContext;
       this.aclCopy = aclCopy;
       this.aclMove = aclMove;
       this.aclPublishto = aclPublishto;
       this.aclPublish = aclPublish;
       this.aclPackage = aclPackage;
       this.aclExtract = aclExtract;
       this.aclManageRepSettings = aclManageRepSettings;
       this.aclRenameRepository = aclRenameRepository;
       this.aclSetPermission = aclSetPermission;
       this.aclViewContentUsage = aclViewContentUsage;
       this.aclListContent = aclListContent;
       this.systemFlag = systemFlag;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.accessControlEntries = accessControlEntries;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="NAME", unique=true, nullable=false, length=128)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="IMMUTABLE_FLAG", nullable=false, precision=1, scale=0)
    public boolean isImmutableFlag() {
        return this.immutableFlag;
    }
    
    public void setImmutableFlag(boolean immutableFlag) {
        this.immutableFlag = immutableFlag;
    }

    
    @Column(name="ACL_READ", nullable=false, precision=1, scale=0)
    public boolean isAclRead() {
        return this.aclRead;
    }
    
    public void setAclRead(boolean aclRead) {
        this.aclRead = aclRead;
    }

    
    @Column(name="ACL_WRITE", nullable=false, precision=1, scale=0)
    public boolean isAclWrite() {
        return this.aclWrite;
    }
    
    public void setAclWrite(boolean aclWrite) {
        this.aclWrite = aclWrite;
    }

    
    @Column(name="ACL_DELETE", nullable=false, precision=1, scale=0)
    public boolean isAclDelete() {
        return this.aclDelete;
    }
    
    public void setAclDelete(boolean aclDelete) {
        this.aclDelete = aclDelete;
    }

    
    @Column(name="ACL_ACCESS_AREA", nullable=false, precision=1, scale=0)
    public boolean isAclAccessArea() {
        return this.aclAccessArea;
    }
    
    public void setAclAccessArea(boolean aclAccessArea) {
        this.aclAccessArea = aclAccessArea;
    }

    
    @Column(name="ACL_PREVIEW", nullable=false, precision=1, scale=0)
    public boolean isAclPreview() {
        return this.aclPreview;
    }
    
    public void setAclPreview(boolean aclPreview) {
        this.aclPreview = aclPreview;
    }

    
    @Column(name="ACL_CREATE_FOLDER", nullable=false, precision=1, scale=0)
    public boolean isAclCreateFolder() {
        return this.aclCreateFolder;
    }
    
    public void setAclCreateFolder(boolean aclCreateFolder) {
        this.aclCreateFolder = aclCreateFolder;
    }

    
    @Column(name="ACL_CREATE_CONTENT", nullable=false, precision=1, scale=0)
    public boolean isAclCreateContent() {
        return this.aclCreateContent;
    }
    
    public void setAclCreateContent(boolean aclCreateContent) {
        this.aclCreateContent = aclCreateContent;
    }

    
    @Column(name="ACL_UPLOAD", nullable=false, precision=1, scale=0)
    public boolean isAclUpload() {
        return this.aclUpload;
    }
    
    public void setAclUpload(boolean aclUpload) {
        this.aclUpload = aclUpload;
    }

    
    @Column(name="ACL_RENAME_CONTENT", nullable=false, precision=1, scale=0)
    public boolean isAclRenameContent() {
        return this.aclRenameContent;
    }
    
    public void setAclRenameContent(boolean aclRenameContent) {
        this.aclRenameContent = aclRenameContent;
    }

    
    @Column(name="ACL_RENAME_FOLDER", nullable=false, precision=1, scale=0)
    public boolean isAclRenameFolder() {
        return this.aclRenameFolder;
    }
    
    public void setAclRenameFolder(boolean aclRenameFolder) {
        this.aclRenameFolder = aclRenameFolder;
    }

    
    @Column(name="ACL_EDIT_CONTENT", nullable=false, precision=1, scale=0)
    public boolean isAclEditContent() {
        return this.aclEditContent;
    }
    
    public void setAclEditContent(boolean aclEditContent) {
        this.aclEditContent = aclEditContent;
    }

    
    @Column(name="ACL_DECLARE_CHARACTERSET", nullable=false, precision=1, scale=0)
    public boolean isAclDeclareCharacterset() {
        return this.aclDeclareCharacterset;
    }
    
    public void setAclDeclareCharacterset(boolean aclDeclareCharacterset) {
        this.aclDeclareCharacterset = aclDeclareCharacterset;
    }

    
    @Column(name="ACL_DELETE_CONTENT", nullable=false, precision=1, scale=0)
    public boolean isAclDeleteContent() {
        return this.aclDeleteContent;
    }
    
    public void setAclDeleteContent(boolean aclDeleteContent) {
        this.aclDeleteContent = aclDeleteContent;
    }

    
    @Column(name="ACL_DELETE_FOLDER", nullable=false, precision=1, scale=0)
    public boolean isAclDeleteFolder() {
        return this.aclDeleteFolder;
    }
    
    public void setAclDeleteFolder(boolean aclDeleteFolder) {
        this.aclDeleteFolder = aclDeleteFolder;
    }

    
    @Column(name="ACL_DELETE_DELIVERY_CONTEXT", nullable=false, precision=1, scale=0)
    public boolean isAclDeleteDeliveryContext() {
        return this.aclDeleteDeliveryContext;
    }
    
    public void setAclDeleteDeliveryContext(boolean aclDeleteDeliveryContext) {
        this.aclDeleteDeliveryContext = aclDeleteDeliveryContext;
    }

    
    @Column(name="ACL_COPY", nullable=false, precision=1, scale=0)
    public boolean isAclCopy() {
        return this.aclCopy;
    }
    
    public void setAclCopy(boolean aclCopy) {
        this.aclCopy = aclCopy;
    }

    
    @Column(name="ACL_MOVE", nullable=false, precision=1, scale=0)
    public boolean isAclMove() {
        return this.aclMove;
    }
    
    public void setAclMove(boolean aclMove) {
        this.aclMove = aclMove;
    }

    
    @Column(name="ACL_PUBLISHTO", nullable=false, precision=1, scale=0)
    public boolean isAclPublishto() {
        return this.aclPublishto;
    }
    
    public void setAclPublishto(boolean aclPublishto) {
        this.aclPublishto = aclPublishto;
    }

    
    @Column(name="ACL_PUBLISH", nullable=false, precision=1, scale=0)
    public boolean isAclPublish() {
        return this.aclPublish;
    }
    
    public void setAclPublish(boolean aclPublish) {
        this.aclPublish = aclPublish;
    }

    
    @Column(name="ACL_PACKAGE", nullable=false, precision=1, scale=0)
    public boolean isAclPackage() {
        return this.aclPackage;
    }
    
    public void setAclPackage(boolean aclPackage) {
        this.aclPackage = aclPackage;
    }

    
    @Column(name="ACL_EXTRACT", nullable=false, precision=1, scale=0)
    public boolean isAclExtract() {
        return this.aclExtract;
    }
    
    public void setAclExtract(boolean aclExtract) {
        this.aclExtract = aclExtract;
    }

    
    @Column(name="ACL_MANAGE_REP_SETTINGS", nullable=false, precision=1, scale=0)
    public boolean isAclManageRepSettings() {
        return this.aclManageRepSettings;
    }
    
    public void setAclManageRepSettings(boolean aclManageRepSettings) {
        this.aclManageRepSettings = aclManageRepSettings;
    }

    
    @Column(name="ACL_RENAME_REPOSITORY", nullable=false, precision=1, scale=0)
    public boolean isAclRenameRepository() {
        return this.aclRenameRepository;
    }
    
    public void setAclRenameRepository(boolean aclRenameRepository) {
        this.aclRenameRepository = aclRenameRepository;
    }

    
    @Column(name="ACL_SET_PERMISSION", nullable=false, precision=1, scale=0)
    public boolean isAclSetPermission() {
        return this.aclSetPermission;
    }
    
    public void setAclSetPermission(boolean aclSetPermission) {
        this.aclSetPermission = aclSetPermission;
    }

    
    @Column(name="ACL_VIEW_CONTENT_USAGE", nullable=false, precision=1, scale=0)
    public boolean isAclViewContentUsage() {
        return this.aclViewContentUsage;
    }
    
    public void setAclViewContentUsage(boolean aclViewContentUsage) {
        this.aclViewContentUsage = aclViewContentUsage;
    }

    
    @Column(name="ACL_LIST_CONTENT", nullable=false, precision=1, scale=0)
    public boolean isAclListContent() {
        return this.aclListContent;
    }
    
    public void setAclListContent(boolean aclListContent) {
        this.aclListContent = aclListContent;
    }

    
    @Column(name="SYSTEM_FLAG", nullable=false, precision=1, scale=0)
    public boolean isSystemFlag() {
        return this.systemFlag;
    }
    
    public void setSystemFlag(boolean systemFlag) {
        this.systemFlag = systemFlag;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="accessControlPermissionSet")
    public Set<AccessControlEntry> getAccessControlEntries() {
        return this.accessControlEntries;
    }
    
    public void setAccessControlEntries(Set<AccessControlEntry> accessControlEntries) {
        this.accessControlEntries = accessControlEntries;
    }




}


