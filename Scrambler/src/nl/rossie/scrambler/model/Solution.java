package nl.rossie.scrambler.model;

public class Solution {

	private int id;
	private String algoritm;
	private String name;
	private boolean enabled;

	
	public Solution(String alg, String name, boolean enabled){
		setEnabled(enabled);
		setAlgoritm(alg);
		setName(name);
	}
	public String getAlgoritm() {
		return algoritm;
	}
	public void setAlgoritm(String algoritm) {
		this.algoritm = algoritm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getReverse() {
		
		String org = getAlgoritm();
		
		String[] result = org.split(" ");
		StringBuilder generated = new StringBuilder();
		for (int i= result.length -1; i > -1; i--){
			String move = "";
			if (result[i].contains("'")){
				move = result[i].replace("'", "") + " ";
			}else{
				move = result[i] + "' ";
			}
			generated.append(move);		
			
		}		
		
		return generated.toString();
	}


}
