public void reverse(int[] arr, int s, int e) {
  while (s < e) {
    int temp = arr[s];
    arr[s] = arr[e];
    arr[e] = temp;
    s++;
    e--;
  }
}

public List<Integer> pancakeSort(int[] arr) {
  List<Integer> ans = new ArrayList<Integer>();
  int n = arr.length;
  for (int i = n - 1; i >= 0; i--) {
    int maxIdx = i;
    for (int j = i - 1; j >= 0; j--) maxIdx = (arr[j] > arr[maxIdx] ? j : maxIdx);
    // System.out.println(arr[maxIdx]+" "+i);
    if (maxIdx != i) {
      reverse(arr, 0, maxIdx);
      ans.add(maxIdx + 1);
      if (i == n - 1) reverse(arr, 0, i);
      else reverse(arr, 0, i);
      ans.add(i + 1);
    }
  }
  for (int i = 0; i < arr.length; i++) System.out.print(arr[i] + " ");
  return ans;
}