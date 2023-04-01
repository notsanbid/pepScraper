import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int i = scn.nextInt();
    int j = scn.nextInt();
    int k = scn.nextInt();
    int m = scn.nextInt();
    
    int mask1 = 1 << i;
    int mask2 = 1 << j;
    int mask3 = 1 << k;
    int mask4 = 1 << m;

    System.out.println(n | mask1);
    System.out.println(n & (~mask2));
    System.out.println(n ^ mask3);
    System.out.println((n & mask4) == 0 ?  false: true);
  }

}