package nl.rossie.scrambler.model;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import nl.rossie.scrambler.consts.ScramblerConsts;
import nl.rossie.scrambler.util.AlgorithmLoader;
import nl.rossie.scrambler.util.DataStore;

/**
 * @author D352019
 *
 */
public class Scrambler {

	private Random random;
	private boolean misOrientULayer= false;
	private DataStore dataStore = new DataStore();
	
	private static String[] turns3X3;
	static{
		setTurns3X3(new String[] {"F","F'","F2","R","R'","R2","U","U'","U2","L","L'","L2","B","B'","B2","D","D'","D2"});
	}

	private static String[] turns2X2;
	static{
		setTurns2X2(new String[] {"F","F'","F2","R","R'","R2","U","U'","U2"});
	}
	
	private ArrayList<Scramble> scrambles      = new ArrayList<Scramble>();
	private ArrayList<Solution> solutionsOLL   = new ArrayList<Solution>();
	private ArrayList<Solution> solutionsF2L   = new ArrayList<Solution>();
	private ArrayList<Solution> solutionsPLL   = new ArrayList<Solution>();
	private ArrayList<Solution> solutionsWV    = new ArrayList<Solution>();
	private ArrayList<Solution> solutionsCOLL  = new ArrayList<Solution>();
	private ArrayList<Solution> solutionsCMLL  = new ArrayList<Solution>();
	private ArrayList<Solution> solutionsCLL   = new ArrayList<Solution>();
	private ArrayList<Solution> solutionsZBLLH = new ArrayList<Solution>();
	private ArrayList<Solution> solutionsEG1   = new ArrayList<Solution>();
	private ArrayList<Solution> solutionsDef   = new ArrayList<Solution>();
	private ArrayList<Solution> solutionsF2LE  = new ArrayList<Solution>();
	
	public Scrambler(){
		AlgorithmLoader.loadAlgs(this);
	}

	//Handy for fewest moves.. reverse a string
    public String reverse(String source){
    	
    	String withoutSpaces = source.replace(" ", ""); // first replace spaces
    	StringBuilder withSpaces = new StringBuilder();
    	for (int i = 0; i < withoutSpaces.length(); i++ ){
    		//Then add spaces
			withSpaces.append(withoutSpaces.charAt(i));

    		if (i < withoutSpaces.length() -1){
    			String character = withoutSpaces.charAt(i + 1)+"";
		    	if ( character.equalsIgnoreCase("2") ||  character.equalsIgnoreCase("'")){
		    		//Loop for R2 B2 U' R' etc.
		    		continue;
		    	}
    	    }
			if(i < withoutSpaces.length() -1){
				withSpaces.append(" ");
			}
    	}
    	
		String[] result = withSpaces.toString().split(" ");
		StringBuilder generated = new StringBuilder();
		for (int i= result.length -1; i > -1; i--){
			String move = "";
			if (result[i].contains("'")){
				move = result[i].replace("'", "") + " ";
			}else{
				if (i <=  (result.length -1)){
					move = result[i] + "' ";
				}
			}
			generated.append(move);		
		}		
		return generated.toString();
    }
    
	public Scramble scrambleByOption(int option){
		switch (option) {
		case ScramblerConsts.OPTION_3X3:
			return generate3X3();
		case ScramblerConsts.OPTION_2X2:
			return generate2X2();
		case ScramblerConsts.OPTION_OLL:
			return generate(getSolutionsOLL(), ScramblerConsts.OLL_STRING);
		case ScramblerConsts.OPTION_F2L:
			return generate(getSolutionsF2L(), ScramblerConsts.F2L_STRING);
		case ScramblerConsts.OPTION_F2LE:
			return generate(getSolutionsF2LE(), ScramblerConsts.F2LE_STRING);
		case ScramblerConsts.OPTION_PLL:
			return generate(getSolutionsPLL(), ScramblerConsts.PLL_STRING);
		case ScramblerConsts.OPTION_WV:
			return generate(getSolutionsWV(), ScramblerConsts.WV_STRING);
		case ScramblerConsts.OPTION_COLL:
			return generate(getSolutionsCOLL(), ScramblerConsts.COLL_STRING);
		case ScramblerConsts.OPTION_CMLL:
			return generate(getSolutionsCMLL(), ScramblerConsts.CMLL_STRING);
		case ScramblerConsts.OPTION_CLL:
			return generate(getSolutionsCLL(), ScramblerConsts.CLL_STRING);
		case ScramblerConsts.OPTION_ZBLLH:
			return generate(getSolutionsZBLLH(), ScramblerConsts.ZBLLH_STRING);
		case ScramblerConsts.OPTION_EG1:
			return generate(getSolutionsEG1(), ScramblerConsts.EG1_STRING);
		case ScramblerConsts.OPTION_DEFAULT:
			return generate(getSolutionsDef(), ScramblerConsts.DEF_STRING);
		default:
			break;
		}
		return null;
	}
	
	/**
	 * 'Turns3X3' is an array 18 elements and one face is in a group of 3. 
	 * So that makes 6 groups/faces. 20 times pick a group, and if it is
	 * not the same as the previous pick of group, then pick a random of 3 of the content
	 * of the group.
	 */
	private Scramble generate3X3(){
		Scramble resultScramble = new Scramble();
		String result = "";
		int[] backTrail = new int[21];
		backTrail[0]= random.nextInt(6);
		for (int i = 0; i < 20; i++){
			boolean isSameAsPrevious = true;
			while( isSameAsPrevious && i > 0){
				int groupNumber = random.nextInt(6);
				if (i > 0 && groupNumber != backTrail[i-1]){
					backTrail[i] = groupNumber;
					isSameAsPrevious = false;
				}
			}
			int faceNumber = random.nextInt(3);
			result += getTurns3X3()[backTrail[i] * 3 + faceNumber] + " ";  
		}
		resultScramble.setHint("No hint available for 3 X 3 scrambles");
		resultScramble.setScramble(result);
		resultScramble.setName("Random");
		resultScramble.setCategory("3X3X3");
		return resultScramble;
	}

	
	/**
	 * 'Turns2X2' is an array 9 elements and one face is in a group of 3. 
	 * 2 X 2 had only 3 faces for turning 9 times pick a group, and if it is
	 * not the same as the previous pick of group, then pick a random of 3 of the content
	 * of the group.
	 */
	private Scramble generate2X2(){
		Scramble resultScramble = new Scramble();
		String result = "";
		int[] backTrail = new int[10];
		backTrail[0]= random.nextInt(3);
		for (int i = 0; i < 9; i++){
			boolean isSameAsPrevious = true;
			while( isSameAsPrevious && i > 0){
				int groupNumber = random.nextInt(3);
				if (i > 0 && groupNumber != backTrail[i-1]){
					backTrail[i] = groupNumber;
					isSameAsPrevious = false;
				}
			}
			int faceNumber = random.nextInt(3);
			result += getTurns2X2()[backTrail[i] * 3 + faceNumber] + " ";  
		}
		resultScramble.setHint("No hint available for 2 X 2 scrambles");
		resultScramble.setScramble(result);
		resultScramble.setName("Random");
		resultScramble.setCategory("2X2X2");
		return resultScramble;
	}
	

	private Scramble generate(ArrayList<Solution> array, String type){
		Scramble resultScramble = new Scramble();
		ArrayList<Solution> enabledSolution = new ArrayList<Solution>();
		int count = 1;
		for (Solution sol: array){
			if(sol.isEnabled()){
				sol.setId(count);
				enabledSolution.add(sol);
			}
			count++;
		}
		if(enabledSolution.size() >0){
			int rand = random.nextInt(enabledSolution.size());
			Solution solution = enabledSolution.get(rand); 
			String org = solution.getAlgoritm();
			
			String[] result = org.split(" ");
			StringBuilder generated = new StringBuilder();
			generated.append(randomOrientation());
			for (int i= result.length -1; i > -1; i--){
				String move = "";
				if (result[i].contains("'")){
					move = result[i].replace("'", "") + " ";
				}else{
					move = result[i] + "' ";
				}
				generated.append(move);		
				
			}
			generated.append(randomOrientation());
			
			resultScramble.setIndex(solution.getId());
			resultScramble.setName(solution.getName());
			resultScramble.setScramble(generated.toString());
			resultScramble.setHint(org);
			resultScramble.setCategory(type);
			resultScramble.setImageFileName("/"+ type + (solution.getId()) + ".png"); // images start from 1 and array from 0
        }else{
			resultScramble.setName("No algs found!");
			resultScramble.setScramble("Please add your own algs.");
			resultScramble.setHint("look in algs text files.");
		}

		return resultScramble;
	}

	
	private String randomOrientation(){
		String[] orients = new String[] {"U","U'","U2","U2'"};
		String result = "";
		if(misOrientULayer){
			result = orients[random.nextInt(orients.length)] + " ";
		}
		return result;
	}
	
	public String getAveragesText(){
		AverageCalculator averageCalculator = new AverageCalculator();
		return averageCalculator.getAveragesText(scrambles);
	}

	public String getHistory(){
		StringBuilder sb = new StringBuilder();
		int count = 1;
		for(Scramble scramble : scrambles){
			String countStr = count + "";
			if(countStr.length() == 1){
				countStr = "0" + countStr;
			}
			sb.append(countStr +  " :" + scramble.getTime() +  " :" + scramble.getScramble() + ScramblerConsts.NEW_LINE);
			count++;
		}
		return sb.toString();
	}

	public String getAverages(Date from, Date untill, String caseId) throws SQLException{
		return dataStore.getAverages(from, untill, caseId);
	}
	
	public void addScramble(Scramble scramble){
		getScrambles().add(scramble);
		dataStore.saveTime(scramble);
	}

	public void clearScrambles(){
		getScrambles().clear();
	}
	
	/**
	 * @return the turns
	 */
	public static String[] getTurns3X3() {
		return turns3X3;
	}

	/**
	 * @return the turns
	 */
	public static String[] getTurns2X2() {
		return turns2X2;
	}
	
	/**
	 * @param turns the turns to set
	 */
	public static void setTurns3X3(String[] turns) {
		Scrambler.turns3X3 = turns;
	}

	/**
	 * @param turns the turns to set
	 */
	public static void setTurns2X2(String[] turns) {
		Scrambler.turns2X2 = turns;
	}
	
	/**
	 * @return the random
	 */
	public Random getRandom() {
		return random;
	}

	/**
	 * @param random the random to set
	 */
	public void setRandom(Random random) {
		this.random = random;
	}


	public  ArrayList<Solution> getSolutionsOLL() {
		return solutionsOLL;
	}


	public void setSolutionsOLL(ArrayList<Solution> solutionsOLL) {
		this.solutionsOLL = solutionsOLL;
	}

	public ArrayList<Scramble> getScrambles() {
		return scrambles;
	}

	public void setScrambles(ArrayList<Scramble> scrambles) {
		this.scrambles = scrambles;
	}

	public ArrayList<Solution> getSolutionsPLL() {
		return solutionsPLL;
	}

	public void setSolutionsPLL(ArrayList<Solution> solutionsPLL) {
		this.solutionsPLL = solutionsPLL;
	}

	public ArrayList<Solution> getSolutionsCOLL() {
		return solutionsCOLL;
	}

	public void setSolutionsCOLL(ArrayList<Solution> solutionsCOLL) {
		this.solutionsCOLL = solutionsCOLL;
	}

	public ArrayList<Solution> getSolutionsCMLL() {
		return solutionsCMLL;
	}

	public void setSolutionsCMLL(ArrayList<Solution> solutionsCMLL) {
		this.solutionsCMLL = solutionsCMLL;
	}


	public ArrayList<Solution> getSolutionsCLL() {
		return solutionsCLL;
	}


	public void setSolutionsCLL(ArrayList<Solution> solutionsCLL) {
		this.solutionsCLL = solutionsCLL;
	}


	public ArrayList<Solution> getSolutionsZBLLH() {
		return solutionsZBLLH;
	}


	public void setSolutionsZBLLH(ArrayList<Solution> solutionsZBLLH) {
		this.solutionsZBLLH = solutionsZBLLH;
	}


	public boolean isMisOrientULayer() {
		return misOrientULayer;
	}


	public void setMisOrientULayer(boolean misOrientULayer) {
		this.misOrientULayer = misOrientULayer;
	}


	/**
	 * @return the solutionsEG1
	 */
	public ArrayList<Solution> getSolutionsEG1() {
		return solutionsEG1;
	}


	/**
	 * @param solutionsF2L the solutionsF2L to set
	 */
	public void setSolutionsF2L(ArrayList<Solution> solutionsF2L) {
		this.solutionsF2L = solutionsF2L;
	}

	/**
	 * @return the solutionsF2L
	 */
	public ArrayList<Solution> getSolutionsF2L() {
		return solutionsF2L;
	}


	/**
	 * @param solutionsEG1 the solutionsEG1 to set
	 */
	public void setSolutionsEG1(ArrayList<Solution> solutionsEG1) {
		this.solutionsEG1 = solutionsEG1;
	}
	

	public ArrayList<Solution> getSolutionsDef() {
		return solutionsDef;
	}


	public void setSolutionsDef(ArrayList<Solution> solutionsDef) {
		this.solutionsDef = solutionsDef;
	}

	public ArrayList<Solution> getSolutionsWV() {
		return solutionsWV;
	}

	public void setSolutionsWV(ArrayList<Solution> solutionsWV) {
		this.solutionsWV = solutionsWV;
	}

	public ArrayList<Solution> getSolutionsF2LE() {
		return solutionsF2LE;
	}

	public void setSolutionsF2LE(ArrayList<Solution> solutionsF2LE) {
		this.solutionsF2LE = solutionsF2LE;
	}
}
