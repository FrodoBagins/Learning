import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioPanelBuilder implements Builder{
	
	private JPanel panel=new JPanel();
	
//	static JButton exitButton = new JButton();
//	static JButton checkButton = new JButton();
//	static JButton nextButton = new JButton();
//	static JButton prevButton = new JButton();
	
	private static IWord iiword;
	
	private JButton nextButton;
	
	private IWord opd1;
	private IWord opd2;
	private IWord opd3;
	private IWord opd4;
	
	
	private int selectedAnswerNumber;
	private int numberOfQuestions;
	private String rightAnswer;
	
	private JPanel panel2 = new JPanel();
	private JRadioButton radio1 = new JRadioButton();
	private JRadioButton radio2 = new JRadioButton();
	private JRadioButton radio3 = new JRadioButton();
	private JRadioButton radio4 = new JRadioButton();
	
	private JLabel checkone = new JLabel("1");
	private JLabel checktwo = new JLabel("2");
	private JLabel checkthree = new JLabel("3");
	private JLabel checkfour = new JLabel("4");
	
	private List<String[]> zleodpowiedzi;
	
	private IWord selectedAnswer;
	private ButtonGroup group;
	

	@Override
	public void addQuestion(String quest) {
		panel.setLayout(new BorderLayout());
		
		
		String question = new String("Przetłumacz na język angielski "+quest);
			
		JLabel gameLabel = new JLabel(question,JLabel.CENTER);
		panel.add(gameLabel,BorderLayout.NORTH);
				
		
	}

	@Override
	public void addAnswer(IWord answer) {
		
		rightAnswer = answer.getWord().getText();
		
		zleodpowiedzi = Program.getIncorrectAnswers();
		
		String[] zlo = zleodpowiedzi.get(Program.getActualQuestion()-1);
		
		checkone = new JLabel(zlo[0]);
		checktwo = new JLabel(zlo[1]);
		checkthree = new JLabel(zlo[2]);
		checkfour = new JLabel(zlo[3]);
		
		Random rand = new Random();
		int n = 0;
		
		opd1 = new WordDecoratorRed( new Word(zlo[0]));
		opd2 = new WordDecoratorRed( new Word(zlo[1]));
		opd3 = new WordDecoratorRed( new Word(zlo[2]));
		opd4 = new WordDecoratorRed( new Word(zlo[3]));
		
		if(Program.getLevel()==2)
		{	n = rand.nextInt(4);  }
		
		if(Program.getLevel()==1)
		{	n = rand.nextInt(2); }

		
		switch (n) {
		
		case 0 : opd1 = new WordDecoratorGreen(new Word(answer.getWord().getText())); break;
		
		case 1 : opd2 = new WordDecoratorGreen(new Word(answer.getWord().getText())); break;
		
		case 2 : opd3 = new WordDecoratorGreen(new Word(answer.getWord().getText())); break;
		
		case 3 : opd4 = new WordDecoratorGreen(new Word(answer.getWord().getText()));; break;
		
		}
		
				
		group = new ButtonGroup();
		
	     JPanel controlPanel = new JPanel();
	     controlPanel.setLayout(new GridLayout(2, 1));
	     
		JPanel panel2 = new JPanel();
		GridLayout layout2 = new GridLayout(3, 3);
		panel2.setLayout(layout2);
		
				   
	      group.add(radio1);
	      group.add(radio2);
	      
		     controlPanel.add(radio1);
		     controlPanel.add(opd1.getWord());
		     controlPanel.add(radio2);
		     controlPanel.add(opd2.getWord());
	      
	      	      
	    if(Program.getLevel()==2) {
	    	

	    	group.add(radio3);
	    	group.add(radio4);
	    	controlPanel.setLayout(new GridLayout(4,1));
	    	controlPanel.add(radio3);
	    	controlPanel.add(opd3.getWord());
	    	controlPanel.add(radio4);
	    	controlPanel.add(opd4.getWord());
	    	
	    }
	      
	     panel.add(controlPanel,BorderLayout.CENTER);
	    		
	}

	@Override
	public void addButton(String button) {
		
		//panel2 = new JPanel();
		
		
		
		if(button.equals("EXIT"))
		{	
			
			JButton exitButton = new JButton();
			exitButton.setText("EXIT");   	
		
        ActionListener exitListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			
					System.out.println("EXIT");
					
					Program.showMainPanel();
							
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

                   if(radio1.isSelected()) selectedAnswerNumber=1;
                   if(radio2.isSelected()) selectedAnswerNumber=2;
                   if(radio3.isSelected()) selectedAnswerNumber=3;
                   if(radio4.isSelected()) selectedAnswerNumber=4;
                   
           		switch (selectedAnswerNumber) {
        		
        		case 1 : opd1.decorate(opd1.getWord());        		
        		if(opd1.getWord().getText()==rightAnswer)
        		{
                    radio1.setEnabled(false);
                    radio2.setEnabled(false);
                    radio3.setEnabled(false);
                    radio4.setEnabled(false);  	
                    nextButton.setEnabled(true);
                    
        		}    		
        		break;
        		
        		case 2 : opd2.decorate(opd2.getWord()); 
        		if(opd2.getWord().getText()==rightAnswer)
        		{
                    radio1.setEnabled(false);
                    radio2.setEnabled(false);
                    radio3.setEnabled(false);
                    radio4.setEnabled(false);      
                    nextButton.setEnabled(true);
        		}       		
        		break;
        		
        		case 3 : opd3.decorate(opd3.getWord()); 
        		if(opd3.getWord().getText()==rightAnswer)
        		{
                    radio1.setEnabled(false);
                    radio2.setEnabled(false);
                    radio3.setEnabled(false);
                    radio4.setEnabled(false);
                    nextButton.setEnabled(true);
        		}
        		
        		break;		
        		case 4 : opd4.decorate(opd4.getWord()); 
        		if(opd4.getWord().getText()==rightAnswer)
        		{
                    radio1.setEnabled(false);
                    radio2.setEnabled(false);
                    radio3.setEnabled(false);
                    radio4.setEnabled(false);    	
                    nextButton.setEnabled(true);
        		}
        		break;
        		
        		}
                   
                   
                 
				 
					System.out.println("CHECK"+selectedAnswerNumber);
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
			
			nextButton.setEnabled(false);
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
		
		
		
		if(button.equals("NEXTTEST"))
		{	
			nextButton = new JButton();
			nextButton.setText("NEXTTEST");   	
		
        ActionListener nextListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			

					 
					System.out.println("NEXTTEST");
			 }				   	        		      	 
			};	 		
			
			nextButton.addActionListener(nextListener);	
			nextButton.setEnabled(false);
			panel2.add(nextButton);
		}
		
		
		if(button.equals("SCORE"))
		{	
			JButton prevButton = new JButton();
			
			prevButton.setText("SCORE");   	
		
        ActionListener prevListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			


					System.out.println("SCORE");
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
