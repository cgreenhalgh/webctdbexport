/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class Member {
	private BigDecimal id;
	private BigDecimal personId;
	private BigDecimal LearningContextId;
	private boolean statusFlag;
	private boolean deleteStatus;
	public Member() {		
	}
	public Member(BigDecimal id, BigDecimal personId,
			BigDecimal learningContextId, boolean statusFlag,
			boolean deleteStatus) {
		super();
		this.id = id;
		this.personId = personId;
		LearningContextId = learningContextId;
		this.statusFlag = statusFlag;
		this.deleteStatus = deleteStatus;
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
	 * @return the personId
	 */
	public BigDecimal getPersonId() {
		return personId;
	}
	/**
	 * @param personId the personId to set
	 */
	public void setPersonId(BigDecimal personId) {
		this.personId = personId;
	}
	/**
	 * @return the learningContextId
	 */
	public BigDecimal getLearningContextId() {
		return LearningContextId;
	}
	/**
	 * @param learningContextId the learningContextId to set
	 */
	public void setLearningContextId(BigDecimal learningContextId) {
		LearningContextId = learningContextId;
	}
	/**
	 * @return the statusFlag
	 */
	public boolean isStatusFlag() {
		return statusFlag;
	}
	/**
	 * @param statusFlag the statusFlag to set
	 */
	public void setStatusFlag(boolean statusFlag) {
		this.statusFlag = statusFlag;
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
	
}
