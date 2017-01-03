import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class program {
	
	   private JFrame mainFrame;
	   private JLabel headerLabel;
	   private JLabel statusLabel;
	   private JPanel controlPanel;
	   
	   UiElementFactory factory = new UiElementFactory();

	   public program(){
	      prepareGUI();
	   }

	public static void main(String[] args) {
		System.out.println("Start");
		program pr = new program();
		pr.showEventDemo();
		
		
		DataBase db = DataBase.getDataBase();
		db.createWordsPair("PL_1", "ANG_1");
		db.save();
		
		
			
	}
		
	     private void prepareGUI(){
	         mainFrame = new JFrame("Java SWING Examples");
	         mainFrame.setSize(400,400);
	         
	         //
	         // Demo FactoryMethod
	         //
	        
	         
	         UiElement element = factory.getUiElement("LABEL","NAPIS");
	         UiElement element1 = factory.getUiElement("BUTTON","NAPIS2");
	         UiElement element2 = factory.getUiElement("BUTTON","tekst1");
	         UiElement element3 = factory.getUiElement("TEXTBOX","NAPIS2");
	         UiElement element4 = factory.getUiElement("LABEL","NAPIS3");
	         UiElement element5 = factory.getUiElement("LABEL","NAPIS4");
	         UiElement element6 = factory.getUiElement("LABEL","NAPIS5");
	         
	       
	         
	      //   element1.listener(var);
	     //    element2.listener(var2);
	         
	         
	         System.out.println(element3.getText());
	         
	         ActionListener listen = new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println(element3.getText());
					
				}
	        		      	 
	         };
	        	         	 	        	 
	         element1.listener(listen);
	                
	         JPanel panel = new JPanel();
	         
	         panel.setLayout(new FlowLayout());
	         
	         panel.add(element.getElement());
	         panel.add(element1.getElement());
	         panel.add(element2.getElement());
	         panel.add(element3.getElement());
	         panel.add(element4.getElement());
	         panel.add(element5.getElement());
	         panel.add(element6.getElement());
	         
	         
	         mainFrame.add(panel);
	         
	         mainFrame.setVisible(true); 
	         
	      }
		
	     
	     private void showEventDemo(){
	        

	         mainFrame.setVisible(true);  
	      }
	     
	     

	}


