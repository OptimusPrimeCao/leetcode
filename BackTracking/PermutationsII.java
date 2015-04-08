package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if(num != null) {
			Arrays.sort(num);
			dfs2(num,0,new ArrayList<Integer>(),result);
		}
		return result;
	}

	public void dfs2(int[] num, int curIndex, List<Integer> res, List<List<Integer>> result) {
		if(curIndex >= num.length) {
			result.add(res);
			return;
		}
		int startPos = 0;
		if(curIndex >0 && num[curIndex] == num[curIndex-1]) 
			startPos = res.lastIndexOf(new Integer(num[curIndex]))+1;
		
		for(int i=startPos;i<=res.size();i++) {
			List<Integer> cur = new ArrayList<Integer>(res);
			cur.add(i, num[curIndex]);
			dfs(num, curIndex+1, cur, result);
		}
  
	}
	
	public void dfs(int[] num, int curIndex, List<Integer> res, List<List<Integer>> result) {
		if(curIndex >= num.length) {
			result.add(res);
			return;
		}
		for(int i=0;i<=res.size();i++) {
			List<Integer> cur = new ArrayList<Integer>(res);
			cur.add(i, num[curIndex]);
			dfs(num, curIndex+1, cur, result);
		}

	}

}





