package nl.teqplay.ass.shiplocator.config;

import jakarta.annotation.PostConstruct;
import lombok.Data;
import nl.teqplay.ass.shiplocator.exception.PortCreationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Configuration
@Data
public class PortData {

    @Value("Rotterdam port")
    private String portName;
    @Value("#{'${portArea.xPoints}'.split(',')}")
    private List<java.lang.Double> xPoints;

    @Value("#{'${portArea.yPoints}'.split(',')}")
    private List<java.lang.Double> yPoints;

    private List<Point2D.Double> points=new ArrayList<>();

    public List<Point2D.Double> getPoints(){
        return points;
    }

    @PostConstruct
    public void afterInitialize() throws PortCreationException {
        if (xPoints.size()!=yPoints.size()){
            throw new PortCreationException("Port with given point cannot be created");
        }
        for (int i = 0; i < xPoints.size(); i++) {
            points.add(new Point2D.Double(xPoints.get(i),yPoints.get(i)));
        }
    }
}
