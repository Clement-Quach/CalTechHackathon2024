import java.util.ArrayList;

public class ChoresList {

  private ArrayList<Chore> list = new ArrayList<>();

  private int ChoresCount;

  public ChoresList() {
    ChoresCount = 0;

  }

  public void add(Chore chr) {
    list.add(chr);
  }

  public void remove(Chore chr) {
    list.remove(chr);
  }

  public Chore getChoreAt(int i) {
    return list.get(i);
  }

  public ChoresList(Chore... chr) {
    for (Chore c : chr) {
      list.add(c);
    }
  }

  public Chore[] getList() {
    Chore retList[] = new Chore[list.size()];
    int i = 0;
    for (Chore c : list) {
      retList[i] = c;
      i++;
    }

    return retList;
  }

  public int getSize() {
    return ChoresCount;
  }

  /**
   * complete the chore at index i
   */
  public void choreComplete(int i) {
    list.get(i).setCompletion(true);
  }

}
