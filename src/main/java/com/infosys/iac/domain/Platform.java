package com.infosys.iac.domain;

import com.infosys.iac.dto.PlatformDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "Platform_Data")
public class Platform {
    @Id
    private String name;
    private String description;
    // method to convert entity to DTO .
    public static PlatformDTO preparePlatformDTO(Platform platform){
        PlatformDTO platformDTO = new PlatformDTO();
        platformDTO.setDescription(platform.getDescription());
        platformDTO.setName(platform.getName());
        return platformDTO;
    }

}
