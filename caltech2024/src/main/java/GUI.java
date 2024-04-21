import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUI {

  // Defining
  private JFrame mainFrame; // creates frame
  private ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/icon.png")); // creates icon
  private JButton questLog = new JButton();
  private ImageIcon questIcon = new ImageIcon(this.getClass().getResource("/images/questLog.png"));
  private JLayeredPane display = new JLayeredPane();
  private ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/images/background.png"));
  private JLabel background = new JLabel();
  private App app;
  private JPanel questLogPanel; // Panel for quest log content
  private JButton closeQuestLogButton; // Close button for quest log
  private JLabel snackCountLabel; // Label to display snack count

  // Main GUI
  public GUI(App app) {
    this.app = app;

    // MainFrame settings
    mainFrame = new JFrame(); // creates frame
    mainFrame.setTitle("title"); // sets title
    mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainFrame.setSize(800, 800); // sets dimensions
    mainFrame.setIconImage(icon.getImage());
    mainFrame.setVisible(true);
    mainFrame.setLayout(new BorderLayout());

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

    snackCountLabel = new JLabel("Snacks: " + app.getNumTreats());
    snackCountLabel.setBounds(64, 0, 64, 64);
    display.add(snackCountLabel,Integer.valueOf(1));

    background.setIcon(backgroundImage);
    background.setBounds(0,-180,1920,1080);
    // Adding components to frame
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
    questLogPanel.setBounds(300, 200, 780, 500);;
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
