import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JRadioButton;

public class RadioButton implements IComponent {
	JRadioButton radioButton;

	public RadioButton(String content) {
		radioButton = new JRadioButton(content);
	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		radioButton.addActionListener(actionListener);
	}

	@Override
	public void setColor(Color color) {
		radioButton.setForeground(color);
	}

	@Override
	public JComponent getComponent() {
		return radioButton;
	}

	@Override
	public void addFocusListener(FocusListener focusListener) {
		radioButton.addFocusListener(focusListener);

	}

	@Override
	public void setText(String content) {
		radioButton.setText(content);

	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		radioButton.setBounds(x, y, width, height);

	}

	@Override
	public void setAlignmentX(float alignment) {
		radioButton.setAlignmentX(alignment);

	}

	@Override
	public void setToolTipText(String text) {
		radioButton.setToolTipText(text);

	}

	@Override
	public void setMaximumSize(Dimension dimension) {
		radioButton.setMaximumSize(dimension);

	}

	@Override
	public void setForeground(Color color) {
		radioButton.setForeground(color);

	}

	@Override
	public void setFont(Font font) {
		radioButton.setFont(font);

	}

	@Override
	public String getText() {
		return radioButton.getText();
	}

}
