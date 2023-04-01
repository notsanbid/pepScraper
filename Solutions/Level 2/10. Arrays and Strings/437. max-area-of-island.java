class Solution {
public:

  vector<int> di = {-1, 0, 1, 0};
  vector<int> dj = {0, 1, 0, -1};

  int islandFinder(vector<vector<int>>& a, vector<vector<bool>>& vis, int i, int j) {
    if (i < 0 || j < 0 || i >= a.size() || j >= a[0].size() || a[i][j] == 0 || vis[i][j]) return 0;
    vis[i][j] = true;
    int nextAns = 0;
    for (int d = 0; d < 4; d++) nextAns += islandFinder(a, vis, i + di[d], j + dj[d]);
    return nextAns + 1;
  }

  int maxAreaOfIsland(vector<vector<int>>& arr) {
    int n = arr.size(), m = arr[0].size();
    vector<vector<bool>> vis(n, vector<bool>(m, false));
    int maxi = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (vis[i][j]) continue;
        maxi = max(maxi, islandFinder(arr, vis, i, j));
      }
    }
    return maxi;
  }
};