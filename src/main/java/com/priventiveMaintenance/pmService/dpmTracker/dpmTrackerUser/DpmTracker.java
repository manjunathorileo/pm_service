package com.priventiveMaintenance.pmService.dpmTracker.dpmTrackerUser;

import com.priventiveMaintenance.pmService.asset.AssetMaster;
import com.priventiveMaintenance.pmService.checkListMaster.CheckList;
import com.priventiveMaintenance.pmService.dpmTracker.CheckListTracker;
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
public class DpmTracker {
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
    private String completedBy;
    private long totalNumberOfCheckPoints;
    private long totalNumberOfCheckPointsDone;
    private long percentageOfCompletion;
    private long documentId;

    @OneToMany
    private List<CheckListTracker> checkListTrackers;

    private String completionStatus;//comp,underexc,skipped
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
}
