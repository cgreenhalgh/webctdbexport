package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * PersonReadAnnouncement generated by hbm2java
 */
@Entity
@Table(name="PERSON_READ_ANNOUNCEMENT"
)
public class PersonReadAnnouncement  implements java.io.Serializable {


     private PersonReadAnnouncementId id;

    public PersonReadAnnouncement() {
    }

    public PersonReadAnnouncement(PersonReadAnnouncementId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="announcementId", column=@Column(name="ANNOUNCEMENT_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="personId", column=@Column(name="PERSON_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="learningContextId", column=@Column(name="LEARNING_CONTEXT_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="annLearningContextId", column=@Column(name="ANN_LEARNING_CONTEXT_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="title", column=@Column(name="TITLE", nullable=false, length=1000) ), 
        @AttributeOverride(name="content", column=@Column(name="CONTENT", nullable=false) ), 
        @AttributeOverride(name="startTimestamp", column=@Column(name="START_TIMESTAMP", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="endTimestamp", column=@Column(name="END_TIMESTAMP", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="deliverAsPopup", column=@Column(name="DELIVER_AS_POPUP", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="htmlContent", column=@Column(name="HTML_CONTENT", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="createPersonId", column=@Column(name="CREATE_PERSON_ID", nullable=false, precision=20, scale=0) ) } )
    public PersonReadAnnouncementId getId() {
        return this.id;
    }
    
    public void setId(PersonReadAnnouncementId id) {
        this.id = id;
    }




}


