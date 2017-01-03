import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class UiButton implements UiElement{
	
	JButton button = new JButton();
	
	UiButton(String str1){
		
		button.setText(str1);
		
	}

	@Override
	public JButton getElement() {
		// TODO Auto-generated method stub
		return button;
	}

	@Override
    public void listener(ActionListener listen){
    	
    	
    	button.addActionListener(listen);
    		
   
    	
    	

    }

	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
