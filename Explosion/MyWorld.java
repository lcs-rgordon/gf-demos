import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
    }
    
    /**
     * Called about 60 times per second.
     */
    public void act()
    {
        checkForMouseClick();
    }
    
    /**
     * Look for a mouse click.
     */
    private void checkForMouseClick()
    {
        if (Greenfoot.mouseClicked(null))
        {
            // Create an explosion at this location
            Explosion boom = new Explosion();
            
            // Get the location of the mouse
            int x = Greenfoot.getMouseInfo().getX();
            int y = Greenfoot.getMouseInfo().getY();
            
            // Add the explosion to the world
            addObject(boom, x, y);
        }
    }
}
