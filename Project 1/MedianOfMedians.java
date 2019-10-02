/*Author(s): Stanley Lin, Yajie Zhang
 *References (URLs): https://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/ 
 * */
import java.util.*;
class MedianOfMedians {
	private int[] arr;
	private int l;
	private int r;
	private int k;
	private int count = 0;
	
	public MedianOfMedians(int[] a, int n) {
		arr = a;
		k = n;
		l = 0;
		r = arr.length - 1;
		
	}
	
	public void run() {
		System.out.println("Median Element: " + kthSmallest(arr, l, r, k));
		System.out.println("Number of Comparisons: " + numOfComparisons());
	}
	
	private int findMedian(int[] a, int i, int n) {
		if(i <= n) {
			Arrays.sort(a, i, n);
		}
		else {
			Arrays.sort(a, n, i);
		}
		return a[n/2];
	}
	
	private int kthSmallest(int[] a, int l, int r, int k) {
		if(k > 0 && k <= r - l + 1) {
			int n = r - l + 1;
			
			int i;
			
			int[] median = new int[(n + 4) / 5];
			for(i = 0; i < n / 5; i++) {
				median[i] = findMedian(a, l + i * 5, 5);
			}
			if(i * 5 < n) {
				median[i] = findMedian(a, l + i * 5, n % 5);
				i++;
			}
			
			int medOfMed = (i == 1)? median[i - 1]:
								kthSmallest(median, 0, i - 1, i / 2);
			
			int pos = partition(a, l, r, medOfMed);
			
			if(pos - l == k - 1) {
				count++;
				return a[pos];
			}
			if(pos - l > k - 1) {
				count++;
				return kthSmallest(a, l , pos - 1, k);
			}
			count++;
		return kthSmallest(a, pos + 1, r, k - pos + l - 1);
		}
		return Integer.MAX_VALUE;
	}
	
	private static int[] swap(int []arr, int i, int j) { 
	    int temp = arr[i]; 
	    arr[i] = arr[j]; 
	    arr[j] = temp; 
	    return arr; 
	} 
	  
	// It searches for x in arr[l..r], and  
	// partitions the array around x. 
	private int partition(int arr[], int l, int r, int x) { 
	    // Search for x in arr[l..r] and move it to end 
	    int i; 
	    for (i = l; i < r; i++) 
	        if (arr[i] == x) 
	        break; 
	    swap(arr, i, r); 
	  
	    // Standard partition algorithm 
	    i = l; 
	    for (int j = l; j <= r - 1; j++) 
	    { 
	        if (arr[j] <= x) 
	        { 
	            swap(arr, i, j); 
	            i++; 
	        } 
	    } 
	    swap(arr, i, r); 
	    return i; 
	} 
	
	private int numOfComparisons() {
		return count;
	}
}
