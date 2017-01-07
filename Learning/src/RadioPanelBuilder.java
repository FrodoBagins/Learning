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
	
	private static IWord iiword;
	
	static JLabel checkone = new JLabel("1");
	static JLabel checktwo = new JLabel("2");
	static JLabel checkthree = new JLabel("3");
	static JLabel checkfour = new JLabel("4");
	
	static JPanel panel2 = new JPanel();
	
	
	private IWord selectedAnswer;
	private ButtonGroup group;
	

	@Override
	public void addQuestion(String quest) {
		panel.setLayout(new BorderLayout());
		
		
		//
		//Dodac ifa z kierunkiem tłumacznia todo
		//
		
		String question = new String("Przetłumacz na język angielski "+quest);
			
		JLabel gameLabel = new JLabel(question,JLabel.CENTER);
		panel.add(gameLabel,BorderLayout.NORTH);
				
		
	}

	@Override
	public void addAnswer(IWord answer) {
		
		group = new ButtonGroup();
		
	     JPanel controlPanel = new JPanel();
	     controlPanel.setLayout(new GridLayout(2, 1));
	     
		JPanel panel2 = new JPanel();
		GridLayout layout2 = new GridLayout(3, 3);
		panel2.setLayout(layout2);
		
				
	  //  answer = new WordDecoratorRed(answer);
	  
	//	answer.decorate(answer.getWord());
		

	  
		JRadioButton radio1 = new JRadioButton();
		JRadioButton radio2 = new JRadioButton();
	    
	      group.add(radio1);
	      group.add(radio2);
	      
		     controlPanel.add(radio1);
		     controlPanel.add(answer.getWord());
		     controlPanel.add(radio2);
		     controlPanel.add(checktwo);
	      
	      	      
	    if(Program.getLevel()==2) {
	    	
	    	JRadioButton radio3 = new JRadioButton();
	    	JRadioButton radio4 = new JRadioButton();
	    	group.add(radio3);
	    	group.add(radio4);
	    	controlPanel.setLayout(new GridLayout(4,1));
	    	controlPanel.add(radio3);
	    	controlPanel.add(checkthree);
	    	controlPanel.add(radio4);
	    	controlPanel.add(checkfour);
	    	
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
