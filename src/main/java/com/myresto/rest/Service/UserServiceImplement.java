package com.myresto.rest.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myresto.rest.entity.User;
import com.myresto.rest.repository.UserRepository;

@Service
public class UserServiceImplement implements UserServiceInterface {

	@Autowired
	UserRepository userRepository;
	@Override
	public List<User> getAll() throws Exception {
		try {
			   List<User>list = userRepository.findAll();
			   return list;	
			} catch (Exception e) {
	            throw new Exception(e.getMessage());
			}
	}

	@Override
	public User save(User user) throws Exception {
		try {		    
			return userRepository.save(user);	
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public User getById(Integer id) throws Exception {
		try {
			Optional<User> UserOptional=userRepository.findById(id);
			return UserOptional.get();
			
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Optional<User> get(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public User update(User user) throws Exception {
		try {
			Optional<User> UserOptional=userRepository.findById(user.getId());
            User  user2= UserOptional.get();
            userRepository.save(user);
			return user2;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public boolean delete(Integer id) throws Exception {
		try {
			if(userRepository.existsById(id))
			{
				userRepository.deleteById(id);
				return true;
			}
			else {
				throw new Exception();
			}
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

}
