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
 * DirectoryGroupUser generated by hbm2java
 */
@Entity
@Table(name="DIRECTORY_GROUP_USER"
)
public class DirectoryGroupUser  implements java.io.Serializable {


     private BigDecimal id;
     private DirectoryGroup directoryGroup;
     private DirectoryObject directoryObject;
     private boolean inactiveFlag;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public DirectoryGroupUser() {
    }

    public DirectoryGroupUser(BigDecimal id, DirectoryGroup directoryGroup, DirectoryObject directoryObject, boolean inactiveFlag, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.directoryGroup = directoryGroup;
       this.directoryObject = directoryObject;
       this.inactiveFlag = inactiveFlag;
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
    @JoinColumn(name="GROUP_ID", nullable=false)
    public DirectoryGroup getDirectoryGroup() {
        return this.directoryGroup;
    }
    
    public void setDirectoryGroup(DirectoryGroup directoryGroup) {
        this.directoryGroup = directoryGroup;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DIRECTORY_OBJECT_ID", nullable=false)
    public DirectoryObject getDirectoryObject() {
        return this.directoryObject;
    }
    
    public void setDirectoryObject(DirectoryObject directoryObject) {
        this.directoryObject = directoryObject;
    }

    
    @Column(name="INACTIVE_FLAG", nullable=false, precision=1, scale=0)
    public boolean isInactiveFlag() {
        return this.inactiveFlag;
    }
    
    public void setInactiveFlag(boolean inactiveFlag) {
        this.inactiveFlag = inactiveFlag;
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


