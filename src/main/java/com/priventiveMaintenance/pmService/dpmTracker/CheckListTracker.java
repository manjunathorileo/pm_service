package com.priventiveMaintenance.pmService.dpmTracker;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Getter
@Setter
public class CheckListTracker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String checkPoint;
    private String description;
    private String standardCondition;
    private String standardValue;
    private String actionPlan;
    private Boolean checkStatus;
    private String checkedBy;
    private String remarks;
    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updatedOn;
}
