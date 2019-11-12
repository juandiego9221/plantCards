package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

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
	public void proccessSubmission(Map<String, String> params) {
		String height = params.get("height");
		String fallColor = params.get("fallColor");
		int i = 1+1;
	}

}
