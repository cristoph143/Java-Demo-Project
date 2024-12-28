package ph.com.alliance.demo.repository;

import java.util.List;

import ph.com.alliance.demo.entity.UserTest;

public interface IUserTestRepository {
	public UserTest findById(final int id);
	public List<UserTest> findAll(); 
	public int save(final UserTest user);
	public int updateByID(final UserTest user);
	public int deleteByID(final int id);
}
