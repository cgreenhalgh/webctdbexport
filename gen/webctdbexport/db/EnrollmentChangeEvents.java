package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EnrollmentChangeEvents generated by hbm2java
 */
@Entity
@Table(name="ENROLLMENT_CHANGE_EVENTS"
)
public class EnrollmentChangeEvents  implements java.io.Serializable {


     private BigDecimal id;
     private BigDecimal instLcid;
     private BigDecimal learningContextId;
     private String lcSourceId;
     private String lcSourceName;
     private BigDecimal personId;
     private String webctId;
     private String personSourceId;
     private String personSourceName;
     private boolean deletedFlag;
     private boolean statusFlag;
     private BigDecimal memberId;
     private BigDecimal roleId;
     private String roleName;
     private boolean processingStatus;
     private BigDecimal processingTs;
     private BigDecimal mark;
     private BigDecimal childMemberId;

    public EnrollmentChangeEvents() {
    }

	
    public EnrollmentChangeEvents(BigDecimal id, BigDecimal instLcid, BigDecimal learningContextId, String lcSourceId, String lcSourceName, BigDecimal personId, String webctId, String personSourceId, String personSourceName, boolean deletedFlag, boolean statusFlag, BigDecimal memberId, BigDecimal roleId, String roleName, boolean processingStatus, BigDecimal processingTs) {
        this.id = id;
        this.instLcid = instLcid;
        this.learningContextId = learningContextId;
        this.lcSourceId = lcSourceId;
        this.lcSourceName = lcSourceName;
        this.personId = personId;
        this.webctId = webctId;
        this.personSourceId = personSourceId;
        this.personSourceName = personSourceName;
        this.deletedFlag = deletedFlag;
        this.statusFlag = statusFlag;
        this.memberId = memberId;
        this.roleId = roleId;
        this.roleName = roleName;
        this.processingStatus = processingStatus;
        this.processingTs = processingTs;
    }
    public EnrollmentChangeEvents(BigDecimal id, BigDecimal instLcid, BigDecimal learningContextId, String lcSourceId, String lcSourceName, BigDecimal personId, String webctId, String personSourceId, String personSourceName, boolean deletedFlag, boolean statusFlag, BigDecimal memberId, BigDecimal roleId, String roleName, boolean processingStatus, BigDecimal processingTs, BigDecimal mark, BigDecimal childMemberId) {
       this.id = id;
       this.instLcid = instLcid;
       this.learningContextId = learningContextId;
       this.lcSourceId = lcSourceId;
       this.lcSourceName = lcSourceName;
       this.personId = personId;
       this.webctId = webctId;
       this.personSourceId = personSourceId;
       this.personSourceName = personSourceName;
       this.deletedFlag = deletedFlag;
       this.statusFlag = statusFlag;
       this.memberId = memberId;
       this.roleId = roleId;
       this.roleName = roleName;
       this.processingStatus = processingStatus;
       this.processingTs = processingTs;
       this.mark = mark;
       this.childMemberId = childMemberId;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="INST_LCID", nullable=false, precision=20, scale=0)
    public BigDecimal getInstLcid() {
        return this.instLcid;
    }
    
    public void setInstLcid(BigDecimal instLcid) {
        this.instLcid = instLcid;
    }

    
    @Column(name="LEARNING_CONTEXT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getLearningContextId() {
        return this.learningContextId;
    }
    
    public void setLearningContextId(BigDecimal learningContextId) {
        this.learningContextId = learningContextId;
    }

    
    @Column(name="LC_SOURCE_ID", nullable=false, length=768)
    public String getLcSourceId() {
        return this.lcSourceId;
    }
    
    public void setLcSourceId(String lcSourceId) {
        this.lcSourceId = lcSourceId;
    }

    
    @Column(name="LC_SOURCE_NAME", nullable=false, length=510)
    public String getLcSourceName() {
        return this.lcSourceName;
    }
    
    public void setLcSourceName(String lcSourceName) {
        this.lcSourceName = lcSourceName;
    }

    
    @Column(name="PERSON_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(BigDecimal personId) {
        this.personId = personId;
    }

    
    @Column(name="WEBCT_ID", nullable=false, length=768)
    public String getWebctId() {
        return this.webctId;
    }
    
    public void setWebctId(String webctId) {
        this.webctId = webctId;
    }

    
    @Column(name="PERSON_SOURCE_ID", nullable=false, length=768)
    public String getPersonSourceId() {
        return this.personSourceId;
    }
    
    public void setPersonSourceId(String personSourceId) {
        this.personSourceId = personSourceId;
    }

    
    @Column(name="PERSON_SOURCE_NAME", nullable=false, length=510)
    public String getPersonSourceName() {
        return this.personSourceName;
    }
    
    public void setPersonSourceName(String personSourceName) {
        this.personSourceName = personSourceName;
    }

    
    @Column(name="DELETED_FLAG", nullable=false, precision=1, scale=0)
    public boolean isDeletedFlag() {
        return this.deletedFlag;
    }
    
    public void setDeletedFlag(boolean deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    
    @Column(name="STATUS_FLAG", nullable=false, precision=1, scale=0)
    public boolean isStatusFlag() {
        return this.statusFlag;
    }
    
    public void setStatusFlag(boolean statusFlag) {
        this.statusFlag = statusFlag;
    }

    
    @Column(name="MEMBER_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getMemberId() {
        return this.memberId;
    }
    
    public void setMemberId(BigDecimal memberId) {
        this.memberId = memberId;
    }

    
    @Column(name="ROLE_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getRoleId() {
        return this.roleId;
    }
    
    public void setRoleId(BigDecimal roleId) {
        this.roleId = roleId;
    }

    
    @Column(name="ROLE_NAME", nullable=false, length=30)
    public String getRoleName() {
        return this.roleName;
    }
    
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    
    @Column(name="PROCESSING_STATUS", nullable=false, precision=1, scale=0)
    public boolean isProcessingStatus() {
        return this.processingStatus;
    }
    
    public void setProcessingStatus(boolean processingStatus) {
        this.processingStatus = processingStatus;
    }

    
    @Column(name="PROCESSING_TS", nullable=false, precision=20, scale=0)
    public BigDecimal getProcessingTs() {
        return this.processingTs;
    }
    
    public void setProcessingTs(BigDecimal processingTs) {
        this.processingTs = processingTs;
    }

    
    @Column(name="MARK", precision=20, scale=0)
    public BigDecimal getMark() {
        return this.mark;
    }
    
    public void setMark(BigDecimal mark) {
        this.mark = mark;
    }

    
    @Column(name="CHILD_MEMBER_ID", precision=20, scale=0)
    public BigDecimal getChildMemberId() {
        return this.childMemberId;
    }
    
    public void setChildMemberId(BigDecimal childMemberId) {
        this.childMemberId = childMemberId;
    }




}


