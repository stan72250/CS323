//CS323 Project 1
//Authors: Stanley Lin & Yajie Zhang

import java.util.*;
import java.io.*;

public class Driver{
  public static void main(String args[]) throws NumberFormatException, IOException{
    int n;
    int k = 0;
    
    Random rand = new Random();
    Scanner input = new Scanner(System.in);
    
    System.out.print("Enter a number of integers to generate: ");
    n = input.nextInt();
    int[] arr = new int[n];
    
    if(arr.length % 2 == 1){
      k = (n + 1) / 2;
    }
    else if(arr.length % 2 == 0){
      k = n / 2;
    }
    
    System.out.println();
    for(int i = 0;i < n; i++){
      arr[i] = rand.nextInt(100) + 1;
    }
    
    System.out.println("Unsorted Integers: ");
    for(int i = 0; i < arr.length; i++){
      System.out.print(arr[i] + " ");
    }
    System.out.println();
    System.out.println();
    
    int choice = 0;
    
    System.out.println("Select algorithm to find median:\n" +
                       "1) Insertion Sort\n" +
                       "2) Merge Sort\n" +
                       "3) Selection Sort\n" +
                       "4) Heap Sort\n" +
                       "5) Quick Select\n" +
                       "6) Median of Medians\n" +
                       "7) End Program\n");
    while(choice != 7){
      try{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        choice = Integer.parseInt(br.readLine());
        
        switch(choice){
          case 1:
            InsertionSort is = new InsertionSort(arr, k);
            is.run();
            break;
          case 2:
            
            break;
          case 3:
            SelectionSort ss = new SelectionSort(arr, k);
            ss.run();
            break;
          case 4:
            
            break;
          case 5:
            QuickSelect qs = new QuickSelect(arr, k);
            qs.run();
            break;
          case 6:
            break;
          case 7:
            break;
        }              
      }
      catch(NumberFormatException e){
        System.out.println("Invalid input");
      }
    
  }
 
}
