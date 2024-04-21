import java.time.LocalDate;
import java.util.ArrayList;

public class App {
  private int counter = 1;
  private LocalDate today;
  private Pet pet;
  private ChoresList myList;
  private RewardSystem rewardSystem;
  private SideQuestGenerator generator;

  private final int petReduce = -2;

  /**
   * the current index of the pet we are dealing with.
   */
  private int currentPet = 0;
  private ArrayList<Pet> petList = new ArrayList<>();

  public App() {
    today = LocalDate.now();
    pet = new poro(1);
    petList.add(pet);
    petList.add(new turtle(2));
    petList.add(new slime(3));

    myList = new ChoresList();
    rewardSystem = new RewardSystem();
    generator = new SideQuestGenerator();

    myList.add(generator.getQuest(365));
    myList.add(generator.getQuest(7));
    myList.add(generator.getQuest(1));
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

  /**
   * function to pass the day. in total, the function will increase the date and
   * reduce all pets hapiness by petReduce
   */
  public void passOneDay() {
    counter++;
    today = today.plusDays(1);
    for (int i = 0; i < petList.size(); i++) {
      petList.get(i).feedPet(petReduce);

    }

  }

  /**
   * returns the date in game. the date begins on todays actual date, and
   * increases for every passOneDay() is called
   * 
   * @return
   */
  public LocalDate getDay() {
    return this.today;
  }

  /**
   * generates new daily, weekly, and yearly quests.
   */
  public void generateNewSide() {
    Chore temp = generator.getQuest();
    if (counter % 365 == 0) {
      myList.add(generator.getQuest(365));
    }
    if (counter % 7 == 0) {
      myList.add(generator.getQuest(7));

    }
    myList.add(generator.getQuest(1));
    myList.add(generator.getQuest(1));

  }

  /**
   * rotate the pet that is displayed
   * 
   * @return
   */
  public void rotatePet() {
    currentPet++;
    if (currentPet > petList.size() - 1) {
      currentPet = 0;
    }
  }

  /**
   * gets the pet that we currently point to.
   * 
   * @return the ID of the current pet.
   */
  public Pet getPet() {
    return petList.get(currentPet);
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

      petList.get(currentPet).feedPet();
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

    return this.rewardSystem.getNumTreats();
  }

  /**
   * adds a chores to the list of chores.
   * this function takes in the name and description and gives the due date equal
   * to today.
   * 
   * @param name        the name of the chore
   * @param description a description of what the chore will be
   */
  public void addChore(String name, String description) {
    this.myList.add(new Chore(name, description, this.getDay()));
  }

  /**
   * adds a chore that is passsed in to the list.
   * 
   * @param chr the chore that will be added to the list.
   */
  public void addChore(Chore chr) {

    this.myList.add(chr);
  }

  /**
   * takes in an integer and returns the chore that is at the position in the
   * list.
   * you can combine this function with find chore to pass in a chore from a
   * foreach loop
   * to return the refrence to that chore in order to edit it.
   * 
   * @param i the index of the chore
   * @return the chore at the index
   */
  public Chore getChoreAt(int i) {
    return myList.getChoreAt(i);
  }

  /**
   * remove a chore based on a specific chore using arraylist functions.
   * 
   * @param c the chore you are going to remove.
   */
  public void removeChore(Chore c) {
    myList.remove(c);
  }

  /**
   * returns an array of chores from the list. is used to print out all of the
   * chores, and used
   * for foreach loops
   * 
   * @return an array of chores in the order that they are made in the array list.
   */
  public Chore[] listShow() {
    return myList.getList();
  }

  /**
   * developer function to add a treat to the counter for testing mostly.
   */
  public void addTreat() {
    rewardSystem.giveNewTreat();
  }

  /**
   * passes in a chore and returns the index of that chore in the list of chores.
   * uses arraylist functions.
   * 
   * @param c the chore whos index you are trying to find.
   * @return the index of the chore
   */
  public int findChore(Chore c) {
    int i = myList.findChore(c);
    return i;
  }

}
