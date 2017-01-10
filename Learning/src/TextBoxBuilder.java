import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextBoxBuilder implements Builder{

    private JTextField answerTextBox;	
	private JLabel gameInfoLabel;
	private JButton nextButton;
	
	private JPanel panelTextBox = new JPanel();
	private JPanel panelButtons = new JPanel();

		
	private String rightAnswer;
	private String selectedAnswerString;

	@Override
	public void addQuestion(String newQuestion) {
		
		GridLayout layoutTextBox = new GridLayout(3,0);
		
		layoutTextBox.setHgap(100);
		layoutTextBox.setVgap(50);
		
		panelTextBox.setBounds(80, 20, 400, 300);
		panelTextBox.setLayout(layoutTextBox);
		
		String question = new String("(Pytanie "+Program.getActualQuestion()+"/"+Program.getCorrectAnswers().size()+") Przetłumacz:   "+ newQuestion);
			
		gameInfoLabel = new JLabel(question,JLabel.CENTER);
		panelTextBox.add(gameInfoLabel);
				
	}

	@Override
	public void addAnswer(IWord answer) {
		
		   answerTextBox = new JTextField();
		   
		   answerTextBox.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Program.setAnswerText(answerTextBox.getText(), Program.getActualQuestion());	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		  
	       answerTextBox.setText("");
	       answerTextBox.setText(Program.getAnswerText(Program.getActualQuestion()));
	       

		     
	   	JPanel answerPanel = new JPanel();
	    GridLayout answerLayout = new GridLayout(0, 3);
	    answerPanel.setLayout(answerLayout);
	       
	       rightAnswer = answer.getWord().getText();
	    

	       answerPanel.add(answerTextBox);

	       
	       answerPanel.setBorder(BorderFactory.createEmptyBorder(0, 200, 0, 0));
     
	       panelTextBox.add(answerPanel);
	     
			JPanel panelButtons = new JPanel();
			GridLayout layoutButtons = new GridLayout(3, 3);
			panelButtons.setLayout(layoutButtons);
	        
	}

	@Override
	public void addButton(String button) {
		
		if(button.equals("EXIT"))
		{	
			JButton exitButton = new JButton();
			exitButton.setText("Menu główne");   	
             ActionListener exitListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			
					Program.showMainPanel();
					
	          }	
		};	 		
			
		exitButton.addActionListener(exitListener);		
		panelButtons.add(exitButton);
		
		}
		
				
		if(button.equals("CHECK"))
		{			
			JButton checkButton = new JButton();
			
			checkButton.setText("Sprawdź");   	
		
        ActionListener checkListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			

				 selectedAnswerString=answerTextBox.getText();
	 
				 if(selectedAnswerString.equals(rightAnswer))
				 {			 
					 answerTextBox.setEnabled(false);
					 answerTextBox.setBackground(Color.GREEN);
					 answerTextBox.setDisabledTextColor(Color.WHITE);
					 nextButton.setEnabled(true);			 					 
				 }		 			 
				 else{
					 
					 answerTextBox.setBackground(Color.RED);		 
				 }				 
									
			 }				   	        		      	 
			};	 					
			checkButton.addActionListener(checkListener);		
			panelButtons.add(checkButton);
		}
		
		
		
		
		if(button.equals("NEXT"))
		{	
			nextButton = new JButton();
			nextButton.setText("Dalej");   	
		
        ActionListener nextListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			

				    if(Program.getActualQuestion()==Program.getQuestionNumber())
				    	Program.showMainPanel();
				    else
				        Program.nextLearnStateQuestion();	 
				 
			 }				   	        		      	 
			};	 		
			
			nextButton.addActionListener(nextListener);	
			nextButton.setEnabled(false);
			panelButtons.add(nextButton);
		}
		
		
		
		
		if(button.equals("PREV"))
		{	
			JButton prevButton = new JButton();	
			prevButton.setText("Poprzednie pytanie");   	
		
        ActionListener prevListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			

                 if(Program.getActualQuestion()>1)
				 Program.previousTestStateQuestion();
				 
			 }				   	        		      	 
			};	 		
			
			prevButton.addActionListener(prevListener);		
			panelButtons.add(prevButton);
		}
		
		
		if(button.equals("NEXTTEST"))
		{	
			nextButton = new JButton();
			nextButton.setText("Następne pytanie"); 
			
			if(Program.getActualQuestion() == Program.QUESTIONS_NUMBER){
				nextButton.setEnabled(false);
			}
		
        ActionListener nextListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			
			 
				 if(Program.getActualQuestion()<Program.QUESTIONS_NUMBER)
				 Program.nextTestStateQuestion();
				 else
					 Program.setScorePanel();
				  	 		
			 }				   	        		      	 
			};	 		
			
			nextButton.addActionListener(nextListener);	
			panelButtons.add(nextButton);
		}
		
		
		if(button.equals("SCORE"))
		{	
			JButton prevButton = new JButton();
			
			prevButton.setText("Wynik");   	
		
        ActionListener prevListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			
				 
				 Program.setScorePanel();
				 
			 }				   	        		      	 
			};	 		
			
			prevButton.addActionListener(prevListener);		
			panelButtons.add(prevButton);
		}
		
		
		panelTextBox.add(panelButtons);
		
	}
	
	public JPanel getPanel(){
			
		return this.panelTextBox;
	}
	
}
