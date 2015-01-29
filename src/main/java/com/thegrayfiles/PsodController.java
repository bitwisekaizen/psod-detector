package com.thegrayfiles;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PsodController {

    @RequestMapping("/psod")
    private Psod psod(@RequestParam String vm) {
        return new Psod(vm);
    }
}

