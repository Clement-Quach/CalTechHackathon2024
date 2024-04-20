import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI {
    //defining
    private JFrame mainFrame; //creates frame
    private ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/icon.png")); //creates icon
    private JButton questLog = new JButton();
    private ImageIcon questIcon = new ImageIcon(this.getClass().getResource("/images/questLog.png"));
    private JLayeredPane display = new JLayeredPane();
    private ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/images/background.png"));
    private JLabel background = new JLabel();
    //main GUI
    public GUI(){
            // mainFrame settings
        mainFrame = new JFrame(); //creates frame
        mainFrame.setTitle("title"); //sets title
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1920,1080); //sets dimensions
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setVisible(true);
        mainFrame.setLayout(new BorderLayout());
            //questlog button
        questLog.setIcon(questIcon);
        questLog.addActionListener(e -> OpenQuestLog());
        questLog.setBounds(0, 0, 64, 64);
        questLog.setOpaque(false);

        background.setIcon(backgroundImage);
        background.setBounds(0,-180,1920,1080);
        //adding components to frame
        display.add(background,Integer.valueOf(0));
        display.add(questLog, Integer.valueOf(1));
        mainFrame.add(display);
    }
    private void OpenQuestLog(){
        
    }

}
