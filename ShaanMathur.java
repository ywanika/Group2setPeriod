import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ShaanMathur class can be used as a model for your own class that represents you and your seating location in AP CSA
 * Part of loopGroup
 * @author Mr. Kaehms and modified by Shaan Mathur
 * @version 08/07/20
 */
public class ShaanMathur extends LoopGroup implements NumberOfSiblings, SpecialInterestOrHobby, StudentAthlete
{

    /**
     * Constructor for the ShaanMathur class.
     * Constructors are special methods with the same exact name as the class name.  
     * Constructors to not have return types.
     * Constructors can be overloaded. This means we can call a constructor with different sets of parameter
     *  lists to initalize for different conditions (depending on what constructors have been written.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public ShaanMathur(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";   
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public ShaanMathur() {
        firstName="Kilgore";
        lastName="Trout";
        myRow=1;
        mySeat=1;
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the ShaanMathur actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
          if(Greenfoot.mouseClicked(this)){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); 
                getName();
                sayName(soundFile);
            
                myHobby("I like to watch movies!");
                System.out.println("I have " + Integer.toString(numberOfSiblings()) + " siblings.");
                myHobby("I love to cook!");
                mySport("I play golf and powerlift!");
                circleClass();
                provideLesson();
                sitDown();
            }
        
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName);
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     */
    public void provideLesson(){
        while (! sitting) {
        String q=Greenfoot.ask("Are you ready to start (yes/no)");
        if (q.contains("yes")){
            bluej.utility.Utility.openWebBrowser("https://drive.google.com/file/d/1xE0wQSPAU1Ku_Fzbr64Y8EkrfhlJKMiO/view?usp=sharing");
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
         if (q.equals("yes")){
            Greenfoot.delay(10);
            sitDown();
        }
    }
        
    }
    public void answerQuestion(){
        // may not need
    }
    /**
     * This is a local method specific to the ShaanMathur class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void circleClass(){
        setLocation(0,0);
        Greenfoot.delay(10);
        // move right
        for (int i=1;i<=9;i++){
            setImage("shaanmathur-right.jpg");
            getWorld().setBackground(new GreenfootImage("epic.gif"));
            setLocation(i,0);
            Greenfoot.delay(10);
        }
        // move back
        for (int i=1;i<=5;i++){
            setImage("shaanmathur-left.jpg");
            setLocation(9,i);
            Greenfoot.delay(10);
        }      
         // move left
        for (int i=9;i>=0;i--){
            setImage("shaanmathur-right.jpg");
            setLocation(i,5);
            Greenfoot.delay(10);
        }      
              // move Forward
        for (int i=5;i>=0;i--){
            setImage("shaanmathur-left.jpg");
            getWorld().setBackground(new GreenfootImage("csa.jpg"));
            setLocation(0,i);
            Greenfoot.delay(10);
        }   
           sayName("classic.mp3");
           Greenfoot.delay(20);
           returnToSeat();
    }
     /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
     public void myHobby(String s) {
         System.out.println(s);
    }

    /**
     * interface that totals my number of siblings 
     */
    public int numberOfSiblings() {
        return numberOfBrothers() + numberOfSisters();
    }
    
    /**
     * interface that gives my number of brothers as 0 
     */
    public int numberOfBrothers() {
        return 0;
    }
    
    /**
     * interface that gives my number of sisters as 0
     */
    public int numberOfSisters() {
        return 0;
    }

    /**
     * interface that states my sport
     */
    public void mySport(String s) {
        System.out.println(s);
    }
    
}
