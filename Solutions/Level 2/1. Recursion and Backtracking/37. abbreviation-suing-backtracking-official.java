import java.io.*;
import java.util.*;

public class Main {

    public static void solution(String str, String asf,int count, int pos){
        if(pos == str.length()){
            if(count > 0){
                asf += count;
            }
            System.out.println(asf);
            return;
        }
        solution(str, asf + (count > 0 ? count : "" ) + str.charAt(pos), 0, pos + 1); //yes call -> including curr char
        solution(str, asf, count + 1, pos + 1); //not including curr char -> just converting letters to a number
    }

	public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        solution(str,"",0,0);
        // solution2(str);
    }
}