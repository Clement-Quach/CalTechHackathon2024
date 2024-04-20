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
   * feed the pet to make it not hungry. adds the value of feed value to the pet
   * 
   * @param feedValue the value that we are going to increase the hunger variable
   *                  by
   */
  public void feedPet(int feedValue) {
    this.hunger += feedValue;
  }

  /**
   * a way to call feedPet() with a default value of 1.
   */
  public void feedPet() {
    feedPet(1);
  }

  public int getId() {
    return this.petID;
  }

}