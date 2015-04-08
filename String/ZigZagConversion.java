package String;

public class ZigZagConversion {
	public static String convert(String s, int nRows) {
		int row = Math.min(s.length(), nRows);
		if(row == 1)
			return s;
		String result = "";
		for(int i=0;i<row;i++) {
			String curStr = ""+s.charAt(i);
			int len = 2*(row-1);
			if(i==0 || i==row-1) {
				int nextIndex = i+len;
				
				while(nextIndex < s.length()) {
					curStr = curStr + s.charAt(nextIndex);
					nextIndex += len;

				}
			}
			else {
				int nextIndex = i+2*(row-i-1);
				int nextIndex2 = i+len;
				while(nextIndex < s.length()) {
					curStr = curStr + s.charAt(nextIndex);
					nextIndex += len;
					if(nextIndex2 < s.length())
						curStr = curStr + s.charAt(nextIndex2);
					nextIndex2 += len;

				}
			}
			result = result + curStr;
		}
		return result;
	}
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}
