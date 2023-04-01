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


  public static List<List<Integer>> threeSum(int[] nums, int si, int targ) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length - si < 3) {
      return res;
    }

    for (int i = si; i <= nums.length - 3; i++) {
      if (i != si && nums[i - 1] == nums[i]) continue;

      int val1 = nums[i];
      int target = targ - val1;
      List<List<Integer>> subRes = twoSum(nums, i + 1, nums.length - 1, target);

      for (List<Integer> val : subRes) {
        val.add(val1);
        res.add(val);
      }
    }
    return res;
  }


  public static List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;
    if (n < 4) return res;
    Arrays.sort(nums);
    for (int i = 0; i <= n - 4; i++) {
      if (i != 0 && nums[i] == nums[i - 1]) continue;

      int val = nums[i];
      int targ = target - val;
      List<List<Integer>> ans = threeSum(nums, i + 1, targ);
      for (List<Integer> list : ans) {
        list.add(val);
        res.add(list);
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    int target = scn.nextInt();
    List<List<Integer>> res = fourSum(arr, target);
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