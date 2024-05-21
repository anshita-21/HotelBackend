package com.AgilePeople.project.service;

import com.AgilePeople.project.entity.Register;

import java.util.List;

public interface RegisterService {
    Register createRegister(Register register);

    Register getRegisterById(Long registerId);

    List<Register> getAllRegister();

    Register updateRegister(Register register);

    void deleteRegister(Long registerId);
}