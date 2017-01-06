import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioPanelBuilder implements Builder{
	
	
	private JPanel panel=new JPanel();
	
	
	private IWord selectedAnswer;
	private ButtonGroup group;
	

	@Override
	public void addQuestion(String quest) {
		
		
		
		// TODO Auto-generated method stub
		
		JLabel gameLabel = new JLabel(quest,JLabel.CENTER);
		panel.add(gameLabel);
		
		
	}

	@Override
	public void addAnswer(IWord answer) {
		// TODO Auto-generated method stub
		
	     JPanel controlPanel = new JPanel();
	     controlPanel.setLayout(new GridLayout(3, 1));
		
		
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
	    	controlPanel.add(radio3);
	    	
	    	
	    }
	      
	    
	     panel.add(controlPanel);
	    
	    
	      		
		
	}

	@Override
	public void addButton(String button) {
		
		
		
		// TODO Auto-generated method stub
		
		
	}
	
	public JPanel getPanel(){
		
		
		return this.panel;
	}
	

}
