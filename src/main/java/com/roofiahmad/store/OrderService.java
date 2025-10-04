package com.roofiahmad.store;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

//@Service
public class OrderService {
    private PaymentService paymentService;

    public OrderService(PaymentService  paymentService){
        this.paymentService = paymentService;
        System.out.println("Order service created");
    }

    @PostConstruct
    public void init(){
        System.out.println("can do db init here");
        System.out.println("order service post construct");
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("release resources like db connection, file handler,thread, etc");
        System.out.println("order pre destroy");
    }

    public void placeOrder(){
        paymentService.processPayment(10);
    }
    public void setPaymentService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
}
