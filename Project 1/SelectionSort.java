
class SelectionSort {
	private int[] arr;
	private int k;
	private static int count = 0;
	
	public SelectionSort(int[] a, int n){
		arr = a;
		k = n;
	}
	
	public void run() {
		SSort(arr, k);
		printArray(arr);
		System.out.println("Median Element: " + SSort(arr, k));
		System.out.println("Number of Comparisons: " + numOfComparisons());
	}
	
	private int SSort(int arr[], int k) {
		int n = arr.length;
		
		for(int i = 0; i < n - 1; i++) {
			int min_idx = i;
	
			for(int j = i + 1; j < n; j++) {
				if(arr[j] < arr[min_idx]) {
					min_idx = j;
					count++;
				}	
			}	
			
			int temp = arr[min_idx];
			arr[min_idx] = arr[i];
			arr[i] = temp;
										
		}
		return arr[k - 1];
	}
	
	private static void printArray(int[] arr) {
		int n = arr.length;
		System.out.println("Sorted Array: ");
		for(int i = 0; i < n; ++i) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	private static int numOfComparisons() {
		return count;
	}
}
