package com.roleauth.roleAuth.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.roleauth.roleAuth.dao.RoleDao;
import com.roleauth.roleAuth.dao.UserDao;
import com.roleauth.roleAuth.entity.Role;
import com.roleauth.roleAuth.entity.User;

@Service
public class UserService {

	 	@Autowired
	    private UserDao userDao;

	    @Autowired
	    private RoleDao roleDao;


	    @Autowired
	    private PasswordEncoder passwordEncoder;

	    public void initRoleAndUser() {
	    
	    	Role adminRole = new Role();
	    	adminRole.setRoleName("Admin");
	        adminRole.setRoleDescription("Admin role");
	        roleDao.save(adminRole);

			System.out.println("************************************* till admin_role_save");


	    	Role userRole = new Role();
	    	userRole.setRoleName("User");
	        userRole.setRoleDescription("user role");
	        roleDao.save(userRole);

			System.out.println("************************************* till user_role_save");

	        User adminUser = new User();
	        adminUser.setUserName("admin123");
	        adminUser.setUserPassword(getEncodedPassword("admin@pass"));
	        adminUser.setUserFirstName("admin");
	        adminUser.setUserLastName("admin");
	        Set<Role> adminRoles = new HashSet<>();
	        adminRoles.add(adminRole);
	        adminUser.setRole(adminRoles);
	        userDao.save(adminUser);

			System.out.println("************************************* till saving_adminrole_save");

//	        User user = new User();
//	        user.setUserName("raj123");
//	        user.setUserPassword(getEncodedPassword("raj@123"));
//	        user.setUserFirstName("raj");
//	        user.setUserLastName("sharma");
//	        Set<Role> userRoles = new HashSet<>();
//	        userRoles.add(userRole);
//	        user.setRole(userRoles);
//	        userDao.save(user);
	    
	        
	    }//initRoleAndUser
	
	    
	    public User registerNewUser(User user) {
	    	Role role = roleDao.findById("User").get();
	    	Set<Role> roleset = new HashSet<>();
	    	roleset.add(role);
	    	user.setRole(roleset);

	        user.setUserPassword(getEncodedPassword(user.getUserPassword()));
	    	
	    	return userDao.save(user);	    	
	    }

	    public String getEncodedPassword(String password) {
	        return passwordEncoder.encode(password);
	    }	    
}//class
