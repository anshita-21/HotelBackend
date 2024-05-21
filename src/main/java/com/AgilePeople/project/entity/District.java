package com.AgilePeople.project.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "district_master")
public class District {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "district_id", nullable = true)
    private String districtId;
    @Column(name = "district_name", nullable = true)
    private String districtName;
    @Column(name = "active", nullable =true)
    private String active;

    @Column(name = "state_id", nullable = true)
    private String stateId;

    public District() {
    }

    public District(Long id, String districtId, String districtName, String active, String stateId) {
        this.id = id;
        this.districtId = districtId;
        this.districtName = districtName;
        this.active = active;
        this.stateId = stateId;
    }

    public Long getId() {
        return id;
    }

    public String getDistrictId() {
        return districtId;
    }

    public String getDistrictName() {
        return districtName;
    }

    public String getActive() {
        return active;
    }

    public String getStateId() {
        return stateId;
    }
}