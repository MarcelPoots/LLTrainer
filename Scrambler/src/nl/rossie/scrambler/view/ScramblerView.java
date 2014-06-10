package nl.rossie.scrambler.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import nl.rossie.scrambler.consts.ScramblerConsts;
import nl.rossie.scrambler.model.Scramble;
import nl.rossie.scrambler.model.ScrambleKeyListener;
import nl.rossie.scrambler.model.Scrambler;
import nl.rossie.scrambler.util.FileUtil;
import nl.rossie.scrambler.util.TimeDisplayUtil;

public class ScramblerView extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private static ScramblerView sv    = null;
	JButton[]    button = new JButton[1];
	JTextPane  display  = new JTextPane();
	String[] buttonText = {"Press spacebar.."};
	Scrambler scrambler = new Scrambler();
	UIUpdater uiupdater = null;
	Long startTime      = new Long(0);
	Long lastStopTime  = new Long(0);
	Scramble scramble   = null;
	@SuppressWarnings("rawtypes")
	JList list          = new JList();
	JTextArea text      = new JTextArea("");  
	JTextArea averages  = new JTextArea("");
	JPanel imagePanel   = new JPanel();
	JPanel resultPanels = new JPanel();
	JScrollPane scrollpane = new JScrollPane(resultPanels); 
	JRadioButtonMenuItem rbMenuItemOLL    = new JRadioButtonMenuItem("OLL training");
	JRadioButtonMenuItem rbMenuItemF2L    = new JRadioButtonMenuItem("F2L training");
	JRadioButtonMenuItem rbMenuItemF2LE    = new JRadioButtonMenuItem("F2L expert");
	JRadioButtonMenuItem rbMenuItemPLL    = new JRadioButtonMenuItem("PLL training");
	JRadioButtonMenuItem rbMenuItemWV     = new JRadioButtonMenuItem("Wintervariation (WV) training");
	JRadioButtonMenuItem rbMenuItemCOLL   = new JRadioButtonMenuItem("COLL training");
	JRadioButtonMenuItem rbMenuItemCMLL   = new JRadioButtonMenuItem("CMLL training");
	JRadioButtonMenuItem rbMenuItemCLL    = new JRadioButtonMenuItem("CLL training");
	JRadioButtonMenuItem rbMenuItemZBLLH  = new JRadioButtonMenuItem("ZBLL-H training");
	JRadioButtonMenuItem rbMenuItemEG1    = new JRadioButtonMenuItem("EG-1 training");
	JRadioButtonMenuItem rbMenuItemDef    = new JRadioButtonMenuItem("Default");
	JRadioButtonMenuItem rbMenuItem3X3    = new JRadioButtonMenuItem("Normal 3 X 3");
	JRadioButtonMenuItem rbMenuItem2X2    = new JRadioButtonMenuItem("Normal 2 X 2");
	JCheckBoxMenuItem    cbMenuItemOrient = new JCheckBoxMenuItem("mis-orient U-layer",false);
	

	private boolean started = false;;
	int count           = 1;
	
	/**
	 * Constructor
	 */
	public ScramblerView(){
		try {
			FileUtil fu = new FileUtil();
			fu.readAlgsFromFile(scrambler, ScramblerConsts.OLL);
			fu.readAlgsFromFile(scrambler, ScramblerConsts.F2L);
			fu.readAlgsFromFile(scrambler, ScramblerConsts.F2LE);
			fu.readAlgsFromFile(scrambler, ScramblerConsts.PLL);
			fu.readAlgsFromFile(scrambler, ScramblerConsts.WV);
			fu.readAlgsFromFile(scrambler, ScramblerConsts.COLL);
			fu.readAlgsFromFile(scrambler, ScramblerConsts.CMLL);
			fu.readAlgsFromFile(scrambler, ScramblerConsts.CLL);
			fu.readAlgsFromFile(scrambler, ScramblerConsts.ZBLLH);
			fu.readAlgsFromFile(scrambler, ScramblerConsts.EG1);
			fu.readAlgsFromFile(scrambler, ScramblerConsts.DEFAULT);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Error opening algs file : " + e.getMessage(),"ERROR", 1);
		}
		Random rand = new Random(Calendar.getInstance().getTimeInMillis());
		scrambler.setRandom(rand);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(900,600));
		panel.setLayout(new GridLayout(3,1));
		button[0] = new JButton();
		button[0].setText(buttonText[0]);
		Font f = new Font("Arial", 1, 60);
		button[0].setForeground(Color.PINK); 
		button[0].setFont(f);
		panel.add(button[0]);
		button[0].setPreferredSize(new Dimension(900,60));
		button[0].addActionListener(this);
		Font font = new Font("Arial", Font.BOLD, 30);
		display.setFont(font);
		display.setBackground(Color.black);
		display.setForeground(Color.green);
		display.setEditable(false);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		StyledDocument doc = display.getStyledDocument();
		SimpleAttributeSet center = new SimpleAttributeSet();
		StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
		doc.setParagraphAttributes(0, doc.getLength(), center, false);
		
		display.setPreferredSize(new Dimension(900,10));
		panel.add(display, BorderLayout.NORTH);
		button[0].setFocusable(false);
		
		getRootPane().setDefaultButton(button[0]);
		panel.add(button[0], BorderLayout.NORTH);
		
		JMenu file = new JMenu("File");
		file.setMnemonic('F');
		
		//a group of radio button menu items
		ButtonGroup group = new ButtonGroup();
		rbMenuItemOLL.setSelected(true);
		group.add(rbMenuItemOLL);
		file.add(rbMenuItemOLL);		

		rbMenuItemF2L.setSelected(false);
		group.add(rbMenuItemF2L);
		file.add(rbMenuItemF2L);		

		rbMenuItemF2LE.setSelected(false);
		group.add(rbMenuItemF2LE);
		file.add(rbMenuItemF2LE);		
		
		rbMenuItemPLL.setSelected(false);
		group.add(rbMenuItemPLL);
		file.add(rbMenuItemPLL);		

		rbMenuItemWV.setSelected(false);
		group.add(rbMenuItemWV);
		file.add(rbMenuItemWV);		
		
		rbMenuItemCOLL.setSelected(false);
		group.add(rbMenuItemCOLL);
		file.add(rbMenuItemCOLL);		

		rbMenuItemCMLL.setSelected(false);
		group.add(rbMenuItemCMLL);
		file.add(rbMenuItemCMLL);		

		rbMenuItemCLL.setSelected(false);
		group.add(rbMenuItemCLL);
		file.add(rbMenuItemCLL);		

		rbMenuItemZBLLH.setSelected(false);
		group.add(rbMenuItemZBLLH);
		file.add(rbMenuItemZBLLH);		
		
		rbMenuItemEG1.setSelected(false);
		group.add(rbMenuItemEG1);
		file.add(rbMenuItemEG1);		
		
		file.addSeparator();

		rbMenuItemDef.setSelected(false);
		group.add(rbMenuItemDef);
		file.add(rbMenuItemDef);		
		
		file.addSeparator();

		rbMenuItem3X3.setSelected(false);
		group.add(rbMenuItem3X3);
		file.add(rbMenuItem3X3);		

		rbMenuItem2X2.setSelected(false);
		group.add(rbMenuItem2X2);
		file.add(rbMenuItem2X2);		

		
		file.addSeparator();		
		JMenuItem exitPLLTrainer = new JMenuItem("PLL Trainer");
		exitPLLTrainer.setMnemonic('P');
		file.add(exitPLLTrainer);		
		
		file.addSeparator();		
		JMenuItem exitItem = new JMenuItem("Exit");
		exitItem.setMnemonic('X');
		file.add(exitItem);

		JMenu options = new JMenu("Options");
		options.setMnemonic('O');
		
		JMenuItem resetItem = new JMenuItem("Reset statistiscs");
		resetItem.setMnemonic('R');
		options.add(resetItem);

		JMenuItem manageItem = new JMenuItem("Manage settings");
		manageItem.setMnemonic('M');
		options.add(manageItem);

		JMenuItem reverseItem = new JMenuItem("Reverse a scramble");
		reverseItem.setMnemonic('S');
		options.add(reverseItem);
		
		JMenuItem historyItem = new JMenuItem("Show session history");
		historyItem.setMnemonic('H');
		options.add(historyItem);

		JMenuItem averagesItem = new JMenuItem("Show averages history");
		averagesItem.setMnemonic('A');
		options.add(averagesItem);
		
		cbMenuItemOrient.setMnemonic('O');
		options.add(cbMenuItemOrient);
		
		exitItem.addActionListener(
			new ActionListener(){
				public void actionPerformed(ActionEvent e)
				{
					System.out.println("Exit is pressed");
					setVisible(false);
				    dispose();
				    System.exit(0); 
					
				}
			}
		);	

		exitPLLTrainer.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("PLL trainer is pressed");
						PllTrainer plltrainer = new PllTrainer();
						plltrainer.init();
					}
				}
			);	
		
		resetItem.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("reset is pressed");
						reset();
						
					}
				}
			);	

		manageItem.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Manage is pressed");
						ManageFrame mf = new ManageFrame();
						URL imgURL = getClass().getResource( "/avatar.png");
						Image image = null;
						try {
							image = ImageIO.read(imgURL);
						} catch (IOException e2) {}
						if(image != null){
							mf.setIconImage(image);
						}
						mf.setScrambler(scrambler);
						
					}
				}
			);
		reverseItem.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Reverse is pressed");
						ReverseScramble rs = new ReverseScramble();
						URL imgURL = getClass().getResource( "/avatar.png");
						Image image = null;
						try {
							image = ImageIO.read(imgURL);
						} catch (IOException e2) {}
						if(image != null){
							rs.setIconImage(image);
						}
						rs.init(scrambler);
					}
				}
			);			
		
		historyItem.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("History is pressed");
						HistoryFrame hf = new HistoryFrame();
						URL imgURL = getClass().getResource( "/avatar.png");
						Image image = null;
						try {
							image = ImageIO.read(imgURL);
						} catch (IOException e2) {}
						if(image != null){
							hf.setIconImage(image);
						}
						hf.init(scrambler);
						
					}
				}
			);	

		averagesItem.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Averages-History is pressed");
						AveragesFrame af = new AveragesFrame();
						URL imgURL = getClass().getResource( "/avatar.png");
						Image image = null;
						try {
							image = ImageIO.read(imgURL);
						} catch (IOException e2) {}
						if(image != null){
							af.setIconImage(image);
						}
						af.init(scrambler);
						
					}
				}
			);	
		
		
		
		
		rbMenuItemOLL.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("OLL is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItemF2L.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("F2L is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItemF2LE.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("F2LE is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		cbMenuItemOrient.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Orient U layer is pressed");
						scrambler.setMisOrientULayer(cbMenuItemOrient.getState());
					}
				}
			);	
		
		rbMenuItemPLL.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("PLL is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItemWV.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("WV is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItemCOLL.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("COLL is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItemCMLL.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("CMLL is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItemCLL.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("CLL is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItemZBLLH.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("ZBLL-H is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItemEG1.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("EG-1 is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItemDef.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("Default is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItem3X3.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("3 X 3 is pressed");
						reset();
						updateDisplay();
					}
				}
			);	
		rbMenuItem2X2.addActionListener(
				new ActionListener(){
					public void actionPerformed(ActionEvent e)
					{
						System.out.println("2 X 2 is pressed");
						reset();
						updateDisplay();
					}
				}
			);	

		
		JMenuBar bar = new JMenuBar();
		setJMenuBar(bar);
		bar.add(file);
		bar.add(options);
			
		JPanel resultPanel = new JPanel();
		resultPanel.setLayout(new GridLayout(1,2));
		resultPanel.setPreferredSize(new Dimension(900,600));
		
		
		resultPanels.setLayout(new BoxLayout(resultPanels, BoxLayout.Y_AXIS)); 
        //scrollpane.setLayout(new FlowLayout() );
		//list.add(text);		
		scrollpane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    resultPanel.add(scrollpane,BorderLayout.WEST);
	    resultPanel.add(imagePanel,BorderLayout.CENTER);
	    averages.setBorder(BorderFactory.createLineBorder(Color.darkGray));
	    resultPanel.add(averages,BorderLayout.EAST);
	    panel.add(resultPanel,BorderLayout.SOUTH);
	    pack();

	    //Now all visual elements in de the main window must handle the spacebar as a toggle":
		display.addKeyListener(new ScrambleKeyListener(this));
		averages.addKeyListener(new ScrambleKeyListener(this));
	    text.addKeyListener(new ScrambleKeyListener(this));
	    button[0].addKeyListener(new ScrambleKeyListener(this));
	    panel.addKeyListener(new ScrambleKeyListener(this));
	    
	    updateDisplay();
	}
	
	private void reset(){
		count = 1;
    	resultPanels.removeAll(); //remove all panels
    	resultPanels.repaint();
		scrambler.clearScrambles();
		averages.setText(scrambler.getAveragesText()); 
		text.setText("");
	}
	
	private int getScrambleOption(){
		if (rbMenuItemOLL.isSelected()){
			return ScramblerConsts.OPTION_OLL; 
		}else if (rbMenuItemF2L.isSelected()){
			return ScramblerConsts.OPTION_F2L;
		}else if (rbMenuItemF2LE.isSelected()){
			return ScramblerConsts.OPTION_F2LE;
		}else if (rbMenuItemPLL.isSelected()){
			return ScramblerConsts.OPTION_PLL;
		}else if (rbMenuItemWV.isSelected()){
			return ScramblerConsts.OPTION_WV;
		}else if (rbMenuItemCOLL.isSelected()){
			return ScramblerConsts.OPTION_COLL;
		}else if (rbMenuItemCMLL.isSelected()){
			return ScramblerConsts.OPTION_CMLL;
		}else if (rbMenuItemZBLLH.isSelected()){
			return ScramblerConsts.OPTION_ZBLLH;
		}else if (rbMenuItemEG1.isSelected()){
			return ScramblerConsts.OPTION_EG1;
		}else if (rbMenuItemDef.isSelected()){
			return ScramblerConsts.OPTION_DEFAULT;
		}else if (rbMenuItemCLL.isSelected()){
			return ScramblerConsts.OPTION_CLL;
		}else if (rbMenuItem3X3.isSelected()){
			return ScramblerConsts.OPTION_3X3;
		}else if (rbMenuItem2X2.isSelected()){
			return ScramblerConsts.OPTION_2X2;
		}else{
			return ScramblerConsts.OPTION_OLL; // default is OLL trainer
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		sv = new ScramblerView();
		sv.setSize(900, 600);
		sv.setVisible(true);
		URL imgURL = sv.getClass().getResource( "/avatar.png");
		Image image = null;
		try {
			image = ImageIO.read(imgURL);
		} catch (IOException e) {}		
		sv.setIconImage(image);
		sv.setDefaultCloseOperation(EXIT_ON_CLOSE);
		sv.requestFocusInWindow();
		sv.addKeyListener(new ScrambleKeyListener(sv)); 
	}

	@SuppressWarnings("deprecation")
	public void toggleTimer(){
		System.out.println("toggle ");
		if (!isStarted()){
			
			if (Calendar.getInstance().getTimeInMillis() - lastStopTime > 1000 ){
				// At least 1000 milisecs have passed.. to double hit on space bar has no effect.
				scramble.setIndex(count++);
				Font f = new Font("Arial", 1, 100);
				button[0].setFont(f);				
				startTime = Calendar.getInstance().getTimeInMillis();
				setStarted(true); 
				if(uiupdater == null){
					uiupdater = new UIUpdater();
					uiupdater.start();
				}
				uiupdater.setRun(true);	
				uiupdater.resume();
			}
			
		}else{
			
			setStarted(false);
			uiupdater.setRun(false);

			scrambler.addScramble(scramble);
			averages.setText(scrambler.getAveragesText()); // Calc averages
			text.setText(scramble.getIndex() + ". "+  scramble.getTime() +  " " + scramble.getScramble() + ScramblerConsts.NEW_LINE + text.getText());
			lastStopTime = Calendar.getInstance().getTimeInMillis();
			
			JPanel resPanel = new JPanel(new BorderLayout(1, 2));
			resPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
 			resPanel.setPreferredSize(new Dimension(resultPanels.getWidth(),30));
			JLabel textLabel2 = new JLabel(" " + scramble.getIndex() + ". " +  scramble.getTime() + " " + scramble.getScramble());
			resPanel.add(textLabel2,BorderLayout.CENTER);
			
	        BufferedImage wp = null;
			try {
				wp = ImageIO.read(this.getClass().getResource("/close.png"));
			} catch (Exception e) {
				//
			}
						
			if (wp != null){
				JResultLabel imageLabel = new JResultLabel(new ImageIcon(wp), scramble);
				imageLabel.addMouseListener(new MouseListener() {

			        public void mouseClicked(MouseEvent e) {
			        	JResultLabel res = (JResultLabel)e.getSource();
			        	JPanel parent = (JPanel)res.getParent();
			        	System.out.println("Scrambles " + scrambler.getScrambles().size() + " panel: " + resultPanels.countComponents());
			        	scrambler.getScrambles().remove(res.getScramble());
			        	resultPanels.remove(parent); //remove panel
			        	resultPanels.repaint();
			        	averages.setText(scrambler.getAveragesText()); // Opnieuw
 			            //JOptionPane.showMessageDialog(null,"Scrambles " + scrambler.getScrambles().size() + " panel: " + resultPanels.countComponents());
			        }

			        public void mousePressed(MouseEvent e) {
			        }
			        public void mouseReleased(MouseEvent e) {
			        }
			        public void mouseEntered(MouseEvent e) {
			        }
			        public void mouseExited(MouseEvent e) {
			        }
			    });
			        
				imageLabel.setPreferredSize(new Dimension(30,30));
				resPanel.add(imageLabel,BorderLayout.EAST);
			}
			
			resultPanels.add(resPanel,0); 
			updateDisplay();
			uiupdater.setRun(false);
			////button[0].setText(time);
		}
	}
		

	private void updateDisplay(){
		scramble = scrambler.scrambleByOption(getScrambleOption());
		placeImage(scramble.getImageFileName());
		display.setToolTipText("Solution " + scramble.getHint() );
		String name = (scramble.getName() != null ? scramble.getName() :"" );
		display.setText(ScramblerConsts.NEW_LINE + scramble.getScramble() + 
				ScramblerConsts.NEW_LINE + 
				ScramblerConsts.NEW_LINE + name );
		this.setTitle(ScramblerConsts.APP_NAME + " "  + ScramblerConsts.VERSION +  " (solution: " + scramble.getHint() + ")" );
		
		if(uiupdater != null && uiupdater.isAlive()){
			uiupdater.setRun(false);
		}
	}

	private void placeImage(String filename){
		imagePanel.removeAll();

		if(filename != null){
			// First try and see if user has put images in folder himself.
 	        File file = new File(filename);
	        BufferedImage wp = null;
			if (file.isFile()) {
	        	try {
					wp = ImageIO.read(file);
				} catch (IOException e) {
					//
				}
	        }
			if(wp == null){
				// No user image. Then get from resource
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
				imagePanel.setLayout(new GridLayout(1,1));
				JLabel imageLabel = new JLabel(new ImageIcon(wp));
				imageLabel.setPreferredSize(new Dimension(140,140));
				imageLabel.setOpaque(true);
				imagePanel.add(imageLabel);
				JPanel namePanel = new JPanel();
				namePanel.setPreferredSize(new Dimension(140,20));
				namePanel.setLayout(new GridBagLayout());
				JLabel nameLabel = new JLabel(scramble.getName() != null ? scramble.getName() :"" );
				namePanel.add(nameLabel);
				//imagePanel.add(namePanel);
			}
		}
		
	}
	
	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	class UIUpdater extends Thread {
		
		private boolean run = false;
		
		@Override
		public void run() {
			Calendar c = Calendar.getInstance();  
	  		Long now = Calendar.getInstance().getTimeInMillis();
	  		//startTime = Calendar.getInstance().getTimeInMillis();
			Long difference = new Long(0);//now - startTime; 
		    while (true) {
		      try {
		        // Update variables here
		    	    if (isRun()){
				  		now = Calendar.getInstance().getTimeInMillis();
						difference = now - startTime;
						c.setTimeInMillis(difference);
						scramble.setTime(TimeDisplayUtil.longToTimeString(difference));
						button[0].setText(scramble.getTime());
						scramble.setResult(difference);
						
		    	    }
		      }
		      catch (Exception e) {
		    	  System.out.println("Error: " + e);
		      }
		      finally {
		          try {
					    Thread.sleep(10);
				  } catch (InterruptedException e) {
				    	e.printStackTrace();
				}
		      }
		    }
		  }
		  
			public synchronized  boolean isRun() {
				return run;
			}
			public synchronized  void setRun(boolean run) {
				this.run = run;
			}
		}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
