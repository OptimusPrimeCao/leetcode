package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//主要是L中重复的问题
public class SubstringwithConcatenationofAllWords {
	  public List<Integer> findSubstring(String S, String[] L) {
		  int wordNum = L.length;
		  int wordLength = L[0].length();
		  HashMap<String, Integer> words = new HashMap<String, Integer>();
		  HashMap<String, Integer> findWords = new HashMap<String, Integer>();
		  List<Integer> results = new ArrayList<Integer>();
		  
		  if(S == null || L == null || S.isEmpty() || L.length<1)
			  return results;
		  
		  for(int i=0;i<wordNum;i++) {
			  if(!words.containsKey(L[i]))
				  words.put(L[i], 1);
			  else
				  words.put(L[i], words.get(L[i]) + 1);
		  }
		  
		  for(int i=0; i<=S.length()-wordNum * wordLength; i++) {
			  findWords.clear();
			  int j;
			  for(j=0;j<wordNum;j++) {
				  int startIndex = i + j*wordLength;
				  String test = S.substring(startIndex, startIndex + wordLength);
				  if(!words.containsKey(test))
					  break;
				  if(findWords.containsKey(test)) {
					  findWords.put(test, findWords.get(test) + 1);
				  }else {
					  findWords.put(test, 1);
				  }
				  
				  if(findWords.get(test) > words.get(test)) 
					  break;
				  
			  }
			  
			  if(j == wordNum) {
				  results.add(i);
			  }
			  
		  }
		  return results;
		  
	  }
	  public static void main(String[] args) {
		System.out.println();
	}
}
