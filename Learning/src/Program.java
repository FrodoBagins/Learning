import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class Program extends JFrame{
	private static final long serialVersionUID = 1L;
	   private JPanel mainPanel;

	   private UiElementFactory factory = new UiElementFactory();
	   
	   
	   private Program(){
		   //default setting for frame
		   setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   setSize(600, 400);
		   setBackground(Color.white);
		   setResizable(false);
		   setVisible(true);
		   setBounds(200, 200, getWidth(), getHeight());
		   
		   
		   mainPanel = new JPanel(); 
		   mainPanel.setBounds(80, 20, 400, 300);
		   mainPanel.setVisible(true);
		   
		   BorderLayout layout3 = new BorderLayout();
		   layout3.setHgap(50);
		   layout3.setVgap(50);
		   
		   mainPanel.setLayout(layout3);

		   
		   JLabel gameLabel = new JLabel("Program do nauki słówek",JLabel.CENTER);
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
		   
		   //
		   // DEMO & TESTING AREA
		   //  /*
		   
		   JPanel panel = new JPanel();
		   GridLayout layout = new GridLayout(0,2);
		   layout.setVgap(20);
		   panel.setLayout(layout);
		   
		   String[] poziomy = new String[]{"Łatwy","Średni","Trudny"};
		   String[] tryby = new String[]{"Tryb nauki","Tryb testu"};
		   String[] kierunek = new String[]{"PL -> ANG","ANG -> PL"};
		   		   
		   UiElement mLabel = factory.getUiElement("LABEL", "Tryb ");
		   UiElement lLabel = factory.getUiElement("LABEL", "Poziom ");
		   UiElement dLabel = factory.getUiElement("LABEL", "Kierunek ");		   
		   UiElement mComboBox = factory.getUiElement("COMBOBOX", "-");
		   UiElement lComboBox = factory.getUiElement("COMBOBOX", "-");
		   UiElement dComboBox = factory.getUiElement("COMBOBOX", "-");
		   
		   mComboBox.setComboBox(tryby);
		   lComboBox.setComboBox(poziomy);
		   dComboBox.setComboBox(kierunek);
		 	      
		   panel.add(mLabel.getElement());
		   panel.add(mComboBox.getElement());		   
		   panel.add(lLabel.getElement());
		   panel.add(lComboBox.getElement());		   
		   panel.add(dLabel.getElement());
	       panel.add(dComboBox.getElement());
		      		   
		   JPanel panel2 = new JPanel();	
		   GridLayout layout2 = new GridLayout(0,3);
		   layout2.setHgap(40);
		   layout2.setVgap(40);   
		   panel2.setLayout(layout2);
		   
		   UiElement exit = factory.getUiElement("BUTTON", "Wyjdź");	
		   UiElement start = factory.getUiElement("BUTTON", "Start");
		   UiElement crud = factory.getUiElement("BUTTON", "Baza słów");		

		   panel2.add(exit.getElement());
		   panel2.add(start.getElement());
		   panel2.add(crud.getElement());
		   
		   //   */
		   // END
		   //
		   
		  ActionListener startButtonListener = new ActionListener(){
			  
			  @Override
			  public void actionPerformed(ActionEvent arg0) {
			   		System.out.println(mComboBox.getText());
			   		System.out.println(lComboBox.getText());
			   		System.out.println(dComboBox.getText());
			   					
			   			}
			   	        		      	 
			   	   };
			   	   
           ActionListener exitButtonListener = new ActionListener(){
						  
			 @Override
			 public void actionPerformed(ActionEvent arg0) {
				 setVisible(false); 
				 dispose();
			
							
				 }
						   	        		      	 
			};	   	   
			   	         
			   	         
			start.listener(startButtonListener);
			exit.listener(exitButtonListener);
		   
	   
		 /*  
	 
		   mainPanel.add(crudOperationsButton);
		   mainPanel.add(exitButton);
		   mainPanel.add(startGame);
		   mainPanel.add(gameLabel);
		   mainPanel.add(modeComboBox);
		   
		  */ 
			
			
			JRadioButton radio1 = new JRadioButton("odpowied 1");
			JRadioButton radio2 = new JRadioButton("odpowiedz 2");
			JRadioButton radio3 = new JRadioButton("odpowied 3");
	
		      ButtonGroup group = new ButtonGroup();
		      group.add(radio1);
		      group.add(radio2);
		      group.add(radio3);
			

		      

		     JPanel controlPanel = new JPanel();
		     controlPanel.setLayout(new GridLayout(3, 1));
		     
		     controlPanel.add(radio1);
		     controlPanel.add(radio2);
		     controlPanel.add(radio3);
		//     mainPanel.add(controlPanel,BorderLayout.CENTER);
		     
		     
		     
	           ActionListener crudButtonListener = new ActionListener(){
					  
	  			 @Override
	  			 public void actionPerformed(ActionEvent arg0) {
	  				if(radio1.isSelected()) System.out.println("1");
	  				if(radio2.isSelected()) System.out.println("2");
	  				if(radio3.isSelected()) System.out.println("3");
	  					
	  	  				 }
	  						   	        		      	 
	  			};	 
		     
		     crud.listener(crudButtonListener);
		     
			
		   
	       mainPanel.add(panel,BorderLayout.CENTER);
		   mainPanel.add(gameLabel,BorderLayout.NORTH);
		   mainPanel.add(panel2,BorderLayout.SOUTH);
		   
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


