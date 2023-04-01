import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
  public static class LRU {

    class Node {
      int key;
      int val;
      Node prev, next;
    }

    private void addNode(Node node) {
      node.next = head.next;
      node.prev = head;

      head.next.prev = node;
      head.next = node;
    }

    private void removeNode(Node node) {
      Node prv = node.prev;
      Node nxt = node.next;

      prv.next = nxt;
      nxt.prev = prv;
    }

    private void moveToFront(Node node) {
      removeNode(node);
      addNode(node);
    }

    HashMap<Integer, Node> cache;
    Node head, tail;
    int cap;

    public LRU(int capacity) {
      head = new Node();
      tail = new Node();
      head.next = tail;
      tail.prev = head;
      cache = new HashMap<>();
      cap = capacity;
    }

    public int get(int key) {
      Node node = cache.get(key);

      if (node == null) {
        return -1;
      } else {
        moveToFront(node);
        return node.val;
      }
    }

    public void put(int key, int value) {
      Node node = cache.get(key);

      if (node != null) {
        node.val = value;
        moveToFront(node);
      } else {
        Node newNode = new Node();
        newNode.key = key;
        newNode.val = value;
        if (cache.size() == cap) {
          int LRU_Key = tail.prev.key;
          Node LRU_Node = cache.remove(LRU_Key);
          removeNode(LRU_Node);
        }
        cache.put(key, newNode);
        addNode(newNode);
      }
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    LRU obj = new LRU(Integer.parseInt(str.split(" ")[1]));

    while (true) {
      str = br.readLine();
      String inp[] = str.split(" ");
      if (inp.length == 1) {
        break;
      } else if (inp.length == 2) {
        System.out.println(obj.get(Integer.parseInt(inp[1])));
      } else if (inp.length == 3) {
        obj.put(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
      }
    }
  }
}