package nl.rossie.scrambler.model;

import java.util.ArrayList;
import java.util.Collections;

import nl.rossie.scrambler.consts.ScramblerConsts;
import nl.rossie.scrambler.util.ResultsCompare;
import nl.rossie.scrambler.util.ScrambleResultCompare;
import nl.rossie.scrambler.util.TimeDisplayUtil;

public class AverageCalculator {

	private ArrayList<Scramble> scrambles;
	
	private ArrayList<AverageSet> averages = new ArrayList<AverageSet>();
	
	public String getAveragesText(ArrayList<Scramble> list){
		scrambles = list;
		
		String result = "  Average main: " + getAverage() + 
						ScramblerConsts.NEW_LINE +
						"  Fastest time " + getFastest() +
						ScramblerConsts.NEW_LINE +
						"  Slowest time " + getSlowest() +
						ScramblerConsts.NEW_LINE +
						"  Best average of 12:"+ getAverageOf(12) +
						ScramblerConsts.NEW_LINE +
						"  Best average of 5: " + getAverageOf(5)+
						ScramblerConsts.NEW_LINE +
						"  Best average of 3: " + getAverageOf(3); 
		return result;
	}
	
	private String getAverageOf(int set){
		String result = "--:--:--";
		averages.clear();
		for (int i = 0; i < scrambles.size(); i++ ){
			Long av = new Long(0);
			// Make temp list so we can remove slowest and fastest time
			ArrayList<Scramble> temp = new ArrayList<Scramble>();
			int setCount = 0;
			for (int j = i; j < scrambles.size();  j++ ){
				temp.add(scrambles.get(j));
				setCount++;
				if (setCount == set){
					break;
				}
			}
			Collections.sort(temp, new  ScrambleResultCompare());
			if(temp.size() == set ){
				System.out.println("Slowest " + temp.get(set -1).getResult() + " fastest " + temp.get(0).getResult() );
				if(set != 3){
					temp.remove(set -1); // last one
					temp.remove(0); // first one
				}
				for (int k = 0; k < temp.size(); k++ ){
					av = av + temp.get(k).getResult();
					System.out.println("Average plus " + av);
					System.out.println("Temp index: " + temp.get(k).getIndex() + " av: " + temp.get(k).getResult());
				}
				System.out.println("Toegevoegd " + i + " av: " + av / temp.size());
				averages.add(new AverageSet(i, av / temp.size()));
				continue;
			}
		}
		Collections.sort(averages, new ResultsCompare());
		if(averages.size() >= 0){
			for (AverageSet a: averages ){
				System.out.println("Laatste loop: " +a.getIndex() + " av: " + a.getAverage());
				if(a.getAverage() != 0){
					int last = (a.getIndex() + set) -1;
					return  TimeDisplayUtil.longToTimeString(a.getAverage()) + " (No " + (a.getIndex() + 1) + " until " + (last + 1) + ")";
					//break.. we found the smallest average
				}
			}
			for (AverageSet a: averages ){
				if(a.getAverage() != 0){
					int last = (a.getIndex() + set) -1;
					System.out.println("Gekozen: " +a.getIndex() + " av: " + a.getAverage());
					return  TimeDisplayUtil.longToTimeString(a.getAverage()) + " (No " + (a.getIndex() + 1) + " until " + (last + 1) + ")";
					//break.. we found the smallest average
				}
				
			}
		}
		return result;
	}

	
	private String getAverage(){
		Long av = new Long("0");
		try{
			if (scrambles.size() == 1){
				return scrambles.get(0).getTime();
			}
			for (Scramble scramble : scrambles){
				av = av +  scramble.getResult();
			}
			return TimeDisplayUtil.longToTimeString(av / scrambles.size());
		}catch(Exception e){
			return "00:00:00";
		}
	}
	
	private String getFastest(){
		Long fast = new Long(Long.MAX_VALUE);
		try{
			for (Scramble scramble: scrambles){
				if(scramble.getResult() < fast){
					fast = scramble.getResult();
				}
			}
			if (scrambles.size() == 1){
				return scrambles.get(0).getTime();
			}
			return TimeDisplayUtil.longToTimeString(fast);
		}catch(Exception e){
			return "00:00:00";
		}
	}

	private String getSlowest(){
		Long slow = new Long(Long.MIN_VALUE);
		try{
			for (Scramble scramble: scrambles){
				if(scramble.getResult() > slow){
					slow = scramble.getResult();
				}
			}
			if (scrambles.size() == 1){
				return scrambles.get(0).getTime();
			}
			return TimeDisplayUtil.longToTimeString(slow);
		}catch(Exception e){
			return "00:00:00";
		}
	}
	
}
