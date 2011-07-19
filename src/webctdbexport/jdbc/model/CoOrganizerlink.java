/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class CoOrganizerlink {
	private BigDecimal id;
	private float position;
	private boolean openinnewwindow;
	private String longDescription;
	private String linkname;
	public CoOrganizerlink() {}
	public CoOrganizerlink(BigDecimal id, float position,
			boolean openinnewwindow, String longDescription, String linkname) {
		super();
		this.id = id;
		this.position = position;
		this.openinnewwindow = openinnewwindow;
		this.longDescription = longDescription;
		this.linkname = linkname;
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
	 * @return the position
	 */
	public float getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(float position) {
		this.position = position;
	}
	/**
	 * @return the openinnewwindow
	 */
	public boolean isOpeninnewwindow() {
		return openinnewwindow;
	}
	/**
	 * @param openinnewwindow the openinnewwindow to set
	 */
	public void setOpeninnewwindow(boolean openinnewwindow) {
		this.openinnewwindow = openinnewwindow;
	}
	/**
	 * @return the longDescription
	 */
	public String getLongDescription() {
		return longDescription;
	}
	/**
	 * @param longDescription the longDescription to set
	 */
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	/**
	 * @return the linkname
	 */
	public String getLinkname() {
		return linkname;
	}
	/**
	 * @param linkname the linkname to set
	 */
	public void setLinkname(String linkname) {
		this.linkname = linkname;
	}
	
}
