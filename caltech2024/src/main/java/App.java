import java.util.ArrayList;

public class App {

  private Pet pet;
  private ChoresList myList;
  private RewardSystem rewardSystem;
  private SideQuestGenerator generator;

  /**
   * the current index of the pet we are dealing with.
   */
  private int currentPet = 0;
  private ArrayList<Pet> petList = new ArrayList<>();

  public App() {

    pet = new Pet(1);
    petList.add(pet);
    myList = new ChoresList();
    rewardSystem = new RewardSystem();
    generator = new SideQuestGenerator();

    myList.add(generator.getQuest(365));
    myList.add(generator.getQuest(7));
    myList.add(generator.getQuest(1));
  }

  public void addPet(int i) {
    petList.add(new Pet(i));
  }

  public int getPet() {
    return petList.get(currentPet).petID;
  }

  /**
   * pass in the pet number you want to move to. ie, pet 1, pet 2, pet 3. this
   * starts at 1.
   * 
   * @param i the pet you want to move towards.
   */
  public void changePet(int i) {
    currentPet = i - 1;
  }

  /**
   * finish the task at the array index 1;
   * 
   * @param i index of the chore you want to finish
   */
  public void completeTask(int i) {
    int temp = myList.getChoreAt(i).getTreatVal();

    myList.choreComplete(i);
    rewardSystem.completeTask(temp);
  }

  public void feedPet(int i) {
    if (this.rewardSystem.getNumTreats() > 0) {
      petList.get(currentPet).feedPet(1);
      this.rewardSystem.useTreat();
    }
  }

  public int getPetHappiness() {
    return petList.get(currentPet).getHunger();
  }

  public int getNumTreats() {
    return this.rewardSystem.getNumTreats();
  }

  public void addChore(String name, String description) {
    this.myList.add(new Chore(name, description));
  }

  public Chore getChoreAt(int i) {
    return myList.getChoreAt(i);
  }

  public Chore[] listShow() {
    return myList.getList();
  }

}
