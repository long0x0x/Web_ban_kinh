package poly.edu.adminController;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpSession;
import poly.edu.dao.CategoryDao;
import poly.edu.dao.ProductDao;
import poly.edu.entity.Category;
import poly.edu.entity.Product;
import poly.edu.service.CategoryService;
import poly.edu.service.ProductService;
import poly.edu.utils.ParamService;
import poly.edu.utils.SessionService;

@Controller
@RequestMapping("managerproduct")
public class ManagerProductController {

	@Autowired
	ProductService productService;

	@Autowired
	ParamService paramService;

	@Autowired
	SessionService sessionService;

	@Autowired
	ProductDao productDao;

	@Autowired
	CategoryDao categoryDao;

	@Autowired
	CategoryService categoryService;

	@GetMapping("/listproduct/page")
	public String listmanager(Model model, @RequestParam("keywords") Optional<String> kw,
			@RequestParam("item") Optional<Integer> item, HttpSession session) {
		if (session.getAttribute("USERNAME") == null) {
			return "views/admin/login-admin";
		} else {
			String kwords = kw.orElse(sessionService.get("keywords", ""));
			sessionService.set("keywords", kwords);
			Pageable pageable = PageRequest.of(item.orElse(0), 8);
			Page<Product> page = productDao.findByKeywords("%" + kwords + "%", pageable);
			model.addAttribute("LISTPRODUCT", page);
			return "views/admin/list-product";
		}
	}

	@ModelAttribute("catetorys")
	List<Category> getCategory() {
		return categoryDao.findAll();
	}

	@RequestMapping("/editproduct")
	public String editcustomer(Model model) {
		model.addAttribute("LISTPRODUCT", new Product());
		return "views/admin/edit-product";
	}

	@PostMapping("/checkedit")
	public String checkedit(@Validated @ModelAttribute("LISTPRODUCT") Product pr, BindingResult result, Model model,
			@RequestParam("photo") MultipartFile multipartFile) throws IOException {
		if (result.hasErrors() || multipartFile.isEmpty()) {
			model.addAttribute("ERROR_PHOTO", "please select a image");
			return "views/admin/edit-product";
		}
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		String uploadDir = "/uploads";
		pr.setImage(fileName);

		paramService.save(multipartFile, uploadDir);
		productService.save(pr);
		model.addAttribute("LISTPRODUCT", new Product());
		return "redirect:/managerproduct/listproduct/page";
	}

	@GetMapping("edit/{productid}")
	public String edit(@PathVariable("productid") Integer productid, Model model) {
		Optional<Product> product = productService.findById(productid);
		if (product.isPresent()) {
			model.addAttribute("LISTPRODUCT", product.get());
		} else {
			model.addAttribute("LISTPRODUCT", new Product());
		}
		return "/views/admin/edit-product";
	}

	@GetMapping(value = "listproduct/page", params = "btnDel")
	public String delProduct(@RequestParam("productid") Integer productid, Model model) {
		productService.deleteById(productid);
		return "redirect:/managerproduct/listproduct/page";
	}

}
