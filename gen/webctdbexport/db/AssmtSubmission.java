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
 * AssmtSubmission generated by hbm2java
 */
@Entity
@Table(name="ASSMT_SUBMISSION"
)
public class AssmtSubmission  implements java.io.Serializable {


     private BigDecimal id;
     private AssmtAssessment assmtAssessment;
     private Member member;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private Set<AssmtAttempt> assmtAttempts = new HashSet<AssmtAttempt>(0);

    public AssmtSubmission() {
    }

	
    public AssmtSubmission(BigDecimal id, AssmtAssessment assmtAssessment, Member member, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.assmtAssessment = assmtAssessment;
        this.member = member;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public AssmtSubmission(BigDecimal id, AssmtAssessment assmtAssessment, Member member, BigDecimal createTs, BigDecimal lastmodifyTs, Set<AssmtAttempt> assmtAttempts) {
       this.id = id;
       this.assmtAssessment = assmtAssessment;
       this.member = member;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.assmtAttempts = assmtAttempts;
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
    @JoinColumn(name="MEMBER_ID", nullable=false)
    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="assmtSubmission")
    public Set<AssmtAttempt> getAssmtAttempts() {
        return this.assmtAttempts;
    }
    
    public void setAssmtAttempts(Set<AssmtAttempt> assmtAttempts) {
        this.assmtAttempts = assmtAttempts;
    }




}


