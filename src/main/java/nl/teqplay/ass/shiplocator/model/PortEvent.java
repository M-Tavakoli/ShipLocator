package nl.teqplay.ass.shiplocator.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Data
@Entity
@NoArgsConstructor
public class PortEvent {
    @Id
    @GeneratedValue
    private Long id;

    @OneToOne
    private Ship ship;

    private ShipStatus shipStatus;

    private Timestamp eventTime;
}
