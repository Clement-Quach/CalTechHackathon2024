public class RewardSystem {
  private int numOfBiscuts;
  private int choresDone;
  private final int choresPerTreat = 5;

  public RewardSystem() {
    numOfBiscuts = 1;
  }

  public void completeTask(int val) {
    choresDone += val;
    treatGenerate();
  }

  public void treatGenerate() {
    if (this.choresDone >= choresPerTreat) {
      while (this.choresDone - choresPerTreat >= choresPerTreat) {
        this.choresDone -= choresPerTreat;
        this.numOfBiscuts++;
      }
    }
  }

  public int getNumTreats() {
    return this.numOfBiscuts;
  }

  public void useTreat() {
    this.numOfBiscuts--;
  }

  public void giveNewTreat() {
    numOfBiscuts++;
  }

}
