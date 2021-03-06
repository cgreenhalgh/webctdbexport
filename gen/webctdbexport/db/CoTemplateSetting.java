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
 * CoTemplateSetting generated by hbm2java
 */
@Entity
@Table(name="CO_TEMPLATE_SETTING"
)
public class CoTemplateSetting  implements java.io.Serializable {


     private BigDecimal id;
     private CoTemplate coTemplate;
     private String propertyKey;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private String value;
     private String toolName;

    public CoTemplateSetting() {
    }

	
    public CoTemplateSetting(BigDecimal id, CoTemplate coTemplate, String propertyKey, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.coTemplate = coTemplate;
        this.propertyKey = propertyKey;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public CoTemplateSetting(BigDecimal id, CoTemplate coTemplate, String propertyKey, BigDecimal createTs, BigDecimal lastmodifyTs, String value, String toolName) {
       this.id = id;
       this.coTemplate = coTemplate;
       this.propertyKey = propertyKey;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.value = value;
       this.toolName = toolName;
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
    @JoinColumn(name="TEMPLATE_ID", nullable=false)
    public CoTemplate getCoTemplate() {
        return this.coTemplate;
    }
    
    public void setCoTemplate(CoTemplate coTemplate) {
        this.coTemplate = coTemplate;
    }

    
    @Column(name="PROPERTY_KEY", nullable=false, length=200)
    public String getPropertyKey() {
        return this.propertyKey;
    }
    
    public void setPropertyKey(String propertyKey) {
        this.propertyKey = propertyKey;
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

    
    @Column(name="VALUE", length=400)
    public String getValue() {
        return this.value;
    }
    
    public void setValue(String value) {
        this.value = value;
    }

    
    @Column(name="TOOL_NAME", length=256)
    public String getToolName() {
        return this.toolName;
    }
    
    public void setToolName(String toolName) {
        this.toolName = toolName;
    }




}


