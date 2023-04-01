import java.io.*;
import java.util.*;

public class Main {
  public static class MaxStack {

    class Node {
      int x;
      Node next;
      Node prev;

      Node(int x) {
        this.x = x;
      }

    }

    final Node head = new Node(-1);
    final Node tail = new Node(-1);

    TreeMap<Integer, ArrayList<Node>> tmap;

    public MaxStack() {
      tmap = new TreeMap<>();
      head.next = tail;
      tail.prev = head;

    }

    public void push(int x) {
      Node node = new Node(x);
      addNode(node);

      if (!tmap.containsKey(x)) {

        ArrayList<Node> temp = new ArrayList<>();
        tmap.put(x, temp);
      }

      ArrayList<Node> temp1 = tmap.get(x);
      temp1.add(node);
      tmap.put(x, temp1);


    }

    public int pop() {

      Node node = tail.prev;
      ArrayList<Node> temp = tmap.get(node.x);
      int j = temp.size() - 1;
      temp.remove(j);
      if (temp.size() == 0) {
        tmap.remove(node.x);
      }
      deleteNode(node);
      return node.x;
    }

    public int top() {
      return tail.prev.x;
    }

    public int peekMax() {
      return tmap.lastKey();
    }

    public int popMax() {
      ArrayList<Node> temp = tmap.get(tmap.lastKey());

      Node tobeDeleted = temp.remove(temp.size() - 1);

      if (temp.size() == 0) {
        tmap.remove(tobeDeleted.x);
      }

      deleteNode(tobeDeleted);

      return tobeDeleted.x;

    }

    public void addNode(Node node) {
      Node node_prev = tail.prev;
      tail.prev = node;
      node.next = tail;

      node.prev = node_prev;
      node_prev.next = node;


    }
    public void deleteNode(Node node) {

      Node node_prev = node.prev;
      Node node_next = node.next;

      node_prev.next = node_next;
      node_next.prev = node_prev;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MaxStack maxst = new MaxStack();

    while (read.ready()) {
      String []inp = read.readLine().split(" ");

      switch (inp[0]) {
        case "pop":
          System.out.println(maxst.pop());
          break;
        case "top":
          System.out.println(maxst.top());
          break;
        case "popMax":
          System.out.println(maxst.popMax());
          break;
        case "peekMax":
          System.out.println(maxst.peekMax());
          break;
        case "push":
          maxst.push(Integer.parseInt(inp[1]));
          break;
      }

    }

  }
}