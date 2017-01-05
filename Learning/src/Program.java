import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Program extends JFrame{
	private static final long serialVersionUID = 1L;
	   private JPanel mainPanel;

	   
	   private Program(){
		   //default setting for frame
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   setSize(600, 400);
		   setBackground(Color.white);
		   setVisible(true);
		   setBounds(200, 200, getWidth(), getHeight());
		   
		   
		   mainPanel = new JPanel();
		   mainPanel.setSize(600, 400);
		   mainPanel.setVisible(true);
		   mainPanel.setLayout(null);
		   
		   JLabel gameLabel = new JLabel("Program do nauki słówek");
		   gameLabel.setFont(new Font(Font.SANS_SERIF, 0,30 ));
		   gameLabel.setBounds(120, 0, 450, 50);
		   
		   JLabel modeLabel = new JLabel("Tryb ");
		  // modeLabel.setBounds(x, y, width, height);
		   
		   JLabel levelLabel = new JLabel("Poziom ");
		  // levelLabel.setBounds(x, y, width, height);
		   
		   JLabel directionLabel = new JLabel("Kierunek ");
		  // typeGame.setBounds(x, y, width, height);
		   
		   JComboBox<String> modeComboBox = new JComboBox<>();
		   modeComboBox.addItem("Tryb nauki"); //index 0
		   modeComboBox.addItem("Tryb testu"); //index 1
		   modeComboBox.setBounds(200, 200, 100, 30);
		   
		   JComboBox<String> levelComboBox = new JComboBox<>();
		   levelComboBox.addItem("Łatwy");//index 0
		   levelComboBox.addItem("Średni");//index 1
		   levelComboBox.addItem("Trudny");//index 2
		   
		   
		   JComboBox<String> directionComboBox = new JComboBox<>();
		   directionComboBox.addItem("PL -> ANG");//index 0
		   directionComboBox.addItem("ANG -> PL");//index 1
		   
		   
		   JButton crudOperationsButton = new JButton("Baza słów");
		   crudOperationsButton.setBounds(400, 300, 120, 25);
		   
		   JButton exitButton = new JButton("Wyjście");
		   exitButton.setBounds(200,300,80,25);
		   
		   JButton startGame = new JButton("Rozpocznij");
		   startGame.setBounds(300, 270, 120, 25);
		   
		   mainPanel.add(crudOperationsButton);
		   mainPanel.add(exitButton);
		   mainPanel.add(startGame);
		   mainPanel.add(gameLabel);
		   mainPanel.add(modeComboBox);
		   
		   setContentPane(mainPanel);
		   
		   
	   }

	   
	   
	   private JPanel createCrudPanel(){
		   //TODO CRUD panel
		   return null;
	   }
	 

	public static void main(String[] args) {
		Program program = new Program();			
	}
		
	}


