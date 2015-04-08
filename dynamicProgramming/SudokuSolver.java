package dynamicProgramming;

public class SudokuSolver {
	boolean[][] rowFlag ;
	boolean[][] colFlag ;
	boolean[][] blockFlag ;
	public void solveSudoku(char[][] board) {
		if(board == null || board.length == 0)
			return;
		rowFlag = new boolean[board.length][board.length];
		colFlag = new boolean[board.length][board.length];
		blockFlag = new boolean[board.length][board.length];
		for(int i=0;i<board.length;i++) 
			for(int j=0;j<board.length;j++) 
				if(board[i][j] != '.') {
					int k = board[i][j] - '0';
					rowFlag[i][k-1] = true;
					colFlag[j][k-1] = true;
					blockFlag[i-i%3+j/3][k-1] = true;  
				}
		dfs(board,0,0);
	}
	
	
	
	public boolean dfs(char[][] board, int row, int col) {
		if(row == board.length)
			return true;
		int nextRow,nextCol;
		if(col == board.length-1) {
			nextRow = row+1;
			nextCol = 0;
		}
		else {
			nextRow = row;
			nextCol = col+1;
		}
		if(board[row][col] == '.') {
			for(int k=1;k<=9;k++) {
				if(isValid(row,col,k)) {
					rowFlag[row][k-1] = true;
					colFlag[col][k-1] = true;
					blockFlag[row-row%3+col/3][k-1] = true;            
					board[row][col] = (char)('0'+k);
					if(dfs(board,nextRow,nextCol))
						return true;
					rowFlag[row][k-1] = false;
					colFlag[col][k-1] = false;
					blockFlag[row-row%3+col/3][k-1] = false;   
					board[row][col] = '.';
				}	
			}
			return false;
		}
		else 
			return dfs(board,nextRow,nextCol);

	}
	public boolean isValid(int row, int col, int k) {
		return !rowFlag[row][k-1] && !colFlag[col][k-1] && !blockFlag[row-row%3+col/3][k-1];
	}

}
