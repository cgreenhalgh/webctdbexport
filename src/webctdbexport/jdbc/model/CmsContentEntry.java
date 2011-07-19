/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class CmsContentEntry {
//	private static final String CE_FIELDS = "ce.ID, ce.NAME, ce.CE_TYPE_NAME, ce.CE_SUBTYPE_NAME, ce.ACL_ID, ce.LASTMODIFY_TS, ce.FILESIZE, ce.FILE_CONTENT_ID";
	private BigDecimal id;
	private String name;
	private String ceTypeName;
	private String ceSubtypeName;
	private BigDecimal aclId;
	private long lastmodifyTs;
	private long filesize;
	private BigDecimal fileContentId;
	public CmsContentEntry() {		
	}
	public CmsContentEntry(BigDecimal id, String name, String ceTypeName,
			String ceSubtypeName, BigDecimal aclId, long lastmodifyTs,
			long filesize, BigDecimal fileContentId) {
		super();
		this.id = id;
		this.name = name;
		this.ceTypeName = ceTypeName;
		this.ceSubtypeName = ceSubtypeName;
		this.aclId = aclId;
		this.lastmodifyTs = lastmodifyTs;
		this.filesize = filesize;
		this.fileContentId = fileContentId;
	}
	/**
	 * @return the id
	 */
	public BigDecimal getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(BigDecimal id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the ceTypeName
	 */
	public String getCeTypeName() {
		return ceTypeName;
	}
	/**
	 * @param ceTypeName the ceTypeName to set
	 */
	public void setCeTypeName(String ceTypeName) {
		this.ceTypeName = ceTypeName;
	}
	/**
	 * @return the ceSubtypeName
	 */
	public String getCeSubtypeName() {
		return ceSubtypeName;
	}
	/**
	 * @param ceSubtypeName the ceSubtypeName to set
	 */
	public void setCeSubtypeName(String ceSubtypeName) {
		this.ceSubtypeName = ceSubtypeName;
	}
	/**
	 * @return the aclId
	 */
	public BigDecimal getAclId() {
		return aclId;
	}
	/**
	 * @param aclId the aclId to set
	 */
	public void setAclId(BigDecimal aclId) {
		this.aclId = aclId;
	}
	/**
	 * @return the lastmodifyTs
	 */
	public long getLastmodifyTs() {
		return lastmodifyTs;
	}
	/**
	 * @param lastmodifyTs the lastmodifyTs to set
	 */
	public void setLastmodifyTs(long lastmodifyTs) {
		this.lastmodifyTs = lastmodifyTs;
	}
	/**
	 * @return the filesize
	 */
	public long getFilesize() {
		return filesize;
	}
	/**
	 * @param filesize the filesize to set
	 */
	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}
	/**
	 * @return the fileContentId
	 */
	public BigDecimal getFileContentId() {
		return fileContentId;
	}
	/**
	 * @param fileContentId the fileContentId to set
	 */
	public void setFileContentId(BigDecimal fileContentId) {
		this.fileContentId = fileContentId;
	}
}
