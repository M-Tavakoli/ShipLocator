package nl.teqplay.ass.shiplocator.service;

/**
 * @author Maryam Tavakoli on 14/01/2023
 */
public interface TeqplayTokenService {

    String getToken();
    void refreshToken();
}
