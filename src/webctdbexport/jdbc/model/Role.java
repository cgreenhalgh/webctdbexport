/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class Role {
	private BigDecimal id;
	private BigDecimal memberId;
	private BigDecimal roleDefinitionId;
	private boolean deleteStatus;
	private boolean roleStatus;
	public Role() {}
	public Role(BigDecimal id, BigDecimal memberId,
			BigDecimal roleDefinitionId, boolean deleteStatus,
			boolean roleStatus) {
		super();
		this.id = id;
		this.memberId = memberId;
		this.roleDefinitionId = roleDefinitionId;
		this.deleteStatus = deleteStatus;
		this.roleStatus = roleStatus;
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
	 * @return the memberId
	 */
	public BigDecimal getMemberId() {
		return memberId;
	}
	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(BigDecimal memberId) {
		this.memberId = memberId;
	}
	/**
	 * @return the roleDefinitionId
	 */
	public BigDecimal getRoleDefinitionId() {
		return roleDefinitionId;
	}
	/**
	 * @param roleDefinitionId the roleDefinitionId to set
	 */
	public void setRoleDefinitionId(BigDecimal roleDefinitionId) {
		this.roleDefinitionId = roleDefinitionId;
	}
	/**
	 * @return the deleteStatus
	 */
	public boolean isDeleteStatus() {
		return deleteStatus;
	}
	/**
	 * @param deleteStatus the deleteStatus to set
	 */
	public void setDeleteStatus(boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	/**
	 * @return the roleStatus
	 */
	public boolean isRoleStatus() {
		return roleStatus;
	}
	/**
	 * @param roleStatus the roleStatus to set
	 */
	public void setRoleStatus(boolean roleStatus) {
		this.roleStatus = roleStatus;
	}
	
}
