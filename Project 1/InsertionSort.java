class InsertionSort{
	private int[] arr;
	private int k;
	private static int count = 0;
	
	public InsertionSort(int[] a, int n){
		arr = a;
		k = n;
	}
	public run(){
		System.out.println(ISort(arr, k));
		System.out.println(numOfComparisons);
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
	private static int numOfComparisons(){
		return count;
	}
}
