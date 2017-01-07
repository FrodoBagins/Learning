import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextBoxBuilder implements Builder{

private JTextField answerText=new JTextField();
	
	
	private JPanel panel=new JPanel();
	
	private JLabel gameLabel;
	
//	static JButton exitButton = new JButton();
//	static JButton checkButton = new JButton();
//	static JButton nextButton = new JButton();
//	static JButton prevButton = new JButton();
	private JPanel panel2 = new JPanel();
	private String selectedAnswerString;

	@Override
	public void addQuestion(String quest) {
		panel.setLayout(new BorderLayout());
		
		
		
		//
		//Dodac ifa z kierunkiem tłumacznia todo
		//
		
		String question = new String("Przetłumacz na język angielski "+quest);
			
		gameLabel = new JLabel(question,JLabel.CENTER);
		panel.add(gameLabel,BorderLayout.NORTH);
				
	}

	@Override
	public void addAnswer(IWord answer) {
		
	       answerText.setText("");
	       answerText.setBounds(0, 0, 20, 20);
	    
	     panel.add(answerText,BorderLayout.CENTER);
	     
			JPanel panel2 = new JPanel();
			GridLayout layout2 = new GridLayout(3, 3);
			panel2.setLayout(layout2);
	    
	    	
	}

	@Override
	public void addButton(String button) {
		
		
		
		if(button.equals("EXIT"))
		{	
			
			JButton exitButton = new JButton();
			exitButton.setText("EXIT");   	
		
        ActionListener exitListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			
					System.out.println("EXIT");
					
					Program.showMainPanel();
				//	Program.setMainPanel();
					
					
					
		 }	};	 		
			
		 
		exitButton.addActionListener(exitListener);		
		panel2.add(exitButton);
		
		}
		
		
		
		
		if(button.equals("CHECK"))
		{	
			
			JButton checkButton = new JButton();
			
			checkButton.setText("CHECK");   	
		
        ActionListener checkListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			

				 selectedAnswerString=answerText.getText();

					System.out.println("CHECK"+selectedAnswerString);
			 }				   	        		      	 
			};	 		
			
			checkButton.addActionListener(checkListener);		
			panel2.add(checkButton);
		}
		
		
		
		
		if(button.equals("NEXT"))
		{	
			JButton nextButton = new JButton();
			nextButton.setText("NEXT");   	
		
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
		{	
			JButton prevButton = new JButton();
			
			prevButton.setText("PREV");   	
		
        ActionListener prevListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			


					System.out.println("PREV");
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
