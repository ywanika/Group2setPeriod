import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The CopyOfKilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 * 
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class JennyWang extends Student implements SpecialInterestOrHobby
{

    /**
     * Constructor for the JennyWang class.
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
    public JennyWang(String f, String l, int r, int s) {
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
    public JennyWang() {
        firstName="Jenny";
        lastName="Wang";
        myRow=3;
        mySeat=3;
        // imgFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
    /**
     * Act - do whatever the JennyWang actor wants to do. This method is called whenever
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
            
                myHobby("I like to sing and write songs!");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a 
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat
            
                danceAround();  // Jenny Wang's special method 
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
         // put in your lesson here - you can open up a browser for a screencast
         // Create a blackboard image and write to it, etc
         // Use an animated gif and dub over with audio - see "controls/show sound recoder"
         // from main greenfoot menu for a simple to use soud editor
        sayName("jennywang-lesson.wav");
        System.out.println("");
        System.out.println("Starting lesson...");
        Greenfoot.delay(250); 
        System.out.println("");
        System.out.println("AP CSA: TWO DIMENSIONAL ARRAYS, BY: RIA JAIN, GRACE LIU, JENNY WANG");
        Greenfoot.delay(250); 
        System.out.println("");
        System.out.println("");
        System.out.println("");
        System.out.println("We will cover:");
        Greenfoot.delay(150); 
        System.out.println("        i. Introduction to 2D Arrays");
        Greenfoot.delay(150); 
        System.out.println("        ii. Array Storage");
        Greenfoot.delay(150); 
        System.out.println("        iii. How to Declare 2D Arrays");
        Greenfoot.delay(150); 
        System.out.println("        iv. Setting Values in a 2D Array");
        Greenfoot.delay(150); 
        System.out.println("        v. How to Get a Value from a 2D Array");
        Greenfoot.delay(150); 
        System.out.println("        vi. How to Find the Number of Rows and Columns in a 2D Array");
        Greenfoot.delay(150); 
        System.out.println("        vii. How to Loop Through a 2D Array");
        Greenfoot.delay(150); 
        System.out.println("        viii. Using a For-Each Loop");
        Greenfoot.delay(150); 
        System.out.println("        ix. Looping through Part of a 2D Array");
        Greenfoot.delay(150); 
        System.out.println("        x. Common Mistakes");
        Greenfoot.delay(150); 
        q=Greenfoot.ask("Are you ready to start (yes/no)");
        if(q.contains("yes")){
            ourLesson(); 
            sitDown();
        }
        else {
            q=Greenfoot.ask("Would you like to see the notes instead? (yes/no)"); 
            if(q.contains("yes")){
                ourNotes();
                sitDown();
            }
            if(q.contains("no")){
              q=Greenfoot.ask("Okay... May I sit down?");  
              if (q.contains("yes")){
                  sitDown();
                  
                }
              
            }
            else {
                q=Greenfoot.ask("I don't understand the question... May I sit down?");
                if (q.contains("yes")){
                    Greenfoot.delay(10);
                    sitDown();
                }
            }
        }
        // You can end the lesson and "sitDown" once the lesson is complete, or once
        // someone answers "yes" to the sitdown question
        
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
     * This is a local method specific to the CopyOfKilgoreTrout class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */
    public void danceAround(){
     
        Greenfoot.delay(10); 
        
        for (int i=1;i<=2;i++){
           setRotation(25);  
           
           GreenfootImage pic = new GreenfootImage(600, 400);
           pic.setColor(new Color(228, 187, 240));
           pic.fill();
           getWorld().setBackground(pic);
           Greenfoot.delay(12); 
        }
        for (int i=1;i<=2;i++){
           setRotation(-25);  
           
           GreenfootImage pic = new GreenfootImage(600, 400);
           pic.setColor(new Color(242, 208, 219));
           pic.fill();
           getWorld().setBackground(pic);
           Greenfoot.delay(12); 
        }
        for (int i=1;i<=2;i++){
           setRotation(25);  
           GreenfootImage pic = new GreenfootImage(600, 400);
           pic.setColor(new Color(215, 208, 242));
           pic.fill();
           getWorld().setBackground(pic);
           Greenfoot.delay(12); 

        }
        for (int i=1;i<=2;i++){
           setRotation(-25);  
           GreenfootImage pic = new GreenfootImage(600, 400);
           pic.setColor(new Color(227, 188, 199));
           pic.fill();
           getWorld().setBackground(pic);
           Greenfoot.delay(12); 

        }
        for (int i=1;i<=2;i++){
           setRotation(25);  
           GreenfootImage pic = new GreenfootImage(600, 400);
           pic.setColor(new Color(202, 171, 219));
           pic.fill();
           getWorld().setBackground(pic);
           Greenfoot.delay(12); 

        }
        for (int i=1;i<=2;i++){
           setRotation(-25);  
           GreenfootImage pic = new GreenfootImage(600, 400);
           pic.setColor(new Color(166, 163, 191));
           pic.fill();
           getWorld().setBackground(pic);
           Greenfoot.delay(12); 

        }
        for (int i=1;i<=2;i++){
           setRotation(25);  
           GreenfootImage pic = new GreenfootImage(600, 400);
           pic.setColor(new Color(255, 189, 230));
           pic.fill();
           getWorld().setBackground(pic);
           Greenfoot.delay(12); 

        }
        for (int i=1;i<=2;i++){
           setRotation(-25);  
           
           GreenfootImage pic = new GreenfootImage(600, 400);
           pic.setColor(new Color(219, 160, 172));
           pic.fill();
           getWorld().setBackground(pic);
           Greenfoot.delay(12); 
        }
        for (int i=1;i<=2;i++){
           setRotation(0);  
      
           GreenfootImage pic = new GreenfootImage(600, 400);
           pic.setColor(new Color(247, 218, 247));
           pic.fill();
           getWorld().setBackground(pic);
           Greenfoot.delay(8); 
        }
        
        
        Greenfoot.delay(8); 
        getWorld().setBackground(new GreenfootImage("csa.jpg"));
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
    
    /**
     * Code for the presentation 
     */
    public void ourLesson() {
        sitDown(); 
        bluej.utility.Utility.openWebBrowser("https://youtu.be/prXUe8rXlp8");
    }
    
    /**
     * Code for the presentation 
     */
    public void ourNotes() {
        sitDown(); 
        bluej.utility.Utility.openWebBrowser("https://docs.google.com/document/d/17U_2yqYnbC4gpIYQSBEEClDZSNC4D5t38SGbU9HEB4M/edit?usp=sharing");
    }
}
