package com.roofiahmad.store;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
        var orderService =  context.getBean(OrderService.class);
        orderService.placeOrder();
//        context.close();

//        var notificationManagerService = context.getBean(NotificationManagerService.class);
//        notificationManagerService.sendNotification("hello");
	}

}
