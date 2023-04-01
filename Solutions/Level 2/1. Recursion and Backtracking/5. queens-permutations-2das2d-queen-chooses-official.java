import java.io.*;
import java.util.*;

public class Main {

    public static void queensPermutations(int qpsf, int tq, int[][] chess){
        if(qpsf == tq){
            for(int row = 0; row < chess.length; row++){
                for(int col = 0; col < chess.length; col++){
                    System.out.print(chess[row][col] != 0? "q"+ chess[row][col] + "\t": "-\t");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }
        
        for(int row = 0; row < chess.length; row++){
            for(int col = 0; col < chess.length; col++){
                if(chess[row][col] == 0){
                    chess[row][col] = qpsf + 1;
                    queensPermutations(qpsf + 1, tq, chess);
                    chess[row][col] = 0;
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] chess = new int[n][n];
        
        queensPermutations(0, n, chess);
    }
}