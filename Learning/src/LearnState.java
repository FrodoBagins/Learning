import java.util.List;

import javax.swing.JPanel;

public class LearnState implements State{
	
	private Builder builder;
	
	private List<String> questions;
	private List<String> answers;

	public void build() {
		
		int actualQuestion = Program.getActualQuestion();
		
		questions = Program.getChoosedQuestions();
				
		answers = Program.getCorrectAnswers();
		
		
		String pytanie = questions.get(actualQuestion-1);
		String odpowiedz = answers.get(actualQuestion-1);
		
			
		if(Program.getLevel()==3){
			builder = new TextBoxBuilder();
		}
		else {
			builder = new RadioPanelBuilder();
		}
		
		builder.addQuestion(pytanie);
		builder.addAnswer(new Word(odpowiedz));
		builder.addButton("CHECK");
		builder.addButton("NEXT");
		builder.addButton("EXIT");	
		
	}
	
	
	public JPanel getTestLayout() {
		
		return builder.getPanel();
		
	}
	
}
