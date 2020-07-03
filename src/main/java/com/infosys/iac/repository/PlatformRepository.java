package com.infosys.iac.repository;

import com.infosys.iac.domain.Platform;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlatformRepository extends JpaRepository<Platform,String> {
}
