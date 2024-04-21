
import java.time.LocalDate;

public class Chore {

  protected boolean done;
  private int RGB[] = new int[3];
  protected LocalDate assignedDate;
  protected String name;
  protected String description;
  protected int treatValue;

  public Chore() {
    this.assignedDate = LocalDate.now();
  }

  public Chore(String name, String desc) {
    this.done = false;
    this.assignedDate = LocalDate.now();
    this.name = name;
    this.description = desc;
    this.treatValue = 1;
  }

  public boolean getCompletion() {
    return this.done;
  }

  public String getDateString() {
    return this.assignedDate.toString();
  }

  public void addToDay(int addVal) {
    this.assignedDate.plusDays(addVal);
  }

  public String getName() {
    return this.name;
  }

  public String getDescription() {
    return description;
  }

  public LocalDate getDate() {
    return this.assignedDate;
  }

  public int[] getRGB() {
    return this.RGB;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public void setRGB(int inRGB[]) {
    if (inRGB.length < 3) {
      return;
    }

    for (int i = 0; i <= 2; i++) {
      if (inRGB[i] > 255 || inRGB[i] < 0) {
        return;
      }
      this.RGB[i] = inRGB[i];
    }
  }

  public void setCompletion(boolean status) {
    this.done = status;
  }

  public int getTreatVal() {
    return this.treatValue;
  }

  public void setTreat(int val) {
    this.treatValue = val;
  }

}
