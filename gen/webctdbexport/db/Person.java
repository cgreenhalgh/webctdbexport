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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Person generated by hbm2java
 */
@Entity
@Table(name="PERSON"
)
public class Person  implements java.io.Serializable {


     private BigDecimal id;
     private SettingsGroup settingsGroup;
     private LearningContext learningContextByPortfolioId;
     private LearningContext learningContextByLearningContextId;
     private String webctId;
     private String webctIdLowercase;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private boolean activestatus;
     private boolean defaultuser;
     private boolean enableExternalMail;
     private boolean demouser;
     private boolean ftimeLoginPwreqOk;
     private String webctPassword;
     private String remoteUserid;
     private String nameNFamily;
     private String nameNGiven;
     private String nameNOther;
     private String nameNPrefix;
     private String nameNSuffix;
     private String nameFn;
     private String nameSort;
     private String nameNickname;
     private String hintQuestion;
     private String hintAnswer;
     private String demographicsGender;
     private BigDecimal demographicsBday;
     private String email;
     private String lastloginSessionid;
     private BigDecimal lastlogintime;
     private String lastlogoutSessionid;
     private BigDecimal lastlogouttime;
     private BigDecimal deletestatus;
     private String sourcedidSource;
     private BigDecimal lastpalmsynctime;
     private BigDecimal lastPwChangeTime;
     private BigDecimal homefolderId;
     private BigDecimal expirationDate;
     private String datasource;
     private boolean convertedToBb;
     private Set<CwbActivechatuser> cwbActivechatusers = new HashSet<CwbActivechatuser>(0);
     private Set<AgnSubmissionViewState> agnSubmissionViewStates = new HashSet<AgnSubmissionViewState>(0);
     private Set<ColMetaLcPerson> colMetaLcPersons = new HashSet<ColMetaLcPerson>(0);
     private Set<MyBookmark> myBookmarks = new HashSet<MyBookmark>(0);
     private Set<AgnToolViewState> agnToolViewStates = new HashSet<AgnToolViewState>(0);
     private Set<TocBookmark> tocBookmarks = new HashSet<TocBookmark>(0);
     private Set<CoNewStatus> coNewStatuses = new HashSet<CoNewStatus>(0);
     private Set<DisMessage> disMessages = new HashSet<DisMessage>(0);
     private Set<CoReadStatus> coReadStatuses = new HashSet<CoReadStatus>(0);
     private Set<DisRating> disRatings = new HashSet<DisRating>(0);
     private Set<CalendarEntry> calendarEntries = new HashSet<CalendarEntry>(0);
     private Set<LocalContentDesktopConfig> localContentDesktopConfigs = new HashSet<LocalContentDesktopConfig>(0);
     private Set<PreferenceNode> preferenceNodes = new HashSet<PreferenceNode>(0);
     private Set<MyPortalPreference> myPortalPreferences = new HashSet<MyPortalPreference>(0);
     private Set<NotesItem> notesItems = new HashSet<NotesItem>(0);
     private Set<DisPersonMessage> disPersonMessages = new HashSet<DisPersonMessage>(0);
     private Set<Member> members = new HashSet<Member>(0);
     private Set<Photo> photos = new HashSet<Photo>(0);
     private Set<DisTopicPersonSummary> disTopicPersonSummaries = new HashSet<DisTopicPersonSummary>(0);
     private Set<SrCriteriaDetail> srCriteriaDetails = new HashSet<SrCriteriaDetail>(0);
     private Set<PinAuth> pinAuths = new HashSet<PinAuth>(0);
     private Set<AnnouncementPersonRead> announcementPersonReads = new HashSet<AnnouncementPersonRead>(0);
     private Set<Phone> phones = new HashSet<Phone>(0);
     private Set<CpmLcEditorRel> cpmLcEditorRels = new HashSet<CpmLcEditorRel>(0);
     private Set<MailMessage> mailMessages = new HashSet<MailMessage>(0);
     private Set<MyNotepad> myNotepads = new HashSet<MyNotepad>(0);
     private Set<CmsContentEntry> cmsContentEntries = new HashSet<CmsContentEntry>(0);
     private Set<MailBox> mailBoxes = new HashSet<MailBox>(0);
     private PersonContentQuota personContentQuota;
     private Set<ColValue> colValues = new HashSet<ColValue>(0);
     private Set<Address> addresses = new HashSet<Address>(0);
     private Set<LocalContentTool> localContentTools = new HashSet<LocalContentTool>(0);
     private Set<Announcement> announcements = new HashSet<Announcement>(0);

    public Person() {
    }

	
    public Person(BigDecimal id, LearningContext learningContextByLearningContextId, String webctId, String webctIdLowercase, BigDecimal createTs, BigDecimal lastmodifyTs, boolean activestatus, boolean defaultuser, boolean enableExternalMail, boolean demouser, boolean ftimeLoginPwreqOk, String remoteUserid, String sourcedidSource, String datasource, boolean convertedToBb) {
        this.id = id;
        this.learningContextByLearningContextId = learningContextByLearningContextId;
        this.webctId = webctId;
        this.webctIdLowercase = webctIdLowercase;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
        this.activestatus = activestatus;
        this.defaultuser = defaultuser;
        this.enableExternalMail = enableExternalMail;
        this.demouser = demouser;
        this.ftimeLoginPwreqOk = ftimeLoginPwreqOk;
        this.remoteUserid = remoteUserid;
        this.sourcedidSource = sourcedidSource;
        this.datasource = datasource;
        this.convertedToBb = convertedToBb;
    }
    public Person(BigDecimal id, SettingsGroup settingsGroup, LearningContext learningContextByPortfolioId, LearningContext learningContextByLearningContextId, String webctId, String webctIdLowercase, BigDecimal createTs, BigDecimal lastmodifyTs, boolean activestatus, boolean defaultuser, boolean enableExternalMail, boolean demouser, boolean ftimeLoginPwreqOk, String webctPassword, String remoteUserid, String nameNFamily, String nameNGiven, String nameNOther, String nameNPrefix, String nameNSuffix, String nameFn, String nameSort, String nameNickname, String hintQuestion, String hintAnswer, String demographicsGender, BigDecimal demographicsBday, String email, String lastloginSessionid, BigDecimal lastlogintime, String lastlogoutSessionid, BigDecimal lastlogouttime, BigDecimal deletestatus, String sourcedidSource, BigDecimal lastpalmsynctime, BigDecimal lastPwChangeTime, BigDecimal homefolderId, BigDecimal expirationDate, String datasource, boolean convertedToBb, Set<CwbActivechatuser> cwbActivechatusers, Set<AgnSubmissionViewState> agnSubmissionViewStates, Set<ColMetaLcPerson> colMetaLcPersons, Set<MyBookmark> myBookmarks, Set<AgnToolViewState> agnToolViewStates, Set<TocBookmark> tocBookmarks, Set<CoNewStatus> coNewStatuses, Set<DisMessage> disMessages, Set<CoReadStatus> coReadStatuses, Set<DisRating> disRatings, Set<CalendarEntry> calendarEntries, Set<LocalContentDesktopConfig> localContentDesktopConfigs, Set<PreferenceNode> preferenceNodes, Set<MyPortalPreference> myPortalPreferences, Set<NotesItem> notesItems, Set<DisPersonMessage> disPersonMessages, Set<Member> members, Set<Photo> photos, Set<DisTopicPersonSummary> disTopicPersonSummaries, Set<SrCriteriaDetail> srCriteriaDetails, Set<PinAuth> pinAuths, Set<AnnouncementPersonRead> announcementPersonReads, Set<Phone> phones, Set<CpmLcEditorRel> cpmLcEditorRels, Set<MailMessage> mailMessages, Set<MyNotepad> myNotepads, Set<CmsContentEntry> cmsContentEntries, Set<MailBox> mailBoxes, PersonContentQuota personContentQuota, Set<ColValue> colValues, Set<Address> addresses, Set<LocalContentTool> localContentTools, Set<Announcement> announcements) {
       this.id = id;
       this.settingsGroup = settingsGroup;
       this.learningContextByPortfolioId = learningContextByPortfolioId;
       this.learningContextByLearningContextId = learningContextByLearningContextId;
       this.webctId = webctId;
       this.webctIdLowercase = webctIdLowercase;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.activestatus = activestatus;
       this.defaultuser = defaultuser;
       this.enableExternalMail = enableExternalMail;
       this.demouser = demouser;
       this.ftimeLoginPwreqOk = ftimeLoginPwreqOk;
       this.webctPassword = webctPassword;
       this.remoteUserid = remoteUserid;
       this.nameNFamily = nameNFamily;
       this.nameNGiven = nameNGiven;
       this.nameNOther = nameNOther;
       this.nameNPrefix = nameNPrefix;
       this.nameNSuffix = nameNSuffix;
       this.nameFn = nameFn;
       this.nameSort = nameSort;
       this.nameNickname = nameNickname;
       this.hintQuestion = hintQuestion;
       this.hintAnswer = hintAnswer;
       this.demographicsGender = demographicsGender;
       this.demographicsBday = demographicsBday;
       this.email = email;
       this.lastloginSessionid = lastloginSessionid;
       this.lastlogintime = lastlogintime;
       this.lastlogoutSessionid = lastlogoutSessionid;
       this.lastlogouttime = lastlogouttime;
       this.deletestatus = deletestatus;
       this.sourcedidSource = sourcedidSource;
       this.lastpalmsynctime = lastpalmsynctime;
       this.lastPwChangeTime = lastPwChangeTime;
       this.homefolderId = homefolderId;
       this.expirationDate = expirationDate;
       this.datasource = datasource;
       this.convertedToBb = convertedToBb;
       this.cwbActivechatusers = cwbActivechatusers;
       this.agnSubmissionViewStates = agnSubmissionViewStates;
       this.colMetaLcPersons = colMetaLcPersons;
       this.myBookmarks = myBookmarks;
       this.agnToolViewStates = agnToolViewStates;
       this.tocBookmarks = tocBookmarks;
       this.coNewStatuses = coNewStatuses;
       this.disMessages = disMessages;
       this.coReadStatuses = coReadStatuses;
       this.disRatings = disRatings;
       this.calendarEntries = calendarEntries;
       this.localContentDesktopConfigs = localContentDesktopConfigs;
       this.preferenceNodes = preferenceNodes;
       this.myPortalPreferences = myPortalPreferences;
       this.notesItems = notesItems;
       this.disPersonMessages = disPersonMessages;
       this.members = members;
       this.photos = photos;
       this.disTopicPersonSummaries = disTopicPersonSummaries;
       this.srCriteriaDetails = srCriteriaDetails;
       this.pinAuths = pinAuths;
       this.announcementPersonReads = announcementPersonReads;
       this.phones = phones;
       this.cpmLcEditorRels = cpmLcEditorRels;
       this.mailMessages = mailMessages;
       this.myNotepads = myNotepads;
       this.cmsContentEntries = cmsContentEntries;
       this.mailBoxes = mailBoxes;
       this.personContentQuota = personContentQuota;
       this.colValues = colValues;
       this.addresses = addresses;
       this.localContentTools = localContentTools;
       this.announcements = announcements;
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
    @JoinColumn(name="SMS_GROUP_ID")
    public SettingsGroup getSettingsGroup() {
        return this.settingsGroup;
    }
    
    public void setSettingsGroup(SettingsGroup settingsGroup) {
        this.settingsGroup = settingsGroup;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PORTFOLIO_ID")
    public LearningContext getLearningContextByPortfolioId() {
        return this.learningContextByPortfolioId;
    }
    
    public void setLearningContextByPortfolioId(LearningContext learningContextByPortfolioId) {
        this.learningContextByPortfolioId = learningContextByPortfolioId;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LEARNING_CONTEXT_ID", nullable=false)
    public LearningContext getLearningContextByLearningContextId() {
        return this.learningContextByLearningContextId;
    }
    
    public void setLearningContextByLearningContextId(LearningContext learningContextByLearningContextId) {
        this.learningContextByLearningContextId = learningContextByLearningContextId;
    }

    
    @Column(name="WEBCT_ID", nullable=false, length=768)
    public String getWebctId() {
        return this.webctId;
    }
    
    public void setWebctId(String webctId) {
        this.webctId = webctId;
    }

    
    @Column(name="WEBCT_ID_LOWERCASE", nullable=false, length=768)
    public String getWebctIdLowercase() {
        return this.webctIdLowercase;
    }
    
    public void setWebctIdLowercase(String webctIdLowercase) {
        this.webctIdLowercase = webctIdLowercase;
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

    
    @Column(name="ACTIVESTATUS", nullable=false, precision=1, scale=0)
    public boolean isActivestatus() {
        return this.activestatus;
    }
    
    public void setActivestatus(boolean activestatus) {
        this.activestatus = activestatus;
    }

    
    @Column(name="DEFAULTUSER", nullable=false, precision=1, scale=0)
    public boolean isDefaultuser() {
        return this.defaultuser;
    }
    
    public void setDefaultuser(boolean defaultuser) {
        this.defaultuser = defaultuser;
    }

    
    @Column(name="ENABLE_EXTERNAL_MAIL", nullable=false, precision=1, scale=0)
    public boolean isEnableExternalMail() {
        return this.enableExternalMail;
    }
    
    public void setEnableExternalMail(boolean enableExternalMail) {
        this.enableExternalMail = enableExternalMail;
    }

    
    @Column(name="DEMOUSER", nullable=false, precision=1, scale=0)
    public boolean isDemouser() {
        return this.demouser;
    }
    
    public void setDemouser(boolean demouser) {
        this.demouser = demouser;
    }

    
    @Column(name="FTIME_LOGIN_PWREQ_OK", nullable=false, precision=1, scale=0)
    public boolean isFtimeLoginPwreqOk() {
        return this.ftimeLoginPwreqOk;
    }
    
    public void setFtimeLoginPwreqOk(boolean ftimeLoginPwreqOk) {
        this.ftimeLoginPwreqOk = ftimeLoginPwreqOk;
    }

    
    @Column(name="WEBCT_PASSWORD", length=128)
    public String getWebctPassword() {
        return this.webctPassword;
    }
    
    public void setWebctPassword(String webctPassword) {
        this.webctPassword = webctPassword;
    }

    
    @Column(name="REMOTE_USERID", nullable=false, length=768)
    public String getRemoteUserid() {
        return this.remoteUserid;
    }
    
    public void setRemoteUserid(String remoteUserid) {
        this.remoteUserid = remoteUserid;
    }

    
    @Column(name="NAME_N_FAMILY", length=768)
    public String getNameNFamily() {
        return this.nameNFamily;
    }
    
    public void setNameNFamily(String nameNFamily) {
        this.nameNFamily = nameNFamily;
    }

    
    @Column(name="NAME_N_GIVEN", length=768)
    public String getNameNGiven() {
        return this.nameNGiven;
    }
    
    public void setNameNGiven(String nameNGiven) {
        this.nameNGiven = nameNGiven;
    }

    
    @Column(name="NAME_N_OTHER", length=768)
    public String getNameNOther() {
        return this.nameNOther;
    }
    
    public void setNameNOther(String nameNOther) {
        this.nameNOther = nameNOther;
    }

    
    @Column(name="NAME_N_PREFIX", length=96)
    public String getNameNPrefix() {
        return this.nameNPrefix;
    }
    
    public void setNameNPrefix(String nameNPrefix) {
        this.nameNPrefix = nameNPrefix;
    }

    
    @Column(name="NAME_N_SUFFIX", length=96)
    public String getNameNSuffix() {
        return this.nameNSuffix;
    }
    
    public void setNameNSuffix(String nameNSuffix) {
        this.nameNSuffix = nameNSuffix;
    }

    
    @Column(name="NAME_FN", length=768)
    public String getNameFn() {
        return this.nameFn;
    }
    
    public void setNameFn(String nameFn) {
        this.nameFn = nameFn;
    }

    
    @Column(name="NAME_SORT", length=768)
    public String getNameSort() {
        return this.nameSort;
    }
    
    public void setNameSort(String nameSort) {
        this.nameSort = nameSort;
    }

    
    @Column(name="NAME_NICKNAME", length=768)
    public String getNameNickname() {
        return this.nameNickname;
    }
    
    public void setNameNickname(String nameNickname) {
        this.nameNickname = nameNickname;
    }

    
    @Column(name="HINT_QUESTION", length=1000)
    public String getHintQuestion() {
        return this.hintQuestion;
    }
    
    public void setHintQuestion(String hintQuestion) {
        this.hintQuestion = hintQuestion;
    }

    
    @Column(name="HINT_ANSWER", length=300)
    public String getHintAnswer() {
        return this.hintAnswer;
    }
    
    public void setHintAnswer(String hintAnswer) {
        this.hintAnswer = hintAnswer;
    }

    
    @Column(name="DEMOGRAPHICS_GENDER", length=64)
    public String getDemographicsGender() {
        return this.demographicsGender;
    }
    
    public void setDemographicsGender(String demographicsGender) {
        this.demographicsGender = demographicsGender;
    }

    
    @Column(name="DEMOGRAPHICS_BDAY", precision=20, scale=0)
    public BigDecimal getDemographicsBday() {
        return this.demographicsBday;
    }
    
    public void setDemographicsBday(BigDecimal demographicsBday) {
        this.demographicsBday = demographicsBday;
    }

    
    @Column(name="EMAIL", length=320)
    public String getEmail() {
        return this.email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    
    @Column(name="LASTLOGIN_SESSIONID", length=256)
    public String getLastloginSessionid() {
        return this.lastloginSessionid;
    }
    
    public void setLastloginSessionid(String lastloginSessionid) {
        this.lastloginSessionid = lastloginSessionid;
    }

    
    @Column(name="LASTLOGINTIME", precision=20, scale=0)
    public BigDecimal getLastlogintime() {
        return this.lastlogintime;
    }
    
    public void setLastlogintime(BigDecimal lastlogintime) {
        this.lastlogintime = lastlogintime;
    }

    
    @Column(name="LASTLOGOUT_SESSIONID", length=256)
    public String getLastlogoutSessionid() {
        return this.lastlogoutSessionid;
    }
    
    public void setLastlogoutSessionid(String lastlogoutSessionid) {
        this.lastlogoutSessionid = lastlogoutSessionid;
    }

    
    @Column(name="LASTLOGOUTTIME", precision=20, scale=0)
    public BigDecimal getLastlogouttime() {
        return this.lastlogouttime;
    }
    
    public void setLastlogouttime(BigDecimal lastlogouttime) {
        this.lastlogouttime = lastlogouttime;
    }

    
    @Column(name="DELETESTATUS", precision=20, scale=0)
    public BigDecimal getDeletestatus() {
        return this.deletestatus;
    }
    
    public void setDeletestatus(BigDecimal deletestatus) {
        this.deletestatus = deletestatus;
    }

    
    @Column(name="SOURCEDID_SOURCE", nullable=false, length=510)
    public String getSourcedidSource() {
        return this.sourcedidSource;
    }
    
    public void setSourcedidSource(String sourcedidSource) {
        this.sourcedidSource = sourcedidSource;
    }

    
    @Column(name="LASTPALMSYNCTIME", precision=20, scale=0)
    public BigDecimal getLastpalmsynctime() {
        return this.lastpalmsynctime;
    }
    
    public void setLastpalmsynctime(BigDecimal lastpalmsynctime) {
        this.lastpalmsynctime = lastpalmsynctime;
    }

    
    @Column(name="LAST_PW_CHANGE_TIME", precision=20, scale=0)
    public BigDecimal getLastPwChangeTime() {
        return this.lastPwChangeTime;
    }
    
    public void setLastPwChangeTime(BigDecimal lastPwChangeTime) {
        this.lastPwChangeTime = lastPwChangeTime;
    }

    
    @Column(name="HOMEFOLDER_ID", precision=20, scale=0)
    public BigDecimal getHomefolderId() {
        return this.homefolderId;
    }
    
    public void setHomefolderId(BigDecimal homefolderId) {
        this.homefolderId = homefolderId;
    }

    
    @Column(name="EXPIRATION_DATE", precision=20, scale=0)
    public BigDecimal getExpirationDate() {
        return this.expirationDate;
    }
    
    public void setExpirationDate(BigDecimal expirationDate) {
        this.expirationDate = expirationDate;
    }

    
    @Column(name="DATASOURCE", nullable=false, length=510)
    public String getDatasource() {
        return this.datasource;
    }
    
    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    
    @Column(name="CONVERTED_TO_BB", nullable=false, precision=1, scale=0)
    public boolean isConvertedToBb() {
        return this.convertedToBb;
    }
    
    public void setConvertedToBb(boolean convertedToBb) {
        this.convertedToBb = convertedToBb;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<CwbActivechatuser> getCwbActivechatusers() {
        return this.cwbActivechatusers;
    }
    
    public void setCwbActivechatusers(Set<CwbActivechatuser> cwbActivechatusers) {
        this.cwbActivechatusers = cwbActivechatusers;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<AgnSubmissionViewState> getAgnSubmissionViewStates() {
        return this.agnSubmissionViewStates;
    }
    
    public void setAgnSubmissionViewStates(Set<AgnSubmissionViewState> agnSubmissionViewStates) {
        this.agnSubmissionViewStates = agnSubmissionViewStates;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<ColMetaLcPerson> getColMetaLcPersons() {
        return this.colMetaLcPersons;
    }
    
    public void setColMetaLcPersons(Set<ColMetaLcPerson> colMetaLcPersons) {
        this.colMetaLcPersons = colMetaLcPersons;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<MyBookmark> getMyBookmarks() {
        return this.myBookmarks;
    }
    
    public void setMyBookmarks(Set<MyBookmark> myBookmarks) {
        this.myBookmarks = myBookmarks;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<AgnToolViewState> getAgnToolViewStates() {
        return this.agnToolViewStates;
    }
    
    public void setAgnToolViewStates(Set<AgnToolViewState> agnToolViewStates) {
        this.agnToolViewStates = agnToolViewStates;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<TocBookmark> getTocBookmarks() {
        return this.tocBookmarks;
    }
    
    public void setTocBookmarks(Set<TocBookmark> tocBookmarks) {
        this.tocBookmarks = tocBookmarks;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<CoNewStatus> getCoNewStatuses() {
        return this.coNewStatuses;
    }
    
    public void setCoNewStatuses(Set<CoNewStatus> coNewStatuses) {
        this.coNewStatuses = coNewStatuses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<DisMessage> getDisMessages() {
        return this.disMessages;
    }
    
    public void setDisMessages(Set<DisMessage> disMessages) {
        this.disMessages = disMessages;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<CoReadStatus> getCoReadStatuses() {
        return this.coReadStatuses;
    }
    
    public void setCoReadStatuses(Set<CoReadStatus> coReadStatuses) {
        this.coReadStatuses = coReadStatuses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<DisRating> getDisRatings() {
        return this.disRatings;
    }
    
    public void setDisRatings(Set<DisRating> disRatings) {
        this.disRatings = disRatings;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<CalendarEntry> getCalendarEntries() {
        return this.calendarEntries;
    }
    
    public void setCalendarEntries(Set<CalendarEntry> calendarEntries) {
        this.calendarEntries = calendarEntries;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<LocalContentDesktopConfig> getLocalContentDesktopConfigs() {
        return this.localContentDesktopConfigs;
    }
    
    public void setLocalContentDesktopConfigs(Set<LocalContentDesktopConfig> localContentDesktopConfigs) {
        this.localContentDesktopConfigs = localContentDesktopConfigs;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<PreferenceNode> getPreferenceNodes() {
        return this.preferenceNodes;
    }
    
    public void setPreferenceNodes(Set<PreferenceNode> preferenceNodes) {
        this.preferenceNodes = preferenceNodes;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<MyPortalPreference> getMyPortalPreferences() {
        return this.myPortalPreferences;
    }
    
    public void setMyPortalPreferences(Set<MyPortalPreference> myPortalPreferences) {
        this.myPortalPreferences = myPortalPreferences;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<NotesItem> getNotesItems() {
        return this.notesItems;
    }
    
    public void setNotesItems(Set<NotesItem> notesItems) {
        this.notesItems = notesItems;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<DisPersonMessage> getDisPersonMessages() {
        return this.disPersonMessages;
    }
    
    public void setDisPersonMessages(Set<DisPersonMessage> disPersonMessages) {
        this.disPersonMessages = disPersonMessages;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<Member> getMembers() {
        return this.members;
    }
    
    public void setMembers(Set<Member> members) {
        this.members = members;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<Photo> getPhotos() {
        return this.photos;
    }
    
    public void setPhotos(Set<Photo> photos) {
        this.photos = photos;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<DisTopicPersonSummary> getDisTopicPersonSummaries() {
        return this.disTopicPersonSummaries;
    }
    
    public void setDisTopicPersonSummaries(Set<DisTopicPersonSummary> disTopicPersonSummaries) {
        this.disTopicPersonSummaries = disTopicPersonSummaries;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<SrCriteriaDetail> getSrCriteriaDetails() {
        return this.srCriteriaDetails;
    }
    
    public void setSrCriteriaDetails(Set<SrCriteriaDetail> srCriteriaDetails) {
        this.srCriteriaDetails = srCriteriaDetails;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<PinAuth> getPinAuths() {
        return this.pinAuths;
    }
    
    public void setPinAuths(Set<PinAuth> pinAuths) {
        this.pinAuths = pinAuths;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<AnnouncementPersonRead> getAnnouncementPersonReads() {
        return this.announcementPersonReads;
    }
    
    public void setAnnouncementPersonReads(Set<AnnouncementPersonRead> announcementPersonReads) {
        this.announcementPersonReads = announcementPersonReads;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<Phone> getPhones() {
        return this.phones;
    }
    
    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<CpmLcEditorRel> getCpmLcEditorRels() {
        return this.cpmLcEditorRels;
    }
    
    public void setCpmLcEditorRels(Set<CpmLcEditorRel> cpmLcEditorRels) {
        this.cpmLcEditorRels = cpmLcEditorRels;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<MailMessage> getMailMessages() {
        return this.mailMessages;
    }
    
    public void setMailMessages(Set<MailMessage> mailMessages) {
        this.mailMessages = mailMessages;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<MyNotepad> getMyNotepads() {
        return this.myNotepads;
    }
    
    public void setMyNotepads(Set<MyNotepad> myNotepads) {
        this.myNotepads = myNotepads;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<CmsContentEntry> getCmsContentEntries() {
        return this.cmsContentEntries;
    }
    
    public void setCmsContentEntries(Set<CmsContentEntry> cmsContentEntries) {
        this.cmsContentEntries = cmsContentEntries;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<MailBox> getMailBoxes() {
        return this.mailBoxes;
    }
    
    public void setMailBoxes(Set<MailBox> mailBoxes) {
        this.mailBoxes = mailBoxes;
    }

@OneToOne(fetch=FetchType.EAGER, mappedBy="person")
    public PersonContentQuota getPersonContentQuota() {
        return this.personContentQuota;
    }
    
    public void setPersonContentQuota(PersonContentQuota personContentQuota) {
        this.personContentQuota = personContentQuota;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<ColValue> getColValues() {
        return this.colValues;
    }
    
    public void setColValues(Set<ColValue> colValues) {
        this.colValues = colValues;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<Address> getAddresses() {
        return this.addresses;
    }
    
    public void setAddresses(Set<Address> addresses) {
        this.addresses = addresses;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<LocalContentTool> getLocalContentTools() {
        return this.localContentTools;
    }
    
    public void setLocalContentTools(Set<LocalContentTool> localContentTools) {
        this.localContentTools = localContentTools;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="person")
    public Set<Announcement> getAnnouncements() {
        return this.announcements;
    }
    
    public void setAnnouncements(Set<Announcement> announcements) {
        this.announcements = announcements;
    }




}


