//Authors: Stanley Lin & Yajie Zhang
/*References: https://www.baeldung.com/java-merge-sort
*/
class MergeSort {
	private int[] arr;
	private static long count = 0;
	private int k;
	
	public MergeSort(int[] a, int n){
		arr = a;
		k = n;
	}
	
	public void run() {
		count = 0;
		sort(arr, arr.length);
		//printArray(arr);
		System.out.println("Median Element: " + returnKthElement(k));
		System.out.println("Number of Comparisons: " + numOfComparisons());
		System.out.println();
	}
	
	private void sort(int[] a, int n) {
		if(n < 2) {
			return;
		}
		int mid = n / 2;
		int[] left = new int[mid];
		int[] right = new int[n - mid];
		
		for(int i = 0; i < mid; i++) {
			left[i] = a[i];
		}
		for(int i = mid; i < n; i++) {
			right[i - mid] = a[i];
		}
		sort(left, mid);
		sort(right, n - mid);
		merge(a, left, right, mid, n - mid);
 	}
			
	private void merge(int arr[], int[] l, int[] r, int left, int right) {
		int i = 0, j = 0, k = 0;
		while(i < left && j < right) {
			if(l[i] <= r[j]) {
				arr[k++] = l[i++];
			}
			else {
				arr[k++] = r[j++];
			}
		}
		count += k;
		while(i < left) {
			arr[k++] = l[i++];
		}
		while(j < right) {
			arr[k++] = r[j++];
		}
	}
	
	private static void printArray(int[] arr) {
		int n = arr.length;
		System.out.println("Sorted Array: ");
		for(int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private int returnKthElement(int k) {
		return arr[k - 1];
	}
	
	private static long numOfComparisons() {
		return count;
	}		
}
