import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Super simple demonstration of how to create an animation in Greenfoot.
 * 
 * @author R. Gordon
 * @version May 4, 2019
 */
public class Explosion extends Actor
{
    /**
     * Instance variables
     * 
     * Can be used anywhere in methods below.
     */
    private GreenfootImage explosion[];
    private int frames;
    private static final int delay = 5;
    GreenfootSound boom;

    /**
     * Constructor
     * 
     * When this actor is created, it makes an explosion animation.
     * 
     * Image files from:
     * 
     * http://www.bigrookgames.com/files/UndeadEmpire2DAssets.zip
     * via
     * https://opengameart.org/content/undeadempire-tileset-64x64-repack-floor-lava-walls-and-effects
     * 
     * Sound file from:
     * https://freesound.org/people/smcameron/sounds/51467/
     */
    Explosion()
    {
        // Initialize the 'explosion' array with 9 values
        // (since this is how many images we have)
        explosion = new GreenfootImage[9];

        // Load the images from disk using a loop
        for (int i = 0; i < explosion.length; i++)
        {
            explosion[i] = new GreenfootImage("explosion-" + i + ".png");
        }
        
        // Set and play the explosion sound
        boom = new GreenfootSound("explosion.wav");
        boom.play();
        
        // Set the frame counter
        frames = 0;
    }

    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       // Track frames / time in scenario
       frames += 1;
        
       // Track animation stage (e.g.: first image, second image, etc)
       int stage = frames / delay;
       
       // Change the image of the actor to create an animation
       if (stage < explosion.length)
       {
           // Only update image once when it's time for a new stage of
           // the animation
           if (frames % delay == 0)
           {
               this.setImage(explosion[stage]);
           }
       }
       else
       {
           // Remove the explosion and stop sound effect
           World myWorld = getWorld();
           boom.stop();
           myWorld.removeObject(this);
       }
    }    
}
