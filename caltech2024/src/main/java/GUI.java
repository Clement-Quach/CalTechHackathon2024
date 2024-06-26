import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class GUI {
  // Defining
  private JFrame mainFrame; // creates frame

  // images
  private ImageIcon icon = new ImageIcon(this.getClass().getResource("/images/icon.png")); // logo icon
  private ImageIcon questIcon = new ImageIcon(this.getClass().getResource("/images/questLog.png")); // questlogicon
  private ImageIcon backgroundImage = new ImageIcon(this.getClass().getResource("/images/background.png")); // background
                                                                                                            // image
  private ImageIcon taiyakiIcon = new ImageIcon(this.getClass().getResource("/images/taiyaki.png")); // taiyaki image
  // pets
  private JLayeredPane petDisplay = new JLayeredPane();
  private JLabel petHappiness = new JLabel();
  private JLabel currentPetIcon = new JLabel();
  private JButton feedButton = new JButton();
  private Pet currentPet;
  // others
  private JButton questLog = new JButton();
  private JLayeredPane display = new JLayeredPane();
  private JLabel background = new JLabel();
  private App app;
  private JPanel questLogPanel; // Panel for quest log content
  private JButton closeQuestLogButton; // Close button for quest log
  private JLabel date;
  private JLabel snackCountLabel; // Label to display snack count
  Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
  private JButton addQuestButton;
  // move 1 day
  private JButton passOneDayButton;
  // rotate pets
  private JButton switchPet;

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
    // questLog button

    Image tempImage = questIcon.getImage(); // transform it
    Image tempNewImage = tempImage.getScaledInstance(dim.width / 30, dim.width / 30, java.awt.Image.SCALE_SMOOTH); // scale
                                                                                                                   // it
                                                                                                                   // the
                                                                                                                   // smooth
    // way
    questIcon = new ImageIcon(tempNewImage); // transform it back
    questLog.setIcon(questIcon);
    questLog.setBounds(0, 0, dim.width / 30, dim.width / 30);

    // Add MouseListener to questLog button
    questLog.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        if (questLogPanel == null) {
          createQuestLogPanel();
        }
        questLogPanel.setVisible(true);
        addQuestButton.setVisible(true);

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
    snackCountLabel.setBounds(dim.width / 30, 0, dim.width / 12, dim.width / 30);

    date = new JLabel();
    date.setText(app.getDay().toString());
    date.setBounds((int) dim.getWidth() - 100, 30, 100, 30);

    // add display counters
    display.add(date, Integer.valueOf(1));
    display.add(snackCountLabel, Integer.valueOf(1));

    Image image = backgroundImage.getImage(); // transform it
    Image newimg = image.getScaledInstance(dim.width, dim.height, java.awt.Image.SCALE_SMOOTH); // scale it the smooth
                                                                                                // way
    backgroundImage = new ImageIcon(newimg); // transform it back
    background.setIcon(backgroundImage);
    background.setBounds(0, 0, dim.width, dim.height);
    // displaying pet
    /*
     * diplay
     * what happiness
     * if >10
     * display pet happy
     */
    // setting up current pet
    Pet currentPet = app.getPet();
    int currentID = currentPet.getId();
    refreshPet();
    currentPetIcon.setBounds(0, 0, dim.width / 4, dim.width / 4);
    petDisplay.add(currentPetIcon, Integer.valueOf(3));
    petDisplay.setBounds(0, 0, dim.width / 3, dim.width / 3);
    petDisplay.setLocation(dim.width / 2 - petDisplay.getSize().width / 2,
        dim.height / 2 - petDisplay.getSize().height / 2);
    currentPetIcon.setLocation(petDisplay.getSize().width / 2 - currentPetIcon.getSize().width / 4,
        petDisplay.getSize().width / 2 - currentPetIcon.getSize().width / 2);
    // setting up happineesss
    petHappiness.setBackground(new Color(0xFFFFFF));
    petHappiness.setBounds(0, 0, dim.width / 7, dim.height / 30);
    petHappiness.setText("Happiness: " + currentPet.getHunger() + "/20");
    petHappiness.setFont(new Font(petHappiness.getFont().getName(), petHappiness.getFont().getStyle(), 30));
    petHappiness.setHorizontalAlignment(SwingConstants.CENTER);
    petHappiness.setVerticalAlignment(SwingConstants.CENTER);
    petHappiness.setOpaque(true);
    petDisplay.add(petHappiness, Integer.valueOf(5));
    petHappiness.setLocation(petDisplay.getSize().width / 2 - petHappiness.getSize().width / 2,
        petDisplay.getSize().width / 2 - petHappiness.getSize().width / 2 - dim.width / 12);

    // feeding button
    feedButton.setBackground(new Color(0x05b331));
    feedButton.setText("Feed");
    feedButton.setBounds(0, 0, dim.width / 12, dim.height * 2 / 45);
    feedButton.setLocation(dim.width / 2 - feedButton.getSize().width / 2,
        dim.height / 2 + dim.height / 3 - feedButton.getSize().height / 2);
    feedButton.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        app.feedPet(); // feed pet
        snackCountLabel.setText("Snacks: " + app.getNumTreats());
        refreshPet();

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

    // pass one day
    // Pass one day button
    passOneDayButton = new JButton("Pass One Day");
    passOneDayButton.setBounds((int) (dim.getWidth() - dim.getWidth() * 0.2), 60, (int) (dim.getWidth() * 0.2), 30);
    passOneDayButton.addActionListener(e -> passDay());

    // switch pets
    switchPet = new JButton("change pet");
    switchPet.setBounds((int) dim.getWidth() - 100, (int) dim.getHeight() - 200, 100, 70);

    switchPet.addActionListener(e -> rotatePets());

    // Adding components to frame
    display.add(feedButton, Integer.valueOf(1));
    display.add(background, Integer.valueOf(0));
    display.add(questLog, Integer.valueOf(1));
    display.add(passOneDayButton, Integer.valueOf(2)); // Add to layered pane with higher index
    display.add(switchPet, Integer.valueOf(1));
    display.add(petDisplay, Integer.valueOf(1));
    // add chore
    addQuestButton = new JButton("+add");
    addQuestButton.setBounds((int) (dim.getWidth() / 2 + dim.getWidth() * 0.15), (int) (dim.getHeight() * 0.7), 100,
        25);
    addQuestButton.addActionListener(e -> addChore()); // Print on click
    display.add(addQuestButton, Integer.valueOf(3)); // Add to layered pane with higher index
    addQuestButton.setVisible(false);

    mainFrame.add(display);
  }

  public void refreshPet() {
    currentPet = app.getPet();
    int happyL = currentPet.getMoodThreshold();

    if (happyL == 3) {
      currentPetIcon.setIcon(currentPet.getHappyImage());
    } else if (happyL == 2) {
      currentPetIcon.setIcon(currentPet.getNeutralImage());
    } else {
      currentPetIcon.setIcon(currentPet.getSadImage());
    }
    petHappiness.setText("Happiness: " + currentPet.getHunger() + "/20");

  }

  public void rotatePets() {
    app.rotatePet();
    refreshPet();
  }

  public void addChore() {
    String nm = showInputDialog("enter name for this quest");
    String desc = showInputDialog("give this quest a description");
    String Day = showInputDialog("how many days will this take");
    Chore c = new Chore(nm, desc);
    try {
      int intDay = Integer.parseInt(Day);
      c.addToDay(intDay);
    } catch (Exception e) {
      System.out.println("did not input proper num");
    }
    app.addChore(c);
    updateQuestLogPanel();

  }

  /**
   * move forward one day. this increments the current date by 1, checks if you've
   * failed any tasks, and generates new ones.
   */
  private void passDay() {

    app.passOneDay();
    for (Chore c : app.listShow()) {
      if (app.getDay().compareTo(c.getDate()) >= 0) {
        app.removeChore(c);
      }
    }

    app.generateNewSide();
    updateQuestLogPanel();
    date.setText(app.getDay().toString());

    refreshPet();
  }

  private void updateQuestLogPanel() {
    if (questLogPanel == null) {
      return; // Do nothing if quest log panel is not created yet
    }

    // Clear existing components from the quest log panel
    questLogPanel.removeAll();

    // Add close button again (optional, can be outside the loop)
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
      descriptionLabel
          .setPreferredSize(new Dimension(mainFrame.getWidth() - choreButton.getPreferredSize().width - 20, 0));
      JLabel dueDate = new JLabel("Due: " + chore.getDateString());
      // Add components to questLogPanel
      questLogPanel.add(choreButton);
      questLogPanel.add(descriptionLabel);
      questLogPanel.add(dueDate);
    }

    // revalidate and repaint the quest log panel to reflect changes
    questLogPanel.revalidate();
    questLogPanel.repaint();

  }

  public String showInputDialog(String message1) {
    // Use JOptionPane for user input dialog
    String userInput = JOptionPane.showInputDialog(mainFrame, message1);
    return userInput;
  }

  private void completeChore(Chore c) {

    if (showConfirmationDialog("are you done this chore?") == 0) {
      this.app.completeTask(app.findChore(c));
      snackCountLabel.setText("Snacks: " + app.getNumTreats());
      this.app.removeChore(c);
      updateQuestLogPanel();
    }

  }

  public int showConfirmationDialog(String message) {
    // Create confirmation dialog with options and custom icon (optional)
    int confirmDialog = JOptionPane.showConfirmDialog(
        mainFrame, // Parent component for the dialog
        message, // Message to display
        "Confirmation", // Dialog title
        JOptionPane.YES_NO_OPTION, // Option types (YES_NO, OK_CANCEL, etc.)
        JOptionPane.QUESTION_MESSAGE // Message type icon (INFORMATION, WARNING, QUESTION, etc.)
    );
    return confirmDialog;
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
      descriptionLabel
          .setPreferredSize(new Dimension(mainFrame.getWidth() - choreButton.getPreferredSize().width - 20, 0));
      JLabel dueDate = new JLabel("Due: " + chore.getDateString());

      // Add components to questLogPanel
      questLogPanel.add(choreButton);
      questLogPanel.add(descriptionLabel);
      questLogPanel.add(dueDate);

    }

    // Add questLogPanel to main frame (but don't set visible yet)
    questLogPanel.setBounds(0, 0, 780, 500);
    questLogPanel.setLocation(dim.width / 2 - questLogPanel.getSize().width / 2,
        dim.height / 2 - questLogPanel.getSize().height / 2);
    display.add(questLogPanel, Integer.valueOf(2));
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
      addQuestButton.setVisible(false);
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
