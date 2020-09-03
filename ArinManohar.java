import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Desktop;
import java.net.URI;

import java.io.IOException;


/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Arin Manohar 
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class ArinManohar extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the KilgoreTrout class.
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
    public ArinManohar(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpeg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpeg";
        standingFile2=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing2.jpeg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public ArinManohar() {
        firstName="Arin";
        lastName="Manohar";
        myRow=1;
        mySeat=1;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpeg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpeg";
        standingFile2=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing2.jpeg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
    private void move()
    {
        //creates random motion
        
        for (int i=1;i<=19;i++){
            move(2);
            Greenfoot.delay(5);
            turn(Greenfoot.getRandomNumber(61)-30);
            if (isAtEdge()) {
                turn(81);
                Greenfoot.delay(10);
                setImage(standingFile);
            }  
            if  (Greenfoot.getRandomNumber(100) < 20) {
                turn(Greenfoot.getRandomNumber(61)-30);
                setRotation(150);
                setImage(standingFile2);
            }
        }
        setImage(standingFile);
        setRotation(0);
    }
    
     /**
     * Act - do whatever the KilgoreTrout actor wants to do. This method is called whenever
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
            
                myHobby("I like to watch Gordon Ramsay");
                NumberOfSiblings("I have no siblings");
            
            
                move();
            
                circleClass();  // Made modifications to this in the circleclass method, along with my own move() method
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
         // opens a youtube link for our tutorial
          
            
            try {
                  Desktop desktop = java.awt.Desktop.getDesktop();
                  URI oURL = new URI("https://www.youtube.com/watch?v=FwiyK9Z5SMI");
                  desktop.browse(oURL);
                } 
            catch (Exception e) {
                  e.printStackTrace();
                }
           
            sitDown();
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
         * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
         * You should write your own methods to perform your own animation for your character/avatar.
         */
        public void circleClass(){
        // non linear movement modification
            
        setLocation(0,0);
         Greenfoot.delay(10);
        // move right
        for (int i=1;i<=9;i++){
            setLocation(i^2,0);
            Greenfoot.delay(10);
        }
        // move back
        for (int i=1;i<=5;i++){
            setLocation(i+4,i);
            Greenfoot.delay(10);
        }      
         // move left
        for (int i=9;i>=0;i--){
            setLocation(i-4,5);
            Greenfoot.delay(10);
        }      
              // move Forward
        for (int i=5;i>=0;i--){
            setLocation(0,i);
            Greenfoot.delay(10);
        }   
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
        
        public void NumberOfSiblings(String n) {
            System.out.println(n);
        }
}