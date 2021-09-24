package com.priventiveMaintenance.pmService.asset;

import com.sun.javaws.exceptions.ExitException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.management.openmbean.KeyAlreadyExistsException;
import java.util.List;

@Service
public class AssetMasterService {

    @Autowired
    AssetMasterRepository assetMasterRepository;

    public void saveAssetMaster(AssetMaster assetMaster) {

        AssetMaster assetMasterOld = assetMasterRepository.findByCode(assetMaster.getCode());
        if (assetMasterOld != null) {
            if (assetMaster.getId() != assetMasterOld.getId()) {
                throw new KeyAlreadyExistsException("Asset code " + assetMaster.getCode() + " already exists");
            }
        }
        assetMasterRepository.save(assetMaster);
    }

    public AssetMaster getById(long id) {
        AssetMaster assetMaster = assetMasterRepository.findOne(id);
        return assetMaster;
    }

    public List<AssetMaster> getAll() {
        List<AssetMaster> assetMasters = assetMasterRepository.findAll();
        return assetMasters;
    }

    public void delete(long id) {
        assetMasterRepository.delete(id);
    }


}
