package nl.rossie.scrambler.util;

import java.util.Comparator;

import nl.rossie.scrambler.model.Scramble;

public class ScrambleResultCompare implements Comparator<Scramble> {

	@Override
	public int compare(Scramble o1, Scramble o2) {
		// TODO Auto-generated method stub
		
		return (int)o1.getResult().doubleValue() - (int)o2.getResult().doubleValue();
	}
	


}
