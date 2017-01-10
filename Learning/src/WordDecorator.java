import javax.swing.JLabel;

public abstract class WordDecorator implements IWord{
	IWord decoratedWord;
	JLabel word;
	
		
	public WordDecorator(IWord decoratedWord){
				
		this.decoratedWord = decoratedWord;
		word = this.decoratedWord.getWord();
		
	}
	
	public void decorate(JLabel word){
		this.decoratedWord.decorate(word);
		
	}
	
	
	public JLabel getWord(){

		return decoratedWord.getWord();	
	}
	
	public IWord undecorate(){
		
		return decoratedWord.undecorate();
	}
	

}
