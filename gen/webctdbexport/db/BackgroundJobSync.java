package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * BackgroundJobSync generated by hbm2java
 */
@Entity
@Table(name="BACKGROUND_JOB_SYNC"
)
public class BackgroundJobSync  implements java.io.Serializable {


     private String dummyfield;

    public BackgroundJobSync() {
    }

    public BackgroundJobSync(String dummyfield) {
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


