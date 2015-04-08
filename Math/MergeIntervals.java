package Math;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		//对集合用api的排序方法，否则还得转成数组
		
		if(intervals == null || intervals.size() <= 1)
			return intervals;
		int n = intervals.size();
		Collections.sort(intervals, new IntervalComParator());
		
		Interval temp = intervals.get(0);
		List<Interval> result = new ArrayList<Interval>();
		
		for(int i=1; i<n;i++) {
			Interval test = intervals.get(i);
			if(test.start <= temp.end) {
				temp.end = Math.max(test.end, temp.end);
			}else {
				result.add(temp);
				temp = test;
			}
		}
		result.add(temp);
		return result;
	}
	
	private class IntervalComParator implements Comparator<Interval> {
		@Override
		public int compare(Interval o1, Interval o2) {
			if(o1.start < o2.start)
				return -1;
			else if(o1.start >o2.start)
				return 1;
			return 0;
		}
		
		
	}
	
	public static void main(String[] args) {
		String s = "ab";
		List<String> ss = new ArrayList<String>();
		ss.add(s);
		s = "a";
		System.out.println(ss.get(0));
	}
}


