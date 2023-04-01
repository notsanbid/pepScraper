import java.io.*;
import java.util.*;

public class Main {
  public static class MovingAverage {

    Queue<Integer> q;
    int size;
    double sum;

    public MovingAverage(int size) {
      q = new LinkedList<>();
      this.size = size;
      sum = 0;
    }

    public double next(int val) {
      q.add(val);
      sum += val;

      if (q.size() > size) {
        sum = sum - q.poll();
      }
      return (double)sum / q.size();
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    int size = Integer.parseInt(read.readLine());
    MovingAverage obj = new MovingAverage(size);
    PrintWriter out = new PrintWriter(System.out);
    while (read.ready()) {
      int val = Integer.parseInt(read.readLine());
      double avg = obj.next(val);

      StringBuilder ans = new StringBuilder(String.format("%.5f", avg));
      while (ans.charAt(ans.length() - 2) != '.' && ans.charAt(ans.length() - 1) == '0') {
        ans.deleteCharAt(ans.length() - 1);
      }
      out.println(ans);
    }
    out.close();
  }
}