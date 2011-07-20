/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class AccessControlPermissionSet {
	private BigDecimal id;
	private String name;
	private boolean aclRead;
	public AccessControlPermissionSet(BigDecimal id, String name,
			boolean aclRead) {
		super();
		this.id = id;
		this.name = name;
		this.aclRead = aclRead;
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
	 * @return the readFlag
	 */
	public boolean isAclRead() {
		return aclRead;
	}
	/**
	 * @param readFlag the readFlag to set
	 */
	public void setAclRead(boolean aclRead) {
		this.aclRead = aclRead;
	}
	
}
