
public class QuickSort {

	public static void main(String[] args) {
	      int[] a = {1,3,4,2,13,-312,-22,5,7,0,13,2};
	      QuickSort qs = new QuickSort();
	      qs.QSort(a, 0, a.length-1);
	      for(int i=0;i<a.length;i++) {
	         System.out.print(a[i]+"  ");
	      }
	}
	
    void QSort(int[] a, int low, int high) {
    	if(low < high) {
    	  int partition = getPartition(a, low, high);
    	  QSort(a, low, partition-1);
    	  QSort(a, partition+1, high);
    	}    	
    }
    
    int getPartition(int[] a, int low, int high) {
    	int key = a[low];
    	while(high > low) {
	    	while(a[high] >= key && high > low) 
	    		high--;
	        a[low] = a[high];
	    	
	    	while(a[low] <= key && high > low) 
	    		low++;
	    	a[high] = a[low];
    	}
    	a[high] = key;
    	return low;
    	
    	
    	
    }
}
