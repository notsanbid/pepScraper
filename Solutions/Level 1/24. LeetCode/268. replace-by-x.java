import java.util.*;
 
 public class Main {
     
     public static void replaceX(String main, String sub) {
         // TODO Auto-generated method stub
         StringBuilder ans = new StringBuilder("");
         int count = 0;
         for (int i = 0; i < main.length();) {
             while ((i <= main.length() - sub.length()) && main.substring(i, i + sub.length()).equals(sub)) {
                 i += sub.length();
                 count++;
             }
             if (count != 0) {
                 ans.append("X");
                 count = 0;
             } else {
                 ans.append(main.charAt(i));
                 i++;
             }
         }
         System.out.println(ans);
     }
     
     public static void main(String[] args) {
         Scanner sc = new Scanner(System.in);
         replaceX(sc.next(), sc.next());
     }
 }