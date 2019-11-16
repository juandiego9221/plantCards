package pe.com.jdmm21.plant.app.helper;

import lombok.Data;

@Data
public class PlantHelper {
	
	private String genus;
	private String species;
	private String cultivar;
	private String common;
	private String nativeRegion;
	private EvergreenHelper  evergreenHelper;

}
