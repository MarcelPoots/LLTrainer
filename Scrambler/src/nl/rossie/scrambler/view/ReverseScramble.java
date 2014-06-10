package nl.rossie.scrambler.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.plaf.SplitPaneUI;

import nl.rossie.scrambler.model.Scrambler;

public class ReverseScramble extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextArea displayInput = new JTextArea();
	private JTextArea displayOutput = new JTextArea();
	private Scrambler scrambler = null;

	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() instanceof JButton){
	       
	        JButton button = (JButton)e.getSource();
	        if (button.getText().equalsIgnoreCase("Close")){
	        	System.out.println("Exit Button pressed");
				setVisible(false);
			    dispose();
	        }else if (button.getText().equalsIgnoreCase("Reverse")){
	        	System.out.println("String reversed");
	        	displayOutput.setText("New scramble is: " + scrambler.reverse(displayInput.getText()));
	        }

	    }
	}
	
	public void init(Scrambler scrambler){
		setScrambler(scrambler);
		setLayout(new BorderLayout());

		JPanel content = new JPanel();
		content.setLayout(new GridLayout(2,1));
		
		JScrollPane scrollpane = new JScrollPane(content);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		content.add(displayInput);
		
		content.add(displayOutput);
		displayInput.append("Paste here your (space separated) scramble to be reversed...");
		JPanel panelBottom = new JPanel();
		panelBottom.setPreferredSize(new Dimension(getWidth(),40));
		JButton buttonReverse = new JButton("Reverse");

		JButton buttonExit = new JButton("Close");
		panelBottom.add(buttonReverse);
		panelBottom.add(buttonExit);
		
		buttonExit.addActionListener(this);
		buttonReverse.addActionListener(this);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		getContentPane().add(panelBottom, BorderLayout.PAGE_END);
		setSize(700, 300);
		setVisible(true);
		repaint();
	}

	public Scrambler getScrambler() {
		return scrambler;
	}

	public void setScrambler(Scrambler scrambler) {
		this.scrambler = scrambler;
	}	

}
