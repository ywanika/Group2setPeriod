import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author Anish Kolan
 * @version 3.0 August 7, 2020
 */
public class AnishKolan extends Student implements SpecialInterestOrHobby
{

    /**
     * @param String f (firstname)
     * @param String l (lastname)
     * @param int r (row of seating arrangement)
     * @param int s (seat number within row seating arrangement)
     * 
     */
    public AnishKolan(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";    // Make sure to name your image files firstlast.jpg, all lowercase!!!
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";  // Make sure to name your sound files firstlast.wav, all lowercase!!!
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Default constructor, if you don't pass in a name and seating location
     * Pay attention to how the row and seat variables set the location of the image.  1,1 is the first cell in the upper left
     * of the classroom.
     */
    public AnishKolan() {
        firstName="Anish";
        lastName="Kolan";
        myRow=1;
        mySeat=2;
       portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
       standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
     
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
     
            sitting=false;
            setImage(standingFile);
            System.out.println(""); 
            getName();
            sayName(soundFile);
        
            myHobby("I like to play video games!");

        
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
  

        
        bluej.utility.Utility.openWebBrowser("https://www.youtube.com/watch?v=Wv1mGChI0yw");
        q=Greenfoot.ask("The lecture is completed, may I sit down?"); 

        }
        else {
          q=Greenfoot.ask("My lesson is over... May I sit down?"); 
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
        setLocation(1,0);
        Greenfoot.delay(30);
        setLocation(1,4);
        Greenfoot.delay(30);
       
        for (int i=0;i<=4;i++){
            setLocation(1,i);
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

}