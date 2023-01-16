package nl.teqplay.ass.shiplocator.model;


import jakarta.annotation.PostConstruct;
import lombok.Data;
import nl.teqplay.ass.shiplocator.config.PortData;
import nl.teqplay.ass.shiplocator.utils.PolygonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.geom.Path2D;
import java.util.HashSet;
import java.util.List;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */

@Component
@Data
public class Port {
    private static Port instance;
    @Autowired
    private final PortData portData;
    private Path2D polygon;
    private HashSet<Ship> inside;
    private List<PortEvent> events;

    @PostConstruct
    public void afterInitialize() {
        polygon=PolygonUtils.createPolygon(portData.getPoints());
    }
}
