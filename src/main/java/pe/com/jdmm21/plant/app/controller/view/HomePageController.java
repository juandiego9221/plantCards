package pe.com.jdmm21.plant.app.controller.view;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.jdmm21.plant.app.decorator.PlantDecorator;

@Controller
public class HomePageController {
	
	private List<PlantDecorator> plantDecorators ;
	
	public HomePageController() {
		plantDecorators = new ArrayList<>();
	}

	@RequestMapping("/home")
	public String home(Model model,
			@RequestParam(name = "name", required = false, defaultValue = "nombrex") String name) {
		model.addAttribute("name", name);
		return "home";
	}

}
