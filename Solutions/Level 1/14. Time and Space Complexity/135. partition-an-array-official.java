import java.io.*;
import java.util.*;

public class Main {

  public static void partition(int[] arr, int pivot) {
    // 0 to j-1  ->  all elements are equal and smaller than pivot 
    // j to i-1  ->  all elements are greater than pivot
    // i to arr.length-1  ->  unknown elements
    
    int i = 0, j = 0;
    while (i < arr.length) {
      if (arr[i] <= pivot) {
        swap(arr, i, j);
        i++;
        j++;
      }else {
        i++;
      }
    }
  }

  // used for swapping ith and jth elements of array
  public static void swap(int[] arr, int i, int j) {
    System.out.println("Swapping " + arr[i] + " and " + arr[j]);
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int pivot = scn.nextInt();
    partition(arr, pivot);
    print(arr);
  }

}