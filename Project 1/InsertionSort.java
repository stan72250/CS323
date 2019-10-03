//Authors: Stanley Lin & Yajie Zhang
/*References (URLs): https://www.geeksforgeeks.org/insertion-sort/
*
*/
class InsertionSort{
	private int[] arr;
	private int k;
	private static long count = 0;
	
	public InsertionSort(int[] a, int n){
		arr = a;
		k = n;
	}
	public void run(){
		count = 0;
		ISort(arr, k);
		//printArray(arr);
		System.out.println("Median Element: " + ISort(arr, k));
		System.out.println("Number of Comparisons: " + numOfComparisons());
	}
	private int ISort(int arr[], int k) {
		long comparisons = 0;
		int n = arr.length;
		for (int i = 1; i < n; i++) {
			int j = i;
			
			while(j > 0 && arr[j] < arr[j - 1]) {				
				int temp = arr[j];
				arr[j] = arr[j - 1];
				arr[j - 1] = temp;
				comparisons++;
				j--;
			}
			comparisons++;
		}
		count += comparisons;
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
	private static long numOfComparisons(){
		return count;
	}
}
