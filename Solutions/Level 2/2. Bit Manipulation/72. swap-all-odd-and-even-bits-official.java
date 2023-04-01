import java.io.*;
import java.util.*;

public class Main {

  public static void main(String[] args){
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();

    int even = n & 0xAAAAAAAA;  
    int odd = n & 0x55555555;  

    even >>= 1;   
    odd <<= 1;  
    System.out.println(even | odd);  
  }


}