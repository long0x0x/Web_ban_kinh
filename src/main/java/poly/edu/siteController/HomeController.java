package poly.edu.siteController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import poly.edu.dao.ProductDao;
import poly.edu.entity.Product;

@Controller
@RequestMapping("home")
public class HomeController {
	
	@Autowired
	ProductDao productDao;
	
	
	@RequestMapping("index")
	public String index(Model model) {
		
		List<Product> list = productDao.findAll();
		model.addAttribute("PRODUCTHOME", list);
		
		return "views/user/index";
	}
	@PostMapping("producthome")
	List<Product> getProducts() {	
		return productDao.findAll();
	}
	@RequestMapping("/cart")
	public String cart() {
		return "views/user/shopping-cart";
	}
	
	@RequestMapping("/viewproduct")
	public String views() {
		return "views/user/view-product";
	}
	
	@RequestMapping("/allproduct")
	public String allproduct() {
		return "views/user/all-product";
	}
	
}
