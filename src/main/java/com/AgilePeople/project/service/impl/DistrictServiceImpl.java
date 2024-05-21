package com.AgilePeople.project.service.impl;
//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.District;
import com.AgilePeople.project.repository.DistrictRepository;
import com.AgilePeople.project.service.DistrictService;
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
public class DistrictServiceImpl implements DistrictService {
    @Autowired
    private DistrictRepository districtRepository;


    @Override
    public District getDistrictById(Long districtId) {
        Optional<District> optionalDistrict = districtRepository.findById(districtId);
        return optionalDistrict.get();
    }

    @Override
    public List<District> getAllDistrict() {
        return districtRepository.findAll();
    }

    public DistrictServiceImpl(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }
}
