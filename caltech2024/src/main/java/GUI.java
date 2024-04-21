import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI {

  // Defining
  private JFrame mainFrame; // creates frame

  //images
  private ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/icon.png")); //logo icon
  private ImageIcon questIcon = new ImageIcon(this.getClass().getResource("/images/questLog.png")); //questlogicon
  private ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/images/background.png")); //background image
  private ImageIcon taiyakiIcon = new ImageIcon(this.getClass().getResource("/images/taiyaki.png")); //taiyaki image
    //poro images
  private ImageIcon poroHappyIcon = new ImageIcon(this.getClass().getResource("/images/pets/poro/poro_happy.png"));
  private ImageIcon poroSadIcon = new ImageIcon(this.getClass().getResource("/images/pets/poro/poro_sad.png"));
  private ImageIcon poroNeutralIcon = new ImageIcon(this.getClass().getResource("/images/pets/poro/poro_neutral.png"));
  //pets
  private JLabel poro = new JLabel();
  private JButton feedButton = new JButton();
  //others
  GraphicsEnvironment graphics = GraphicsEnvironment.getLocalGraphicsEnvironment();
  GraphicsDevice device = graphics.getDefaultScreenDevice();
  private JButton questLog = new JButton();
  private JLayeredPane display = new JLayeredPane();
  private JLabel background = new JLabel();
  private App app;
  private JPanel questLogPanel; // Panel for quest log content
  private JButton closeQuestLogButton; // Close button for quest log
  private JLabel snackCountLabel; // Label to display snack count
  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  // Main GUI
  public GUI(App app) {
    this.app = app;
    // MainFrame settings
    mainFrame = new JFrame(); // creates frame
    mainFrame.setTitle("Quest Log"); // sets title
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(800, 800); // sets dimensions
    mainFrame.setIconImage(icon.getImage());
    mainFrame.setVisible(true);
    mainFrame.setLayout(new BorderLayout());
    device.setFullScreenWindow(mainFrame);
    // questLog button
    questLog.setIcon(questIcon);
    questLog.setBounds(0, 0, 64, 64);

    // Add MouseListener to questLog button
    questLog.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (questLogPanel == null) {
          createQuestLogPanel();
        }
        showQuestLogPanel(); // Show or hide quest log panel

      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      // ... (other MouseListener methods not required)
    });


    GridBagConstraints snackCountConstraints = new GridBagConstraints();

    snackCountConstraints.anchor = GridBagConstraints.NORTHEAST; // Anchor to top and east
    snackCountConstraints.insets = new Insets(10, 10, 10, 10); // Add some padding

    snackCountLabel = new JLabel();
    snackCountLabel.setText("Snacks: " + app.getNumTreats());
    snackCountLabel.setIcon(taiyakiIcon);
    snackCountLabel.setBounds(64, 0,160, 64);
    display.add(snackCountLabel,Integer.valueOf(1));

    background.setIcon(backgroundImage);
    background.setBounds(0,-180,1920,1080);

    //feeding button
    feedButton.setBackground(new Color(0x05b331));
    feedButton.setText("Feed");
    feedButton.setBounds(0,0,160,48);
    feedButton.setLocation(dim.width/2-feedButton.getSize().width/2, dim.height/2+250-feedButton.getSize().height/2);
    feedButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        app.feedPet(); //feed pet
        snackCountLabel.setText("Snacks: " + app.getNumTreats());
      }

      @Override
      public void mousePressed(MouseEvent e) {

      }

      @Override
      public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      @Override
      public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
      }

      // ... (other MouseListener methods not required)
    });
    //pet things
    poro.setIcon(poroNeutralIcon);
    // Adding components to frame
    display.add(feedButton, Integer.valueOf(1));
    display.add(background,Integer.valueOf(0));
    display.add(questLog, Integer.valueOf(1));
    mainFrame.add(display);
  }

  private void completeChore(Chore c) {
    this.app.completeTask(app.findChore(c));
    snackCountLabel.setText("Snacks: " + app.getNumTreats());
  }

  private void createQuestLogPanel() {
    questLogPanel = new JPanel();
    questLogPanel.setLayout(new BoxLayout(questLogPanel, BoxLayout.Y_AXIS)); // Use BoxLayout
    questLogPanel.setOpaque(true); // Make panel transparent

    // Create close button
    closeQuestLogButton = new JButton("X");
    closeQuestLogButton.setPreferredSize(new Dimension(30, 30));
    closeQuestLogButton.addActionListener(e -> hideQuestLogPanel()); // Hide on click

    // Add close button to quest log panel
    questLogPanel.add(closeQuestLogButton);

    // Loop through each chore in the quest log
    for (Chore chore : app.listShow()) {
      // Create a button with chore name
      JButton choreButton = new JButton(chore.getName());
      choreButton.addActionListener(e -> completeChore(chore)); // Print on click

      // Set button properties (optional)
      // choreButton.setForeground(new Color(chore.getRGB()[0], chore.getRGB()[1],
      // chore.getRGB()[2]));

      String wrappedDescription = wrapTextByWords(chore.getDescription(), 20);
      JLabel descriptionLabel = new JLabel("<html>" + wrappedDescription + "</html>");
      descriptionLabel.setPreferredSize(new Dimension(mainFrame.getWidth() - choreButton.getPreferredSize().width - 20, 0));

      // Add components to questLogPanel
      questLogPanel.add(choreButton);
      questLogPanel.add(descriptionLabel);
    }

    // Add questLogPanel to main frame (but don't set visible yet)
    questLogPanel.setBounds(0,0, 780, 500);
    questLogPanel.setLocation(dim.width/2-questLogPanel.getSize().width/2, dim.height/2-questLogPanel.getSize().height/2);
    display.add(questLogPanel,Integer.valueOf(2));
  }

  private void showQuestLogPanel() {
    if (questLogPanel == null) {
      createQuestLogPanel();
    }
    questLogPanel.setVisible(!questLogPanel.isVisible()); // Toggle visibility
  }

  private void hideQuestLogPanel() {
    if (questLogPanel != null) {
      questLogPanel.setVisible(false);
    }
  }

  // Helper method to wrap text with line breaks
  private String wrapTextByWords(String text, int wordLimit) {
    StringBuilder sb = new StringBuilder();
    String[] words = text.split("\\s+"); // Split text into words
    int wordCount = 0;
    for (String word : words) {
      if (wordCount > 0 && wordCount % wordLimit == 0) {
        sb.append("<br>"); // Add line break after wordLimit words
      }
      sb.append(word).append(" ");
      wordCount++;
    }
    return sb.toString().trim(); // Remove trailing space
  }
}
