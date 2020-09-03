import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.Desktop;
import java.net.URI;

/**
 * The MarkOwenMacasaet class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms and Mark Owen Macasaet
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 * @ version 4.0 August 7, 2020
 */
public class MarkOwenMacasaet extends Student implements SpecialInterestOrHobby
{
    /**
     * Constructor for the MarkOwenMacasaet class.
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
    public MarkOwenMacasaet(String f, String l, int r, int s) 
    {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.png";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public MarkOwenMacasaet() 
    {
        firstName="MarkOwen";
        lastName="Macasaet";
        myRow=10;
        mySeat=4;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.png";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
    /**
     * Act - do whatever the MarkOwenMacasaet actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this))
        {
            //  if (sitting){
            sitting=false;
            setImage(standingFile);
            System.out.println(""); // Print a blank line to create space between any student output.
            getName();
            sayName(soundFile);
            
            myHobby("I like to play the violin!");
            myNumberOfSiblings("I have 2 siblings!");
            
            spinStudent(); //animate my character
            provideLesson(); //ask yes or no questions to determine when to link the tutorial
            sitDown(); //move back to seat
        }
        
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName()
    {
        System.out.println("My name is " + firstName + " " + lastName);
    }
    
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface, and provide
     * some mechanism that allows the student to sit down once the Q&A session ends.  You can use this basic model, or come up
     * with some additional class and object that represents a blackboard, or a talking cartoon bubble etc. If you provide extra
     * classes, make sure to fully document so other students can use the same interface.
     * Links youtube tutorial of strings lesson.
     */
    public void provideLesson()
    {
        while (! sitting) 
        {
            String q=Greenfoot.ask("Are you ready to start (yes/no)");
            if (q.contains("yes"))
            {
                try 
                {
                    Desktop desktop = java.awt.Desktop.getDesktop();
                    URI oURL = new URI("https://www.youtube.com/watch?v=FwiyK9Z5SMI"); //links the tutorial youtube video when yes is entered
                    desktop.browse(oURL);
                }    
                catch (Exception e) 
                {
                    e.printStackTrace();  
                }
            }
            else 
            {
                 q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
            }
            if (q.equals("yes"))
            {
                  Greenfoot.delay(10);
                  sitDown(); //return student to original seat
            }
        }   
        
    }
    
    public void answerQuestion()
    {
        // may not need
    }
    
    /**
     * This is a local method specific to the MarkOwenMacasaet class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     * Makes my character spin while moving back and forth on the bottom of the screen.
     */
    public void spinStudent()
    {
        setLocation(5,4);
        Greenfoot.delay(10);
        //move to the right while spinning
        for (int i=5;i<=10;i++)
        {
            setLocation(i,4);
            Greenfoot.delay(10);
            turn(45);
        }
        // move left while spinning
        for (int i=10;i>=0;i--)
        {
            setLocation(i,4);
            Greenfoot.delay(10);
            turn(45);
        }
        //move to the right while spinning
        for (int i=0;i<=5;i++)
        {
            setLocation(i,4);
            Greenfoot.delay(10);
            turn(45);
        }
        turn(45);
        Greenfoot.delay(20);
        returnToSeat();
    }
    
    /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
    public void myHobby(String s) 
    {
        System.out.println(s); //prints out a message of my hobby
    }
    
    public void myNumberOfSiblings (String n)
    {
        System.out.println(n); //prints out the number of siblings message
    }

}