import java.awt.Color;

import javax.swing.JLabel;

public class WordDecoratorRed extends WordDecorator{


	public WordDecoratorRed(IWord decoratedWord) {
		super(decoratedWord);
	}


	@Override
	public void paint(JLabel label) {
		label.setForeground(Color.RED);
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


