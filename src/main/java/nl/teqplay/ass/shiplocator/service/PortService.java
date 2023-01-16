package nl.teqplay.ass.shiplocator.service;

import nl.teqplay.ass.shiplocator.model.PortEvent;

import java.util.List;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
public interface PortService {
    List<PortEvent> getAllPortEvents(int pageNum);

    PortEvent savePortEventInfo(PortEvent portEvent);
}
