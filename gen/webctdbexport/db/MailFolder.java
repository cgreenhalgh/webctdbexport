package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
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
 * MailFolder generated by hbm2java
 */
@Entity
@Table(name="MAIL_FOLDER"
)
public class MailFolder  implements java.io.Serializable {


     private BigDecimal id;
     private MailBox mailBox;
     private byte type;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private String name;
     private Set<MailReceipt> mailReceipts = new HashSet<MailReceipt>(0);

    public MailFolder() {
    }

	
    public MailFolder(BigDecimal id, MailBox mailBox, byte type, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.mailBox = mailBox;
        this.type = type;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public MailFolder(BigDecimal id, MailBox mailBox, byte type, BigDecimal createTs, BigDecimal lastmodifyTs, String name, Set<MailReceipt> mailReceipts) {
       this.id = id;
       this.mailBox = mailBox;
       this.type = type;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.name = name;
       this.mailReceipts = mailReceipts;
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
    @JoinColumn(name="MAIL_BOX_ID", nullable=false)
    public MailBox getMailBox() {
        return this.mailBox;
    }
    
    public void setMailBox(MailBox mailBox) {
        this.mailBox = mailBox;
    }

    
    @Column(name="TYPE", nullable=false, precision=2, scale=0)
    public byte getType() {
        return this.type;
    }
    
    public void setType(byte type) {
        this.type = type;
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

    
    @Column(name="NAME", length=256)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="mailFolder")
    public Set<MailReceipt> getMailReceipts() {
        return this.mailReceipts;
    }
    
    public void setMailReceipts(Set<MailReceipt> mailReceipts) {
        this.mailReceipts = mailReceipts;
    }




}


