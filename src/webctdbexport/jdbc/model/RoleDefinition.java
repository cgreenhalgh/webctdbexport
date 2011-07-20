/**
 * 
 */
package webctdbexport.jdbc.model;

import java.math.BigDecimal;

/**
 * @author cmg
 *
 */
public class RoleDefinition {
	private BigDecimal id;
	private String name;
	public RoleDefinition() {}
	public RoleDefinition(BigDecimal id, String name) {
		super();
		this.id = id;
		this.name = name;
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
	
}
