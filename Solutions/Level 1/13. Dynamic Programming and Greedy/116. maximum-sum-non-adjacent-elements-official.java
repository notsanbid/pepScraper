import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        long inc = arr[0] < 0 ? 0 : arr[0];
        long exc = 0;

        for (int i = 1; i < arr.length; i++) {
            long ninc = exc + arr[i];
            long nexc = Math.max(inc, exc);

            inc = ninc;
            exc = nexc;
        }

        System.out.println(Math.max(inc, exc));
    }
}