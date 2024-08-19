import java.awt.*;
public class Values
{
    /** images of each enemy-basic, fast, tanky, boss, respectively. */
    public static final String[] URLS   = {
        "https://cdn.discordapp.com/attachments/1098448658283909130/1112516722470166639/image.png",
        "https://cdn.discordapp.com/attachments/1098448658283909130/1112518766333542450/image.png",
        "https://cdn.discordapp.com/attachments/1098448658283909130/1112484023764258987/enemyTanky.jpg",
        "https://cdn.discordapp.com/attachments/1098448658283909130/1111867603502235698/EnemyBoss.png" };
    
    /** Represents all positions for enemies to follow as they move along the track. */
    public static Point[]        points = { new Point(0, 2), new Point(0, 2), new Point(1, 2),
        new Point(2, 2), new Point(2, 3), new Point(2, 4), new Point(2, 5), new Point(2, 6),
        new Point(2, 7), new Point(2, 8), new Point(2, 9), new Point(2, 10), new Point(3, 10),
        new Point(4, 10), new Point(5, 10), new Point(6, 10), new Point(7, 10), new Point(8, 10),
        new Point(8, 9), new Point(8, 8), new Point(8, 7), new Point(8, 6), new Point(9, 6) }; 

    /** Stores the status of each tile in the grid: Grass('g'), Track('t'), and Tower('h') */
    public static char[][]       states =
        { { 'g', 'g', 't', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' },
            { 'g', 'g', 't', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g' },
            { 'g', 'g', 't', 't', 't', 't', 't', 't', 't', 't', 't', 'g' },
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 't', 'g' },
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 't', 'g' },
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 't', 'g' },
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 't', 'g' },
            { 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 'g', 't', 'g' },
            { 'g', 'g', 'g', 'g', 'g', 'g', 't', 't', 't', 't', 't', 'g' },
            { 'g', 'g', 'g', 'g', 'g', 'g', 't', 'g', 'g', 'g', 'g', 'g' } }; 

    /** Creates the array used to represent all tiles in a grid. */
    public static final Tile[][] grid   = new Tile[10][12]; 

    /** Initializes the grid when this class is called for the first time. */
    static
    {
        for (int columns = 0; columns < 10; columns++)
        {
            for (int rows = 0; rows < 12; rows++)
            {
                if (Values.states[columns][rows] == 't')
                {
                    Tile tile = new Tile(Frame.getFrame(), "track");
                    grid[columns][rows] = tile;
                }
                else
                {
                    Tile tile = new Tile(Frame.getFrame(), "grass");
                    grid[columns][rows] = tile;
                }
            }
        }
    }
}
