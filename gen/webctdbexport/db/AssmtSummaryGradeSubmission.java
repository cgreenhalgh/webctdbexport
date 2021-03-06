package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AssmtSummaryGradeSubmission generated by hbm2java
 */
@Entity
@Table(name="ASSMT_SUMMARY_GRADE_SUBMISSION"
)
public class AssmtSummaryGradeSubmission  implements java.io.Serializable {


     private AssmtSummaryGradeSubmissionId id;

    public AssmtSummaryGradeSubmission() {
    }

    public AssmtSummaryGradeSubmission(AssmtSummaryGradeSubmissionId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="deliveryContextId", column=@Column(name="DELIVERY_CONTEXT_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="assessmentId", column=@Column(name="ASSESSMENT_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="assessmentIdent", column=@Column(name="ASSESSMENT_IDENT", nullable=false, length=768) ), 
        @AttributeOverride(name="maxscore", column=@Column(name="MAXSCORE", nullable=false, precision=12, scale=4) ), 
        @AttributeOverride(name="numassmtitems", column=@Column(name="NUMASSMTITEMS", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="settingId", column=@Column(name="SETTING_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="numberofattempts", column=@Column(name="NUMBEROFATTEMPTS", nullable=false, precision=3, scale=0) ), 
        @AttributeOverride(name="timebetweenattempts", column=@Column(name="TIMEBETWEENATTEMPTS", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="timebetweenattemptsunits", column=@Column(name="TIMEBETWEENATTEMPTSUNITS", nullable=false, length=60) ), 
        @AttributeOverride(name="questiondelivery", column=@Column(name="QUESTIONDELIVERY", nullable=false, length=20) ), 
        @AttributeOverride(name="displayNewWindow", column=@Column(name="DISPLAY_NEW_WINDOW", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="duration", column=@Column(name="DURATION", nullable=false, precision=6, scale=0) ), 
        @AttributeOverride(name="durationunits", column=@Column(name="DURATIONUNITS", nullable=false, length=60) ), 
        @AttributeOverride(name="durationunlimited", column=@Column(name="DURATIONUNLIMITED", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="resultsemail", column=@Column(name="RESULTSEMAIL", nullable=false, length=320) ), 
        @AttributeOverride(name="resultsreleasetype", column=@Column(name="RESULTSRELEASETYPE", nullable=false, length=30) ), 
        @AttributeOverride(name="resultsscoretype", column=@Column(name="RESULTSSCORETYPE", nullable=false, length=20) ), 
        @AttributeOverride(name="resultscorrectanswer", column=@Column(name="RESULTSCORRECTANSWER", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="resultsevaluation", column=@Column(name="RESULTSEVALUATION", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="resultsfeedback", column=@Column(name="RESULTSFEEDBACK", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="resultsfullevaluation", column=@Column(name="RESULTSFULLEVALUATION", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="resultsgradercomments", column=@Column(name="RESULTSGRADERCOMMENTS", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="resultsresponse", column=@Column(name="RESULTSRESPONSE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="resultsscore", column=@Column(name="RESULTSSCORE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="resultstext", column=@Column(name="RESULTSTEXT", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="resultstotalscore", column=@Column(name="RESULTSTOTALSCORE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="securitypassword", column=@Column(name="SECURITYPASSWORD", nullable=false, length=300) ), 
        @AttributeOverride(name="securityaddressmask", column=@Column(name="SECURITYADDRESSMASK", nullable=false, length=15) ), 
        @AttributeOverride(name="submitmessage", column=@Column(name="SUBMITMESSAGE", nullable=false, length=4000) ), 
        @AttributeOverride(name="submitemailaddress", column=@Column(name="SUBMITEMAILADDRESS", nullable=false, length=320) ), 
        @AttributeOverride(name="showtitle", column=@Column(name="SHOWTITLE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="allowsubmissionafter", column=@Column(name="ALLOWSUBMISSIONAFTER", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="securityaddress", column=@Column(name="SECURITYADDRESS", nullable=false, length=15) ), 
        @AttributeOverride(name="starttime", column=@Column(name="STARTTIME", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="endtime", column=@Column(name="ENDTIME", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="id", column=@Column(name="ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="sectionBookId", column=@Column(name="SECTION_BOOK_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="learningActivityId", column=@Column(name="LEARNING_ACTIVITY_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="cobaltType", column=@Column(name="COBALT_TYPE", nullable=false, length=40) ), 
        @AttributeOverride(name="alignment", column=@Column(name="ALIGNMENT", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="label", column=@Column(name="LABEL", nullable=false, length=1000) ), 
        @AttributeOverride(name="decimalScale", column=@Column(name="DECIMAL_SCALE", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="mandatoryFl", column=@Column(name="MANDATORY_FL", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="editableFl", column=@Column(name="EDITABLE_FL", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="releasedFl", column=@Column(name="RELEASED_FL", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="overridableFl", column=@Column(name="OVERRIDABLE_FL", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="gradeFl", column=@Column(name="GRADE_FL", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="selectionList", column=@Column(name="SELECTION_LIST", nullable=false, length=3000) ), 
        @AttributeOverride(name="letterGradeScheme", column=@Column(name="LETTER_GRADE_SCHEME", nullable=false, length=1000) ), 
        @AttributeOverride(name="gradeFormula", column=@Column(name="GRADE_FORMULA", nullable=false, length=4000) ), 
        @AttributeOverride(name="inheritedFl", column=@Column(name="INHERITED_FL", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="maxValue", column=@Column(name="MAX_VALUE", nullable=false, precision=7) ), 
        @AttributeOverride(name="schemeUpdateDate", column=@Column(name="SCHEME_UPDATE_DATE", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="randomizeattempt", column=@Column(name="RANDOMIZEATTEMPT", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="numSubmissions", column=@Column(name="NUM_SUBMISSIONS", nullable=false, precision=22, scale=0) ), 
        @AttributeOverride(name="requiresecurebrowser", column=@Column(name="REQUIRESECUREBROWSER", nullable=false, precision=1, scale=0) ), 
        @AttributeOverride(name="allowartifactcreation", column=@Column(name="ALLOWARTIFACTCREATION", nullable=false, precision=1, scale=0) ) } )
    public AssmtSummaryGradeSubmissionId getId() {
        return this.id;
    }
    
    public void setId(AssmtSummaryGradeSubmissionId id) {
        this.id = id;
    }




}


