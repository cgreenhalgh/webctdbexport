package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * RptLearningContextSizeT generated by hbm2java
 */
@Entity
@Table(name="RPT_LEARNING_CONTEXT_SIZE_T"
)
public class RptLearningContextSizeT  implements java.io.Serializable {


     private BigDecimal learningContextId;
     private BigDecimal totalSize;
     private BigDecimal templateSize;
     private BigDecimal additionalFileSize;

    public RptLearningContextSizeT() {
    }

	
    public RptLearningContextSizeT(BigDecimal learningContextId) {
        this.learningContextId = learningContextId;
    }
    public RptLearningContextSizeT(BigDecimal learningContextId, BigDecimal totalSize, BigDecimal templateSize, BigDecimal additionalFileSize) {
       this.learningContextId = learningContextId;
       this.totalSize = totalSize;
       this.templateSize = templateSize;
       this.additionalFileSize = additionalFileSize;
    }
   
     @Id 

    
    @Column(name="LEARNING_CONTEXT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getLearningContextId() {
        return this.learningContextId;
    }
    
    public void setLearningContextId(BigDecimal learningContextId) {
        this.learningContextId = learningContextId;
    }

    
    @Column(name="TOTAL_SIZE", precision=20, scale=0)
    public BigDecimal getTotalSize() {
        return this.totalSize;
    }
    
    public void setTotalSize(BigDecimal totalSize) {
        this.totalSize = totalSize;
    }

    
    @Column(name="TEMPLATE_SIZE", precision=20, scale=0)
    public BigDecimal getTemplateSize() {
        return this.templateSize;
    }
    
    public void setTemplateSize(BigDecimal templateSize) {
        this.templateSize = templateSize;
    }

    
    @Column(name="ADDITIONAL_FILE_SIZE", precision=20, scale=0)
    public BigDecimal getAdditionalFileSize() {
        return this.additionalFileSize;
    }
    
    public void setAdditionalFileSize(BigDecimal additionalFileSize) {
        this.additionalFileSize = additionalFileSize;
    }




}


