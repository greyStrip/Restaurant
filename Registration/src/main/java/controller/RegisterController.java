package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.User;
import service.LoginService;

@Controller
public class RegisterController {

	private LoginService<User> loginService;
	
	@Autowired
	public RegisterController(LoginService<User> loginService) {
		super();
		this.loginService = loginService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homePage() {
		return "home";
	}

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String displayRegisterPage(Model model) {
		model.addAttribute("userObj", new User());
		return "register";
	}

	@RequestMapping(value = "/process", method = RequestMethod.POST)
	public String processRegister(Model model, @ModelAttribute("userObj") @Valid User user, BindingResult br) {
		if(br.hasErrors()) {
			return "register";
		}
		loginService.save(user);
		loginService.getAllData().forEach(x-> System.out.println(x));
		System.out.println(user.getFirstName());
		model.addAttribute("firstName", user.getFirstName());
		return "success";
	}

}
