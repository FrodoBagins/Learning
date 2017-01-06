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

	@Override
	public void setBounds(int int1, int int2, int int3, int int4) {
		button.setBounds(int1, int2, int3, int4);
		
	}

	@Override
	public void setComboBox(String[] wpisy) {
		// TODO Auto-generated method stub
		
	}
	
	
}
