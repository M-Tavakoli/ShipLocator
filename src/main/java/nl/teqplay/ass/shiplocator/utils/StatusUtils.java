package nl.teqplay.ass.shiplocator.utils;

import nl.teqplay.ass.shiplocator.model.ShipLocation;
import nl.teqplay.ass.shiplocator.model.ShipStatus;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
public class StatusUtils {

    private StatusUtils() {
    }

    public static ShipStatus evaluateShipStatus(ShipLocation prevLoc, ShipLocation newLoc){
        if (prevLoc.changed(newLoc)) {
            if (prevLoc.equals(ShipLocation.IN))
                return ShipStatus.LEFT;
            if (prevLoc.equals(ShipLocation.OUT))
                return ShipStatus.ENTER;
        }
        return ShipStatus.NO_CHANGE;
    }
}
