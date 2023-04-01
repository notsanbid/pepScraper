import java.io.*;
import java.util.*;

public class Main {
  public static class MyCircularDeque<T> {

    public class Node {
      T data;
      Node next;
      Node pre;

      Node() {
        data = null;
      }
      Node(T value) {
        data = value;
      }

      public void delete () {
        next.pre = pre;
        pre.next = next;
      }
    }

    final private Node head;
    final private Node tail;
    private int size;
    /** Initialize your data structure here.*/
    public MyCircularDeque() {
      head = new Node();
      tail = new Node();
      head.next = tail;
      tail.pre = head;
      size = 0;
    }

    /**
     * Adds an item at the front of Deque.
     */
    public void insertFront(T value) {
      Node n = new Node(value);
      n.next = head.next;
      head.next = n;
      n.next.pre = n;
      n.pre = head;
      size++;
    }

    /**
     * Adds an item at the rear of Deque.
     */
    public void insertLast(T value) {
      Node n = new Node(value);
      n.next = tail;
      n.pre = tail.pre;
      n.pre.next = n;
      tail.pre = n;
      size++;
    }

    /**
     * Deletes an item from the front of Deque. Return true if the operation is
     * successful.
     */
    public T deleteFront() {
      if (size == 0)return null;

      Node n = head.next;
      T value = n.data;
      n.delete();
      size--;
      return value;
    }

    /**
     * Deletes an item from the rear of Deque. Return true if the operation is
     * successful.
     */
    public T deleteLast() {
      if (size == 0)return null;

      Node n = tail.pre;
      T value = n.data;

      n.delete();
      size--;
      return value;
    }

    /** Get the front item from the deque. */
    public T getFront() {
      if (size == 0)return null;
      return head.next.data;
    }

    /** Get the last item from the deque. */
    public T getRear() {
      if (size == 0)return null;
      return tail.pre.data;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
      return size == 0;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MyCircularDeque<Integer> obj = new MyCircularDeque<>();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");
      String s = inp[0];

      if (s.equals("insertLast")) {
        obj.insertLast(Integer.parseInt(inp[1]));
      } else if (s.equals("insertFront")) {
        obj.insertFront(Integer.parseInt(inp[1]));
      } else if (s.equals("deleteFront")) {
        System.out.println(obj.deleteFront());
      } else if (s.equals("deleteLast")) {
        System.out.println(obj.deleteLast());
      } else if (s.equals("getFront")) {
        System.out.println(obj.getFront());
      } else if (s.equals("getRear")) {
        System.out.println(obj.getRear());
      } else if (s.equals("isEmpty")) {
        System.out.println(obj.isEmpty());
      }
    }

  }
}