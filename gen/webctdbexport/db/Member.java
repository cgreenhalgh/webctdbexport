package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Member generated by hbm2java
 */
@Entity
@Table(name="MEMBER"
)
public class Member  implements java.io.Serializable {


     private BigDecimal id;
     private Person person;
     private Member member;
     private LearningContext learningContext;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private boolean statusFlag;
     private boolean startRestrict;
     private boolean endRestrict;
     private boolean deleteStatus;
     private BigDecimal startdateTime;
     private BigDecimal enddateTime;
     private boolean hiddenLc;
     private BigDecimal displayOrder;
     private Set<Role> roles = new HashSet<Role>(0);
     private Set<AgnAssignee> agnAssignees = new HashSet<AgnAssignee>(0);
     private Set<SimpleFileUploader> simpleFileUploaders = new HashSet<SimpleFileUploader>(0);
     private Set<RubricLinkCellResult> rubricLinkCellResultsForLearnerId = new HashSet<RubricLinkCellResult>(0);
     private Set<RubricLinkCellResult> rubricLinkCellResultsForMarkerId = new HashSet<RubricLinkCellResult>(0);
     private Set<RoleXlistSource> roleXlistSources = new HashSet<RoleXlistSource>(0);
     private Set<AssmtSubmission> assmtSubmissions = new HashSet<AssmtSubmission>(0);
     private Set<Member> members = new HashSet<Member>(0);
     private Set<RubricLinkResult> rubricLinkResultsForMarkerId = new HashSet<RubricLinkResult>(0);
     private Set<MemberAttrValue> memberAttrValues = new HashSet<MemberAttrValue>(0);
     private Set<RubricLinkResult> rubricLinkResultsForLearnerId = new HashSet<RubricLinkResult>(0);
     private Set<ScormScoMemberData> scormScoMemberDatas = new HashSet<ScormScoMemberData>(0);
     private Set<AgnSubmission> agnSubmissions = new HashSet<AgnSubmission>(0);

    public Member() {
    }

	
    public Member(BigDecimal id, Person person, LearningContext learningContext, BigDecimal createTs, BigDecimal lastmodifyTs, boolean statusFlag, boolean startRestrict, boolean endRestrict, boolean deleteStatus, boolean hiddenLc, BigDecimal displayOrder) {
        this.id = id;
        this.person = person;
        this.learningContext = learningContext;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
        this.statusFlag = statusFlag;
        this.startRestrict = startRestrict;
        this.endRestrict = endRestrict;
        this.deleteStatus = deleteStatus;
        this.hiddenLc = hiddenLc;
        this.displayOrder = displayOrder;
    }
    public Member(BigDecimal id, Person person, Member member, LearningContext learningContext, BigDecimal createTs, BigDecimal lastmodifyTs, boolean statusFlag, boolean startRestrict, boolean endRestrict, boolean deleteStatus, BigDecimal startdateTime, BigDecimal enddateTime, boolean hiddenLc, BigDecimal displayOrder, Set<Role> roles, Set<AgnAssignee> agnAssignees, Set<SimpleFileUploader> simpleFileUploaders, Set<RubricLinkCellResult> rubricLinkCellResultsForLearnerId, Set<RubricLinkCellResult> rubricLinkCellResultsForMarkerId, Set<RoleXlistSource> roleXlistSources, Set<AssmtSubmission> assmtSubmissions, Set<Member> members, Set<RubricLinkResult> rubricLinkResultsForMarkerId, Set<MemberAttrValue> memberAttrValues, Set<RubricLinkResult> rubricLinkResultsForLearnerId, Set<ScormScoMemberData> scormScoMemberDatas, Set<AgnSubmission> agnSubmissions) {
       this.id = id;
       this.person = person;
       this.member = member;
       this.learningContext = learningContext;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.statusFlag = statusFlag;
       this.startRestrict = startRestrict;
       this.endRestrict = endRestrict;
       this.deleteStatus = deleteStatus;
       this.startdateTime = startdateTime;
       this.enddateTime = enddateTime;
       this.hiddenLc = hiddenLc;
       this.displayOrder = displayOrder;
       this.roles = roles;
       this.agnAssignees = agnAssignees;
       this.simpleFileUploaders = simpleFileUploaders;
       this.rubricLinkCellResultsForLearnerId = rubricLinkCellResultsForLearnerId;
       this.rubricLinkCellResultsForMarkerId = rubricLinkCellResultsForMarkerId;
       this.roleXlistSources = roleXlistSources;
       this.assmtSubmissions = assmtSubmissions;
       this.members = members;
       this.rubricLinkResultsForMarkerId = rubricLinkResultsForMarkerId;
       this.memberAttrValues = memberAttrValues;
       this.rubricLinkResultsForLearnerId = rubricLinkResultsForLearnerId;
       this.scormScoMemberDatas = scormScoMemberDatas;
       this.agnSubmissions = agnSubmissions;
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
    @JoinColumn(name="PERSON_ID", nullable=false)
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CHILD_MEMBER_ID")
    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LEARNING_CONTEXT_ID", nullable=false)
    public LearningContext getLearningContext() {
        return this.learningContext;
    }
    
    public void setLearningContext(LearningContext learningContext) {
        this.learningContext = learningContext;
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

    
    @Column(name="STATUS_FLAG", nullable=false, precision=1, scale=0)
    public boolean isStatusFlag() {
        return this.statusFlag;
    }
    
    public void setStatusFlag(boolean statusFlag) {
        this.statusFlag = statusFlag;
    }

    
    @Column(name="START_RESTRICT", nullable=false, precision=1, scale=0)
    public boolean isStartRestrict() {
        return this.startRestrict;
    }
    
    public void setStartRestrict(boolean startRestrict) {
        this.startRestrict = startRestrict;
    }

    
    @Column(name="END_RESTRICT", nullable=false, precision=1, scale=0)
    public boolean isEndRestrict() {
        return this.endRestrict;
    }
    
    public void setEndRestrict(boolean endRestrict) {
        this.endRestrict = endRestrict;
    }

    
    @Column(name="DELETE_STATUS", nullable=false, precision=1, scale=0)
    public boolean isDeleteStatus() {
        return this.deleteStatus;
    }
    
    public void setDeleteStatus(boolean deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    
    @Column(name="STARTDATE_TIME", precision=20, scale=0)
    public BigDecimal getStartdateTime() {
        return this.startdateTime;
    }
    
    public void setStartdateTime(BigDecimal startdateTime) {
        this.startdateTime = startdateTime;
    }

    
    @Column(name="ENDDATE_TIME", precision=20, scale=0)
    public BigDecimal getEnddateTime() {
        return this.enddateTime;
    }
    
    public void setEnddateTime(BigDecimal enddateTime) {
        this.enddateTime = enddateTime;
    }

    
    @Column(name="HIDDEN_LC", nullable=false, precision=1, scale=0)
    public boolean isHiddenLc() {
        return this.hiddenLc;
    }
    
    public void setHiddenLc(boolean hiddenLc) {
        this.hiddenLc = hiddenLc;
    }

    
    @Column(name="DISPLAY_ORDER", nullable=false, precision=16, scale=4)
    public BigDecimal getDisplayOrder() {
        return this.displayOrder;
    }
    
    public void setDisplayOrder(BigDecimal displayOrder) {
        this.displayOrder = displayOrder;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
    public Set<Role> getRoles() {
        return this.roles;
    }
    
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
    public Set<AgnAssignee> getAgnAssignees() {
        return this.agnAssignees;
    }
    
    public void setAgnAssignees(Set<AgnAssignee> agnAssignees) {
        this.agnAssignees = agnAssignees;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
    public Set<SimpleFileUploader> getSimpleFileUploaders() {
        return this.simpleFileUploaders;
    }
    
    public void setSimpleFileUploaders(Set<SimpleFileUploader> simpleFileUploaders) {
        this.simpleFileUploaders = simpleFileUploaders;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="memberByLearnerId")
    public Set<RubricLinkCellResult> getRubricLinkCellResultsForLearnerId() {
        return this.rubricLinkCellResultsForLearnerId;
    }
    
    public void setRubricLinkCellResultsForLearnerId(Set<RubricLinkCellResult> rubricLinkCellResultsForLearnerId) {
        this.rubricLinkCellResultsForLearnerId = rubricLinkCellResultsForLearnerId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="memberByMarkerId")
    public Set<RubricLinkCellResult> getRubricLinkCellResultsForMarkerId() {
        return this.rubricLinkCellResultsForMarkerId;
    }
    
    public void setRubricLinkCellResultsForMarkerId(Set<RubricLinkCellResult> rubricLinkCellResultsForMarkerId) {
        this.rubricLinkCellResultsForMarkerId = rubricLinkCellResultsForMarkerId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
    public Set<RoleXlistSource> getRoleXlistSources() {
        return this.roleXlistSources;
    }
    
    public void setRoleXlistSources(Set<RoleXlistSource> roleXlistSources) {
        this.roleXlistSources = roleXlistSources;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
    public Set<AssmtSubmission> getAssmtSubmissions() {
        return this.assmtSubmissions;
    }
    
    public void setAssmtSubmissions(Set<AssmtSubmission> assmtSubmissions) {
        this.assmtSubmissions = assmtSubmissions;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
    public Set<Member> getMembers() {
        return this.members;
    }
    
    public void setMembers(Set<Member> members) {
        this.members = members;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="memberByMarkerId")
    public Set<RubricLinkResult> getRubricLinkResultsForMarkerId() {
        return this.rubricLinkResultsForMarkerId;
    }
    
    public void setRubricLinkResultsForMarkerId(Set<RubricLinkResult> rubricLinkResultsForMarkerId) {
        this.rubricLinkResultsForMarkerId = rubricLinkResultsForMarkerId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
    public Set<MemberAttrValue> getMemberAttrValues() {
        return this.memberAttrValues;
    }
    
    public void setMemberAttrValues(Set<MemberAttrValue> memberAttrValues) {
        this.memberAttrValues = memberAttrValues;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="memberByLearnerId")
    public Set<RubricLinkResult> getRubricLinkResultsForLearnerId() {
        return this.rubricLinkResultsForLearnerId;
    }
    
    public void setRubricLinkResultsForLearnerId(Set<RubricLinkResult> rubricLinkResultsForLearnerId) {
        this.rubricLinkResultsForLearnerId = rubricLinkResultsForLearnerId;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
    public Set<ScormScoMemberData> getScormScoMemberDatas() {
        return this.scormScoMemberDatas;
    }
    
    public void setScormScoMemberDatas(Set<ScormScoMemberData> scormScoMemberDatas) {
        this.scormScoMemberDatas = scormScoMemberDatas;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="member")
    public Set<AgnSubmission> getAgnSubmissions() {
        return this.agnSubmissions;
    }
    
    public void setAgnSubmissions(Set<AgnSubmission> agnSubmissions) {
        this.agnSubmissions = agnSubmissions;
    }




}


