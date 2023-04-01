import java.io.*;
import java.util.*;

public class Main {

	public static String solution(String str){
		StringBuilder ans = new StringBuilder();
		for(int i = 0 ; i < str.length(); i++){
			if(i + 1 < str.length()){
				int diff = str.charAt(i + 1) - str.charAt(i);
				ans.append(str.charAt(i));
				ans.append(diff);
			}else{
				ans.append(str.charAt(i));
			}
		}
		return ans.toString();
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

}