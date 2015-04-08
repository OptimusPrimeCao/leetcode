package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//把第一个str作为值存进map，第二个相同的anagrams将其置空
public class Anagrams {
	public List<String> anagrams(String[] strs) {
		List<String> result = new ArrayList<String>();
		if(strs == null || strs.length == 0)
			return result;
		Map<String,String> strMap = new HashMap<String, String>();
		for(String str : strs) {
			char[] cArr = str.toCharArray();
			Arrays.sort(cArr);
			String sortedStr = new String(cArr);
			if(strMap.containsKey(sortedStr)) {
				result.add(str);
				if(strMap.get(sortedStr) != null) {
					result.add(strMap.get(sortedStr));
					strMap.put(sortedStr, null);
				}
			}
			else {
				strMap.put(sortedStr, str);
			}
		}
		return result;

	}
}
