import javax.swing.JFrame;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.Component;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.net.MalformedURLException;
import java.net.URL;
import javax.swing.*;
import java.awt.event.*;
public class Frame
    extends JFrame
    implements ActionListener
{
    private static int          health;
    private static int          money;
    private static JFrame       myFrame = new JFrame("Dylan's Tower Defense");
    private static boolean      state   = false;

    private static Queue<Tower> temp    = new LinkedList<Tower>();
    private static String       myUrl;

    private static JLabel       cash    = new JLabel("Cash: 1000$");
    private static JLabel       lives   = new JLabel("Health: 100");
    /** Type of tower about to be placed. */
    public static Tower         towerType; 
    /** Whether the game is running or paused. */
    public static boolean       flag    = true; 
    {
        health = 100;
        money = 1000;
        myFrame.setLayout(null);
        myFrame.setSize(800, 800);
        myFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        myFrame.setResizable(false);
        JButton b = new JButton();
        b.addActionListener(this);
        try
        {
            int widthOfButton = 70;
            int heightOfButton = 70;
            ImageIcon img = new ImageIcon(
                new URL(
                    "https://cdn.discordapp.com/attachments/1098448658283909130/1113257260257390593/tower.jpg"));
            Image oldimage = img.getImage();
            Image newimg = oldimage
                .getScaledInstance(widthOfButton, heightOfButton, java.awt.Image.SCALE_SMOOTH);
            img = new ImageIcon(newimg);
            JButton dmgbut = new JButton(img);
            dmgbut.setBounds(300, 650, widthOfButton, heightOfButton);
            JLabel dmgbutPrice = new JLabel("$350");
            dmgbutPrice.setBounds(322, 720, 70, 20);
            myFrame.add(dmgbutPrice);
            myFrame.add(dmgbut);
            dmgbut.addActionListener(this);
            dmgbut.setActionCommand("damage tower clicked");
        }
        catch (Exception e)
        {
            System.out.println("image URL didnt work");
        }
        try
        {
            int widthOfButton = 70;
            int heightOfButton = 70;
            ImageIcon img = new ImageIcon(
                new URL(
                    "https://cdn.discordapp.com/attachments/1098448658283909130/1113257600172163082/fireTower.jpg"));
            Image oldimage = img.getImage();
            Image newimg = oldimage
                .getScaledInstance(widthOfButton, heightOfButton, java.awt.Image.SCALE_SMOOTH);
            img = new ImageIcon(newimg);
            JButton firebut = new JButton(img);
            firebut.setBounds(470, 650, widthOfButton, heightOfButton);
            JLabel firebutPrice = new JLabel("$950");
            firebutPrice.setBounds(492, 720, 70, 20);
            myFrame.add(firebutPrice);
            myFrame.add(firebut);
            firebut.addActionListener(this);
            firebut.setActionCommand("fire tower clicked");
        }
        catch (Exception e)
        {
            System.out.println("image URL didnt work");
        }
        try
        {
            int widthOfButton = 70;
            int heightOfButton = 70;
            ImageIcon img = new ImageIcon(
                new URL(
                    "https://cdn.discordapp.com/attachments/1098448658283909130/1113258045749870613/iceTower.jpg"));
            Image oldimage = img.getImage();
            Image newimg = oldimage
                .getScaledInstance(widthOfButton, heightOfButton, java.awt.Image.SCALE_SMOOTH);
            img = new ImageIcon(newimg);
            JButton icebut = new JButton(img);
            icebut.setBounds(130, 650, widthOfButton, heightOfButton);
            JLabel icebutPrice = new JLabel("$700");
            icebutPrice.setBounds(152, 720, 70, 20);
            myFrame.add(icebutPrice);
            myFrame.add(icebut);
            icebut.addActionListener(this);
            icebut.setActionCommand("ice tower clicked");
        }
        catch (Exception e)
        {
            System.out.println("image URL didnt work");
        }
        try
        {
            int widthOfButton = 50;
            int heightOfButton = 50;
            ImageIcon img = new ImageIcon(
                new URL(
                    "https://static.vecteezy.com/system/resources/previews/000/630/395/original/play-button-icon-design-illustration-vector.jpg"));
            Image oldimage = img.getImage();
            Image newimg = oldimage
                .getScaledInstance(widthOfButton, heightOfButton, java.awt.Image.SCALE_SMOOTH);
            img = new ImageIcon(newimg);
            JButton pausebut = new JButton(img);
            pausebut.setBounds(700, 30, widthOfButton, heightOfButton);
            myFrame.add(pausebut);
            pausebut.addActionListener(this);
            pausebut.setActionCommand("pause play clicked");

            cash.setBounds(680, 100, 90, 30);
            myFrame.add(cash);

            lives.setBounds(680, 130, 90, 30);
            myFrame.add(lives);
        }
        catch (Exception e)
        {
            System.out.println("image URL didnt work");
        }
        myFrame.setVisible(true);
        this.setVisible(false);
    }

    /**
     * Returns current player health.
     * 
     * @return current health.
     */
    public static int getHealth()
    {
        return health;
    }


    /**
     * Returns current money.
     * 
     * @return current money.
     */
    public static int getMoney()
    {
        return money;
    }


    /**
     * Removes health from player health.
     * 
     * @param damage
     *            amount of health to be removed.
     */
    public static void removeHealth(int damage)
    {
        health -= damage;
    }


    /**
     * Adds money to player balance.
     * 
     * @param moneyDropped
     *            amount of money to add to balance.
     */
    public static void addMoney(int moneyDropped)
    {
        money += moneyDropped;
    }


    /**
     * Removes money from player balance.
     * 
     * @param cost
     *            amount of money to be deducted from balance.
     */
    public static void removeMoney(int cost)
    {
        money -= cost;
    }


    /**
     * Returns the JLabel for player health.
     * 
     * @return health JLabel
     */
    public static JLabel getHealthLabel()
    {
        return lives;
    }


    /**
     * Returns the JLabel for player money.
     * 
     * @return money JLabel
     */
    public static JLabel getGoldLabel()
    {
        return cash;
    }


    private static void createAndShowGUI()
    {
        myFrame.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                if (flag == true)
                {
                    flag = false;
                    if (Values.states[e.getX() / (myFrame.getWidth() / 12)][e.getY()
                        / (5 * myFrame.getHeight() / 72)] == 't')
                    {
                        System.out.println(
                            "Your tower cannot be placed on the track, please place the tower on a grass tile");
                    }
                    else if (!Values.grid[e.getX() / (myFrame.getWidth() / 12)][e.getY()
                        / (5 * myFrame.getHeight() / 72)].empty)
                    {
                        System.out.println("Cannot place a tower on top of another tower");
                        System.out.println(e.getX() / (myFrame.getWidth() / 12));
                        System.out.println(e.getY() / (5 * myFrame.getHeight() / 72));
                    }
                    else if (money < towerType.getCost())
                    {
                        System.out.println("Not enough cash!");
                    }
                    else
                    {
                        towerType.updateLocation(e.getX(), e.getY());
                        temp.add(towerType);
                        applyImageAtTile(e.getX(), e.getY());
                        removeMoney(towerType.getCost());
                        cash.setText("Cash: " + money + "$");
                    }
                }
            }
        });
    }


    /**
     * Places an image at a chosen tile.
     * 
     * @param x
     *            X value of tile in grid.
     * @param y
     *            Y value of tile in grid.
     */
    public static void applyImageAtTile(int x, int y)
    {
        try
        {
            ImageIcon img = new ImageIcon(new URL(myUrl));
            Image oldimage = img.getImage();
            Image newimg = oldimage
                .getScaledInstance(Tile.getWidth(), Tile.getHeight(), java.awt.Image.SCALE_SMOOTH);
            img = new ImageIcon(newimg);
            Values.grid[x / (myFrame.getWidth() / 12)][y / (5 * myFrame.getHeight() / 72)]
                .setImage(img);
            Values.grid[x / (myFrame.getWidth() / 12)][y / (5 * myFrame.getHeight() / 72)].empty =
                false;
            Values.states[x / (myFrame.getWidth() / 12)][y / (5 * myFrame.getHeight() / 72)] = 'h';

        }
        catch (Exception e)
        {
            System.out.println("Please select a tile on screen");
        }
    }


    /**
     * Action Listener for this frame.
     */
    public void actionPerformed(ActionEvent ae)
    {
        String action = ae.getActionCommand();
        if (action.equals("pause play clicked"))
        {
            state = true;
        }
        if (action.equals("ice tower clicked") && money >= new TowerIce(0, 0).getCost())
        {
            towerType = new TowerIce(0, 0);
            flag = true;
            createAndShowGUI();
            try
            {
                myUrl =
                    "https://cdn.discordapp.com/attachments/1098448658283909130/1113258045749870613/iceTower.jpg";
            }
            catch (Exception e)
            {
                System.out.println("myUrl doesnt work here");
            }
        }
        if (action.equals("damage tower clicked") && money >= new TowerBasic(0, 0).getCost())
        {
            towerType = new TowerBasic(0, 0);
            flag = true;
            createAndShowGUI();
            try
            {
                myUrl =
                    "https://cdn.discordapp.com/attachments/1098448658283909130/1113257260257390593/tower.jpg";
            }
            catch (Exception e)
            {
                System.out.println("myUrl doesnt work here");
            }
        }
        if (action.equals("fire tower clicked") && money >= new TowerFire(0, 0).getCost())
        {
            towerType = new TowerFire(0, 0);
            flag = true;
            createAndShowGUI();
            try
            {
                myUrl =
                    "https://cdn.discordapp.com/attachments/1098448658283909130/1113257600172163082/fireTower.jpg   ";
            }
            catch (Exception e)
            {
                System.out.println("myUrl doesnt work here");
            }
        }
    }


    /**
     * Main class for Dylan's Tower Defense.
     * 
     * @param args the standard argument array.
     */
    public static void main(String args[])
    {

        new Frame();
        Screen screen = new Screen(myFrame);
        screen.paint();

        int round = 1;
        Queue<Enemy> roundEnemies = new LinkedList<Enemy>();
        // round 1
        roundEnemies.add(new EnemyBasic(1001, myFrame));
        roundEnemies.add(new EnemyBasic(1002, myFrame));
        roundEnemies.add(new EnemyBasic(1003, myFrame));
        roundEnemies.add(new EnemyBasic(1004, myFrame));
        roundEnemies.add(new EnemyBasic(1005, myFrame));
        roundEnemies.add(new EnemyBasic(1006, myFrame));
        roundEnemies.add(new EnemyBasic(1007, myFrame));
        roundEnemies.add(new EnemyBasic(1008, myFrame));
        roundEnemies.add(new EnemyBasic(1009, myFrame));
        roundEnemies.add(new EnemyBasic(1010, myFrame));
        roundEnemies.add(new EnemyBasic(1011, myFrame));
        roundEnemies.add(new EnemyBasic(1012, myFrame));
        roundEnemies.add(new EnemyBasic(1013, myFrame));
        roundEnemies.add(new EnemyBasic(1014, myFrame));
        roundEnemies.add(new EnemyBasic(1015, myFrame));
        roundEnemies.add(new EnemyBasic(1016, myFrame));
        roundEnemies.add(new EnemyBasic(1017, myFrame));
        roundEnemies.add(new EnemyBasic(1018, myFrame));
        roundEnemies.add(new EnemyBasic(1019, myFrame));
        roundEnemies.add(new EnemyBasic(1020, myFrame));
        roundEnemies.add(new EnemyBasic(1021, myFrame));
        roundEnemies.add(new EnemyBasic(1022, myFrame));
        roundEnemies.add(new EnemyBasic(1023, myFrame));
        roundEnemies.add(new EnemyBasic(1024, myFrame));
        roundEnemies.add(new EnemyBasic(1025, myFrame));
        roundEnemies.add(new EnemyBasic(1026, myFrame));
        roundEnemies.add(new EnemyBasic(1027, myFrame));
        roundEnemies.add(new EnemyTanky(1030, myFrame));
        roundEnemies.add(new EnemyTanky(1035, myFrame));

        // round 2
        roundEnemies.add(new EnemyTanky(2001, myFrame));
        roundEnemies.add(new EnemyFast(2002, myFrame));
        roundEnemies.add(new EnemyFast(2003, myFrame));
        roundEnemies.add(new EnemyFast(2004, myFrame));
        roundEnemies.add(new EnemyFast(2005, myFrame));
        roundEnemies.add(new EnemyFast(2006, myFrame));
        roundEnemies.add(new EnemyTanky(2010, myFrame));
        roundEnemies.add(new EnemyTanky(2012, myFrame));
        roundEnemies.add(new EnemyTanky(2014, myFrame));
        roundEnemies.add(new EnemyTanky(2016, myFrame));
        roundEnemies.add(new EnemyTanky(2018, myFrame));
        roundEnemies.add(new EnemyTanky(2020, myFrame));
        roundEnemies.add(new EnemyTanky(2022, myFrame));

        // round 3
        roundEnemies.add(new EnemyBasic(3001, myFrame));
        roundEnemies.add(new EnemyBasic(3002, myFrame));
        roundEnemies.add(new EnemyBasic(3003, myFrame));
        roundEnemies.add(new EnemyBasic(3004, myFrame));
        roundEnemies.add(new EnemyBasic(3005, myFrame));
        roundEnemies.add(new EnemyBasic(3006, myFrame));
        roundEnemies.add(new EnemyBasic(3007, myFrame));
        roundEnemies.add(new EnemyBasic(3008, myFrame));
        roundEnemies.add(new EnemyBasic(3009, myFrame));
        roundEnemies.add(new EnemyBasic(3010, myFrame));
        roundEnemies.add(new EnemyBasic(3011, myFrame));
        roundEnemies.add(new EnemyBasic(3012, myFrame));
        roundEnemies.add(new EnemyBasic(3013, myFrame));
        roundEnemies.add(new EnemyBasic(3014, myFrame));
        roundEnemies.add(new EnemyBasic(3015, myFrame));
        roundEnemies.add(new EnemyBoss(3020, myFrame));
        // background gui stuff gets created
        // pause/play button
        int health = 100;
        TowerManager fieldTowers = new TowerManager();
        FieldEnemyManager fieldEnemies = new FieldEnemyManager(myFrame);
        // Repaint repaintManager = new Repaint(fieldEnemies);
        while (state == false)
        {
            String s1 = new String("Hi");
            if (state != false)
            {
                break;
            }
            // shop should still be able to be used here
        }
        if (state == true)// play button is pressed)
        {
            // shop should be able to be used here
            double time = 0;
            while (true)
            {
                long start = System.nanoTime();
                if (roundEnemies.peek() != null
                    && roundEnemies.peek().getSpawnTime() / 1000 != round
                    && fieldEnemies.getLength() == 0)
                { // when the round is over nothing should happen!!!!
                    round = roundEnemies.peek().getSpawnTime() / 1000;
                    state = false;
                    screen.repaint();
                    time = 0;
                    while (state != true)
                    { // play button is not pressed

                        String s2 = new String("Hi!");
                        if (state != false)
                        {
                            break;
                        }
                        // shop should still be able to be used here
                    }
                }
                while (!temp.isEmpty())
                {
                    fieldTowers.addTower(temp.remove());
                }
                for (int i = 0; i < fieldTowers.getLength(); i++)
                { // checks if any towers can attack enemies
                    for (int j = 0; j < fieldEnemies.getLength(); j++)
                    {
                        if (fieldTowers.getTower(i).inRange(fieldEnemies.getEnemy(j)))
                        { // if enemy is in range of tower
                            if ((int)(10 * (time + 0.05)) % 10
                                * (fieldTowers.getTower(i).getAttackSpeed()) == 0)
                            { // checks if attack speed of tower aligns with
                              // time(basically if the tower should have
                              // reloaded at this time)
                                fieldEnemies.getEnemy(j)
                                    .removeHealth(fieldTowers.getTower(i).getDamage()); // deals
                                                                                        // damage
                                                                                        // to
                                                                                        // enemy
                                if (fieldEnemies.getEnemy(j).getHealth() <= 0)
                                { // if enemy health is less than 0, remove from
                                  // field
                                    int xTemp =
                                        (int)Values.points[fieldEnemies.getEnemy(j).getPoint()]
                                            .getX();
                                    int yTemp =
                                        (int)Values.points[fieldEnemies.getEnemy(j).getPoint()]
                                            .getY();
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
                                    money += fieldEnemies.getEnemy(j).getMoneyDropped();
                                    cash.setText("Cash: " + money + "$");
                                    fieldEnemies.removeEnemy(fieldEnemies.getEnemy(j));
                                    fieldEnemies.remove(fieldEnemies.getEnemy(j));
                                }
                                break; // tower should not be attacking any more
                                       // enemies(all towers are single target)
                            }

                        }
                    }
                }
                lives.setText("Health: " + getHealth());
                // System.out.println(time);
                fieldEnemies.update();
                int roundTime = 1000 * round + (int)time;
                if (roundEnemies.peek() != null && roundEnemies.peek().getSpawnTime() == roundTime)
                {
                    fieldEnemies.addEnemy(roundEnemies.remove()); // if time is
                                                                  // correct,
                                                                  // spawns
                                                                  // enemy +
                                                                  // removes
                                                                  // from
                                                                  // hashmap
                }

                if (getHealth() <= 0)
                {
                    try
                    {
                        int imgWidth = 800;
                        int imgHeight = 800;
                        int LocX = 0;
                        int LocY = 0;
                        ImageIcon iag = new ImageIcon(
                            new URL(
                                "https://res.cloudinary.com/jerrick/image/upload/v1640244367/61c4248f4166b2001d2d7199.jpg"));
                        Image image = iag.getImage();
                        Image newimg = image
                            .getScaledInstance(imgWidth, imgHeight, java.awt.Image.SCALE_SMOOTH);
                        iag = new ImageIcon(newimg);
                        JLabel imgLabel = new JLabel(iag);

                        imgLabel.setBounds(LocX, LocY, imgWidth, imgHeight);
                        myFrame.add(imgLabel);
                        myFrame.setComponentZOrder(imgLabel, 0);
                        myFrame.revalidate();
                        myFrame.repaint();
                    }
                    catch (Exception e)
                    {
                        System.out.println("Image didn't work");
                    }
                    screen.repaint();
                    break;
                }
                if (roundEnemies.isEmpty() && fieldEnemies.getLength() == 0 && health > 0)
                { // again we gotta have that last one or things dont work for
                  // some reason
                    try
                    {
                        int imgWidth = 800;
                        int imgHeight = 800;
                        int LocX = 0;
                        int LocY = 0;
                        ImageIcon iag = new ImageIcon(
                            new URL(
                                "https://us.123rf.com/450wm/vasilyrosca/vasilyrosca2004/vasilyrosca200400260/145426048-retro-game-glitch-win-score-background-video-game-you-win-glitch-effect-text.jpg"));
                        Image image = iag.getImage();
                        Image newimg = image
                            .getScaledInstance(imgWidth, imgHeight, java.awt.Image.SCALE_SMOOTH);
                        iag = new ImageIcon(newimg);
                        JLabel imgLabel = new JLabel(iag);

                        imgLabel.setBounds(LocX, LocY, imgWidth, imgHeight);
                        myFrame.add(imgLabel);
                        myFrame.setComponentZOrder(imgLabel, 0);
                        myFrame.revalidate();
                        myFrame.repaint();
                        break;
                    }
                    catch (Exception e)
                    {
                        System.out.println("Image didn't work");
                    }
                    screen.repaint();
                    break;
                }
                long finish = System.nanoTime();
                if ((finish - start) / 100000 < 200)
                { // if the program takes less than 200 milliseconds to run,
                  // then we wait until 200 milliseconds. if the program takes
                  // over 200 milliseconds, ig well die
                    try
                    { // now, you wait 100 milliseconds MINUS the time it took
                      // for the program to run its loop.
                        Thread.sleep(200 - (int)((double)finish - (double)start) / 1000000);
                    }
                    catch (InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
                time += 0.2;
            }
        }
    }


    /**
     * Returns the associated JFrame.
     * 
     * @return the used JFrame
     */
    public static JFrame getFrame()
    {
        return myFrame;
    }
}
