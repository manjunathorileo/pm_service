package com.priventiveMaintenance.pmService.dpmScheduling;

import com.priventiveMaintenance.pmService.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class DpmSchedulingController extends BaseController {
    @Autowired
    DpmSchedulingService dpmSchedulingService;

    @PostMapping("dpm-schedule")
    public void scheduleDpm(DpmSchedule dpmSchedule){
        dpmSchedulingService.saveDpmSchedule(dpmSchedule);
    }

    @GetMapping("dpm-schedules")
    public ResponseEntity<List<DpmSchedule>> getAll(){
        List<DpmSchedule> dpmSchedules = dpmSchedulingService.getAll();
        return new ResponseEntity<>(dpmSchedules, HttpStatus.OK);
    }

    @GetMapping("dpm-schedule/{id}")
    public ResponseEntity<DpmSchedule> getById(@PathVariable long id){
        DpmSchedule dpmSchedule = dpmSchedulingService.getById(id);
        return new ResponseEntity<>(dpmSchedule,HttpStatus.OK);
    }

    @DeleteMapping("dpm-schedule/{id}")
    public void delete(@PathVariable long id){
        dpmSchedulingService.delete(id);
    }



}
