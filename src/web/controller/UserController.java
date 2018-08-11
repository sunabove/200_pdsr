package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.model.User;
import web.model.UserRepository;

@RequestMapping("/user")
@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@RequestMapping( value = { "index.html" , "main.html" , "regi.html" } )
	public String userRegi(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) { 
		
		model.addAttribute( "name", name );
		
		return "311_user_regi.html";
	}
	
	@RequestMapping( value = { "manage_role.html" } )
	public String manageRole(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) { 
		
		model.addAttribute( "name", name );
		
		return "410_manage_user_role.html";
	}
	
	@RequestMapping( value = { "login.html" } )
	public String userLogin(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) { 
		
		model.addAttribute( "name", name );
		
		return "312_user_login.html";
	}
	
	@RequestMapping( value = { "find_id.html" } )
	public String findId(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) { 
		
		model.addAttribute( "name", name );
		
		return "313_user_find_id.html";
	}
	
	@RequestMapping( value = { "info.html" } )
	public String userInfo(@RequestParam(name = "name", required = false, defaultValue = "World") String name,
			Model model) { 
		
		model.addAttribute( "name", name );
		
		return "314_user_info.html";
	}

}