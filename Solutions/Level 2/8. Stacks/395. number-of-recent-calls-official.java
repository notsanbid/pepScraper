import java.io.*;
import java.util.*;

public class Main {
  public static class RecentCounter {

    Queue<Integer> q = new LinkedList<>();
    int size = 3000;
    public RecentCounter() {

    }

    public int ping(int t) {
      q.add(t);
      while (q.peek() < t - size)q.remove();
      return q.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    RecentCounter obj = new RecentCounter();

    while (read.ready()) {
      int val = Integer.parseInt(read.readLine());
      int ans = obj.ping(val);
      System.out.println(ans);
    }

  }
}