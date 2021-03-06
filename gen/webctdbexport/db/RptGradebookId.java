package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RptGradebookId generated by hbm2java
 */
@Embeddable
public class RptGradebookId  implements java.io.Serializable {


     private String sectionName;
     private String userId;
     private BigDecimal learningContextId;
     private String givenName;
     private String familyName;
     private String columnName;
     private String value;

    public RptGradebookId() {
    }

    public RptGradebookId(String sectionName, String userId, BigDecimal learningContextId, String givenName, String familyName, String columnName, String value) {
       this.sectionName = sectionName;
       this.userId = userId;
       this.learningContextId = learningContextId;
       this.givenName = givenName;
       this.familyName = familyName;
       this.columnName = columnName;
       this.value = value;
    }
   


    @Column(name="SECTION_NAME", nullable=false, length=1000)
    public String getSectionName() {
        return this.sectionName;
    }
    
    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }


    @Column(name="USER_ID", nullable=false, length=768)
    public String getUserId() {
        return this.userId;
    }
    
    public void setUserId(String userId) {
        this.userId = userId;
    }


    @Column(name="LEARNING_CONTEXT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getLearningContextId() {
        return this.learningContextId;
    }
    
    public void setLearningContextId(BigDecimal learningContextId) {
        this.learningContextId = learningContextId;
    }


    @Column(name="GIVEN_NAME", nullable=false, length=768)
    public String getGivenName() {
        return this.givenName;
    }
    
    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }


    @Column(name="FAMILY_NAME", nullable=false, length=768)
    public String getFamilyName() {
        return this.familyName;
    }
    
    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }


    @Column(name="COLUMN_NAME", nullable=false, length=1000)
    public String getColumnName() {
        return this.columnName;
    }
    
    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }


    @Column(name="VALUE", nullable=false, length=4000)
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }




}


