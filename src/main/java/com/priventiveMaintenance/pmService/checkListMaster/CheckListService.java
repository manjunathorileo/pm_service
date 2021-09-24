package com.priventiveMaintenance.pmService.checkListMaster;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckListService {
    @Autowired
    CheckListRepository checkListRepository;

    public void saveCheckList(CheckList checkList){
        checkListRepository.save(checkList);
    }

    public List<CheckList> checkLists(){
        List<CheckList> checkLists = checkListRepository.findAll();
        return checkLists;
    }

    public CheckList checkList(long id){
        CheckList checkList = checkListRepository.findOne(id);
        return checkList;
    }

    public void delete(long id){
        checkListRepository.delete(id);
    }


}
