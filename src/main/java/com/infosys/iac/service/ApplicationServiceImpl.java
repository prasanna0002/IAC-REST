package com.infosys.iac.service;

import com.infosys.iac.domain.Application;
import com.infosys.iac.dto.ApplicationDTO;
import com.infosys.iac.repository.ApplicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApplicationServiceImpl implements  ApplicationService{
    @Autowired
    ApplicationRepository applicationRepository;
    @Override
    public void insertAppOnboardingData(ApplicationDTO applicationDTO) {
        applicationRepository.saveAndFlush(ApplicationDTO.prepareApplicationEntity(applicationDTO));
    }

    @Override
    public List<Application> findAll() {
        return applicationRepository.findAll();
    }
}
