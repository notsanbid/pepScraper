import java.io.*;

public class Main {

  public static void main(String[] args) throws NumberFormatException, IOException {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(read.readLine());

    int ans[] = new int[n + 1];
    boolean used[] = new boolean[n + 1];

    int mask = (1 << 20) - 1; // 111111111..111 20 times

    for (int i = n; i >= 0; i--) {
      while ((mask ^ i) > n || used[mask ^ i] == true) {
        mask = mask >> 1;
      }

      ans[i] = mask ^ i;
      used[mask ^ i] = true;
    }

    StringBuilder sb = new StringBuilder();
    long score = n;
    score = score * (score + 1);

    sb.append(score + "\n");

    for (int i = 0; i <= n; i++) {
      sb.append(ans[i] + " ");
    }

    System.out.println(sb);
  }
}