
/**
 * represents a triangle in the Euclidean space.
 *
 * @author Neta Hayat
 * @version 01/04/2021 v-1
 */
public class Triangle {
    
    // declarations
    private Point _point1;
    private Point _point2;
    private Point _point3;
    private final double POINT1_X = 1; // default x of _point1
    private final double POINT1_Y = 0; // // default y of _point1
    private final double POINT2_X = -1; // default x of _point2
    private final double POINT2_Y = 0; // default y of _point2
    private final double POINT3_X = 0; // default x of _point3
    private final double POINT3_Y = 1; // default y of _point3
    private final double HALF_PERIMETER_DIVIDER = 2; 
    private final double PYTHANGOREAN_EXPONENT = 2; // power of 2 for pythangorean formula
    private final int ON_AXIS = 0; // represents an axis border 
    static final double EPSILON = 0.001;
    
    // constructors
    /**
     * Construct a new Triangle (default constructor) from 3 default Points:(1,0),(-1,0),(0,1)
     */
    public Triangle() 
    {
        this._point1 = new Point(POINT1_X,POINT1_Y);
        this._point2 = new Point(POINT2_X,POINT2_Y);
        this._point3 = new Point(POINT3_X,POINT3_Y);
    } // end of defalut constructor Triangle()
    
    /**
     * Construct a new Triangle (from 3 points)
     * @param p1 the first Point
     * @param p2 the second Point
     * @param p3 the third Point
     */
    public Triangle(Point p1, Point p2, Point p3)
    {
        this();
        if(isValid(p1,p2,p3)) { // if the triangle is valid 
            this._point1 = new Point(p1);
            this._point2 = new Point(p2);
            this._point3 = new Point(p3);
        }// end of if statement
    } // end of constructor Triangle(Point p1, Point p2, Point p3)
    
    /**
     * Construct a new Triangle (from 6 reals)
     * @param x1 the x coordinate of the first Point
     * @param y1 the y coordinate of the first Point
     * @param x2 the x coordinate of the second Point
     * @param y2 the y coordinate of the second Point
     * @param x3 the x coordinate of the third Point
     * @param y3 the y coordinate of the third Point
     */
    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3)
    {
        this();
        
        if(isValid(new Point (x1,y1),new Point(x2,y2),new Point(x3,y3))) { // check if the 6 numbers created a valid triangle
            this._point1 = new Point(x1,y1);
            this._point2 = new Point(x2,y2);
            this._point3 = new Point(x3,y3);
        } // end of if statment 
    } // end of constructor Triangle based on 6 numbers
    
    /**
     * Copy constructor Creates a new triangle identical to the given triangle
     * @param other the triangle to be copied
     */
    public Triangle(Triangle other) 
    { 
        this._point1 = new Point(other._point1);
        this._point2 = new Point(other._point2);
        this._point3 = new Point(other._point3);
    } // end of copy constructor Triangle(Triangle other)
    
    // methods
    /**
     * This method checks if 3 points make a valid triangle. 
     * A triangle is valid if no sum of any two sides equals the third side (with precision EPSILON)
     * @param p1 the first point
     * @param p2 the second point
     * @param p3 the third point
     * @return true if the triangle(p1,p2,p3) is valid
     */
    public boolean isValid(Point p1, Point p2, Point p3)
    { // check to see if the triangle is valid
        
        //declaration of distances between points
        double distance1 = p1.distance(p2);
        double distance2 = p2.distance(p3);
        double distance3 = p3.distance(p1);
        
        return !epsilonTest(distance1, distance2 + distance3) && !epsilonTest(distance2, distance1 + distance3)
                && !epsilonTest(distance3, distance2 + distance1);
    } // end of method isValid
    
    /**
     * This method returns the triangle's first point
     * @return The first point of the triangle
     */
    public Point getPoint1()
    {
        return new Point(_point1);
    } // end of method getPoint1()
    
    /**
     * This method returns the triangle's second point
     * @return The second point of the triangle
     */
    public Point getPoint2()
    {
        return new Point(_point2);
    } // end of method getPoint2()
    
    /**
     * This method returns the triangle's third point
     * @return The third point of the triangle
     */
    public Point getPoint3()
    {
        return new Point(_point3);
    } // end of method getPoint3()
    
    /**
     * This method sets the first point of the triangle.
     * @param p The new first point
     */
    public void setPoint1(Point p)
    {
        if(isValid(p, _point2, _point3)){ // if the triangle is valid with the new point
        _point1 = new Point(p);
        }
    } // end of method setPoint1(Point p)
    
    /**
     * This method sets the second point of the triangle.
     * @param p The new second point
     */
    public void setPoint2(Point p)
    {
        if(isValid(_point1, p, _point3)){ // if the triangle is valid with the new point
        _point2 = new Point(p);
        }
    } // end of method setPoint2(Point p)
    
    /**
     * This method sets the third point of the triangle.
     * @param p The new third point
     */
    public void setPoint3(Point p)
    {
        if(isValid(_point1, _point2, p)){ // if the triangle is valid with the new point
        _point3 = new Point(p);
        }
    } // end of method setPoint3(Point p)    
    
    /**
     * This method returns a String representation of thetTriangle. 
     * The format of the string should be: {(x1,y1),(x2,y2),(x3,y3)}
     * @return a String representation of the triangle
     */
    public String toString()
    {
        return "{"+ _point1 + "," + _point2 + "," + _point3 + "}";
    } // end of method toString()
    
    private double getEdge(Point p1, Point p2)
    { // calculates the distance between two points
        return p1.distance(p2);
    } // end of method getEdge()
    
    private double getEdge1()
    { // calculates the first edge of the traingle based on the given points
        return getEdge(this._point1, this._point2);
    } // end of method getEdge1()
    
    private double getEdge2()
    { // calculates the second edge of the traingle based on the given points
        return getEdge(this._point2, this._point3);
    } // end of method getEdge2()
    
    private double getEdge3()
    { // calculates the third edge of the traingle based on the given points
        return getEdge(this._point3, this._point1);
    } // end of method getEdge3()
    
    private boolean epsilonTest(double num1, double num2)
    { // check if 2 doubles are equal by the precision epsilon
        return Math.abs(num1 - num2) < EPSILON;
    } // end of method epsilonTest(double num1, double num2)
    
    /**
     * This method returns the triangle's perimeter.
     * @return the triangle's perimeter
     */
    public double getPerimeter()
    {
        return getEdge1() + getEdge2() + getEdge3();
    } // end of method getPerimeter() 
    
    /**
     * This method returns the triangle's area (using Heron's formula).
     * @return the triangle's area
     */
    public double getArea()
    {
        double halfPerimeter = getPerimeter() / HALF_PERIMETER_DIVIDER; // half perimeter based on getPerimeter method
        
        return Math.sqrt(halfPerimeter * (halfPerimeter - getEdge1()) * (halfPerimeter - getEdge2())
                * (halfPerimeter - getEdge3()));
    } // end of method getArea()
    
    /**
     * This method returns true if the triangle is an isosceles triangle(with precision EPSILON).
     * @return true if the triangle is an isosceles triangle
     */
    public boolean isIsosceles()
    {
        return epsilonTest(getEdge1(), getEdge2()) || epsilonTest(getEdge2(), getEdge3()) || 
               epsilonTest(getEdge3(), getEdge1());
    } // end of method isIsosceles()
    
    private double pythangorean(double dis1, double dis2)
    { // calculates the left side of pythangorean formula 
        return Math.sqrt(Math.pow(dis1, PYTHANGOREAN_EXPONENT) + Math.pow(dis2, PYTHANGOREAN_EXPONENT));
    } // end of method pythangorean(double dis1, double dis2)
    
    /**
     * This method returns true if the triangle is a right-angled triangle.
     * @return true if the triangle is a right-angled triangle
     */
    public boolean isPythagorean()
    {        
        return epsilonTest(getEdge1(), pythangorean(getEdge2(), getEdge3())) || 
               epsilonTest(getEdge2(), pythangorean(getEdge1(), getEdge3())) || 
               epsilonTest(getEdge3(), pythangorean(getEdge1(), getEdge2()));
    } // end of method isPythagorean()
    
    /**
     * This method returns true if the triangle is in a given circle.
     * @param x the x value of the point which is the center of the circle
     * @param y the y value of the point which is the center of the circle
     * @param r the radius of the circle
     * @return true if the triangle is in a given circle.
     */
    public boolean isContainedInCircle(double x, double y, double r)
    {
        Point _center = new Point(x,y); // creating new point based on given x and y
        
        // declarations of distances between triangle points and the center of the circle 
        double distance1 = getEdge(_point1, _center);
        double distance2 = getEdge(_point2, _center); 
        double distance3 = getEdge(_point3, _center);
        
        return (epsilonTest(distance1, r) || distance1 < r) && (epsilonTest(distance2, r) || distance2 < r) && 
                (epsilonTest(distance3, r) || distance3 < r);
    } // end of method isContainedInCircle(double x, double y, double r)
    
    private Point leftBetweenTwo(Point p1, Point p2)
    { // check which point is more left out of two
        if(p1.isLeft(p2)) { // p1 is more left
            return new Point(p1);
        }
        else { // p2 is more left
            return new Point(p2);
        } // end of if statment
    } // end of method leftBetweenTwo(Point p1, Point p2)
    
    private Point lowBetweenTwo(Point p1, Point p2)
    { // check which point is lower out of two
        if(p1.isUnder(p2)) { // p1 is lower
            return new Point(p1);
        }
        else if(p2.isUnder(p1)) { // p2 is lower
            return new Point(p2);
        }
        else { // both have the same height
            return leftBetweenTwo(p1,p2);
        } // end of if statment
    } // end of method lowBetweenTwo(Point p1, Point p2)
    
    /**
     * This method returns the lowest vertex of the triangle.
     * @return the lowest vertex
     */
    public Point lowestPoint()
    {
        return lowBetweenTwo(lowBetweenTwo(_point1, _point2), _point3);
    } // end of method lowestPoint()
    
    private Point highBetweenTwo(Point p1, Point p2)
    { // check which point is higher out of two
        if(p1.isAbove(p2)) { // p1 is higher
            return new Point(p1);
        }
        else if(p2.isAbove(p1)) { // p2 is higher
            return new Point(p2);
        }
        else { // both have the same height
            return leftBetweenTwo(p1,p2);
        } // end of if statment
    } // end of method highBetweenTwo(Point p1, Point p2)
    
    /**
     * This method returns the highest vertex of the triangle.
     * @retun the highest vertex
     */
    public Point highestPoint()
    {
        return highBetweenTwo(highBetweenTwo(_point1, _point2), _point3);
    } // end of method highestPoint()
    
    /**
     * This method returns true if the triangle is entirely in one quadrant.
     * @return true if the triangle is entirely in one quadrant
     */
    public boolean isLocated()
    {
        return this._point1.quadrant() == this._point2.quadrant() &&
               this._point2.quadrant() == this._point3.quadrant()
               && this._point1.quadrant() != ON_AXIS;
    } // end of method isLocated()
    
    /**
     * Check if this triangle is completely above a received triangle.
     * @param other the triangle to check if this triangle is above
     * @return true if this triangle is above the other triangle
     */
    public boolean isAbove(Triangle other)
    {
        return this.lowestPoint().isAbove(other.highestPoint());
    } // end of method isAbove()
    
    /**
     * Check if this triangle is completely below a received triangle.
     * @param other the triangle to check if this triangle is below
     * @return true if this triangle is below the other triangle
     */
    public boolean isUnder(Triangle other)
    {
        return other.isAbove(this);
    } // end of method isUnder()
    
    /**
     * Check if the given triangle is equal to this triangle.
     * @param other the triangle we are checking equality with
     * @return true if the triangle other is equal to this triangle
     */
    public boolean equals(Triangle other)
    {
        return this._point1.equals(other._point1) && this._point2.equals(other._point2) 
               && this._point3.equals(other._point3);
    } // end of method equals(Triangle other)
    
    /**
     * Check if the given triangle is congruent to this triangle.
     * @param other the triangle we are checking congruency with
     * @return true if the triangle other is congruent to this triangle
     */
    public boolean isCongruent(Triangle other)
    {
        if(epsilonTest(this.getEdge1(), other.getEdge1()) ||
            epsilonTest(this.getEdge1(), other.getEdge2()) ||
            epsilonTest(this.getEdge1(), other.getEdge3())) {
            if(epsilonTest(this.getEdge2(), other.getEdge1()) ||
                epsilonTest(this.getEdge2(), other.getEdge2()) ||
                epsilonTest(this.getEdge2(), other.getEdge3())) {
                if(epsilonTest(this.getEdge3(), other.getEdge1()) ||
                   epsilonTest(this.getEdge3(), other.getEdge2()) ||
                   epsilonTest(this.getEdge3(), other.getEdge3())) {
                    return true;
                } // end of if statment for getEdge3()
            } // end of if statment for getEdge2()
        } // end of if statment for getEdge1()
        return false;
    } // end of method isCongruent(Triangle other)
    
} // end of class Triangle 

