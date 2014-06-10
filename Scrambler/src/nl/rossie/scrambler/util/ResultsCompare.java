package nl.rossie.scrambler.util;

import java.util.Comparator;

import nl.rossie.scrambler.model.AverageSet;

public class ResultsCompare implements Comparator<AverageSet> {
	

	@Override
	public int compare(AverageSet set1, AverageSet set2) {

		return (int)set1.getAverage() - (int)set2.getAverage();
	}
}