package nl.teqplay.ass.shiplocator.repository;

import nl.teqplay.ass.shiplocator.model.Ship;
import nl.teqplay.ass.shiplocator.model.ShipLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Repository
public interface ShipRepository extends JpaRepository<Ship,Long> {
    Optional<Ship> findShipByMmsi(Long mmis);

    List<Ship> findShipsByShipLocation(ShipLocation shipLocation);
}
