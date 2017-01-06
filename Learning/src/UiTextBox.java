import java.awt.event.ActionListener;

import javax.swing.JTextField;

public class UiTextBox implements UiElement{
	
	JTextField txtField = new JTextField();
	
	UiTextBox(String str1){
		
		txtField.setText(str1);
			
	}
	

	@Override
	public JTextField getElement() {
		// TODO Auto-generated method stub
		return txtField;
	}


	@Override
	public String getText() {
	return txtField.getText();
	}


	@Override
	public void listener(ActionListener omg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setBounds(int int1, int int2, int int3, int int4) {
		txtField.setBounds(int1, int2, int3, int4);
		
	}


	@Override
	public void setComboBox(String[] wpisy) {
		// TODO Auto-generated method stub
		
	}
	
	
	


}
