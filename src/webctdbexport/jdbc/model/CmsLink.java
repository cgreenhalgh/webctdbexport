package webctdbexport.jdbc.model;

import java.math.BigDecimal;

public class CmsLink {
	private BigDecimal id;
	private BigDecimal linkTypeId;
	private BigDecimal leftobjectId;
	private BigDecimal rightobjectId;
	private String name;
	// from CoOrganizerlink
	private CoOrganizerlink coOrganizerlink;
	public CmsLink() {}
	public CmsLink(BigDecimal id, BigDecimal linkTypeId,
			BigDecimal leftobjectId, BigDecimal rightobjectId, String name) {
		super();
		this.id = id;
		this.linkTypeId = linkTypeId;
		this.leftobjectId = leftobjectId;
		this.rightobjectId = rightobjectId;
		this.name = name;
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
	 * @return the linkTypeId
	 */
	public BigDecimal getLinkTypeId() {
		return linkTypeId;
	}
	/**
	 * @param linkTypeId the linkTypeId to set
	 */
	public void setLinkTypeId(BigDecimal linkTypeId) {
		this.linkTypeId = linkTypeId;
	}
	/**
	 * @return the leftobjectId
	 */
	public BigDecimal getLeftobjectId() {
		return leftobjectId;
	}
	/**
	 * @param leftobjectId the leftobjectId to set
	 */
	public void setLeftobjectId(BigDecimal leftobjectId) {
		this.leftobjectId = leftobjectId;
	}
	/**
	 * @return the rightobjectId
	 */
	public BigDecimal getRightobjectId() {
		return rightobjectId;
	}
	/**
	 * @param rightobjectId the rightobjectId to set
	 */
	public void setRightobjectId(BigDecimal rightobjectId) {
		this.rightobjectId = rightobjectId;
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
	 * @return the coOrganizerlink
	 */
	public CoOrganizerlink getCoOrganizerlink() {
		return coOrganizerlink;
	}
	/**
	 * @param coOrganizerlink the coOrganizerlink to set
	 */
	public void setCoOrganizerlink(CoOrganizerlink coOrganizerlink) {
		this.coOrganizerlink = coOrganizerlink;
	}
	
}
