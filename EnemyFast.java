import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EnemyFast
    extends Enemy
{
    /**
     * Creates a new instance of the EnemyFast class.
     *
     * @param timeOfSpawn
     *            The time of spawn for the enemy.
     * @param frame
     *            The JFrame object associated with the game.
     */
    public EnemyFast(int timeOfSpawn, JFrame frame)
    {
        super(timeOfSpawn, "fast", frame);
        damage = 7;
        health = 18;
        moneyDropped = 40;
        speed = 1;
    }


    /**
     * Retrieves the image of the enemy.
     *
     * @return The ImageIcon object representing the enemy's image.
     */
    public ImageIcon getImage()
    {
        try
        {
            ImageIcon iag = new ImageIcon(
                new URL(
                    "https://cdn.discordapp.com/attachments/1098448658283909130/1112518766333542450/image.png"));
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

}
