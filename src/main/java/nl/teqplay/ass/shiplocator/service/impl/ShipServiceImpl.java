package nl.teqplay.ass.shiplocator.service.impl;


import nl.teqplay.ass.shiplocator.config.TeqplayConfig;
import nl.teqplay.ass.shiplocator.model.*;
import nl.teqplay.ass.shiplocator.repository.ShipRepository;
import nl.teqplay.ass.shiplocator.service.PortService;
import nl.teqplay.ass.shiplocator.service.ShipService;
import nl.teqplay.ass.shiplocator.service.TeqplayTokenService;
import nl.teqplay.ass.shiplocator.utils.LocationUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.awt.geom.Point2D;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Stream;

import static nl.teqplay.ass.shiplocator.utils.StatusUtils.evaluateShipStatus;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Service
public class ShipServiceImpl implements ShipService {

    RestTemplate restTemplate = new RestTemplate();

    @Autowired
    ShipRepository shipRepository;

    @Autowired
    PortService portService;

    @Autowired
    Port port;

    @Autowired
    TeqplayConfig teqplayConfig;

    @Autowired
    TeqplayTokenService teqplayTokenService;
    @Override
    public List<Ship> getShipsPositions() {
        ResponseEntity<ShipPositionResponse[]> positionResponses=sendRequest();

        return Stream.of(positionResponses.getBody()).map(ship->new Ship(ship.getMmsi(),
                LocationUtils.evaluateLocation(new Point2D.Double(ship.getLocation().getCoordinates()[0],ship.getLocation().getCoordinates()[1])
                        , port.getPolygon()))).toList();
    }

    @Override
    public void updateShipsInfo() {
         List<Ship> updatedInfo=getShipsPositions();

        for (Ship updatedShipInfo : updatedInfo) {

            Ship ship = shipRepository.findShipByMmsi(updatedShipInfo.getMmsi())
                    .orElse(updatedShipInfo);

            ShipStatus status = evaluateShipStatus(ship.getShipLocation(), updatedShipInfo.getShipLocation());

            if(ship.getId()!=null)
                updatedShipInfo.setId(ship.getId());
            shipRepository.save(updatedShipInfo);

            if (!status.equals(ShipStatus.NO_CHANGE)) {
                PortEvent newPortEvent = new PortEvent();
                newPortEvent.setShip(updatedShipInfo);
                newPortEvent.setShipStatus(status);
                newPortEvent.setEventTime(Timestamp.valueOf(LocalDateTime.now()));
                portService.savePortEventInfo(newPortEvent);
            }
        }
    }

    @Override
    public List<Ship> getShipsInsidePort() {
        return shipRepository.findShipsByShipLocation(ShipLocation.IN).stream().toList();
    }

    private ResponseEntity<ShipPositionResponse[]> sendRequest(){
        ResponseEntity<ShipPositionResponse[]> response = new ResponseEntity<>(HttpStatusCode.valueOf(204));
        try {
            HttpHeaders httpHeaders = new HttpHeaders();
            httpHeaders.add("Authorization", teqplayTokenService.getToken());
            HttpEntity httpEntity = new HttpEntity(httpHeaders);

            response = restTemplate.exchange("https://backenddev.teqplay.nl/ship/",
                    HttpMethod.GET,
                    httpEntity,
                    ShipPositionResponse[].class);

        } catch (Exception ex){
            if (ex.getMessage().contains("io.jsonwebtoken.ExpiredJwtException")) {
                // Refresh Token
                teqplayTokenService.refreshToken();
                // try again with refresh token
                response = sendRequest();
            }else {
                ex.printStackTrace();
            }
        }
        return response;
    }
}
