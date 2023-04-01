import java.util.*;

public class Main {

  // ~~~~~~~~~~~~~~User Section~~~~~~~~~~~
  public static boolean isVowel(char[] arr, int indx) {
    char ch = arr[indx];
    if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' ||
        ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
      return true;
    }
    return false;
  }

  public static void swap(char[] arr, int a, int b) {
    char temp = arr[a];
    arr[a] = arr[b];
    arr[b] = temp;
  }

  public static String reverseVowels(String s) {
    char[] arr = s.toCharArray();
    int left = 0;
    int right = s.length() - 1;

    while (left < right) {
      while (left < right && isVowel(arr, left) == false) {
        left++;
      }
      while (left < right && isVowel(arr, right) == false) {
        right--;
      }
      swap(arr, left, right);
      left++;
      right--;
    }

    String str = "";
    for (char ch : arr) {
      str += ch;
    }
    return str;
  }

  // ~~~~~~~~~~~~Input Management~~~~~~~~~~
  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    String str = scn.nextLine();

    String res = reverseVowels(str);
    System.out.println(res);
  }
}