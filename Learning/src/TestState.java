import java.util.List;

import javax.swing.JPanel;

public class TestState implements State{
		
	private Builder builder;
	private List<String> questions;
	private List<String> answers;
	
	public void build(){
		
		int actualQuestion = Program.getActualQuestion();
		
		questions = Program.getChoosedQuestions();
		answers = Program.getCorrectAnswers();
				
		String question = questions.get(actualQuestion-1);
		String answer = answers.get(actualQuestion-1);
		
		if(Program.getLevel()==3){
			builder = new TextBoxBuilder();
		}else {
			builder = new RadioPanelBuilder();
		}
		
		builder.addQuestion(question);
		builder.addAnswer(new WordDecoratorGreen(new Word(answer)));
		builder.addButton("PREV");
		builder.addButton("NEXTTEST");
		builder.addButton("SCORE");
		
	}
	
	
	public JPanel getTestLayout() {
			
		return builder.getPanel();
		
	}
	
}
