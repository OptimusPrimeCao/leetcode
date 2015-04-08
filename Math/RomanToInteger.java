package Math;
//http://zhidao.baidu.com/link?url=JSNI6jy_Qspb84WDzE_iN0Nff7l5l4p72dFpto-FNWf3CKCiz9i9PRfKD_kdkzl52N60MlcXG39Bpb-pVhiyrK
//http://zuoye.baidu.com/question/441ac07962eb54ca781a28fa0378a041.html
public class RomanToInteger {

	public static int romanToInt(String s) {
		if(s == null || s.isEmpty())
			return 0;

		int prev = getRomanValue(s.charAt(0));
		int curv = 0;
		int result = prev;
		for(int i=1;i<s.length();i++) {
			curv = getRomanValue(s.charAt(i));
			if(curv > prev) {
				result = result + curv - prev * 2;
			}else {
				result += curv;
			}
			
			prev = curv;
		}
		
		return result;
	}
	public static int getRomanValue(char c) {  
		switch(c) {  
		case 'I': return 1;   
		case 'V': return 5;  
		case 'X': return 10;  
		case 'L': return 50;  
		case 'C': return 100;  
		case 'D': return 500;  
		case 'M': return 1000;  
		default: return 0;  
		}  
	}
	
	public static void main(String[] args) {
		System.out.println(romanToInt("M"));
	}
}