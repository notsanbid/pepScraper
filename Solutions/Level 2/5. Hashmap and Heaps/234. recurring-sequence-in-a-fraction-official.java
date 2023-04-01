import java.util.*;

public class Main {

    public static String solution(int num, int den) {
        StringBuilder sb = new StringBuilder();
        
        int quo = num / den;
        int rem = num % den;
        sb.append(quo);
        
        if(rem == 0){
            return sb.toString();
        } else {
            sb.append(".");
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        while(rem != 0){
            if(map.containsKey(rem) == false){
                map.put(rem, sb.length());
            
                rem *= 10;
                quo = rem / den;
                rem = rem % den;
                sb.append(quo);
            } else {
                int pos = map.get(rem);
                sb.insert(pos, "(");
                sb.append(")");
                break;
            }
        }
        
        return sb.toString();
    }
    
    public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int num = scn.nextInt();
		int den = scn.nextInt();
		System.out.println(solution(num , den));
	}

}