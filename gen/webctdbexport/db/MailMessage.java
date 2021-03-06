package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.sql.Clob;
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
 * MailMessage generated by hbm2java
 */
@Entity
@Table(name="MAIL_MESSAGE"
)
public class MailMessage  implements java.io.Serializable {


     private BigDecimal id;
     private SimpleFileGroup simpleFileGroup;
     private Person person;
     private LearningContext learningContext;
     private byte format;
     private byte urgency;
     private String subject;
     private boolean enclosures;
     private boolean shortMessageFlag;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private BigDecimal dateSent;
     private String shortMessage;
     private Clob longMessage;
     private Set<MailTarget> mailTargets = new HashSet<MailTarget>(0);
     private Set<MailReceipt> mailReceipts = new HashSet<MailReceipt>(0);

    public MailMessage() {
    }

	
    public MailMessage(BigDecimal id, Person person, LearningContext learningContext, byte format, byte urgency, String subject, boolean enclosures, boolean shortMessageFlag, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.person = person;
        this.learningContext = learningContext;
        this.format = format;
        this.urgency = urgency;
        this.subject = subject;
        this.enclosures = enclosures;
        this.shortMessageFlag = shortMessageFlag;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public MailMessage(BigDecimal id, SimpleFileGroup simpleFileGroup, Person person, LearningContext learningContext, byte format, byte urgency, String subject, boolean enclosures, boolean shortMessageFlag, BigDecimal createTs, BigDecimal lastmodifyTs, BigDecimal dateSent, String shortMessage, Clob longMessage, Set<MailTarget> mailTargets, Set<MailReceipt> mailReceipts) {
       this.id = id;
       this.simpleFileGroup = simpleFileGroup;
       this.person = person;
       this.learningContext = learningContext;
       this.format = format;
       this.urgency = urgency;
       this.subject = subject;
       this.enclosures = enclosures;
       this.shortMessageFlag = shortMessageFlag;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.dateSent = dateSent;
       this.shortMessage = shortMessage;
       this.longMessage = longMessage;
       this.mailTargets = mailTargets;
       this.mailReceipts = mailReceipts;
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
    @JoinColumn(name="FILE_GROUP_ID")
    public SimpleFileGroup getSimpleFileGroup() {
        return this.simpleFileGroup;
    }
    
    public void setSimpleFileGroup(SimpleFileGroup simpleFileGroup) {
        this.simpleFileGroup = simpleFileGroup;
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
    @JoinColumn(name="LEARNING_CONTEXT_ID", nullable=false)
    public LearningContext getLearningContext() {
        return this.learningContext;
    }
    
    public void setLearningContext(LearningContext learningContext) {
        this.learningContext = learningContext;
    }

    
    @Column(name="FORMAT", nullable=false, precision=2, scale=0)
    public byte getFormat() {
        return this.format;
    }
    
    public void setFormat(byte format) {
        this.format = format;
    }

    
    @Column(name="URGENCY", nullable=false, precision=2, scale=0)
    public byte getUrgency() {
        return this.urgency;
    }
    
    public void setUrgency(byte urgency) {
        this.urgency = urgency;
    }

    
    @Column(name="SUBJECT", nullable=false, length=900)
    public String getSubject() {
        return this.subject;
    }
    
    public void setSubject(String subject) {
        this.subject = subject;
    }

    
    @Column(name="ENCLOSURES", nullable=false, precision=1, scale=0)
    public boolean isEnclosures() {
        return this.enclosures;
    }
    
    public void setEnclosures(boolean enclosures) {
        this.enclosures = enclosures;
    }

    
    @Column(name="SHORT_MESSAGE_FLAG", nullable=false, precision=1, scale=0)
    public boolean isShortMessageFlag() {
        return this.shortMessageFlag;
    }
    
    public void setShortMessageFlag(boolean shortMessageFlag) {
        this.shortMessageFlag = shortMessageFlag;
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

    
    @Column(name="DATE_SENT", precision=20, scale=0)
    public BigDecimal getDateSent() {
        return this.dateSent;
    }
    
    public void setDateSent(BigDecimal dateSent) {
        this.dateSent = dateSent;
    }

    
    @Column(name="SHORT_MESSAGE", length=4000)
    public String getShortMessage() {
        return this.shortMessage;
    }
    
    public void setShortMessage(String shortMessage) {
        this.shortMessage = shortMessage;
    }

    
    @Column(name="LONG_MESSAGE")
    public Clob getLongMessage() {
        return this.longMessage;
    }
    
    public void setLongMessage(Clob longMessage) {
        this.longMessage = longMessage;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mailMessage")
    public Set<MailTarget> getMailTargets() {
        return this.mailTargets;
    }
    
    public void setMailTargets(Set<MailTarget> mailTargets) {
        this.mailTargets = mailTargets;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mailMessage")
    public Set<MailReceipt> getMailReceipts() {
        return this.mailReceipts;
    }
    
    public void setMailReceipts(Set<MailReceipt> mailReceipts) {
        this.mailReceipts = mailReceipts;
    }




}


