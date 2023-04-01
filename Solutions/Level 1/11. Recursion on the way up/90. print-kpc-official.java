import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        printKPC(str, "");
    }

    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static void printKPC(String ques, String asf) {
        if(ques.length() == 0){
            System.out.println(asf);
            return;
        }

        char ch = ques.charAt(0);
        String roq = ques.substring(1);
        for(char chcode: codes[ch - 48].toCharArray()){
            printKPC(roq, asf + chcode);
        }
    }
}