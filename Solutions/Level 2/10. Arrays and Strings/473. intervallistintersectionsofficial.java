import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static int[][] intersection(int intervalList1[][], int intervalList2[][]) {
    ArrayList<int[]> ans = new ArrayList<>();

    int i = 0, j = 0;

    while (i < intervalList1.length && j < intervalList2.length) {
      int cSP = Math.max(intervalList1[i][0], intervalList2[j][0]);
      int cEP = Math.min(intervalList1[i][1], intervalList2[j][1]);

      if (cSP <= cEP) {
        int tmp[] = {cSP, cEP};
        ans.add(tmp);
      }

      if (intervalList1[i][1] < intervalList2[j][1]) {
        i++;
      } else {
        j++;
      }
    }

    return ans.toArray(new int[ans.size()][]);
  }
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    // Input format
    int n = scn.nextInt();
    int list1[][] = new int[n][2];
    for (int i = 0 ; i < n ; i++) {
      list1[i][0] = scn.nextInt();
      list1[i][1] = scn.nextInt();
    }

    int m = scn.nextInt();
    int list2[][] = new int[m][2];
    for (int i = 0 ; i < m ; i++) {
      list2[i][0] = scn.nextInt();
      list2[i][1] = scn.nextInt();
    }

    // output
    int ans[][] = intersection(list1, list2);
    System.out.print("[");
    for (int interval[] : ans) {
      System.out.print(Arrays.toString(interval));
    }
    System.out.println("]");
  }
}