package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * LearningContextProxy generated by hbm2java
 */
@Entity
@Table(name="LEARNING_CONTEXT_PROXY"
)
public class LearningContextProxy  implements java.io.Serializable {


     private BigDecimal id;
     private LearningContext learningContext;
     private LcTerm lcTerm;
     private String contentSourcedidSource;
     private String contentSourcedidId;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public LearningContextProxy() {
    }

	
    public LearningContextProxy(LearningContext learningContext, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.learningContext = learningContext;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public LearningContextProxy(LearningContext learningContext, LcTerm lcTerm, String contentSourcedidSource, String contentSourcedidId, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.learningContext = learningContext;
       this.lcTerm = lcTerm;
       this.contentSourcedidSource = contentSourcedidSource;
       this.contentSourcedidId = contentSourcedidId;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
    }
   
     @GenericGenerator(name="generator", strategy="foreign", parameters=@Parameter(name="property", value="learningContext"))@Id @GeneratedValue(generator="generator")

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

@OneToOne(fetch=FetchType.LAZY)
    public LearningContext getLearningContext() {
        return this.learningContext;
    }
    
    public void setLearningContext(LearningContext learningContext) {
        this.learningContext = learningContext;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LC_TERM_ID")
    public LcTerm getLcTerm() {
        return this.lcTerm;
    }
    
    public void setLcTerm(LcTerm lcTerm) {
        this.lcTerm = lcTerm;
    }

    
    @Column(name="CONTENT_SOURCEDID_SOURCE", length=510)
    public String getContentSourcedidSource() {
        return this.contentSourcedidSource;
    }
    
    public void setContentSourcedidSource(String contentSourcedidSource) {
        this.contentSourcedidSource = contentSourcedidSource;
    }

    
    @Column(name="CONTENT_SOURCEDID_ID", length=768)
    public String getContentSourcedidId() {
        return this.contentSourcedidId;
    }
    
    public void setContentSourcedidId(String contentSourcedidId) {
        this.contentSourcedidId = contentSourcedidId;
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


