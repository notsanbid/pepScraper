import java.util.*;

public class minimax {
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int T = scn.nextInt();
    while (T-- > 0) {
      String s = scn.next();
      int[] count = new int[26];

      for (int i = 0; i < s.length(); i++) {
        char ch = s.charAt(i);
        count[ch - 'a']++;
      }
      boolean done = false;
      for (int i = 0; i < 26; i++) {
        if (count[i] == 1) {
          // printing for test 1
          String ans = "";
          ans += (char)(i + 'a');
          count[i] = 0;
          for (int j = 0; j < 26; j++) {
            while (count[j]-- > 0) {
              ans += (char)(j + 'a');
            }
          }
          System.out.println(ans);
          done = true;
          break;
        } else if (count[i] == s.length()) {
          System.out.println(s);
          done = true;
          break;
        }
      }
      if (done) continue;

      // now everyone is > 2 or = 0
      // we assume the min character < |s|/2 + 1

      int mini = -1;
      for (int i = 0; i < 26; i++) if (count[i] > 0) {
          mini = i;
          break;
        }

      if (count[mini] > s.length() / 2 + 1) {
        int smini = mini + 1;
        while (smini < 26 && count[smini] == 0) {
          smini++;
        }
        int tmini = smini + 1;
        while (tmini < 26 && count[tmini] == 0) tmini++;
        if (tmini == 26) {
          // there are only 2 characters mini and smini
          String ans = "" + (char)(mini + 'a');
          count[mini]--;
          while (count[smini] > 0) {
            ans += (char)(smini + 'a');
            count[smini]--;
          }
          while (count[mini] > 0) {
            ans += (char)(mini + 'a');
            count[mini]--;
          }
          System.out.println(ans);
          done = true;

        } else {
          // there are > 2 characters
          String ans = "" + (char)(mini + 'a');
          count[mini]--;
          ans += (char)(smini + 'a');
          count[smini]--;

          while (count[mini] > 0) {
            ans += (char)(mini + 'a');
            count[mini]--;
          }
          ans += (char)(tmini + 'a');
          count[tmini]--;
          while (count[smini] > 0) {
            ans += (char)(smini + 'a');
            count[smini]--;
          }

          for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
              ans += (char)(i + 'a');
              count[i]--;
            }
          }
          System.out.println(ans);
          done = true;
        }
      }
      if (done) continue;
      // we can place aa
      String ans = "";

      ans += (char)(mini + 'a');
      ans += (char)(mini + 'a');
      count[mini] -= 2;

      // aa cannot occur together
      int i = 0;
      while (i < 26) {
        if (i == mini || count[i] == 0) {
          i++;
          continue;
        }
        if (count[mini] > 0) {
          ans += ((char) (i + 'a'));
          ans += ((char) (mini + 'a'));
          count[i]--;
          count[mini]--;
        } else {
          while (count[i] > 0) {
            ans += ((char)(i + 'a'));
            count[i]--;
          }
          i++;
        }
      }
      System.out.println(ans);
    }
  }
}