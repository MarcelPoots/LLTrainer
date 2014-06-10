/**
 * Marcel Poots
 */
package nl.rossie.scrambler.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import nl.rossie.scrambler.consts.ScramblerConsts;
import nl.rossie.scrambler.model.Scrambler;
import nl.rossie.scrambler.model.Solution;

/**
 * @author MarcelP
 *
 */
public class FileUtil {


	public void writeToFile(String filename, Scrambler scrambler, int option) throws IOException{
		
		//When file does not exsist make file and place some algs in there
	    Writer output = new BufferedWriter(new FileWriter(filename));
	    try {
	    	//FileWriter always assumes default encoding is OK!
	    	if (option == ScramblerConsts.OLL){
		    	for (int i = 0; i < scrambler.getSolutionsOLL().size(); i++){
		    		Solution solution = scrambler.getSolutionsOLL().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsOLL().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	if (option == ScramblerConsts.F2L){
		    	for (int i = 0; i < scrambler.getSolutionsF2L().size(); i++){
		    		Solution solution = scrambler.getSolutionsF2L().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsF2L().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	if (option == ScramblerConsts.F2LE){
		    	for (int i = 0; i < scrambler.getSolutionsF2LE().size(); i++){
		    		Solution solution = scrambler.getSolutionsF2LE().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsF2LE().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	if (option == ScramblerConsts.PLL){
		    	for (int i = 0; i < scrambler.getSolutionsPLL().size(); i++){
		    		Solution solution = scrambler.getSolutionsPLL().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsPLL().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	if (option == ScramblerConsts.WV){
		    	for (int i = 0; i < scrambler.getSolutionsWV().size(); i++){
		    		Solution solution = scrambler.getSolutionsWV().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsWV().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	if (option == ScramblerConsts.COLL){
		    	for (int i = 0; i < scrambler.getSolutionsCOLL().size(); i++){
		    		Solution solution = scrambler.getSolutionsCOLL().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsCOLL().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	if (option == ScramblerConsts.CMLL){
		    	for (int i = 0; i < scrambler.getSolutionsCMLL().size(); i++){
		    		Solution solution = scrambler.getSolutionsCMLL().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsCMLL().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	if (option == ScramblerConsts.CLL){
		    	for (int i = 0; i < scrambler.getSolutionsCLL().size(); i++){
		    		Solution solution = scrambler.getSolutionsCLL().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsCLL().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	if (option == ScramblerConsts.ZBLLH){
		    	for (int i = 0; i < scrambler.getSolutionsZBLLH().size(); i++){
		    		Solution solution = scrambler.getSolutionsZBLLH().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsZBLLH().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	if (option == ScramblerConsts.EG1){
		    	for (int i = 0; i < scrambler.getSolutionsEG1().size(); i++){
		    		Solution solution = scrambler.getSolutionsEG1().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsEG1().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	if (option == ScramblerConsts.DEFAULT){
		    	for (int i = 0; i < scrambler.getSolutionsDef().size(); i++){
		    		Solution solution = scrambler.getSolutionsDef().get(i); 
		    		output.write(solution.getAlgoritm() + " [" + 
		    				scrambler.getSolutionsDef().get(i).getName() + "] {" + 
		    				(solution.isEnabled() ? "TRUE" : "FALSE") + "}" + ScramblerConsts.NEW_LINE);
		    	}
	    	}
	    	
	    }
	    finally {
	      output.close();
	    }

	}

	public void readAlgsFromFile(Scrambler scrambler, int option) throws IOException{
		
		String filename = "algs.txt";
		switch (option) {
		case ScramblerConsts.OLL:
			filename = "algsOLL.txt";	
			break;
		case ScramblerConsts.F2L:
			filename = "algsF2L.txt";	
			break;
		case ScramblerConsts.F2LE:
			filename = "algsF2LE.txt";	
			break;
		case ScramblerConsts.PLL:
			filename = "algsPLL.txt";	
			break;
		case ScramblerConsts.WV:
			filename = "algsWV.txt";	
			break;
		case ScramblerConsts.COLL:
			filename = "algsCOLL.txt";	
			break;
		case ScramblerConsts.CMLL:
			filename = "algsCMLL.txt";	
			break;
		case ScramblerConsts.CLL:
			filename = "algsCLL.txt";	
			break;
		case ScramblerConsts.ZBLLH:
			filename = "algsZBLLH.txt";	
			break;
		case ScramblerConsts.EG1:
			filename = "algsEG-1.txt";	
			break;
		case ScramblerConsts.DEFAULT:
			filename = "algsDefault.txt";	
			break;
		default:
			break;
		}
		
		File f = new File(filename);
		 
		if(!f.exists()){

			writeToFile(filename, scrambler, option);
			
		}else{
			
			ArrayList<Solution> algs = new ArrayList<Solution>();
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			int count = 1;
			try{
				String line;
				while((line = br.readLine()) != null) {
					int nameStart      = line.indexOf("[");
					int nameEnd        = line.indexOf("]");
					int enabledStart   = line.indexOf("{");
					int enabledEnd     = line.indexOf("}");

					boolean enabled    = true;
					String name        = "";
					String alg         = "";
					
					if(enabledStart > 0){
						String enableStr = line.substring(enabledStart + 1, enabledEnd);
						enableStr = enableStr + "";
						enabled = line.substring(enabledStart + 1, enabledEnd).equalsIgnoreCase("TRUE");
						alg = line.substring(0,nameStart);
					}					
					if(nameStart > 0){
						name = line.substring(nameStart + 1, nameEnd);
						alg = line.substring(0,nameStart);
					}else{
						alg = line;
					}
					Solution solution = new Solution(alg, name, enabled);
					solution.setId(count);
					count++;
					algs.add(solution);
				}
			}finally{
				br.close();
			}
			switch (option) {
			case ScramblerConsts.OLL:
				scrambler.setSolutionsOLL(algs);	
				break;
			case ScramblerConsts.F2L:
				scrambler.setSolutionsF2L(algs);	
				break;
			case ScramblerConsts.PLL:
				scrambler.setSolutionsPLL(algs);	
				break;
			case ScramblerConsts.WV:
				scrambler.setSolutionsWV(algs);	
				break;
			case ScramblerConsts.COLL:
				scrambler.setSolutionsCOLL(algs);	
				break;
			case ScramblerConsts.CMLL:
				scrambler.setSolutionsCMLL(algs);	
				break;
			case ScramblerConsts.CLL:
				scrambler.setSolutionsCLL(algs);	
				break;
			case ScramblerConsts.ZBLLH:
				scrambler.setSolutionsZBLLH(algs);	
				break;
			case ScramblerConsts.EG1:
				scrambler.setSolutionsEG1(algs);	
				break;
			case ScramblerConsts.DEFAULT:
				scrambler.setSolutionsDef(algs);	
				break;
			default:
				break;
			}
			
		}
	}
	
	

}
