package nl.rossie.scrambler.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ScrollPaneLayout;

import nl.rossie.scrambler.consts.ScramblerConsts;
import nl.rossie.scrambler.model.Scrambler;
import nl.rossie.scrambler.model.Solution;
import nl.rossie.scrambler.util.FileUtil;

public class ManageFrame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Scrambler scrambler = null;
	private ArrayList<Solution> list = null;	
	
	private JPanel optionChoise = null;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox = null;
	private JLabel selectLabel = null;
	private JButton buttonUncheck = null;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public ManageFrame(){
		optionChoise = new JPanel();
		comboBox = new JComboBox(ScramblerConsts.OPTIONS);
		comboBox.addActionListener(this);
		optionChoise.setSize(this.getWidth(), 50);
		selectLabel = new JLabel("Options  of:");
		buttonUncheck = new JButton("uncheck all");
		buttonUncheck.setName("uncheck");
		buttonUncheck.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() instanceof JComboBox){
	        @SuppressWarnings("rawtypes")
			JComboBox cb = (JComboBox)e.getSource();
	        String type = (String)cb.getSelectedItem();
	        System.out.println(type + "selected");
	        selectList(type);
	        init();
		}else if (e.getSource() instanceof JButton){
	        System.out.println("Button pressed");
	        JButton button = (JButton)e.getSource();
	        if (button.getName().equalsIgnoreCase("exit")){
		        FileUtil fu = new FileUtil();
		        try {
					fu.writeToFile("algsOLL.txt", scrambler,ScramblerConsts.OLL);
					fu.writeToFile("algsF2L.txt", scrambler,ScramblerConsts.F2L);
					fu.writeToFile("algsF2LE.txt", scrambler,ScramblerConsts.F2LE);
					fu.writeToFile("algsWV.txt", scrambler,ScramblerConsts.WV);
					fu.writeToFile("algsPLL.txt", scrambler,ScramblerConsts.PLL);
					fu.writeToFile("algsCLL.txt", scrambler,ScramblerConsts.CLL);
					fu.writeToFile("algsCMLL.txt", scrambler,ScramblerConsts.CMLL);
					fu.writeToFile("algsCOLL.txt", scrambler,ScramblerConsts.COLL);
					fu.writeToFile("algsZBLLH.txt", scrambler,ScramblerConsts.ZBLLH);
					fu.writeToFile("algsEG-1.txt", scrambler,ScramblerConsts.EG1);
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "Error writing to Algoritm file : " + e1.getMessage(),"ERROR", 1);
				}
				setVisible(false);
			    dispose();
	        }else if (button.getName().equalsIgnoreCase("uncheck")){
	        	for (Solution solution: list){
	        		solution.setEnabled(false);
	        	}
	        	init();
	        }
		}else if (e.getSource() instanceof ScramblerCheckbox){
			ScramblerCheckbox checkbox = (ScramblerCheckbox)e.getSource();
			checkbox.getSolution().setEnabled(checkbox.isSelected());
			updateTitle();
		}
		
	}
	
	private void updateTitle(){
		int selected = 0;
		for (Solution solution: list){
			if (solution.isEnabled()){
				selected++;
			}
		}
		setTitle("Selected " + selected + " out of " + list.size()  + " " +  comboBox.getSelectedItem().toString() + "s" );
	}

	private void selectList(String type){
		if (type.equalsIgnoreCase(ScramblerConsts.OLL_STRING )){
			list = scrambler.getSolutionsOLL();
		}else if (type.equalsIgnoreCase(ScramblerConsts.PLL_STRING)){
			list = scrambler.getSolutionsPLL();
		}else if (type.equalsIgnoreCase(ScramblerConsts.F2L_STRING)){
			list = scrambler.getSolutionsF2L();
		}else if (type.equalsIgnoreCase(ScramblerConsts.F2LE_STRING)){
			list = scrambler.getSolutionsF2LE();
		}else if (type.equalsIgnoreCase(ScramblerConsts.WV_STRING)){
			list = scrambler.getSolutionsWV();
		}else if (type.equalsIgnoreCase(ScramblerConsts.CLL_STRING)){
			list = scrambler.getSolutionsCLL();
		}else if (type.equalsIgnoreCase(ScramblerConsts.CMLL_STRING)){
			list = scrambler.getSolutionsCMLL();
		}else if (type.equalsIgnoreCase(ScramblerConsts.COLL_STRING)){
			list = scrambler.getSolutionsCOLL();
		}else if (type.equalsIgnoreCase(ScramblerConsts.ZBLLH_STRING)){
			list = scrambler.getSolutionsZBLLH();
		}else if (type.equalsIgnoreCase(ScramblerConsts.EG1_STRING)){
			list = scrambler.getSolutionsEG1();
		}else if (type.equalsIgnoreCase(ScramblerConsts.DEF_STRING)){
			list = scrambler.getSolutionsDef();
		}
	}
	
	private void init(){
		getContentPane().removeAll();
		//pack();
		setLayout(new BorderLayout());
		
		optionChoise.add(selectLabel);
		optionChoise.add(comboBox);
		optionChoise.add(buttonUncheck);
		
		getContentPane().add(optionChoise, BorderLayout.PAGE_START);
		
		JPanel container = new JPanel();
		selectList(comboBox.getSelectedItem().toString());
		container.setLayout(new GridLayout(list.size(),1));
		JScrollPane scrollpane = new JScrollPane(container);
		scrollpane.setLayout(new ScrollPaneLayout());
		scrollpane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		int imageCount = 1;
		for (Solution solution: list){
			JPanel panel = new JPanel();
			panel.setSize(this.getWidth(), 50);
			panel.setLayout(new BorderLayout());
			
			JLabel labelName = new JLabel("   " + solution.getReverse());
			labelName.setSize(100, 50);
			labelName.setForeground(Color.PINK);
			Font font = new Font("Arial", 1, 9);
			
			labelName.setFont(font);
			ScramblerCheckbox checkbox = new ScramblerCheckbox(solution.getName() + " (" + solution.getAlgoritm() + ")" ,solution);
			checkbox.addActionListener(this);
			
			checkbox.setSize(50, 50);
			checkbox.setSelected(solution.isEnabled());
			
			panel.add(checkbox,BorderLayout.PAGE_START);
			panel.add(labelName,BorderLayout.EAST);
			
			BufferedImage wp = null;
			JLabel imageLabel = null;
			
            // try to read from file in working directory
			String filename = "img/" + comboBox.getSelectedItem().toString() + imageCount +  ".png";
			
			// First try and see if user has put images in folder himself.
            File file = new File(filename);
            if (file.isFile()) {
            	try {
					wp = ImageIO.read(file);
				} catch (IOException e) {
					//
				}
            }
			if(wp == null){
				// No user image. Then get from resource
				filename =  "/"+ comboBox.getSelectedItem().toString() + imageCount +  ".png";
				try {
					wp = ImageIO.read(this.getClass().getResource(filename));
				} catch (Exception e) {
					try{
						wp = ImageIO.read(this.getClass().getResource("/no_image.png"));
					}catch(Exception e2){
						wp = null;
					}
				}
			}
						
			if (wp != null){
				imageLabel = new JLabel(new ImageIcon(wp));
				imageLabel.setOpaque(true);
				panel.add(imageLabel,BorderLayout.CENTER);
			}
			
		//	panel.add(labelAlg,BorderLayout.PAGE_END);
			container.add(panel);
			imageCount++;
		}
		
		JPanel closePanel = new JPanel();
		JButton button = new JButton("Save and close");
		button.setName("exit");
		button.addActionListener(this);
		closePanel.add(button);
		closePanel.setSize(this.getWidth(), 50);
		
		getContentPane().add(closePanel, BorderLayout.PAGE_END);
		updateTitle();
		setSize(400, 700);
		setVisible(true);
		repaint();
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	public Scrambler getScrambler() {
		return scrambler;
	}

	public void setScrambler(Scrambler scrambler) {
		this.scrambler = scrambler;
		init(); // Setting scrambler is trigger
	}
}
