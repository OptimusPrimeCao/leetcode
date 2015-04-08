package Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class LargestNumber {
	public String largestNumber(int[] num) {
		if(num == null || num.length < 1)
			return "";
		String[] strs = new String[num.length];
		for(int i=0;i<num.length;i++)
			strs[i] = String.valueOf(num[i]);
		
		Arrays.sort(strs, new Comparator<String>() {
			public int compare(String o1, String o2) {
				String str1 = o1+o2;
				String str2 = o2+o1;
				for(int i=0;i<str1.length();i++) {
					if(str1.charAt(i) != str2.charAt(i)) {
						if(str1.charAt(i) > str2.charAt(i))
							return 1;
						else 
							return -1;
					}
				}
				return 0;
			}
			
		});
		
		if(strs[num.length-1].equals("0"))
			return "0";
		String result = "";
		for(int i=num.length-1; i>=0; i--)
			result =result + strs[i];
		return result;
	}
}
