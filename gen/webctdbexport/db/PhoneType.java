package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PhoneType generated by hbm2java
 */
@Entity
@Table(name="PHONE_TYPE"
)
public class PhoneType  implements java.io.Serializable {


     private BigDecimal id;
     private String phoneType;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private Set<Phone> phones = new HashSet<Phone>(0);

    public PhoneType() {
    }

	
    public PhoneType(BigDecimal id, String phoneType, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.phoneType = phoneType;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public PhoneType(BigDecimal id, String phoneType, BigDecimal createTs, BigDecimal lastmodifyTs, Set<Phone> phones) {
       this.id = id;
       this.phoneType = phoneType;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.phones = phones;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="PHONE_TYPE", nullable=false, length=90)
    public String getPhoneType() {
        return this.phoneType;
    }
    
    public void setPhoneType(String phoneType) {
        this.phoneType = phoneType;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="phoneType")
    public Set<Phone> getPhones() {
        return this.phones;
    }
    
    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }




}


