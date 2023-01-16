package nl.teqplay.ass.shiplocator.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Getter
@Setter
public class ShipPositionResponse implements Serializable {
    private Long _id;
    private Long mmsi;
    private Loc location;

    @Getter
    @Setter
    public class Loc implements Serializable{
        private String type;
        private double[] coordinates;
    }
}
