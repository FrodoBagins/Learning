import javax.swing.JPanel;

public class TestState implements State{
	
	//private RadioPanelBuilder builder = new RadioPanelBuilder();
	
	private Builder builder;
	
	
	
	public void build() {
		builder = new RadioPanelBuilder();
		
		
		builder.addQuestion("Napis");
		
		
		
	}
	
	
	public JPanel getTestLayout() {
		
		
		return builder.getPanel();
		
	}
	
	

	@Override
	public void increaseLevel() {
		// TODO Auto-generated method stub
		
	}

}
