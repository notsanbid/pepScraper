class Solution {
  public List<Integer> sequentialDigits(int low, int high) {
    int[] allNums = {12, 23, 34, 45, 56, 67, 78, 89,
                     123, 234, 345, 456, 567, 678, 789,
                     1234, 2345, 3456, 4567, 5678, 6789,
                     12345, 23456, 34567, 45678, 56789,
                     123456, 234567, 345678, 456789,
                     1234567, 2345678, 3456789,
                     12345678, 23456789,
                     123456789
                    };
    System.out.println(allNums.length);
    List<Integer> res = new ArrayList<>();
    int n = allNums.length;
    for (int i = 0; i < n; i++) {
      if (allNums[i] < low) continue;
      if (allNums[i] > high) break;
      res.add(allNums[i]);
    }
    return res;
  }
}