import javax.swing.JLabel;

public interface IWord {
	
	public void paint(JLabel word);
	public JLabel getWord();
	public IWord undecorate();
}
