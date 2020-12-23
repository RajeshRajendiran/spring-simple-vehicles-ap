package com.company.vehicles.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping(value = "/status")
public class StatusController {
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> listAllVehicles() {
        return new ResponseEntity<>("SUCCESS", HttpStatus.OK);
    }
}
