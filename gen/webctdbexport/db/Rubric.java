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
import javax.persistence.Version;

/**
 * Rubric generated by hbm2java
 */
@Entity
@Table(name="RUBRIC"
)
public class Rubric  implements java.io.Serializable {


     private BigDecimal id;
     private BigDecimal version;
     private CoTemplate coTemplate;
     private String name;
     private byte rubricType;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private String maxScore;
     private String description;
     private Set<RubricRow> rubricRows = new HashSet<RubricRow>(0);
     private Set<RubricLink> rubricLinks = new HashSet<RubricLink>(0);
     private Set<RubricColumn> rubricColumns = new HashSet<RubricColumn>(0);
     private Set<RubricUsage> rubricUsages = new HashSet<RubricUsage>(0);

    public Rubric() {
    }

	
    public Rubric(BigDecimal id, CoTemplate coTemplate, String name, byte rubricType, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.coTemplate = coTemplate;
        this.name = name;
        this.rubricType = rubricType;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public Rubric(BigDecimal id, CoTemplate coTemplate, String name, byte rubricType, BigDecimal createTs, BigDecimal lastmodifyTs, String maxScore, String description, Set<RubricRow> rubricRows, Set<RubricLink> rubricLinks, Set<RubricColumn> rubricColumns, Set<RubricUsage> rubricUsages) {
       this.id = id;
       this.coTemplate = coTemplate;
       this.name = name;
       this.rubricType = rubricType;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.maxScore = maxScore;
       this.description = description;
       this.rubricRows = rubricRows;
       this.rubricLinks = rubricLinks;
       this.rubricColumns = rubricColumns;
       this.rubricUsages = rubricUsages;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

//    @Version
    @Column(name="VERSION", nullable=false, precision=20, scale=0)
    public BigDecimal getVersion() {
        return this.version;
    }
    
    public void setVersion(BigDecimal version) {
        this.version = version;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="TEMPLATE_ID", nullable=false)
    public CoTemplate getCoTemplate() {
        return this.coTemplate;
    }
    
    public void setCoTemplate(CoTemplate coTemplate) {
        this.coTemplate = coTemplate;
    }

    
    @Column(name="NAME", nullable=false, length=750)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="RUBRIC_TYPE", nullable=false, precision=2, scale=0)
    public byte getRubricType() {
        return this.rubricType;
    }
    
    public void setRubricType(byte rubricType) {
        this.rubricType = rubricType;
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

    
    @Column(name="MAX_SCORE", length=200)
    public String getMaxScore() {
        return this.maxScore;
    }
    
    public void setMaxScore(String maxScore) {
        this.maxScore = maxScore;
    }

    
    @Column(name="DESCRIPTION", length=3000)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rubric")
    public Set<RubricRow> getRubricRows() {
        return this.rubricRows;
    }
    
    public void setRubricRows(Set<RubricRow> rubricRows) {
        this.rubricRows = rubricRows;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rubric")
    public Set<RubricLink> getRubricLinks() {
        return this.rubricLinks;
    }
    
    public void setRubricLinks(Set<RubricLink> rubricLinks) {
        this.rubricLinks = rubricLinks;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rubric")
    public Set<RubricColumn> getRubricColumns() {
        return this.rubricColumns;
    }
    
    public void setRubricColumns(Set<RubricColumn> rubricColumns) {
        this.rubricColumns = rubricColumns;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="rubric")
    public Set<RubricUsage> getRubricUsages() {
        return this.rubricUsages;
    }
    
    public void setRubricUsages(Set<RubricUsage> rubricUsages) {
        this.rubricUsages = rubricUsages;
    }




}


