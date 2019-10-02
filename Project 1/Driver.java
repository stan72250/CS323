//CS323 Project 1
//Authors: Stanley Lin & Yajie Zhang
import java.util.*;
import java.io.*;
public class Driver {
	public static void main(String args[]) throws NumberFormatException, IOException {
		int n;
		int k = 0;
		
		Random rand = new Random();
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter a number of integers: ");
		n = input.nextInt();
		int[] arr = new int[n];

		if(arr.length % 2 == 1) {
			k = (n + 1) / 2;
		}
		else if(arr.length % 2 == 0) {
			k = n / 2;
		}
		
		System.out.println();
		System.out.println();
		
		System.out.println("INSERTION SORT");
		for(int j = 0; j < 10; j++) {
			System.out.println("Iter " + (j + 1) + ": ");
			for(int i = 0; i < n; i++) {
				arr[i] = rand.nextInt(100000) + 1;
			}
			System.out.println("Unsorted Array: ");		
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}		
			System.out.println();
			InsertionSort is = new InsertionSort(arr, k);
			is.run();	
		}
		
		System.out.println("SELECTION SORT");
		for(int j = 0; j < 10; j++) {
			System.out.println("Iter " + (j + 1) + ": ");
			for(int i = 0; i < n; i++) {
				arr[i] = rand.nextInt(100000) + 1;
			}
			System.out.println("Unsorted Array: ");		
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			SelectionSort ss = new SelectionSort(arr, k);
			ss.run();
		}
		
		System.out.println("QUICK SELECT");
		for(int j = 0; j < 10; j++) {
			System.out.println("Iter " + (j + 1) + ": ");
			for(int i = 0; i < n; i++) {
				arr[i] = rand.nextInt(100000) + 1;
			}
			System.out.println("Array Input: ");
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			QuickSelect qs = new QuickSelect(arr, k);
			qs.run();
		}
		
		System.out.println("MERGE SORT");
		for(int j = 0; j < 10; j++) {
			System.out.println("Iter " + (j + 1) + ": ");
			for(int i = 0; i < n; i++) {
				arr[i] = rand.nextInt(100000) + 1;
			}
			System.out.println("Unsorted Array: ");
			for(int i = 0; i < arr.length; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			MergeSort ms = new MergeSort(arr, k);
			ms.run();
		}		
	}		
}

