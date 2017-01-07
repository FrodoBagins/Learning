import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioPanelBuilder implements Builder{
	
	private JPanel panel=new JPanel();
	
	static JButton exitButton = new JButton();
	static JButton checkButton = new JButton();
	static JButton nextButton = new JButton();
	static JButton prevButton = new JButton();
	static JPanel panel2 = new JPanel();
	
	
	private IWord selectedAnswer;
	private ButtonGroup group;
	

	@Override
	public void addQuestion(String quest) {
		panel.setLayout(new BorderLayout());
		
		
		
		JLabel gameLabel = new JLabel(quest,JLabel.CENTER);
		panel.add(gameLabel,BorderLayout.NORTH);
		
		
	}

	@Override
	public void addAnswer(IWord answer) {
		
		group = new ButtonGroup();
		
	     JPanel controlPanel = new JPanel();
	     controlPanel.setLayout(new GridLayout(4, 1));
	     
		JPanel panel2 = new JPanel();
		GridLayout layout2 = new GridLayout(3, 3);
		panel2.setLayout(layout2);
	
		
		JRadioButton radio1 = new JRadioButton("odpowied 1");
		JRadioButton radio2 = new JRadioButton("odpowiedz 2");
		//JRadioButton radio3 = new JRadioButton("odpowied 3");
	    
	      group.add(radio1);
	      group.add(radio2);
	      
		     controlPanel.add(radio1);
		     controlPanel.add(radio2);
	      
	      
	      
	    if(Program.getLevel()==2) {
	    	
	    	JRadioButton radio3 = new JRadioButton("odpowied 3");
	    	JRadioButton radio4 = new JRadioButton("odpoeiwd 4");
	    	group.add(radio3);
	    	group.add(radio4);
	    	controlPanel.add(radio3);
	    	controlPanel.add(radio4);
	    	
	    }
	      
	     panel.add(controlPanel,BorderLayout.CENTER);
	    		
	}

	@Override
	public void addButton(String button) {
		

		
		
		
		if(button.equals("EXIT"))
		{	exitButton.setText("EXIT");   	
		
        ActionListener exitListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			
					System.out.println("EXIT");
		 }	};	 		
			
		 
		exitButton.addActionListener(exitListener);		
		panel2.add(exitButton);
		
		}
		
		
		
		
		if(button.equals("CHECK"))
		{	checkButton.setText("CHECK");   	
		
        ActionListener checkListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			


					System.out.println("CHECK");
			 }				   	        		      	 
			};	 		
			
			checkButton.addActionListener(checkListener);		
			panel2.add(checkButton);
		}
		
		
		
		
		if(button.equals("NEXT"))
		{	nextButton.setText("NEXT");   	
		
        ActionListener nextListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			


					System.out.println("NEXT");
			 }				   	        		      	 
			};	 		
			
			nextButton.addActionListener(nextListener);		
			panel2.add(nextButton);
		}
		
		
		
		
		if(button.equals("PREV"))
		{	prevButton.setText("PREV");   	
		
        ActionListener prevListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			


					System.out.println("CHECK");
			 }				   	        		      	 
			};	 		
			
			prevButton.addActionListener(prevListener);		
			panel2.add(prevButton);
		}
		
		panel.add(panel2,BorderLayout.SOUTH);
		
	}
	
	public JPanel getPanel(){
		
		
		return this.panel;
	}
	

}
