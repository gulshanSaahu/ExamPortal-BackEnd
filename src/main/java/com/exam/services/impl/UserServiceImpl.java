package com.exam.services.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.entities.User;
import com.exam.entities.UserRole;
import com.exam.repository.RoleRepository;
import com.exam.repository.UserRepository;
import com.exam.services.UserService;
@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private RoleRepository roleRepo;
     //creating User
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception{
		User local= this.userRepo.findByUsername(user.getUsername());
		
		if(local!=null)
		{
			System.out.println("User is already there !!");
			throw new Exception("User Already Present");
		}else {
			for(UserRole ur:userRoles)
			{
				roleRepo.save(ur.getRole());
			}
			
			user.getUserRole().addAll(userRoles);
			local = this.userRepo.save(user);
		}
		return local;
	}
	
	//getting user by usertname
	@Override
	public User getUser(String username) {
		
		return this.userRepo.findByUsername(username);
	}

	@Override
	public List<User> getAllUser() {
		
		return this.userRepo.findAll();
	}

	@Override
	public void deleteUser(Long userId) {
		
	   this.userRepo.deleteById(userId);
	}

	@Override
	public User updateUser(User user, Long id) {
		User user2 = this.userRepo.findById(id).get();
		if(user2.getId()==id)
		{
			user2.setUsername(user.getUsername());
			user2.setFirstName(user.getFirstName());
			user2.setLastName(user.getLastName());
			user2.setEmail(user.getEmail());
			user2.setPhone(user.getPhone());
			user2.setPassword(user.getPassword());
			user2.setProfile(user.getProfile());
			
		}
		User save = this.userRepo.save(user2);
		return save;
	}
	
	

}
