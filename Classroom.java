import java.util.*;
import greenfoot.*;
import java.util.ArrayList;
import java.io.*;
// (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.reflect.Constructor;

/**
 * Write a description of class Classroom here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Classroom extends World
{
    private ArrayList<Class> listo = new ArrayList<Class>();
    /**
     * Constructor for objects of class Classroom. Creates the toggle button and sets initial period to period 2
     *
     */
    public Classroom()
    {
        // Create a new world with 10x6 cells with a cell size of 130x130 pixels.
        super(10, 6, 130);
        ToggleBtn balloon = new ToggleBtn(); // creates a new Toggle Botton
        addObject(balloon, 1, 1); // adds the Toggle Button (red baloon) to location (1,1)
        setPeriod(0); // sets period to default period which is period 1
    }

    /**
     * Clears world and creates objects depending on the current period
     */

     public void setPeriod(int currentPeriod)
    {
       removeObjects(getObjects(null));
       
       ToggleBtn balloon = new ToggleBtn();
       addObject(balloon, 1, 1);
        
       if (currentPeriod == 0){ //if the current period is period 2, then create these students
           TrishaMoorkoth trishamoorkoth = new TrishaMoorkoth("Trisha", "Moorkoth", 6, 2);
           addObject(trishamoorkoth, 6, 2);
           trishamoorkoth.sitDown();
           
           NiruSuravarjjala nirusuravarjjala = new NiruSuravarjjala("Niru", "Suravarjjala", 1, 5);
           addObject(nirusuravarjjala, 1, 5);
           nirusuravarjjala.sitDown();
           
           DerekXu derekxu = new DerekXu("Derek", "Xu", 2, 4);
           addObject(derekxu, 2, 4);
           derekxu.sitDown();
       }
       

       else if (currentPeriod == 1) {  //if the current period is period 3, then create these students
           JoshuaChon joshuachon = new JoshuaChon("Joshua", "Chon", 1, 6);
           addObject(joshuachon, 1, 6);
           joshuachon.sitDown();
           
           KaifJeelani kaifjeelani = new KaifJeelani("Kaif", "Jeelani", 5,2);
           addObject(kaifjeelani, 5, 2);
           kaifjeelani.sitDown();
           
           JennyWang jennywang = new JennyWang("Jenny", "Wang", 5,2);
           addObject(jennywang, 5, 2);
           kaifjeelani.sitDown();
        }
    }
}

