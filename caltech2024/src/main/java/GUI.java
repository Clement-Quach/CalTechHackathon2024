import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI {
  private JFrame frame; // creates frame
  private ImageIcon image = new ImageIcon(this.getClass().getResource("/images/icon.png")); // creates icon

  public GUI() {
    frame = new JFrame(); // creates frame
    frame.setTitle("title"); // sets title
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(420, 420); // sets dimensions
    frame.setIconImage(image.getImage());
    frame.setVisible(true);
  }
}
