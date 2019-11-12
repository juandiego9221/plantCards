package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

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
	public void proccessSubmission(Map<String, String> params) {
		String region = params.get("region");
		int i = 1+1;
	}

}
