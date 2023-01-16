package nl.teqplay.ass.shiplocator.service;

import nl.teqplay.ass.shiplocator.model.Ship;

import java.util.List;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
public interface ShipService {
    List<Ship> getShipsPositions();
    void updateShipsInfo();

    List<Ship> getShipsInsidePort();

}
