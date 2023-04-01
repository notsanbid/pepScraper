import java.io.*;
import java.util.*;

public class Main {

    public static void queensCombinations(int qpsf, int tq, int row, int col, String asf){
        if(row == tq){
            if(qpsf == tq){
                System.out.println(asf);
            }
            return;
        }
        queensCombinations(qpsf + 1, tq, 
                           col == tq - 1? row + 1: row, 
                           col == tq - 1? 0: col + 1, 
                           col == tq - 1? asf + "q\n": asf + "q");
        queensCombinations(qpsf + 0, tq, 
                           col == tq - 1? row + 1: row, 
                           col == tq - 1? 0: col + 1, 
                           col == tq - 1? asf + "-\n": asf + "-");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        queensCombinations(0, n, 0, 0, "");
    }
}