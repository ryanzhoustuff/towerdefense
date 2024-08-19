import java.awt.Image;
import java.awt.Point;
import java.awt.geom.Point2D;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class EnemyBasic
    extends Enemy
{
    /**
     * @param timeOfSpawn
     *            The time of spawn for the enemy.
     * @param frame
     *            The JFrame associated with this enemy.
     */
    public EnemyBasic(int timeOfSpawn, JFrame frame)
    {
        super(timeOfSpawn, "basic", frame);
        damage = 3;
        health = 24;
        moneyDropped = 25;
        speed = 3;
        incrementMove();
        incrementMove();
    }


    /**
     * Returns the image associated with this enemy.
     * 
     * @return the ImageIcon associated with this enemy.
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
}
