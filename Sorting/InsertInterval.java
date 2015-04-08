package Sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//使用mergeInterval中的方法，完全一样

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
	public String toString() {
		return "[" + start + "," + end + "]";
	}
}
public class InsertInterval {
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		intervals.add(newInterval);
		return merge(intervals);
	}
	
	public List<Interval> merge(List<Interval> intervals) {
		if(intervals == null || intervals.size() <= 1)
			return intervals;
		int n = intervals.size();
		Collections.sort(intervals, new IntervalComParator());
		System.out.println(intervals);
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
		List<Interval> input = new ArrayList<Interval>();
		input.add(new Interval(1,3));
		input.add(new Interval(4,5));
		InsertInterval test = new InsertInterval();
		List<Interval> result = test.insert(input, new Interval(1,2));
		System.out.println(result);
		
	}
}
