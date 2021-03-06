package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * AssmtSetting generated by hbm2java
 */
@Entity
@Table(name="ASSMT_SETTING"
)
public class AssmtSetting  implements java.io.Serializable {


     private BigDecimal id;
     private AssmtAssessment assmtAssessment;
     private CmsContentEntry cmsContentEntry;
     private BigDecimal starttime;
     private int duration;
     private String durationunits;
     private boolean durationunlimited;
     private boolean displayNewWindow;
     private String questiondelivery;
     private short numberofattempts;
     private boolean showtitle;
     private boolean allowsubmissionafter;
     private boolean randomizeAttempts;
     private boolean showStatistics;
     private boolean inCalendar;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private BigDecimal endtime;
     private Integer timebetweenattempts;
     private String timebetweenattemptsunits;
     private boolean instructionsIsHtml;
     private boolean instructionsEveryQuestion;
     private String instructions;
     private AssmtSecuritySetting assmtSecuritySetting;
     private AssmtSubmissionSetting assmtSubmissionSetting;
     private AssmtResultSetting assmtResultSetting;

    public AssmtSetting() {
    }

	
    public AssmtSetting(BigDecimal id, AssmtAssessment assmtAssessment, CmsContentEntry cmsContentEntry, BigDecimal starttime, int duration, String durationunits, boolean durationunlimited, boolean displayNewWindow, String questiondelivery, short numberofattempts, boolean showtitle, boolean allowsubmissionafter, boolean randomizeAttempts, boolean showStatistics, boolean inCalendar, BigDecimal createTs, BigDecimal lastmodifyTs, boolean instructionsIsHtml, boolean instructionsEveryQuestion) {
        this.id = id;
        this.assmtAssessment = assmtAssessment;
        this.cmsContentEntry = cmsContentEntry;
        this.starttime = starttime;
        this.duration = duration;
        this.durationunits = durationunits;
        this.durationunlimited = durationunlimited;
        this.displayNewWindow = displayNewWindow;
        this.questiondelivery = questiondelivery;
        this.numberofattempts = numberofattempts;
        this.showtitle = showtitle;
        this.allowsubmissionafter = allowsubmissionafter;
        this.randomizeAttempts = randomizeAttempts;
        this.showStatistics = showStatistics;
        this.inCalendar = inCalendar;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
        this.instructionsIsHtml = instructionsIsHtml;
        this.instructionsEveryQuestion = instructionsEveryQuestion;
    }
    public AssmtSetting(BigDecimal id, AssmtAssessment assmtAssessment, CmsContentEntry cmsContentEntry, BigDecimal starttime, int duration, String durationunits, boolean durationunlimited, boolean displayNewWindow, String questiondelivery, short numberofattempts, boolean showtitle, boolean allowsubmissionafter, boolean randomizeAttempts, boolean showStatistics, boolean inCalendar, BigDecimal createTs, BigDecimal lastmodifyTs, BigDecimal endtime, Integer timebetweenattempts, String timebetweenattemptsunits, boolean instructionsIsHtml, boolean instructionsEveryQuestion, String instructions, AssmtSecuritySetting assmtSecuritySetting, AssmtSubmissionSetting assmtSubmissionSetting, AssmtResultSetting assmtResultSetting) {
       this.id = id;
       this.assmtAssessment = assmtAssessment;
       this.cmsContentEntry = cmsContentEntry;
       this.starttime = starttime;
       this.duration = duration;
       this.durationunits = durationunits;
       this.durationunlimited = durationunlimited;
       this.displayNewWindow = displayNewWindow;
       this.questiondelivery = questiondelivery;
       this.numberofattempts = numberofattempts;
       this.showtitle = showtitle;
       this.allowsubmissionafter = allowsubmissionafter;
       this.randomizeAttempts = randomizeAttempts;
       this.showStatistics = showStatistics;
       this.inCalendar = inCalendar;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.endtime = endtime;
       this.timebetweenattempts = timebetweenattempts;
       this.timebetweenattemptsunits = timebetweenattemptsunits;
       this.instructionsIsHtml = instructionsIsHtml;
       this.instructionsEveryQuestion = instructionsEveryQuestion;
       this.instructions = instructions;
       this.assmtSecuritySetting = assmtSecuritySetting;
       this.assmtSubmissionSetting = assmtSubmissionSetting;
       this.assmtResultSetting = assmtResultSetting;
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
    @JoinColumn(name="ASSESSMENT_ID", nullable=false)
    public AssmtAssessment getAssmtAssessment() {
        return this.assmtAssessment;
    }
    
    public void setAssmtAssessment(AssmtAssessment assmtAssessment) {
        this.assmtAssessment = assmtAssessment;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DELIVERY_CONTEXT_ID", nullable=false)
    public CmsContentEntry getCmsContentEntry() {
        return this.cmsContentEntry;
    }
    
    public void setCmsContentEntry(CmsContentEntry cmsContentEntry) {
        this.cmsContentEntry = cmsContentEntry;
    }

    
    @Column(name="STARTTIME", nullable=false, precision=20, scale=0)
    public BigDecimal getStarttime() {
        return this.starttime;
    }
    
    public void setStarttime(BigDecimal starttime) {
        this.starttime = starttime;
    }

    
    @Column(name="DURATION", nullable=false, precision=6, scale=0)
    public int getDuration() {
        return this.duration;
    }
    
    public void setDuration(int duration) {
        this.duration = duration;
    }

    
    @Column(name="DURATIONUNITS", nullable=false, length=60)
    public String getDurationunits() {
        return this.durationunits;
    }
    
    public void setDurationunits(String durationunits) {
        this.durationunits = durationunits;
    }

    
    @Column(name="DURATIONUNLIMITED", nullable=false, precision=1, scale=0)
    public boolean isDurationunlimited() {
        return this.durationunlimited;
    }
    
    public void setDurationunlimited(boolean durationunlimited) {
        this.durationunlimited = durationunlimited;
    }

    
    @Column(name="DISPLAY_NEW_WINDOW", nullable=false, precision=1, scale=0)
    public boolean isDisplayNewWindow() {
        return this.displayNewWindow;
    }
    
    public void setDisplayNewWindow(boolean displayNewWindow) {
        this.displayNewWindow = displayNewWindow;
    }

    
    @Column(name="QUESTIONDELIVERY", nullable=false, length=20)
    public String getQuestiondelivery() {
        return this.questiondelivery;
    }
    
    public void setQuestiondelivery(String questiondelivery) {
        this.questiondelivery = questiondelivery;
    }

    
    @Column(name="NUMBEROFATTEMPTS", nullable=false, precision=3, scale=0)
    public short getNumberofattempts() {
        return this.numberofattempts;
    }
    
    public void setNumberofattempts(short numberofattempts) {
        this.numberofattempts = numberofattempts;
    }

    
    @Column(name="SHOWTITLE", nullable=false, precision=1, scale=0)
    public boolean isShowtitle() {
        return this.showtitle;
    }
    
    public void setShowtitle(boolean showtitle) {
        this.showtitle = showtitle;
    }

    
    @Column(name="ALLOWSUBMISSIONAFTER", nullable=false, precision=1, scale=0)
    public boolean isAllowsubmissionafter() {
        return this.allowsubmissionafter;
    }
    
    public void setAllowsubmissionafter(boolean allowsubmissionafter) {
        this.allowsubmissionafter = allowsubmissionafter;
    }

    
    @Column(name="RANDOMIZE_ATTEMPTS", nullable=false, precision=1, scale=0)
    public boolean isRandomizeAttempts() {
        return this.randomizeAttempts;
    }
    
    public void setRandomizeAttempts(boolean randomizeAttempts) {
        this.randomizeAttempts = randomizeAttempts;
    }

    
    @Column(name="SHOW_STATISTICS", nullable=false, precision=1, scale=0)
    public boolean isShowStatistics() {
        return this.showStatistics;
    }
    
    public void setShowStatistics(boolean showStatistics) {
        this.showStatistics = showStatistics;
    }

    
    @Column(name="IN_CALENDAR", nullable=false, precision=1, scale=0)
    public boolean isInCalendar() {
        return this.inCalendar;
    }
    
    public void setInCalendar(boolean inCalendar) {
        this.inCalendar = inCalendar;
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

    
    @Column(name="ENDTIME", precision=20, scale=0)
    public BigDecimal getEndtime() {
        return this.endtime;
    }
    
    public void setEndtime(BigDecimal endtime) {
        this.endtime = endtime;
    }

    
    @Column(name="TIMEBETWEENATTEMPTS", precision=6, scale=0)
    public Integer getTimebetweenattempts() {
        return this.timebetweenattempts;
    }
    
    public void setTimebetweenattempts(Integer timebetweenattempts) {
        this.timebetweenattempts = timebetweenattempts;
    }

    
    @Column(name="TIMEBETWEENATTEMPTSUNITS", length=60)
    public String getTimebetweenattemptsunits() {
        return this.timebetweenattemptsunits;
    }
    
    public void setTimebetweenattemptsunits(String timebetweenattemptsunits) {
        this.timebetweenattemptsunits = timebetweenattemptsunits;
    }

    
    @Column(name="INSTRUCTIONS_IS_HTML", nullable=false, precision=1, scale=0)
    public boolean isInstructionsIsHtml() {
        return this.instructionsIsHtml;
    }
    
    public void setInstructionsIsHtml(boolean instructionsIsHtml) {
        this.instructionsIsHtml = instructionsIsHtml;
    }

    
    @Column(name="INSTRUCTIONS_EVERY_QUESTION", nullable=false, precision=1, scale=0)
    public boolean isInstructionsEveryQuestion() {
        return this.instructionsEveryQuestion;
    }
    
    public void setInstructionsEveryQuestion(boolean instructionsEveryQuestion) {
        this.instructionsEveryQuestion = instructionsEveryQuestion;
    }

    
    @Column(name="INSTRUCTIONS", length=4000)
    public String getInstructions() {
        return this.instructions;
    }
    
    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="assmtSetting")
    public AssmtSecuritySetting getAssmtSecuritySetting() {
        return this.assmtSecuritySetting;
    }
    
    public void setAssmtSecuritySetting(AssmtSecuritySetting assmtSecuritySetting) {
        this.assmtSecuritySetting = assmtSecuritySetting;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="assmtSetting")
    public AssmtSubmissionSetting getAssmtSubmissionSetting() {
        return this.assmtSubmissionSetting;
    }
    
    public void setAssmtSubmissionSetting(AssmtSubmissionSetting assmtSubmissionSetting) {
        this.assmtSubmissionSetting = assmtSubmissionSetting;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="assmtSetting")
    public AssmtResultSetting getAssmtResultSetting() {
        return this.assmtResultSetting;
    }
    
    public void setAssmtResultSetting(AssmtResultSetting assmtResultSetting) {
        this.assmtResultSetting = assmtResultSetting;
    }




}


