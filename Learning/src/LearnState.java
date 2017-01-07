import javax.swing.JPanel;

public class LearnState implements State{
	
	private Builder builder;

	public void build() {
		
		if(Program.getLevel()==3){
			builder = new TextBoxBuilder();
		}
		else {
			builder = new RadioPanelBuilder();
		}
		
		
		
		builder.addQuestion("Napis");
		builder.addAnswer(new Word("slowo"));
		builder.addButton("CHECK");
		builder.addButton("NEXT");
		builder.addButton("EXIT");
		
		
	}
	
	
	public JPanel getTestLayout() {
		
		
		return builder.getPanel();
		
	}
	
	

	@Override
	public void increaseLevel() {
		// TODO Auto-generated method stub
		
	}

}
