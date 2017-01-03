import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class UiLabel implements UiElement{
	
	JLabel label = new JLabel();
	
	UiLabel(String str1){
		
		label.setText(str1);
		
	}
	

	@Override
	public JLabel getElement(){
		// TODO Auto-generated method stub
	
		return  label;
	}





	@Override
	public String getText() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void listener(ActionListener omg) {
		// TODO Auto-generated method stub
		
	}

}
