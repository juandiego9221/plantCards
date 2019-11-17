package pe.com.jdmm21.plant.app.model;

import lombok.Data;
import pe.com.jdmm21.plant.app.helper.PlantHelper;

@Data
public class Plant {
	
	private String genus;
	private String species;
	private String cultivar;
	private String common;
	public String accept(PlantHelper plantHelper) {
		return plantHelper.visit(this);
	}

}
