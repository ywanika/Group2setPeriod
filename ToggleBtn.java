import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToggleBtn here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToggleBtn extends Actor
{
    private int currentPeriod = 0;
    /**
     * Act - do whatever the ToggleBtn wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.mouseClicked(this)){ 
            currentPeriod = 1 - currentPeriod;
            ((Classroom)getWorld()).prepare(currentPeriod);
        }
    }    
}
