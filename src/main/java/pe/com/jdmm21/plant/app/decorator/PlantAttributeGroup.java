package pe.com.jdmm21.plant.app.decorator;

import java.util.Map;

import lombok.Data;

@Data
public class PlantAttributeGroup {
	private Map<String, PlantDecorator> decorators;
}
