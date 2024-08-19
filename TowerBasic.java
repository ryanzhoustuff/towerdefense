public class TowerBasic
    extends Tower
{
    /**
     * Constructor for a basic tower. Uses Tower's setter methods to set the
     * damage, attack speed, cost, range and location variables of a basic
     * tower.
     * 
     * @param LocationX
     *            The X coordinate where the tower should be spawned
     * @param LocationY
     *            The Y coordinate where the tower should be spawned
     */
    public TowerBasic(double LocationX, double LocationY)
    {
        super.updateAttackSpeed(1);
        super.updateCost(350);
        super.updateDamage(8);
        super.updateRange(800);
        super.updateLocation(LocationX, LocationY);
    }
}
