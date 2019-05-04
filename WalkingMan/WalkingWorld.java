import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * World to control animated characters. All of the code that actually controls
 * the animation is built into the WalkingMan Actor class. WalkingWorld basically
 * just keeps track of the controls.
 * 
 * @author Jordan Cohen
 * @version May 2013
 */
public class WalkingWorld extends World
{
    private boolean isKeyPressed;
    private WalkingMan man;
    /**
     * Constructor for objects of class WalkingWorld.
     * 
     */
    public WalkingWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        man = new WalkingMan ();
        addObject (man, 300, 200);
    }
    
    public void act ()
    {
        checkKeys();
    }
    
    private void checkKeys()
    {
        // boolean to check if either direction was pressed
        isKeyPressed = false;
        if (Greenfoot.isKeyDown("right"))
        {
            man.walkRight();
            isKeyPressed = true;
        }
        if (Greenfoot.isKeyDown("left"))
        {
            man.walkLeft();
            isKeyPressed = true;
        }
        // In the event that no button is pressed, call the stopWalking method
        if (!(isKeyPressed))
        {
            man.stopWalking();
        }
    }
}
