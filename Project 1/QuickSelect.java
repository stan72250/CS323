//Authors: Stanley Lin & Yajie Zhang
//References: https://www.geeksforgeeks.org/quickselect-algorithm/
import java.util.*;
class QuickSelect {
	private int[] arr;
	private int l;
	private int r;
	private int k;
	private static long count = 0;
	
	public QuickSelect(int[] a, int n){
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
	private int partition(int[] arr, int l, int r) {
		int x = arr[r], i = l;
		for(int j = l; j <= r - 1; j++) {
			if(arr[j] <= x) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
			count++;
		}
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;
		return i;
	}
	
	private int kthSmallest(int[] arr, int l, int r, int k) {
		if(k > 0 && k <= r - l + 1) {
			int index = partition(arr, l, r);
			
			if(index - l == k - 1) {
				return arr[index];
			}
			
			else if(index - l > k - 1) {
				return kthSmallest(arr, l, index - 1, k);
			}
			
			else {
				return kthSmallest(arr, index + 1, r, k - index + l - 1);
			}
		}
		return Integer.MAX_VALUE;
	}

	private static long numOfComparisons() {
		return count;
	}
}
