package com.quickjwt.configuration.jwt;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Lenny on 8/6/2018.
 */
public class JWTToken {
    private String idToken;

    public JWTToken(String idToken) {
        this.idToken = idToken;
    }

    @JsonProperty("id_token")
    public String getIdToken() {
        return idToken;
    }

    public void setIdToken(String idToken) {
        this.idToken = idToken;
    }
}
