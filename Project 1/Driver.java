//CS323 Project 1
//Authors: Stanley Lin & Yajie Zhang

import java.util.*;

public class Driver{
  public static void main(String args[]){
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
  }
 
}
