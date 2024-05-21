package com.AgilePeople.project.controller;

import com.AgilePeople.project.entity.State;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
//@AllArgsConstructor
@RequestMapping("api/state_master")
public class StateController {
    @Autowired
    private StateService stateService;

    // build create User REST API

    @GetMapping("{id}")
    public ResponseEntity<State> getStateById(@PathVariable("id") Long stateId){
        State state = stateService.getStateById(stateId);
        return new ResponseEntity<>(state, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<State>> getAllState(){
        List<State> state = stateService.getAllState();
        return new ResponseEntity<>(state, HttpStatus.OK);
    }




    public StateController(StateService stateService) {
        this.stateService = stateService;
    }
}