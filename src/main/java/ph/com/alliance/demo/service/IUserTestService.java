package ph.com.alliance.demo.service;

import java.io.BufferedReader;

import ph.com.alliance.demo.entity.UserTest;

public interface IUserTestService {
	public String findById(final int id);
	public String findAll();
	public int save(final BufferedReader body);
	public int update(final UserTest user);
	public int deleteById(final int id);
}
