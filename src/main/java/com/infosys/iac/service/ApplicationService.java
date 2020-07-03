package com.infosys.iac.service;

import com.infosys.iac.domain.Application;
import com.infosys.iac.dto.ApplicationDTO;

import java.util.List;

public interface ApplicationService {
    public void insertAppOnboardingData(ApplicationDTO applicationDTO);
    // this method to be changed later to query based on userid.
    public List<Application> findAll();
}
