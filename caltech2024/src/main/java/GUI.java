import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI {
    //defining
    private JFrame mainFrame; //creates frame
    private ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/icon.png")); //creates icon
    private JPanel topBar = new JPanel();
    private JButton questLog = new JButton();
    private ImageIcon questIcon = new ImageIcon(this.getClass().getResource("/images/questLog.png"));

    //main GUI
    public GUI(){
            // mainFrame settings
        mainFrame = new JFrame(); //creates frame
        mainFrame.setTitle("title"); //sets title
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(1600,1600); //sets dimensions
        mainFrame.setIconImage(icon.getImage());
        mainFrame.setVisible(true);
        mainFrame.setLayout(new BorderLayout());
            //questlog button
        questLog.setIcon(questIcon);
        questLog.addActionListener(e -> OpenQuestLog());
        questLog.setPreferredSize(new Dimension(64,64));
            //top bar
        topBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        topBar.setPreferredSize(new Dimension(1600, 100));
        topBar.add(questLog); 
        
        //adding components to frame
        mainFrame.add(topBar,BorderLayout.NORTH);
    }

    private void OpenQuestLog(){
        
    }

}
