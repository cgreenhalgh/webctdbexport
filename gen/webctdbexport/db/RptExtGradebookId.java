package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * RptExtGradebookId generated by hbm2java
 */
@Embeddable
public class RptExtGradebookId  implements java.io.Serializable {


     private String learningContextName;
     private BigDecimal learningContextId;
     private String userLoginName;
     private BigDecimal personId;
     private String givenName;
     private String familyName;
     private String columnName;
     private String columnType;
     private String finalValue;
     private String override;
     private String originalValue;
     private String sourceLoType;
     private String sourceLoName;
     private BigDecimal sourceLoId;
     private BigDecimal maxPoints;

    public RptExtGradebookId() {
    }

    public RptExtGradebookId(String learningContextName, BigDecimal learningContextId, String userLoginName, BigDecimal personId, String givenName, String familyName, String columnName, String columnType, String finalValue, String override, String originalValue, String sourceLoType, String sourceLoName, BigDecimal sourceLoId, BigDecimal maxPoints) {
       this.learningContextName = learningContextName;
       this.learningContextId = learningContextId;
       this.userLoginName = userLoginName;
       this.personId = personId;
       this.givenName = givenName;
       this.familyName = familyName;
       this.columnName = columnName;
       this.columnType = columnType;
       this.finalValue = finalValue;
       this.override = override;
       this.originalValue = originalValue;
       this.sourceLoType = sourceLoType;
       this.sourceLoName = sourceLoName;
       this.sourceLoId = sourceLoId;
       this.maxPoints = maxPoints;
    }
   


    @Column(name="LEARNING_CONTEXT_NAME", nullable=false, length=1000)
    public String getLearningContextName() {
        return this.learningContextName;
    }
    
    public void setLearningContextName(String learningContextName) {
        this.learningContextName = learningContextName;
    }


    @Column(name="LEARNING_CONTEXT_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getLearningContextId() {
        return this.learningContextId;
    }
    
    public void setLearningContextId(BigDecimal learningContextId) {
        this.learningContextId = learningContextId;
    }


    @Column(name="USER_LOGIN_NAME", nullable=false, length=768)
    public String getUserLoginName() {
        return this.userLoginName;
    }
    
    public void setUserLoginName(String userLoginName) {
        this.userLoginName = userLoginName;
    }


    @Column(name="PERSON_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getPersonId() {
        return this.personId;
    }
    
    public void setPersonId(BigDecimal personId) {
        this.personId = personId;
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


    @Column(name="COLUMN_TYPE", nullable=false, length=40)
    public String getColumnType() {
        return this.columnType;
    }
    
    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }


    @Column(name="FINAL_VALUE", nullable=false, length=4000)
    public String getFinalValue() {
        return this.finalValue;
    }
    
    public void setFinalValue(String finalValue) {
        this.finalValue = finalValue;
    }


    @Column(name="OVERRIDE", nullable=false, length=4000)
    public String getOverride() {
        return this.override;
    }
    
    public void setOverride(String override) {
        this.override = override;
    }


    @Column(name="ORIGINAL_VALUE", nullable=false, length=4000)
    public String getOriginalValue() {
        return this.originalValue;
    }
    
    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }


    @Column(name="SOURCE_LO_TYPE", nullable=false, length=100)
    public String getSourceLoType() {
        return this.sourceLoType;
    }
    
    public void setSourceLoType(String sourceLoType) {
        this.sourceLoType = sourceLoType;
    }


    @Column(name="SOURCE_LO_NAME", nullable=false, length=1000)
    public String getSourceLoName() {
        return this.sourceLoName;
    }
    
    public void setSourceLoName(String sourceLoName) {
        this.sourceLoName = sourceLoName;
    }


    @Column(name="SOURCE_LO_ID", nullable=false, precision=20, scale=0)
    public BigDecimal getSourceLoId() {
        return this.sourceLoId;
    }
    
    public void setSourceLoId(BigDecimal sourceLoId) {
        this.sourceLoId = sourceLoId;
    }


    @Column(name="MAX_POINTS", nullable=false, precision=22, scale=0)
    public BigDecimal getMaxPoints() {
        return this.maxPoints;
    }
    
    public void setMaxPoints(BigDecimal maxPoints) {
        this.maxPoints = maxPoints;
    }




}


