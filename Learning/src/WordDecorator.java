import javax.swing.JLabel;

public abstract class WordDecorator implements IWord{
	IWord decoratedWord;
	JLabel word;
	
		
	public WordDecorator(IWord decoratedWord){
				
		this.decoratedWord = decoratedWord;
		word = this.decoratedWord.getWord();
		
	}
	
	public void paint(JLabel word){
		this.decoratedWord.paint(word);
		
	}
	
	
	public JLabel getWord(){

		return decoratedWord.getWord();	
	}
	
	public IWord undecorate(){
		
		return decoratedWord.undecorate();
	}
	

}
