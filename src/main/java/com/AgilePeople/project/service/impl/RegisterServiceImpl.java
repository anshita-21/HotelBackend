package com.AgilePeople.project.service.impl;
//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Register;
import com.AgilePeople.project.repository.RegisterRepository;
import com.AgilePeople.project.service.RegisterService;
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
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public Register createRegister(Register register) {
        return registerRepository.save(register);
    }

    @Override
    public Register getRegisterById(Long registerId) {
        Optional<Register> optionalRegister = registerRepository.findById(registerId);
        return optionalRegister.get();
    }

    @Override
    public List<Register> getAllRegister() {
        return registerRepository.findAll();
    }

    @Override
    public Register updateRegister(@NotNull Register register) {
        Register existingRegister = registerRepository.findById(register.getId()).get();
        existingRegister.setTitle(register.getTitle());
        existingRegister.setFirstName(register.getFirstName());
        existingRegister.setMiddleName(register.getMiddleName());
        existingRegister.setLastName(register.getLastName());
        existingRegister.setEmail(register.getEmail());
        existingRegister.setPincode(register.getPincode());
        existingRegister.setCity(register.getCity());
        existingRegister.setState(register.getState());
        existingRegister.setActive(register.getActive());
        Register updatedRegister = registerRepository.save(existingRegister);
        return updatedRegister;
    }

    @Override
    public void deleteRegister(Long registerId) {
        registerRepository.deleteById(registerId);
    }

    public RegisterServiceImpl(RegisterRepository registerRepository) {
        this.registerRepository = registerRepository;
    }
}
