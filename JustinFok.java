import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The KilgoreTrout class can be used as a model for your own class that represents you and your seating location in AP CSA
 *
 * @author Mr. Kaehms
 * @version 2.0 Aug 13, 2019
 * @version 3.0 July 21, 2020
 */
public class JustinFok extends Student implements SpecialInterestOrHobby
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
    public JustinFok(String f, String l, int r, int s) {
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
    public JustinFok() {
        firstName="Justin";
        lastName="Fok";
        myRow=1;
        mySeat=1;
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
            //  if (sitting){
            sitting=false;
            setImage(standingFile);
            System.out.println(""); // Print a blank line to create space between any student output.
            getName();
            sayName(soundFile);

            myHobby("I enjoy playing soccer.");
            // Create a "special method for your class and put the call here.  You can twirl your image, resize it, move it around, change transparancy, or a
            // combination of all of those types of actions, or more. Make sure to save the original image if you manipulate it, so that you can put it back.
            // Call the sitDown() method to move back  to your seat

            teleportClass();  // My class
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
                q=Greenfoot.ask("Today we will be learning about 5 different sorting and searching algorithms.");
                q=Greenfoot.ask("The first type is a binary searching. Its starts in the middle of an array, checks if the value is larger or smaller and removes half the list.");
                q=Greenfoot.ask("The second type is sequential searching. It goes through a array one by one until a match is found. If not present, returns -1.");
                q=Greenfoot.ask("The third type is selection sorting. It swaps the smaller value in the rest of the unsorted list with the current value and keeps going until each value is in the right spot.");
                q=Greenfoot.ask("The fourth type is the insertion sort. It starts with the front of the list, checks with the number behind to see if the current number is smaller and if so, swaps places. Loop iterates until the list is sorted.");
                q=Greenfoot.ask("The last type is the merge sort. It splits list into two parts and individually sorts them one after the other and merges them together at the end.");
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

    public void answerQuestion(){
        // may not need
    }

    /**
     * This is a local method specific to the KilgoreTrout class used to animate the character once the image is clicked on.
     * You should write your own methods to perform your own animation for your character/avatar.
     */

    public void teleportClass(){
        setLocation(1,5);
        Greenfoot.delay(50);
        setLocation(2,9);
        Greenfoot.delay(50);
        setLocation(5,2);
        Greenfoot.delay(50);
        setLocation(6,5);
        Greenfoot.delay(50);
        setLocation(1,5);
        Greenfoot.delay(50);
        setLocation(7,8);
        Greenfoot.delay(50);
        setLocation(5,9);
        Greenfoot.delay(50);

        Greenfoot.delay(50);
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
