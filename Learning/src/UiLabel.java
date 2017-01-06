import java.awt.event.ActionListener;

import javax.swing.JLabel;

public class UiLabel implements UiElement {

	JLabel label = new JLabel();

	UiLabel(String str1) {
		label.setText(str1);
	}

	@Override
	public JLabel getElement() {
		// TODO Auto-generated method stub

		label.setHorizontalAlignment(JLabel.CENTER);

		return label;
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

	@Override
	public void setBounds(int int1, int int2, int int3, int int4) {

		label.setBounds(int1, int2, int3, int4);

	}

	@Override
	public void setComboBox(String[] wpisy) {
		// TODO Auto-generated method stub

	}

}
