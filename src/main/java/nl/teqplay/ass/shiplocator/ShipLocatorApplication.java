package nl.teqplay.ass.shiplocator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@ConfigurationPropertiesScan
public class ShipLocatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShipLocatorApplication.class, args);
    }

}
