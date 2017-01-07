import java.awt.Color;

import javax.swing.JLabel;

public class WordDecoratorBlack extends WordDecorator {


	public WordDecoratorBlack(IWord decoratedWord) {
		super(decoratedWord);
	}


	@Override
	public void decorate(JLabel label) {
		label.setForeground(Color.BLACK);
		super.decorate(label);
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
