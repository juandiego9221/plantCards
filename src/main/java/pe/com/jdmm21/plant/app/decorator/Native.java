package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

import pe.com.jdmm21.plant.app.model.Plant;

public class Native implements PlantDecorator{

	@Override
	public String getLabel() {
		return "Native";
	}

	@Override
	public String getTemplate() {
		return "fragments/native";
	}

	@Override
	public void proccessSubmission(Map<String, String> params, Plant plant) {
		String region = params.get("region");
		Map<String, String> additionalProperties = plant.getAdditionalProperties();
		additionalProperties.put("nativeRegion", region);

	}

}
