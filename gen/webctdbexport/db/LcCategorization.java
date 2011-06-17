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
 * LcCategorization generated by hbm2java
 */
@Entity
@Table(name="LC_CATEGORIZATION"
)
public class LcCategorization  implements java.io.Serializable {


     private BigDecimal id;
     private LcCategory lcCategory;
     private LearningContext learningContext;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;

    public LcCategorization() {
    }

    public LcCategorization(BigDecimal id, LcCategory lcCategory, LearningContext learningContext, BigDecimal createTs, BigDecimal lastmodifyTs) {
       this.id = id;
       this.lcCategory = lcCategory;
       this.learningContext = learningContext;
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
    @JoinColumn(name="LC_CATEGORY_ID", nullable=false)
    public LcCategory getLcCategory() {
        return this.lcCategory;
    }
    
    public void setLcCategory(LcCategory lcCategory) {
        this.lcCategory = lcCategory;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="LEARNING_CONTEXT_ID", nullable=false)
    public LearningContext getLearningContext() {
        return this.learningContext;
    }
    
    public void setLearningContext(LearningContext learningContext) {
        this.learningContext = learningContext;
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


