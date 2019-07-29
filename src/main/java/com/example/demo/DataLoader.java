package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    MessageRepository messagesRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override

    public void run(String... strings) throws Exception{
        roleRepository.save(new Role("USER"));
        roleRepository.save(new Role("ADMIN"));

        Role adminRole = roleRepository.findByRole("ADMIN");
        Role userRole = roleRepository.findByRole("USER");

        User user = new User("jim@jim.com", "password", "Jim", "Jimmerson", true,
                "jim");
        user.setRoles(Arrays.asList(userRole));
        userRepository.save(user);

        user = new User("admin@admin.com", "password",
                "Admin",
                "User", true,
                "admin");
        user.setRoles(Arrays.asList(adminRole));
        userRepository.save(user);

        Message message = new Message();
        message.setTitle("Hello");
        message.setContent("Urgent");
        message.setPostedDate("07/10/2019");
        message.setPostedBy("Firehiwot");

        messagesRepository.save(message);

        message  = new Message();
        message.setTitle("Good Morning");
        message.setContent("Urgent");
        message.setPostedDate("10/10/2019");
        message.setPostedBy("Fre");

        messagesRepository.save(message);

        message  = new Message();
        message.setTitle("Vacation");
        message.setContent("Urgent");
        message.setPostedDate("17/10/2019");
        message.setPostedBy("Frey");

        messagesRepository.save(message);




    }
}