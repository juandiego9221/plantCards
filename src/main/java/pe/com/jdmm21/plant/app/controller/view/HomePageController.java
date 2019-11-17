package pe.com.jdmm21.plant.app.controller.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import pe.com.jdmm21.plant.app.decorator.PlantAttributeGroup;
import pe.com.jdmm21.plant.app.decorator.PlantDecorator;
import pe.com.jdmm21.plant.app.helper.PlantHelper;
import pe.com.jdmm21.plant.app.model.Plant;

@Controller
@ImportResource("/WEB-INF/classes/applicationContext.xml")
public class HomePageController {

	@Autowired
	private PlantAttributeGroup plantAttributeGroup;

	private List<PlantDecorator> plantDecorators;

	private List<Plant> allPlants;

	public HomePageController() {
		plantDecorators = new ArrayList<>();
		allPlants = new ArrayList<>();
	}

	@RequestMapping("/home")
	public String home(Model model,
			@RequestParam(name = "name", required = false, defaultValue = "nombrex") String name) {
		model.addAttribute("name", name);
		return "home";
	}

	@RequestMapping("/selectAttributes")
	public String selectAttributes(Model model) {
		model.addAttribute("components", plantAttributeGroup.getDecorators().keySet());
		return "selectAttributes";
	}

	@RequestMapping("/addPlant")
	public String addPlant(@RequestParam Map<String, String> params, Model model) {
		Set<String> selectedKeys = params.keySet();
		List<String> templates = new ArrayList<String>();
		for (String key : selectedKeys) {
			PlantDecorator plantDecorator = plantAttributeGroup.getDecorators().get(key);
			plantDecorators.add(plantDecorator);
			if (plantDecorator != null) {
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
			if (plantDecorator != null) {
				plantDecorator.proccessSubmission(params, plant);
			}
		}
		allPlants.add(plant);
		return "savePlant";
	}

	@RequestMapping(value = "/generateJson",method = RequestMethod.GET,produces = "application/json")
	@ResponseBody
	public String generateJson() {
//		List<PlantHelper> plantHelpers = new ArrayList<>();
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/classes/applicationContext.xml");
////		PlantHelper broadLeafPlantHelper = context.getBean("broadLeafPlantHelper",PlantHelper.class);
////		PlantHelper herbaceousPlantHelper = context.getBean("herbaceousPlantHelper",PlantHelper.class);
//		PlantHelper mohanianAquifoliumHelper = context.getBean("broadLeafPlantHelper",PlantHelper.class);
//		PlantHelper monardaDidymaHelper = context.getBean("herbaceousPlantHelper",PlantHelper.class);
//		PlantHelper monardaFistulosaHelper = context.getBean("herbaceousPlantHelper",PlantHelper.class);
////		monardaFistulosaHelper.setSpecies("fistulosa");
////		monardaFistulosaHelper.setCommon("wild  Bergamon");
//		plantHelpers.add(monardaFistulosaHelper);
//		plantHelpers.add(monardaDidymaHelper);
//		plantHelpers.add(mohanianAquifoliumHelper);
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/WEB-INF/classes/applicationContext.xml");
		StringBuilder json = new StringBuilder();
				
		for (Plant plant : allPlants) {
			Map<String, String> additionalProperties = plant.getAdditionalProperties();
			String helperBean = additionalProperties.get(Plant.HELPER);
			PlantHelper plantHelper = context.getBean(helperBean,PlantHelper.class);
			String plantJson = plant.accept(plantHelper);
			json.append(plantJson);
		}
		return json.toString();
	}

}
