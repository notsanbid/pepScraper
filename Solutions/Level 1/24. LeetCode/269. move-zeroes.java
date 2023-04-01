import java.util.*;
 
 public class Main {
 
     // This is a functional problem. You have to complete this function.
     // It takes as input an integer array. It should move all the zeroes
     // to the end of the array.
     public static void moveZeroes(int[] nums) {
         int count = 0;
         for (int i = 0; i < nums.length; i++)
             count++;
 
         int i = 0;
         int k = 0;
 
         while (i < nums.length) {
             if (nums[i] != 0) {
                 nums[k] = nums[i];
                 k++;
             }
             i++;
         }
 
         while (k < nums.length) {
             nums[k] = 0;
             k++;
         }
     }
 
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         int N = sc.nextInt();
         int[] arr = new int[N];
 
         for (int i = 0; i < arr.length; i++) {
             arr[i] = sc.nextInt();
         }
 
         moveZeroes(arr);
         display(arr);
     }
 
     // function to display an array.
     public static void display(int[] arr) {
 
         for (int i = 0; i < arr.length; i++) {
             System.out.print(arr[i] + " ");
         }
 
         System.out.println();
     }
 }