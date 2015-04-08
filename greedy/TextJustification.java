package greedy;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	public static List<String> fullJustify(String[] words, int L) {
		List<String> rowStr = new ArrayList<String>();
		List<String> result = new ArrayList<String>();
		if(words == null || words.length == 0)
			return result;
		rowStr.add(words[0]);
		int existLen = words[0].length();
		for(int k=1;k<words.length;k++) {
			String str = words[k];
			if(existLen+1+str.length()<=L) {
				existLen += 1+str.length();
				rowStr.add(str);
				continue;
			}
			
			String curStr = "";
			int emptyPads = L;
			for(String s:rowStr)
				emptyPads = emptyPads - s.length();
					
			if(rowStr.size()==1) {
				curStr = rowStr.get(0);
				for(int i=1;i<=emptyPads;i++) 
					curStr = curStr + " ";
			}
			else {
				int leftPadsPerSlot = emptyPads%(rowStr.size()-1)==0?emptyPads/(rowStr.size()-1):emptyPads/(rowStr.size()-1)+1;
				int rightPadsPerSlot = emptyPads%(rowStr.size()-1)==0?emptyPads/(rowStr.size()-1):emptyPads/(rowStr.size()-1);
				int leftPadsNumber = emptyPads%(rowStr.size()-1);
				String leftPadsStr = "";
				for(int i=1;i<=leftPadsPerSlot;i++)
					leftPadsStr = leftPadsStr + " ";
				String rightPadsStr = "";
				for(int i=1;i<=rightPadsPerSlot;i++)
					rightPadsStr = rightPadsStr + " ";
				
				for(int i=0;i<leftPadsNumber;i++) 
					curStr = curStr + rowStr.get(i) + leftPadsStr;
				for(int i=leftPadsNumber;i<=rowStr.size()-2;i++) 
					curStr = curStr + rowStr.get(i) + rightPadsStr;	
				curStr = curStr + rowStr.get(rowStr.size()-1);
				
			}
			
			result.add(curStr);
			rowStr.clear();
			rowStr.add(str);
			existLen = str.length();
			System.out.println(curStr);			
		}
		int emptyPadsOnRight = L;
		for(String s:rowStr)
			emptyPadsOnRight = emptyPadsOnRight-s.length()-1;
		emptyPadsOnRight++;
		
		String lastRowStr = "";
		for(String s : rowStr) 
			lastRowStr = lastRowStr + s + " ";
		lastRowStr = lastRowStr.substring(0, lastRowStr.length()-1);
		
		for(int i=1;i<=emptyPadsOnRight;i++)
			lastRowStr = lastRowStr + " ";
		
		result.add(lastRowStr);		
		return result;
	}
	
	
	
	public static void main(String[] args) {
		String[] ss = new String[]{"tttttttttttt","This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(fullJustify(ss, 16));
	}
}	
