import java.util.Scanner;
 
 public class Main {
 
 	 public static int max(int[] nums) {
 	 	 if(nums==null || nums.length==0) return 0;
         int max=nums[0], min=nums[0], res=nums[0];
         for(int i=1;i<nums.length;i++){
             int tmp=max;
             max=Math.max(Math.max(nums[i]*max,nums[i]*min), nums[i]);
             min=Math.min(Math.min(nums[i]*tmp,nums[i]*min), nums[i]);
             res=Math.max(res,max);
         }
         return res;
 	 }
 
 	 public static void main(String[] args) {
 
 	 	 Scanner s = new Scanner(System.in);
 	 	 int n = s.nextInt();
 	 	 int[] a = new int[n];
 	 	 for (int i = 0; i < a.length; i++) {
 	 	 	 a[i] = s.nextInt();
 	 	 }
 	 	 System.out.println(max(a));
 
 	 }
 
 }