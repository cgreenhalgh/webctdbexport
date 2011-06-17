package webctdbexport.db;
// Generated 17-Jun-2011 11:38:57 by Hibernate Tools 3.4.0.CR1


import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * SearchIndexRebuildLog generated by hbm2java
 */
@Entity
@Table(name="SEARCH_INDEX_REBUILD_LOG"
)
public class SearchIndexRebuildLog  implements java.io.Serializable {


     private SearchIndexRebuildLogId id;

    public SearchIndexRebuildLog() {
    }

    public SearchIndexRebuildLog(SearchIndexRebuildLogId id) {
       this.id = id;
    }
   
     @EmbeddedId

    
    @AttributeOverrides( {
        @AttributeOverride(name="createts", column=@Column(name="CREATETS", nullable=false) ), 
        @AttributeOverride(name="logLevel", column=@Column(name="LOG_LEVEL", nullable=false, length=5) ), 
        @AttributeOverride(name="messages", column=@Column(name="MESSAGES", nullable=false, length=4000) ) } )
    public SearchIndexRebuildLogId getId() {
        return this.id;
    }
    
    public void setId(SearchIndexRebuildLogId id) {
        this.id = id;
    }




}


