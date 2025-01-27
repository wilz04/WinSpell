import javax.swing.*;

public class OnRelease {
  
  //Archivo
  
  public static void saveFile(String fileName, String text) {
    try {
      if (!fileName.substring(fileName.length() - 4, fileName.length()).equals(".wsd")) {
        fileName += ".wsd";
      }
      
      java.io.FileWriter fileWriter = new java.io.FileWriter(fileName);
      java.io.BufferedWriter bufferedWriter = new java.io.BufferedWriter(fileWriter);
      bufferedWriter.write(text);
      bufferedWriter.close();
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, "Error al guardar el documento", "WinSpell", JOptionPane.INFORMATION_MESSAGE);
    }
  }
  
  public static void exit() {
    System.exit(0);
  }
  
  //Herramientas
  
  public static String spelling() {
    String s = JOptionPane.showInputDialog("Inserte la palabra:");
    int length;
    Tree tree = File.read();
    boolean more = true;
    String newS = "";
    String word = "$";
    int i = 0;
    int j = 0;
    int k = 0;
    int oldk = 0;
    while (more) {
      word = tree.getWord(i);
      length = Math.min(s.length(), word.length());
      if (word != "") {
        for (j = 0; j < length; j++) {
          if (word.charAt(j) == s.charAt(j)) {
            k++;
            if (k > oldk) {
              newS = word;
              oldk = k;
            }
          }
        }
      } else {
        more = false;
      }
      k = 0;
      i++;
    }
    JOptionPane.showMessageDialog(null, newS, "Sugerencia", JOptionPane.INFORMATION_MESSAGE);
    return newS;
  }
  
  //Ayuda
  
  public static void about() {
    JOptionPane.showMessageDialog(null, "Wilberth Castro Fuentes\nJorge Ramírez Barrantes\nErick Salas Araya", "A cerca de I-Square ®", JOptionPane.INFORMATION_MESSAGE);
  }
  
}