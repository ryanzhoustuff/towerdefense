import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class Screen
{

    private JFrame frame;

    /**
     * Represents the repainting class for the associated frame.
     * 
     * @param frame The associated frame.
     */
    public Screen(JFrame frame)
    {
        this.frame = frame;
    }


    /**
     * Sets up the initial field display.
     */
    public void paint()
    {
        for (int columns = 0; columns < 10; columns++)
        {
            for (int rows = 0; rows < 12; rows++)
            {
                Tile tile = Values.grid[columns][rows];
                tile.setLocation(columns * tile.getWidth(), rows * tile.getHeight());
            }
        }
        // frame.validate();
        // frame.repaint();
    }


    /**
     * Ensures that all track tiles are free from enemies.
     */
    public void repaint()
    {
        Frame.getHealthLabel().setText("Lives: " + Frame.getHealth());
        Frame.getGoldLabel().setText("Cash: " + Frame.getMoney());
        for (int col = 0; col < Values.grid.length; col++)
        {
            for (int row = 0; row < Values.grid[0].length; row++)
            {
                try
                {
                    if (Values.states[col][row] == 't')
                    {
                        Values.grid[col][row].setImage(
                            new ImageIcon(
                                new URL(
                                    "https://cdn.discordapp.com/attachments/1098448658283909130/1112449605175607477/track.jpg")));
                    }
                    else if (Values.states[col][row] == 'g')
                    {
                        Values.grid[col][row].setImage(
                            new ImageIcon(
                                new URL(
                                    "https://cdn.discordapp.com/attachments/1098448658283909130/1112448098854252654/grass.jpg")));
                    }
                    else
                    {
                        continue;
                    }
                }
                catch (MalformedURLException e)
                {
                    e.printStackTrace();
                }
            }
        }
        frame.revalidate();
        frame.repaint();
    }
}
