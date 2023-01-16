package nl.teqplay.ass.shiplocator.util;

import nl.teqplay.ass.shiplocator.config.PortData;
import nl.teqplay.ass.shiplocator.exception.PortCreationException;
import nl.teqplay.ass.shiplocator.model.Port;
import nl.teqplay.ass.shiplocator.model.ShipLocation;
import nl.teqplay.ass.shiplocator.utils.LocationUtils;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.awt.geom.Point2D;
import java.util.List;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@SpringBootTest
public class LocationUtilsTest {
    @Test
    public void evaluateLocationTest() throws PortCreationException {
        Point2D.Double point=new Point2D.Double(4.631448333333334, 51.78986333333333);
        Assertions.assertThat(LocationUtils.evaluateLocation(point, populatePort().getPolygon())).isEqualTo(ShipLocation.IN);
    }
    private Port populatePort() throws PortCreationException {
        PortData portData=new PortData();
        portData.setXPoints(List.of(4.09365,4.08719,3.98969,3.94652,3.95805,3.98431,4.46901,4.55084,4.629,4.69875,4.5382,4.09365));
        portData.setYPoints(List.of(51.98509,52.01616,52.0345,51.99088,51.9598,51.91666,51.82003,51.64443,51.664,51.83797,51.91703,51.98509));
        portData.afterInitialize();
        Port port=new Port(portData);
        port.afterInitialize();
        return port;
    }
}
