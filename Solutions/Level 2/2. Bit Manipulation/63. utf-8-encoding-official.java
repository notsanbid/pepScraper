import java.io.*;
import java.util.*;

public class Main {

    public static boolean solution(int[] arr) {
        int count = 0;
        for (int val : arr) {
            if (count > 0) {
                if ((val >> 6) == 0b10) {
                    count--;
                } else {
                    return false;
                }
            } else {
                if ((val >> 7) == 0b0) {
                    count = 0;
                } else if ((val >> 5) == 0b110) {
                    count = 1;
                } else if ((val >> 4) == 0b1110) {
                    count = 2;
                } else if ((val >> 3) == 0b11110) {
                    count = 3;
                } else {
                    return false;
                }
            }
        }

        if (count > 0) {
            return false;
        } else {
            return true;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        System.out.println(solution(arr));
    }

}