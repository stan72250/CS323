import java.util.*;
class QuickSelect {
	private int[] arr;
	private int l;
	private int r;
	private int k;
	
	public QuickSelect(int[] a, int n){
		arr = a;
		l = 0;
		r = arr.length - 1;
		k = n;
	}
	
	public void run() {
		kthSmallest(arr, l, r, k);
	}
	
	private static int partition(int[] arr, int l, int r) {
		int x = arr[r], i = l;
		for(int j = l; j <= r - 1; j++) {
			if(arr[j] <= x) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;
		
		return i;
	}
	
	private static int kthSmallest(int[] arr, int l, int r, int k) {
		if(k > 0 && k <= r - 1 + 1) {
			int pos = partition(arr, l, r);
			
			if(pos - 1 == k - 1) {
				return arr[pos];
			}
			
			if(pos - 1 > k - 1) {
				return kthSmallest(arr, l, pos - 1, k);
			}
			
			return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
		}
		
		return Integer.MAX_VALUE;
	}
}
