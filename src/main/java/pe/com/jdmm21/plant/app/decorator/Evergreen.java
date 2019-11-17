package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

import pe.com.jdmm21.plant.app.model.Plant;

public class Evergreen implements PlantDecorator{

	@Override
	public String getLabel() {
		return "Evergreen";
	}

	@Override
	public String getTemplate() {
		return "fragments/evergreen";
	}

	@Override
	public void proccessSubmission(Map<String, String> params, Plant plant) {
		String broadleafconifer = params.get("broadleafconifer");
		int i= 1+1;
		
	}

}
