/**
 * Marcel Poots
 */
package nl.rossie.scrambler.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import nl.rossie.scrambler.model.Scramble;

/**
 * @author D352019
 *
 */
public class JResultLabel extends JLabel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Scramble scramble;
	
	
	public JResultLabel(ImageIcon icon, Scramble scramble){
		super(icon);
		setScramble(scramble);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/**
	 * @return the scramble
	 */
	public Scramble getScramble() {
		return scramble;
	}

	/**
	 * @param scramble the scramble to set
	 */
	public void setScramble(Scramble scramble) {
		this.scramble = scramble;
	}
	
	

}
