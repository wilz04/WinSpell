public class Node {
  
  public char data;
  public Node next;
  public Tree son;
  
  public Node(String s) {
    this.data = s.charAt(0);
    next = null;
    son = new Tree();
    insert(s);
  }
  
  public void insert(String s) {
    if (!s.substring(1, s.length()).equals("")) {
      son.insert(s.substring(1, s.length()));
    }
  }
  
  public String getChar(String s) {
    s += data;
    s = son.getString(s);
    if (son._root == null) {
      s += '$';
    }
    return s;
  }
  
  public void show() {
    System.out.println("dato: " + this.data);
    son.show();
    if (son._root == null) {
      System.out.println("Fin de la palabra");
    }
  }
  
}