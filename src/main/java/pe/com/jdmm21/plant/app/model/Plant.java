package pe.com.jdmm21.plant.app.model;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import pe.com.jdmm21.plant.app.helper.PlantHelper;

@Data
public class Plant {
	
	public  static final String HELPER = "HANDLER";
	private String genus;
	private String species;
	private String cultivar;
	private String common;
	private Map<String, String> additionalProperties;
	
	public Plant() {
		setAdditionalProperties(new HashMap<String, String>());
		additionalProperties.put(HELPER, "plantHelper");
	}
	public String accept(PlantHelper plantHelper) {
		return plantHelper.visit(this);
	}

}
