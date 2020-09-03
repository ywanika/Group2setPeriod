import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;

/**
 * I'm Kabir Shah
 * 
 * @author Kabir Shah
 * @version 1.0
 */
public class KabirShah extends LoopGroup implements CSALearnedSoFar, NumberOfSiblings, SpecialInterestOrHobby, StudentAthlete
{
    GreenfootImage pacmanImage0;
    GreenfootImage pacmanImage1;
    GreenfootSound chompSound;
    ArrayList<Student> eatenStudents = new ArrayList<Student>();

    /**
     * Construct a KabirShah with a specific name and seat.
     */
    public KabirShah(String f, String l, int r, int s) {
        firstName = f;
        lastName = l;
        
        myRow = r;
        mySeat = s;
        
        portraitFile = firstName.toLowerCase() + lastName.toLowerCase() + ".jpg";
        standingFile = firstName.toLowerCase() + lastName.toLowerCase() + "-standing.jpg"; 
        soundFile = firstName.toLowerCase() + lastName.toLowerCase() + ".wav";
        chompSound = new GreenfootSound(firstName.toLowerCase() + lastName.toLowerCase() + "-chomp.wav");
        
        sitting = true;
        
        resetImages();
        chompSound.setVolume(75);
        setImage(portraitFile);
    }

    /**
     * Prints name to the console.
     */
    public void getName(){
        System.out.println("Hey, I'm " + firstName + " " + lastName);
    }
    
    /**
     * Prints AP CSA skills learned so far to the console.
     */
    public void LearnedSoFar() {
        System.out.println("I've learned Java syntax, statements, classes, objects, inheritance, and interfaces.");
    }
    
    /**
     * Returns total number of siblings.
     */
    public int numberOfSiblings() {
        return numberOfBrothers() + numberOfSisters();
    }
    
    /**
     * Returns number of brothers.
     */
    public int numberOfBrothers() {
        return 1;
    }
    
    /**
     * Returns number of sisters.
     */
    public int numberOfSisters() {
        return 0;
    }

    /**
     * Prints a given sports sentence.
     */
    public void mySport(String s) {
        System.out.println(s);
    }
    
    /**
     * Prints a given hobby sentence.
     */
    public void myHobby(String s) {
        System.out.println(s);
    }
    
    /**
     * Does some pacman animations.
     */
    public void chomp() {
        for (int i = 0; i < 2; i++) {
            setImage(pacmanImage0);
            Greenfoot.delay(10);
            setImage(pacmanImage1);
            Greenfoot.delay(10);
        }
        
        List<Student> students = (List<Student>) getIntersectingObjects(Student.class);
        
        for (Student student : students) {
            if (student != null) {
                student.getImage().setTransparency(0);
                eatenStudents.add(student);
            
                pacmanImage0.scale(pacmanImage0.getWidth() + 3, pacmanImage0.getHeight() + 3);
                pacmanImage1.scale(pacmanImage1.getWidth() + 3, pacmanImage1.getHeight() + 3);
            }
        }
    }
    
    /**
     * Reset all pacman images.
     */
    public void resetImages() {
        pacmanImage0 = new GreenfootImage(firstName.toLowerCase() + lastName.toLowerCase() + "-standing-pacman-0.tiff");
        pacmanImage1 = new GreenfootImage(firstName.toLowerCase() + lastName.toLowerCase() + "-standing-pacman-1.tiff");
    }
    
    /**
     * Starts the pacman animation.
     */
    public void startAnimation() {
        getWorld().setPaintOrder(KabirShah.class, Student.class);
        chompSound.playLoop();
        
        for (int i = 1; i <= 3; i++) {
            if (i % 2 == 0) {
                for (int j = 8; j >= 1; j--) {
                    setLocation(j, i);
                    chomp();
                }
            } else {
                for (int j = 1; j <= 8; j++) {
                    setLocation(j, i);
                    chomp();
                }
            }
            
            pacmanImage0.mirrorHorizontally();
            pacmanImage1.mirrorHorizontally();
        }
        
        for (Student eatenStudent : eatenStudents) {
            eatenStudent.getImage().setTransparency(255);
        }
        
        eatenStudents = new ArrayList<Student>();
        resetImages();
        chompSound.stop();
        setImage(standingFile);
        returnToSeat();
    }
    
    /**
     * Answer any questions.
     */
    public void answerQuestion() {
        while (!sitting) {
            String answer = Greenfoot.ask("That's the lesson. Any questions? (y/n)");
        
            if (answer.contains("y")) {
            } else {
                sitDown();
            }
        }
    }
       
    /**
     * Start giving the loop group lesson.
     */
    public void provideLesson() {
        while (!sitting) {
            String answer = Greenfoot.ask("Start lesson? (y/n)");
            
            if (answer.contains("y")) {
                bluej.utility.Utility.openWebBrowser("https://drive.google.com/file/d/1xE0wQSPAU1Ku_Fzbr64Y8EkrfhlJKMiO/view?usp=sharing%22");
                answerQuestion();
            } else {
                answer = Greenfoot.ask("Alright then, can I sit down? (y/n)");
        
                if (answer.contains("y")) {
                    sitDown();
                }
            }
        }
    }
        
    /**
     * Give an introduction and begin an animation when clicked.
     */
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            sitting = false;
            setImage(standingFile);
            
            System.out.println("");
            getName();
            sayName(soundFile);
            LearnedSoFar();
            System.out.println("I have " + Integer.toString(numberOfSiblings()) + " siblings.");
            myHobby("I like to play guitar.");
            mySport("I play soccer and lacrosse.");
            
            Greenfoot.delay(100);
            startAnimation();
            provideLesson();
        }
    }
}