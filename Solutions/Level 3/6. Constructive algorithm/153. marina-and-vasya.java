import java.io.*;
import java.util.*;

public class Main {

  static char different(String s1, String s2, int i) {
    char check[] = {'a', 'b', 'c'};

    for (char ch : check) {
      if (ch != s1.charAt(i) && ch != s2.charAt(i)) {
        return ch;
      }
    }
    return 'z';// never return
  }

  public static void main(String[] args) throws IOException {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    int t = n - scn.nextInt();

    String s1 = scn.next();
    String s2 = scn.next();

    int countsame = 0;
    for (int i = 0; i < n; i++) {
      if (s1.charAt(i) == s2.charAt(i))countsame++;
    }

    int same, diff;
    if (t < countsame) {
      same = t;
      diff = 0;
    } else if (t == countsame) {
      same = t;
      diff = 0;
    } else {
      same = countsame;
      diff = (t - same) * 2;
      if (n - countsame < diff) {
        System.out.println(-1);
        return;
      }
    }

    char ans[] = new char[n];
    // same
    for (int i = 0; i < n; i++) {
      if (s1.charAt(i) == s2.charAt(i)) {
        if (same > 0) {
          ans[i] = s1.charAt(i);
          same--;
        } else {
          ans[i] = different(s1, s2, i);
        }
      } else {
        if (diff > 0) {
          ans[i] = s1.charAt(i);
          String tmp = s1;
          s1 = s2;
          s2 = tmp;
          diff--;
        } else {
          ans[i] = different(s1, s2, i);
        }
      }
    }

    System.out.println(new String(ans));
  }
}