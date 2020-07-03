package com.infosys.iac.domain;

import com.infosys.iac.dto.ApplicationDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Application_Data")
public class Application {
    @Id
    @Column(name = "app_id")
    private Integer appId;
    @Column(name = "app_name")
    private String appName;
    @Column(name = "app_owner")
    private String appOwner;
    private String users;
    private String platform;
    @Column(name = "user_id")
    private String userId;

    // method to typecast from entity to DTO.
    public static ApplicationDTO prepareApplicationDTO(Application application){
        ApplicationDTO applicationDTO = new ApplicationDTO();
        applicationDTO.setAppId(application.getAppId());
        applicationDTO.setAppName(application.getAppName());
        applicationDTO.setAppOwner(application.getAppOwner());
        applicationDTO.setPlatform(application.getPlatform());
        applicationDTO.setUsers(application.getUsers());
        applicationDTO.setUserId(application.getUserId());
        return applicationDTO;
    }
}
