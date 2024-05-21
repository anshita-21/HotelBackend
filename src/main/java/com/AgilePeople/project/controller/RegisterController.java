package com.AgilePeople.project.controller;

//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Register;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // returns the data directly in a format like JSON
//@AllArgsConstructor
@CrossOrigin
@RequestMapping("api/register") //routed to the appropriate method
public class RegisterController {
    @Autowired //creats objects
    private RegisterService registerService;

    // build create Register REST API
//    public ResponseEntity<User> createUser(@RequestBody User user){
//        User savedUser = userService.createUser(user);
//        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
//    }
    @PostMapping
    public ResponseEntity<ResponsePojo> createRegister(@RequestBody Register register) {
        String errorMsg = "";
        ResponsePojo responsePojo = null;
        if(register != null)
        {
            if(register.getTitle() == null || register.getTitle().equals(""))
            {
                errorMsg = "Salutation is missing!";

                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(register.getFirstName() == null || register.getFirstName().equals("")) {
                errorMsg = "First name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }

            else if(register.getLastName() == null || register.getLastName().equals("")) {
                errorMsg = "Last name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
//            else if(register.getEmail() == null || register.getEmail().equals("")) {
//                errorMsg = "Email is missing!";
//                responsePojo = new ResponsePojo();
//                responsePojo.setError(true);
//                responsePojo.setErrorMessage(errorMsg);
//            }
            else if (!register.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
//            else if(register.getMobile() == null || register.getMobile().equals("")) {
//                errorMsg = "Contact is missing!";
//                responsePojo = new ResponsePojo();
//                responsePojo.setError(true);
//                responsePojo.setErrorMessage(errorMsg);
//            }
            else if (!register.getMobile().matches("\\d{10}")) {
                errorMsg = "Inavlid Mobile!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }

            else if(register.getPincode() == null || register.getPincode().equals("")) {
                errorMsg = "Pincode is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (!register.getPincode().matches("\\d{7}")) {
                errorMsg = "Pincode must contain only numeric characters!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(register.getState() == null || register.getState().equals("")) {
                errorMsg = "State is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(register.getCity() == null || register.getCity().equals("")) {
                errorMsg = "City is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }

            else {
               Register registerData = registerService.createRegister(register);
                responsePojo = new ResponsePojo();
                responsePojo.setSuccess(true);
               responsePojo.setData(registerData);
            }
        }
        return new ResponseEntity<>(responsePojo, HttpStatus.CREATED);
    }

    // build get register by id REST API
    // http://localhost:8080/api/register/1
    @GetMapping("{id}")
    public Register getRegisterById(@PathVariable("id") Long registerId) {
        Register register = registerService.getRegisterById(registerId);
        return register;
    }

    // Build Get All registers REST API
    // http://localhost:8080/api/register
    @RequestMapping(method = RequestMethod.GET, value = "/post")
    public ResponseEntity<List<Register>> getAllRegister() {
        List<Register> registers = registerService.getAllRegister();

        return new ResponseEntity<>(registers, HttpStatus.OK);
    }

    // Build Update register REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/register/1
    public Register updateRegister(@PathVariable("id") Long registerId,
                                   @RequestBody Register register) {
        register.setId(registerId);
        Register updatedRegister = registerService.updateRegister(register);
        return updatedRegister;
    }

    // Build Delete register REST API
    @DeleteMapping("{id}")
    public String deleteRegister(@PathVariable("id") Long registerId) {
        registerService.deleteRegister(registerId);
        return "register successfully deleted!";
    }
}