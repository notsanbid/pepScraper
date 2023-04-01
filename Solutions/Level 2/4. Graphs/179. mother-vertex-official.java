import java.io.*;
import java.util.*;


public class Main{
    	public static void main(String args[]) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] st = br.readLine().split(" ");
		int n = Integer.parseInt(st[0]);
		int m = Integer.parseInt(st[1]);

		ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < m; i++) {
			st = br.readLine().split(" ");
			int u = Integer.parseInt(st[0]) - 1;
			int v = Integer.parseInt(st[1]) - 1;
			graph.get(u).add(v);
		}

		System.out.println(findMotherVertex(n, graph));
	}
    public static int findMotherVertex(int N, ArrayList<ArrayList<Integer>>adj){
        Stack<Integer> stack = new Stack<>();
		boolean[] visited = new boolean[N];
		for (int i = 0; i < N; i++) {
			if (!visited[i]) {
				dfs(adj, visited, i, stack);
			}
		}
		count=0;
		visited = new boolean[N];
		int ans = stack.pop();
		dfs(adj,visited,ans);
		if(count == N){
		 return ans+1;
		}else{
		   return -1;
		}
		
    }
   static int count;

   public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int cur) {
		visited[cur] = true;
		count++;
		for (Integer neighbour : graph.get(cur)) {
			if (!visited[neighbour]) {
				dfs(graph, visited, neighbour);
			}
		}
	}
    public static void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int cur, Stack<Integer> stack) {
		visited[cur] = true;
		for (Integer neighbour : graph.get(cur)) {
			if (!visited[neighbour]) {
				dfs(graph, visited, neighbour, stack);
			}
		}
		stack.push(cur);
	}
}