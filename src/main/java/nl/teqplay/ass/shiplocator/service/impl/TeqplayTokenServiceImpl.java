package nl.teqplay.ass.shiplocator.service.impl;

import nl.teqplay.ass.shiplocator.config.TeqplayConfig;
import nl.teqplay.ass.shiplocator.model.TokenResponse;
import nl.teqplay.ass.shiplocator.service.TeqplayTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;



/**
 * @author Maryam Tavakoli on 14/01/2023
 */
@Service
public class TeqplayTokenServiceImpl implements TeqplayTokenService {

    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    TeqplayConfig teqplayConfig;


    public String getToken() {
            if(teqplayConfig.getAccessToken()!=null)
                return teqplayConfig.getAccessToken();

            HttpHeaders httpHeaders = getHeaders();
            MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
            map.add("username", teqplayConfig.getUsername());
            map.add("password", teqplayConfig.getPassword());
            HttpEntity entity = new HttpEntity<>(getBody(), httpHeaders);
            entity.getBody();

            ResponseEntity<TokenResponse> response=restTemplate.exchange(teqplayConfig.getAuthenticationUrl(),
                    HttpMethod.POST,
                    entity,
                    TokenResponse.class);

        return response.getBody().getToken();
    }
    public void refreshToken() {
        //TO-DO refresh token endpoint is not available
        teqplayConfig.setAccessToken("");
        getToken();
//        HttpHeaders headers = getHeaders();
//        headers.set("Authorization", teqplayConfig.getRefreshToken());
//        headers.set("isRefreshToken", "true");
//        HttpEntity<String> jwtEntity = new HttpEntity<String>(headers);
        // Use Token to get Response
//        ResponseEntity<ResponseToken> refreshTokenResponse = restTemplate.exchange(REFRESH_TOKEN, HttpMethod.GET, jwtEntity,
//                ResponseToken.class);
//        if (refreshTokenResponse.getStatusCode().equals(HttpStatus.OK)) {
//            token = "Bearer " +refreshTokenResponse.getBody().getToken();
//        }

    }
    private HttpHeaders getHeaders() {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
        headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
        return headers;
    }

    private String getBody(){
        return "{\n" +
                "    \"username\": \""+teqplayConfig.getUsername()+"\",\n" +
                "    \"password\": \""+teqplayConfig.getPassword()+"\"\n" +
                "}";
    }
}
