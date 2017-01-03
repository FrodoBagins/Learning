import java.awt.event.ActionListener;

import javax.swing.JComponent;

public interface UiElement{
	
	public JComponent getElement();
    public void listener(ActionListener omg);
    public String getText();
}
