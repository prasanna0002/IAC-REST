package com.infosys.iac.controller;

import com.infosys.iac.domain.Platform;
import com.infosys.iac.dto.PlatformDTO;
import com.infosys.iac.service.PlatformService;
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
public class PlatformController {
    @Autowired
    PlatformService platformService;

    @PostMapping("/platform")
    public ResponseEntity insertPlatformData(@Valid @RequestBody PlatformDTO platformDTO, Errors errors){
        String response = "Platform details saved successfully";
        if (errors.hasErrors()){
            response = errors.getAllErrors().stream().map(ObjectError:: getDefaultMessage).collect(Collectors.joining(","));
            return new ResponseEntity(response, HttpStatus.NOT_ACCEPTABLE);
        }
        else{
            platformService.insertPlatform(platformDTO);
            return new ResponseEntity(response,HttpStatus.OK);
        }
    }

    @GetMapping("/platform")
    public List<Platform> fetchAllPlatforms(){
        return platformService.findAll();
    }
}
