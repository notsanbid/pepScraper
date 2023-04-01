import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String str = scn.next();
		System.out.println(solution(str));
	}

	public static int solution(String str) {
        if(str.length() == 0){
            return 0;
        }
        HashMap<Character,Integer> map = new HashMap<>();
        int ans = 1;
        for(int i = 0, j = 0 ; i < str.length(); i++){
            char ch = str.charAt(i);
            while(map.containsKey(ch)){
                char chj = str.charAt(j);
                map.put(chj,map.get(chj) - 1);
                if(map.get(chj) <= 0){
                    map.remove(chj);
                    ans = Math.max(ans,i - j);
                }
                j++;
            }
            map.put(ch,map.getOrDefault(ch,0) + 1);
        }
        return Math.max(ans,map.size());
    }

}