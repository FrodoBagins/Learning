
public class ComponentFactory implements IComponentFactory {

	@Override
	public IComponent createComponent(String type, String content) {
		switch (type.toLowerCase()) {
		case "label":
			return new Label(content);
		case "button":
			return new Button(content);
		case "textfield":
			return new TextField(content);
		case "radiobutton":
			return new RadioButton(content);
		}
		return null;
	}
}
