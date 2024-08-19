public abstract class Tower
{
    private int        damage;
    private double     attackSpeed;
    private static int cost;
    private double     range;
    private double     locationY;
    private double     locationX;

    /**
     * Represents a new tower object.
     */
    public Tower()
    {
    }


    /**
     * Updates the location of the tower.
     * 
     * @param displacementY
     *            The Y coordinate of the tower
     * @param displacementX
     *            The X coordinate of the tower
     */
    public void updateLocation(double displacementY, double displacementX)
    {
        locationY = displacementY;
        locationX = displacementX;
    }


    /**
     * Getter method for the damage of a tower
     * 
     * @return Damage value for tower
     */
    public int getDamage()
    {
        return damage;
    }


    /**
     * Getter method for the time between attacks of the tower
     * 
     * @return Attack speed of the tower(in seconds)
     */
    public double getAttackSpeed()
    {
        return attackSpeed;
    }


    /**
     * Getter method for the cost of the tower
     * 
     * @return Cost of tower
     */
    public int getCost()
    {
        return cost;
    }


    /**
     * Setter method for the attack damage of a tower
     * 
     * @param newDamage
     *            Damage tower should deal to enemies in 1 hit
     */
    public void updateDamage(int newDamage)
    {
        damage = newDamage;
    }


    /**
     * Setter method for attack speed of a tower(time between attacks)
     * 
     * @param newAttackSpeed
     *            Attack speed of the tower(in seconds)
     */
    public void updateAttackSpeed(double newAttackSpeed)
    {
        attackSpeed = newAttackSpeed;
    }


    /**
     * Setter method for cost of a tower
     * 
     * @param newCost
     *            Tower cost(in coins)
     */
    public void updateCost(int newCost)
    {
        cost = newCost;
    }


    /**
     * Setter method for tower range
     * 
     * @param newRange
     *            Range of tower
     */
    public void updateRange(int newRange)
    {
        range = newRange;
    }


    /**
     * Checks if an enemy is inside the range of a tower using the pythagorean
     * theorem
     * 
     * @param a
     *            The enemy that you want to check if its inside the range of
     *            the tower
     * @return True if the enemy is inside the tower's range, false if the enemy
     *         is not inside the tower's range.
     */
    public boolean inRange(Enemy a)
    {
        double distance = (locationY - a.getY()) * (locationY - a.getY());
        distance += (locationX - a.getX()) * (locationX - a.getX());
        if (distance <= range * range)
        {
            return true;
        }
        return false;
    }

    /*
     * public double getAngle(Enemy a){ double Y = locationY-a.getY(); double X
     * = locationX-a.getX(); return Math.atan(Y/X); }
     */


    /**
     * The tower removes health from the enemy equivalent to its damage value
     * 
     * @param a
     *            The enemy you waant to remove health from
     */
    public void attack(Enemy a)
    {
        a.removeHealth(damage);
    }


    /**
     * Returns the price of this tower.
     * 
     * @return the associated cost of this tower.
     */
    public static String getPrice()
    {
        return "$" + cost;
    }
}
