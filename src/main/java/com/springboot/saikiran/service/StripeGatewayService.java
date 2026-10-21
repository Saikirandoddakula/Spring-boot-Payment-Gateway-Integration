package com.springboot.saikiran.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;

@Service
public class StripeGatewayService {

    @Value("${stripe.secret.key}")
    private String secretKey;

    @Value("${stripe.public.key}")
    private String publishableKey;

    public String createCheckoutSession(
            String email, String course, int amount, String currency) {

        try {
            // 1. Configure Stripe authentication
            Stripe.apiKey = secretKey;

            // 2. Prepare the Checkout Session configuration
            SessionCreateParams params =
                    SessionCreateParams.builder()
                            .setMode(SessionCreateParams.Mode.PAYMENT)
                            .setCustomerEmail(email)
                            .setSuccessUrl(
                                    "http://localhost:3000/success?session_id={CHECKOUT_SESSION_ID}")
                            .setCancelUrl(
                                    "http://localhost:3000/cancel")
                            .addLineItem(
                                    SessionCreateParams.LineItem.builder()
                                            .setQuantity(1L)
                                            .setPriceData(
                                                    SessionCreateParams.LineItem.PriceData.builder()
                                                            .setCurrency(currency.toLowerCase())
                                                            .setUnitAmount((long) amount * 100)
                                                            .setProductData(
                                                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                                            .setName(course)
                                                                            .build())
                                                            .build())
                                            .build())
                            .build();

            // 3. Ask Stripe to create the session
            Session session = Session.create(params);

            // 4. Return the Checkout URL
            return session.getUrl();

        } catch (StripeException e) {
            throw new RuntimeException(
                    "Failed to create Stripe Checkout Session", e);
        }
    }
}