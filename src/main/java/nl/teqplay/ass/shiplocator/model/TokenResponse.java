package nl.teqplay.ass.shiplocator.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Data
public class TokenResponse implements Serializable {
    private String userName;
    private String refreshToken;
    private String token;
    private String expiresInSeconds;
    private String createdAt;
}
