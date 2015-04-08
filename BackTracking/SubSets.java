package BackTracking;
import java.util.*;
public class SubSets {

	ArrayList<List<Integer>> sets = new ArrayList<List<Integer>>();
	public static void main(String[] args) {
		
	}
	public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        ArrayList<Integer> a = new ArrayList<Integer>();
        dfs(S, 0, S.length -1, a);
        return sets;
    }
	
	public void dfs(int[] S, int startPos, int endPos, ArrayList<Integer> a) {
		if(startPos > endPos) {
			sets.add(a);
			return;
		}
			dfs(S, startPos + 1, endPos, a);
			ArrayList<Integer> b = new ArrayList<Integer>(a);
			b.add(S[startPos]);
			dfs(S, startPos + 1, endPos, b);
		
	}
	
	
	public List<List<Integer>> subsetsWithDup(int[] num) {
		Arrays.sort(num);
		ArrayList<Integer> a = new ArrayList<Integer>();
		dfs2(num, 0, num.length -1, a);
		return sets;        
	}
	public void dfs2(int[] S, int startPos, int endPos, ArrayList<Integer> a) {
		if(startPos > endPos) {
			sets.add(a);
			return;
		}
		int i = startPos;
		int k = 1;
		while(i + 1 <= endPos && S[i + 1] == S[startPos]) {
			i++;
			k++;
		}
		
		dfs2(S, startPos + k, endPos, a);
		for(i = 1; i <= k; i++) {
			ArrayList<Integer> b = new ArrayList<Integer>(a);
			for(int j = 1; j <= i; j++)
			    b.add(S[startPos]);
			
			dfs2(S, startPos + k, endPos, b);
		}
		
		
	}
	

}
