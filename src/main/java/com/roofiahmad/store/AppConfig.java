package com.roofiahmad.store;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${payment-gateway}")
    private String payment;

    @Bean
    public PaymentService stripe(){
        return new StripePaymentService();
    }

    @Bean
    public PaymentService paypal(){
        return new PaypalPaymentService();
    }

    @Bean
//    @Lazy
//    @Scope("prototype")
    public OrderService orderService(){
        if(payment.equals("paypal")){
            return new OrderService(paypal());
        } else {
            return new OrderService(stripe());
        }
    }
}
