import java.util.*;

class MedianOfMedians {
  private int[] arr;
  private int k;
  
  public MedianOfMedians(int[] a, int n){
    arr = a;
    k = n;
  }
  
  public void findMedian(){
    
  }
  
  private static int partition(int[] arr, int l, int r) {
		int x = arr[r], i = l;
		for(int j = l; j <= r - 1; j++) {
			if(arr[j] <= x) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
			}
		}
		int temp = arr[i];
		arr[i] = arr[r];
		arr[r] = temp;
		
		return i;
	}
}
