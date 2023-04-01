import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
  public static void main (String[] args) throws java.lang.Exception
  {
    Scanner scn = new Scanner(System.in);
    long n = scn.nextLong();
    long w = scn.nextLong();

    long prefixSum = 0;
    long MinPassengers = 0, MaxPassengers = 0;
    for (int i = 0; i < n; i++)
    {
      long change = scn.nextLong();
      prefixSum += change;

      if (prefixSum < 0)
        MinPassengers = Math.max(-prefixSum, MinPassengers);
      else MaxPassengers = Math.max(prefixSum, MaxPassengers);
    }

    long possibleStarts = Math.max(0, (w - MaxPassengers) - MinPassengers + 1);
    System.out.println(possibleStarts);
  }
}