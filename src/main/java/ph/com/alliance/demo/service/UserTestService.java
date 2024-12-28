package ph.com.alliance.demo.service;

import java.io.BufferedReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;

import ph.com.alliance.demo.entity.UserTest;
import ph.com.alliance.demo.repository.IUserTestRepository;

@Service
public class UserTestService implements IUserTestService{
	
	private IUserTestRepository repository;
	private Gson gson;
	
	@Autowired
	public UserTestService(final IUserTestRepository repository)
	{
		this.repository = repository;
		this.gson = new Gson();
	}
	
	public String findById(final int id)
	{
		return gson.toJson(repository.findById(id));
	}
	
	public String findAll()
	{
		return gson.toJson(repository.findAll());
	}
	
	public int save(final BufferedReader body)
	{
		//from just a simple requestBody, we transform it to a class using fromJson
		final UserTest user = gson.fromJson(body, UserTest.class);
		
		return repository.save(user);
	}
	
	public int update(final UserTest user)
	{
		return repository.updateByID(user);
	}
	
	public int deleteById(final int id)
	{
		return repository.deleteByID(id);
	}
}
