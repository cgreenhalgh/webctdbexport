package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * AgnAssignee generated by hbm2java
 */
@Entity
@Table(name="AGN_ASSIGNEE"
)
public class AgnAssignee  implements java.io.Serializable {


     private BigDecimal id;
     private Member member;
     private AgnGroupassignment agnGroupassignment;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public AgnAssignee() {
    }

    public AgnAssignee(BigDecimal id, Member member, AgnGroupassignment agnGroupassignment, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.member = member;
       this.agnGroupassignment = agnGroupassignment;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
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
    @JoinColumn(name="MEMBER_ID", nullable=false)
    public Member getMember() {
        return this.member;
    }
    
    public void setMember(Member member) {
        this.member = member;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="GROUPASSIGNMENT_ID", nullable=false)
    public AgnGroupassignment getAgnGroupassignment() {
        return this.agnGroupassignment;
    }
    
    public void setAgnGroupassignment(AgnGroupassignment agnGroupassignment) {
        this.agnGroupassignment = agnGroupassignment;
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




}


