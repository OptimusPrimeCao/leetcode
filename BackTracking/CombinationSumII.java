package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
	public static List<List<Integer>> combinationSum2(int[] num, int target) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(num);
		dfs(result,num,0,target,new ArrayList<Integer>());
		return result;
	}

	public static void dfs(List<List<Integer>> result,int[] candidates, int curIndex, int target, List<Integer> legacy) {
		if(target == 0) {
			result.add(legacy);
			return;
		}
		if(target > 0 && curIndex < candidates.length) {
			int k = 1;
			while(k+curIndex<candidates.length && candidates[k+curIndex]==candidates[curIndex])
				k++;
			//计算有k个curNum
			dfs(result, candidates, curIndex+k, target, legacy);
			for(int i=1;i<=k;i++) {
				int remain = target-candidates[curIndex]*i;
				if(remain < 0)
					break;
				List<Integer> listWithCurNum = new ArrayList<Integer>(legacy);
				for(int j=1;j<=i;j++)
					listWithCurNum.add(candidates[curIndex]);
				dfs(result, candidates, curIndex+k, remain, listWithCurNum);
			}
		}
	}

	public static void main(String[] args) {
		System.out.println(combinationSum2(new int[]{1}, 1));
	}
}
