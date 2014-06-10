package nl.rossie.scrambler.model;

import java.awt.Color;

public class PLL {

	private String name;
	private String colors;
	private Color crossColor;
	
	public PLL(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getColors() {
		return colors;
	}
	public void setColors(String colors) {
		this.colors = colors;
	}
	public Color getCrossColor() {
		return crossColor;
	}
	public void setCrossColor(Color crossColor) {
		this.crossColor = crossColor;
	}
}
