package ph.com.alliance.demo.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ph.com.alliance.demo.entity.UserTest;

@Repository
public class UserTestRepository implements IUserTestRepository {
	
	@Autowired
	private JdbcTemplate template;
	
	public UserTest findById(final int id)
	{
		final String sql = "SELECT * FROM usertest WHERE userID=?";
		final UserTest result = template.queryForObject(sql, BeanPropertyRowMapper.newInstance(UserTest.class), id);
		
		return result;
	}
	
	public List<UserTest> findAll()
	{
		final String sql = "SELECT * FROM usertest";
		final List<UserTest> result = template.query(sql, BeanPropertyRowMapper.newInstance(UserTest.class));
		
		return result;
	}
	
	/**
	 * The INT is the numbers of rows returned. You can use this to customize your response e.g an update did not occur, so you can use conditional statements to handle that.
	 */
	public int save(final UserTest user)
	{
		//The code below is for normal insert
		
		final String sql = "INSERT INTO usertest (userID, username, password) VALUES (?, ?, ?)";
		final int result = template.update(sql, user.getUserID(), user.getUsername(), user.getPassword());
		
		return result;
	}
	
	/**
	 * The INT is the numbers of rows returned. You can use this to customize your response e.g an update did not occur, so you can use conditional statements to handle that.
	 */
	// Name for this can be saveByID, updateByID, insertByID
	public int updateByID(final UserTest user)
	{
		
		//IMPORTANT NOTE: The normal procedure for insert is delete-> insert. However, for demo, I decided to use something called UPSERT. There are a lot of ways to perform upsert. please refer to the link below.
		// javatpoint.com/mysql-upsert
		final String sql = "UPDATE usertest SET username=?, password=? WHERE userid=?";
		final int result = template.update(sql, user.getUsername(), user.getPassword(), user.getUserID());
		
		return result;
	}
	
	/**
	 * The INT is the numbers of rows returned. You can use this to customize your response e.g an update did not occur, so you can use conditional statements to handle that.
	 */
	public int deleteByID(final int id)
	{
		final String sql = "DELETE FROM usertest WHERE userid=?";
		final int result = template.update(sql, id);
		
		return result;
	}
}
