package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {
	public List<List<Integer>> subsetsWithDup(int[] num) {
		List<List<Integer>> sets = new ArrayList<List<Integer>>();
		List<List<Integer>> newSets = new ArrayList<List<Integer>>();
		List<Integer> emptySet = new ArrayList<Integer>();
		Arrays.sort(num);
		sets.add(emptySet);
		for(int i=0;i<num.length;i++) {
			for(List<Integer> set : sets) {
				List<Integer> s = new ArrayList<Integer>(set);
				s.add(num[i]);
				newSets.add(s);
			}
			sets.addAll(newSets);
			newSets.clear();
		}
		
		return sets;
	}
}
