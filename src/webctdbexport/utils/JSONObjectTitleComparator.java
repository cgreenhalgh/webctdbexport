/**
 * 
 */
package webctdbexport.utils;

import java.util.Comparator;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author cmg
 *
 */
public class JSONObjectTitleComparator implements
		Comparator<JSONObject> {

	@Override
	public int compare(JSONObject o1, JSONObject o2) {
		
		try {
			String t1 = o1.has("title") ? o1.getString("title") : "";
			String t2 = o2.has("title") ? o2.getString("title") : "";
			return t1.compareTo(t2);
		} catch (JSONException e) {
			return 0;
		}
	}

}
