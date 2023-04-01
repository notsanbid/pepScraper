import java.util.*;
import java.io.*;

public class Main {
  static InputReader in = new InputReader(System.in);
  static OutputWriter out = new OutputWriter(System.out);

  static class Edge {
    int src;// src
    int nbr;// nbr
    int c;
    int i;
    Edge(int vv, int uu, int cc, int ii) {
      i = ii;
      src = vv;
      nbr = uu;
      c = cc;
    }
  }

  // input in.nextInt() in.nextString()
  // output out.printLine("data");
  static ArrayList<Edge>adj[];
  static int[] depth, parent, edgeToNode, size, value, heavy;
  static int head[], lt[], pos[], idx;

  static void dfs(int node) {

    for (Edge e : adj[node]) {
      if (e.nbr == parent[node])continue;

      depth[e.nbr] = depth[node] + 1;
      parent[e.nbr] = node;
      edgeToNode[e.i] = e.nbr;
      value[e.nbr] = e.c;

      dfs(e.nbr);

      size[node] += size[e.nbr];
      if (size[e.nbr] > size[heavy[node]])heavy[node] = e.nbr;
    }
    size[node]++;
  }

  static void hld(int node, int h) {
    head[node] = h;
    lt[idx] = node;
    pos[node] = idx++;

    if (heavy[node] != 0)hld(heavy[node], h);

    for (Edge e : adj[node]) {
      if (e.nbr != parent[node] && e.nbr != heavy[node]) {
        hld(e.nbr, e.nbr);
      }
    }
  }

  static int queryLCA(int a, int b, int n) {

    int res = Integer.MIN_VALUE;

    while (head[a] != head[b]) {
      if (depth[head[a]] > depth[head[b]]) {
        int t = a;
        a = b;
        b = t;
      }

      res = Math.max(res, query(1, 1, n, pos[head[b]], pos[b]));
      b = parent[head[b]];
    }

    if (depth[a] > depth[b]) {
      int t = a;
      a = b;
      b = t;
    }

    res = Math.max(res, query(1, 1, n, pos[a] + 1, pos[b]));
    return res;
  }

  static void solve() throws Exception {
    int n = in.nextInt();

    adj = new ArrayList[n + 1];
    for (int i = 0; i <= n; i++)adj[i] = new ArrayList<>();
    for (int i = 1; i < n; i++) {
      int v = in.nextInt();
      int u = in.nextInt();
      int c = in.nextInt();
      Edge e = new Edge(v, u, c, i);
      adj[v].add(e);
      adj[u].add(new Edge(u, v, c, i));
    }

    depth = new int[n + 1];
    parent = new int[n + 1];
    edgeToNode = new int[n];// 1...n-1
    size = new int[n + 1];
    value = new int[n + 1];
    heavy = new int[n + 1];

    dfs(1);

    head = new int[n + 1];
    lt = new int[n + 1];
    idx = 1;
    pos = new int[n + 1];

    hld(1, 1);
    tree = new int[4 * n];
    build(1, 1, n);

    while (true) {
      char ty = in.nextString().charAt(0);

      if (ty == 'D')break;

      int a = in.nextInt();
      int b = in.nextInt();

      if (ty == 'C') {
        int node = edgeToNode[a];
        update(1, 1, n, pos[node], b);
      } else {
        int ans = queryLCA(a, b, n);
        out.printLine(Math.max(ans, 0));
      }
    }

  }

  static int []tree;

  static int build(int node, int start, int end) {
    if (start == end) {
      return tree[node] = value[lt[start]];
    } else {
      int mid = (start + end) / 2;
      int la = build(node * 2, start, mid);
      int ra = build(node * 2 + 1, mid + 1, end);
      return tree[node] = Math.max(la, ra);
    }
  }

  static int query(int node, int start, int end, int l, int r) {
    if (end < l || r < start)return Integer.MIN_VALUE;

    if (l <= start && end <= r) {
      return tree[node];
    } else {
      int mid = (start + end) / 2;
      return Math.max(query(node * 2, start, mid, l, r), query(node * 2 + 1, mid + 1, end, l, r));
    }
  }

  static void update(int node, int start, int end, int pos, int val) {
    if (start == end) {
      tree[node] = val;
    } else {
      int mid = (start + end) / 2;

      if (pos <= mid) {
        update(node * 2, start, mid, pos, val);
      } else {
        update(node * 2 + 1, mid + 1, end, pos, val);
      }
      tree[node] = Math.max(tree[node * 2], tree[node * 2 + 1]);
    }
  }

  public static void main(String[] args) throws Exception {

    int t = in.nextInt();

    while (t-- > 0) {
      solve();
    }


    // in.close();
    out.flush();
    out.close();
  }

  private static class InputReader implements AutoCloseable {

    private static final int DEFAULT_BUFFER_SIZE = 1 << 16;

    private static final InputStream DEFAULT_STREAM = System.in;

    private static final int MAX_DECIMAL_PRECISION = 21;

    private int c;

    private final byte[] buf;
    private final int bufferSize;
    private int bufIndex;
    private int numBytesRead;

    private final InputStream stream;

    private static final byte EOF = -1;

    private static final byte NEW_LINE = 10;

    private static final byte SPACE = 32;

    private static final byte DASH = 45;

    private static final byte DOT = 46;
    private char[] charBuffer;
    private static final byte[] bytes = new byte[58];
    private static final int[] ints = new int[58];
    private static final char[] chars = new char[128];

    static {
      char ch = ' ';
      int value = 0;
      byte _byte = 0;
      for (int i = 48; i < 58; i++)
        bytes[i] = _byte++;
      for (int i = 48; i < 58; i++)
        ints[i] = value++;
      for (int i = 32; i < 128; i++)
        chars[i] = ch++;
    }
    private static final double[][] doubles = {
      { 0.0d, 0.00d, 0.000d, 0.0000d, 0.00000d, 0.000000d, 0.0000000d, 0.00000000d, 0.000000000d,
        0.0000000000d, 0.00000000000d, 0.000000000000d, 0.0000000000000d, 0.00000000000000d,
        0.000000000000000d, 0.0000000000000000d, 0.00000000000000000d, 0.000000000000000000d,
        0.0000000000000000000d, 0.00000000000000000000d, 0.000000000000000000000d
      },
      { 0.1d, 0.01d, 0.001d, 0.0001d, 0.00001d, 0.000001d, 0.0000001d, 0.00000001d, 0.000000001d,
        0.0000000001d, 0.00000000001d, 0.000000000001d, 0.0000000000001d, 0.00000000000001d,
        0.000000000000001d, 0.0000000000000001d, 0.00000000000000001d, 0.000000000000000001d,
        0.0000000000000000001d, 0.00000000000000000001d, 0.000000000000000000001d
      },
      { 0.2d, 0.02d, 0.002d, 0.0002d, 0.00002d, 0.000002d, 0.0000002d, 0.00000002d, 0.000000002d,
        0.0000000002d, 0.00000000002d, 0.000000000002d, 0.0000000000002d, 0.00000000000002d,
        0.000000000000002d, 0.0000000000000002d, 0.00000000000000002d, 0.000000000000000002d,
        0.0000000000000000002d, 0.00000000000000000002d, 0.000000000000000000002d
      },
      { 0.3d, 0.03d, 0.003d, 0.0003d, 0.00003d, 0.000003d, 0.0000003d, 0.00000003d, 0.000000003d,
        0.0000000003d, 0.00000000003d, 0.000000000003d, 0.0000000000003d, 0.00000000000003d,
        0.000000000000003d, 0.0000000000000003d, 0.00000000000000003d, 0.000000000000000003d,
        0.0000000000000000003d, 0.00000000000000000003d, 0.000000000000000000003d
      },
      { 0.4d, 0.04d, 0.004d, 0.0004d, 0.00004d, 0.000004d, 0.0000004d, 0.00000004d, 0.000000004d,
        0.0000000004d, 0.00000000004d, 0.000000000004d, 0.0000000000004d, 0.00000000000004d,
        0.000000000000004d, 0.0000000000000004d, 0.00000000000000004d, 0.000000000000000004d,
        0.0000000000000000004d, 0.00000000000000000004d, 0.000000000000000000004d
      },
      { 0.5d, 0.05d, 0.005d, 0.0005d, 0.00005d, 0.000005d, 0.0000005d, 0.00000005d, 0.000000005d,
        0.0000000005d, 0.00000000005d, 0.000000000005d, 0.0000000000005d, 0.00000000000005d,
        0.000000000000005d, 0.0000000000000005d, 0.00000000000000005d, 0.000000000000000005d,
        0.0000000000000000005d, 0.00000000000000000005d, 0.000000000000000000005d
      },
      { 0.6d, 0.06d, 0.006d, 0.0006d, 0.00006d, 0.000006d, 0.0000006d, 0.00000006d, 0.000000006d,
        0.0000000006d, 0.00000000006d, 0.000000000006d, 0.0000000000006d, 0.00000000000006d,
        0.000000000000006d, 0.0000000000000006d, 0.00000000000000006d, 0.000000000000000006d,
        0.0000000000000000006d, 0.00000000000000000006d, 0.000000000000000000006d
      },
      { 0.7d, 0.07d, 0.007d, 0.0007d, 0.00007d, 0.000007d, 0.0000007d, 0.00000007d, 0.000000007d,
        0.0000000007d, 0.00000000007d, 0.000000000007d, 0.0000000000007d, 0.00000000000007d,
        0.000000000000007d, 0.0000000000000007d, 0.00000000000000007d, 0.000000000000000007d,
        0.0000000000000000007d, 0.00000000000000000007d, 0.000000000000000000007d
      },
      { 0.8d, 0.08d, 0.008d, 0.0008d, 0.00008d, 0.000008d, 0.0000008d, 0.00000008d, 0.000000008d,
        0.0000000008d, 0.00000000008d, 0.000000000008d, 0.0000000000008d, 0.00000000000008d,
        0.000000000000008d, 0.0000000000000008d, 0.00000000000000008d, 0.000000000000000008d,
        0.0000000000000000008d, 0.00000000000000000008d, 0.000000000000000000008d
      },
      { 0.9d, 0.09d, 0.009d, 0.0009d, 0.00009d, 0.000009d, 0.0000009d, 0.00000009d, 0.000000009d,
        0.0000000009d, 0.00000000009d, 0.000000000009d, 0.0000000000009d, 0.00000000000009d,
        0.000000000000009d, 0.0000000000000009d, 0.00000000000000009d, 0.000000000000000009d,
        0.0000000000000000009d, 0.00000000000000000009d, 0.000000000000000000009d
      }
    };

    public InputReader(InputStream stream) {
      this(stream, DEFAULT_BUFFER_SIZE);
    }

    public InputReader(InputStream stream, int bufferSize) {
      if (stream == null || bufferSize <= 0)
        throw new IllegalArgumentException();
      buf = new byte[bufferSize];
      charBuffer = new char[128];
      this.bufferSize = bufferSize;
      this.stream = stream;
    }

    private int readJunk(int token) throws IOException {

      if (numBytesRead == EOF)
        return EOF;
      do {

        while (bufIndex < numBytesRead) {
          if (buf[bufIndex] > token)
            return 0;
          bufIndex++;
        }
        numBytesRead = stream.read(buf);
        if (numBytesRead == EOF)
          return EOF;
        bufIndex = 0;

      } while (true);

    }

    public int nextInt() throws IOException {

      if (readJunk(DASH - 1) == EOF)
        throw new IOException();
      int sgn = 1, res = 0;

      c = buf[bufIndex];
      if (c == DASH) {
        sgn = -1;
        bufIndex++;
      }

      do {

        while (bufIndex < numBytesRead) {
          if (buf[bufIndex] > SPACE) {
            res = (res << 3) + (res << 1);
            res += ints[buf[bufIndex++]];
          } else {
            bufIndex++;
            return res * sgn;
          }
        }
        numBytesRead = stream.read(buf);
        if (numBytesRead == EOF)
          return res * sgn;
        bufIndex = 0;

      } while (true);

    }

    private void doubleCharBufferSize() {
      char[] newBuffer = new char[charBuffer.length << 1];
      for (int i = 0; i < charBuffer.length; i++)
        newBuffer[i] = charBuffer[i];
      charBuffer = newBuffer;
    }

    public String nextString() throws IOException {
      if (numBytesRead == EOF)
        return null;
      if (readJunk(SPACE) == EOF)
        return null;

      for (int i = 0;;) {
        while (bufIndex < numBytesRead) {
          if (buf[bufIndex] > SPACE) {
            if (i == charBuffer.length)
              doubleCharBufferSize();
            charBuffer[i++] = (char) buf[bufIndex++];
          } else {
            bufIndex++;
            return new String(charBuffer, 0, i);
          }
        }

        // Reload buffer
        numBytesRead = stream.read(buf);
        if (numBytesRead == EOF)
          return new String(charBuffer, 0, i);
        bufIndex = 0;
      }
    }

    public void close() throws IOException {
      stream.close();
    }

  }

  private static class OutputWriter implements AutoCloseable {
    private final PrintWriter writer;

    public OutputWriter(OutputStream outputStream) {
      writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream)));
    }

    public void print(Object... objects) {
      for (int i = 0; i < objects.length; i++) {
        if (i != 0)
          writer.print(' ');
        writer.print(objects[i]);
      }
    }

    public void printLine(Object... objects) {
      print(objects);
      writer.println();
    }

    public void close() {
      writer.close();
    }

    public void flush() {
      writer.flush();
    }

  }
}