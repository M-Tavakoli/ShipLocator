package nl.teqplay.ass.shiplocator.utils;

import nl.teqplay.ass.shiplocator.model.ShipLocation;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
public class LocationUtils {

    private LocationUtils() {
    }


    public static ShipLocation evaluateLocation(Point2D point, Path2D polygon){
        if(polygon.contains(point)){
            return ShipLocation.IN;
        } else {
            return ShipLocation.OUT;
        }
    }

}
