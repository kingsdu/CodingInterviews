package JavaSE.BLS.InnerClass;

public class Line
{
    public class Point
    {
        public int x, y;
    }
    
    public Point getPoint()
    {
        return new Point();
    }
}

class Triangle
{
    public Triangle()
    {
        Line.Point p = (new Line()).getPoint();
    }
}


