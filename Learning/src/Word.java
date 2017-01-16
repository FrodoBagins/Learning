import java.awt.Font;
import javax.swing.JLabel;

public class Word implements IWord {
	
	private JLabel label;

	
	Word(String word) {
		label = new JLabel(word);
		label.setFont(new Font("Cambria", Font.PLAIN, 14));
	}
	

	@Override
	public void paint(JLabel label) {
		
		this.label = label;
		
	}

	@Override
	public JLabel getWord() {
		return label;
	}

	@Override
	public IWord undecorate() {
		return this;
	}
}
