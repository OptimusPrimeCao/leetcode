
public class WordSearch {

	public static void main(String[] args) {
		//char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
		char[][] board = {{'A'},{'A'}};
		String word = "AA";
		boolean result = new WordSearch().exist(board, word);
    	System.out.println(result);

	}
	
    public boolean exist(char[][] board, String word) {
        if(word == null) {
        	return false;
        }
       
        char a = word.charAt(0);
    	for(int i=0; i < board.length; i++) {
    		for(int j=0; j < board[i].length; j++) {
    			if(board[i][j] == a) {
    				board[i][j] = '#';
    				if(dfs(board, i, j, word.substring(1))) {
    					return true;
    				}
    				board[i][j] = a;
    			}
    		}
    	}
    	return false;
        
    }
   
    
    public boolean dfs(char[][] board, int i, int j, String word) {
    	if(word.length() == 0) {
    		return true;
    	}
    	boolean flag = false;
    	char a = word.charAt(0);
    	if(i>0 && a == board[i-1][j]) {
			board[i-1][j] = '#';
    		flag = dfs(board, i-1, j, word.substring(1));
    		board[i-1][j] = a;
    		if(flag) return flag;
    	}
    	if(j>0 && a == board[i][j-1]) {
    		board[i][j-1] = '#';
    		flag = dfs(board, i, j-1, word.substring(1));
    		board[i][j-1] = a;
    		if(flag) return flag;
    	}
    	if(j<board[i].length-1 && a == board[i][j+1]) {
    		board[i][j+1] = '#';
    		flag = dfs(board, i, j+1, word.substring(1));
    		board[i][j+1] = a;
    		if(flag) return flag;
    	}
    	if(i<board.length-1 && a== board[i+1][j]) {
    		board[i+1][j] ='#';
    		flag = dfs(board, i+1, j, word.substring(1));
    		board[i+1][j] = a;
    	}
    	return flag;
    }
        
}
