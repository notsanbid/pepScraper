import java.util.*;

public class Main {

  public static int minDominoRotations(int[] tops, int[] bottoms) {
    int count1 = 0, count2 = 0, count3 = 0, count4 = 0;

    int num1 = tops[0];
    int num2 = bottoms[0];

    for (int i = 0; i < tops.length; i++) {
      // count 1 is count of rotation if top array have num1
      if (count1 != Integer.MAX_VALUE) {
        if (tops[i] == num1) {
          // nothing to do for count
        } else if (bottoms[i] == num1) {
          count1++;
        } else {
          count1 = Integer.MAX_VALUE;
        }
      }

      // count 2 is count of rotation if bottom array have num1
      if (count2 != Integer.MAX_VALUE) {
        if (bottoms[i] == num1) {
          // nothing to do
        } else if (tops[i] == num1) {
          count2++;
        } else {
          count2 = Integer.MAX_VALUE;
        }
      }

      // count 3 is count of rotation if top array have num2
      if (count3 != Integer.MAX_VALUE) {
        if (tops[i] == num2) {
          // nothing to do for count
        } else if (bottoms[i] == num2) {
          count3++;
        } else {
          count3 = Integer.MAX_VALUE;
        }
      }

      // count 4 is count of rotation if bottom array have num2
      if (count4 != Integer.MAX_VALUE) {
        if (bottoms[i] == num2) {
          // nothing to do
        } else if (tops[i] == num2) {
          count4++;
        } else {
          count4 = Integer.MAX_VALUE;
        }
      }
    }

    int ans = Math.min(Math.min(count1, count2), Math.min(count3, count4));

    return ans == Integer.MAX_VALUE ? -1 : ans;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] top = new int[n];
    int[] bottom = new int[n];

    // read top
    for (int i = 0; i < top.length; i++) {
      top[i] = scn.nextInt();
    }
    // read bottom
    for (int i = 0; i < bottom.length; i++) {
      bottom[i] = scn.nextInt();
    }

    int rotation = minDominoRotations(top, bottom);
    System.out.println(rotation);
  }
}