package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TrkSync generated by hbm2java
 */
@Entity
@Table(name="TRK_SYNC"
)
public class TrkSync  implements java.io.Serializable {


     private String dummyfield;

    public TrkSync() {
    }

    public TrkSync(String dummyfield) {
       this.dummyfield = dummyfield;
    }
   
     @Id 

    
    @Column(name="DUMMYFIELD", nullable=false, length=100)
    public String getDummyfield() {
        return this.dummyfield;
    }
    
    public void setDummyfield(String dummyfield) {
        this.dummyfield = dummyfield;
    }




}


