import java.io.*;

public class Tree {
  
  public Node _root;
  
  public Tree() {
    _root = null;
  }
  
  public void insert(String s) {
    if (_root == null) {
      _root = new Node(s);
    } else if (_root.data == s.charAt(0)) {
      _root.insert(s);
    } else {
      boolean found = false;
      Node temp = _root;
      while (temp.next != null) {
        if (temp.data == s.charAt(0)) {
          found = true;
          temp.insert(s);
          break;
        } else {
          temp = temp.next;
        }
      }
      if (found == false) {
        temp.next = new Node(s);
      }
    }
  }
  
  public String getWord(int n) {
    String s = getString();
    String newS = "";
    String word = "";
    int j = 0;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == '$') {
        if (j != n) {
          newS = "";
          j++;
        } else {
          word = newS;
          break;
        }
      } else {
        newS += s.charAt(i);
      }
    }
    return word;
  }
  
  public String getString() {
    return getString("");
  }
  
  public String getString(String s) {
    Node temp = _root;
    while (temp != null) {
      s = temp.getChar(s);
      temp = temp.next;
    }
    return s;
  }
  
  public void show() {
    Node temp = _root;
    while (temp != null) {
      temp.show();
      temp = temp.next;
    }
  }
  
}
