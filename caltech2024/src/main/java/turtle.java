import javax.swing.ImageIcon;

public class turtle extends Pet {

  public turtle(int i) {
    super(i);
    // TODO Auto-generated constructor stub
    this.imageHappy = new ImageIcon(this.getClass().getResource("/images/pets/turtle/turtle_happy.png"));
    this.imageSad = new ImageIcon(this.getClass().getResource("/images/pets/turtle/turtle_sad.png"));
    this.imageNeutral = new ImageIcon(this.getClass().getResource("/images/pets/turtle/turtle_neutral.png"));
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
