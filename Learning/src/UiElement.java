import java.awt.event.ActionListener;

import javax.swing.JComponent;

public interface UiElement{
	
	public JComponent getElement();
    public void listener(ActionListener omg);
    public void setBounds(int int1, int int2, int int3, int int4);
    public void setComboBox(String[] wpisy);
    public String getText();
}
