import java.util.*;
 
 public class Main {
 
 	 public static void main(String[] args) {
         Scanner scn= new Scanner(System.in);
         int n=scn.nextInt();
 	 	 List<List<Integer>> ans = getFactors(n);
 	 	 for (List<Integer> val : ans) {
 	 	 	 System.out.println(val);
 	 	 }
 	 }
 
 	 public static List<List<Integer>> getFactors(int n) {
 	 	 List<List<Integer>> ans = new ArrayList<>();
 	 	 if (n == 1) {
 	 	 	 return ans;
 	 	 }
 	 	 List<Integer> templist = new ArrayList<>();
 
 	 	 factors(n, ans, templist, n, 2);
 	 	 return ans;
 	 }
 
 	 private static void factors(int n, List<List<Integer>> ans, List<Integer> templist, int permn, int idx) {
 	 	 if (n == 1) {
 	 	 	 List<Integer> br = new ArrayList<>(templist);
 	 	 	 ans.add(br);
 	 	 	 return;
 	 	 }
 	 	 for (int i = idx; i <= n && i < permn; i++) {
 	 	 	 if (n % i == 0) {
 	 	 	 	 templist.add(i);
 	 	 	 	 factors(n / i, ans, templist, permn, i);
 	 	 	 	 templist.remove(templist.size() - 1);
 	 	 	 }
 	 	 }
 	 }
 }