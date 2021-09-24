package com.priventiveMaintenance.pmService.asset;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;

@EnableJpaRepositories
@Transactional
public interface AssetMasterRepository extends JpaRepository<AssetMaster,Long> {
    AssetMaster findByCode(String code);
}
