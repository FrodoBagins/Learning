import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JComponent;

public class UiComboBox implements UiElement{
	
	JComboBox<String> combo = new JComboBox<>();
	
	UiComboBox(String str1) {
		
		combo.addItem(str1);
		
	}

	@Override
	public JComponent getElement() {
		// TODO Auto-generated method stub
		return combo;
	}

	@Override
	public void listener(ActionListener omg) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getText() {
		
		combo.getSelectedItem();
		
		return (String) combo.getSelectedItem();
	}

	@Override
	public void setBounds(int int1, int int2, int int3, int int4) {
         
          combo.setBounds(int1, int2, int3, int4);
          
	}

	@Override
	public void setComboBox(String[] wpisy) {
		
		combo.removeAllItems();
		
		for(String r : wpisy){
			
			combo.addItem(r);
		}
		
		
	}

}
