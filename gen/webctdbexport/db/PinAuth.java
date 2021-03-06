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
 * PinAuth generated by hbm2java
 */
@Entity
@Table(name="PIN_AUTH"
)
public class PinAuth  implements java.io.Serializable {


     private BigDecimal id;
     private PublisherLicense publisherLicense;
     private Person person;
     private BigDecimal licenseTime;
     private BigDecimal authTime;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private BigDecimal gracePeriodExpireTs;

    public PinAuth() {
    }

	
    public PinAuth(BigDecimal id, PublisherLicense publisherLicense, Person person, BigDecimal licenseTime, BigDecimal authTime, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.publisherLicense = publisherLicense;
        this.person = person;
        this.licenseTime = licenseTime;
        this.authTime = authTime;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public PinAuth(BigDecimal id, PublisherLicense publisherLicense, Person person, BigDecimal licenseTime, BigDecimal authTime, BigDecimal createTs, BigDecimal lastmodifyTs, BigDecimal gracePeriodExpireTs) {
       this.id = id;
       this.publisherLicense = publisherLicense;
       this.person = person;
       this.licenseTime = licenseTime;
       this.authTime = authTime;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.gracePeriodExpireTs = gracePeriodExpireTs;
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
    @JoinColumn(name="PUBLISHER_LICENSE_ID", nullable=false)
    public PublisherLicense getPublisherLicense() {
        return this.publisherLicense;
    }
    
    public void setPublisherLicense(PublisherLicense publisherLicense) {
        this.publisherLicense = publisherLicense;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="PERSON_ID", nullable=false)
    public Person getPerson() {
        return this.person;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }

    
    @Column(name="LICENSE_TIME", nullable=false, precision=20, scale=0)
    public BigDecimal getLicenseTime() {
        return this.licenseTime;
    }
    
    public void setLicenseTime(BigDecimal licenseTime) {
        this.licenseTime = licenseTime;
    }

    
    @Column(name="AUTH_TIME", nullable=false, precision=20, scale=0)
    public BigDecimal getAuthTime() {
        return this.authTime;
    }
    
    public void setAuthTime(BigDecimal authTime) {
        this.authTime = authTime;
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

    
    @Column(name="GRACE_PERIOD_EXPIRE_TS", precision=20, scale=0)
    public BigDecimal getGracePeriodExpireTs() {
        return this.gracePeriodExpireTs;
    }
    
    public void setGracePeriodExpireTs(BigDecimal gracePeriodExpireTs) {
        this.gracePeriodExpireTs = gracePeriodExpireTs;
    }




}


