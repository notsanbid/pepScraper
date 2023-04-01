import java.io.*;

public class Main {

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    String inp[] = read.readLine().split(" ");

    long n = Integer.parseInt(inp[0]);
    long m = Integer.parseInt(inp[1]);

    // write your code from here

    long a = n/m;
    long b = n%m;
    
    long max = (n-m)*(n-m+1)/2;
    long min = (a*(a+1)*b)/2 + ((a-1)*a*(m-b))/2;
    
    System.out.println(min+" "+max);

  }
}