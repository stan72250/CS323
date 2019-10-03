/*Author(s): Stanley Lin, Yajie Zhang
 *References (URLs): https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/ 
 * */
import java.util.*;
class MedianOfMedians {
	private int[] arr;
	private int l;
	private int r;
	private int k;
	private static long count = 0;
	
	public MedianOfMedians(int[] a, int n) {
		arr = a;
		l = 0;
		r = a.length - 1;
		k = n;
	}
	
	public void run() {
		count = 0;
		System.out.println("Median Element: " + kthSmallest(arr, l, r, k));
		System.out.println("Number of Comparisons: " + numOfComparisons());
	}
	
	private static int findMedian(int[] a, int n) {
		Arrays.sort(a);
		return a[n/2];
	}
	
	private int kthSmallest(int[] a, int l, int r, int k) {
		if(k > 0 && k <= r - l + 1) {
			int n = r - l + 1;
			
			int i;
			
			int[] median = new int[(n + 4) / 5];
			for(i = 0; i < median.length - 1; i++) {
				median[i] = findMedian(Arrays.copyOfRange(a, 5 * i + l, 5 * i + l + 4), 5);
			}
			if(n % 5 == 0) {
				median[i] = findMedian(Arrays.copyOfRange(a, 5 * i + l, 5 * i + l + 4), 5);
			}
			else {
				median[i] = findMedian(Arrays.copyOfRange(a, 5 * i + l, 5 * i + l + (n % 5)), n % 5);
				i++;
			}
			
			int medOfMed = i == 1 ? median[i - 1]
					: kthSmallest(median, 0, i - 1, i / 2);
			
			int par = partition(a, l, r, medOfMed);
			
			if(par - l == k - 1) {
				return a[par];
			}
			
			if(par - l > k - 1) {
				return kthSmallest(a, l, par - 1, k);
			}
			return kthSmallest(a, par + 1, r, k - (par + 1) + l);
		}
		return Integer.MAX_VALUE;
	}
	
	private static void swap(int []arr, int i, int j) { 
	    int temp = arr[i]; 
	    arr[i] = arr[j]; 
	    arr[j] = temp; 	    
	} 
	  

	private static int partition(int arr[], int l, int r, int pivot) {      
	    for(int i = 0; i < arr.length; i++) {
	    	if(arr[i] == pivot) {
	    		count++;
	    		swap(arr, i, r);
	    		break;
	    	}
	    }
	    int index = l - 1;
	    int i = l;
	    while(i < r) {
	    	if(arr[i] < pivot) {
	    		count++;
	    		index++;
	    		swap(arr, i, index);
	    	}
	    	i++;
	    }
	    index++;
	    swap(arr, index, r);
	    return index; 
	} 
	
	private static long numOfComparisons() {
		return count;
	}
}
