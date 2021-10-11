import java.util.Comparator;

public class PointComparator implements Comparator {
    int xa, ya, xb, yb;
    public int compare(Object a, Object b) throws ClassCastException {
        xa = ((Point)a).getX();
        ya = ((Point)a).getY();
        xb = ((Point)b).getX();
        yb = ((Point)b).getY();
        if(xa != xb)
            return (xa - xb);
        else
            return (ya - yb);
    }
}
