import java.util.*;

public class Main {
    
	public static void main(String[] args){
		Scanner scn = new Scanner(System.in);
		String s= scn.next();
		System.out.print(solution(s));
	}
	
	public static int solution(String s) {
	  HashMap<Character, Integer> map = new HashMap<>();
	  for(int i = 0 ; i < s.length() ;i++) {
		  char ch = s.charAt(i);
		  map.put(ch, map.getOrDefault(ch, 0) + 1);
	  }
	  for(int i = 0 ; i< s.length() ;i++) {
		  char ch = s.charAt(i);
		  if(map.get(ch) == 1) {
			  return i;
		  }
	  }
	  return -1;
  }

}