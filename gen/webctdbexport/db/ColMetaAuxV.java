package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * ColMetaAuxV generated by hbm2java
 */
@Entity
@Table(name="COL_META_AUX_V"
)
public class ColMetaAuxV  implements java.io.Serializable {


     private ColMetaAuxVId id;

    public ColMetaAuxV() {
    }

    public ColMetaAuxV(ColMetaAuxVId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="id", column=@Column(name="ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="colMetaId", column=@Column(name="COL_META_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="colName", column=@Column(name="COL_NAME", nullable=false, length=256) ), 
        @AttributeOverride(name="colDatatype", column=@Column(name="COL_DATATYPE", nullable=false, precision=4, scale=0) ), 
        @AttributeOverride(name="colMetaGroupId", column=@Column(name="COL_META_GROUP_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="attrId", column=@Column(name="ATTR_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="attrName", column=@Column(name="ATTR_NAME", nullable=false, length=100) ), 
        @AttributeOverride(name="value", column=@Column(name="VALUE", nullable=false, length=256) ), 
        @AttributeOverride(name="valueLcId", column=@Column(name="VALUE_LC_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="ownerLcId", column=@Column(name="OWNER_LC_ID", nullable=false, precision=20, scale=0) ), 
        @AttributeOverride(name="visibility", column=@Column(name="VISIBILITY", nullable=false, precision=22, scale=0) ), 
        @AttributeOverride(name="typeCode", column=@Column(name="TYPE_CODE", nullable=false, length=128) ), 
        @AttributeOverride(name="currentLcId", column=@Column(name="CURRENT_LC_ID", nullable=false, precision=20, scale=0) ) } )
    public ColMetaAuxVId getId() {
        return this.id;
    }
    
    public void setId(ColMetaAuxVId id) {
        this.id = id;
    }




}


