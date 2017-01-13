import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JLabel;

public class Label implements IComponent {
	JLabel label;

	public Label(String content) {
		label = new JLabel(content);
	}

	@Override
	public void addActionListener(ActionListener actionListener) {
	}

	@Override
	public void setColor(Color color) {
		label.setBackground(color);
	}

	@Override
	public JComponent getComponent() {
		return label;
	}

	@Override
	public void addFocusListener(FocusListener focusListener) {
		label.addFocusListener(focusListener);
	}

	@Override
	public void setText(String content) {
		label.setText(content);

	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		label.setBounds(x, y, width, height);

	}

	@Override
	public void setAlignmentX(float alignment) {
		label.setAlignmentX(alignment);

	}

	@Override
	public void setToolTipText(String text) {
		label.setToolTipText(text);

	}

	@Override
	public void setMaximumSize(Dimension dimension) {
		label.setMaximumSize(dimension);

	}

	@Override
	public void setForeground(Color color) {
		label.setForeground(color);

	}

	@Override
	public void setFont(Font font) {
		label.setFont(font);

	}

	@Override
	public String getText() {
		return label.getText();
	}

}
