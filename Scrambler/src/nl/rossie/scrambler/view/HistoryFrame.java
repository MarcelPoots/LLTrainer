/**
 * Marcel Poots
 */
package nl.rossie.scrambler.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import nl.rossie.scrambler.model.Scrambler;

/**
 * @author MarcelP
 *
 */
public class HistoryFrame extends JFrame implements ActionListener{

	private Scrambler scrambler;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() instanceof JButton){
	        System.out.println("Exit Button pressed");
	        JButton button = (JButton)e.getSource();
	        if (button.getText().equalsIgnoreCase("Close")){
				setVisible(false);
			    dispose();
	        }
	    }
	}

	public void init(Scrambler scrambler){
		setLayout(new BorderLayout());
		String tekst = scrambler.getHistory();
		JTextArea display = new JTextArea();
		JScrollPane scrollpane = new JScrollPane(display);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		display.append(tekst);
		JPanel panelBottom = new JPanel();
		panelBottom.setPreferredSize(new Dimension(getWidth(),40));
		JButton buttonExit = new JButton("Close");
		panelBottom.add(buttonExit);
		buttonExit.addActionListener(this);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		getContentPane().add(panelBottom, BorderLayout.PAGE_END);
		setScrambler(scrambler);
		setSize(500, 300);
		setVisible(true);
		repaint();
	}

	/**
	 * @return the scrambler
	 */
	public Scrambler getScrambler() {
		return scrambler;
	}

	/**
	 * @param scrambler the scrambler to set
	 */
	public void setScrambler(Scrambler scrambler) {
		this.scrambler = scrambler;
	}
}
