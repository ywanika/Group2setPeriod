import greenfoot.*;

/**
 * @author Anshul Kashyap
 * @version 1.0 August 3, 2020
 */
public class AnshulKashyap extends Student implements CSALearnedSoFar, NumberOfSiblings, SpecialInterestOrHobby, StudentAthlete
{

    /**
     * Constructor for the AnshulKashyap class (with parameters)
     */
    public AnshulKashyap(String f, String l, int r, int s) {
        firstName=f;
        lastName=l;
        myRow=r;
        mySeat=s;
        portraitFile=f.toLowerCase()+l.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+lastName.toLowerCase()+"-standing.jpg";
        soundFile=f.toLowerCase()+l.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    /**
     * Constructor for the AnshulKashyap class (without parameters, default)
     */
    public AnshulKashyap() {
        firstName="Anshul";
        lastName="Kashyap";
        myRow=1;
        mySeat=1;
        portraitFile=firstName.toLowerCase()+ lastName.toLowerCase()+".jpg";
        standingFile=firstName.toLowerCase()+ lastName.toLowerCase()+"-standing.jpg";
        soundFile=firstName.toLowerCase()+ lastName.toLowerCase()+".wav";
        setImage(portraitFile);
        sitting=true;
    }
    
    /**
     * Render the AnshulKashyap object. This runs when the Run or Act button is pressed
     */   
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){
            sitting=false;
            setImage(standingFile);
            System.out.println("");
            getName();
            sayName(soundFile);
            
            myHobby("I like to make cool stuff.");
            
            doStuff();
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
        while(!sitting) {
            String q=Greenfoot.ask("Are you ready to start (yes/no)");
            if (q.contains("yes")){
              q=Greenfoot.ask("Today we will be learning about 5 different searching and sorting algorithms. Are you ready? (yes/no)");
              if (q.contains("yes")){
                  q=Greenfoot.ask("We will start off with BINARY search. Binary search removes half of the items from the list every time the loop iterates. This makes it work very fast since half the points are removed every time the loop runs. That's pretty cool right?");
              }
              else{
                  q=Greenfoot.ask("Too bad :). We will start off with BINARY search. Binary search removes half of the items from the list every time the loop iterates. This makes it work very fast since half the points are removed every time the loop runs. That's pretty cool right?");
              }
              q=Greenfoot.ask("Alright. Let's move on to the next type of search algorithm called INSERTION sort. Insetion sort goes in order and inserts the smallest value every time the loop iterates until the list is sorted. This is a pretty inefficient method of sorting compared to binary because a lot of the values have to be reread every time the loop runs. What do you think about insertion sort?");
              q=Greenfoot.ask("Coolio. Now we will see our first search algorithm called SEQUENTIAL search. Sequential search goes in order and checks to see if a value is equal to the desired value. It repeats until the value is found or returns -1 if it isn’t. Pretty inefficient if there's a lot of values right?");
              q=Greenfoot.ask("We are almost done. We can now learn about SEQUENTIAL SORT. Sequential sort basically swaps the smallest value in the rest of the unsorted list with the current value. This is also pretty inefficient if the values are reverse sorted. How do you feel about sequential sort?");
              q=Greenfoot.ask("Alright. The final algorithm we will be looking at is MERGE sort. Merge sort splits the list into two parts and individually sorts them one after the other and merges them together at the end. This saves computational resources because the amount of times the computer needs to iterate exponentially decreases since the list/array was split in half. Pretty cool right?");
              while (!sitting) {
                  q=Greenfoot.ask("Can I sit down now? (yes/no)");
                  if (q.equals("yes")){
                      Greenfoot.delay(10);
                      sitDown();
                  }
              }
              
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
    
    /**
     * This is a local method specific to the AnshulKashyap class used to animate the character once the image is clicked on
     */
    public void doStuff(){
        int posX = 0;
        int change = 1;
        for(int i = 0; i < 20; i++){
            if(posX > 5){
                change = -1;
            }
            else if(posX == 0){
                change = 1;
            }
            posX += change;
            setLocation(posX, 1);
            Greenfoot.delay(5);
        }
        
        for(int i = 0; i < 80; i++){
            GreenfootImage image = getImage();
            image.scale(image.getWidth() + 1, image.getHeight() + 1);
            setImage(image);
            Greenfoot.delay(1);
        }
        returnToSeat();
    }
    
    /**
     * Answers questions asked
     */
    public void answerQuestion(){
    }
    
    /**
     * Prints AP CSA skills learned so far to the console
     */
    public void LearnedSoFar() {
        System.out.println("I've learned Java syntax, statements, classes, objects, inheritance, and interfaces.");
    }
    
    /**
     * Prints a given sports sentence
     */
    public void mySport(String s) {
        System.out.println(s);
    }
    
    /**
     * Prints hobby sentence to console
     */
    public void myHobby(String s) {System.out.println(s);}
    
    /**
     * Returns total number of siblings
     */
    public int numberOfSiblings() {return numberOfBrothers() + numberOfSisters();}
    
    /**
     * Returns number of brothers
     */
    public int numberOfBrothers() {return 1;}
    
    /**
     * Returns number of sisters
     */
    public int numberOfSisters() {return 0;}
}