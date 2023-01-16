package nl.teqplay.ass.shiplocator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Data
@Entity
@NoArgsConstructor
public class Ship {
    @Id
    @GeneratedValue
    private Long id;

    public Ship(Long mmsi, ShipLocation shipLocation) {
        this.mmsi = mmsi;
        this.shipLocation = shipLocation;
    }

    private Long mmsi;

    private ShipLocation shipLocation;
}
