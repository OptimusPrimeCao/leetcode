/*���ǣ�ע����wordbreak�ıȽϣ�ע������ݵıȽ�*/
import java.util.*;
public class PalindromePartition {

	/**
	 * @param args
	 */
	HashMap<Integer, ArrayList<Integer>> partitions = new HashMap<Integer, ArrayList<Integer>>();
	int min = 0;
	ArrayList<List<String>> results = new ArrayList<List<String>>();
	public static void main(String[] args) {
		PalindromePartition p = new PalindromePartition();
		//System.out.println(p.partition("amanaplanacanalpanama"));
		p.getIndexs("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp");
		System.out.println(p.minCut("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
		System.out.println(p.partitions.size());
		//System.out.println(p.minCut2("apjesgpsxoeiokmqmfgvjslcjukbqxpsobyhjpbgdfruqdkeiszrlmtwgfxyfostpqczidfljwfbbrflkgdvtytbgqalguewnhvvmcgxboycffopmtmhtfizxkmeftcucxpobxmelmjtuzigsxnncxpaibgpuijwhankxbplpyejxmrrjgeoevqozwdtgospohznkoyzocjlracchjqnggbfeebmuvbicbvmpuleywrpzwsihivnrwtxcukwplgtobhgxukwrdlszfaiqxwjvrgxnsveedxseeyeykarqnjrtlaliyudpacctzizcftjlunlgnfwcqqxcqikocqffsjyurzwysfjmswvhbrmshjuzsgpwyubtfbnwajuvrfhlccvfwhxfqthkcwhatktymgxostjlztwdxritygbrbibdgkezvzajizxasjnrcjwzdfvdnwwqeyumkamhzoqhnqjfzwzbixclcxqrtniznemxeahfozp"));
		
		System.out.println("ok");
	}
	
	
	public List<List<String>> partition(String s) {
        getIndexs(s);
        showResults(s, s.length()-1, new ArrayList<String>());
        return results;
    }
	
	
	public int minCut2(String s) {
		min = s.length();
        getCut(s, s.length()-1, 0);
        return min;
    }
	
	private void getCut(String s, int pos, int n) {
		if(isPalindrome(s.substring(0, pos + 1))) {
			if(n < min)    min = n;
			return;
		}
		for(int i=pos; i>0; i--) {
			if(isPalindrome(s.substring(i, pos + 1)))
				getCut(s, i-1, n+1);
		}
		
	}
	/*http://www.cnblogs.com/avril/p/3293449.html*/
	
	public int minCut(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
	    boolean palin[][] = new boolean[s.length()][s.length()];
	    int minCutArray[] = new int[s.length() + 1];
	    for(int i = s.length()-1; i>=0; i--) {
	    	minCutArray[i] = s.length() - i ;
	    	for(int j = i; j < s.length(); j++) {
	    		if(s.charAt(i)==s.charAt(j)&&(j-i<2 || palin[i+1][j-1])) {  
	    			palin[i][j] = true;
	    			minCutArray[i] = Math.min(minCutArray[i], minCutArray[j+1] + 1);
	    		}
	    	}
	    }
	    return minCutArray[0] - 1;
	}
	private void showResults(String s, int pos, ArrayList<String> preStrings ) {
		ArrayList<Integer> splits = partitions.get(pos);
		for(int i = splits.size()-1; i >= 0; i--) {
			ArrayList<String> strings = new ArrayList<String>(preStrings);
			int index = splits.get(i);
			if(index == -1) {
				strings.add(s.substring(0, pos + 1));
				Collections.reverse(strings);
				results.add(strings);
			}
			else {
				strings.add(s.substring(index + 1, pos + 1));
				showResults(s, index, strings);
			}		
		}
		
		
	}
	
	private void getIndexs(String s) {
		ArrayList<Integer> getPartitions = new ArrayList<Integer>();
		for(int i = 0; i < s.length(); i++) {
			String test = s.substring(0, i + 1);
			boolean flag = false;
			if(isPalindrome(test)) {
				ArrayList<Integer> splits = new ArrayList<Integer>();
				splits.add(-1);
				partitions.put(i, splits);
				flag = true;
			}
			for(int j = getPartitions.size()-1; j >= 0; j--) {
				ArrayList<Integer> a;
				test = s.substring(getPartitions.get(j) + 1, i + 1);
				if(isPalindrome(test)) {
					flag = true;
					if(partitions.containsKey(i)) {
						a = partitions.get(i);
					}
					
					else {
						a = new ArrayList<Integer>();
						partitions.put(i, a);
					}
					a.add(getPartitions.get(j));
				}	
			}
			if(flag)
				getPartitions.add(i);
		}
		
	}
	
	private boolean isPalindrome(String s) {
		if(s.length() == 1)
			return true;
		int i = 0, j = s.length() - 1;
		while(i < j) {
			if(s.charAt(i) != s.charAt(j))
				break;
			i++;
			j--;
		}
		if(i >= j)
			return true;
		else
			return false;
	}

}
