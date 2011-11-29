/**
 * 
 */
package webctdbexport.jdbc.model;

/**
 * @author cmg
 *
 */
public class CmsCeType {
	private String name;
	private boolean pathReachableFlag;
	public CmsCeType() {}
	public CmsCeType(String name, boolean pathReachableFlag) {
		super();
		this.name = name;
		this.pathReachableFlag = pathReachableFlag;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isPathReachableFlag() {
		return pathReachableFlag;
	}
	public void setPathReachableFlag(boolean pathReachableFlag) {
		this.pathReachableFlag = pathReachableFlag;
	}
	
}
