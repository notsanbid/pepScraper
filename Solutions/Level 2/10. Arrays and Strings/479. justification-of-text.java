import java.util.*;

class Main {

  public static List<String> fullJustify(String[] words, int maxWidth) {
    List<String> list = new ArrayList<>();
    int i = 0;
    while (i < words.length) {
      int wc = words[i].length();
      int j = i + 1;

      int can = 0;

      while (j < words.length && wc + can + words[j].length() + 1 <= maxWidth) {
        wc += words[j].length();
        can++;
        j++;
      }

      int vac = maxWidth - wc;



      int atleast = can == 0 ? 0 : vac / can;
      int extra = can == 0 ? 0 : vac % can;

      if (j == words.length) {
        atleast = 1;
        extra = 0;
      }

      StringBuilder sb = new StringBuilder();

      for (int k = i; k < j; k++) {
        sb.append(words[k]);
        if (k == j - 1)break;
        for (int e = 0; e < atleast; e++)sb.append(" ");
        if (extra > 0) {
          sb.append(" ");
          extra--;
        }
      }

      while (sb.length() < maxWidth)sb.append(" ");

      list.add(sb.toString());

      i = j;
    }

    return list;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    String[] words = new String[n];
    for (int i = 0; i < n; i++) {
      words[i] = sc.next();
    }
    int width = sc.nextInt();
    System.out.println(fullJustify(words, width));
  }
}