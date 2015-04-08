
public class HeapSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		  int[] a = {1,3,4,2,13,-312,-22,-5,7,0,123,2};
	      HeapSort hs = new HeapSort();
	      hs.heapSort(a);
	      for(int i=0;i<a.length;i++) {
	         System.out.print(a[i]+"  ");
	      }

	}
    
	void heapAdjust(int[] heap, int s, int m) {
		int key = heap[s];
		int j;
		/**
		 * 
		 * 0为根节点的时候j=2*s+1；
		 */
	
		for (j = 2*s+1; j <= m; j = 2*j+1) {
			if(j < m && heap[j] < heap[j+1]) 
				j++;
			if(key >= heap[j]) 
			   {break;}
			heap[s] = heap[j];
			s = j;
			
			
		}
		heap[s] = key;
	}
	
	void heapSort(int[] heap) {
		int temp;
		for(int i=(heap.length-2)/2; i >= 0; i--) {             // 根为0时k节点的父节点时(k-1)/2
			heapAdjust(heap, i ,heap.length-1);
		}
		for(int i=heap.length-1; i > 0; i--) {
			temp = heap[i];
			heap[i] = heap[0];
			heap[0] = temp;
			heapAdjust(heap, 0 ,i-1);
		}
	}
}
