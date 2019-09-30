import java.util.*;
class QuickSelect {
	private int[] arr;
	private int k;
	private static int count = 0;
	
	public QuickSelect(int[] a, int n){
		arr = a;
		k = n;
	}
	
	public void run() {
		System.out.println(kthSmallest(arr, k));
		System.out.println("Number of Comparisons: " + numOfComparisons());
	}
	
	private int kthSmallest(int[] arr, int k) {
		int l = 0;
		int r = arr.length - 1;
		
		while(l < r){
			int pivot = (l + r) / 2;
			int pivotValue = arr[pivot];
			int storage = l;
			
			arr[pivot] = arr[r];
			arr[r] = pivotValue;
			for(int i = l; i < r; i++) {
				if(arr[i] < pivotValue) {
					int temp = arr[storage];
					arr[storage] = arr[i];
					arr[i] = temp;
					storage++;
					count++;
				}
			}
			arr[r] = arr[storage];
			arr[storage] = pivotValue;
			
			if(storage < k) {
				l = storage + 1;
			}
			else {
				r = storage;
			}
		}
		return arr[k - 1];
	}
	
	private static int numOfComparisons() {
		return count;
	}
}
