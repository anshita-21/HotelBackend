package com.AgilePeople.project.service;

import com.AgilePeople.project.entity.Checkout;

import java.util.List;

public interface CheckoutService {
    Checkout createCheckout(Checkout checkout);

    Checkout getCheckoutById(Long checkoutId);

    List<Checkout> getAllCheckout();

    Checkout updateCheckout(Checkout checkout);

    void deleteCheckout(Long checkoutId);
}