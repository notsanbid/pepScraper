import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int noofpairs_src_des = scn.nextInt();
		HashMap<String, String> map = new HashMap<>();
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < noofpairs_src_des; i++) {
			String s1 = scn.next();
			String s2 = scn.next();
			map.put(s1, s2);
			set.add(s1);
		}

		// first we have to find starting point
		ArrayList<String> al = new ArrayList<String>(map.keySet());
		for (String s : al) {
			if (set.contains(map.get(s))) {
				set.remove(map.get(s));
			}
		}
		String start = set.toString();
		StringBuilder sb = new StringBuilder(start);
		sb.deleteCharAt(0);
		sb.deleteCharAt(sb.length() - 1);
		start = sb.toString();

		while (map.containsKey(start)) {
			if(map.size() == 1){
				System.out.print(start + " -> " + map.get(start) + ".");
				break;
			}
			System.out.print(start + " -> ");
			String nstart = map.get(start);
			map.remove(start);
			start = nstart;
		}

	}
}