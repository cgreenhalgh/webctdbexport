/**
 * 
 */
package webctdbexport.jdbc.model;

import java.util.Comparator;

/**
 * @author cmg
 *
 */
public class CmsLinkComparator implements Comparator<CmsLink> {

	@Override
	public int compare(CmsLink l1, CmsLink l2) {
		double p1 = l1.getDisplayOrder();
		double p2 = l2.getDisplayOrder();
		return new Double(p1).compareTo(new Double(p2));
	}
	
}
