import java.util.*;
 class Main {
     public static void main(String[] args){
         Scanner scn= new Scanner(System.in);
         int n=scn.nextInt();
         int[] A= new int[n];
         for(int i=0;i<n;i++){
             A[i]=scn.nextInt();
         }
         System.out.print(sumSubseqWidths(A));
     }
     public static int sumSubseqWidths(int[] A) {
         int MOD = 1_000_000_007;
         int N = A.length;
         Arrays.sort(A);
 
         long[] pow2 = new long[N];
         pow2[0] = 1;
         for (int i = 1; i < N; ++i)
             pow2[i] = pow2[i-1] * 2 % MOD;
 
         long ans = 0;
         for (int i = 0; i < N; ++i)
             ans = (ans + (pow2[i] - pow2[N-1-i]) * A[i]) % MOD;
 
         return (int) ans;
     }
 }