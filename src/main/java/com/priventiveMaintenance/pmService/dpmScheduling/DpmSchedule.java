package com.priventiveMaintenance.pmService.dpmScheduling;

import com.priventiveMaintenance.pmService.asset.AssetMaster;
import com.priventiveMaintenance.pmService.checkListMaster.CheckList;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class DpmSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    private AssetMaster assetMaster;
    private String assetCode;
    private String channelCode;
    private String pmType;
    private Date scheduledDate;
    private long pmChecklistId;
    private Date completionDate;
    private Date endDate;
    private long completeWithinDays;
    private long percentageOfCompletion;
    private long documentId;

    @OneToMany
    private List<CheckList> checkLists;

    private String completionStatus;//comp,underexc,skipped
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;


}
