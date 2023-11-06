package poly.edu.siteController;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.servlet.http.HttpSession;
import poly.edu.entity.Account;
import poly.edu.entity.Customer;
import poly.edu.service.CustomerService;
import poly.edu.utils.ParamService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	ParamService paramService;
	
	@RequestMapping("/home")
	public String home() {
		return "views/user/index";
	}

	@RequestMapping("/register")
	public String registerform(Model model) {
		model.addAttribute("CUSTOMER", new Customer());
		return "views/user/register";
	}

	@PostMapping("/registersubmic")
	public String registersubmic(@Validated @ModelAttribute("CUSTOMER") Customer cs,
			BindingResult result, Model model) throws IOException {
		if (result.hasErrors()) {
			return "views/user/register";
		}
		customerService.save(cs);
		model.addAttribute("CUSTOMER", new Customer());
		return "redirect:/customer/login";
	}

	@RequestMapping("/login")
	public String loginform(Model model) {
		model.addAttribute("CUSTOMER", new Customer());
		return "views/user/login";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(@Validated @ModelAttribute("CUSTOMER")Customer cs, BindingResult result,
			@RequestParam("customername")String customername,
			@RequestParam("password")String password, Model model,
			HttpSession session) {
		if (customerService.checkLogin(customername, password)) {
			session.setAttribute("CUSTOMERNAME", customername);
			session.setAttribute("isLogin", false);
			return "redirect:/customer/home";
		}else {
			if (result.hasErrors()) {
				model.addAttribute("error", "Username or password not exist");			
			}
			return "views/user/login";
		}
		
	}
	
	@GetMapping("/logout")
	public String logout(Model model, HttpSession session) {
		session.removeAttribute("CUSTOMERNAME");
		session.setAttribute("isLogin", true);
		return "redirect:/customer/login";
	}
	
	@RequestMapping("/forgotpassword")
	public String forgotpassword(Model model) {
		return "views/user/forgot-password";
	}
	
}
