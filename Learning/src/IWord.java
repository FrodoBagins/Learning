import javax.swing.JLabel;

public interface IWord {
	
	public void decorate(JLabel word);
	public JLabel getWord();
	public IWord undecorate();
}
