package nl.teqplay.ass.shiplocator.model;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
public enum ShipStatus {
    ENTER,
    LEFT,
    NO_CHANGE;
    public ShipStatus getShipStatus(ShipLocation prev, ShipLocation current){
        if(prev.equals(ShipLocation.IN) && current.equals(ShipLocation.OUT))
            return LEFT;
        if(prev.equals(ShipLocation.OUT) && current.equals(ShipLocation.IN))
            return ENTER;
        return NO_CHANGE;
    }
}
