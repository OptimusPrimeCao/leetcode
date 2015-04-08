import java.util.Arrays;
import java.util.Scanner;



public class Main {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while(in.hasNext()) {
			int n = in.nextInt();
			Point[] points = new Point[n];
			for(int i=0;i<=n-1;i++) {
				Point p = new Point(in.nextInt(),in.nextInt());
				points[i] = p;
			}
			
			System.out.println(minCost(points));
		}
	}
	public static int minCost(Point[] points) {
		int[][] arcs = new int[points.length][points.length];
		for(int i=0;i<points.length;i++) {
			for(int j=0;j<points.length;j++) {
				arcs[i][j] = Math.min(Math.abs(points[i].x-points[j].x), Math.abs(points[i].y-points[j].y));
			}
		}
		
		boolean[] pointsGet = new boolean[points.length];
		int[] dis = new int[points.length];
		for(int i=1;i<points.length;i++) {
			dis[i] = Math.min(Math.abs(points[i].x-points[0].x), Math.abs(points[i].y-points[0].y));
			pointsGet[i] = false;
		}
		pointsGet[0] = true;
		for(int i=1; i<points.length; i++) {
			int min = Integer.MAX_VALUE;
			int pointN = 0;
			for(int j=0;j<points.length;j++) {
				if(!pointsGet[j]) {
					if(dis[j] < min) {
						min = dis[j];
						pointN = j;
					}
				}
				pointsGet[pointN] = true;

			}
			for(int j=0; j<points.length; j++) {
				if(!pointsGet[j] && (min + arcs[j][pointN] < dis[j])) {
					dis[j] = min +  arcs[j][pointN];
				}
			}
		}
		return dis[points.length-1];
	}
	
	
	
	
	
	public static class Point {
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	
	public static int magicBox(int x, int y, int z, String str) {
		if(str == null || str.length()<=0)
			return 0;
		int rNum = 0;
		int yNum = 0;
		int bNum = 0;
		
		int dx = 0;
		int dy = 0;
		int dz = 0;
		
		int maxCount = 0;
		char cArr[] = str.toCharArray();
		
		int[] givenArr = new int[3];
		givenArr[0] = x;
		givenArr[1] = y;
		givenArr[2] = z;
		Arrays.sort(givenArr);
		
		int[] testArr = new int[3];
		
		for(int i=0;i<str.length();i++) {
			if(cArr[i] == 'R') {
				rNum ++;
				dx = Math.abs(rNum-yNum);
				dz = Math.abs(bNum-rNum);
			}else if(cArr[i] == 'Y') {
				yNum ++;
				dx = Math.abs(rNum-yNum);
				dy = Math.abs(yNum-bNum);
			}else if(cArr[i] == 'B') {
				bNum ++;
				dy = Math.abs(yNum-bNum);
				dz = Math.abs(bNum-rNum);
			}else {
				return -1;
			}
			
			testArr[0] = dx;
			testArr[1] = dy;
			testArr[2] = dz;
			Arrays.sort(testArr);
			
			if(testArr[0]==givenArr[0] && testArr[1]==givenArr[1] && testArr[2]==givenArr[2]) {
				maxCount = Math.max(maxCount, rNum+yNum+bNum);
				rNum = 0;
				yNum = 0;
				bNum = 0;
			}
			
		}
		
		maxCount = Math.max(maxCount, rNum+yNum+bNum);
		return maxCount;
	}
	
	
	
	

}
