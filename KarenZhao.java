
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Introduces the student Karen Zhao and a lesson on variables in Java.
 * 
 * @author Karen Zhao
 * @version August 10, 2020
 */
public class KarenZhao extends Student implements NumberOfSiblings, SpecialInterestOrHobby, StudentAthlete, StudentLeadership
{
    public String standingFile1;
    public String standingFile2;
    
    /**
     * Constructor for the KarenZhao class.
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
    public KarenZhao(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing1.jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing2.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public KarenZhao() {
        firstName="Karen";
        lastName="Zhao";
        myRow=3;
        mySeat=3;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing1.jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing2.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * Act - do whatever the KarenZhao actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Action code
        if(Greenfoot.mouseClicked(this)){
          //  if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Prints a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                System.out.println("I have " + Integer.toString(numberOfSisters()) + " sisters and " + Integer.toString(numberOfBrothers()) + " brother.");
                myHobby("I like to skateboard!");
                mySport("I play badminton!");
                myRoleInLeadership();
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                wave();  // Karen Zhao's special method... Please write one of your own. You can use this, but please modify it and be creative.
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
        String q=Greenfoot.ask("Are you ready to start the lesson? (yes/no)");
        if (q.contains("yes")){
         // The lesson about variables in Java opens up in a browser as a screencast.
        if (q.equals("yes")) {
            bluej.utility.Utility.openWebBrowser("https://drive.google.com/file/d/1lu72UjM4JoWIJnIByJckuli2tlNB4lG1/view?usp=sharing");
            answerQuestion();
        } 
        else {
            q=Greenfoot.ask("That's fine, may I sit down? (yes/no)");
        }
            if (q.equals("yes")) {
                Greenfoot.delay(10);
                sitDown();
            }
        }
    }
        
    }
    public void answerQuestion(){
        // may not need
    }
    /**
     * This is a local method specific to the KarenZhao class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void wave(){
        int i = 0;
        GreenfootImage stand1 = new GreenfootImage("karenzhao-standing1.jpg");
        GreenfootImage stand2 = new GreenfootImage("karenzhao-standing2.jpg");
        
        stand1.fill();
        stand2.fill();
        setImage(stand1);
        Greenfoot.delay(10);
        setImage(stand2);
        Greenfoot.delay(10);
        
        i++;

    }
     /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
     public void myHobby(String s) {
         System.out.println(s);
        } //Prints given sentence about hobbies/interests/
     public int numberOfSiblings() {
         return 3;
        } //Returns given number of siblings.
     public int numberOfBrothers() {
         return 1;
        } //Returns given number of brothers.
     public int numberOfSisters() {
         return 2;
        } //Returns given number of sisters.
     public void mySport(String s) {
         System.out.println(s);
        } //Prints given sentence about athletics.
     public void myRoleInLeadership() {
         System.out.println("I'm captain of a VEX Robotics team!");
        } //Prints given sentence about leadership.
}