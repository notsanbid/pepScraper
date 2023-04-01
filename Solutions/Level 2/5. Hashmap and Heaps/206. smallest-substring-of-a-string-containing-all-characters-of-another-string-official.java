import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String s1 = scn.next();
		String s2 = scn.next();
		System.out.println(solution(s1,s2));
	}

	public static String solution(String s1, String s2){
	    if(s2.length() == 1){
            for(int i = 0 ; i < s1.length(); i++){
                if(s1.charAt(i) == s2.charAt(0)){
                    return s2;
                }
            }
            return "";
        }
        
        HashMap<Character,Integer> map1 = new HashMap<>();
	    HashMap<Character,Integer> map2 = new HashMap<>();
	    for(int i = 0 ; i < s2.length(); i++){
	        char ch = s2.charAt(i);
	        map2.put(ch,map2.getOrDefault(ch,0) + 1);
	    }
	    
	    int ans = Integer.MAX_VALUE;
	    int matchcount = 0;
	    int[] fans = new int[2];
	    for(int i = 0, j = 0; i < s1.length(); i++){
	        char c = s1.charAt(i);
	        if(map2.containsKey(c)){
	            map1.put(c,map1.getOrDefault(c,0) + 1);
	            if(map1.get(c) <= map2.get(c)){
	                matchcount++;
	            }
	            while(matchcount == s2.length()){
	                char chj = s1.charAt(j);
	                if(!map1.containsKey(chj)){
	                    //nothing
	                }else if(map1.get(chj) > map2.getOrDefault(chj,0)){
	                    map1.put(chj,map1.get(chj) - 1);
	                }else{
	                    if(i - j + 1 < ans){
	                        ans = i - j + 1;
	                        fans[0] = i;
	                        fans[1] = j;
	                    }
	                    map1.put(chj,map1.get(chj) - 1);
	                    if(map1.get(chj) < 0){
	                        map1.remove(chj);
	                    }
	                    matchcount--;
	                }
	                j++;
	            }
	           
	        }    
	        
	    }
	    if(fans[0] == fans[1] && s2.length() != 1){
	        return "";
	    }else
	    return (s1.substring(fans[1],fans[0] + 1));
	}

}