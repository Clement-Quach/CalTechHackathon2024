import javax.swing.ImageIcon;

public class poro extends Pet{

    public poro(int i) {
        super(i);
        //TODO Auto-generated constructor stub
        this.imageHappy = new ImageIcon(this.getClass().getResource("/images/pets/poro/poro_happy.png"));
        this.imageSad = new ImageIcon(this.getClass().getResource("/images/pets/poro/poro_sad.png"));
        this.imageNeutral = new ImageIcon(this.getClass().getResource("/images/pets/poro/poro_neutral.png"));
    }
    public ImageIcon getHappyImage(){
        return this.imageHappy;
      }
    public ImageIcon getSadImage(){
        return this.imageSad;
      }
    public ImageIcon getNeutralImage(){
        return this.imageNeutral;
      }
    
}