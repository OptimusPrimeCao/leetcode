package Math;

public class ValidNumber {
	public static boolean isNumber(String s) {
		if(s == null || s.isEmpty()) 
			return false;
		s = s.trim();
		if(s.isEmpty())
			return false;
		if(s.charAt(0) == '+' || s.charAt(0) == '-')
			s = s.substring(1);
	
		int length = s.length();
		int dotIndex = -1;
		int eIndex = -1;
		for(int i=0; i<length; i++) {
			if(s.charAt(i) == '.' && dotIndex == -1) {
				dotIndex = i;
				continue;
			}
			if(s.charAt(i) == 'e' && eIndex == -1) {
				eIndex = i;
				if(i+1<length && (s.charAt(i+1) == '+' || s.charAt(i+1) == '-'))
					i++;
				continue;
			}
			
			if(s.charAt(i) < '0' || s.charAt(i) > '9') {
				return false;
			}
		}
		
		//xxxx   //xx.xx
		if(eIndex == -1 ) {
			if(dotIndex != -1 && length <= 1)
				return false;
			if(dotIndex == -1 && length <= 0)
				return false;
		}
		
		//xxexx,xx.xxexx
		if(eIndex != -1) {
			//exx, xxe
			if(eIndex == 0 || eIndex == length-1 )
				return false;
			//xxe+,xxe-
			if(eIndex == length - 2 && (s.charAt(length-1) == '+' 
				|| s.charAt(length-1) == '-'))
				return false;
			//xx.exx
			if(dotIndex != -1) { 
				if(eIndex < dotIndex)
					return false;
				//notice: .exxxx
				else if(dotIndex == 0 && eIndex == dotIndex+1)
					return false;
			}
		}
		
		return true;
		
		
	}
	
	public static void main(String[] args) {
		System.out.println(isNumber("1e."));
	}
}
