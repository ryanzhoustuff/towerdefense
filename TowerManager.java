import java.util.*;
public class TowerManager
{
    private ArrayList<Tower> towers;

    /**
     * Constructs a TowerManager object and initializes the Tower list.
     */
    public TowerManager()
    {
        towers = new ArrayList<Tower>();
    }


    /**
     * Getter method for length of towers.
     * 
     * @return The length of the arraylist of towers on field.
     */
    public int getLength()
    {
        return towers.size();
    }


    /**
     * Gets the tower at the index i in towers.
     * 
     * @param i
     *            The index of the tower you want to get from towers.
     * @return The tower at the index i in towers.
     */
    public Tower getTower(int i)
    {
        return towers.get(i);
    }


    /**
     * Adds a tower to the end of towers.
     * 
     * @param a
     *            The tower you want added to towers.
     */
    public void addTower(Tower a)
    {
        towers.add(a);
    }
}
