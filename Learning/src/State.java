import javax.swing.JPanel;

public interface State {
	
	//public void createPanel(Builder build);
	  public void increaseLevel();
	  public void build();
	  public JPanel getTestLayout();
}
