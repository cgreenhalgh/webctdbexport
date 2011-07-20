/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class Person {
	private BigDecimal id;
	private BigDecimal learningContextId;
	private boolean activestatus;
	private boolean demouser;
	private String remoteUserid;
	private String webctId;
	private String sourcedidSource;
	private BigDecimal deletestatus;
	private BigDecimal homefolderId;
	public Person(BigDecimal id, BigDecimal learningContextId,
			boolean activestatus, boolean demouser, String remoteUserid,
			String webctId, String sourcedidSource, BigDecimal deletestatus,
			BigDecimal homefolderId) {
		super();
		this.id = id;
		this.learningContextId = learningContextId;
		this.activestatus = activestatus;
		this.demouser = demouser;
		this.remoteUserid = remoteUserid;
		this.webctId = webctId;
		this.sourcedidSource = sourcedidSource;
		this.deletestatus = deletestatus;
		this.homefolderId = homefolderId;
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
	 * @return the learningContextId
	 */
	public BigDecimal getLearningContextId() {
		return learningContextId;
	}
	/**
	 * @param learningContextId the learningContextId to set
	 */
	public void setLearningContextId(BigDecimal learningContextId) {
		this.learningContextId = learningContextId;
	}
	/**
	 * @return the activestatus
	 */
	public boolean isActivestatus() {
		return activestatus;
	}
	/**
	 * @param activestatus the activestatus to set
	 */
	public void setActivestatus(boolean activestatus) {
		this.activestatus = activestatus;
	}
	/**
	 * @return the demouser
	 */
	public boolean isDemouser() {
		return demouser;
	}
	/**
	 * @param demouser the demouser to set
	 */
	public void setDemouser(boolean demouser) {
		this.demouser = demouser;
	}
	/**
	 * @return the remoteUserid
	 */
	public String getRemoteUserid() {
		return remoteUserid;
	}
	/**
	 * @param remoteUserid the remoteUserid to set
	 */
	public void setRemoteUserid(String remoteUserid) {
		this.remoteUserid = remoteUserid;
	}
	/**
	 * @return the webctId
	 */
	public String getWebctId() {
		return webctId;
	}
	/**
	 * @param webctid the webctId to set
	 */
	public void setWebctId(String webctId) {
		this.webctId = webctId;
	}
	/**
	 * @return the sourcedidSource
	 */
	public String getSourcedidSource() {
		return sourcedidSource;
	}
	/**
	 * @param sourcedidSource the sourcedidSource to set
	 */
	public void setSourcedidSource(String sourcedidSource) {
		this.sourcedidSource = sourcedidSource;
	}
	/**
	 * @return the deletestatus
	 */
	public BigDecimal getDeletestatus() {
		return deletestatus;
	}
	/**
	 * @param deletestatus the deletestatus to set
	 */
	public void setDeletestatus(BigDecimal deletestatus) {
		this.deletestatus = deletestatus;
	}
	/**
	 * @return the homefolderId
	 */
	public BigDecimal getHomefolderId() {
		return homefolderId;
	}
	/**
	 * @param homefolderId the homefolderId to set
	 */
	public void setHomefolderId(BigDecimal homefolderId) {
		this.homefolderId = homefolderId;
	}
	
}
