package HashTable;

import java.util.HashMap;

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}
//以点为基准而不是以线，因为线无法存储和遍历。虽然共线的多个点最后会算很多重复的，但肯定比前面小
public class MaxPointsOnALine {
	public static int maxPoints(Point[] points) {
		int maxPoints = 0; 
		HashMap<Double, Integer> slopeMap = new HashMap<Double, Integer>();
		for(int i=0; i<points.length; i++) { 
			int samePointNum = 1; 
			int verticalPointNum = 0;
			int tempMaxPoints = 0;
			double k;
			for(int j=i+1; j<points.length; j++) {
				if(points[i].x == points[j].x && points[i].y == points[j].y) {
					samePointNum ++;
					continue;
				}

				if(points[i].x == points[j].x)
					verticalPointNum ++;
				else {
					if(points[j].y == points[i].y)
						k = 0.0;
					else 
						k = ((double)(points[j].y-points[i].y))/(points[j].x-points[i].x);
					if(slopeMap.containsKey(k)) {
						int n = slopeMap.get(k);
						n++;
						slopeMap.put(k, n);

						if(n > tempMaxPoints)
							tempMaxPoints = n;
					}
					else {
						if(tempMaxPoints == 0)
							tempMaxPoints = 1;
						slopeMap.put(k, 1);
					}


				}

			}
			slopeMap.clear();
			
			//
			if(verticalPointNum > tempMaxPoints) 
				tempMaxPoints = verticalPointNum;

			//
			tempMaxPoints += samePointNum;
			if(tempMaxPoints > maxPoints)
				maxPoints = tempMaxPoints;
		}

		return maxPoints;
	}
	
	public static void main(String[] args) {
		Point[] points = {new Point(2,3), new Point(3,3), new Point(-5,3)};
		System.out.println((double)(3-3)/(double)(-1));  //0/-1 == -0
		System.out.println((3-3)/-1);
 		System.out.println(maxPoints(points));
	}
}
