package com.roofiahmad.store;

import com.roofiahmad.store.entities.User;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreApplication {

	public static void main(String[] args) {
//		ApplicationContext context = SpringApplication.run(StoreApplication.class, args);
		var user = User.builder().name("roofiahmad").password("password").email("email").build();
//		var address = Address.builder().street("street").city("city").state("state").zip("zip").build();
//		user.addAddress(address);

//		user.addTag("tag1");
//		var profile = Profile.builder().bio("bio").build();
//		user.setProfile(profile);
//		profile.setUser(user);
//		System.out.printf("User: %s\n", user);

	}
}
