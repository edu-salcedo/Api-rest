package com.myresto.rest.Service;

import java.util.List;
import java.util.Optional;

import com.myresto.rest.entity.User;

public interface UserServiceInterface {
	
	 public List<User> getAll() throws Exception;
	   public User save( User user) throws Exception;
	   public User getById(Integer id)throws Exception;
	   public Optional<User> get(Integer id)throws Exception;
	   public User update(User user)throws Exception;
	   public boolean delete(Integer id)throws Exception;

}
