package nl.rossie.scrambler.model;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import nl.rossie.scrambler.view.ScramblerView;

public class ScrambleKeyListener implements KeyListener {

	private ScramblerView mainWindow; 
	
	public ScrambleKeyListener(ScramblerView frame){
		mainWindow = frame;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		mainWindow.toggleTimer();
	}


}
