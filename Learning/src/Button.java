import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JButton;
import javax.swing.JComponent;

public class Button implements IComponent {

	JButton button;

	public Button(String content) {
		button = new JButton(content);
	}

	@Override
	public void addActionListener(ActionListener actionListener) {
		button.addActionListener(actionListener);

	}

	@Override
	public void setColor(Color color) {
		button.setBackground(color);
	}

	@Override
	public JComponent getComponent() {
		return button;
	}

	@Override
	public void addFocusListener(FocusListener focusListener) {
		button.addFocusListener(focusListener);
	}

	@Override
	public void setText(String content) {
		button.setText(content);

	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		button.setBounds(x, y, width, height);
	}

	@Override
	public void setAlignmentX(float alignment) {
		button.setAlignmentX(alignment);

	}

	@Override
	public void setToolTipText(String text) {
		button.setToolTipText(text);

	}

	@Override
	public void setMaximumSize(Dimension dimension) {
		button.setMaximumSize(dimension);

	}

	@Override
	public void setForeground(Color color) {
		button.setForeground(color);

	}

	@Override
	public void setFont(Font font) {
		button.setFont(font);

	}

	@Override
	public String getText() {
		return button.getText();
	}

}
