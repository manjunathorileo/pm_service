package com.priventiveMaintenance.pmService.dpmScheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DpmSchedulingService {
    @Autowired
    DpmSchedulingRepository  dpmSchedulingRepository;

    public void saveDpmSchedule(DpmSchedule dpmSchedule){
        dpmSchedulingRepository.save(dpmSchedule);
    }

    public List<DpmSchedule> getAll(){
        List<DpmSchedule> dpmSchedules  = dpmSchedulingRepository.findAll();
        return dpmSchedules;
    }

    public DpmSchedule getById(long id){
        DpmSchedule dpmSchedule = dpmSchedulingRepository.findOne(id);
        return dpmSchedule;
    }

    public void delete(long id){
        dpmSchedulingRepository.delete(id);
    }
}
