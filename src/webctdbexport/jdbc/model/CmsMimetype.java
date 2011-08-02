/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class CmsMimetype {
	private BigDecimal id;
	private String mimetype;
	private boolean binary;
	public CmsMimetype() {}
	public CmsMimetype(BigDecimal id, String mimetype, boolean binary) {
		super();
		this.id = id;
		this.mimetype = mimetype;
		this.binary = binary;
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
	 * @return the mimetype
	 */
	public String getMimetype() {
		return mimetype;
	}
	/**
	 * @param mimetype the mimetype to set
	 */
	public void setMimetype(String mimetype) {
		this.mimetype = mimetype;
	}
	/**
	 * @return the binary
	 */
	public boolean isBinary() {
		return binary;
	}
	/**
	 * @param binary the binary to set
	 */
	public void setBinary(boolean binary) {
		this.binary = binary;
	}
	
}
