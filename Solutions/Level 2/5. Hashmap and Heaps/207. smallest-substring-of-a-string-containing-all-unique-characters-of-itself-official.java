import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

	public static int solution(String str){
	    HashMap<Character,Integer> map = new HashMap<>();
	    HashSet<Character> set = new HashSet<>();
	    for(int i = 0 ; i < str.length(); i++){
	        char ch = str.charAt(i);
	        set.add(ch);
	    }
	    int ans = Integer.MAX_VALUE;
	    for(int i = 0, j = 0; i < str.length(); i++){
	        char ch = str.charAt(i);
	        map.put(ch,map.getOrDefault(ch,0) + 1);
	        while(map.size() == set.size() && j < str.length()){
	            char chj = str.charAt(j);
	            map.put(chj,map.get(chj) - 1);
	            if(map.get(chj) <= 0){
	                map.remove(chj);
	                ans = Math.min(ans,i - j + 1);
	            }
	            j++;
	        }
	    }
	    return ans;
	}

}