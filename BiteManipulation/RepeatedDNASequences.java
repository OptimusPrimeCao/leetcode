package BiteManipulation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		List<String> result = new ArrayList<String>();
		int value = 0;
		for(int i=0;i<s.length();i++) {
			value = (value<<3 | s.charAt(i)&0x7) & 0x3FFFFFFF;
			if(i < 9)
				continue;
			if(map.containsKey(value)) {
				if(map.get(value) == 1)
					result.add(s.substring(i-9, i+1));
				map.put(value, map.get(value)+1);
			}
			else
				map.put(value, 1);
			
		}
		return result;
	}
}
