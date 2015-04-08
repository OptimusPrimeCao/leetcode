import java.util.*;
public class WordLadder {
	
	public static void main(String[] args) {
        HashSet<String> dict = new HashSet<String>();
        dict.add("rat");
        dict.add("pen");
        dict.add("pan");
        dict.add("pet");
        dict.add("pat");
        dict.add("ran");
        WordLadder a = new WordLadder();
        System.out.println(a.findLadders("rat", "pen", dict));
        //System.out.println(a.preStrings.entrySet());
        

	}
	public int ladderLength(String start, String end, Set<String> dict) {
		Queue<String> qs = new LinkedList<String>();
		int step = 1;
		int sLength = start.length();
		boolean find = false;
		qs.add(start);
		qs.add(null);
		while(!qs.isEmpty()) {
			String s = qs.poll();
			if(s != null) {
				for(int i=0; i<sLength; i++) {
					for(char c='a'; c<='z'; c++) {
						if(c != s.charAt(i)) {
							StringBuilder testBul = new StringBuilder(s);
							testBul.setCharAt(i, c);
							String test = testBul.toString();
							if(test.equals(end)) {
								return step + 1;
							}
	
							if(dict.contains(test)) {
								dict.remove(test);
								qs.add(test);
							}
							
						}
					}
				}
			}
			
			else {
				step++;
				if(!qs.isEmpty())
					qs.add(null);
				
			}
		}
		
		return 0;
    }
	
	/*ʹ�ÿ�ָ��ʵ�ֲ�������*/
	public List<List<String>> findLadders(String start, String end, Set<String> dict) {
		HashMap<String, ArrayList<String>> preStrings = new HashMap<String, ArrayList<String>>();
		Queue<String> qs = new LinkedList<String>();
		ArrayList<List<String>> ladders = new ArrayList<List<String>>();
		
		ArrayList<String> stringToDelete = new ArrayList<String>();
		int sLength = start.length();
		boolean find = false;
		
		qs.add(start);
		qs.add(null);
		
		
		while(!qs.isEmpty()) {
			String s = qs.poll();
			if(s != null) {
				char[] sr = s.toCharArray();
				/*/
				 *ѭ���ǳ��������Ӷ�
				 */
				for(int i=0; i<sLength; i++) {
					char tmp = sr[i];
					for(char c='a'; c<='z'; c++) {
						if(c != tmp) {
							sr[i] = c;
							String test = String.valueOf(sr);
							if(test.equals(end)) {
								find = true;
								 /*���������ڵ�*/
								if(preStrings.containsKey(test)) {
								    preStrings.get(test).add(s);
								
								}
								else {
									ArrayList<String> a = new ArrayList<String>();
									a.add(s);
									preStrings.put(test, a);
								}
							}
	
							else if(dict.contains(test)) {
							    if(preStrings.containsKey(test)) {
									preStrings.get(test).add(s);
									
								}
								else {
									ArrayList<String> a = new ArrayList<String>();
									a.add(s);
									preStrings.put(test, a);
									
									stringToDelete.add(test);   //�ڵ��ݴ棬�ò������ɺ�ɾ��
									qs.add(test);       //δ���ù������ڵ�Ľڵ����Ҫ�������
								}
							    
							}
							
						 sr[i] = tmp;
						}
						
					}
				}
			}
			
			else {
				if(find)                 break; 
				if(!qs.isEmpty()) {
					while(!stringToDelete.isEmpty()) {
						String temp = stringToDelete.remove(0);
						dict.remove(temp);
					}
					qs.add(null);
				}
			}
		}
		
		if(find) {
			ArrayList<String> tmpList = new ArrayList<String>();
			tmpList.add(end);
			buildPath(start, end, tmpList,preStrings, ladders);
		}
		return ladders;
		
    }
	
	
	
	
	private void buildPath(String start, String end, ArrayList<String> tmpList, 
		Map<String, ArrayList<String>> preStrings, ArrayList<List<String>> ladders) {
		
		ArrayList<String> pres = preStrings.get(end);
		if(start.equals(end)) {
			ArrayList<String> tmpPath = new ArrayList<String>(tmpList);
			Collections.reverse(tmpPath);
			ladders.add(tmpPath);
			return;
		}
		for(String s: pres) {
			tmpList.add(s);
			buildPath(start, s, tmpList, preStrings, ladders);
			tmpList.remove(tmpList.size() - 1);
		}
	}
	
	/*ʹ����������ʵ�ֲ�������*/
	public List<List<String>> findLadders2(String start, String end, Set<String> dict) {
		HashMap<String, ArrayList<String>> preStrings = new HashMap<String, ArrayList<String>>();
		Queue<String> qs = new LinkedList<String>();
		Queue<String> temq = new LinkedList<String>();
		ArrayList<List<String>> ladders = new ArrayList<List<String>>();
		
		ArrayList<String> stringToDelete = new ArrayList<String>();
		int sLength = start.length();
		boolean find = false;
		
		qs.add(start);
		
		
		
		while(!qs.isEmpty()) {
			String s = qs.poll();
			char[] sr = s.toCharArray();
			/*/
			 *ѭ���ǳ��������Ӷ�
			 */
			for(int i=0; i<sLength; i++) {
				char tmp = sr[i];
				for(char c='a'; c<='z'; c++) {
					if(c != tmp) {
						sr[i] = c;
						String test = String.valueOf(sr);
						if(test.equals(end)) {
							find = true;
							/*���������ڵ�*/
							if(preStrings.containsKey(test)) {
								preStrings.get(test).add(s);

							}
							else {
								ArrayList<String> a = new ArrayList<String>();
								a.add(s);
								preStrings.put(test, a);
							}
						}

						else if(dict.contains(test)) {     //����else�����test.equals(end)ʱ���ظ�
							if(preStrings.containsKey(test)) {
								preStrings.get(test).add(s);

							}
							else {
								ArrayList<String> a = new ArrayList<String>();
								a.add(s);
								preStrings.put(test, a);

								stringToDelete.add(test);   //�ڵ��ݴ棬�ò������ɺ�ɾ��
								temq.add(test);       //δ���ù������ڵ�Ľڵ����Ҫ�������
							}

						}

						sr[i] = tmp;
					}

				}
			}
		
			if(qs.isEmpty()) {
				if(find)            break;
				else {
					while(!stringToDelete.isEmpty()) {
						String temp = stringToDelete.remove(0);
						dict.remove(temp);
					}
					qs = temq;
					temq = new LinkedList<String>();
				}
			}
	}
		
		
		if(find) {
			ArrayList<String> tmpList = new ArrayList<String>();
			tmpList.add(end);
			buildPath(start, end, tmpList,preStrings, ladders);
		}
		return ladders;
		
    }

}
