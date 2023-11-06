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
import poly.edu.dao.CustomerDao;
import poly.edu.entity.Customer;
import poly.edu.service.CustomerService;
import poly.edu.utils.ParamService;
import poly.edu.utils.SessionService;

@Controller
@RequestMapping("managercustomer")
public class ManagerCustomerController {

	@Autowired
	CustomerService customerService;

	@Autowired
	ParamService paramService;

	@Autowired
	SessionService sessionService;

	@Autowired
	CustomerDao customerDao;

	@GetMapping("/listcustomer/page")
	public String listmanager(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("item") Optional<Integer> item, HttpSession session) {
		if (session.getAttribute("USERNAME") == null) {
			return "views/admin/login-admin";
		} else {
			String kwords = kw.orElse(sessionService.get("keywords", ""));
			sessionService.set("keywords", kwords);
			Pageable pageable = PageRequest.of(item.orElse(0), 6);
			Page<Customer> page = customerDao.findByKeywords("%" + kwords + "%", pageable);
			model.addAttribute("LISTCUSTOMER", page);
			return "views/admin/list-customer";
		}
	}

	@RequestMapping("/editcustomer")
	public String editcustomer(Model model) {
		model.addAttribute("LISTCUSTOMER", new Customer());
		return "views/admin/edit-customer";
	}

	@PostMapping("/checkedit")
	public String checkedit(@Validated @ModelAttribute("LISTCUSTOMER") Customer cs, BindingResult result, Model model)
			throws IOException {
		if (result.hasErrors()) {
			return "redirect:/managercustomer/editcustomer";
		}
		customerService.save(cs);
		model.addAttribute("LISTCUSTOMER", new Customer());
		return "redirect:/managercustomer/listcustomer/page";
	}

	@GetMapping("edit/{customername}")
	public String edit(@PathVariable("customername") String customername, Model model) {
		Optional<Customer> customer = customerService.findById(customername);
		if (customer.isPresent()) {
			model.addAttribute("LISTCUSTOMER", customer.get());
		} else {
			model.addAttribute("LISTCUSTOMER", new Customer());
		}
		return "/views/admin/edit-customer";
	}

	@GetMapping(value = "listcustomer/page", params = "btnDel")
	public String delAccount(@RequestParam("customername") String customername, Model model) {
		customerService.deleteById(customername);
		return "redirect:/managercustomer/listcustomer/page";
	}

}
