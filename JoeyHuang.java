import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * The JoeyHuang class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author JoeyHuang
 * 
 * @version 1.0 August 7, 2020
 */

public class JoeyHuang extends Student implements SpecialInterestOrHobby
{
    private static int period = 2;
    /**
     * Constructor for the JoeyHuang class.
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public JoeyHuang(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".png";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.png";
        soundFile=f.toLowerCase()+l.toLowerCase()+".mp3";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    
    public int GetPeriod(){
        return period;
    }
    
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public JoeyHuang() {
        firstName="Joey";
        lastName="Huang";
        myRow=2;
        mySeat=1;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".png";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.png";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".mp3";
        GreenfootImage image = new GreenfootImage(soundFile);
        image.scale(13, 25);
        setImage(image);
        sitting=true;
    }
    
     /**
     * Act - do whatever the JoeyHuang actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
           if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
                myHobby("I like to swim!");                
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
                animation();  // my animation

                provideLesson();
                sitDown();
            }
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
        while (!sitting) {
        String q=Greenfoot.ask("Are you ready to start the lesson? (yes/no)");
        if (q.contains("yes")){
            
         // put in your lesson here - you can open up a browser for a screencast
         // Create a blackboard image and write to it, etc
         // Use an animated gif and dub over with audio - see "controls/show sound recoder"
         // from main greenfoot menu for a simple to use soud editor
         
         
        // You can end the lesson and "sitDown" once the lesson is complete, or once
        // someone answers "yes" to the sitdown question
        bluej.utility.Utility.openWebBrowser("https://tiny.cc/sortinglessoncsa");
        }
        else {
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
        }
         if (q.contains("yes")){
            Greenfoot.delay(10);            
            sitDown();
        }
    }
        
    }
    /**
     * This is a local method specific to the TanishB class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void animation(){
        setLocation(0,0);
        Greenfoot.delay(10);
        int defaultRotation = getRotation();
        // spin and move right
        for (int i=1;i<=6;i++){
            setLocation(i,0);
            Greenfoot.delay(10);
            setRotation(i*10);
        }
        setRotation(defaultRotation);
         // move down
        for (int i=6;i>=2;i--){
            setLocation(i,i);
            Greenfoot.delay(10);
        } 
           Greenfoot.delay(20);
           returnToSeat();
    }
    public void answerQuestion(){
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
