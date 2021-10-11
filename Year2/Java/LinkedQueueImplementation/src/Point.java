public class Point<E> extends PointComparator{
    protected int x, y;
    public Point(int xCoord, int yCoord){
        x = xCoord;
        y = yCoord;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }

    @Override
    public String toString(){
        return x + "," + y;
    }
}
