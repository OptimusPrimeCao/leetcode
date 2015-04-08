package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<String>();
		if(digits == null || digits.isEmpty())
			return result;
		dfs(0,digits,result,"");	
		return result;
	}


	public void dfs(int curIndex, String digits, List<String> result, String legacy) {
		if(curIndex >= digits.length()) {
			result.add(legacy);
			return;
		}

		int curNum = digits.charAt(curIndex) - '0';
		if(curNum >= 1 && curNum <= 9) { 
			if(curNum <= 6)
				for(int k=0;k<=2;k++) 
					dfs(curIndex+1, digits, result, legacy+(char)('a'+k+(curNum-2)*3));
			if(curNum == 7)
				for(int k=0;k<=3;k++) 
					dfs(curIndex+1, digits, result, legacy+(char)('p'+k));
			if(curNum == 8)
				for(int k=0;k<=2;k++) 
					dfs(curIndex+1, digits, result, legacy+(char)('t'+k));
			if(curNum == 9)
				for(int k=0;k<=3;k++) 
					dfs(curIndex+1, digits, result, legacy+(char)('w'+k));
			
		}
		else 
			dfs(curIndex+1, digits, result, legacy+curNum);

	}

	public static void main(String[] args) {
		System.out.println((char)('a'+1));
	}
}
