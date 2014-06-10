/**
 * Marcel Poots
 */
package nl.rossie.scrambler.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DateFormatter;

import nl.rossie.scrambler.consts.ScramblerConsts;
import nl.rossie.scrambler.model.Scrambler;

/**
 * @author MarcelP
 *
 */
public class AveragesFrame extends JFrame implements ActionListener{

	private Scrambler scrambler;
	private JTextArea display = new JTextArea();
	private JFormattedTextField fromDateField = null;
	private JFormattedTextField untillDateField = null;
	private JComboBox comboBox = null;
	
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
	        JButton button = (JButton)e.getSource();
	        String text = "";
	        if (button.getText().equalsIgnoreCase("Refresh")){
	        	try{
	        		text = scrambler.getAverages( (Date)fromDateField.getValue() , (Date)untillDateField.getValue(), comboBox.getSelectedItem().toString() );
	        	}catch(Exception error){
	        		text = "SQL Error : " + error.getMessage();
	        	}
	        	display.setText(text);
	        }
	        
	        if (button.getText().equalsIgnoreCase("Close")){
	        	System.out.println("Exit Button pressed");	        	
				setVisible(false);
			    dispose();
	        }
	    }
	}

	public void init(Scrambler scrambler){
		setLayout(new BorderLayout());
		String tekst = "Press refresh to collect data..";
		
		JScrollPane scrollpane = new JScrollPane(display);
		scrollpane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		display.append(tekst);
		
		JPanel panelTop = new JPanel();
		panelTop.setPreferredSize(new Dimension(getWidth(),30));
		panelTop.setLayout(new GridLayout(1,5));
		
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");   
		DateFormatter formatter = new DateFormatter(dateFormat);   
		formatter.setAllowsInvalid(false);   
		formatter.setOverwriteMode(true); 
		
		JLabel fromLabel = new JLabel("From:"); 
		fromDateField = new JFormattedTextField(formatter);
		
		Calendar c = Calendar.getInstance(); 
		c.add(Calendar.DATE, -1);
		Date startDate =  c.getTime();
		
		fromDateField.setValue(startDate);

		JLabel untillLabel = new JLabel("Untill:");
		untillDateField = new JFormattedTextField(formatter);
		untillDateField.setValue(Calendar.getInstance().getTime());
		
		JButton buttonRefresh = new JButton("Refresh");
		
		panelTop.add(fromLabel);
		panelTop.add(fromDateField);

		panelTop.add(untillLabel);
		panelTop.add(untillDateField);
		
		
		comboBox = new JComboBox(ScramblerConsts.OPTIONS);
		comboBox.addActionListener(this);
		
		panelTop.add(comboBox);
		panelTop.add(buttonRefresh);
		
		
		buttonRefresh.addActionListener(this);
		
		JPanel panelBottom = new JPanel();
		panelBottom.setPreferredSize(new Dimension(getWidth(),40));
		JButton buttonExit = new JButton("Close");
		panelBottom.add(buttonExit);
		buttonExit.addActionListener(this);
		
		getContentPane().add(panelTop, BorderLayout.PAGE_START);
		getContentPane().add(scrollpane, BorderLayout.CENTER);
		getContentPane().add(panelBottom, BorderLayout.PAGE_END);
		setScrambler(scrambler);
		setSize(600, 600);
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
