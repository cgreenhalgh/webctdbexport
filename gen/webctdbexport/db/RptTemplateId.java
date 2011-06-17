package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RptTemplateId generated by hbm2java
 */
@Embeddable
public class RptTemplateId  implements java.io.Serializable {


     private BigDecimal templateId;
     private BigDecimal learningContextId;
     private String path;
     private BigDecimal templateSize;
     private BigDecimal assessmentCount;
     private BigDecimal questiondbQuestionCount;
     private BigDecimal assignmentCount;
     private BigDecimal chatRoomCount;
     private BigDecimal pageCount;
     private BigDecimal discussionTopicCount;
     private BigDecimal learningModuleCount;
     private BigDecimal mediaLibraryEntryCount;
     private BigDecimal organizerPageCount;
     private BigDecimal urlEntryCount;
     private BigDecimal scoCount;
     private BigDecimal appBridgeCount;
     private BigDecimal syllabus;
     private Boolean publicFlag;

    public RptTemplateId() {
    }

    public RptTemplateId(BigDecimal templateId, BigDecimal learningContextId, String path, BigDecimal templateSize, BigDecimal assessmentCount, BigDecimal questiondbQuestionCount, BigDecimal assignmentCount, BigDecimal chatRoomCount, BigDecimal pageCount, BigDecimal discussionTopicCount, BigDecimal learningModuleCount, BigDecimal mediaLibraryEntryCount, BigDecimal organizerPageCount, BigDecimal urlEntryCount, BigDecimal scoCount, BigDecimal appBridgeCount, BigDecimal syllabus, Boolean publicFlag) {
       this.templateId = templateId;
       this.learningContextId = learningContextId;
       this.path = path;
       this.templateSize = templateSize;
       this.assessmentCount = assessmentCount;
       this.questiondbQuestionCount = questiondbQuestionCount;
       this.assignmentCount = assignmentCount;
       this.chatRoomCount = chatRoomCount;
       this.pageCount = pageCount;
       this.discussionTopicCount = discussionTopicCount;
       this.learningModuleCount = learningModuleCount;
       this.mediaLibraryEntryCount = mediaLibraryEntryCount;
       this.organizerPageCount = organizerPageCount;
       this.urlEntryCount = urlEntryCount;
       this.scoCount = scoCount;
       this.appBridgeCount = appBridgeCount;
       this.syllabus = syllabus;
       this.publicFlag = publicFlag;
    }
   


    @Column(name="TEMPLATE_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getTemplateId() {
        return this.templateId;
    }
    
    public void setTemplateId(BigDecimal templateId) {
        this.templateId = templateId;
    }


    @Column(name="LEARNING_CONTEXT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getLearningContextId() {
        return this.learningContextId;
    }
    
    public void setLearningContextId(BigDecimal learningContextId) {
        this.learningContextId = learningContextId;
    }


    @Column(name="PATH", nullable=false, length=4000)
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }


    @Column(name="TEMPLATE_SIZE", nullable=false, precision=20, scale=0)
    public BigDecimal getTemplateSize() {
        return this.templateSize;
    }
    
    public void setTemplateSize(BigDecimal templateSize) {
        this.templateSize = templateSize;
    }


    @Column(name="ASSESSMENT_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getAssessmentCount() {
        return this.assessmentCount;
    }
    
    public void setAssessmentCount(BigDecimal assessmentCount) {
        this.assessmentCount = assessmentCount;
    }


    @Column(name="QUESTIONDB_QUESTION_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getQuestiondbQuestionCount() {
        return this.questiondbQuestionCount;
    }
    
    public void setQuestiondbQuestionCount(BigDecimal questiondbQuestionCount) {
        this.questiondbQuestionCount = questiondbQuestionCount;
    }


    @Column(name="ASSIGNMENT_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getAssignmentCount() {
        return this.assignmentCount;
    }
    
    public void setAssignmentCount(BigDecimal assignmentCount) {
        this.assignmentCount = assignmentCount;
    }


    @Column(name="CHAT_ROOM_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getChatRoomCount() {
        return this.chatRoomCount;
    }
    
    public void setChatRoomCount(BigDecimal chatRoomCount) {
        this.chatRoomCount = chatRoomCount;
    }


    @Column(name="PAGE_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getPageCount() {
        return this.pageCount;
    }
    
    public void setPageCount(BigDecimal pageCount) {
        this.pageCount = pageCount;
    }


    @Column(name="DISCUSSION_TOPIC_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getDiscussionTopicCount() {
        return this.discussionTopicCount;
    }
    
    public void setDiscussionTopicCount(BigDecimal discussionTopicCount) {
        this.discussionTopicCount = discussionTopicCount;
    }


    @Column(name="LEARNING_MODULE_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getLearningModuleCount() {
        return this.learningModuleCount;
    }
    
    public void setLearningModuleCount(BigDecimal learningModuleCount) {
        this.learningModuleCount = learningModuleCount;
    }


    @Column(name="MEDIA_LIBRARY_ENTRY_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getMediaLibraryEntryCount() {
        return this.mediaLibraryEntryCount;
    }
    
    public void setMediaLibraryEntryCount(BigDecimal mediaLibraryEntryCount) {
        this.mediaLibraryEntryCount = mediaLibraryEntryCount;
    }


    @Column(name="ORGANIZER_PAGE_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getOrganizerPageCount() {
        return this.organizerPageCount;
    }
    
    public void setOrganizerPageCount(BigDecimal organizerPageCount) {
        this.organizerPageCount = organizerPageCount;
    }


    @Column(name="URL_ENTRY_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getUrlEntryCount() {
        return this.urlEntryCount;
    }
    
    public void setUrlEntryCount(BigDecimal urlEntryCount) {
        this.urlEntryCount = urlEntryCount;
    }


    @Column(name="SCO_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getScoCount() {
        return this.scoCount;
    }
    
    public void setScoCount(BigDecimal scoCount) {
        this.scoCount = scoCount;
    }


    @Column(name="APP_BRIDGE_COUNT", nullable=false, precision=20, scale=0)
    public BigDecimal getAppBridgeCount() {
        return this.appBridgeCount;
    }
    
    public void setAppBridgeCount(BigDecimal appBridgeCount) {
        this.appBridgeCount = appBridgeCount;
    }


    @Column(name="SYLLABUS", nullable=false, precision=20, scale=0)
    public BigDecimal getSyllabus() {
        return this.syllabus;
    }
    
    public void setSyllabus(BigDecimal syllabus) {
        this.syllabus = syllabus;
    }


    @Column(name="PUBLIC_FLAG", nullable=false, precision=1, scale=0)
    public Boolean getPublicFlag() {
        return this.publicFlag;
    }
    
    public void setPublicFlag(Boolean publicFlag) {
        this.publicFlag = publicFlag;
    }




}


