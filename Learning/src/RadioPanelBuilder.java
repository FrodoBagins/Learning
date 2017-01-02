import javax.swing.ButtonGroup;
import javax.swing.JPanel;

public class RadioPanelBuilder implements Builder{
	
	
	private JPanel panel;
	private IWord selectedAnswer;
	private ButtonGroup group;
	

	@Override
	public void addQuestion(String quest) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAnswer(IWord answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addButton(String button) {
		// TODO Auto-generated method stub
		
	}
	
	public JPanel getPanel(){
		
		
		return this.panel;
	}
	

}
