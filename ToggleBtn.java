import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToggleBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToggleBtn extends Actor
{
    private static int currentPeriod = 0; // initial default period is period 2
    /**
     * Act - do whatever the ToggleBtn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() // new act method
    {
        if(Greenfoot.mouseClicked(this)){ // if the Toggle Botton (red balloon) is clicked
            currentPeriod = 1 - currentPeriod; // period 2 = 0 and period 3 = 1, so this allows the current period to change/toggle between periods 2 and 3 
            ((Classroom)getWorld()).setPeriod(currentPeriod); // this sets the world so that the current period toggled shows up on the screen
        }
    }    
}
