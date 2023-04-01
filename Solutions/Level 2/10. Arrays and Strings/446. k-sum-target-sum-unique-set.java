import java.util.*;

public class Main {

  public static List<List<Integer>> twoSum(int[] arr, int si, int ei, int target) {
    List<List<Integer>> res = new ArrayList<>();
    int left = si;
    int right = ei;

    while (left < right) {
      if (left != si && arr[left] == arr[left - 1]) {
        left++;
        continue;
      }

      int sum = arr[left] + arr[right];
      if (sum == target) {
        List<Integer> list = new ArrayList<>();
        list.add(arr[left]);
        list.add(arr[right]);
        res.add(list);

        left++;
        right--;
      } else if (sum > target) {
        right--;
      } else {
        left++;
      }
    }

    return res;
  }

  public static List<List<Integer>> kSumHelper(int[] nums, int target, int k, int si) {
    if (k == 2) {
      return twoSum(nums, si, nums.length - 1, target);
    }
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    if (n < k) return res;
    // Arrays.sort(nums);
    for (int i = si; i <= n - k; i++) {
      if (i != si && nums[i] == nums[i - 1]) continue;

      int val = nums[i];
      int targ = target - val;
      List<List<Integer>> ans = kSumHelper(nums, targ, k - 1, i + 1);
      for (List<Integer> list : ans) {
        list.add(val);
        res.add(list);
      }
    }
    return res;
  }

  public static List<List<Integer>> kSum(int[] arr, int target, int k) {
    Arrays.sort(arr);
    return kSumHelper(arr, target, k, 0);
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    int k = scn.nextInt();
    List<List<Integer>> res = kSum(arr, target, k);
    ArrayList<String> finalResult = new ArrayList<>();
    for (List<Integer> list : res) {
      Collections.sort(list);
      String ans = "";
      for (int val : list) {
        ans += val + " ";
      }
      finalResult.add(ans);
    }
    Collections.sort(finalResult);
    for (String str : finalResult) {
      System.out.println(str);
    }
  }

}