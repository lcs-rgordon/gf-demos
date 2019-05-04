import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Demonstration of animation using 6 moving sprites and 1 standing sprite.
 * 
 * @author Jordan Cohen
 * @version May 2013
 */
public class WalkingMan extends Actor
{
    // Declare arrays of GreenfootImages for animation
    private GreenfootImage[] walkingRight;
    private GreenfootImage[] walkingLeft;
    // Declare GreenfootImages for standing
    private GreenfootImage standingRight;
    private GreenfootImage standingLeft;

    // Two booleans for controlling the flow of the action
    private boolean walking;
    private boolean facingRight;

    // Integers for controlling the speed of the movement and animation
    private int animationCounter;
    private int animationDelay;
    private int animationDelayCounter;
    private int speed;

    /**
     * Constructor for WalkingMan imports the necessary images, sets
     * values for variables and sets this Actor's image to begin.
     */
    public WalkingMan ()
    {
        // Three Strings together to build file name
        String fileName;
        String fileNamePrefix = "right0";
        String fileNameSuffix = ".png";
        // Initialize arrays
        walkingRight = new GreenfootImage[6];
        walkingLeft = new GreenfootImage[6];

        // Use a loop to populate the two image arrays
        for (int i = 0; i < walkingRight.length; i++)
        {
            // Build the file name: Eg. right02.png
            fileName = fileNamePrefix + (i+1) + fileNameSuffix;
            // Use the file for the right facing sprite
            walkingRight[i] = new GreenfootImage(fileName);
            // Build the left facing sprite by flipping the
            // right facing sprite
            walkingLeft[i] = new GreenfootImage (walkingRight[i]);
            walkingLeft[i].mirrorHorizontally();
        }
        // import the right standing image
        standingRight = new GreenfootImage ("standing_right.png");
        // create the left standing image from the right standing image
        standingLeft = new GreenfootImage (standingRight);
        standingLeft.mirrorHorizontally(); 

        // Set starting values for control variables
        walking = false;
        facingRight = true;
        // How fast the Actor will move
        speed = 3;
        // How many acts as a delay between changing frames
        animationDelay = 8;
        // Start delay counter  at 0
        animationDelayCounter = 0;
        // Start the animation counter at 0. The animation counter keeps
        // track of what frame the animation is on, and gets reset if the
        // player changes direction. It is only updated every 
        // *animationDelayCounter* acts, so the animation isn't too fast.
        animationCounter = 0;

        // Set starting image
        this.setImage (standingRight);
    }

    public void act() 
    {
        // animationDelayCounter is used to avoid the animation happening
        // too fast. Each act it increases by 1 until it hits *animationDelay*.
        animationDelayCounter++;
        if(animationDelayCounter == animationDelay)
        {
            animationCounter++;
            animationDelayCounter = 0;
        }
        // Animation counter controls which frame is currently being displayed.
        // If it gets beyond the size of our array of images, reset it to zero
        if (animationCounter > walkingRight.length -1)
            animationCounter = 0;


    }    

    /**
     * Called by WalkingWorld, causes the player to move left.
     */
    public void walkLeft()
    {
        // Check if direction is changing, and if so, reset counter
        if (facingRight)
            animationCounter = 0;
        // Set control booleans to not facing right and walking
        walking = true;
        facingRight = false;
        // Set the appropriate image. Note that animationCounter is
        // controlled by the act() method.
        setImage (walkingLeft[animationCounter]);
        // Move the actor
        setLocation (getX() - speed, getY());   
    }

    /**
     * Called by WalkingWorld, causes the player to move right.
     */
    public void walkRight()
    {
        // Check if direction is changing, and if so, reset counter
        if (!(facingRight))
            animationCounter = 0;
        // Set control booleans to facing right and walking
        walking = true;
        facingRight = true;
        // Set the appropriate image. Note that animationCounter is
        // controlled by the act() method.
        setImage (walkingRight[animationCounter]);
        // Move the actor
        setLocation (getX() + speed, getY());
    }

    /**
     * Called by WalkingWorld, causes the player to stand still.
     * This method gets called when the World decides that neither
     * directional button has been pushed.
     */
    public void stopWalking()
    {
        // Stop walking
        walking = false;
        // Reset animation counter
        animationCounter = 0;
        // Reset animation delay caounter
        animationDelayCounter = 0;
        // Set appropriate image based on which way player was most recently
        // moving
        if (facingRight)
            this.setImage (standingRight);
        else
            this.setImage (standingLeft);
    }
}
