import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JTextField;

public class TextField implements IComponent {

	JTextField textField;

	public TextField(String content) {
		textField = new JTextField(content);
	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		textField.addActionListener(actionListener);
	}

	@Override
	public void setColor(Color color) {
		textField.setBackground(color);
	}

	@Override
	public JComponent getComponent() {
		return textField;
	}

	public void addFocusListener(FocusListener focusListener) {
		textField.addFocusListener(focusListener);
	}

	@Override
	public void setText(String content) {
		textField.setText(content);
		
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		textField.setBounds(x, y, width, height);
		
	}

	@Override
	public void setAlignmentX(float alignment) {
		textField.setAlignmentX(alignment);
		
	}

	@Override
	public void setToolTipText(String text) {
		textField.setToolTipText(text);
		
	}

	@Override
	public void setMaximumSize(Dimension dimension) {
		textField.setMaximumSize(dimension);
		
	}

	@Override
	public void setForeground(Color color) {
		textField.setForeground(color);
		
	}

	@Override
	public void setFont(Font font) {
		textField.setFont(font);
		
	}

	@Override
	public String getText() {
		return textField.getText();
	}

}
