package com.infosys.iac.service;

import com.infosys.iac.domain.Platform;
import com.infosys.iac.dto.PlatformDTO;

import java.util.List;

public interface PlatformService {
    public void insertPlatform(PlatformDTO platformDTO);
    public List<Platform> findAll();
}
