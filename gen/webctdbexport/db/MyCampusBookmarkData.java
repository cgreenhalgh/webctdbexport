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
 * MyCampusBookmarkData generated by hbm2java
 */
@Entity
@Table(name="MY_CAMPUS_BOOKMARK_DATA"
)
public class MyCampusBookmarkData  implements java.io.Serializable {


     private BigDecimal id;
     private LearningContext learningContext;
     private String description;
     private String url;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private Set<MyBookmark> myBookmarks = new HashSet<MyBookmark>(0);

    public MyCampusBookmarkData() {
    }

	
    public MyCampusBookmarkData(BigDecimal id, LearningContext learningContext, String description, String url, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.learningContext = learningContext;
        this.description = description;
        this.url = url;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public MyCampusBookmarkData(BigDecimal id, LearningContext learningContext, String description, String url, BigDecimal createTs, BigDecimal lastmodifyTs, Set<MyBookmark> myBookmarks) {
       this.id = id;
       this.learningContext = learningContext;
       this.description = description;
       this.url = url;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.myBookmarks = myBookmarks;
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
    @JoinColumn(name="INSTITUTION_ID", nullable=false)
    public LearningContext getLearningContext() {
        return this.learningContext;
    }
    
    public void setLearningContext(LearningContext learningContext) {
        this.learningContext = learningContext;
    }

    
    @Column(name="DESCRIPTION", nullable=false, length=4000)
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    
    @Column(name="URL", nullable=false, length=1000)
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
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

@OneToMany(fetch=FetchType.LAZY, mappedBy="myCampusBookmarkData")
    public Set<MyBookmark> getMyBookmarks() {
        return this.myBookmarks;
    }
    
    public void setMyBookmarks(Set<MyBookmark> myBookmarks) {
        this.myBookmarks = myBookmarks;
    }




}


