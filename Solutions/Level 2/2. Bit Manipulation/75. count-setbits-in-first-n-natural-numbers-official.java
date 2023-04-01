import java.util.*;
import java.io.*;

    public class Main {

        public static void main(String[] args) {
            Scanner scn = new Scanner(System.in);
            int n = scn.nextInt();
            System.out.println(solution(n));

        }

        public static int solution(int n) {
            if (n == 0) {
                return 0;
            }

            int x = largestPowerOf2inrange(n);
            int btill2x = x * (1 << (x - 1));
            int msb2xton = n - (1 << x) + 1;
            int rest = n - (1 << x);
            int ans = btill2x + msb2xton + solution(rest);
            return ans;

        }

        public static int largestPowerOf2inrange(int n) {
            int x = 0;

            while ((1 << x) <= n) {
                x++;
            }

            return x - 1;
        }
    }