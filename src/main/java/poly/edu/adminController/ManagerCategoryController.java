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
import poly.edu.dao.CategoryDao;
import poly.edu.entity.Category;
import poly.edu.service.CategoryService;
import poly.edu.utils.ParamService;
import poly.edu.utils.SessionService;

@Controller
@RequestMapping("managercategory")
public class ManagerCategoryController {
	@Autowired
	CategoryService categoryService;

	@Autowired
	ParamService paramService;
	
	@Autowired
	SessionService sessionService;
	
	@Autowired
	CategoryDao categoryDao;
	
	@GetMapping("/listcategory/page")
	public String listmanager(Model model,@RequestParam("keywords") Optional<String> kw , @RequestParam("item") Optional<Integer> item, HttpSession session) {
		if (session.getAttribute("USERNAME") == null) {
			return "views/admin/login-admin";
		}else {	
		String kwords = kw.orElse(sessionService.get("keywords", ""));
		sessionService.set("keywords", kwords);
		Pageable pageable = PageRequest.of(item.orElse(0), 6);
		Page<Category> page = categoryDao.findByKeywords("%"+kwords+"%", pageable);
		model.addAttribute("LISTCATEGORY", page);
		return "views/admin/list-category";
		}
	}

	@RequestMapping("/editcategory")
	public String editcategory(Model model) {
		model.addAttribute("LISTCATEGORY", new Category());
		return "views/admin/edit-category";
	}
	
	
	@PostMapping("/checkedit")
	public String checkedit(@Validated @ModelAttribute("LISTCATEGORY") Category ct, BindingResult result, Model model)
			throws IOException {
		if (result.hasErrors()) {
			return "redirect:/managercategory/editcategory";
		}
		categoryService.save(ct);
		model.addAttribute("LISTCATEGORY", new Category());
		return "redirect:/managercategory/listcategory/page";
	}

	@GetMapping("edit/{categoryid}")
	public String edit(@PathVariable("categoryid")Integer categoryid, Model model) {
		Optional<Category> category = categoryService.findById(categoryid);
		if (category.isPresent()) {
			model.addAttribute("LISTCATEGORY", category.get());
		}else {
			model.addAttribute("LISTCATEGORY", new Category());
		}
		return "/views/admin/edit-category";
	}
	
	@GetMapping(value = "listcategory/page", params = "btnDel")
	public String delAccount(@RequestParam("categoryid")Integer categoryid, Model model) {
		categoryService.deleteById(categoryid);
		return "redirect:/managercategory/listcategory/page";
	}
}
