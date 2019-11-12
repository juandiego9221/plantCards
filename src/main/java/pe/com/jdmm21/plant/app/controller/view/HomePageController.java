package pe.com.jdmm21.plant.app.controller.view;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pe.com.jdmm21.plant.app.decorator.Herbaceous;
import pe.com.jdmm21.plant.app.decorator.Native;
import pe.com.jdmm21.plant.app.decorator.PlantDecorator;
import pe.com.jdmm21.plant.app.decorator.Woody;
import pe.com.jdmm21.plant.app.model.Plant;

@Controller
public class HomePageController {
	
	private List<PlantDecorator> plantDecorators;
	Map<String, PlantDecorator> allPlantDecorators;
	
	public HomePageController() {
		plantDecorators = new ArrayList<>();
		allPlantDecorators = new HashMap<>();
		Woody woody = new Woody();
		Herbaceous herbaceous = new Herbaceous();
		Native nativeGeo = new Native();
		allPlantDecorators.put(woody.getLabel(), woody);
		allPlantDecorators.put(herbaceous.getLabel(), herbaceous);
		allPlantDecorators.put(nativeGeo.getLabel(), nativeGeo);
	}

	@RequestMapping("/home")
	public String home(Model model,
			@RequestParam(name = "name", required = false, defaultValue = "nombrex") String name) {
		model.addAttribute("name", name);
		return "home";
	}
	
	@RequestMapping("/selectAttributes")
	public String selectAttributes(Model model) {
		model.addAttribute("components", allPlantDecorators.keySet());
		return "selectAttributes";
	}
	
	@RequestMapping("/addPlant")
	public String addPlant(@RequestParam  Map<String, String> params, Model model) {
		Set<String> selectedKeys = params.keySet();
		List<String> templates = new ArrayList<String>();
		for (String key : selectedKeys) {
			PlantDecorator plantDecorator =  allPlantDecorators.get(key);
			plantDecorators.add(plantDecorator);
			if(plantDecorator!=null) {
				String template = plantDecorator.getTemplate();
				templates.add(template);
			}
		}
		model.addAttribute("components", templates);
		model.addAttribute("plant", new Plant());
		return "addPlant";
	}
	
	@RequestMapping("/savePlant")
	public String savePlant(Plant plant, @RequestParam Map<String, String> params) {
		for (PlantDecorator plantDecorator : plantDecorators) {
			plantDecorator.proccessSubmission(params);
		}
		return "savePlant";
	}

}
