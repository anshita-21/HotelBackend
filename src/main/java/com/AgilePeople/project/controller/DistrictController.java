package com.AgilePeople.project.controller;

import com.AgilePeople.project.entity.District;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
//@AllArgsConstructor
@RequestMapping("api/district_master")
public class DistrictController {
    @Autowired
    private DistrictService districtService;

    // build create User REST API

    @GetMapping("{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable("id") Long districtId){
        District district = districtService.getDistrictById(districtId);
        return new ResponseEntity<>(district, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<District>> getAllDistrict(){
        List<District> district = districtService.getAllDistrict();
        return new ResponseEntity<>(district, HttpStatus.OK);
    }




    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }
}