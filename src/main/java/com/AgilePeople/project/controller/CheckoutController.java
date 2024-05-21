package com.AgilePeople.project.controller;

//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Checkout;
import com.AgilePeople.project.entity.Register;
import com.AgilePeople.project.pojo.ResponsePojo;
import com.AgilePeople.project.service.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // returns the data directly in a format like JSON
//@AllArgsConstructor
@RequestMapping("api/checkout")

public class CheckoutController {
    @Autowired //creats objects
    private CheckoutService checkoutService;

    // build create Register REST API
    @PostMapping
    public ResponseEntity<ResponsePojo> createCheckout(@RequestBody Checkout checkout) {
        String errorMsg = "";
        ResponsePojo responsePojo = null;
        if(checkout != null)
        {
            if(checkout.getTitle() == null || checkout.getTitle().equals(""))
            {
                errorMsg = "Salutation is missing!";

                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(checkout.getFirstName() == null || checkout.getFirstName().equals("")) {
                errorMsg = "First name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(checkout.getLastName() == null || checkout.getLastName().equals("")) {
                errorMsg = "Middle name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(checkout.getContact() == null || checkout.getContact().equals("")) {
                errorMsg = "Contact is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (!checkout.getContact().matches("\\d{10}")) {
                errorMsg = "Invalid Contact Format";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(checkout.getEmail() == null || checkout.getEmail().equals("")) {
                errorMsg = "Email is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (!checkout.getEmail().matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
                errorMsg = "Invalid email format!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(checkout.getCountry() == null || checkout.getCountry().equals("")) {
                errorMsg = "Country name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(checkout.getState() == null || checkout.getState().equals("")) {
                errorMsg = "State name is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(checkout.getZip() == null || checkout.getZip().equals("")) {
                errorMsg = "Zip is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if (!checkout.getZip().matches("\\d{7}")) {
                errorMsg = "Invalid Zip formate";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(checkout.getAddress() == null || checkout.getAddress().equals("")) {
                errorMsg = "Address is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else if(checkout.getAddress2() == null || checkout.getAddress2().equals("")) {
                errorMsg = "Detailed Address is missing!";
                responsePojo = new ResponsePojo();
                responsePojo.setError(true);
                responsePojo.setErrorMessage(errorMsg);
            }
            else {
                Checkout checkoutData = checkoutService.createCheckout(checkout);
                responsePojo = new ResponsePojo();
                responsePojo.setSuccess(true);
                responsePojo.setData(checkoutData);
            }
        }
        return new ResponseEntity<>(responsePojo, HttpStatus.CREATED);
    }

    // build get register by id REST API
    // http://localhost:8080/api/register/1
    @GetMapping("{id}")
    public Checkout getCheckoutById(@PathVariable("id") Long checkoutId) {
        Checkout checkout = checkoutService.getCheckoutById(checkoutId);
        return checkout;
    }

    // Build Get All registers REST API
    // http://localhost:8080/api/checkout
    @GetMapping
    public List<Checkout> getAllCheckout() {
        List<Checkout> checkout = checkoutService.getAllCheckout();
        return checkout;
    }

    // Build Update register REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/checkout/1
    public Checkout updateCheckout(@PathVariable("id") Long checkoutId,
                                   @RequestBody Checkout checkout) {
        checkout.setId(checkoutId);
        Checkout updatedCheckout = checkoutService.updateCheckout(checkout);
        return updatedCheckout;
    }

    // Build Delete register REST API
    @DeleteMapping("{id}")
    public String deleteCheckout(@PathVariable("id") Long checkoutId) {
        checkoutService.deleteCheckout(checkoutId);
        return "register successfully deleted!";
    }
}
