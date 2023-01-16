package nl.teqplay.ass.shiplocator;

import nl.teqplay.ass.shiplocator.model.Ship;
import nl.teqplay.ass.shiplocator.service.ShipService;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@SpringBootTest
public class ShipServiceTest {
    @Autowired
    ShipService shipService;

    @Test
    public void getShipPosionsTest() {
        List<Ship> result= shipService.getShipsPositions();

        Assertions.assertThat(result).isNotEmpty();
    }
}
