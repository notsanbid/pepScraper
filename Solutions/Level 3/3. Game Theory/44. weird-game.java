import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);

    int n = scn.nextInt();
    String s1 = scn.next();
    String s2 = scn.next();

    int fs = 0;
    int f = 0;
    int s = 0;

    for (int i = 0; i < n * 2; i++) {
      char c1 = s1.charAt(i);
      char c2 = s2.charAt(i);
      if (c1 == '1' && c2 == '1')fs++;
      else if (c1 == '1')f++;
      else if (c2 == '1')s++;
    }

    if (fs % 2 == 1)f++;

    String ans;
    if (f > s)ans = "First";
    else if (s > f + 1)ans = "Second";
    else ans = "Draw";

    System.out.println(ans);
  }
}