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
 * TrkPage generated by hbm2java
 */
@Entity
@Table(name="TRK_PAGE"
)
public class TrkPage  implements java.io.Serializable {


     private BigDecimal id;
     private String name;
     private Set<TrkUserAction> trkUserActions = new HashSet<TrkUserAction>(0);

    public TrkPage() {
    }

	
    public TrkPage(BigDecimal id, String name) {
        this.id = id;
        this.name = name;
    }
    public TrkPage(BigDecimal id, String name, Set<TrkUserAction> trkUserActions) {
       this.id = id;
       this.name = name;
       this.trkUserActions = trkUserActions;
    }
   
     @Id 

    
    @Column(name="ID", nullable=false, precision=20, scale=0)
    public BigDecimal getId() {
        return this.id;
    }
    
    public void setId(BigDecimal id) {
        this.id = id;
    }

    
    @Column(name="NAME", unique=true, nullable=false, length=4000)
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="trkPage")
    public Set<TrkUserAction> getTrkUserActions() {
        return this.trkUserActions;
    }
    
    public void setTrkUserActions(Set<TrkUserAction> trkUserActions) {
        this.trkUserActions = trkUserActions;
    }




}


