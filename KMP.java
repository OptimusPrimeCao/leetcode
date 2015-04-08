
public class KMP {
 
    int[] next;
	public static void main(String[] args) {
	     String regx ="aabaabc";
	     KMP kmp = new KMP();
	     int [] test = kmp.getNext(regx);
	     for(int i=0;i<test.length;i++) {
	    	 System.out.print(test[i]+" ");
	     }
	     String s = "1wrweaaadaabaabc";
	     System.out.println(kmp.find(s,regx,1));
	     

	}
	
	public int find(String s, String regx, int pos) {
		 char[] cMain = s.toCharArray();
		 char[] cRegx = regx.toCharArray();
		 int i=pos,j=0;		 
		 while(i<s.length() && j<regx.length()) {
			 if(-1 ==j || cMain[i] == cRegx[j]){
				 i++;j++;
			 }
			 else
				 j = next[j];
		 }
		 if(regx.length() == j){
			 return i-regx.length();
		 }
		 else 
			 return -1;
	}
	
	
	public int[] getNext(String s) {
		 next = new int[s.length()];
		 char [] cArray = s.toCharArray();
		 
		 int i = 0,j = -1;
		 next[0] = -1;
		 while(i < s.length()-1) {
			 if(-1 == j || cArray[i] == cArray[j]) {
				 i++;j++;
				 if(cArray[i] == cArray[j]) {
					 next[i] = next[j];
				 }
				 else
					 next[i] = j;
			 }
			 else
				 j = next[j];
		 }
		 return next;
	}

}
