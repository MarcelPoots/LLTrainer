package nl.rossie.scrambler.util;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Polygon;

import javax.swing.JPanel;

import nl.rossie.scrambler.model.PLL;



public class Painter {

	private final static int CUBE_SIZE = 60;
	private final static int LEFT_OFFSET = 10;
	private PLL pll;
	
	public void paintCube(JPanel panel){
		Graphics2D g2d = (Graphics2D)panel.getGraphics();
		g2d.setColor(Color.GRAY);
		g2d.fillRect(0, 0, panel.getWidth(), panel.getHeight());
        for (int col=0; col < 3; col++){
        	for (int row=0; row < 3; row++){
        		paintSquare(g2d,  col, row );
        	}
        }
	}
	

	private Color colorByNumber(int i){
		char c = pll.getColors().charAt(i);
		switch(c){
		case'F':return Color.GREEN;
		case'R':return Color.RED;
		case'B':return Color.BLUE;
		case'L':return Color.ORANGE;
		default:return Color.BLACK;
		}
		
	}
	
	private void paintSquare(Graphics2D g2d, int col, int row) {
		BasicStroke stroke = new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
		g2d.setStroke(stroke);
		g2d.setColor(Color.WHITE);
		
		g2d.setColor(colorByNumber(0));
		g2d.fillRoundRect(LEFT_OFFSET, 15, CUBE_SIZE, CUBE_SIZE, 10, 10);		
		g2d.setColor(colorByNumber(1));
		g2d.fillRoundRect(LEFT_OFFSET + (1 * CUBE_SIZE) + 5, 15, CUBE_SIZE, CUBE_SIZE, 10, 10);
		g2d.setColor(colorByNumber(2));
		g2d.fillRoundRect(LEFT_OFFSET + (2 * CUBE_SIZE) + 10, 15, CUBE_SIZE, CUBE_SIZE, 10, 10);


		g2d.setColor(colorByNumber(3));
		g2d.fillRoundRect(LEFT_OFFSET + (3 * CUBE_SIZE) + 15, 15, CUBE_SIZE, CUBE_SIZE, 10, 10);
		g2d.setColor(colorByNumber(4));
		g2d.fillRoundRect(LEFT_OFFSET + (4 * CUBE_SIZE) + 20, 15, CUBE_SIZE, CUBE_SIZE, 10, 10);
		g2d.setColor(colorByNumber(5));
		g2d.fillRoundRect(LEFT_OFFSET + (5 * CUBE_SIZE) + 25, 15, CUBE_SIZE, CUBE_SIZE, 10, 10);
		
		
	}


	public PLL getPll() {
		return pll;
	}


	public void setPll(PLL pll) {
		this.pll = pll;
	}
}
