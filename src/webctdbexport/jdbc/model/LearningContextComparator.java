/**
 * 
 */
package webctdbexport.jdbc.model;

import java.util.Comparator;

/** Compare LearningContexts by name (lowercase)
 * @author cmg
 *
 */
public class LearningContextComparator implements
		Comparator<LearningContext> {

	@Override
	public int compare(LearningContext lc1, LearningContext lc2) {
		return lc1.getName().compareToIgnoreCase(lc2.getName());
	}

}
