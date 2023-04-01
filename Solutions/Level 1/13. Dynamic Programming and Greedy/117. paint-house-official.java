import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][3];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            String[] items = str.split(" ");
            arr[i][0] = Integer.parseInt(items[0]);
            arr[i][1] = Integer.parseInt(items[1]);
            arr[i][2] = Integer.parseInt(items[2]);
        }

        long red = arr[0][0];
        long blue = arr[0][1];
        long green = arr[0][2];

        for (int i = 1; i < arr.length; i++) {
            long nred = arr[i][0] + Math.min(blue, green);
            long nblue = arr[i][1] + Math.min(red, green);
            long ngreen = arr[i][2] + Math.min(red, blue);

            red = nred;
            blue = nblue;
            green = ngreen;
        }

        System.out.println(Math.min(red, Math.min(blue, green)));
    }
}