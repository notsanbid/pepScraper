import java.util.*;

public class permbysum {
  public static int low(int k) {
    return k * (k + 1) / 2;
  }

  public static int high(int n, int k) {
    return k * (2 * n + 1 - k) / 2;
  }

  public static void  main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int T = scn.nextInt();
    while (T-- > 0) {
      int n = scn.nextInt();
      int l = scn.nextInt();
      int r = scn.nextInt();
      int s = scn.nextInt();;
      int k = r - l + 1;              // we have to choose k numbers
      HashSet<Integer> ans = new HashSet<Integer>();
      // if i comes in answer set or not
      int i = n;

      while (k > 0 && i >= 1) {
        // cout<<high(i,k)<<" "<<low(k-1)<<" "<<i<<endl;
        if (high(i, k) >= s && s - i >= low(k - 1)) {
          s -= i;
          ans.add(i);
          k--;
        }
        // cout<<"asd"<<endl;
        i--;
      }
      // for(int x: ans) cout<<-1<<" ";
      // cout<<endl;
      if (s > 0) System.out.println(-1);
      else {
        int[] arr = new int[n + 1];
        int pos = l;
        for (int x : ans) arr[pos++] = x;
        pos = 1;
        int num = 1;
        while (pos <= n) {
          while (pos >= l && pos <= r) pos++;
          while (ans.contains(num)) num++;
          if (pos > n) break;
          arr[pos++] = num++;
        }
        for (int j = 1; j <= n; j++) System.out.print(arr[j] + " ");
        System.out.println();
      }

    }
  }
}