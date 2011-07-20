/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class AccessControlEntry {
	private BigDecimal id;
	private BigDecimal aclId;
	/** this is a DirectoryObject - not clear where to go from there!! */
	private BigDecimal granteeId;
	private BigDecimal permissionSetId;
	public AccessControlEntry(BigDecimal id, BigDecimal aclId,
			BigDecimal granteeId, BigDecimal permissionSetId) {
		super();
		this.id = id;
		this.aclId = aclId;
		this.granteeId = granteeId;
		this.permissionSetId = permissionSetId;
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
	 * @return the granteeId
	 */
	public BigDecimal getGranteeId() {
		return granteeId;
	}
	/**
	 * @param granteeId the granteeId to set
	 */
	public void setGranteeId(BigDecimal granteeId) {
		this.granteeId = granteeId;
	}
	/**
	 * @return the permissionSetId
	 */
	public BigDecimal getPermissionSetId() {
		return permissionSetId;
	}
	/**
	 * @param permissionSetId the permissionSetId to set
	 */
	public void setPermissionSetId(BigDecimal permissionSetId) {
		this.permissionSetId = permissionSetId;
	}
	
}
