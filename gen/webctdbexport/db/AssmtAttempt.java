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
 * AssmtAttempt generated by hbm2java
 */
@Entity
@Table(name="ASSMT_ATTEMPT"
)
public class AssmtAttempt  implements java.io.Serializable {


     private BigDecimal id;
     private AssmtSubmission assmtSubmission;
     private BigDecimal beginDate;
     private char status;
     private boolean discardedFlag;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private BigDecimal score;
     private BigDecimal initialScore;
     private BigDecimal endDate;
     private Clob comments;
     private Set<AssmtAttemptItem> assmtAttemptItems = new HashSet<AssmtAttemptItem>(0);
     private Set<AssmtAttemptEvent> assmtAttemptEvents = new HashSet<AssmtAttemptEvent>(0);

    public AssmtAttempt() {
    }

	
    public AssmtAttempt(BigDecimal id, AssmtSubmission assmtSubmission, BigDecimal beginDate, char status, boolean discardedFlag, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.assmtSubmission = assmtSubmission;
        this.beginDate = beginDate;
        this.status = status;
        this.discardedFlag = discardedFlag;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public AssmtAttempt(BigDecimal id, AssmtSubmission assmtSubmission, BigDecimal beginDate, char status, boolean discardedFlag, BigDecimal createTs, BigDecimal lastmodifyTs, BigDecimal score, BigDecimal initialScore, BigDecimal endDate, Clob comments, Set<AssmtAttemptItem> assmtAttemptItems, Set<AssmtAttemptEvent> assmtAttemptEvents) {
       this.id = id;
       this.assmtSubmission = assmtSubmission;
       this.beginDate = beginDate;
       this.status = status;
       this.discardedFlag = discardedFlag;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.score = score;
       this.initialScore = initialScore;
       this.endDate = endDate;
       this.comments = comments;
       this.assmtAttemptItems = assmtAttemptItems;
       this.assmtAttemptEvents = assmtAttemptEvents;
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
    @JoinColumn(name="SUBMISSION_ID", nullable=false)
    public AssmtSubmission getAssmtSubmission() {
        return this.assmtSubmission;
    }
    
    public void setAssmtSubmission(AssmtSubmission assmtSubmission) {
        this.assmtSubmission = assmtSubmission;
    }

    
    @Column(name="BEGIN_DATE", nullable=false, precision=20, scale=0)
    public BigDecimal getBeginDate() {
        return this.beginDate;
    }
    
    public void setBeginDate(BigDecimal beginDate) {
        this.beginDate = beginDate;
    }

    
    @Column(name="STATUS", nullable=false, length=1)
    public char getStatus() {
        return this.status;
    }
    
    public void setStatus(char status) {
        this.status = status;
    }

    
    @Column(name="DISCARDED_FLAG", nullable=false, precision=1, scale=0)
    public boolean isDiscardedFlag() {
        return this.discardedFlag;
    }
    
    public void setDiscardedFlag(boolean discardedFlag) {
        this.discardedFlag = discardedFlag;
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

    
    @Column(name="SCORE", precision=9, scale=4)
    public BigDecimal getScore() {
        return this.score;
    }
    
    public void setScore(BigDecimal score) {
        this.score = score;
    }

    
    @Column(name="INITIAL_SCORE", precision=9, scale=4)
    public BigDecimal getInitialScore() {
        return this.initialScore;
    }
    
    public void setInitialScore(BigDecimal initialScore) {
        this.initialScore = initialScore;
    }

    
    @Column(name="END_DATE", precision=20, scale=0)
    public BigDecimal getEndDate() {
        return this.endDate;
    }
    
    public void setEndDate(BigDecimal endDate) {
        this.endDate = endDate;
    }

    
    @Column(name="COMMENTS")
    public Clob getComments() {
        return this.comments;
    }
    
    public void setComments(Clob comments) {
        this.comments = comments;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="assmtAttempt")
    public Set<AssmtAttemptItem> getAssmtAttemptItems() {
        return this.assmtAttemptItems;
    }
    
    public void setAssmtAttemptItems(Set<AssmtAttemptItem> assmtAttemptItems) {
        this.assmtAttemptItems = assmtAttemptItems;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="assmtAttempt")
    public Set<AssmtAttemptEvent> getAssmtAttemptEvents() {
        return this.assmtAttemptEvents;
    }
    
    public void setAssmtAttemptEvents(Set<AssmtAttemptEvent> assmtAttemptEvents) {
        this.assmtAttemptEvents = assmtAttemptEvents;
    }




}


