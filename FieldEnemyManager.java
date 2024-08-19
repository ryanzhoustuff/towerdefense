import java.awt.Container;
import java.awt.Point;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FieldEnemyManager
{
    private ArrayList<Enemy> enemies;
    private JFrame           frame;

    /**
     * Creates a FieldEnemyManager object in the provided frame.
     * 
     * @param frame
     *            the frame to add this object to.
     */
    public FieldEnemyManager(JFrame frame)
    {
        this.frame = frame;
        enemies = new ArrayList<Enemy>();
    }


    /**
     * Returns the amount of live enemies.
     * 
     * @return amount of enemies.
     */
    public int getLength()
    {
        return enemies.size();
    }


    /**
     * Returns the enemy which entered ith.
     * 
     * @param i
     *            index of enemy
     * @return enemy which entered in order at position i.
     */
    public Enemy getEnemy(int i)
    {
        return enemies.get(i);
    }


    /**
     * Adds an enemy to the field.
     * 
     * @param a
     *            the enemy to be added.
     */
    public void addEnemy(Enemy a)
    {
        a.setLocation(a.getPoint());
        enemies.add(a);
    }


    /**
     * Removes an enemy from the array.
     * 
     * @param a
     *            the enemy to remove.
     */
    public void remove(Enemy a)
    {
        enemies.remove(a);
    }


    /**
     * Removes an enemy from the field.
     * 
     * @param a
     *            the enemy to remove.
     */
    public void removeEnemy(Enemy a)
    {
        frame.remove(a.getLabel());
        frame.repaint();
        frame.validate();
    }


    /**
     * Removes an enemy from the field and removes its health as damage when an
     * enemy escapes.
     * 
     * @param a
     *            the enemy which slipped past all defenses.
     */
    public void enemyEscape(Enemy a)
    {
        removeEnemy(a);
        Frame.removeHealth(a.getDamage());
    }


    /**
     * Returns the enemies on the field.
     * 
     * @return the ArrayList of enemies on the field.
     */
    public ArrayList<Enemy> getEnemies()
    {
        return enemies;
    }


    /**
     * Returns the associated frame.
     * 
     * @return the frame.
     */
    protected JFrame getFrame()
    {
        return frame;
    }


    /**
     * Updates the location of all enemies on the field. Only moves enemies if
     * enough frames have elapsed.
     */
    protected void update()
    {
        for (int i = 0; i < enemies.size(); i++)
        {
            Enemy currentEnemy = enemies.get(i);
            int xTemp = (int)Values.points[currentEnemy.getPoint()].getX();
            int yTemp = (int)Values.points[currentEnemy.getPoint()].getY();
            if (currentEnemy.getMove() % currentEnemy.getSpeed() == 0)
            {
                if (currentEnemy.getPoint() == 22)
                {
                    enemyEscape(currentEnemy);
                    enemies.remove(currentEnemy);
                    try
                    {
                        Values.grid[9][6].setImage(
                            new ImageIcon(
                                new URL(
                                    "https://cdn.discordapp.com/attachments/1098448658283909130/1112449605175607477/track.jpg")));
                    }
                    catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    }
                }
                else
                {
                    xTemp = (int)Values.points[currentEnemy.getPoint()].getX();
                    yTemp = (int)Values.points[currentEnemy.getPoint()].getY();
                    try
                    {
                        Values.grid[xTemp][yTemp].setImage(
                            new ImageIcon(
                                new URL(
                                    "https://cdn.discordapp.com/attachments/1098448658283909130/1112449605175607477/track.jpg")));
                    }
                    catch (MalformedURLException e)
                    {
                        e.printStackTrace();
                    }
                    currentEnemy.setPoint(currentEnemy.getPoint() + 1);
                    xTemp = (int)Values.points[currentEnemy.getPoint()].getX();
                    yTemp = (int)Values.points[currentEnemy.getPoint()].getY();
                    Values.grid[xTemp][yTemp].setImage(currentEnemy.getImage());
                }
            }
            else
            {
                Values.grid[xTemp][yTemp].setImage(currentEnemy.getImage());
            }
            currentEnemy.incrementMove();
        }
        frame.revalidate();
        frame.repaint();
    }
}
