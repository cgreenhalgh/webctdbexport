/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class CoUrl {
	private BigDecimal id;
	private String link;
	private boolean openinnewwindowflag;
	public CoUrl() {}
	public CoUrl(BigDecimal id, String link, boolean openinnewwindowflag) {
		super();
		this.id = id;
		this.link = link;
		this.openinnewwindowflag = openinnewwindowflag;
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
	 * @return the link
	 */
	public String getLink() {
		return link;
	}
	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	/**
	 * @return the openinnewwindowflag
	 */
	public boolean isOpeninnewwindowflag() {
		return openinnewwindowflag;
	}
	/**
	 * @param openinnewwindowflag the openinnewwindowflag to set
	 */
	public void setOpeninnewwindowflag(boolean openinnewwindowflag) {
		this.openinnewwindowflag = openinnewwindowflag;
	}
	
}
