/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class LearningContext {
	private BigDecimal id;
	private String name;
	private String typeCode;
	private BigDecimal parentId;
	/** cons */
	public LearningContext() {		
	}
	public LearningContext(BigDecimal id, String name, String typeCode, BigDecimal parentId) {
		super();
		this.id = id;
		this.name = name;
		this.typeCode = typeCode;
		this.parentId = parentId;
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
	 * @return the typeCode
	 */
	public String getTypeCode() {
		return typeCode;
	}
	/**
	 * @param typeCode the typeCode to set
	 */
	public void setTypeCode(String typeCode) {
		this.typeCode = typeCode;
	}
	/**
	 * @return the parentId
	 */
	public BigDecimal getParentId() {
		return parentId;
	}
	/**
	 * @param parentId the parentId to set
	 */
	public void setParentId(BigDecimal parentId) {
		this.parentId = parentId;
	}
	
}
