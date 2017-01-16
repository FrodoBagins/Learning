import java.awt.Color;

import javax.swing.JLabel;

public class WordDecoratorGreen extends WordDecorator{


	public WordDecoratorGreen(IWord decoratedWord) {
		super(decoratedWord);
	}

	@Override
	public void paint(JLabel label) {
		label.setForeground(Color.GREEN);
		super.paint(label);
	}

	@Override
	public JLabel getWord() {
		return super.getWord();
	}

	@Override
	public IWord undecorate() {
		return super.undecorate();
	}
	
	

}
