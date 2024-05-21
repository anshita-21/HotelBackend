package com.AgilePeople.project.service;

import com.AgilePeople.project.entity.District;

import java.util.List;

public interface DistrictService {

    District getDistrictById(Long districtId);

    List<District> getAllDistrict();

}