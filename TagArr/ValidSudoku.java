package TagArr;

public class ValidSudoku {
	public boolean isValidSudoku(char[][] board) {
		boolean[][] row = new boolean[9][9];
		boolean[][] col = new boolean[9][9];
		boolean[][] block = new boolean[9][9];
		
		
		int rowLen = board.length;
		int colLen = board[0].length;
		for(int i=0;i<rowLen;i++) { 
			for(int j=0;j<colLen;j++) {
				if(board[i][j] == '.')
					continue;
				
				int n = board[i][j] - '1';
				if(row[i][n] || col[j][n] || block[i-i%3+j/3][n])
					return false;
				
				row[i][n] = col[j][n] = block[i-i%3+j/3][n] =  true;
			}
		}
		
		return true;
		
		
	}
	
	public static void main(String[] args) {
		int a;
		int b;
		//赋值从右向左，表达式值为右边的值
		System.out.println(a =b=2);
	}
}
