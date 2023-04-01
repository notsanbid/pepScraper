import java.io.*;
import java.util.*;

public class Main {

	public static String compression1(String str){
		String ans = "";
		for(int i = 0 ; i < str.length(); i++){
			while(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)){
				i++;
			}
			ans += str.charAt(i);
		}
		return ans;
	}

	public static String compression2(String str){
		String ans = "";
		for(int i = 0 ; i < str.length(); i++){
			int count = 1;
			while(i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)){
				count++;
				i++;
			}
			ans += str.charAt(i);
			if(count > 1){
				ans += count;
			}
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(compression1(str));
		System.out.println(compression2(str));
	}

}