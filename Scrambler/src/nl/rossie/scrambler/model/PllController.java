package nl.rossie.scrambler.model;

import java.util.ArrayList;
import java.util.List;

public class PllController {

	private static List<PLL> pllList = new ArrayList<PLL>();
	static{
		pllList = new ArrayList<PLL>();
		PLL pll = new PLL("T");
		pll.setColors(getTperm());
		pllList.add(pll);
	}
	
	public PllController() {
	}
	
	/**
	 * Originally pll with white on U and green on F. This is not a scramble, but the letters
	 * are the name of the face they come from.
	 * @return
	 */
	private static String getTperm(){
		String result = "FFRBLFRBBLRL";
		
		return result;
	}

	public static PLL getCurrentPLL() {
		return pllList.get(0);
	}
}
