package com.infosys.iac.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller is for checking the health of the microservice.
 * returns 200 if the application is running properly.
 */
@RestController
@RequestMapping("/api/v1")
public class HealthController {
    @GetMapping("/health")
    public ResponseEntity getHealth(){
        return new ResponseEntity("The App is running successfully", HttpStatus.OK);

    }}
