package com.priventiveMaintenance.pmService.checkListMaster;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.transaction.Transactional;

@EnableJpaRepositories
@Transactional
public interface CheckListRepository extends JpaRepository<CheckList,Long> {

}
