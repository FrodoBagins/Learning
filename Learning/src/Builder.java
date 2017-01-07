import javax.swing.JPanel;

public interface Builder {
	
		
		public void addQuestion(String quest);
		public void addAnswer(IWord answer);
		public void addButton(String button);
	    public JPanel getPanel();

}
