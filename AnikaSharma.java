import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The AnikaSharma class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Anika Sharma
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 * @version 4.0 Ayg 2, 2020
 */
public class AnikaSharma extends Student implements SpecialInterestOrHobby, NumberOfSiblings
{
    public int slide = 0;
    /**
     * Constructor for the AnikaSharma class.
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
    public AnikaSharma(String f, String l, int r, int s) {
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
    public AnikaSharma() {
        firstName="Anika";
        lastName="Sharma";
        myRow=1;
        mySeat=3;
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
     /**
     * when this actor is clicked, change to standing, print info, and call next methods
     */   
    public void act() 
    {
                if(Greenfoot.mouseClicked(this)){
            //  if (sitting){
                sitting=false;
                setImage(standingFile);
                System.out.println(""); // Print a blank line to create space between any student output.
                getName();
                sayName(soundFile);
            
                myHobby("I like to bike!");
                System.out.println("I have "+numberOfSiblings()+ " sibling");
                System.out.println("I have "+numberOfSisters()+ " sister");
                System.out.println("I have "+numberOfBrothers()+ " brothers");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                moveAround(); 
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
            whiteboard_anikasharma board = new whiteboard_anikasharma ();
            getWorld().addObject(board, 5, 3);
            board.showBoard();
            board.addImage("Arrayslide1.jpg", 0, 0);
            Greenfoot.delay(10);
            System.out.println("Use arrow keys on keyboard to go back and forth");
            while (board.finishSlide == false){ // while reading slides, allow slides to change with arrow keys
                Greenfoot.delay(20);
                if (Greenfoot.isKeyDown("Right")){
                    board.nextSlide();
                }
                if (Greenfoot.isKeyDown("Left")){
                    board.previousSlide();
                }
            }
         
         if (board.finishSlide == true) {   
            String a=Greenfoot.ask("What is the index of the first value in the array? (0/1)");
           if (a.equals("0")){
               String b=Greenfoot.ask("What is the index of the las value of an array? a. arrayName.length - 1, b. arrayName.lenght (a/b)");
               if (b.equals("0")){
                   Greenfoot.delay(10);
                   sitDown();
                   board.hideBoard();
                }
            }
                
            else {
              q=Greenfoot.ask("I don't understand the question... May I sit down?"); 
            }
            if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown();
                board.hideBoard();
            }
         }
    }
        
    }
     }
    public void answerQuestion(){
        // may not need
    }
    /**
     * Circle classrrom, then pop up in ramdom spots
     */
    public void moveAround(){
        GreenfootImage standingFile = getImage(); 
        
        standingFile.scale((2* standingFile.getWidth() ), (2* standingFile.getHeight() ));
        setImage(standingFile);
        Greenfoot.delay(50);
        standingFile.scale((standingFile.getWidth() /2 ), (standingFile.getHeight() /2 ));
        setImage(standingFile);
        
        Greenfoot.delay(20);
        setLocation(3,0);
        // move right
        for (int i=mySeat;i<=9;i++){
            setLocation(i,0);
            Greenfoot.delay(10);
        }
        // move back
        for (int i=myRow;i<=5;i++){
            setLocation(9,i);
            Greenfoot.delay(10);
        }      
         // move left
        for (int i=9;i>=mySeat;i--){
            setLocation(i,5);
            Greenfoot.delay(10);
        }   
        //turn
        for (int i=0; i<36; i++){
            //System.out.println(i);
            turn (10);
            Greenfoot.delay(2);
        }
        //pop up in random places
        for (int i=0;i<=5;i++){
            standingFile.setTransparency(0);
            setLocation(Greenfoot.getRandomNumber(10),Greenfoot.getRandomNumber(6));
            Greenfoot.delay(10);
            standingFile.setTransparency(255);
            Greenfoot.delay(10);
        }
         // move Forward
        for (int i=5;i>=myRow;i--){
            setLocation(mySeat,i);
            Greenfoot.delay(10);
        }   
           Greenfoot.delay(20);
           //returnToSeat();
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
     *Methods for the Number of Siblings class return int for each method 
     */ 
    public int numberOfSiblings(){
        return 1;
    }
    public int numberOfBrothers(){
        return 0;
    }
    public int numberOfSisters(){
        return 1;
    }
}

