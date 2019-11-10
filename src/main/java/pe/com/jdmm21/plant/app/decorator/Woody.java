package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

public class Woody implements PlantDecorator{

	@Override
	public String getLabel() {
		// TODO Auto-generated method stub
		return "Woody Plant";
	}

	@Override
	public String getTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void proccessSubmission(Map<String, Object> params) {
		// TODO Auto-generated method stub
		
	}

}
