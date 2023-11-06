package poly.edu.adminController;

import java.io.IOException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import poly.edu.dao.AccountDao;
import poly.edu.entity.Account;
import poly.edu.service.AccountService;
import poly.edu.utils.ParamService;
import poly.edu.utils.SessionService;


@Controller
@RequestMapping("manageraccount")
public class ManagerAccountController {
	
	@Autowired
	AccountService accountService;

	@Autowired
	ParamService paramService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	AccountDao accountDao;
	
	@GetMapping("/listaccount/page")
	public String listaccount(Model model,@RequestParam("keywords") Optional<String> kw , @RequestParam("item") Optional<Integer> item, HttpSession session) {	
		if (session.getAttribute("USERNAME") == null) {
			return "redirect:/manageraccount/login";
		}else {		
			String kwords = kw.orElse(sessionService.get("keywords", ""));
			sessionService.set("keywords", kwords);
			Pageable pageable = PageRequest.of(item.orElse(0), 6);
			Page<Account> page = accountDao.findByKeywords("%"+kwords+"%", pageable);
			model.addAttribute("LISTACCOUNT", page);
			return "views/admin/list-account";
		}
	}

	@RequestMapping("/editaccount")
	public String editaccount(Model model) {
		model.addAttribute("LISTACCOUNT", new Account());
		return "views/admin/edit-account";
	}
	
	
	@PostMapping("/checkedit")
	public String checkedit(@Validated @ModelAttribute("LISTACCOUNT") Account ac, BindingResult result, Model model)
			throws IOException {
		if (result.hasErrors()) {
			return "redirect:/manageraccount/editaccount";
		}
		accountService.save(ac);
		model.addAttribute("LISTACCOUNT", new Account());
		return "redirect:/manageraccount/listaccount/page";
	}

	@GetMapping("edit/{username}")
	public String edit(@PathVariable("username")String username, Model model) {
		Optional<Account> account = accountService.findById(username);
		if (account.isPresent()) {
			model.addAttribute("LISTACCOUNT", account.get());
		}else {
			model.addAttribute("LISTACCOUNT", new Account());
		}
		return "/views/admin/edit-account";
	}
	
	@GetMapping(value = "listaccount/page", params = "btnDel")
	public String delAccount(@RequestParam("username")String username, Model model) {
		accountService.deleteById(username);
		return "redirect:/manageraccount/listaccount/page";
	}
	
	@RequestMapping("/login")
	public String loginform(Model model) {
		model.addAttribute("ACCOUNT", new Account());
		return "views/admin/login-admin";
	}
	
	
	@PostMapping("/checklogin")
	public String checkLogin(@Validated @ModelAttribute("ACCOUNT")Account ac, BindingResult result,
			@RequestParam("username")String username,
			@RequestParam("password")String password,
			Model model, HttpSession session) {
		if (accountService.checkLogin(username, password)) {
			session.setAttribute("USERNAME", username);
			return "redirect:/manageraccount/listaccount/page";
		}else {
			if (result.hasErrors()) {
				model.addAttribute("error", "Username or password not exist");			
			}
			return "views/admin/login-admin";
		}	
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("USERNAME");
		return "redirect:/manageraccount/login";
	}

	
}
