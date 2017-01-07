import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextBoxBuilder implements Builder{

private JTextField answerText=new JTextField();
	
	
	private JPanel panel=new JPanel();
	
	
	
	static JButton butt = new JButton();
	

	

	@Override
	public void addQuestion(String quest) {
		panel.setLayout(new BorderLayout());
		
		
		
		JLabel gameLabel = new JLabel(quest,JLabel.CENTER);
		panel.add(gameLabel,BorderLayout.NORTH);
		
		
	}

	@Override
	public void addAnswer(IWord answer) {
		
	       answerText.setText("NNNNNN");
	       answerText.setBounds(0, 0, 20, 20);
	    
	     panel.add(answerText,BorderLayout.CENTER);
	    
	    
	      		
		
	}

	@Override
	public void addButton(String button) {
		
		
		if(button.equals("EXIT"))
		{	butt.setText("EXIT");   	
		
        ActionListener exitListener = new ActionListener(){			  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {			
				
					
					System.out.println("ZIMO");
			 }				   	        		      	 
			};	 		
			
			
			butt.addActionListener(exitListener);		
		panel.add(butt, BorderLayout.SOUTH);
		}
		
		
	}
	
	public JPanel getPanel(){
		
		
		return this.panel;
	}
	

}
