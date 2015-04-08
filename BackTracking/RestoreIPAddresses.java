package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {
	public static List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<String>();
		if(s == null)
			return result;
		dfs(s, 4, result, "");
		return result;
	}
	
	
	public static void dfs(String s, int n, List<String> result, String res) {
		//注意不能用==
		if(s.equals("") && n == 0) {
			result.add(res.substring(0, res.length()-1));
			return;
		}
		if(s.length() > 0 && n != 0) {
			int firstDigit = s.charAt(0) - '0';
			dfs(s.substring(1), n-1, result, res + s.substring(0,1) + '.');

			if(s.length() > 1 && firstDigit != 0) {
				int secondDigit = s.charAt(1) - '0';
				dfs(s.substring(2),n-1,result,res + s.substring(0,2) + ".");

				if(s.length() > 2) {
					int thirdDigit = s.charAt(2) - '0';
					int sum = firstDigit*100 + secondDigit*10 + thirdDigit;
					if(sum <= 255) {
						dfs(s.substring(3),n-1,result,res + s.substring(0,3) + ".");
					}
				}
			}
		}

	}
	public static void main(String[] args) {
		String s = "s";
		System.out.println(restoreIpAddresses("010010"));
	}
	
 }
