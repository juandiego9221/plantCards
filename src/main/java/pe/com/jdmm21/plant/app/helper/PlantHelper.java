package pe.com.jdmm21.plant.app.helper;

import org.json.simple.JSONObject;

import pe.com.jdmm21.plant.app.model.Plant;

public abstract class PlantHelper {

	private String nativeRegion;
	private EvergreenHelper evergreenHelper;
	private Plant plant;
	
	public String visit(Plant plant) {
		this.plant = plant;
		return generateJson();
	}

	public String getNativeRegion() {
		return nativeRegion;
	}

	public void setNativeRegion(String nativeRegion) {
		this.nativeRegion = nativeRegion;
	}

	public EvergreenHelper getEvergreenHelper() {
		return evergreenHelper;
	}

	public void setEvergreenHelper(EvergreenHelper evergreenHelper) {
		this.evergreenHelper = evergreenHelper;
	}

	public String generateJson() {
		String returnValue = "";
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("genus", plant.getGenus());
		jsonObject.put("species", plant.getSpecies());
		jsonObject.put("common", plant.getCommon());
		jsonObject.put("cultivar", plant.getCultivar());
		typeSpecificJSON(jsonObject);
		return jsonObject.toString();
	}
	
	public abstract void typeSpecificJSON(JSONObject jsonObject) ;
	
	
}
