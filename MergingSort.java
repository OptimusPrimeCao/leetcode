
public class MergingSort {

	/**
	 * @param args
	 */
	int[] a = new int[100];
	
	public static void main(String[] args) {
		  int[] b = {1,3,4,2,13,-312,-22,-5,7,0,123,2};
	      MergingSort ms = new MergingSort();
	      ms.mergingSort(b, 0, b.length-1);
	      for(int i=0;i<b.length;i++) {
	         System.out.print(b[i]+"  ");
	      }

	}
    void merge(int[] s, int i, int m, int n) {
    	int k,j;
    	int initial_pos = i;             //¼ÇÂ¼³õÊ¼Î»ÖÃ
    	for(k=i, j=m+1; i<=m && j<=n;k++) {
    		if(s[i] < s[j]) {
    			a[k] = s[i++];
    		}
    		else
    			a[k] = s[j++];
    	}
    	if(i <= m) {
    		for(int t=0; t<=m-i; t++) {
    			a[k+t] = s[i+t];
    		}
    	}
        if(j <= n) {
        	for(int t=0; t<=n-j; t++) {
        		a[k+t] = s[j+t];
        	}
        }
        
        for(k=initial_pos ; k<=n; k++) {
        	s[k] = a[k];
        }
    }
    void mergingSort(int[] s, int i, int n) {
    	if(n > i) {
    		int m = (i + n) /2;
    		mergingSort(s, i, m);
    		mergingSort(s, m+1, n);
    		merge(s, i, m, n);
    	}
    }
    
}
