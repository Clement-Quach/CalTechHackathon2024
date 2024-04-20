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
        sideQuest = new SideQuest("Bread Baking",
            "Learn the art of making homemade bread from scratch, experimenting with different types of flour, yeast, and techniques to achieve the perfect loaf.",
            1, 5);
        break;
      case 2:
        sideQuest = new SideQuest("Basic Coding",
            "Dive into an introductory coding tutorial online to learn the fundamentals of programming languages like Python or JavaScript, empowering yourself with valuable tech skills.",
            1, 5);
        break;
      case 3:
        sideQuest = new SideQuest("Mindfulness Meditation",
            "Practice mindfulness meditation for at least 10 minutes to cultivate awareness, reduce stress, and enhance overall well-being.",
            1, 5);
        break;
      case 4:
        sideQuest = new SideQuest("Creative Writing",
            "Start a journaling practice or explore creative writing prompts to unleash your imagination and express your thoughts and emotions through storytelling.",
            1, 5);
        break;
      case 5:
        sideQuest = new SideQuest("Yoga Practice",
            "Follow a guided yoga session on YouTube or a yoga app to stretch, strengthen, and relax your body and mind, promoting physical and mental health.",
            1, 5);
        break;

      case 6:
        sideQuest = new SideQuest("Plant Care",
            "Research different houseplants and their care requirements, then spend some time tending to your indoor garden, nurturing your green thumb.",
            1, 5);
        break;
      case 7:
        sideQuest = new SideQuest("Language Learning",
            "Dedicate time to learning new words or phrases in a foreign language using language learning apps like Duolingo or Rosetta Stone, broadening your linguistic skills.",
            1, 5);
        break;
      case 8:
        sideQuest = new SideQuest("Photography Skills",
            "Experiment with composition, lighting, and perspective by taking photographs of everyday objects or scenes, honing your photography skills and artistic eye.",
            1, 5);
        break;
      case 9:
        sideQuest = new SideQuest("DIY Home Improvement",
            "Tackle a small home improvement project, such as painting a room, installing shelves, or organizing a closet, to enhance your living space and build practical skills.",
            1, 5);
        break;
      case 10:
        sideQuest = new SideQuest("Cooking a New Recipe",
            "Choose a recipe you've never tried before and challenge yourself to cook a delicious and nutritious meal from scratch, expanding your culinary repertoire.",
            1, 5);
        break;
      case 11:
        sideQuest = new SideQuest("Drawing or Sketching",
            "Grab a pencil and sketchpad and practice drawing objects, people, or landscapes, tapping into your creativity and improving your drawing skills.",
            1, 5);
        break;
      case 12:
        sideQuest = new SideQuest("Financial Literacy",
            "Educate yourself about personal finance topics such as budgeting, saving, investing, and managing debt, empowering yourself to make informed financial decisions.",
            1, 5);
        break;
      case 13:
        sideQuest = new SideQuest("Digital Design Basics",
            "Explore beginner tutorials for graphic design software like Adobe Photoshop or Canva, learning how to create visually appealing graphics and designs.",
            1, 5);
        break;
      case 14:
        sideQuest = new SideQuest("Gardening Basics",
            "Research gardening tips and techniques for your climate and region, then spend time planting seeds, tending to your garden, and connecting with nature.",
            1, 5);
        break;
      case 15:
        sideQuest = new SideQuest("Introduction to Philosophy",
            "Read introductory articles or watch online lectures to explore fundamental philosophical concepts and thinkers, stimulating your intellect and critical thinking skills.",
            1, 5);
        break;
      case 16:
        sideQuest = new SideQuest("Music Instrument Practice",
            "Dedicate time to practicing a musical instrument you're learning or improving upon, whether it's the guitar, piano, violin, or any other instrument.",
            1, 5);
        break;
      case 17:
        sideQuest = new SideQuest("Bodyweight Workout",
            "Follow a bodyweight workout routine that targets different muscle groups, incorporating exercises like squats, push-ups, lunges, and planks to stay active and fit.",
            1, 5);
        break;
      case 18:
        sideQuest = new SideQuest("Art Appreciation",
            "Visit an online art gallery or museum virtually to explore diverse art styles, movements, and masterpieces, enriching your understanding and appreciation of art.",
            1, 5);
        break;
      case 19:
        sideQuest = new SideQuest("Podcast Listening",
            "Listen to a podcast episode on a topic that interests you, whether it's science, history, true crime, self-improvement, or comedy, expanding your knowledge and perspective.",
            1, 5);
        break;
      case 20:
        sideQuest = new SideQuest("Environmental Awareness",
            "Watch a documentary or read articles about environmental issues such as climate change, pollution, or wildlife conservation, deepening your understanding of global environmental challenges and inspiring you to take action.",
            1, 5);
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
        sideQuest = new SideQuest("Digital Illustration Bootcamp",
            "Spend a week diving into digital illustration techniques using software like Adobe Illustrator or Procreate. Learn how to create digital artwork, develop your style, and bring your creative ideas to life.",
            7, 8);
        break;
      case 2:
        sideQuest = new SideQuest("Video Production Crash Course",
            "Enroll in a week-long video production crash course to learn the basics of filming, editing, and storytelling. Explore camera techniques, editing software, and production workflows to create professional-quality videos.",
            7, 8);
        break;
      case 3:
        sideQuest = new SideQuest("Entrepreneurship Workshop",
            "Participate in a week-long entrepreneurship workshop to explore the fundamentals of starting and running a business. Learn about market research, business planning, marketing strategies, and financial management to launch your entrepreneurial journey.",
            7, 8);
        break;
      case 4:
        sideQuest = new SideQuest("Advanced Cooking Techniques",
            "Dedicate a week to mastering advanced cooking techniques and recipes. Explore culinary topics such as sous vide cooking, molecular gastronomy, pastry arts, and international cuisines to elevate your cooking skills.",
            7, 8);
        break;
      case 5:
        sideQuest = new SideQuest("Web Design Sprint",
            "Join a week-long web design sprint to learn rapid prototyping and design iteration techniques. Work collaboratively with a team to conceptualize, design, and prototype a website or web application from start to finish.",
            7, 8);
        break;
      case 6:
        sideQuest = new SideQuest("Data Science Bootcamp",
            "Immerse yourself in a week-long data science bootcamp to learn advanced data analysis, machine learning, and data visualization techniques. Dive into real-world datasets and projects to build your data science portfolio.",
            7, 8);
        break;
      case 7:
        sideQuest = new SideQuest("Music Production Workshop",
            "Enroll in a week-long music production workshop to learn the ins and outs of music production software and techniques. Explore topics such as MIDI sequencing, audio recording, mixing, and mastering to create your own music tracks.",
            7, 8);
        break;
      case 8:
        sideQuest = new SideQuest("Creative Coding Exploration",
            "Spend a week exploring creative coding projects using platforms like Processing or p5.js. Experiment with code-driven art, interactive animations, and generative design to unleash your creativity in the digital realm.",
            7, 8);
        break;
      case 9:
        sideQuest = new SideQuest("Personal Branding Intensive",
            "Use a week to develop your personal brand and online presence. Define your unique value proposition, create professional profiles on social media and professional networking sites, and develop a content strategy to showcase your expertise and interests.",
            7, 8);
        break;
      case 10:
        sideQuest = new SideQuest("Outdoor Adventure Retreat",
            "Retreat to nature for a week-long outdoor adventure experience. Engage in activities such as hiking, camping, kayaking, or rock climbing to reconnect with the natural world, refresh your mind, and rejuvenate your spirit.",
            7, 8);
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
        sideQuest = new SideQuest("Language Fluency Journey",
            "Embark on a journey to achieve fluency in a new language. Dedicate consistent time each day to studying vocabulary, grammar, and conversation practice. Immerse yourself in the language through media, books, and language exchange programs to accelerate your learning and become proficient over the course of the year.",
            365, 500);
        break;
      case 2:
        sideQuest = new SideQuest("Fitness Transformation Challenge",
            "Commit to a year-long fitness transformation challenge to improve your physical health and well-being. Set specific fitness goals such as weight loss, muscle gain, or endurance improvement, and create a structured workout plan tailored to your objectives. Monitor your progress, adjust your routine as needed, and celebrate your achievements along the way.",
            365, 500);
        break;
      case 3:
        sideQuest = new SideQuest("Career Development Plan",
            "Develop a comprehensive career development plan to advance your professional goals over the course of the year. Identify areas for skill development, networking opportunities, and career milestones. Invest in professional development courses, workshops, and certifications to enhance your expertise and increase your marketability in your chosen field.",
            365, 500);
        break;
      case 4:
        sideQuest = new SideQuest("Travel and Cultural Exploration",
            "Plan a year-long travel adventure to explore diverse cultures, landscapes, and experiences around the world. Create a travel itinerary that includes destinations you've always wanted to visit, as well as off-the-beaten-path locations to immerse yourself in new perspectives and traditions. Keep a travel journal, capture memories through photography, and embrace the journey of discovery.",
            365, 500);
        break;
      case 5:
        sideQuest = new SideQuest("Passion Project Pursuit",
            "Pursue a passion project that ignites your creativity and fulfills your personal interests and aspirations. Whether it's writing a novel, starting a podcast, learning a musical instrument, or launching a social impact initiative, dedicate consistent time and effort to make progress towards your passion project goals throughout the year. Enjoy the process of exploration, growth, and self-expression as you bring your vision to life.",
            365, 500);
        break;
      default:
        System.out.println("Invalid endeavor number.");
        return sideQuest;
    }

    sideQuest.setName("Yearly Quest!: " + sideQuest.getName());
    return sideQuest;
  }
}
