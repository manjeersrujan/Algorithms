import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;


/**
 * @author smanjeer
 *
 * 18 Jul 2021 3:59:11 AM
 * 
 * https://leetcode.com/problems/time-based-key-value-store/
 * 
 */
class TimeMap {
	/** Initialize your data structure here. */

	Map<String, TreeMap<Integer, String>> timeMap = null;

	public TimeMap() {
		timeMap = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		if (timeMap.get(key) == null) {
			TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
			timeMap.put(key, treeMap);
			treeMap.put(timestamp, value);
		} else {
			timeMap.get(key).put(timestamp, value);
		}
	}

	public String get(String key, int timestamp) {
		Entry<Integer, String> entry = timeMap.get(key) == null ? null : timeMap.get(key).floorEntry(timestamp);
		return entry == null ? "" : entry.getValue();
	}

}
