/**
 * 
 */
package webctdbexport.jdbc.model;

import java.util.Comparator;

/**
 * @author cmg
 *
 */
public class OrganizerlinkComparator implements Comparator<CmsLink> {

	@Override
	public int compare(CmsLink l1, CmsLink l2) {
		CoOrganizerlink ol1 = l1.getCoOrganizerlink();
		CoOrganizerlink ol2 = l2.getCoOrganizerlink();
		double p1 = ol1!=null ? ol1.getPosition() : -1;
		double p2 = ol2!=null ? ol2.getPosition() : -1;
		return new Double(p1).compareTo(new Double(p2));
	}
	
}
