import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main {
  public static int meetingRoomsUsingPQ(int intervals[][]) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

    for (int interval[] : intervals) {
      if (pq.size() == 0) {
        pq.add(interval[1]);
      } else {
        if (interval[0] < pq.peek()) {
          pq.add(interval[1]);
        } else {
          pq.remove();
          pq.add(interval[1]);
        }
      }
    }

    return pq.size();
  }
  public static int meetingRoomsUsingCO(int intervals[][]) {
    int et[] = new int[intervals.length], st[] = new int[intervals.length];
    for (int i = 0; i < intervals.length; i++) {
      et[i] = intervals[i][1];
      st[i] = intervals[i][0];
    }

    Arrays.sort(et);
    Arrays.sort(st);

    int ePtr = 0, sPtr = 0, count = 0;
    while (sPtr < intervals.length) {
      if (et[ePtr] > st[sPtr]) {
        count++;
        sPtr++;
      } else {
        sPtr++;
        ePtr++;
      }
    }

    return count;
  }
  public static void main(String args[]) {
    Scanner scn = new Scanner(System.in);

    // Input Format
    int n = scn.nextInt();
    int input[][] = new int[n][2];

    for (int i = 0 ; i <  n ; i++) {
      int sp = scn.nextInt();
      int ep = scn.nextInt();

      input[i][0] = sp;
      input[i][1] = ep;
    }

    // Output Format
    // System.out.println(meetingRoomsUsingPQ(input));
    System.out.println(meetingRoomsUsingCO(input));

  }
}