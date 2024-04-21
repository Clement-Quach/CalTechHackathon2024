import java.awt.Component;

import javax.swing.ImageIcon;

public class Pet {
  private int hunger = 7;

  private final int petID;
  protected ImageIcon imageHappy;
  protected ImageIcon imageSad;
  protected ImageIcon imageNeutral;

  public Pet(int i) {
    petID = i;
  }

  /**
   * a method to see how hungry a creature is. 10 is neutral, 0 is very sad, 20 is
   * very happy
   * 
   * @return
   */
  public int getHunger() {
    return this.hunger;
  }

  /**
   * a way to call feedPet() with a default value of 1.
   */
  public void feedPet() {

    this.hunger += 1;
  }

  public void feedPet(int i) {
    this.hunger += i;
    if (this.hunger < 0) {
      this.hunger = 0;
    }
  }

  public int getId() {
    return this.petID;
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