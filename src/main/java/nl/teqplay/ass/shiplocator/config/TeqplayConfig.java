package nl.teqplay.ass.shiplocator.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Configuration
@Data
public class TeqplayConfig {
    @Value("#{'${teqplay.authentication.username}'}")
    private String username;
    @Value("#{'${teqplay.authentication.password}'}")
    private String password;
    private String registrationUrl;
    @Value("#{'${teqplay.authentication.authenticationUrl}'}")
    private String authenticationUrl;
    private String refreshTokenUrl;

    private String accessToken;
    private String refreshToken;

}
