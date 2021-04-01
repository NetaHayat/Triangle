
/**
 * Point.java represents a 2-Dimensional point in the Euclidean space.
 *
 * @author Neta Hayat
 * @version 23/03/2021 v-1
 */
public class Point
{
    // declarations
    private double _x;
    private double _y;
    private final int AXIS_BORDER = 0;
    
    // constructors
    /**
     * Constructs a new Point
     * @param x the x coordinate
     * @param y the y coordinate
     */
    public Point(double x, double y)
    {
        _x = x;
        _y = y;
    } // end of constructor Point(double x, double y)
    
    /**
     * Copy constructor Creates a new Point identical to the given point
     * @param other the Point to be copied
     */
    public Point (Point other) 
    {
        if(other!=null) { // check that the given object is initialized
            _x = other._x;
            _y = other._y;
        } // end of if statment 
    } // end of Copy constructor Point (Point other)
    
    // methods
    /**
     * Returns the x coodinate.
     * @return a double.
     */
    public double getX() 
    {
        return _x;
    } // end of method getX()
    
    /**
     * Returns the y coordinate.
     * @return a double.
     */
    public double getY()
    {
        return _y;
    } // end of method getY()
    
    /**
     * This method sets the x coordinate of the point.
     * @param num The new x coordinate
     */
    public void setX(double num)
    {
        _x = num;
    } // end of method setX()
    
    /**
     * This method sets the y coordinate of the point.
     * @param num The new y coordinate
     */
    public void setY(double num)
    {
        _y = num;
    } // end of method setY()
    
    /**
     * Returns a string representation of this Point. 
     * The format of the string should be: (x,y)
     * @return A string representation of a Point object
     */
    public String toString()
    {
       return "("+_x+","+_y+")"; 
    } // end of method toString()
    
    /**
     * Return true iff the given point is equal to this point.
     * @param other The point we are checking equality with
     * @return true if the point other equals this point
     */
    public boolean equals(Point other)
    {
        return (other._x == _x && other._y == _y);
    } // end of method equals(Point other)
    
    /**
     * Check if this point is above a received point.
     * @param other The point to check if this point is above
     * @return true if this point is above the other point
     */
    public boolean isAbove(Point other)
    {
        return other._y < _y;
    } // end of method isAbove(Point other)
    
    /**
     * Check if this point is below a received point.
     * @param other The point to check if this point is below
     * @return true if this point is below the other point
     */
    public boolean isUnder(Point other)
    {
        return other.isAbove(this);
    } // end of method isUnder(Point other)
    
    /**
     * Check if this point is left of a received point.
     * @param other The point to check if this point is left of
     * @return true if this point is left of the other point
     */
    public boolean isLeft(Point other)
    {
        return _x < other._x;
    } // end of method isLeft(Point other)
    
    /**
     * Check if this point is right of a received point.
     * @param other The point to check if this point is right of
     * @return true if this point is right of the other point
     */
    public boolean isRight(Point other)
    {
        return other.isLeft(this);
    } // end of method isRight(Point other)
    
    /**
     * Check the distance between this point and a received point.
     * @param p The point to check the distance from
     * @return The distance between this point and a received point
     */
    public double distance(Point p)
    {
        return Math.sqrt(Math.pow((_x-p._x),2) + Math.pow((_y-p._y),2));
    } // end of method distance(Point p)
    
    /**
     * Return number of quadrant or 0 if the point is on an axis
     * @return an int representing the quadrant number
     */
    public int quadrant()
    {
        if(_x > AXIS_BORDER && _y > AXIS_BORDER) { // if the point is on quardrant 1
            return 1;
        } else if(_x < AXIS_BORDER && _y > AXIS_BORDER){ // if the point is on quardrant 2
            return 2;
        } else if(_x < AXIS_BORDER && _y < AXIS_BORDER) { // if the point is on quardrant 3
            return 3;
        } else if(_x > AXIS_BORDER && _y < AXIS_BORDER) { // if the point is on quardrant 4
            return 4;
        }
        else { // if the point is on an axis
            return 0;
        }
    } // end of method quadrant()
} // end of class Point

