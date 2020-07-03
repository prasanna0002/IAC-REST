package com.infosys.iac.dto;


import com.infosys.iac.domain.Platform;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatformDTO {

    @NotNull(message = "Name can't be null")
    private String name;
    private String description;

    // method to convert DTO to entity .
    public static Platform preparePlatformDTO(PlatformDTO platformDTO){
        Platform platform = new Platform();
        platform.setDescription(platformDTO.getDescription());
        platform.setName(platformDTO.getName());
        return platform;
    }
}
