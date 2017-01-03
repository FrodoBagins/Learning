
public class UiElementFactory {

	public UiElement getUiElement(String type,String name){
		
		if(type == null){
			return null;
		}
		
		if(type.equalsIgnoreCase("LABEL")){
			
			return new UiLabel(name);
			
		} else if (type.equalsIgnoreCase("BUTTON")){
			
			return new UiButton(name);
		} else if (type.equalsIgnoreCase("TEXTBOX")){
			
			return new UiTextBox(name);
		}
		
		return null;
	}
	
}
