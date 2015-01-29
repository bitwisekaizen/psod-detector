package com.thegrayfiles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Psod {

    private String text;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public String getText() {
        return text;
    }
}
