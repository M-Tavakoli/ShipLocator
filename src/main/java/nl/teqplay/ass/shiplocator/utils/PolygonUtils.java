package nl.teqplay.ass.shiplocator.utils;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.util.List;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
public class PolygonUtils {

    private PolygonUtils() {
    }

    public static Path2D createPolygon(List<Point2D.Double> points){
        Path2D polygon=new Path2D.Double();
        polygon.moveTo(points.get(0).getX(), points.get(0).getY()); // first
        // point
        for (int i = 1; i < points.size(); i++) {
            polygon.lineTo(points.get(i).getX(), points.get(i).getY()); // draw
            // lines
        }
        polygon.closePath();
        return polygon;
    }
}
