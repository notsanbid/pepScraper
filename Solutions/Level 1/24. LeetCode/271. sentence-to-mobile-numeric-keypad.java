import java.util.*;
 import java.io.*;
 
 public class Main {
 
 	 public static void Keypad(String s) {
 	 	 String res = "";
 	 	 int x = 0, y = 0;
 	 	 for (int i = 0; i < s.length(); i++) {
 	 	 	 char c = s.charAt(i);
 	 	 	 if ((int) c == 32) {
 	 	 	 	 res += '0';
 	 	 	 	 continue;
 	 	 	 }
 
 	 	 	 else if (c == 'P' || c == 'Q' || c == 'R' || c == 'S') {
 	 	 	 	 x = 7;
 	 	 	 	 y = ((int) c - 64) % 4 + 1;
 	 	 	 }
 
 	 	 	 else if (c == 'W' || c == 'X' || c == 'Y' || c == 'Z') {
 	 	 	 	 x = 9;
 	 	 	 	 y = ((int) c - 67) % 4 + 1;
 
 	 	 	 } else if (c == 'T' || c == 'U' || c == 'V') {
 	 	 	 	 x = 8;
 	 	 	 	 y = ((int) c - 66) % 3 + 1;
 	 	 	 } else {
 	 	 	 	 x = (((int) s.charAt(i)) - 65) / 3 + 2;
 	 	 	 	 y = (((int) s.charAt(i)) - 65) % 3 + 1;
 	 	 	 }
 	 	 	 for (int j = 0; j < y; j++)
 	 	 	 	 res += (x);
 
 	 	 }
 	 	 System.out.println(res);
 
 	 }
 
 	 public static void main(String[] args) {
 	 	 Scanner in = new Scanner(System.in);
 	 	 String s = in.nextLine();
 	 	 Keypad(s);
 	 }
 }