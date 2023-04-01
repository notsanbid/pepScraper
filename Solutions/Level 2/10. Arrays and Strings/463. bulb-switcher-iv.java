class Solution {
public:
  int minFlips(string target) {
    int curr = 0;
    int count = 0;
    for (int i = 0; i < target.length(); i++) {
      if (target[i] - '0' != curr) {
        curr = target[i] - '0';
        count++;
      }
    }
    return count;
  }
};