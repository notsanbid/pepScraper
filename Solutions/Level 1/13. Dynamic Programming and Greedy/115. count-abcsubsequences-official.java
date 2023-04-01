import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int acount = 0;
        int bcount = 0;
        int ccount = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == 'a'){
                acount = 2 * acount + 1;
            } else if(str.charAt(i) == 'b'){
                bcount = 2 * bcount + acount;
            } else if(str.charAt(i) == 'c'){
                ccount = 2 * ccount + bcount;
            }
        }

        System.out.println(ccount);
    }
}