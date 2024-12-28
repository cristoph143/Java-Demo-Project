package ph.com.alliance.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ph.com.alliance.demo.entity.UserTest;
import ph.com.alliance.demo.service.IUserTestService;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

@RestController
public class UserTestController {
	
	private IUserTestService service;
	
	@Autowired
	public UserTestController(final IUserTestService service)
	{
		this.service = service;
	}
	
	@RequestMapping("/user/{id}")
	public String getById(@PathVariable final int id)
	{
		return service.findById(id);
	}
	
	@RequestMapping("/user")
	public String getAll()
	{
		return service.findAll();
	}
	
	/**
	 * Method for saving
	 * 
	 * @param request - used to create a requestBody in save
	 * @return a String of the response
	 * @throws IOException if an input or output exception occurred NOTE: You can avoid this using the Optional class HINT: Using Optional.empty()
	 */
	@PostMapping("/user")
	public int save(final HttpServletRequest request) throws IOException
	{
		// the reader is where the body is found we then pass this to the service so it'll be processed there
		final BufferedReader body = request.getReader();
		
		//No exception handling is provided in this demo. Please DIY :)
		return service.save(body);
	}
	
	// For update, you can 
	@PostMapping("/user/{id}")
	public int save(@PathVariable final int id, @RequestParam("password") final String password, @RequestParam("username") final String userName) throws IOException
	{
		//For update, you can just use the same approach above, however. For demo purposes. I'll perform the @RequestParam.
		
		//No exception handling is provided in this demo. Please DIY :)
		return service.update(new UserTest(id, userName, password));
	}
	
	// For delete you can use deleteMapping annotation
	@DeleteMapping("/user/delete/{id}")
	public int delete(@PathVariable final int id) throws IOException
	{		
		//No exception handling is provided in this demo. Please DIY :)
		return service.deleteById(id);
	}
}
