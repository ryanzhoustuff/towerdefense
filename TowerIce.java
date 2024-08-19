public class TowerIce
    extends Tower
{
    private int freeze;

    /**
     * Constructor for an ice tower. Uses Tower's setter methods to set the
     * damage, attack speed, cost, range and location variables of an ice tower.
     * 
     * @param LocationX
     *            The X coordinate where the tower should be spawned
     * @param LocationY
     *            The Y coordinate where the tower should be spawned
     */
    public TowerIce(double LocationX, double LocationY)
    {
        super.updateAttackSpeed(1);
        super.updateCost(700);
        super.updateDamage(12);
        super.updateRange(800);
        super.updateLocation(LocationX, LocationY);
        freeze = 1;
    }


    /**
     * Override of tower's attack function. Needed because ice tower also slows
     * down the enemy it is attacking.
     * 
     * @param a
     *            The enemy being attacked
     */
    public void attack(Enemy a)
    {
        super.attack(a);
        // int newSpeed = a.getSpeed() - freeze; // enemy stats require changes
        a.setSpeed(a.getSpeed() * 2);
    }
}
