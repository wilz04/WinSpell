import javax.swing.JOptionPane;

import java.io.*;

public class File {
  
  /** Escritura de la clase 'Base' */
  private static void write() {
    try {
      DataOutputStream output = new DataOutputStream(new FileOutputStream("Base.class"));
      for (int i = 1; i <= 260; i++) {
        String word = JOptionPane.showInputDialog("Inserte la palabra " + i + ":");
        output.writeUTF(word);
      }
      output.close();
    } catch (Exception e) {
      System.out.println(e);
    }
    System.exit(0);
  }
  
  /** Lectura de la clase 'Base' */
  public static Tree read() {
    Tree tree = new Tree();
    try {
      DataInputStream input = new DataInputStream(new FileInputStream("Base.class"));
      while (true) {
        tree.insert(input.readUTF());
      }
    } catch (Exception e){
      System.out.println(e);
    }
    return tree;
  }
  
  public static void main(String args[]) {
    write();
  }
  
}