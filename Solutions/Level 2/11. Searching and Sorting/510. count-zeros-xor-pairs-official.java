import java.util.*;
import java.io.*;

public class Main {

  public static int countPairs(int[]arr) {
    //write your code here
    int count = 0;
    HashMap<Integer, Integer>hm = new HashMap<>();

    for (int i = 0; i < arr.length; i++) {
      if (hm.containsKey(arr[i]) == true) {
        hm.put(arr[i], hm.get(arr[i]) + 1);
      }
      else {
        hm.put(arr[i], 1);
      }
    }

    for (int key : hm.keySet()) {
      int val = hm.get(key);
      count += ((val - 1) * (val) / 2);
    }

    return count;
  }

  public static void main(String[]args) {
    //input work
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[]arr = new int[n];

    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }

    System.out.println(countPairs(arr));
  }
}