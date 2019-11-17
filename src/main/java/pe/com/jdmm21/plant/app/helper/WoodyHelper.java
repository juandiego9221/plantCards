package pe.com.jdmm21.plant.app.helper;

import org.json.simple.JSONObject;

public class WoodyHelper extends PlantHelper{

	private int height;
	private String fallColor;
	
	public void setHeight(int height) {
		this.height = height;
	}
	
	public int getHeight() {
		return height;
	}

	@Override
	public void typeSpecificJSON(JSONObject jsonObject) {
		jsonObject.put("height", height);
		jsonObject.put("fallColor", fallColor);
	}

}
