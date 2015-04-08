package twoPointers;

public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		int maxArea = 0;
		int curArea = 0;
		int i = 0;
		int j = height.length - 1;
		while(i < j) {
			curArea =  Math.min(height[j],height[i]) * (j-i);
			maxArea = Math.max(maxArea, curArea);
			if(height[j] > height[i])
				i++;
			else
				j--;
		}
		return maxArea;
	}
}
