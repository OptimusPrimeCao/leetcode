
public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		String s = "  a  b     ";
		//System.out.println(new ReverseWords().reverseWords(s).length());
		System.out.println(s.trim());
		String[] sb2 = s.split("\\s");
		System.out.println(s.split("\\s").length);
		for(int i=0; i<sb2.length;i++) {
			System.out.println(sb2[i].length());
		}
		
		
		/*String st = s.trim();
		String[] sb1 = s.split("\\s");
		//System.out.println(sb1.length);
		for(int i=0; i<sb1.length;i++) {
			System.out.println(sb1[i]);
		}
		String[] sb2 = st.split("[\\s]*");
		System.out.println(sb2.length);
		for(int i=0; i<sb2.length;i++) {
			System.out.println(sb2[i]);
		}
		System.out.println(st.length());
		*/
		

	}
	
	 public String reverseWords(String s) {		
		String st = s.trim();
		String result ="";
		if(st.length() > 0) {
		    String[] sArray = s.split("\\s");
		    for(int i=sArray.length-1; i>=0; i--) {
		    	if(sArray[i].trim().length() > 0)
		    		result = result + sArray[i] + " ";
		    }
		    return result.trim();
		}
		else
			return st;
	 }

}
