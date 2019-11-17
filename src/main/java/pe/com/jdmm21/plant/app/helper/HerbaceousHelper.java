package pe.com.jdmm21.plant.app.helper;

import org.json.simple.JSONObject;

import lombok.Data;

@Data
public class HerbaceousHelper extends PlantHelper{
	private String flowerColor;
	private String flowerTime;
	@Override
	public void typeSpecificJSON(JSONObject jsonObject) {
		jsonObject.put("flowerColor", flowerColor);
		jsonObject.put("flowerTime", flowerTime);
	}

}
