import java.util.*;

public class Main {
  public static void main(String args[]) {
    SuffixTree st = new SuffixTree("abca".toCharArray());
    st.build();
    st.dfs();

  }
}
class SuffixTree {
  ///////////////////////////////////////////////////////////////// Code starts here
  public void dfs() {
    for (SuffixNode child : root.child) {
      if (child != null) {
        ArrayList<Character> asf = new ArrayList<Character>();
        dfsPrinter(child, asf);
      }
    }
  }
  public void dfsPrinter(SuffixNode node, ArrayList<Character> asf) {
    if (node == null) return;
    for (int i = node.start; i <= node.end.end; i++) {
      asf.add(input[i]);
    }
    if (node.index != -1) {
      for (Character c : asf) System.out.print(c);
      System.out.println();
      for (int i = node.start; i <= node.end.end; i++) {
        asf.remove(asf.size() - 1);
      }
      return;
    }

    for (SuffixNode child : node.child) {
      if (child != null) dfsPrinter(child, asf);;
    }
    for (int i = node.start; i <= node.end.end; i++) {
      asf.remove(asf.size() - 1);
    }
  }
  ///////////////////////////////////////////////////////////////// Code ends here
  public SuffixNode root;
  private Active active;
  private int remainingSuffixCount;
  private End end;
  private char input[];
  private static char UNIQUE_CHAR = '$';

  SuffixTree(char input[]) {
    this.input = new char[input.length + 1];
    for (int i = 0; i < input.length; i++) {
      this.input[i] = input[i];
    }
    this.input[input.length] = UNIQUE_CHAR;
  }

  public void build() {
    root = SuffixNode.createNode(1, new End(0));
    root.index = -1;
    active = new Active(root);
    this.end = new End(-1);
    //loop through string to start new phase
    for (int i = 0; i < input.length; i++) {
      startPhase(i);
    }

    if (remainingSuffixCount != 0) {
      System.out.print("Something wrong happened");
    }
    //finally walk the tree again and set up the index.
    setIndexUsingDfs(root, 0, input.length);
  }

  private void startPhase(int i) {
    //set lastCreatedInternalNode to null before start of every phase.
    SuffixNode lastCreatedInternalNode = null;
    //global end for leaf. Does rule 1 extension as per trick 3 by incrementing end.
    end.end++;

    //these many suffixes need to be created.
    remainingSuffixCount++;
    while (remainingSuffixCount > 0) {
      //if active length is 0 then look for current character from root.
      if (active.activeLength == 0) {
        //if current character from root is not null then increase active length by 1
        //and break out of while loop. This is rule 3 extension and trick 2 (show stopper)
        if (selectNode(i) != null) {
          active.activeEdge = selectNode(i).start;
          active.activeLength++;
          break;
        } //create a new leaf node with current character from leaf. This is rule 2 extension.
        else {
          root.child[input[i]] = SuffixNode.createNode(i, end);
          remainingSuffixCount--;
        }
      } else {
        //if active length is not 0 means we are traversing somewhere in middle. So check if next character is same as
        //current character.
        try {
          char ch = nextChar(i);
          //if next character is same as current character then do a walk down. This is again a rule 3 extension and
          //trick 2 (show stopper).
          if (ch == input[i]) {
            //if lastCreatedInternalNode is not null means rule 2 extension happened before this. Point suffix link of that node
            //to selected node using active point.
            //TODO - Could be wrong here. Do we only do this if when walk down goes past a node or we do it every time.
            if (lastCreatedInternalNode != null) {
              lastCreatedInternalNode.suffixLink = selectNode();
            }
            //walk down and update active node if required as per rules of active node update for rule 3 extension.
            walkDown(i);
            break;
          }
          else {
            //next character is not same as current character so create a new internal node as per
            //rule 2 extension.
            SuffixNode node = selectNode();
            int oldStart = node.start;
            node.start = node.start + active.activeLength;
            //create new internal node
            SuffixNode newInternalNode = SuffixNode.createNode(oldStart, new End(oldStart + active.activeLength - 1));

            //create new leaf node
            SuffixNode newLeafNode = SuffixNode.createNode(i, this.end);

            //set internal nodes child as old node and new leaf node.
            newInternalNode.child[input[newInternalNode.start + active.activeLength]] = node;
            newInternalNode.child[input[i]] = newLeafNode;
            newInternalNode.index = -1;
            active.activeNode.child[input[newInternalNode.start]] = newInternalNode;

            //if another internal node was created in last extension of this phase then suffix link of that
            //node will be this node.
            if (lastCreatedInternalNode != null) {
              lastCreatedInternalNode.suffixLink = newInternalNode;
            }
            //set this guy as lastCreatedInternalNode and if new internalNode is created in next extension of this phase
            //then point suffix of this node to that node. Meanwhile set suffix of this node to root.
            lastCreatedInternalNode = newInternalNode;
            newInternalNode.suffixLink = root;

            //if active node is not root then follow suffix link
            if (active.activeNode != root) {
              active.activeNode = active.activeNode.suffixLink;
            }
            //if active node is root then increase active index by one and decrease active length by 1
            else {
              active.activeEdge = active.activeEdge  + 1;
              active.activeLength--;
            }
            remainingSuffixCount--;
          }

        } catch (EndOfPathException e) {

          //this happens when we are looking for new character from end of current path edge. Here we already have internal node so
          //we don't have to create new internal node. Just create a leaf node from here and move to suffix new link.
          SuffixNode node = selectNode();
          node.child[input[i]] = SuffixNode.createNode(i, end);
          if (lastCreatedInternalNode != null) {
            lastCreatedInternalNode.suffixLink = node;
          }
          lastCreatedInternalNode = node;
          //if active node is not root then follow suffix link
          if (active.activeNode != root) {
            active.activeNode = active.activeNode.suffixLink;
          }
          //if active node is root then increase active index by one and decrease active length by 1
          else {
            active.activeEdge = active.activeEdge + 1;
            active.activeLength--;
          }
          remainingSuffixCount--;
        }
      }
    }
  }

  private void walkDown(int index) {
    SuffixNode node = selectNode();
    //active length is greater than path edge length.
    //walk past current node so change active point.
    //This is as per rules of walk down for rule 3 extension.
    if (diff(node) < active.activeLength) {
      active.activeNode = node;
      active.activeLength = active.activeLength - diff(node);
      active.activeEdge = node.child[input[index]].start;
    } else {
      active.activeLength++;
    }
  }

  //find next character to be compared to current phase character.
  private char nextChar(int i) throws EndOfPathException{
    SuffixNode node = selectNode();
    if (diff(node) >= active.activeLength) {
      return input[active.activeNode.child[input[active.activeEdge]].start + active.activeLength];
    }
    if (diff(node) + 1 == active.activeLength ) {
      if (node.child[input[i]] != null) {
        return input[i];
      }
    }
    else {
      active.activeNode = node;
      active.activeLength = active.activeLength - diff(node) - 1;
      active.activeEdge = active.activeEdge + diff(node)  + 1;
      return nextChar(i);
    }

    throw new EndOfPathException();
  }

  private static class EndOfPathException extends Exception {

  }

  private SuffixNode selectNode() {
    return active.activeNode.child[input[active.activeEdge]];
  }

  private SuffixNode selectNode(int index) {
    return active.activeNode.child[input[index]];
  }


  private int diff(SuffixNode node) {
    return node.end.end - node.start;
  }

  private void setIndexUsingDfs(SuffixNode root, int val, int size) {
    if (root == null) {
      return;
    }

    val += root.end.end - root.start + 1;
    if (root.index != -1) {
      root.index = size - val;
      return;
    }

    for (SuffixNode node : root.child) {
      setIndexUsingDfs(node, val, size);
    }
  }

  /**
   * Do a DFS traversal of the tree.
   */
  public void dfsTraversal() {
    List<Character> result = new ArrayList<>();
    for (SuffixNode node : root.child) {
      dfsTraversal(node, result);
    }
  }

  private void dfsTraversal(SuffixNode root, List<Character> result) {
    if (root == null) {
      return;
    }
    if (root.index != -1) {
      for (int i = root.start; i <= root.end.end; i++) {
        result.add(input[i]);
      }
      result.stream().forEach(System.out::print);
      System.out.println(" " + root.index);
      for (int i = root.start; i <= root.end.end; i++) {
        result.remove(result.size() - 1);
      }
      return;
    }

    for (int i = root.start; i <= root.end.end; i++) {
      result.add(input[i]);
    }

    for (SuffixNode node : root.child) {
      dfsTraversal(node, result);
    }

    for (int i = root.start; i <= root.end.end; i++) {
      result.remove(result.size() - 1);
    }

  }

  /**
   * Do validation of the tree by comparing all suffixes and their index at leaf node.
   */
  private boolean validate(SuffixNode root, char[] input, int index, int curr) {
    if (root == null) {
      System.out.println("Failed at " + curr + " for index " + index);
      return false;
    }

    if (root.index != -1) {
      if (root.index != index) {
        System.out.println("Index not same. Failed at " + curr + " for index " + index);
        return false;
      } else {
        return true;
      }
    }
    if (curr >= input.length) {
      System.out.println("Index not same. Failed at " + curr + " for index " + index);
      return false;
    }

    SuffixNode node = root.child[input[curr]];
    if (node == null) {
      System.out.println("Failed at " + curr + " for index " + index);
      return false;
    }
    int j = 0;
    for (int i = node.start ; i <= node.end.end; i++) {
      if (input[curr + j] != input[i] ) {
        System.out.println("Mismatch found " + input[curr + j] + " " + input[i]);
        return false;
      }
      j++;
    }
    curr += node.end.end - node.start + 1;
    return validate(node, input, index, curr);
  }

  public boolean validate() {
    for (int i = 0; i < this.input.length; i++) {
      if (!validate(this.root, this.input, i, i)) {
        System.out.println("Failed validation");
        return false;
      }
    }
    return true;
  }
}

class SuffixNode {

  private SuffixNode() {
  }

  private static final int TOTAL = 256;
  SuffixNode[] child = new SuffixNode[TOTAL];

  int start;
  End end;
  int index;

  SuffixNode suffixLink;

  public static SuffixNode createNode(int start, End end) {
    SuffixNode node = new SuffixNode();
    node.start = start;
    node.end = end;
    return node;
  }

  @Override
  public String toString() {
    StringBuffer buffer = new StringBuffer();
    int i = 0;
    for (SuffixNode node : child) {
      if (node != null) {
        buffer.append((char)i + " ");
      }
      i++;
    }
    return "SuffixNode [start=" + start + "]" + " " + buffer.toString();
  }
}

class End {
  public End(int end) {
    this.end = end;
  }
  int end;
}

class Active {
  Active(SuffixNode node) {
    activeLength = 0;
    activeNode = node;
    activeEdge = -1;
  }

  @Override
  public String toString() {
    return "Active [activeNode=" + activeNode + ", activeIndex=" + activeEdge + ", activeLength=" + activeLength + "]";
  }

  SuffixNode activeNode;
  int activeEdge;
  int activeLength;
}