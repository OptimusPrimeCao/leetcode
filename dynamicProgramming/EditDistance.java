package dynamicProgramming;
//插入和删除操作假设只能在尾部进行
public class EditDistance {
	public int minDistance(String word1, String word2) {
		int rowLen = word1.length()+1;
		int colLen = word2.length()+1;
		int[][] dis = new int[rowLen][colLen]; 
		for(int i=0;i<colLen;i++)
			dis[0][i] = i;
		for(int i=0;i<rowLen;i++)
			dis[i][0] = i;

		for(int i=1;i<rowLen;i++) {
			for(int j=1;j<colLen;j++) {
				dis[i][j] = Math.min(Math.min(dis[i-1][j]+1, dis[i][j-1]+1),
						dis[i-1][j-1]+(word1.charAt(i-1)==word2.charAt(j-1)?0:1));
			}
		}
		
		return dis[rowLen-1][colLen-1];
	}
}
