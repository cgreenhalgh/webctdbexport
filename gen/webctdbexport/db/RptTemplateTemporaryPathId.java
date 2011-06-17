package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RptTemplateTemporaryPathId generated by hbm2java
 */
@Embeddable
public class RptTemplateTemporaryPathId  implements java.io.Serializable {


     private BigDecimal templateId;
     private String path;
     private BigDecimal learningContextId;

    public RptTemplateTemporaryPathId() {
    }

    public RptTemplateTemporaryPathId(BigDecimal templateId, String path, BigDecimal learningContextId) {
       this.templateId = templateId;
       this.path = path;
       this.learningContextId = learningContextId;
    }
   


    @Column(name="TEMPLATE_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getTemplateId() {
        return this.templateId;
    }
    
    public void setTemplateId(BigDecimal templateId) {
        this.templateId = templateId;
    }


    @Column(name="PATH", nullable=false, length=4000)
    public String getPath() {
        return this.path;
    }
    
    public void setPath(String path) {
        this.path = path;
    }


    @Column(name="LEARNING_CONTEXT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getLearningContextId() {
        return this.learningContextId;
    }
    
    public void setLearningContextId(BigDecimal learningContextId) {
        this.learningContextId = learningContextId;
    }




}


