
class SelectionSort {
	private int[] arr;
	private int k;
	
	public SelectionSort(int[] a, int n){
		arr = a;
		k = n;
	}
	
	public void run() {
		SSort(arr, k);
	}
	
	private int SSort(int arr[], int k) {
		int n = arr.length;
		
		for(int i = 1; i <= k; i++) {
			int min_idx = i;
			int min_value = arr[i];
			for(int j = i + 1; j < n; j++) {
				if(arr[j] < arr[min_idx]) {
					min_idx = j;
					min_value = arr[j];
					int temp = arr[min_idx];
					arr[min_idx] = arr[i];
					arr[i] = temp;
				}
			}			
		}
		return arr[k];
	}
}
