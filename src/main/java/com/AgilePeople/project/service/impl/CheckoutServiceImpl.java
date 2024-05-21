package com.AgilePeople.project.service.impl;
//import lombok.AllArgsConstructor;
import com.AgilePeople.project.entity.Checkout;
import com.AgilePeople.project.repository.CheckoutRepository;
import com.AgilePeople.project.service.CheckoutService;
import com.AgilePeople.project.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
//@AllArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {
    @Autowired
    private CheckoutRepository checkoutRepository;

    @Override
    public Checkout createCheckout(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }

    @Override
    public Checkout getCheckoutById(Long checkoutId) {
        Optional<Checkout> optionalCheckout = checkoutRepository.findById(checkoutId);
        return optionalCheckout.get();
    }


    @Override
    public List<Checkout> getAllCheckout() {
        return checkoutRepository.findAll();
    }

    @Override
    public Checkout updateCheckout(Checkout checkout) {
        Checkout existingCheckout = checkoutRepository.findById(checkout.getId()).get();
        existingCheckout.setTitle(checkout.getTitle());
        existingCheckout.setFirstName(checkout.getFirstName());
        existingCheckout.setAddress(checkout.getAddress());
        existingCheckout.setLastName(checkout.getLastName());
        existingCheckout.setEmail(checkout.getEmail());
        existingCheckout.setAddress2(checkout.getAddress2());
        existingCheckout.setCountry(checkout.getCountry());
        existingCheckout.setState(checkout.getState());
        existingCheckout.setZip(checkout.getZip());
        existingCheckout.setContact(checkout.getContact());
        Checkout updatedCheckout = checkoutRepository.save(existingCheckout);
        return updatedCheckout;
    }

    @Override
    public void deleteCheckout(Long checkoutId) {
        checkoutRepository.deleteById(checkoutId);
    }


}
