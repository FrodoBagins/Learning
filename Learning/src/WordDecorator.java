
public abstract class WordDecorator implements IWord{
	protected IWord decoratedWord;
	
	public WordDecorator(IWord decoratedWord){
		this.decoratedWord = decoratedWord;
	}
	
	

}
