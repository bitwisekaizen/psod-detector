package com.thegrayfiles;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PsodController {

    @RequestMapping("/psod")
    private Psod psod() {
        return new Psod("something");
    }
}

