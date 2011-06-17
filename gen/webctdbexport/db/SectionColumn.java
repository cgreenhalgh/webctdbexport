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
 * SectionColumn generated by hbm2java
 */
@Entity
@Table(name="SECTION_COLUMN"
)
public class SectionColumn  implements java.io.Serializable {


     private BigDecimal id;
     private SectionBook sectionBook;
     private CmsContentEntry cmsContentEntry;
     private String cobaltType;
     private String label;
     private boolean mandatoryFl;
     private boolean editableFl;
     private boolean releasedFl;
     private boolean overridableFl;
     private boolean gradeFl;
     private boolean inheritedFl;
     private boolean releaseStatisticsFl;
     private BigDecimal createTs;
     private BigDecimal lastmodifyTs;
     private BigDecimal learningActivityId;
     private Boolean alignment;
     private Boolean decimalScale;
     private String selectionList;
     private String letterGradeScheme;
     private String gradeFormula;
     private BigDecimal maxValue;
     private BigDecimal schemeUpdateDate;
     private BigDecimal releaseDate;
     private Set<ScormItem> scormItems = new HashSet<ScormItem>(0);
     private Set<MemberAttrValue> memberAttrValues = new HashSet<MemberAttrValue>(0);
     private Set<RubricLink> rubricLinks = new HashSet<RubricLink>(0);
     private Set<ViewColumn> viewColumns = new HashSet<ViewColumn>(0);

    public SectionColumn() {
    }

	
    public SectionColumn(BigDecimal id, SectionBook sectionBook, String cobaltType, String label, boolean mandatoryFl, boolean editableFl, boolean releasedFl, boolean overridableFl, boolean gradeFl, boolean inheritedFl, boolean releaseStatisticsFl, BigDecimal createTs, BigDecimal lastmodifyTs) {
        this.id = id;
        this.sectionBook = sectionBook;
        this.cobaltType = cobaltType;
        this.label = label;
        this.mandatoryFl = mandatoryFl;
        this.editableFl = editableFl;
        this.releasedFl = releasedFl;
        this.overridableFl = overridableFl;
        this.gradeFl = gradeFl;
        this.inheritedFl = inheritedFl;
        this.releaseStatisticsFl = releaseStatisticsFl;
        this.createTs = createTs;
        this.lastmodifyTs = lastmodifyTs;
    }
    public SectionColumn(BigDecimal id, SectionBook sectionBook, CmsContentEntry cmsContentEntry, String cobaltType, String label, boolean mandatoryFl, boolean editableFl, boolean releasedFl, boolean overridableFl, boolean gradeFl, boolean inheritedFl, boolean releaseStatisticsFl, BigDecimal createTs, BigDecimal lastmodifyTs, BigDecimal learningActivityId, Boolean alignment, Boolean decimalScale, String selectionList, String letterGradeScheme, String gradeFormula, BigDecimal maxValue, BigDecimal schemeUpdateDate, BigDecimal releaseDate, Set<ScormItem> scormItems, Set<MemberAttrValue> memberAttrValues, Set<RubricLink> rubricLinks, Set<ViewColumn> viewColumns) {
       this.id = id;
       this.sectionBook = sectionBook;
       this.cmsContentEntry = cmsContentEntry;
       this.cobaltType = cobaltType;
       this.label = label;
       this.mandatoryFl = mandatoryFl;
       this.editableFl = editableFl;
       this.releasedFl = releasedFl;
       this.overridableFl = overridableFl;
       this.gradeFl = gradeFl;
       this.inheritedFl = inheritedFl;
       this.releaseStatisticsFl = releaseStatisticsFl;
       this.createTs = createTs;
       this.lastmodifyTs = lastmodifyTs;
       this.learningActivityId = learningActivityId;
       this.alignment = alignment;
       this.decimalScale = decimalScale;
       this.selectionList = selectionList;
       this.letterGradeScheme = letterGradeScheme;
       this.gradeFormula = gradeFormula;
       this.maxValue = maxValue;
       this.schemeUpdateDate = schemeUpdateDate;
       this.releaseDate = releaseDate;
       this.scormItems = scormItems;
       this.memberAttrValues = memberAttrValues;
       this.rubricLinks = rubricLinks;
       this.viewColumns = viewColumns;
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
    @JoinColumn(name="SECTION_BOOK_ID", nullable=false)
    public SectionBook getSectionBook() {
        return this.sectionBook;
    }
    
    public void setSectionBook(SectionBook sectionBook) {
        this.sectionBook = sectionBook;
    }

@ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="CONTENT_ENTRY_ID")
    public CmsContentEntry getCmsContentEntry() {
        return this.cmsContentEntry;
    }
    
    public void setCmsContentEntry(CmsContentEntry cmsContentEntry) {
        this.cmsContentEntry = cmsContentEntry;
    }

    
    @Column(name="COBALT_TYPE", nullable=false, length=40)
    public String getCobaltType() {
        return this.cobaltType;
    }
    
    public void setCobaltType(String cobaltType) {
        this.cobaltType = cobaltType;
    }

    
    @Column(name="LABEL", nullable=false, length=1000)
    public String getLabel() {
        return this.label;
    }
    
    public void setLabel(String label) {
        this.label = label;
    }

    
    @Column(name="MANDATORY_FL", nullable=false, precision=1, scale=0)
    public boolean isMandatoryFl() {
        return this.mandatoryFl;
    }
    
    public void setMandatoryFl(boolean mandatoryFl) {
        this.mandatoryFl = mandatoryFl;
    }

    
    @Column(name="EDITABLE_FL", nullable=false, precision=1, scale=0)
    public boolean isEditableFl() {
        return this.editableFl;
    }
    
    public void setEditableFl(boolean editableFl) {
        this.editableFl = editableFl;
    }

    
    @Column(name="RELEASED_FL", nullable=false, precision=1, scale=0)
    public boolean isReleasedFl() {
        return this.releasedFl;
    }
    
    public void setReleasedFl(boolean releasedFl) {
        this.releasedFl = releasedFl;
    }

    
    @Column(name="OVERRIDABLE_FL", nullable=false, precision=1, scale=0)
    public boolean isOverridableFl() {
        return this.overridableFl;
    }
    
    public void setOverridableFl(boolean overridableFl) {
        this.overridableFl = overridableFl;
    }

    
    @Column(name="GRADE_FL", nullable=false, precision=1, scale=0)
    public boolean isGradeFl() {
        return this.gradeFl;
    }
    
    public void setGradeFl(boolean gradeFl) {
        this.gradeFl = gradeFl;
    }

    
    @Column(name="INHERITED_FL", nullable=false, precision=1, scale=0)
    public boolean isInheritedFl() {
        return this.inheritedFl;
    }
    
    public void setInheritedFl(boolean inheritedFl) {
        this.inheritedFl = inheritedFl;
    }

    
    @Column(name="RELEASE_STATISTICS_FL", nullable=false, precision=1, scale=0)
    public boolean isReleaseStatisticsFl() {
        return this.releaseStatisticsFl;
    }
    
    public void setReleaseStatisticsFl(boolean releaseStatisticsFl) {
        this.releaseStatisticsFl = releaseStatisticsFl;
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

    
    @Column(name="LEARNING_ACTIVITY_ID", precision=20, scale=0)
    public BigDecimal getLearningActivityId() {
        return this.learningActivityId;
    }
    
    public void setLearningActivityId(BigDecimal learningActivityId) {
        this.learningActivityId = learningActivityId;
    }

    
    @Column(name="ALIGNMENT", precision=1, scale=0)
    public Boolean getAlignment() {
        return this.alignment;
    }
    
    public void setAlignment(Boolean alignment) {
        this.alignment = alignment;
    }

    
    @Column(name="DECIMAL_SCALE", precision=1, scale=0)
    public Boolean getDecimalScale() {
        return this.decimalScale;
    }
    
    public void setDecimalScale(Boolean decimalScale) {
        this.decimalScale = decimalScale;
    }

    
    @Column(name="SELECTION_LIST", length=3000)
    public String getSelectionList() {
        return this.selectionList;
    }
    
    public void setSelectionList(String selectionList) {
        this.selectionList = selectionList;
    }

    
    @Column(name="LETTER_GRADE_SCHEME", length=1000)
    public String getLetterGradeScheme() {
        return this.letterGradeScheme;
    }
    
    public void setLetterGradeScheme(String letterGradeScheme) {
        this.letterGradeScheme = letterGradeScheme;
    }

    
    @Column(name="GRADE_FORMULA", length=4000)
    public String getGradeFormula() {
        return this.gradeFormula;
    }
    
    public void setGradeFormula(String gradeFormula) {
        this.gradeFormula = gradeFormula;
    }

    
    @Column(name="MAX_VALUE", precision=7)
    public BigDecimal getMaxValue() {
        return this.maxValue;
    }
    
    public void setMaxValue(BigDecimal maxValue) {
        this.maxValue = maxValue;
    }

    
    @Column(name="SCHEME_UPDATE_DATE", precision=20, scale=0)
    public BigDecimal getSchemeUpdateDate() {
        return this.schemeUpdateDate;
    }
    
    public void setSchemeUpdateDate(BigDecimal schemeUpdateDate) {
        this.schemeUpdateDate = schemeUpdateDate;
    }

    
    @Column(name="RELEASE_DATE", precision=20, scale=0)
    public BigDecimal getReleaseDate() {
        return this.releaseDate;
    }
    
    public void setReleaseDate(BigDecimal releaseDate) {
        this.releaseDate = releaseDate;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="sectionColumn")
    public Set<ScormItem> getScormItems() {
        return this.scormItems;
    }
    
    public void setScormItems(Set<ScormItem> scormItems) {
        this.scormItems = scormItems;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="sectionColumn")
    public Set<MemberAttrValue> getMemberAttrValues() {
        return this.memberAttrValues;
    }
    
    public void setMemberAttrValues(Set<MemberAttrValue> memberAttrValues) {
        this.memberAttrValues = memberAttrValues;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="sectionColumn")
    public Set<RubricLink> getRubricLinks() {
        return this.rubricLinks;
    }
    
    public void setRubricLinks(Set<RubricLink> rubricLinks) {
        this.rubricLinks = rubricLinks;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="sectionColumn")
    public Set<ViewColumn> getViewColumns() {
        return this.viewColumns;
    }
    
    public void setViewColumns(Set<ViewColumn> viewColumns) {
        this.viewColumns = viewColumns;
    }




}


