public class TowerFire
    extends Tower
{
    /**
     * Constructor for a fire tower. Uses Tower's setter methods to set the
     * damage, attack speed, cost, range and location variables of a fire tower.
     * 
     * @param LocationX
     *            The X coordinate where the tower should be spawned
     * @param LocationY
     *            The Y coordinate where the tower should be spawned
     */
    public TowerFire(double LocationX, double LocationY)
    {
        super.updateAttackSpeed(1);
        super.updateCost(950);
        super.updateDamage(24);
        super.updateRange(1000);
        super.updateLocation(LocationX, LocationY);
    }
}
