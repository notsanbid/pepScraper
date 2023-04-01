class Solution {

  public void dfs(int[][] graph, int i) {
    graph[i][i] = 0;
    for (int j = 0; j < graph.length; j++) {
      if (graph[i][j] == 0  || graph[j][j] == 0) continue;
      dfs(graph, j);
    }
  }

  public int findCircleNum(int[][] graph) {
    int ans = 0;
    int n = graph.length;
    for (int i = 0; i < n; i++) {
      if (graph[i][i] == 0) continue;
      ans++;
      dfs(graph, i);
    }
    return ans;
  }
}