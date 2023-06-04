package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exam.entities.Role;
import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.services.UserService;

@SpringBootApplication
public class ExamServerApplication /* implements CommandLineRunner */
{
	@Autowired
     private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public static void main(String[] args) {
		SpringApplication.run(ExamServerApplication.class, args);
	}

	/*
	 * @Override public void run(String... args) throws Exception {
	 * System.out.println("Starting code");
	 * 
	 * User user = new User();
	 * 
	 * user.setFirstName("Gulshan"); user.setLastName("sahu");
	 * user.setUsername("gulshans1998");
	 * user.setPassword(this.bCryptPasswordEncoder.encode("Java@2022"));
	 * user.setEmail("gulshansahu94020@gmail.com"); user.setProfile("default.png");
	 * user.setPhone("8435862179");
	 * 
	 * Role role = new Role();
	 * 
	 * role.setRoleId(44L); role.setRoleName("ADMIN");
	 * 
	 * Set<UserRole> userRoles = new HashSet<>(); UserRole userRole = new
	 * UserRole(); userRole.setRole(role); userRole.setUser(user);
	 * 
	 * userRoles.add(userRole);
	 * 
	 * User createUser = this.userService.createUser(user, userRoles);
	 * 
	 * System.out.println(createUser.getUsername());
	 * 
	 * 
	 * 
	 * 
	 * }
	 */
	 

}
