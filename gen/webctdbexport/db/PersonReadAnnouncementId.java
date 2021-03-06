package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.sql.Clob;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * PersonReadAnnouncementId generated by hbm2java
 */
@Embeddable
public class PersonReadAnnouncementId  implements java.io.Serializable {


     private BigDecimal announcementId;
     private BigDecimal personId;
     private BigDecimal learningContextId;
     private BigDecimal annLearningContextId;
     private String title;
     private Clob content;
     private BigDecimal startTimestamp;
     private BigDecimal endTimestamp;
     private boolean deliverAsPopup;
     private boolean htmlContent;
     private BigDecimal createPersonId;

    public PersonReadAnnouncementId() {
    }

    public PersonReadAnnouncementId(BigDecimal announcementId, BigDecimal personId, BigDecimal learningContextId, BigDecimal annLearningContextId, String title, Clob content, BigDecimal startTimestamp, BigDecimal endTimestamp, boolean deliverAsPopup, boolean htmlContent, BigDecimal createPersonId) {
       this.announcementId = announcementId;
       this.personId = personId;
       this.learningContextId = learningContextId;
       this.annLearningContextId = annLearningContextId;
       this.title = title;
       this.content = content;
       this.startTimestamp = startTimestamp;
       this.endTimestamp = endTimestamp;
       this.deliverAsPopup = deliverAsPopup;
       this.htmlContent = htmlContent;
       this.createPersonId = createPersonId;
    }
   


    @Column(name="ANNOUNCEMENT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getAnnouncementId() {
        return this.announcementId;
    }
    
    public void setAnnouncementId(BigDecimal announcementId) {
        this.announcementId = announcementId;
    }


    @Column(name="PERSON_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(BigDecimal personId) {
        this.personId = personId;
    }


    @Column(name="LEARNING_CONTEXT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getLearningContextId() {
        return this.learningContextId;
    }
    
    public void setLearningContextId(BigDecimal learningContextId) {
        this.learningContextId = learningContextId;
    }


    @Column(name="ANN_LEARNING_CONTEXT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getAnnLearningContextId() {
        return this.annLearningContextId;
    }
    
    public void setAnnLearningContextId(BigDecimal annLearningContextId) {
        this.annLearningContextId = annLearningContextId;
    }


    @Column(name="TITLE", nullable=false, length=1000)
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }


    @Column(name="CONTENT", nullable=false)
    public Clob getContent() {
        return this.content;
    }
    
    public void setContent(Clob content) {
        this.content = content;
    }


    @Column(name="START_TIMESTAMP", nullable=false, precision=20, scale=0)
    public BigDecimal getStartTimestamp() {
        return this.startTimestamp;
    }
    
    public void setStartTimestamp(BigDecimal startTimestamp) {
        this.startTimestamp = startTimestamp;
    }


    @Column(name="END_TIMESTAMP", nullable=false, precision=20, scale=0)
    public BigDecimal getEndTimestamp() {
        return this.endTimestamp;
    }
    
    public void setEndTimestamp(BigDecimal endTimestamp) {
        this.endTimestamp = endTimestamp;
    }


    @Column(name="DELIVER_AS_POPUP", nullable=false, precision=1, scale=0)
    public boolean isDeliverAsPopup() {
        return this.deliverAsPopup;
    }
    
    public void setDeliverAsPopup(boolean deliverAsPopup) {
        this.deliverAsPopup = deliverAsPopup;
    }


    @Column(name="HTML_CONTENT", nullable=false, precision=1, scale=0)
    public boolean isHtmlContent() {
        return this.htmlContent;
    }
    
    public void setHtmlContent(boolean htmlContent) {
        this.htmlContent = htmlContent;
    }


    @Column(name="CREATE_PERSON_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getCreatePersonId() {
        return this.createPersonId;
    }
    
    public void setCreatePersonId(BigDecimal createPersonId) {
        this.createPersonId = createPersonId;
    }




}


