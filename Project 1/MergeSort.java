//Modification of Merge sort algorithm, merges only elements 1 to k.
class MergeSort {
	private int[] arr;
	private int l;
	private int r;
	MergeSort(int[] a){
		arr = a;
		l = 0;
		r = arr.length - 1;
	}
	public void sort() {
		mergeSort(arr, l, r);
	}
	
	private void mergeSort(int[] a, int l, int r) {
		if(l < r) {
			int m = (l + r) / 2;
			
			mergeSort(a, l, m);
			mergeSort(a, m + 1, r);
			merge(a, l, m, r);
		}
	
 	}
			
	private void merge(int arr[], int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int L[] = new int [n1];
		int R[] = new int [n2];
		
		for(int i = 0; i < n1; ++i) {
			L[i] = arr[l + i];
		}
		for(int j = 0; j < n2; ++j) {
			R[j] = arr[m + 1 + j];
		}
		
		// Initial indexes of first and second subarrays 
        int i = 0, j = 0; 
  
        // Initial index of merged subarray array 
        int k = l; 
        while (i < n1 && j < n2) 
        { 
            if (L[i] <= R[j]) 
            { 
                arr[k] = L[i]; 
                i++; 
            } 
            else
            { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
  
        /* Copy remaining elements of L[] if any */
        while (i < n1) 
        { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
  
        /* Copy remaining elements of R[] if any */
        while (j < n2) 
        { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
	}
	
	//Utility class to print sorted Array
	void printArray() {
			int n = arr.length;
			for(int i = 0; i < n; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
	}
		
}
