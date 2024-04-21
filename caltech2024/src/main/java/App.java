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

  /**
   * adds a pet to the list with an id. this id will determine what the pet looks
   * like
   * 
   * @param i the id of the pet.
   */
  public void addPet(int i) {
    petList.add(new Pet(i));
  }

  public void generateNewSide() {
    myList.add(generator.getQuest());
  }

  /**
   * gets the pet that we currently point to.
   * 
   * @return the ID of the current pet.
   */
  public int getPet() {
    return petList.get(currentPet).petID;
  }

  public int getListSize() {
    return myList.getSize();
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

    if (myList.choreComplete(i)) {

      rewardSystem.completeTask(temp);
    }

  }

  /**
   * feed the pet a snack. feeds only if
   * you have a treat
   *
   */
  public void feedPet() {
    if (this.rewardSystem.getNumTreats() > 0) {
      petList.get(currentPet).feedPet(1);
      this.rewardSystem.useTreat();
    }
  }

  /**
   * returns an integer that is how hungry the current pet is.
   * 0 is very sad
   * 10 is neutral
   * 20 is happy
   * 
   * @return how happy the current pet is
   */
  public int getPetHappiness() {
    return petList.get(currentPet).getHunger();
  }

  /**
   * see how many treats you are able to give the pet
   * 
   * @return
   */
  public int getNumTreats() {
    System.out.println(this.rewardSystem.getNumTreats());
    return this.rewardSystem.getNumTreats();
  }

  public void addChore(String name, String description) {
    this.myList.add(new Chore(name, description));
  }

  public void addChore(Chore chr) {
    this.myList.add(chr);
  }

  public Chore getChoreAt(int i) {
    return myList.getChoreAt(i);
  }

  public void removeChore(Chore c) {
    myList.remove(c);
  }

  public Chore[] listShow() {
    return myList.getList();
  }

  public void addTreat() {
    rewardSystem.giveNewTreat();
  }

  public int findChore(Chore c) {
    int i = myList.findChore(c);
    return i;
  }
}
