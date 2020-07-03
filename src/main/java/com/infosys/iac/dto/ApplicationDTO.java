package com.infosys.iac.dto;

import com.infosys.iac.domain.Application;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationDTO {
    @NotNull(message = "App id can't be null")
    private Integer appId;
    @NotNull(message = "App name can't be null")
    private String appName;
    @NotNull(message = "App owner can't be null")
    private String appOwner;
    private String users;
    @NotNull(message = "Platform can't be null")
    private String platform;
    private String userId;


    // method to typecast from DTO To Entity.
    public static Application prepareApplicationEntity(ApplicationDTO applicationDTO){
        Application application = new Application();
        application.setAppId(applicationDTO.getAppId());
        application.setAppName(applicationDTO.getAppName());
        application.setAppOwner(applicationDTO.getAppOwner());
        application.setPlatform(applicationDTO.getPlatform());
        application.setUsers(applicationDTO.getUsers());
        application.setUserId(applicationDTO.getUserId());
        return application;
    }
}
