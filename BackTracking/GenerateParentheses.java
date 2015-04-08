package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> ss = new ArrayList<String>();
		dfs(ss,n,0,"",2*n);
		return ss;
	}


	public void dfs(List<String> ss, int n, int preLeftParenthese, String legacy, int k) {
		if((2*n-k-preLeftParenthese) <= preLeftParenthese && preLeftParenthese <=n) {
			if(k==0) {	
				ss.add(legacy);
				return;
			}
			dfs(ss, n, preLeftParenthese+1, legacy+"(", k-1);
			dfs(ss, n, preLeftParenthese, legacy+")", k-1);
		}
	}


}
