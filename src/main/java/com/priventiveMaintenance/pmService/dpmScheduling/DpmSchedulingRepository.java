package com.priventiveMaintenance.pmService.dpmScheduling;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;

@EnableJpaRepositories
@Transactional
public interface DpmSchedulingRepository extends JpaRepository<DpmSchedule,Long> {
}
