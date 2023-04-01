public int minFlips(int a, int b, int c) {
  int res = 0;

  for (int i = 0; i < 32; i++) {
    boolean aa = false;
    boolean bb = false;
    boolean cc = false;

    if ( (a & (1 << i)) != 0) aa = true;
    if ( (b & (1 << i)) != 0) bb = true;
    if ( (c & (1 << i)) != 0) cc = true;
    if (cc) {
      if (!aa && !bb ) res++;
    } else {
      if (aa && bb) res += 2;
      else if (aa || bb) res++;
    }
  }
  return res;
}