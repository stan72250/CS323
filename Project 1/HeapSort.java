/*Authors: Stanley Lin & Yajie Zhang
* References (URLs): https://www.cs.wcupa.edu/rkline/ds/heaps.html, http://pages.cs.wisc.edu/~paton/readings/Old/fall01/HEAP-SORT, 
* https://rosettacode.org/wiki/Sorting_algorithms/Heapsort#J
*
*/
class HeapSort {
	private int[] arr;
	private int k;
	private static long count = 0;
	
	public HeapSort(int[] a, int n) {
		arr = a;
		k = n;
	}
	
	public void run(){
		count = 0;
		sort(arr);
		System.out.println("Median Element: " + kthElement());
		System.out.println("Number of Comparisons: " + numOfComparisons());
	}
	
	private void sort(int arr[]) {
		for(int i = arr.length / 2; i >=0; i--) {
			percolateDown(arr, i, arr.length);
		}
		for(int i = arr.length - 1; i > 0; i--) {
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			percolateDown(arr, 0, i);
		}
	}
	
	private static int leftChild(int i) {
		return 2 * i + 1;
	}
	
	private static void percolateDown(int[] arr, int i, int n) {
		int child, temp;
		
		for(temp = arr[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			if(child != n - 1 && arr[child] < arr[child + 1]) {
				child++;
				count++;
			}
			if(temp < arr[child]) {
				arr[i] = arr[child];
				count++;
			}
			else {
				break;
			}
		}
		arr[i] = temp;
	}
	
	private int kthElement() {
		return arr[k - 1];
	}
	
	private static long numOfComparisons(){
		return count;
	}
}
