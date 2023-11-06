package poly.edu.siteController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("product")
public class ProductController {
	
	@GetMapping("/form-product")
	public String display() {
		return "views/user/product-form";
	}
	
}
