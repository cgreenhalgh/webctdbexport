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
 * RubricLink generated by hbm2java
 */
@Entity
@Table(name="RUBRIC_LINK"
)
public class RubricLink  implements java.io.Serializable {


     private BigDecimal id;
     private RubricUsage rubricUsage;
     private Rubric rubric;
     private DisMessage disMessage;
     private SectionColumn sectionColumn;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private Set<RubricLinkCellResult> rubricLinkCellResults = new HashSet<RubricLinkCellResult>(0);
     private Set<RubricLinkResult> rubricLinkResults = new HashSet<RubricLinkResult>(0);

    public RubricLink() {
    }

	
    public RubricLink(BigDecimal id, Rubric rubric, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.rubric = rubric;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public RubricLink(BigDecimal id, RubricUsage rubricUsage, Rubric rubric, DisMessage disMessage, SectionColumn sectionColumn, BigDecimal createTs, BigDecimal lastmodifyTs, Set<RubricLinkCellResult> rubricLinkCellResults, Set<RubricLinkResult> rubricLinkResults) {
       this.id = id;
       this.rubricUsage = rubricUsage;
       this.rubric = rubric;
       this.disMessage = disMessage;
       this.sectionColumn = sectionColumn;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.rubricLinkCellResults = rubricLinkCellResults;
       this.rubricLinkResults = rubricLinkResults;
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
    @JoinColumn(name="RUBRIC_USAGE_ID")
    public RubricUsage getRubricUsage() {
        return this.rubricUsage;
    }
    
    public void setRubricUsage(RubricUsage rubricUsage) {
        this.rubricUsage = rubricUsage;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="RUBRIC_ID", nullable=false)
    public Rubric getRubric() {
        return this.rubric;
    }
    
    public void setRubric(Rubric rubric) {
        this.rubric = rubric;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="DIS_MESSAGE_ID")
    public DisMessage getDisMessage() {
        return this.disMessage;
    }
    
    public void setDisMessage(DisMessage disMessage) {
        this.disMessage = disMessage;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="SECTION_COLUMN_ID")
    public SectionColumn getSectionColumn() {
        return this.sectionColumn;
    }
    
    public void setSectionColumn(SectionColumn sectionColumn) {
        this.sectionColumn = sectionColumn;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="rubricLink")
    public Set<RubricLinkCellResult> getRubricLinkCellResults() {
        return this.rubricLinkCellResults;
    }
    
    public void setRubricLinkCellResults(Set<RubricLinkCellResult> rubricLinkCellResults) {
        this.rubricLinkCellResults = rubricLinkCellResults;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rubricLink")
    public Set<RubricLinkResult> getRubricLinkResults() {
        return this.rubricLinkResults;
    }
    
    public void setRubricLinkResults(Set<RubricLinkResult> rubricLinkResults) {
        this.rubricLinkResults = rubricLinkResults;
    }




}


