package com.exam.services;

import java.util.List;
import java.util.Set;

import com.exam.entities.User;
import com.exam.entities.UserRole;

public interface UserService 
{
    //creating user
	
  public User createUser(User user,Set<UserRole> userRoles) throws Exception;
  
  // get user by username
  
  public User getUser(String username);
  
  // get allUser
  
  public List<User> getAllUser();
  
  //getDeleteUser
  
  public void deleteUser(Long userId);
  
  public User updateUser(User user, Long id);
}
