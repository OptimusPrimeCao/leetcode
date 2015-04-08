package greedy;

public class Candy {
//左右遍历两次，可求出每个孩子分到的糖果，需要O(n)空间
//只求总数，可以用一下修正法 http://www.cnblogs.com/felixfang/p/3620086.html
	
	
	public int candy(int[] ratings) {
		int length = 0;
		int total = 1;
		int beforeDesc = 1;
		int preCanCount = 1;
		
		for(int i=1; i<ratings.length; i++) {
			if(ratings[i] < ratings[i-1]) {
				length ++;
				if(beforeDesc <= length) {
					total++;
				}
				total += length;
				preCanCount = 1;
			}
			else {
				int curCanCount = 1;
				if(ratings[i] > ratings[i-1]) {
					curCanCount = preCanCount + 1;
				}
				preCanCount = curCanCount;
				beforeDesc = curCanCount;
				length = 0;
				total += curCanCount;
			}
		}
		return total;
		
	}
	
	
	
	public int candy2(int[] ratings) {
		int curCans = 0;
		int preCans = 0;
		int sum = 0;
		int preTop = 0;
		int length = 0;
		for(int i=0;i<ratings.length-1;i++) {
			if(ratings[i] <= ratings[i+1]) {
				if(ratings[i] == ratings[i+1])
					curCans = 0;
				else
					curCans = preCans + 1;
				sum += curCans;
				preCans = curCans;
				preTop = curCans;
				length = 0;
			}
			else {
				sum += length;
				length++;
				if(length > preTop) {
					sum ++;
				}
				preCans = 0;
			}
			
		}
		
		return sum + ratings.length ;
	
	
	
	
	
	}

}
