import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * @author Grace Liu
 * @version 1.0 August 8, 2020
 */
public class GraceLiu extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the GraceLiu class.
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
    public GraceLiu(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        dancingFile = firstName.toLowerCase()+ lastName.toLowerCase()+"-dancing.jpg";
        setImage(portraitFile);
        soundFileAYR = f.toLowerCase()+l.toLowerCase()+"-areyouready.wav";
        soundDanceFile = f.toLowerCase() + l.toLowerCase() + "-dancemusic.wav";
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public GraceLiu() {
        firstName="Grace";
        lastName="Liu";
        myRow=2;
        mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        dancingFile = firstName.toLowerCase()+ lastName.toLowerCase()+"-dancing.jpg";
        soundFileAYR = firstName.toLowerCase()+lastName.toLowerCase()+"-areyouready.wav";
        setImage(portraitFile);
        soundDanceFile = firstName.toLowerCase() + lastName.toLowerCase() + "-dancemusic.wav";
        sitting=true;
    }
    
     /**
     * Act - do whatever the GraceLiu actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
          //  if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to read!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
  
                danceClass();  // Grace Liu's special method... Please write one of your own. You can use this, but please modify it and be creative.
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
    
    public void  provideLesson()
    {
        while(!sitting)
        {
           
            String ans = Greenfoot.ask("Would you like to view a lesson on 2D arrays?");
            if(ans.contains("y")||ans.contains("Y")) {
                ourLesson();
                break;
            }
            else if (ans.contains("n")||ans.contains("N")) {
                String ans2 = Greenfoot.ask("Okay, may I sit down?");
                if(ans2.contains("y")||ans2.contains("Y")){
                    sitDown();
                }
                break;
            }
            else {
                System.out.println("Please answer with 'yes' or 'no.'");
            }
            }
        }
    
    /** 
     * Code for the actual lesson.
     */
    public void ourLesson() {
        sitDown();
        Greenfoot.delay(100);
        for(int i=0;i<2;i++){
            System.out.println("\n");
        }
        Greenfoot.playSound("GraceLiulesson1.wav");
        System.out.println("Starting lesson...");
        Greenfoot.delay(100);
        System.out.println("AP CSA: TWO DIMENSIONAL ARRAYS, BY: RIA JAIN, GRACE LIU, JENNY WANG");
        System.out.println("\n");
        Greenfoot.delay(750);
        System.out.println("We will cover:");
        System.out.println("\ti. Introduction to 2D Arrays");
        Greenfoot.delay(150);
        System.out.println("\tii. Array Storage");
        Greenfoot.delay(150);
        System.out.println("\tiii. How to Declare 2D Arrays");
        Greenfoot.delay(150);
        System.out.println("\tiv. Set value(s) in a 2D Array");
        Greenfoot.delay(150);
        System.out.println("\tv. How to get a Value from a 2D Array");
        Greenfoot.delay(150);
        System.out.println("\tvi. How to Find the Number of Rows and Columns in a 2D Array");
        Greenfoot.delay(250);
        System.out.println("\tvii. How to loop through a 2D Array");
        Greenfoot.delay(150);
        System.out.println("\tviii. Using For-Each to Loop");
        Greenfoot.delay(150);
        System.out.println("\tix. Looping through Part of a 2D Array");
        Greenfoot.delay(150);
        System.out.println("\tx. Common Mistakes");
        Greenfoot.playSound("GraceLiulesson2.wav");
        Greenfoot.delay(500);
        String answer = Greenfoot.ask("Are you ready to begin watching the lesson?");
        Boolean a = true;
        while(a) {
            if(answer.contains("y")||answer.contains("Y")) {
                startLesson();
                break;
            }
            else if (answer.contains("n")||answer.contains("N")) {
                String ans2 = Greenfoot.ask("Okay, may I sit down?");
                if(ans2.contains("y")||ans2.contains("Y")){
                    sitDown();
                }
                break;
            }
            else {
                System.out.println("Please answer with 'yes' or 'no.'");
            }
        }
    }
    public void startLesson() 
    {
        bluej.utility.Utility.openWebBrowser("https://www.youtube.com/watch?v=prXUe8rXlp8&feature=youtu.be");
        Greenfoot.delay(150);
        String ans = Greenfoot.ask("Would you like to  view the notes for this lesson?");
        Boolean a = true;
        while(a) {
            if(ans.contains("y")||ans.contains("Y")) {
                bluej.utility.Utility.openWebBrowser("https://docs.google.com/document/d/17U_2yqYnbC4gpIYQSBEEClDZSNC4D5t38SGbU9HEB4M/edit");
                break;
            }
            else if (ans.contains("n")||ans.contains("N")) {
                String ans2 = Greenfoot.ask("Okay, may I sit down?");
                if(ans2.contains("y")||ans2.contains("Y")){
                    sitDown();
                }
                break;
            }
            else {
                System.out.println("Please answer with 'yes' or 'no.'");
            }
        }
    }

    
    public void answerQuestion(){
        // may not need
    }
    /**
     * This is a local method specific to the GraceLiu class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void danceClass(){
        setLocation(myRow,mySeat);
        Greenfoot.delay(30);
        sayAreYouReady(soundFileAYR);
        // move right
        Greenfoot.delay(10);
        for (int i=1;i<=10;i++){
            turn(30);
            Greenfoot.delay(10);
        }
        setRotation(0);
        
        for (int i=1;i<=5;i++){
            setImage(dancingFile);
            sayDance(soundDanceFile);
            move(1);
            Greenfoot.delay(200);
            setImage(standingFile);
            Greenfoot.delay(15);
            
        }
        /*
        for (int i=1;i<=10;i++){
            turn(30);
            Greenfoot.delay(10);
        }
        */
           Greenfoot.delay(20);
           setLocation(2,1);
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

}