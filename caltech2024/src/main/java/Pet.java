public class Pet {
  private int hunger = 10;

  public final int petID;

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
  }

  public int getId() {
    return this.petID;
  }

}