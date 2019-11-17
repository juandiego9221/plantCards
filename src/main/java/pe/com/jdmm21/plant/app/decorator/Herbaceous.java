package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

import pe.com.jdmm21.plant.app.model.Plant;

public class Herbaceous implements PlantDecorator{

	@Override
	public String getLabel() {
		return "Herbaceous Plant (Flower)";
	}

	@Override
	public String getTemplate() {
		return "fragments/herbaceous";
	}

	@Override
	public void proccessSubmission(Map<String, String> params, Plant plant) {
		Map<String, String> additionalProperties = plant.getAdditionalProperties();
		additionalProperties.put(Plant.HELPER, "herbaceousPlantHelper");
	}

}
