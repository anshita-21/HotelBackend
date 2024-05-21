package com.AgilePeople.project.service;

import com.AgilePeople.project.entity.State;

import java.util.List;

public interface StateService {

    State getStateById(Long stateId);

    List<State> getAllState();

}