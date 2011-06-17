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
 * LcTerm generated by hbm2java
 */
@Entity
@Table(name="LC_TERM"
)
public class LcTerm  implements java.io.Serializable {


     private BigDecimal id;
     private LearningContext learningContext;
     private String name;
     private String nameLowercase;
     private String sourceName;
     private String sourceId;
     private boolean restrictLearner;
     private boolean restrictSdes;
     private boolean restrictSins;
     private boolean restrictStea;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private BigDecimal startdateTime;
     private BigDecimal enddateTime;
     private String datasource;
     private Clob description;
     private Clob fulldescription;
     private boolean hiddenTerm;
     private Set<LcTermMapping> lcTermMappings = new HashSet<LcTermMapping>(0);
     private Set<LearningContextProxy> learningContextProxies = new HashSet<LearningContextProxy>(0);

    public LcTerm() {
    }

	
    public LcTerm(BigDecimal id, LearningContext learningContext, String name, String nameLowercase, String sourceName, String sourceId, boolean restrictLearner, boolean restrictSdes, boolean restrictSins, boolean restrictStea, BigDecimal createTs, BigDecimal lastmodifyTs, boolean hiddenTerm) {
        this.id = id;
        this.learningContext = learningContext;
        this.name = name;
        this.nameLowercase = nameLowercase;
        this.sourceName = sourceName;
        this.sourceId = sourceId;
        this.restrictLearner = restrictLearner;
        this.restrictSdes = restrictSdes;
        this.restrictSins = restrictSins;
        this.restrictStea = restrictStea;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
        this.hiddenTerm = hiddenTerm;
    }
    public LcTerm(BigDecimal id, LearningContext learningContext, String name, String nameLowercase, String sourceName, String sourceId, boolean restrictLearner, boolean restrictSdes, boolean restrictSins, boolean restrictStea, BigDecimal createTs, BigDecimal lastmodifyTs, BigDecimal startdateTime, BigDecimal enddateTime, String datasource, Clob description, Clob fulldescription, boolean hiddenTerm, Set<LcTermMapping> lcTermMappings, Set<LearningContextProxy> learningContextProxies) {
       this.id = id;
       this.learningContext = learningContext;
       this.name = name;
       this.nameLowercase = nameLowercase;
       this.sourceName = sourceName;
       this.sourceId = sourceId;
       this.restrictLearner = restrictLearner;
       this.restrictSdes = restrictSdes;
       this.restrictSins = restrictSins;
       this.restrictStea = restrictStea;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.startdateTime = startdateTime;
       this.enddateTime = enddateTime;
       this.datasource = datasource;
       this.description = description;
       this.fulldescription = fulldescription;
       this.hiddenTerm = hiddenTerm;
       this.lcTermMappings = lcTermMappings;
       this.learningContextProxies = learningContextProxies;
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
    @JoinColumn(name="INST_LCID", nullable=false)
    public LearningContext getLearningContext() {
        return this.learningContext;
    }
    
    public void setLearningContext(LearningContext learningContext) {
        this.learningContext = learningContext;
    }

    
    @Column(name="NAME", nullable=false, length=1000)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    @Column(name="NAME_LOWERCASE", nullable=false, length=1000)
    public String getNameLowercase() {
        return this.nameLowercase;
    }
    
    public void setNameLowercase(String nameLowercase) {
        this.nameLowercase = nameLowercase;
    }

    
    @Column(name="SOURCE_NAME", nullable=false, length=510)
    public String getSourceName() {
        return this.sourceName;
    }
    
    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    
    @Column(name="SOURCE_ID", nullable=false, length=768)
    public String getSourceId() {
        return this.sourceId;
    }
    
    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    
    @Column(name="RESTRICT_LEARNER", nullable=false, precision=1, scale=0)
    public boolean isRestrictLearner() {
        return this.restrictLearner;
    }
    
    public void setRestrictLearner(boolean restrictLearner) {
        this.restrictLearner = restrictLearner;
    }

    
    @Column(name="RESTRICT_SDES", nullable=false, precision=1, scale=0)
    public boolean isRestrictSdes() {
        return this.restrictSdes;
    }
    
    public void setRestrictSdes(boolean restrictSdes) {
        this.restrictSdes = restrictSdes;
    }

    
    @Column(name="RESTRICT_SINS", nullable=false, precision=1, scale=0)
    public boolean isRestrictSins() {
        return this.restrictSins;
    }
    
    public void setRestrictSins(boolean restrictSins) {
        this.restrictSins = restrictSins;
    }

    
    @Column(name="RESTRICT_STEA", nullable=false, precision=1, scale=0)
    public boolean isRestrictStea() {
        return this.restrictStea;
    }
    
    public void setRestrictStea(boolean restrictStea) {
        this.restrictStea = restrictStea;
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

    
    @Column(name="STARTDATE_TIME", precision=20, scale=0)
    public BigDecimal getStartdateTime() {
        return this.startdateTime;
    }
    
    public void setStartdateTime(BigDecimal startdateTime) {
        this.startdateTime = startdateTime;
    }

    
    @Column(name="ENDDATE_TIME", precision=20, scale=0)
    public BigDecimal getEnddateTime() {
        return this.enddateTime;
    }
    
    public void setEnddateTime(BigDecimal enddateTime) {
        this.enddateTime = enddateTime;
    }

    
    @Column(name="DATASOURCE", length=768)
    public String getDatasource() {
        return this.datasource;
    }
    
    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    
    @Column(name="DESCRIPTION")
    public Clob getDescription() {
        return this.description;
    }
    
    public void setDescription(Clob description) {
        this.description = description;
    }

    
    @Column(name="FULLDESCRIPTION")
    public Clob getFulldescription() {
        return this.fulldescription;
    }
    
    public void setFulldescription(Clob fulldescription) {
        this.fulldescription = fulldescription;
    }

    
    @Column(name="HIDDEN_TERM", nullable=false, precision=1, scale=0)
    public boolean isHiddenTerm() {
        return this.hiddenTerm;
    }
    
    public void setHiddenTerm(boolean hiddenTerm) {
        this.hiddenTerm = hiddenTerm;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="lcTerm")
    public Set<LcTermMapping> getLcTermMappings() {
        return this.lcTermMappings;
    }
    
    public void setLcTermMappings(Set<LcTermMapping> lcTermMappings) {
        this.lcTermMappings = lcTermMappings;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="lcTerm")
    public Set<LearningContextProxy> getLearningContextProxies() {
        return this.learningContextProxies;
    }
    
    public void setLearningContextProxies(Set<LearningContextProxy> learningContextProxies) {
        this.learningContextProxies = learningContextProxies;
    }




}


