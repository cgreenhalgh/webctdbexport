/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class CmsFileContent {
	private BigDecimal id;
	private long lastModifyTs;
	private BigDecimal mimetypeId;
	private String characterSet;
	public CmsFileContent() {}
	public CmsFileContent(BigDecimal id, long lastModifyTs,
			BigDecimal mimetypeId, String characterSet) {
		super();
		this.id = id;
		this.lastModifyTs = lastModifyTs;
		this.mimetypeId = mimetypeId;
		this.characterSet = characterSet;
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
	 * @return the lastModifyTs
	 */
	public long getLastModifyTs() {
		return lastModifyTs;
	}
	/**
	 * @param lastModifyTs the lastModifyTs to set
	 */
	public void setLastModifyTs(long lastModifyTs) {
		this.lastModifyTs = lastModifyTs;
	}
	/**
	 * @return the mimetypeId
	 */
	public BigDecimal getMimetypeId() {
		return mimetypeId;
	}
	/**
	 * @param mimetypeId the mimetypeId to set
	 */
	public void setMimetypeId(BigDecimal mimetypeId) {
		this.mimetypeId = mimetypeId;
	}
	/**
	 * @return the characterSet
	 */
	public String getCharacterSet() {
		return characterSet;
	}
	/**
	 * @param characterSet the characterSet to set
	 */
	public void setCharacterSet(String characterSet) {
		this.characterSet = characterSet;
	}
	
}
