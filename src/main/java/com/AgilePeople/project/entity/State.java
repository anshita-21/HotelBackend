package com.AgilePeople.project.entity;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "state_master")
public class State {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String name;
    @Column(name = "state_id", nullable = true)
    private String stateId;
    @Column(name = "state_name", nullable = true)
    private String stateName;
    @Column(name = "active", nullable =true)
    private String active;

    @Column(name = "country_id", nullable = true)
    private String countryId;

    public State() {
    }

    public State(Long id, String name, String stateId, String stateName, String active, String countryId) {
        this.id = id;
        this.name = name;
        this.stateId = stateId;
        this.stateName = stateName;
        this.active = active;
        this.countryId = countryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStateId() {
        return stateId;
    }

    public void setStateId(String stateId) {
        this.stateId = stateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }
}