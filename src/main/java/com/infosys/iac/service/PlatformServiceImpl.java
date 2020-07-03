package com.infosys.iac.service;

import com.infosys.iac.domain.Platform;
import com.infosys.iac.dto.PlatformDTO;
import com.infosys.iac.repository.PlatformRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlatformServiceImpl implements PlatformService {
    @Autowired
    PlatformRepository platformRepository;
    @Override
    public void insertPlatform(PlatformDTO platformDTO) {
        platformRepository.saveAndFlush(PlatformDTO.preparePlatformDTO(platformDTO));
    }

    @Override
    public List<Platform> findAll() {
        return platformRepository.findAll();
    }
}
