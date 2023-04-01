import java.util.*;

public class Main {

  public static int numRescueBoats(int[] people, int limit) {
    int ans = 0;
    int i = 0;
    int j = people.length - 1;

    Arrays.sort(people);

    while (i <= j) {
      if (people[i] + people[j] > limit) {
        j--;
        ans++;
      } else {
        ans++;
        i++;
        j--;
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] people = new int[n];

    for (int i = 0; i < n; i++)
      people[i] = scn.nextInt();

    int limit = scn.nextInt();
    int boats = numRescueBoats(people, limit);
    System.out.println(boats);
  }
}