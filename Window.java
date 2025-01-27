import java.awt.*;
import java.awt.event.*;
import java.net.*;
import javax.swing.*;

class Window extends JFrame implements ActionListener {
  
  private JMenuItem miNew, miOpen, miSave, miExit;
  private JMenuItem miCut, miCopy, miPaste;
  private JMenuItem miSpelling;
  private JMenuItem miAbout;
  private JEditorPane editorPane;
  
  /** Creacion de la ventana */
  public Window() {
    JMenuBar menuBar = new JMenuBar();
    JMenu mFile = new JMenu("Archivo");
    JMenu mEdit = new JMenu("Edición");
    JMenu mTools = new JMenu("Herramientas");
    JMenu mHelp = new JMenu("Ayuda");
    Font black = new Font("Verdana", 1, 10);
    Font normal = new Font("Verdana", 0, 10);
    
    miNew = new JMenuItem("Nuevo");
    miOpen = new JMenuItem("Abrir");
    miSave = new JMenuItem("Guardar");
    miExit = new JMenuItem("Salir");
    
    miCut = new JMenuItem("Cortar");
    miCopy = new JMenuItem("Copiar");
    miPaste = new JMenuItem("Pegar");
    
    miSpelling = new JMenuItem("Ortografía");
    
    miAbout = new JMenuItem("Acerca de...");
    
    mFile.setFont(black);
    mEdit.setFont(black);
    mTools.setFont(black);
    mHelp.setFont(black);
    
    miNew.setFont(normal);
    miOpen.setFont(normal);
    miSave.setFont(normal);
    miExit.setFont(normal);
    
    miCut.setFont(normal);
    miCopy.setFont(normal);
    miPaste.setFont(normal);
    
    miSpelling.setFont(normal);
    
    miAbout.setFont(normal);
    
    miNew.addActionListener(this);
    miOpen.addActionListener(this);
    miSave.addActionListener(this);
    miExit.addActionListener(this);
    
    miCut.addActionListener(this);
    miCopy.addActionListener(this);
    miPaste.addActionListener(this);
    
    miSpelling.addActionListener(this);
    
    miAbout.addActionListener(this);
    
    mFile.add(miNew);
    mFile.add(miOpen);
    mFile.add(miSave);
    mFile.addSeparator();
    mFile.add(miExit);
    
    mEdit.add(miCut);
    mEdit.add(miCopy);
    mEdit.add(miPaste);
    
    mTools.add(miSpelling);
    
    mHelp.add(miAbout);
    
    menuBar.add(mFile);
    menuBar.add(mEdit);
    menuBar.add(mTools);
    menuBar.add(mHelp);
    
    setJMenuBar(menuBar);
    
    setLayout(new GridLayout(1, 1));
    editorPane = new JEditorPane();
    editorPane.setFont(normal);
    add(new JScrollPane(editorPane));
    
    addWindowListener(
      new WindowAdapter() {
        public void windowClosing(WindowEvent e) {
          dispose();
          System.exit(0);
        }
      }
    );
  }
  
  /** Reacciones a eventos */
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == miNew) {
      editorPane.setText("");
    }
    if (e.getSource() == miOpen) {
      JFileChooser fileChooser = new JFileChooser();
      int fcFocus = fileChooser.showOpenDialog(this);
      if (fcFocus == fileChooser.APPROVE_OPTION) {
        try {
          URL fileName = fileChooser.getSelectedFile().toURL();
          editorPane.setPage(fileName);
        } catch (Exception io) {
          JOptionPane.showMessageDialog(null, "Error al abrir el documento", "WinSpell", JOptionPane.INFORMATION_MESSAGE);
        }
      }
    }
    if (e.getSource() == miSave) {
      String fileName;
      JFileChooser fileChooser = new JFileChooser();
      int fcFocus = fileChooser.showSaveDialog(this);
      if (fcFocus == fileChooser.APPROVE_OPTION) {
        fileName = fileChooser.getSelectedFile().getAbsolutePath();
        
        OnRelease.saveFile(fileName, editorPane.getText());
        
      }
    }
    if (e.getSource() == miExit) {
      OnRelease.exit();
    }
    
    if (e.getSource() == miCut) {
      editorPane.cut();
    }
    if (e.getSource() == miCopy) {
      editorPane.copy();
    }
    if (e.getSource() == miPaste) {
      editorPane.paste();
    }
    
    if (e.getSource() == miSpelling) {
      String newS = OnRelease.spelling();
      editorPane.setText(editorPane.getText() + newS);
    }
    
    if (e.getSource() == miAbout) {
      OnRelease.about();
    }
  }
  /** Método principal */
  public static void main(String args[]) {
    Window mainFrame = new Window();
    mainFrame.setSize(550, 400);
    mainFrame.setTitle("WinSpell");
    mainFrame.setVisible(true);
  }
}