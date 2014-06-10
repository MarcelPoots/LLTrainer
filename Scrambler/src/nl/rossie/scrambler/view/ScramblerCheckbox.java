package nl.rossie.scrambler.view;

import javax.swing.JCheckBox;

import nl.rossie.scrambler.model.Solution;

public class ScramblerCheckbox extends JCheckBox{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Solution solution;

	public ScramblerCheckbox(String name, Solution solution){
		super(name);
		setSolution(solution);
	}

	public Solution getSolution() {
		return solution;
	}

	public void setSolution(Solution solution) {
		this.solution = solution;
	}

}
