package com.bharath.springcloud.security;

import com.bharath.springcloud.security.entities.Role;
import com.bharath.springcloud.security.entities.User;
import com.bharath.springcloud.security.repos.RoleRepo;
import com.bharath.springcloud.security.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class AuthserverlatestApplication implements CommandLineRunner {

	private final UserRepo userRepository;
	private final RoleRepo roleRepository;
	private final PasswordEncoder passwordEncoder;

	@Autowired
	public AuthserverlatestApplication(UserRepo userRepository, RoleRepo roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public static void main(String[] args) {
		SpringApplication.run(AuthserverlatestApplication.class, args);
	}

	@Override
	public void run(String... args) {

		Role adminRole = new Role();
		adminRole.setName("ROLE_ADMIN");
		roleRepository.save(adminRole);

		Role userRole = new Role();
		userRole.setName("ROLE_USER");
		roleRepository.save(userRole);

		User adminUser = new User();
		adminUser.setFirstName("Admin User");
		adminUser.setEmail("admin@example.com");
		adminUser.setPassword(passwordEncoder.encode("admin123"));

		Set<Role> adminRoles = new HashSet<>();
		adminRoles.add(adminRole);
		adminUser.setRoles(adminRoles);

		userRepository.save(adminUser);

		User normalUser = new User();
		normalUser.setFirstName("Normal User");
		normalUser.setEmail("user@example.com");
		normalUser.setPassword(passwordEncoder.encode("user123"));

		Set<Role> userRoles = new HashSet<>();
		userRoles.add(userRole);
		normalUser.setRoles(userRoles);

		userRepository.save(normalUser);

		System.out.println("Users and roles inserted successfully!");
	}
}