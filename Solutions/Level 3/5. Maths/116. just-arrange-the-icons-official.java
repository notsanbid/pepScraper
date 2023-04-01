import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner scn = new Scanner(System.in);
    int t = scn.nextInt();
    while (t-- > 0)
    {
      int n = scn.nextInt();
      int[] category = new int[n];
      for (int i = 0; i < n; i++)
        category[i] = scn.nextInt();

      int[] freq = new int[n];
      int maxFreq = 0;
      for (int i = 0; i < n; i++)
      {
        freq[category[i] - 1] += 1;
        maxFreq = Math.max(maxFreq, freq[category[i] - 1]);
      }

      Arrays.sort(freq);

      int ans = Integer.MAX_VALUE;
      for (int size = 1; size <= maxFreq + 1; size++)
      {
        boolean check = true;
        int totalScreens = 0;
        for (int i = n - 1; i >= 0; i--)
        {
          if (freq[i] == 0) break;

          int screens = freq[i] / size;
          if (freq[i] % size != 0) screens++;
          totalScreens += screens;

          int minIcons = screens * (size - 1);

          if (freq[i] < minIcons)
          {
            // Size should be discarded
            check = false;
            break;
          }
        }

        if (check == true)
          ans = Math.min(ans, totalScreens);
      }

      System.out.println(ans);
    }
  }
}