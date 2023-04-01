class Solution {
  public boolean isPowerOfFour(int n) {
    int fac = 0b01010101010101010101010101010101;
    return n > 0 && (n & (n - 1)) == 0 && (fac & n) > 0;
  }
}