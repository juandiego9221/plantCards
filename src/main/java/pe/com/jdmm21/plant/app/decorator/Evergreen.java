package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

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
	public void proccessSubmission(Map<String, String> params) {
		String broadleafconifer = params.get("broadleafconifer");
		int i= 1+1;
		
	}

}
