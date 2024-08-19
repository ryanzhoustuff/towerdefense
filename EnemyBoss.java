import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EnemyBoss
    extends Enemy
{

    /**
     * Creates a new instance of the EnemyBoss class.
     *
     * @param timeOfSpawn
     *            The time of spawn for the boss enemy.
     * @param frame
     *            The JFrame object associated with the game.
     */
    public EnemyBoss(int timeOfSpawn, JFrame frame)
    {
        super(timeOfSpawn, "boss", frame);
        damage = 100;
        health = 1000;
        moneyDropped = 2500;
        speed = 4;
        incrementMove();
        incrementMove();
        incrementMove();
    }


    /**
     * Retrieves the image of the boss enemy.
     *
     * @return The ImageIcon object representing the boss enemy's image.
     */
    public ImageIcon getImage()
    {
        try
        {
            ImageIcon iag = new ImageIcon(
                new URL(
                    "https://cdn.discordapp.com/attachments/1098448658283909130/1111867603502235698/EnemyBoss.png"));
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
