/**
 * 
 */
package webctdbexport.utils;

import java.util.Comparator;

import webctdbexport.db.LearningContext;

/** Compare LearningContexts by name (lowercase)
 * @author cmg
 *
 */
public class LearningContextComparator implements
		Comparator<LearningContext> {

	@Override
	public int compare(LearningContext lc1, LearningContext lc2) {
		return lc1.getNameLowercase().compareTo(lc2.getNameLowercase());
	}

}
