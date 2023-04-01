import java.util.*;

public class Main {
    public static ArrayList<ArrayList<Integer>> fourSum(int[] nums, int target, int n) {
		HashSet<ArrayList<Integer>> s = new HashSet<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			for (int j = i + 1; j < nums.length - 2; j++) {
				int left = j + 1;
				int right = nums.length - 1;
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						ArrayList<Integer> tmp = new ArrayList<>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[left]);
						tmp.add(nums[right]);
						s.add(tmp);
						left++;
						right--;
					} else if (sum < target) {
						left++;
					} else {
						right--;
					}
				}
			}
		}
		ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
		for (ArrayList<Integer> i : s) {
			ret.add(i);
		}
		return ret;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int target = sc.nextInt();
		ArrayList<ArrayList<Integer>> ans = fourSum(arr, target, n);
		Collections.sort(ans, new Comparator<ArrayList<Integer>> () {
			@Override
			public int compare(ArrayList<Integer> a, ArrayList<Integer> b) {
				int i = 0, j = 0;
				while(i < a.size() && j < b.size() && a.get(i) == b.get(j)){
					i++;
					j++;
				}
				return a.get(i).compareTo(b.get(j));
			}
		});
		for (ArrayList<Integer> a : ans) {
			for (int element : a) {
				System.out.print(element + " ");
			}
			System.out.println();
		}
	}

}