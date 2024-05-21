package com.AgilePeople.project.service.impl;
//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.State;
import com.AgilePeople.project.repository.StateRepository;
import com.AgilePeople.project.service.StateService;
import org.apache.logging.log4j.util.Strings;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class StateServiceImpl implements StateService {
    @Autowired
    private StateRepository stateRepository;


    @Override
    public State getStateById(Long stateId) {
        Optional<State> optionalState = stateRepository.findById(stateId);
        return optionalState.get();
    }

    @Override
    public List<State> getAllState() {
        return stateRepository.findAll();
    }

    public StateServiceImpl(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }
}
