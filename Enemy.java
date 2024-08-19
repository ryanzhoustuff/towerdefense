import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class Enemy
{
    /** Enemy health. */
    protected int  health; 
    /** Frames taken to move once. */
    protected int  speed; 
    /** The current point of this enemy. */
    protected int  point; 
    /** Money gained from killing this enemy. */
    protected int  moneyDropped; 
    /** Damage dealt to the player upon escape. */
    protected int  damage; 
    private int    spawnTime;
    private JLabel jLabel;
    private String url;
    private int    x;
    private int    y;
    private int    move = 0;

    private JFrame frame;

    /**
     * Constructor for the Enemy class. Sets display image, current frame,
     * current location, and creates the JLabel accordingly.
     * 
     * @param timeOfSpawn
     *            Spawn time of this enemy.
     * @param type
     *            The typing of this enemy. Determines display.
     * @param frame
     *            The frame this enemy will be displayed in.
     */
    public Enemy(int timeOfSpawn, String type, JFrame frame)
    {
        point = 0; // point number
        // tile = Values.grid[0][2];
        this.frame = frame;

        spawnTime = timeOfSpawn;
        url = Values.URLS[0]; // Default to index 0 (basic)
        if (type.equals("fast"))
        {
            url = Values.URLS[1];
        }
        else if (type.equals("tanky"))
        {
            url = Values.URLS[2];
        }
        else if (type.equals("boss"))
        {
            url = Values.URLS[3];
        }
        jLabel = new JLabel();
    }


    /**
     * Sets the location of this enemy.
     * 
     * @param p
     *            location to move enemy to
     */
    public void setLocation(int p)
    {
        int x = (int)Values.points[p].getX();
        int y = (int)Values.points[p].getY();
        point = p;
        this.x = x; 
        this.y = y;
        frame.revalidate();
        frame.repaint();
    }


    /**
     * Determines how many frames have elapsed since the previous movement.
     * 
     * @return The current frame count
     */
    public int getMove()
    {
        return move;
    }


    /**
     * Increases the number of frames which have elapsed since the previous
     * movement by one.
     */
    public void incrementMove()
    {
        move++;
    }


    /**
     * Returns this enemy's ImageIcon.
     * 
     * @return this enemy's image.
     */
    public ImageIcon getImage()
    {
        try
        {
            ImageIcon iag = new ImageIcon(
                new URL(
                    "https://cdn.discordapp.com/attachments/1098448658283909130/1112516722470166639/image.png"));
            // System.out.println("iag: "+ iag);
            Image image = iag.getImage();
            Image newimg = image.getScaledInstance(66, 55, java.awt.Image.SCALE_SMOOTH);
            iag = new ImageIcon(newimg);
            return iag;
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * Returns the current X position of this enemy in the grid.
     * 
     * @return x
     */
    public int getX()
    {
        return x;
    }


    /**
     * Returns the current Y position of this enemy in the grid.
     * 
     * @return y
     */
    public int getY()
    {
        return y;
    }


    /**
     * Returns the time this enemy will spawn.
     * 
     * @return time of spawn
     */
    public int getSpawnTime()
    {
        return spawnTime;
    }


    /**
     * Sets the number of frames to newMove.
     * 
     * @param newMove
     *            frames elapsed since previous movement.
     */
    public void setMove(int newMove)
    {
        move = newMove;
    }


    /**
     * Subtracts enemyDamage from this enemy's health.
     * 
     * @param enemyDamage
     *            damage taken.
     */
    public void removeHealth(int enemyDamage)
    {
        health -= enemyDamage;
    }


    /**
     * Returns this enemy's health.
     * 
     * @return this enemy's current health.
     */
    public int getHealth()
    {
        return health;
    }


    /**
     * Returns the damage dealt upon exit.
     * 
     * @return this enemy's damage
     */
    public int getDamage()
    {
        return damage;
    }


    /**
     * The number of frames for this enemy to move once.
     * 
     * @return this enemy's speed.
     */
    public int getSpeed()
    {
        return speed;
    }


    /**
     * Returns the amount of money this enemy provides when defeated.
     * 
     * @return this enemy's dropped money.
     */
    public int getMoneyDropped()
    {
        return moneyDropped;
    }


    /**
     * Retrieves the JLabel component associated with this object.
     *
     * @return The JLabel component.
     */
    public JLabel getLabel()
    {
        return jLabel;
    }


    /**
     * Retrieves the current value of the point.
     *
     * @return The current point value.
     */
    public int getPoint()
    {
        return point;
    }


    /**
     * Sets the value of the point to a new value.
     *
     * @param newPoint
     *            The new point value.
     */
    public void setPoint(int newPoint)
    {
        point = newPoint;
    }


    /**
     * Sets the speed to a new value.
     *
     * @param newSpeed
     *            The new speed value.
     */
    public void setSpeed(int newSpeed)
    {
        speed = newSpeed;
    }
}
