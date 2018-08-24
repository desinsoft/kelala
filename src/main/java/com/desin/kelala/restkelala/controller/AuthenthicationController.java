package com.desin.kelala.restkelala.controller;

import com.desin.kelala.restkelala.ServiceException;
import com.desin.kelala.restkelala.dto.DTOAPIResponse;
import com.desin.kelala.restkelala.util.FormatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/oauth/token/")
public class AuthenthicationController {

    private TokenStore tokenStore;
    private final ConsumerTokenServices consumerTokenServices;

    @Autowired
    public AuthenthicationController(TokenStore tokenStore, ConsumerTokenServices consumerTokenServices){
        this.tokenStore = tokenStore;
        this.consumerTokenServices = consumerTokenServices;
    }

    @RequestMapping(value = "revoke", method = RequestMethod.POST)
    public ResponseEntity create(@RequestParam("token") String value) {
        try {
            this.revokeToken(value);
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (ServiceException e) {
            return new ResponseEntity<>(new DTOAPIResponse<>(FormatUtil.parseException(e)), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private void revokeToken(String tokenValue)
            throws ServiceException {
        OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
        if (accessToken == null) {
            throw new ServiceException("a valid token is necessary to invalidate");
        }
        if (accessToken.getRefreshToken() != null) {
            tokenStore.removeRefreshToken(accessToken.getRefreshToken());
        }

        consumerTokenServices.revokeToken(accessToken.getValue());
        tokenStore.removeAccessToken(accessToken);
    }

}
