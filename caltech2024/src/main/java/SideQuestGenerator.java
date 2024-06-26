import java.util.Random;

public class SideQuestGenerator {

  private static int status = 0;

  public SideQuest getQuest() {

    status++;
    return getQuest(status);
  }

  public SideQuest getQuest(int day) {
    if (day % 365 == 0) {
      return generateRandomYearly();
    }
    if (day % 7 == 0) {
      return generateRandomWeekly();
    }

    return generateRandomDaily();
  }

  public SideQuestGenerator() {

  }

  private SideQuest generateRandomDaily() {
    SideQuest sideQuest = new SideQuest();
    Random rand = new Random();

    int choice = rand.nextInt(1, 20);

    switch (choice) {
      case 1:
        sideQuest = new SideQuest("Wash the Dishes",
            "Finally go wash up all those saved up dishes of yours.",
            1 + status, 5);
        break;
      case 2:
        sideQuest = new SideQuest("Laundry",
            "Go wash your laundry so you'll have cloths to wear.",
            1 + status, 5);
        break;
      case 3:
        sideQuest = new SideQuest("Study",
            "Get your daily studying in to prepare for any upcoming tests.",
            1 + status, 5);
        break;
      case 4:
        sideQuest = new SideQuest("Shower",
            "Go shower, else you'll start stinking up the plac.e",
            1 + status, 5);
        break;
      case 5:
        sideQuest = new SideQuest("Floss your Teeth",
            "There is a reason your dentist always tells you to floss.",
            1 + status, 5);
        break;

      case 6:
        sideQuest = new SideQuest("Brush your Teeth",
            "Don't forget to brush your tongue to keep your breath smelling fresh.",
            1 + status, 5);
        break;
      case 7:
        sideQuest = new SideQuest("Go Excersise",
            "Make your future-self happy by sustaining a healthy body.",
            1 + status, 5);
        break;
      case 8:
        sideQuest = new SideQuest("Make your Bed",
            "Keeping your bed tidy leads to a clearer mind.",
            1 + status, 5);
        break;
      case 9:
        sideQuest = new SideQuest("Clean the Dinner Table",
            "Especially important for messy eaters. Always keep the table clean.",
            1 + status, 5);
        break;
      case 10:
        sideQuest = new SideQuest("Take out the Trash",
            "Throw the trash bag in your washroom away or even better take out all your trash.",
            1 + status, 5);
        break;
      case 11:
        sideQuest = new SideQuest("Fold the Clothes",
            "Don't think that you should skip folding the clothes bcause folding them makes them look neater when you need to wear them.",
            1 + status, 5);
        break;
      case 12:
        sideQuest = new SideQuest("Tidy up your Room",
            "Organize your room and make sure not to have any misplaced items or garbage layiong around.",
            1 + status, 5);
        break;
      case 13:
        sideQuest = new SideQuest("Drink Water",
            "Stay hydrated.",
            1 + status, 5);
        break;
      case 14:
        sideQuest = new SideQuest("Go Outside",
            "Go for a walk. Enjoy the outside air. If the weather is bad, just enjoy the scenary form your window.",
            1 + status, 5);
        break;
      case 15:
        sideQuest = new SideQuest("Do your Homework",
            "Your due date can be a while from now, but it's never too early to start. Even just writing the title is fine. Get it done.",
            1 + status, 5);
        break;
      case 16:
        sideQuest = new SideQuest("Hone your skills",
            "Have something you want to improve upon? Go practice. Skill comes from practice not talent.",
            1 + status, 5);
        break;
      case 17:
        sideQuest = new SideQuest("Feed your Pet",
            "Pets having nutrients is just as important as you having nutrients. Remember to feed them.",
            1 + status, 5);
        break;
      case 18:
        sideQuest = new SideQuest("Nap",
            "Napping is proven to statiscally improve the rate at which you learn. As long as you are studying ofcourse.",
            1 + status, 5);
        break;
      case 19:
        sideQuest = new SideQuest("Stretch",
            "You don't want to be as stiff as a rock when your old, so go do some stretches.",
            1 + status, 5);
        break;
      case 20:
        sideQuest = new SideQuest("Eat a Fruit",
            "Fruit pack a ton of nutrients. They have all the neccessary vitamins to prevent you form deterioting.",
            1 + status, 5);
        break;
      default:
        System.out.println("Invalid activity number.");
        return sideQuest;
    }
    sideQuest.setName("Daily Quest: " + sideQuest.getName());
    return sideQuest;

  }

  private SideQuest generateRandomWeekly() {

    SideQuest sideQuest = new SideQuest();
    Random rand = new Random();

    int choice = rand.nextInt(1, 10);
    switch (choice) {
      case 1:
        sideQuest = new SideQuest("Wash your Bedsheets",
            "Washing your bedsheets will lead to better sleep and cleaner body.",
            7 + status, 8);
        break;
      case 2:
        sideQuest = new SideQuest("Vacuum your Room",
            "Why stop at just your room, go do your whole house.",
            7 + status, 8);
        break;
      case 3:
        sideQuest = new SideQuest("Cook yourself a Hearty Meal",
            "Stop getting takeout and try cooking up a nice meal for yourself. You can even do meal prep for the whole week.",
            7 + status, 8);
        break;
      case 4:
        sideQuest = new SideQuest("Buy Groceries",
            "Always keep your fridge stocked. You never know when you'll want to grab a midnight snack.",
            7 + status, 8);
        break;
      case 5:
        sideQuest = new SideQuest("Clean up your pet's litter",
            "If you have a pet, go clean up those nasty leftovers of your pet. If you don't have a pet, take a break.",
            7 + status, 8);
        break;
      case 6:
        sideQuest = new SideQuest("Clean your Washroom",
            "You should clean your washroom else it'll start reeking of what you ate last night.",
            7 + status, 8);
        break;
      case 7:
        sideQuest = new SideQuest("Clean the Kitchen",
            "Always keep your kitchen clean and tidy so you don't spend extra time cleaning before you make food.",
            7 + status, 8);
        break;
      case 8:
        sideQuest = new SideQuest("Mow the Lawn",
            "Your grass is starting to outgrow you, stop them. if you don't have a lawn, take a break.",
            7 + status, 8);
        break;
      case 9:
        sideQuest = new SideQuest("Water your Plants",
            "Don't let them die. They wish to live just as much as you. Give them some love.",
            7 + status, 8);
        break;
      case 10:
        sideQuest = new SideQuest("Get Sleep",
            "Stuck in heavy sleep debt due to school? then now's your time to get lots of sleep.",
            7 + status, 8);
        break;
      default:
        System.out.println("Invalid activity number.");
        return sideQuest;
    }
    sideQuest.setName("Weekly Quest: " + sideQuest.getName());
    return sideQuest;
  }

  private SideQuest generateRandomYearly() {

    SideQuest sideQuest = new SideQuest();
    Random rand = new Random();

    int choice = rand.nextInt(1, 5);
    switch (choice) {
      case 1:
        sideQuest = new SideQuest("Try Learning a Language of your Choice",
            "Want to travel to foriegn countries? Well get a head start by learning a new language. Learning takes time, so take a one step at a time. Feel free to chekc this off once you feel like you learned what you should in a year.",
            365 + status, 500);
        break;
      case 2:
        sideQuest = new SideQuest("Get in Shape",
            "It's about drive, it's about power. Try going on a diet, eating less if you want to lose weight and more if you want to gain weight. Start goign to the gym regularly. Check this off once you have been consistently maintaining your goal for the year.",
            365 + status, 500);
        break;
      case 3:
        sideQuest = new SideQuest("Pick up a New Skill",
            "Ever saw something that fascinated you? Ever thought that you wanted to try it? Well you should. Practice it consistently for the year and you'll get better. Check it off once you have been consistently maintaing your goal for the year.",
            365 + status, 500);
        break;
      case 4:
        sideQuest = new SideQuest("Save Money",
            "Unless money isn't a problem to you, you have to start saving money. Setup some budgets and save the rest. Check it off once you have been consistently maintaing it for the year.",
            365 + status, 500);
        break;
      case 5:
        sideQuest = new SideQuest("Socialize or Spend Time on Yourself",
            "If you don't talk to people and you are too shy to do anything, now's your chance. Go out there and make new friends. Otherwise you can spend some time focusing on your and find ways to imporve yourself.",
            365 + status, 500);
        break;
      default:
        System.out.println("Invalid endeavor number.");
        return sideQuest;
    }

    sideQuest.setName("Yearly Quest!: " + sideQuest.getName());
    return sideQuest;
  }
}
