package webctdbexport.jdbc.model;

import java.math.BigDecimal;

public class CmsLink {
	private BigDecimal id;
	private BigDecimal linkTypeId;
	private BigDecimal leftobjectId;
	private BigDecimal rightobjectId;
	private String name;
	private double displayOrder;
	// from CoOrganizerlink
	private CoOrganizerlink coOrganizerlink;
	// from CoTocLink
	private CoTocLink coTocLink;
	public CmsLink() {}
	public CmsLink(BigDecimal id, BigDecimal linkTypeId,
			BigDecimal leftobjectId, BigDecimal rightobjectId, String name, double displayOrder) {
		super();
		this.id = id;
		this.linkTypeId = linkTypeId;
		this.leftobjectId = leftobjectId;
		this.rightobjectId = rightobjectId;
		this.name = name;
		this.displayOrder = displayOrder;
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
	 * @return the displayOrder
	 */
	public double getDisplayOrder() {
		return displayOrder;
	}
	/**
	 * @param displayOrder the displayOrder to set
	 */
	public void setDisplayOrder(double displayOrder) {
		this.displayOrder = displayOrder;
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
	/**
	 * @return the coTocLink
	 */
	public CoTocLink getCoTocLink() {
		return coTocLink;
	}
	/**
	 * @param coTocLink the coTocLink to set
	 */
	public void setCoTocLink(CoTocLink coTocLink) {
		this.coTocLink = coTocLink;
	}
	
}
