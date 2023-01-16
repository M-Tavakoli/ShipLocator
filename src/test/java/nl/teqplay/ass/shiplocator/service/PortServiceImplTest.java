package nl.teqplay.ass.shiplocator.service;

import nl.teqplay.ass.shiplocator.model.PortEvent;
import nl.teqplay.ass.shiplocator.model.Ship;
import nl.teqplay.ass.shiplocator.model.ShipLocation;
import nl.teqplay.ass.shiplocator.model.ShipStatus;
import nl.teqplay.ass.shiplocator.repository.PortEventRepository;
import nl.teqplay.ass.shiplocator.service.impl.PortServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.mockito.Mockito.when;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@SpringBootTest
class PortServiceImplTest {

    @InjectMocks
    private PortServiceImpl portService;

    @Mock
    private PortEventRepository portRepository;

    @Test
    void savePortEventInfo_SUCCESS_CASE() {
        PortEvent portEvent=populatePortEventEntity();
        when(portRepository.save(portEvent)).thenReturn(portEvent);
        System.out.println(portService.savePortEventInfo(portEvent));
        Assertions.assertThat(portService.savePortEventInfo(portEvent).getId()).isNotZero();
    }

    @Test
    void getAllPortEvents_SUCCESS_CASE() {
        when(portRepository.findAll()).thenReturn(populatePortEventList());
        Assertions.assertThat(portService.getAllPortEvents()).isNotEmpty();
    }
    private PortEvent populatePortEventEntity() {
        PortEvent portEvent=new PortEvent();
        portEvent.setId(12345L);
        portEvent.setShip(populateShipEntity());
        portEvent.setShipStatus(ShipStatus.values()[new Random().nextInt(ShipStatus.values().length)]);
        portEvent.setEventTime(Timestamp.valueOf(LocalDateTime.now()));

        return portEvent;
    }
    private Ship populateShipEntity() {
        Ship ship=new Ship();
        ship.setMmsi(12345L);
        ship.setShipLocation(ShipLocation.IN);

        return ship;
    }
    private List<PortEvent> populatePortEventList() {
        PortEvent portEvent1=populatePortEventEntity();
        PortEvent portEvent2=populatePortEventEntity();
        PortEvent portEvent3=populatePortEventEntity();

        List<PortEvent> portEvents=new ArrayList<>();
        portEvents.add(portEvent1);
        portEvents.add(portEvent2);
        portEvents.add(portEvent3);

        return portEvents;
    }
}
