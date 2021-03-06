package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * AssmtScore generated by hbm2java
 */
@Entity
@Table(name="ASSMT_SCORE"
)
public class AssmtScore  implements java.io.Serializable {


     private AssmtScoreId id;

    public AssmtScore() {
    }

    public AssmtScore(AssmtScoreId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="deliveryContextId", column=@Column(name="DELIVERY_CONTEXT_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="assmtId", column=@Column(name="ASSMT_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="assmtSubId", column=@Column(name="ASSMT_SUB_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="memberId", column=@Column(name="MEMBER_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="assmtScore", column=@Column(name="ASSMT_SCORE", nullable=false, precision=22, scale=0) ), 
        @AttributeOverride(name="attempts", column=@Column(name="ATTEMPTS", nullable=false, precision=22, scale=0) ) } )
    public AssmtScoreId getId() {
        return this.id;
    }
    
    public void setId(AssmtScoreId id) {
        this.id = id;
    }




}


