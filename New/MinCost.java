package New;

public class MinCost {
	public static class Point {
		public int x;
		public int y;
		public Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	

	public static int minCost(Point[] points) {
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
				int arc = Math.min(Math.abs(points[j].x-points[pointN].x), Math.abs(points[j].y-points[pointN].y));
				if(!pointsGet[j] && (min + arc < dis[j])) {
					dis[j] = min + arc;
				}
			}
		}
		return dis[points.length-1];
	}
	
	public static void main(String[] args) {
		Point A = new Point(2,2);
		Point B = new Point(1,7);
		Point C = new Point(7,6);
		Point[] points = new Point[3];
		points[0] = A;
		points[1] = B;
		points[2] = C;
		System.out.println(minCost(points));
		
	}
}
