import java.util.*;

public class Main{
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int[] lastOccurence = new int[26];
        Arrays.fill(lastOccurence, -1);
        long[] dp = new long[str.length() + 1];
        dp[0] = 1;

        for(int i = 1; i <= str.length(); i++){
                dp[i] = 2 * dp[i - 1];
            if(lastOccurence[str.charAt(i - 1) - 'a'] != -1){
                dp[i] -= dp[lastOccurence[str.charAt(i - 1) - 'a']];
            }
            lastOccurence[str.charAt(i - 1) - 'a'] = (i - 1);
        }
        System.out.println((dp[str.length()] - 1));
    }
}