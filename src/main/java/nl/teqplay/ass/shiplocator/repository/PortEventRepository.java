package nl.teqplay.ass.shiplocator.repository;

import nl.teqplay.ass.shiplocator.model.PortEvent;
import nl.teqplay.ass.shiplocator.model.ShipStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Repository
public interface PortEventRepository extends JpaRepository<PortEvent,Long> {
    List<PortEvent> findPortEventByShipStatus(ShipStatus shipStatus);
}
