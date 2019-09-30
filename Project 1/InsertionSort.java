class InsertionSort{
	private int[] arr;
	private int k;
	
	public InsertionSort(int[] a, int n){
		arr = a;
		k = n;
	}
	public run(){
		ISort(arr, k);
	}
	private int ISort(int arr[], int k) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			
			while(j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
			}
			arr[j + 1] = key;
		}
		return arr[k];
	}
}
