package edu.nyu.cs9053.homework4;

/**
 * @author lxp1991
 *
 */
public enum Biome {
	
	Equatorial("Always moist. Little temperature seasonality. Evergreen tropical rain forest"),
	Tropical("Summer rainy season and cooler “winter” dry season. Seasonal forest, scrub, or savanna"),
	Subtropical("Highly seasonal, arid climate. Desert vegetation with considerable exposed surface"),
	Mediterranean("Winter rainy season and summer drought. Sclerophyllous (drought-adapted), frost-sensitive shrublands and woodlands"),
	Warm_temperate("Occasional frost, often with summer rainfall maximum. Temperate evergreen forest, somewhat frost-sensitive"),
	Nemoral("Moderate climate with winter freezing. Frost-resistant, deciduous, temperate forest"),
	Continental("Arid, with warm or hot summers and cold winters. Grasslands and temperate deserts"),
	Boreal("Cold temperate with cool summers and long winters. Evergreen, frost-hardy, needle-leaved forest (taiga)"),
	Polar("Short, cool summers and long, cold winters. Low, evergreen vegetation, without trees, growing over permanently frozen soils");	
	
	public static void printBiomeDescription(Biome ... biomes) {
		for (Biome biome : biomes) {
			System.out.println(biome + ": " + biome.getDescription());
		}
	} 
	
	private final String description;
	
	private Biome(String description) {
		this.description = description;
	}
	private final String getDescription() {
		return description;
	}
	
}
