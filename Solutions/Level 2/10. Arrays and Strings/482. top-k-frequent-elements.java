import java.util.*;
 
 public class Main {
 
 	 public static class pair implements Comparable<pair> {
 	 	 public int val;
 	 	 public int count;
 
 	 	 public pair(int val, int count) {
 	 	 	 this.val = val;
 	 	 	 this.count = count;
 	 	 }
 
 	 	 @Override
 	 	 public int compareTo(pair o) {
 	 	 	 // TODO Auto-generated method stub
 	 	 	 return o.count - this.count;
 	 	 }
 
 	 }
 
 	 public static ArrayList<Integer> topKFrequent(int n, int[] nums, int k) {
 
 	 	 ArrayList<Integer> ans = new ArrayList<>();
 
 	 	 HashMap<Integer, Integer> map = new HashMap<>();
 	 	 PriorityQueue<pair> pq = new PriorityQueue<>();
 
 	 	 for (int i = 0; i < nums.length; i++) {
 	 	 	 if (map.containsKey(nums[i])) {
 	 	 	 	 map.put(nums[i], map.get(nums[i]) + 1);
 	 	 	 } else {
 	 	 	 	 map.put(nums[i], 1);
 	 	 	 }
 	 	 }
 
 	 	 for (int val : map.keySet()) {
 	 	 	 pq.add(new pair(val, map.get(val)));
 	 	 }
 
 	 	 for (int i = 0; i < k; i++) {
 	 	 	 ans.add(pq.remove().val);
 	 	 }
 
 	 	 return ans;
 
 	 }
 
 	 public static void main(String[] args) {
 
 	 	 Scanner s = new Scanner(System.in);
 	 	 int n = s.nextInt();
 	 	 int[] ar = new int[n];
 	 	 for (int i = 0; i < ar.length; i++) {
 	 	 	 ar[i] = s.nextInt();
 	 	 }
 	 	 int k = s.nextInt();
 	 	 ArrayList<Integer> res = topKFrequent(n, ar, k);
 	 	 Collections.sort(res);
 	 	 System.out.println(res);
 	 }
 
 }