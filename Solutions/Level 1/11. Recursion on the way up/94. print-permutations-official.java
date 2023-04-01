import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        printPermutations(str, "");
    }

    public static void printPermutations(String ques, String ans){
        if(ques.length() == 0){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i < ques.length(); i++){
            char ch = ques.charAt(i);
            String roq = ques.substring(0, i) + ques.substring(i + 1);
            printPermutations(roq, ans + ch);
        }
    }
}