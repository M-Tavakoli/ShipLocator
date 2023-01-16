package nl.teqplay.ass.shiplocator.model;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
public enum ShipLocation {
    IN{
        @Override
        public boolean changed(ShipLocation prev) {
            return OUT.equals(prev);
        }
    },
    OUT {
        @Override
        public boolean changed(ShipLocation prev) {
            return IN.equals(prev);
        }
    };
    public abstract boolean changed(ShipLocation prev);
}
