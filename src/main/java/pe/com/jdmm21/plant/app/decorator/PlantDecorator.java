package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

import pe.com.jdmm21.plant.app.model.Plant;

public interface PlantDecorator {
	
	String getLabel();
	String getTemplate();
	void proccessSubmission(Map<String, String> params, Plant plant);

}
