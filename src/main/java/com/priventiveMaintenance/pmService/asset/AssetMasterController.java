package com.priventiveMaintenance.pmService.asset;

import com.priventiveMaintenance.pmService.BaseController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class AssetMasterController extends BaseController {
    @Autowired
    AssetMasterService assetMasterService;

    @PostMapping("asset-master")
    public void createAssetMaster(AssetMaster assetMaster){
        assetMasterService.saveAssetMaster(assetMaster);
    }

    @GetMapping("asset-master/{id}")
    public ResponseEntity<AssetMaster> getById(@PathVariable long id){
        AssetMaster assetMaster = assetMasterService.getById(id);
        return new ResponseEntity<>(assetMaster, HttpStatus.OK);
    }

    @GetMapping("asset-masters")
    public ResponseEntity<List<AssetMaster>> getAll(){
        List<AssetMaster> assetMasterList = assetMasterService.getAll();
        return new ResponseEntity<>(assetMasterList,HttpStatus.OK);
    }

    @DeleteMapping("asset-master/{id}")
    public void delete(@PathVariable long id){
        assetMasterService.delete(id);
    }



}
