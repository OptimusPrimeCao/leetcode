package String;

public class CountAndSay {
	public static String countAndSay(int n) {
		String preStr = "1";
		String curStr = "1";
		int count;
		for(int i=1;i<=n-1;i++) {
			count = 1;
			curStr = "";
			char[] cArr = preStr.toCharArray();
			for(int j=1;j<preStr.length();j++) {
				if(cArr[j] == cArr[j-1]) {
					count++;
					continue;
				}
				curStr = curStr + (char)(count+'0') + cArr[j-1];
				count = 1;	
			}
			curStr = curStr + (char)(count+'0') + cArr[preStr.length()-1];
			preStr = curStr;
		}
		return curStr;
	}
	public static void main(String[] args) {
		System.out.println(countAndSay(5));
	}
}
