import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

    public static int solution(int[] arr) {
        int sum = 0, maxLen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == 0){
                arr[i] = -1;
            }
            sum += arr[i];
            if (sum == 0) {
                maxLen = i + 1;
            } else if (!map.containsKey(sum))
                map.put(sum, i);

            else {
                maxLen = Math.max(maxLen, i - map.get(sum));
            }
        }

        return maxLen;
    }

}