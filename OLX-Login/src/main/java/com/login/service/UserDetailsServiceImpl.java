package com.login.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.login.entity.UserEntity;
import com.login.repository.UserRepository;

@Service
public class UserDetailsServiceImpl  implements UserDetailsService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<UserEntity> list = repository.findByUserName(username);
		
//        if(list==null || list.size()==0)
//              throw new UsernameNotFoundException(username);
////        
//If exception is not thrown, then username is present,now take the username
//        UserEntity entity=list.get(0);
//        Collection<GrantedAuthority>authorities=new ArrayList<>();
//        
//        String roles=entity.getRoles();
//         String[] roleArray = roles.split(",");
//         for(String role:roleArray)
//         {
//               GrantedAuthority authority=new SimpleGrantedAuthority(role.trim());
////             System.out.println(authority);
//               authorities.add(authority);
//         }
//        
//        UserDetails details= new User(entity.getUserName(),
//                    passwordEncoder.encode(entity.getPassword()),authorities);
//        
//        return details;
		
		return null;
	}

}
