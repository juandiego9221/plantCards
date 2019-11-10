package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

public interface PlantDecorator {
	
	String getLabel();
	String getTemplate();
	void proccessSubmission(Map<String, Object> params);

}
