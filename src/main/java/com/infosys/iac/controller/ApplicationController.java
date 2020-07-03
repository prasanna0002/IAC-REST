package com.infosys.iac.controller;

import com.infosys.iac.domain.Application;
import com.infosys.iac.dto.ApplicationDTO;
import com.infosys.iac.service.ApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1")
public class ApplicationController {
    @Autowired
    ApplicationService applicationService;

    @PostMapping("/application")
    public ResponseEntity onBoardApplication(@Valid @RequestBody ApplicationDTO applicationDTO , Errors errors){
        String response = "Application onboarding details saved successfully";
        if (errors.hasErrors()){
            response = errors.getAllErrors().stream().map(ObjectError:: getDefaultMessage).collect(Collectors.joining(","));
            return new ResponseEntity(response, HttpStatus.NOT_ACCEPTABLE);
        }
        else{
            applicationService.insertAppOnboardingData( applicationDTO);
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }
    @GetMapping("/application")
    public List<Application> fetchAllOnBoardedApps(){
        return applicationService.findAll();
    }
}
