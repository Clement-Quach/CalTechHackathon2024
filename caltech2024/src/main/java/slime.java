import javax.swing.ImageIcon;

public class slime extends Pet {
  public slime(int i) {
    super(i);
    // TODO Auto-generated constructor stub
    this.imageHappy = new ImageIcon(this.getClass().getResource("/images/pets/slime/slime_happy.png"));
    this.imageSad = new ImageIcon(this.getClass().getResource("/images/pets/slime/slime_sad.png"));
    this.imageNeutral = new ImageIcon(this.getClass().getResource("/images/pets/slime/slime_neutral.png"));
  }

  public ImageIcon getHappyImage() {
    return this.imageHappy;
  }

  public ImageIcon getSadImage() {
    return this.imageSad;
  }

  public ImageIcon getNeutralImage() {
    return this.imageNeutral;
  }
}
