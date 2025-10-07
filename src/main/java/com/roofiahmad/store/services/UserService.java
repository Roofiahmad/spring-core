package com.roofiahmad.store.services;

import com.roofiahmad.store.entities.Address;
import com.roofiahmad.store.entities.User;
import com.roofiahmad.store.repositories.AddressRepository;
import com.roofiahmad.store.repositories.ProfileRepository;
import com.roofiahmad.store.repositories.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final EntityManager entityManager;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;



    @Transactional
    public void showEntityStates() {
        var user = User.builder()
                .name("John Doe")
                .email("john.doe@example.com")
                .password("password")
                .build();

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");

        userRepository.save(user);

        if (entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient / Detached");
    }

    @Transactional
    public void showRelatedEntities() {
        var profile = profileRepository.findById(2L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress() {
        var address = addressRepository.findById(1L).orElseThrow();
    }

    public void persistRelated(){
        var user = User.builder().name("John Doe").email("john.doe@example.com").password("password").build();
        var address = Address.builder().street("street").city("city").zip("zip").state("state").build();
        user.addAddress(address);
        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated() {
//        userRepository.deleteById(1L);
      var user =  userRepository.findById(5L).orElseThrow();
      var address=  user.getAddresses().getFirst();
      user.removeAddress(address);
      userRepository.save(user);

    }

    @Transactional
    public void fetchUser(){
      var user=  userRepository.findByEmail("roofiahmadsidiq@gmail.com");
        System.out.println(user);
    }

    @Transactional
    public void fetchUsers(){
        var users = userRepository.findAllWithAddresses();
        users.forEach(u->{
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }

    @Transactional
    public void setLoyaltyPoints(){
//        var user1 = User.builder().email("roofiahmad1@example.com").name("roofiahmad1").password("password").build();
//        var user1Profile = Profile.builder().user(user1).bio("bio of user1").loyaltyPoints(5).build();
//
//        var user2 = User.builder().email("roofiahmad2@example.com").name("roofiahmad2").password("password").build();
//        var user2Profile = Profile.builder().user(user2).bio("bio of user2").loyaltyPoints(10).build();
//
//        var user3 = User.builder().email("roofiahmad3@example.com").name("roofiahmad3").password("password").build();
//        var user3Profile = Profile.builder().user(user3).bio("bio of user3").loyaltyPoints(5).build();
//
//        userRepository.save(user1);
//        userRepository.save(user2);
//        userRepository.save(user3);
//
//        profileRepository.save(user1Profile);
//        profileRepository.save(user2Profile);
//        profileRepository.save(user3Profile);

        var profiles = userRepository.findByMinimumPoints(2);
        profiles.forEach(p->{
            System.out.println(p.getId());
            System.out.println(p.getEmail());
        });

    }
}
