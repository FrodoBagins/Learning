import java.awt.Color;

import javax.swing.JLabel;

public class Word implements IWord {
	
	protected static JLabel label;

	@Override
	public JLabel undecorate() {
		// TODO Auto-generated method stub
		label.setForeground(Color.black);
		
		return label;
	}

	@Override
	public void decorate(JLabel label) {
		
		Word.label = label;
		
	}

}
