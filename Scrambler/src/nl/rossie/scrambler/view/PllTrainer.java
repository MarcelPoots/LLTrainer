package nl.rossie.scrambler.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

import nl.rossie.scrambler.model.PLL;
import nl.rossie.scrambler.model.PllController;
import nl.rossie.scrambler.model.Solution;
import nl.rossie.scrambler.util.Painter;

public class PllTrainer extends JFrame implements ActionListener{

	private Painter painter;
	private JPanel container = new JPanel();
	private PLL pll;
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
	    if (e.getSource() instanceof JButton){
	        JButton button = (JButton)e.getSource();
	        if (button.getText().equalsIgnoreCase("Close")){
	        	System.out.println("Exit Button pressed");	        	
				setVisible(false);
			    dispose();
	        }
	    }	    
		
	}

	public void init(){
		painter = new Painter();

		pll = PllController.getCurrentPLL();
		painter.setPll(pll);

		getContentPane().removeAll();
		//pack();
		setLayout(new BorderLayout());
		
		
		
		container.setLayout(new GridLayout(1,1));
		JScrollPane scrollpane = new JScrollPane(container);
		scrollpane.setLayout(new ScrollPaneLayout());
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		
		JPanel closePanel = new JPanel();
		JButton button = new JButton("Close");
		button.setName("exit");
		button.addActionListener(this);
		closePanel.add(button);
		closePanel.setSize(this.getWidth(), 50);
		
		getContentPane().add(closePanel, BorderLayout.PAGE_END);
		setSize(600, 500);
		setVisible(true);
		repaint();		
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		painter.paintCube(container);
	}	
}
