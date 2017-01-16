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
	
	private IComponentFactory componentFactory = new ComponentFactory();
	private IComponent nextButton = componentFactory.createComponent("button", "");
	private IComponent gameInfoLabel = componentFactory.createComponent("label", "");
	private IComponent answerTextBox = componentFactory.createComponent("textfield", "");
	
	
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
			
		gameInfoLabel.setText(question);
		
		
		panelTextBox.add(gameInfoLabel.getComponent());
				
	}

	@Override
	public void addAnswer(IWord answer) {
		

		   answerTextBox.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				Program.setAnswerText(answerTextBox.getText(), Program.getActualQuestion());	
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				
		}
		});
		  
	       answerTextBox.setText("");
	       answerTextBox.setText(Program.getAnswerText(Program.getActualQuestion()));
	       

		     
	   	JPanel answerPanel = new JPanel();
	    GridLayout answerLayout = new GridLayout(0, 3);
	    answerPanel.setLayout(answerLayout);
	       
	       rightAnswer = answer.getWord().getText();
	    

	       answerPanel.add(answerTextBox.getComponent());

	       
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
			IComponent exitButton = componentFactory.createComponent("button", "Powrót do menu głównego");
			
             ActionListener exitListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			
					Program.showMainPanel();
					
	          }	
		};	 		
			
		exitButton.addActionListener(exitListener);		
		panelButtons.add(exitButton.getComponent());
		
		}
		
				
		if(button.equals("CHECK"))
		{			
			IComponent checkButton = componentFactory.createComponent("button", "Sprawdź"); 	
		
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
			panelButtons.add(checkButton.getComponent());
		}
		
		
		
		
		if(button.equals("NEXT"))
		{	
		//	nextButton = new JButton();
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
			panelButtons.add(nextButton.getComponent());
		}
		
		
		
		
		if(button.equals("PREV"))
		{	
			IComponent prevButton = componentFactory.createComponent("button", "Poprzednie pytanie"); 	
		
        ActionListener prevListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			

                 if(Program.getActualQuestion()>1)
				 Program.previousTestStateQuestion();
				 
			 }				   	        		      	 
			};	 		
			
			prevButton.addActionListener(prevListener);		
			panelButtons.add(prevButton.getComponent());
		}
		
		
		if(button.equals("NEXTTEST"))
		{	
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
			panelButtons.add(nextButton.getComponent());
		}
		
		
		if(button.equals("SCORE"))
		{	
			IComponent prevButton = componentFactory.createComponent("button", "Wynik");
				
        ActionListener prevListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			
				 
				 Program.setScorePanel();
				 
			 }				   	        		      	 
			};	 		
			
			prevButton.addActionListener(prevListener);		
			panelButtons.add(prevButton.getComponent());
		}
		
		
		panelTextBox.add(panelButtons);
		
	}
	
	public JPanel getPanel(){
			
		return this.panelTextBox;
	}
	
}
