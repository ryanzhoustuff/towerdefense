import javax.swing.*;
import java.awt.Container;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;
public class Tile
/* implements MouseListener */ {

    /** A tower may be placed on this tile if this tile is empty. */
    public boolean     empty; 

    private JFrame     frame;
    private JLabel     jLabel;
    private ImageIcon  imageIcon;
    private static int width  = Frame.getFrame().getWidth() / 12;
    private static int height = 5 * Frame.getFrame().getHeight() / 72;

    /**
     * Represents a tile on the grid display.
     * 
     * @param jFrame
     *            The associated frame.
     * @param type
     *            The type of tile - grass, track, or tower.
     */
    public Tile(JFrame jFrame, String type)
    {
        frame = jFrame;
        try
        {
            switch (type)
            {
                case "grass":
                    empty = true;
                    imageIcon = new ImageIcon(
                        new URL(
                            "https://cdn.discordapp.com/attachments/1098448658283909130/1112448098854252654/grass.jpg"));
                    break;
                case "track":
                    empty = false;
                    imageIcon = new ImageIcon(
                        new URL(
                            "https://cdn.discordapp.com/attachments/1098448658283909130/1112449605175607477/track.jpg"));
                    break;
            }
            jLabel = new JLabel(imageIcon);
            frame.add(jLabel, -1);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }


    /**
     * Sets the location of this Tile.
     * 
     * @param x
     *            The X position of this tile in the grid.
     * @param y
     *            The Y position of this tile in the grid.
     */
    public void setLocation(int x, int y)
    {
        jLabel.setBounds(x, y, width, height);
    }


    /**
     * Changes the image display on this tile.
     * 
     * @param icon
     *            The new image to be displayed.
     */
    public void setImage(ImageIcon icon)
    {
        imageIcon = icon;
        jLabel.setIcon(icon);
        ImageIcon img = icon;
        Image oldimage = img.getImage();
        Image newimg = oldimage
            .getScaledInstance(Tile.getWidth(), Tile.getHeight(), java.awt.Image.SCALE_SMOOTH);
        img = new ImageIcon(newimg);
        Frame.getFrame().validate();
        Frame.getFrame().repaint();
    }


    /**
     * Returns the ImageIcon currently being displayed on this Tile.
     * 
     * @return the current associated ImageIcon.
     */
    public ImageIcon getImageIcon()
    {
        return imageIcon;
    }


    /**
     * Returns the JLabel currently being used by this Tile.
     * 
     * @return the associated JLabel.
     */
    public JLabel getLabel()
    {
        return jLabel;
    }


    /**
     * Returns the width of this Tile.
     * 
     * @return width of this tile.
     */
    public static int getWidth()
    {
        return width;
    }


    /**
     * Returns the height of this Tile.
     * 
     * @return height of this tile.
     */
    public static int getHeight()
    {
        return height;
    }
}
