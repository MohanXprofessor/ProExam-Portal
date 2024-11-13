package com.exam.service.implementation;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Repository.RoleRepository;
import com.exam.Repository.UserRepository;
import com.exam.entity.User;
import com.exam.entity.UserRole;
import com.exam.service.UserService;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	private UserRepository userrepo;
	
	private RoleRepository rolerepo;
	
	
	
	// create User
	
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		User local=this.userrepo.findByusername(user.getUsername());
		if(local!=null)
		{
			System.out.println("User is Already Present..!!");
			throw new Exception("User is already present..!!"); 
		}else
		{
			// user roles   fetch all roles and save it 
			for(UserRole ur:userRoles)  //For Each Loop to get one by one roles 
			{
				rolerepo.save(ur.getRole());
			}
			
			
			// assign to user then save it 
			user.getUserroles().addAll(userRoles);
			local=this.userrepo.save(user);
			
		}
		
		return local;
		
	}
	
	
	
	
	
	

}
