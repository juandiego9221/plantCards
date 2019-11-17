package pe.com.jdmm21.plant.app.helper;

import java.util.Map;

import org.json.simple.JSONObject;

public class WoodyHelper extends PlantHelper{

//	private int height;
//	private String fallColor;
//	
//	public void setHeight(int height) {
//		this.height = height;
//	}
//	
//	public int getHeight() {
//		return height;
//	}

	@Override
	public void typeSpecificJSON(JSONObject jsonObject) {
		Map<String, String> additionalProperties = plant.getAdditionalProperties();
		jsonObject.put("height", additionalProperties.get("height"));
		jsonObject.put("fallColor", additionalProperties.get("fallColor"));
	}

}
