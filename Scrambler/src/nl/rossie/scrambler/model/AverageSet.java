package nl.rossie.scrambler.model;

public class AverageSet {

	private int index;
	private long average;
	
	public AverageSet(int index, Long average){
		setIndex(index);
		setAverage(average);
	}
	
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
	public long getAverage() {
		return average;
	}
	public void setAverage(long average) {
		this.average = average;
	}
	

}
