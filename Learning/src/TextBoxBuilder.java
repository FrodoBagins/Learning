import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextBoxBuilder implements Builder{

   private JTextField answerText;
	
	
	private JPanel panel=new JPanel();
	
	private JLabel gameLabel;

	private JButton nextButton;

	private JPanel panel2 = new JPanel();
	
	
	private String rightAnswer;
	private String selectedAnswerString;

	@Override
	public void addQuestion(String quest) {
		
		
		GridLayout laj = new GridLayout(3,0);
		
		laj.setHgap(100);
		laj.setVgap(50);
		
		
		panel.setBounds(80, 20, 400, 300);
		panel.setLayout(laj);
		
		
		String question = new String("(Pytanie "+Program.getActualQuestion()+"/"+Program.getCorrectAnswers().size()+") Przetłumacz na język angielski "+quest);
			
		gameLabel = new JLabel(question,JLabel.CENTER);
		panel.add(gameLabel);
				
	}

	@Override
	public void addAnswer(IWord answer) {
		
		   answerText = new JTextField();
		   
		   answerText.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Program.setSelectedTextBox(answerText.getText(), Program.getActualQuestion());
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		  
	       answerText.setText("");
	       answerText.setText(Program.getSelectedTextBox(Program.getActualQuestion()));
	       
	       answerText.setBounds(20, 100, 20, 20);
	       
	       JLabel emptyTxT = new JLabel(" ");
	       JLabel emptyTxT2 = new JLabel(" ");
		     
		JPanel panel3 = new JPanel();
	    GridLayout layout3 = new GridLayout(0, 3);
		panel3.setLayout(layout3);
	       
	       rightAnswer = answer.getWord().getText();
	    
	       panel3.add(emptyTxT);
	       panel3.add(answerText);
	       panel3.add(emptyTxT2);
	       
	     panel.add(panel3);
	     
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
	          }	
		};	 		
			
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
	 
				 if(selectedAnswerString.equals(rightAnswer))
				 {			 
					 answerText.setEnabled(false);
					 answerText.setBackground(Color.GREEN);
					 answerText.setDisabledTextColor(Color.WHITE);
					 nextButton.setEnabled(true);			 					 
				 }		 			 
				 else{
					 
					 answerText.setBackground(Color.RED);		 
				 }				 
					System.out.println("CHECK"+rightAnswer);										
			 }				   	        		      	 
			};	 					
			checkButton.addActionListener(checkListener);		
			panel2.add(checkButton);
		}
		
		
		
		
		if(button.equals("NEXT"))
		{	
			nextButton = new JButton();
			nextButton.setText("NEXT");   	
		
        ActionListener nextListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			

				    if(Program.getActualQuestion()==Program.getQuestionNumber())
				    	Program.showMainPanel();
				    else
				        Program.nextLearnState();	 
				 
					System.out.println("NEXT");
			 }				   	        		      	 
			};	 		
			
			nextButton.addActionListener(nextListener);	
			nextButton.setEnabled(false);
			panel2.add(nextButton);
		}
		
		
		
		
		if(button.equals("PREV"))
		{	
			JButton prevButton = new JButton();
			
			prevButton.setText("PREV");   	
		
        ActionListener prevListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			

				 
//				 Program.setSelectedTextBox(answerText.getText(), Program.getActualQuestion());

                 if(Program.getActualQuestion()>1)
				 Program.previousTestState();
				 
             
					System.out.println("PREV");
			 }				   	        		      	 
			};	 		
			
			prevButton.addActionListener(prevListener);		
			panel2.add(prevButton);
		}
		
		
		if(button.equals("NEXTTEST"))
		{	
			nextButton = new JButton();
			nextButton.setText("NEXTTEST"); 
			
			if(Program.getActualQuestion() == Program.QUESTIONS_NUMBER){
				nextButton.setEnabled(false);
			}
		
        ActionListener nextListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			

//				 Program.setSelectedTextBox(answerText.getText(), Program.getActualQuestion());
				 
				 
				 if(Program.getActualQuestion()<Program.QUESTIONS_NUMBER)
				 Program.nextTestState();
				 else
					 Program.setScorePanel();
				 
				 
				 
				 
					 
					System.out.println("NEXTTEST");
			 }				   	        		      	 
			};	 		
			
			nextButton.addActionListener(nextListener);	
			panel2.add(nextButton);
		}
		
		
		if(button.equals("SCORE"))
		{	
			JButton prevButton = new JButton();
			
			prevButton.setText("SCORE");   	
		
        ActionListener prevListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			

				 Program.setScorePanel();
					System.out.println("SCORE");
			 }				   	        		      	 
			};	 		
			
			prevButton.addActionListener(prevListener);		
			panel2.add(prevButton);
		}
		
		
		
		
		
		panel.add(panel2);
		
	}
	
	public JPanel getPanel(){
		
		
		return this.panel;
	}
	

}
