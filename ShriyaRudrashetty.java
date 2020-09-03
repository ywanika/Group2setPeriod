 
import greenfoot.*; 
import java.net.*; 
import java.awt.*;// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The ShriyaRudrashetty class represents Shriya Rudrashetty and her seating location. It included an animation and a lesson.
 * 
 * @author Shriya Rudrashetty
 * @version 2.0 8/7/2020
 */
public class ShriyaRudrashetty extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the ShriyaRudrashetty class.
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
    public ShriyaRudrashetty(String f, String l, int r, int s) {
        //parameters
        firstName=f; 
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".JPG"; //this is to find the correct image for the portrait   
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.JPG"; //find the correct standing up image
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav"; //find the correct sound file to play
        setImage(portraitFile); //set the image to the portrait file
        sitting=true; //sitting is set to true (so don't show standing up image yet)
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     * My image is in row 3, seat 3
     */
    public ShriyaRudrashetty() {
        //string for the first and last name
        firstName="Shriya";
        lastName="Rudrashetty";
        //set row and seat number
        myRow=3;
        mySeat=3;
       // based on the first and last name strings above, this helps find the correct image/sounds files which follow the same format
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".JPG";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.JPG";
       soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
       setImage(portraitFile);
       sitting=true;
    }
    
     /**
     * Act - do whatever the Shriya Rudrashetty actor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     * Act Method
     */   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
                //if the image is clicked on
                sitting=false; //sitting is false, so switch image to the standing file
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName(); //print out the correct name, defined above
                sayName(soundFile); //say the name, using the correct sound file
            
                myHobby("I like to read books!!"); //display/print out the hobby as well
            
                specialClass(); //call the specialClass method, this is my animation
                provideLesson(); //call the provideLesson method, this is how I will present my lesson
                sitDown(); //after all that is done, sit down and switch image back to sitting down
            }
        
    } 
    
    /**
     * Prints the first and last name to the console
     */
    public void getName(){
        System.out.println("My name is " + firstName + " " + lastName); //print out the first and last name, defined above
    }
    /**
     * This method needs to allow the user to interact with the student through a question and answer interface
     * It also calls the variablesLesson method to teach the lesson
     */
     public void provideLesson(){
        while (! sitting) { //while the actor is standing up
        String q=Greenfoot.ask("Are you ready to start (yes/no)"); //start the questioning
        if (q.contains("yes")){ //if the answer is yes...
            variablesLesson(); //start the lesson, this calls the variablesLesson method which teaches the lesson
        }
        else { //if another input is given
          q=Greenfoot.ask("I don't understand the question... May I sit down?"); //ask to sit down
        }
         if (q.equals("yes")){ //if the answer is yes, wait and then sit down (switch image back to the sitting down one)
            Greenfoot.delay(10);
            sitDown();
        }
    }
    }
     public void answerQuestion(){
        //I didn't use this method
    }
    /**
     * This is used to animate my character when it is clicked on
     * The image twirls and then grows/shrinks
     */
    public void specialClass(){ //the method is called specialClass
        Greenfoot.delay(20); //wait 
        int spinLoop = 72; //I want the process to repeat 72 times, so the image will twirl twice
        int spinIteration = 0; //start the number of iterations with 0
        for (spinIteration = 0; spinIteration < spinLoop; spinIteration = spinIteration + 1)
        //start spinIteration at 0 and continue to increment it for as long as it's below the spinLoop number
        {
            turn(10); //turn 10 degrees with each iteration
            Greenfoot.delay(1); //wait before turning again
        }
        Greenfoot.delay(20); //wait before starting the next action
        
        int growLoop = 5; //I want this process to repeat 5 times
        int growIteration = 0; //start the number of iterations at 0
        for (growIteration = 0; growIteration < growLoop; growIteration = growIteration + 1)
        //start growIteration at 0 and continue to increment it for as long as it's below the growLoop number
        {
             GreenfootImage image = getImage(); //get the image (the standing up one)
             image.scale(image.getWidth()*2, image.getHeight()*2); //set the image scale to 2X the width and height
             Greenfoot.delay(10); //wait before repeating
             //the image to continue to grow until it is ten times its original size
        }
        
        int shrinkLoop = 5; //I want this process to repeat 5 times
        int shrinkIteration = 0; //start the number of iterations at 0
        for (shrinkIteration = 0; shrinkIteration < shrinkLoop; shrinkIteration = shrinkIteration + 1)
        //start shrinkIteration at 0 and continue to increment it for as long as it's below the shrinkLoop number
        {
             GreenfootImage image = getImage(); //get the image (the modified standing up one)
             image.scale(image.getWidth()/2, image.getHeight()/2); //decrease the image scale by a factor of 3
             Greenfoot.delay(10); //wait
             //this basically undos the changes done in the previous step so the image returns to its original dimensions
        }
        Greenfoot.delay(100); //wait before asking (provideLesson method)
    }
    
    public void variablesLesson() { //this method provides the variables lesson
        sitting = false; //the image remains standing
        Greenfoot.delay(10); //wait
        //the below section of code opens up another window with the video lesson
        try
        {
          Desktop.getDesktop().browse(new URL("https://drive.google.com/file/d/1lu72UjM4JoWIJnIByJckuli2tlNB4lG1/view?usp=sharing").toURI());
        }      
        catch (Exception e) {}
        //wait
        Greenfoot.delay(10);
        
    }
     /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
     public void myHobby(String s) {
         System.out.println(s); //this is to print my hobby to the console
}

}

