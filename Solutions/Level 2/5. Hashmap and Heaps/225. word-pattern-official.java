import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		String pattern = scn.nextLine();
		String words = scn.nextLine();
		System.out.println(wordPattern(pattern,words));
	}

	public static boolean wordPattern(String pattern, String str) {
        String[] arr = str.split(" ");
		if(arr.length != pattern.length()){
		    return false;
		}
		HashMap<Character, String> map = new HashMap<Character, String>();
	    for(int i=0; i<pattern.length(); i++){
	        char c = pattern.charAt(i);
	        if(map.containsKey(c)){
	            String value = map.get(c);
	            if(!value.equals(arr[i])){
	                return false;
	            }
	        }else if (map.containsValue(arr[i])){
	            return false;
	        }
	        map.put(c, arr[i]);
	    }
		return true;
    }

}