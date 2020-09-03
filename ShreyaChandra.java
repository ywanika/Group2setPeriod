import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class represents the seating arrangement for Shreya Chandra.
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 * @author Shreya Chandra
 * @version 4.0 August 7, 2020
 */
public class ShreyaChandra extends Student implements SpecialInterestOrHobby, StudentAthlete
{
    /**
     * Constructor for the ShreyaChandra class.
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
    public int slide = 0;
    public ShreyaChandra(String f, String l, int r, int s) {
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
    public ShreyaChandra() {
        firstName="Shreya";
        lastName="Chandra";
        myRow=1;
        mySeat=2;
       // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
    /**
    * Act - do whatever the KilgoreTrout actor wants to do. This method is called whenever
    * the 'Act' or 'Run' button gets pressed in the environment.
    */   
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
                sitting=false;
                setImage(standingFile); //changes image after clicked
                System.out.println(""); // Print a blank line to create space between any student output.
                getName(); //displays name
                Greenfoot.playSound("shreyachandra.wav"); //plays name sound effect
                Greenfoot.delay(100); //pauses before next action
            
                myHobby("I like to read!"); //displays favorite hobby
                mySport("I'm a figure skater."); //displays sport
            
                moveToCenter(); //calls the special animation
                provideLesson(); //displays the lesson
                sitDown(); //reverts to original seat and picture
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
          String q=Greenfoot.ask("Are you ready to start/repeat the lesson (yes/no)");
          if (q.contains("yes")){
            //creates and displays new WhiteBoard
            WhiteBoard_ShreyaChandra board = new WhiteBoard_ShreyaChandra(); 
            getWorld().addObject(board, 5, 3);
            
            board.showBoard(); //shows board on screen
            board.addImage("Arrayslide1.jpg", 0, 0); //adds first slide for lesson
            Greenfoot.delay(10); //pauses
            while (board.finishSlide == false){
                Greenfoot.delay(20); //pauses
                if (Greenfoot.isKeyDown("Right")){
                    board.nextSlide(); //uses right keyboard key to move ahead in slides
                }
                if (Greenfoot.isKeyDown("Left")){
                    board.previousSlide(); //uses left keyboard key to move back in slides
                }
            }
                
            if (board.finishSlide == true) {
                Greenfoot.delay(100); //pauses after slides are finished
                   
                //asks questions to check for understanding
                q=Greenfoot.ask("1. What is the index number for the first value of an array? (0/1)");
                if (q.contains("0")){
                    q=Greenfoot.ask("2. What is the index of the last value of an array? a. arrayName.length -1 or b. arrayName.length (type a or b)");
                }
                if (q.contains("a")){
                    board.hideBoard();
                    q=Greenfoot.ask("Correct! May I sit down? (yes/no)");
                }
                if (q.equals("yes")){
                    Greenfoot.delay(10);
                    sitDown();
                }
                board.hideBoard(); //removes whiteboard from screen
             }
            else {
                q=Greenfoot.ask("May I sit down? (yes/no)"); 
            }   
            if (q.equals("yes")){
                board.hideBoard();
                Greenfoot.delay(10);
                sitDown(); //returns to seated position if answered incorrectly
            }
          }
       }
    }
    public void answerQuestion(){
        // unused
    }
    public void moveToCenter() {
        setLocation(getWorld().getWidth()/2, getWorld().getHeight()/2); //moves image to middle
        Greenfoot.delay(10); //pauses
        Greenfoot.playSound("applause3.wav"); //plays applause sound effect
        for (int i=0; i<=72; i++) {
            //image rotates in a circle
            getImage().rotate(5);
            Greenfoot.delay(2);
        }
        for (int i=0; i<=1; i++) {
          Greenfoot.playSound("applause3.wav"); //plays applause sound effect
            for (int x=1;x<=9;x++){
            setLocation(x,0); //moves right
            Greenfoot.delay(10);
          }
          for (int z=9;z>=0;z--){
           setLocation(z,5); //moves left
           Greenfoot.delay(10);
            }
        } 
        Greenfoot.delay(20);
        returnToSeat(); //returns back to original seated position
        
    }
    /**
     * myHobby is one of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
     public void myHobby(String s) {
         System.out.println(s);
     }
    /** mySport is another of the interfaces provided.  
     * An interface is just a contract for the methods that you will implement in your code.  The College Board no longer
     * tests on abstract classes and interfaces, but it is good to know about them
     */
    public void mySport(String s) {
        System.out.println(s);
    }
}
