package nl.teqplay.ass.shiplocator.controller;

import nl.teqplay.ass.shiplocator.model.PortEvent;
import nl.teqplay.ass.shiplocator.model.Ship;
import nl.teqplay.ass.shiplocator.service.PortService;
import nl.teqplay.ass.shiplocator.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@RestController
@RequestMapping("/teqplay/port/")
public class ShipLocationController {

    @Autowired
    private PortService portService;
    @Autowired
    private ShipService shipService;



    @GetMapping("/getAllEvents")
    public List<PortEvent> getAllEvent(@RequestParam int pageNum) {
        return portService.getAllPortEvents(pageNum);
    }

    @GetMapping("/getPresentShipsInfo")
    public List<Ship> getPresentShipsInfo() {
        return shipService.getShipsInsidePort();
    }
}
