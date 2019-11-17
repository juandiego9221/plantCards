package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

import pe.com.jdmm21.plant.app.model.Plant;

public class Woody implements PlantDecorator{

	@Override
	public String getLabel() {
		return "Woody Plant";
	}

	@Override
	public String getTemplate() {
		return "fragments/woody";
	}

	@Override
	public void proccessSubmission(Map<String, String> params, Plant plant) {
		Map<String, String> additionalProperties = plant.getAdditionalProperties();
		String height = params.get("height");
		String fallColor = params.get("fallColor");
		additionalProperties.put("fallColor", fallColor);
		additionalProperties.put("height", height);
		additionalProperties.put(Plant.HELPER, "woodyPlantHelper");
	}

}
