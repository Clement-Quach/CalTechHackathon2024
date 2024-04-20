
public class SideQuest extends Chore {

  public SideQuest() {

  }

  public SideQuest(String name, String desc, int timeLim, int treatVal) {
    super(name, desc);
    int RGB[] = { 0, 128, 255 };
    this.setRGB(RGB);
    this.assignedDate = this.assignedDate.plusDays(timeLim);
    this.treatValue = treatVal;
  }

  public int getTreatValue() {
    return this.treatValue;
  }

}