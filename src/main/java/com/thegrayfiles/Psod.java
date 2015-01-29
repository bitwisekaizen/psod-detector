package com.thegrayfiles;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Psod {

    private String text;

    private Psod() {}

    public Psod(String text) {
        this.text = text;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public String getText() {
        return text;
    }
}
