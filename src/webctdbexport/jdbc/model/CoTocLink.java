/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class CoTocLink {
	private BigDecimal id;
	private int indentlevel;
	public CoTocLink() {}
	public CoTocLink(BigDecimal id, int indentlevel) {
		super();
		this.id = id;
		this.indentlevel = indentlevel;
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
	 * @return the indentLevel
	 */
	public int getIndentlevel() {
		return indentlevel;
	}
	/**
	 * @param indentLevel the indentLevel to set
	 */
	public void setIndentlevel(int indentlevel) {
		this.indentlevel = indentlevel;
	}
	
}
