import java.util.*;
  
  public class Main {
  
  	  // This is a functional problem. You have to complete this function.
  	  // It takes as input the given array. It should return true if the array is sorted, else should return false.
  	  public static boolean isSorted(int[] arr) {
  	  	  boolean flag = false;
  	  	  for (int i = arr.length - 1; i >= 1; i--) {
  	  	  	  if (arr[i] < arr[i - 1]) {
  	  	  	  	  flag = true;
  	  	  	  	  break;
  	  	  	  }
  	  	  }
  	  	  
  	  	  return !flag;
  
  	  }
  
  	  public static void main(String[] args) {
  	  	  Scanner sc = new Scanner(System.in);
  
  	  	  // taking input for given array
  	  	  int N = sc.nextInt();
  	  	  int[] arr = new int[N];
  	  	  for (int i = 0; i < arr.length; i++) {
  	  	  	  arr[i] = sc.nextInt();
  	  	  }
  
  	  	  if(isSorted(arr)){
  	  	  	  System.out.println("Yes");
  	  	  } else {
  	  	  	  System.out.println("No");
  	  	  }
  	  	  
  	  }
  
  	  // utility function to display an array.
  	  public static void display(int[] arr) {
  	  	  if(arr == null){
  	  	  	  return;
  	  	  }
  
  	  	  for(int i: arr){
  	  	  	  System.out.print(i + " ");
  	  	  }
  
  	  	  System.out.println();
  	  }
  
  
  }