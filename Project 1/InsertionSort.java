class InsertionSort{
	private int[] arr;
	private int k;
	private int count = 0;
	
	public InsertionSort(int[] a, int n){
		arr = a;
		k = n;
	}
	public void run(){
		ISort(arr, k);
		printArray(arr);
		System.out.println("Median Element: " + ISort(arr, k));
		System.out.println("Number of Comparisons: " + numOfComparisons());
	}
	private int ISort(int arr[], int k) {
		int n = arr.length;
		for (int i = 1; i < n; ++i) {
			int key = arr[i];
			int j = i - 1;
			
			while(j >= 0 && arr[j] > key) {
				arr[j + 1] = arr[j];
				j = j - 1;
				count++;
			}
			arr[j + 1] = key;
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
	private int numOfComparisons(){
		return count;
	}
}
