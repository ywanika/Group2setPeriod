import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ella here.
 * 
 * @Ella DeGuzman
 * @version 1.0
 */
public class EllaDeGuzman extends Student implements SpecialInterestOrHobby, StudentAthlete
{
    /**
     * Constructor for the Ella class.
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
  
   public EllaDeGuzman(String f, String l, int r, int s) {
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
    public EllaDeGuzman() {
        firstName="Ella";
        lastName="DeGuzman";
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
     * Act - do whatever the Ella wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        // Add your action code here.
        if(Greenfoot.mouseClicked(this)){
            sitting=false; //chnges state of character to standing
            setImage(standingFile); //switches image to me standing
            System.out.println(""); // Print a blank line to create space between any student output.
            getName(); //prints "My name is Ella DeGuzman"
            sayName(soundFile); //say "Ella DeGuzman"
            
            myHobby("I like to paint!"); //say hobby
            mySport("I like to play lacrosse!"); //say sport
            
            lacrosse();  //Ella's method
            provideLesson(); //give lesson on arrays
            sitDown(); //make character sit down
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
        while (! sitting) { //checks if person is standing
        //asks if they want to test their knowledge before lesson
        String q=Greenfoot.ask("Do you want to start the lesson? If yes, use your arrow keys to move between slides (yes/no)");
        //gives quiz
        if (q.contains("yes")){
            WhiteBoard_Ella board = new WhiteBoard_Ella(); //adds a whiteboard
            getWorld().addObject(board, 5, 3);
            
            board.showBoard(); //makes board opaque
            board.addImage("Arrayslide1.jpg", 0, 0); //adds the first slide
            Greenfoot.delay(10);
            while (board.finishSlide == false){ //checks if the lesson is on the last slide 
                Greenfoot.delay(20);
                if (Greenfoot.isKeyDown("Right")){//allows you to use arrow keys to move between slides
                    board.nextSlide();
                }
                if (Greenfoot.isKeyDown("Left")){ //allows you to use arrow keys to move between slides
                    board.previousSlide();
                }
            }  
            if (board.finishSlide == true) { //checks if the lesson is on the last slide and then asks quiz questions 
                q=Greenfoot.ask("1. What is the index number for the first value of an array? (0/1)");
                if (q.contains("0")){
                    q=Greenfoot.ask("2. What is the index of the last value of an array? a. arrayName.length -1 or b. arrayName.length (type a or b)");
                    if (q.contains("a")){
                        q=Greenfoot.ask("Correct! May I sit down?(yes/no)");
                        if (q.equals("yes")){
                            board.hideBoard(); //hides the board
                            Greenfoot.delay(10);
                            sitDown(); //makes character sit down 
                        }
                    }
                }
            }
            board.hideBoard();
        }
        else {
            q=Greenfoot.ask("May I sit down? (yes/no)"); 
            if (q.equals("yes")){
                Greenfoot.delay(10);
                sitDown(); //makes character sit down 
                }
            }
        }
    }
    public void answerQuestion(){
        // may not need
    }
    /**
     * This is a local method specific to the EllaDeGuzman class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void lacrosse(){
        //play favorite song 
        Greenfoot.playSound("music.wav");
        //make the standing image 1.5 times bigger 
        GreenfootImage standingFile = new GreenfootImage("elladeguzman-standing.jpg");
        standingFile.scale(standingFile.getWidth()*3/2, standingFile.getHeight()*3/2);
        setImage(standingFile);
        //wait 
        Greenfoot.delay(30);
        //make the image turn 360 degrees 
        for (int i=1;i<=36;i++){
            turn(10);
            Greenfoot.delay(1);
        }
        //set starting location 
        setLocation(0,0);
        //wait 
        Greenfoot.delay(30);
        // move right
        Greenfoot.playSound("run.wav");
        for (int i=1;i<=8;i++){
            setLocation(i,0);
            Greenfoot.delay(5);
        }
        // move down
        for (int i=1;i<=4;i++){
            setLocation(8,i);
            Greenfoot.delay(5);
        }  
        //wait 
        Greenfoot.delay(30);
        //set image as lacrosse image
        GreenfootImage sportFile = new GreenfootImage("elladeguzman-lacrosse.jpg");
        sportFile.scale(sportFile.getWidth()*7/4, sportFile.getHeight()*7/4);
        setImage(sportFile);
        //wait
        Greenfoot.delay(30);
        //play swoosh sound
        Greenfoot.playSound("swoosh.wav");
        //rotate character
        for (int i=1;i<=10;i++){
            turn(-i);
            Greenfoot.delay(1);
        }  
        Greenfoot.delay(30);
        //rotate character
        for (int i=1;i<=10;i++){
            turn(i);
            Greenfoot.delay(1);
        }  
        Greenfoot.delay(30);
        //rotate character
        for (int i=1;i<=10;i++){
            turn(-i);
            Greenfoot.delay(1);
        }  
        Greenfoot.delay(30);
        //rotate character
        for (int i=1;i<=10;i++){
            turn(i);
            Greenfoot.delay(1);
        }  
        Greenfoot.delay(30);
        //play running sound
        Greenfoot.playSound("run.wav");
        for (int i=1;i<=8;i++){
            setLocation(8-i,4);
            Greenfoot.delay(10);
        }
        Greenfoot.delay(30);
        //go back to seat
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
    public void mySport(String s) {
         System.out.println(s);
        } 
}
