package nl.teqplay.ass.shiplocator.schedule;

import nl.teqplay.ass.shiplocator.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;



/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Component
public class ShipLocationScheduler {

    @Autowired
    ShipService shipService;

//    @Scheduled(cron = "* * * * * *")
    @Scheduled(fixedRate = 60000)
    public void scheduleTaskWithFixedRate() {
        shipService.updateShipsInfo();
    }
}
