import java.util.List;

import javax.swing.JPanel;

public class TestState implements State{
	
	//private RadioPanelBuilder builder = new RadioPanelBuilder();
	
	private Builder builder;
	private List<String> pytania;
	private List<String> odpowiedzi;
	
	
	
	public void build() {
		
		int aktualnePytanie = Program.getActualQuestion();
		
		pytania = Program.getChoosedQuestions();
		
		odpowiedzi = Program.getCorrectAnswers();
		
		
		String pytanie = pytania.get(aktualnePytanie-1);
		String odpowiedz = odpowiedzi.get(aktualnePytanie-1);
		
		
		if(Program.getLevel()==3){
			builder = new TextBoxBuilder();
		}
		else {
			builder = new RadioPanelBuilder();
		}
		
		
		
		builder.addQuestion(pytanie);
		builder.addAnswer(new WordDecoratorGreen(new Word(odpowiedz)));
		builder.addButton("PREV");
		builder.addButton("NEXTTEST");
		builder.addButton("SCORE");
		
		
		
		
	}
	
	
	public JPanel getTestLayout() {
		
		
		return builder.getPanel();
		
	}
	
	

	@Override
	public void increaseLevel() {
		// TODO Auto-generated method stub
		
	}

}
