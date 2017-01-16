import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.FocusListener;

import javax.swing.JComponent;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

public interface IComponent {
	public void addActionListener(ActionListener actionListener);

	public void setColor(Color color);

	public JComponent getComponent();

	public void addFocusListener(FocusListener focusListener);

	public void setText(String content);

	public void setBounds(int x, int y, int width, int height);

	public void setAlignmentX(float alignment);

	public void setToolTipText(String text);

	public void setMaximumSize(Dimension dimension);

	public void setForeground(Color color);

	public void setFont(Font font);

	public String getText();

	void setBorder(Border border);

	void setSelected(boolean b);

	boolean isSelected();

	void setEnabled(boolean b);


	void setBackground(Color bg);

	void setDisabledTextColor(Color bg);
	
	
}
