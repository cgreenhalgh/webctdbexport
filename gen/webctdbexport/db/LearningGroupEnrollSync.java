package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LearningGroupEnrollSync generated by hbm2java
 */
@Entity
@Table(name="LEARNING_GROUP_ENROLL_SYNC"
)
public class LearningGroupEnrollSync  implements java.io.Serializable {


     private BigDecimal lcid;

    public LearningGroupEnrollSync() {
    }

    public LearningGroupEnrollSync(BigDecimal lcid) {
       this.lcid = lcid;
    }
   
     @Id 

    
    @Column(name="LCID", nullable=false, precision=20, scale=0)
    public BigDecimal getLcid() {
        return this.lcid;
    }
    
    public void setLcid(BigDecimal lcid) {
        this.lcid = lcid;
    }




}


