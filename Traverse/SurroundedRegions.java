package Traverse;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SurroundedRegions {
	static boolean IsSurrounded;
	static boolean[][] visited;
	public static void solve(char[][] board) {
		if(board == null || board.length == 0)
			return;
		
		for(int i=0;i<board.length;i++) {
			if(board[i][0]=='O')
				dfsSearch(i, 0, board);
		}
		for(int i=0;i<board.length;i++) {
			if(board[i][board[0].length-1]=='O')
				dfsSearch(i, board[0].length-1, board);
		}
		for(int j=0;j<board[0].length;j++) {
			if(board[0][j]=='O')
				dfsSearch(0, j, board);
		}
		for(int j=0;j<board[0].length;j++) {
			if(board[board.length-1][j]=='O')
				dfsSearch(board.length-1, j, board);
		}
		
		
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='E') {
					board[i][j] = 'O';
				}else if(board[i][j]=='O')
					board[i][j] = 'X';
			}
		}
	
	}

	public static void dfsSearch(int row, int col, char[][] board) {
		if(row==board.length || col == board[0].length || row==-1 || col==-1) 
			return;
		if(board[row][col] == 'O') {
			board[row][col] = 'E';
			dfsSearch(row-1,col,board);
			dfsSearch(row,col-1,board);
			dfsSearch(row+1,col,board);
			dfsSearch(row,col+1,board);
		}
			
	}
	public static void Bfssolve(char[][] board) {
		Queue<Integer> queue = new LinkedList<Integer>();
	    if (board == null || board.length == 0)
	      return;
	    int m = board.length;
	    int n = board[0].length;
	    boolean visited[][] = new boolean[m][n];
	    int dir[][] = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	    for (int i = 0; i < m; i++) {
	      for (int j = 0; j < n; j++) {

	        //以下是标准的BFS搜索，用visitedPoints记录访问的O
	        if (board[i][j] == 'O' && !visited[i][j]) {
	          boolean surounned = true;
	          List<Integer> visitedPoints = new ArrayList<Integer>();
	          queue.add(i * n + j);
	          visited[i][j] = true;
	          while (queue.size() > 0) {
	            int point = queue.poll();
	            visitedPoints.add(point);
	            int x = point/n;
	            int y = point%n;
	            for (int k = 0; k < 4; k++) {
	            	int nextx = x + dir[k][0];
	            	int nexty = y + dir[k][1];
	            	if (nextx >= 0 && nextx < m && nexty >= 0 && nexty < n) {
	            		if (board[nextx][nexty] == 'O' && !visited[nextx][nexty]) {
	            			queue.add(nextx * n + nexty);
	            			visited[nextx][nexty] = true;
	            		}
	            	} else {
	            		surounned = false;
	            	}
	            }
	          }

	          //如果当前遍历到的O是被包围的
	          if (surounned) {
	        	  for (int p : visitedPoints)
	        		  board[p / n][p % n] = 'X';
	          }
	        }
	      }
	    }
	}
//	public static void dfsFlip(int row, int col, char[][] board) {
//		board[row][col] = 'X';
//		
//		if(board[row-1][col]=='0')
//			dfsFlip(row-1,col,board);
//		if(board[row][col-1]=='0')
//			dfsFlip(row,col-1,board);
//		if(board[row+1][col]=='0')
//			dfsFlip(row+1,col,board);
//		if(board[row][col+1]=='0')
//			dfsFlip(row,col+1,board);
//	}
	
	public static void main(String[] args) {
		char[][] board = {{'0','0','0','0','X','X'},{'0','0','0','0','0','0'},{'0','X','0','X','0','0'},{'0','X','0','0','X','0'},{'0','X','0','X','0','0'},{'0','X','0','0','0','0'}};
		solve(board);
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}



}
