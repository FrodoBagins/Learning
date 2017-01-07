import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Program extends JFrame {
	private static final long serialVersionUID = 1L;
	private static JPanel mainPanel;
	private static Program program;
	private static DefaultListModel<String> wordsList;
	static IDbOperations dbOperations = new DbAdapter();

	private UiElementFactory factory = new UiElementFactory();

	private static int level;

	private Program() {
		// default setting for frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setVisible(true);
		setBounds(200, 200, getWidth(), getHeight());
		
		mainPanel = new JPanel();
		mainPanel.setBackground(Color.white);
		mainPanel.setBounds(80, 20, 400, 300);
		mainPanel.setVisible(true);

		BorderLayout layout3 = new BorderLayout();
		
		layout3.setHgap(50);
		layout3.setVgap(50);

		mainPanel.setLayout(layout3);

		JLabel gameLabel = new JLabel("Program do nauki słówek", JLabel.CENTER);
		gameLabel.setFont(new Font(Font.SANS_SERIF, 0, 30));
		gameLabel.setBounds(120, 0, 450, 50);

		JLabel modeLabel = new JLabel("Tryb ");
		// modeLabel.setBounds(x, y, width, height);

		JLabel levelLabel = new JLabel("Poziom ");
		// levelLabel.setBounds(x, y, width, height);

		JLabel directionLabel = new JLabel("Kierunek ");
		// typeGame.setBounds(x, y, width, height);

		JComboBox<String> modeComboBox = new JComboBox<>();
		modeComboBox.addItem("Tryb nauki"); // index 0
		modeComboBox.addItem("Tryb testu"); // index 1
		modeComboBox.setBounds(200, 200, 100, 30);

		JComboBox<String> levelComboBox = new JComboBox<>();
		levelComboBox.addItem("Łatwy");// index 0
		levelComboBox.addItem("Średni");// index 1
		levelComboBox.addItem("Trudny");// index 2

		JComboBox<String> directionComboBox = new JComboBox<>();
		directionComboBox.addItem("PL -> ANG");// index 0
		directionComboBox.addItem("ANG -> PL");// index 1

		JButton crudOperationsButton = new JButton("Baza słów");
		crudOperationsButton.setBounds(400, 300, 120, 25);

		JButton exitButton = new JButton("Wyjście");
		exitButton.setBounds(200, 300, 80, 25);

		JButton startGame = new JButton("Rozpocznij");
		startGame.setBounds(300, 270, 120, 25);

		//
		// DEMO & TESTING AREA
		// /*

		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(0, 2);
		layout.setVgap(20);
		panel.setLayout(layout);

		String[] poziomy = new String[] { "Łatwy", "Średni", "Trudny" };
		String[] tryby = new String[] { "Tryb nauki", "Tryb testu" };
		String[] kierunek = new String[] { "PL -> ANG", "ANG -> PL" };

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
		GridLayout layout2 = new GridLayout(0, 3);
		layout2.setHgap(40);
		layout2.setVgap(40);
		panel2.setLayout(layout2);

		UiElement exit = factory.getUiElement("BUTTON", "Wyjdź");
		UiElement start = factory.getUiElement("BUTTON", "Start");
		UiElement crud = factory.getUiElement("BUTTON", "Baza słów");

		panel2.add(exit.getElement());
		panel2.add(start.getElement());
		panel2.add(crud.getElement());

		// */
		// END
		//

		ActionListener startButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(mComboBox.getText());
				System.out.println(lComboBox.getText());
				System.out.println(dComboBox.getText());

			}

		};

		ActionListener exitButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
				dispose();

			}

		};

		start.listener(startButtonListener);
		exit.listener(exitButtonListener);

		/*
		 * 
		 * mainPanel.add(crudOperationsButton); mainPanel.add(exitButton);
		 * mainPanel.add(startGame); mainPanel.add(gameLabel);
		 * mainPanel.add(modeComboBox);
		 * 
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
		// mainPanel.add(controlPanel,BorderLayout.CENTER);

		ActionListener crudButtonListener = new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setCrudPanel();
			}

		};

		crud.listener(crudButtonListener);

		TestState test = new TestState();

		test.build();

		JPanel panel22 = test.getTestLayout();

		// mainPanel.add(panel22,BorderLayout.CENTER);
		panel.setBackground(Color.white);
		panel2.setBackground(Color.white);
		mainPanel.add(panel, BorderLayout.CENTER);
		mainPanel.add(gameLabel, BorderLayout.NORTH);
		mainPanel.add(panel2, BorderLayout.SOUTH);

		setContentPane(mainPanel);

	}

	public static int getLevel() {

		return level;

	}

	public void setLevel(int level) {

		Program.level = level;

	}

	public static JPanel setCrudPanel() {
		// panels
		JPanel crudPanel = new JPanel();
		JPanel addWordPanel = new JPanel();
		JPanel editWordPanel = new JPanel();
		JPanel deleteWordPanel = new JPanel();

		// textfields
		JTextField addPolishWordText = new JTextField();
		JTextField addEnglishWordText = new JTextField();
		JTextField editPolishWordText = new JTextField();
		JTextField editEnglishWordText = new JTextField();
		JTextField deletePolishWordText = new JTextField();
		JTextField deleteEnglishWordText = new JTextField();

		// labels
		JLabel crudLabel = new JLabel("Zarządzenie bazą słówek");
		JLabel addWordLabel = new JLabel("Dodaj nowe słowo:");
		JLabel addPolishWordLabel = new JLabel("Polskie słowo: ");
		JLabel addEnglishWordLabel = new JLabel("Angielskie słowo: ");
		JLabel editWordLabel = new JLabel("Edytuj słowo");
		JLabel deleteWordLabel = new JLabel("Usuń słowo");
    
		// buttons
		JButton addWordButton = new JButton("Dodaj słowo");
		JButton editWordButton = new JButton("Edytuj słowo");
		JButton deleteWordButton = new JButton("Usuń słowo");
		JButton backToMainButton = new JButton("Panel główny");

		// fonts
		Font addTextFieldsFont = new Font("Cambria", 0, 24);

		// lists
		wordsList = new DefaultListModel<String>();
		refreshWordsList();

		JList<String> editList = new JList<String>(wordsList);
		JScrollPane scrollEditList = new JScrollPane(editList);
		editList.setVisibleRowCount(7);
		editList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollEditList.setMinimumSize(new Dimension(180, 200));
		scrollEditList.setMaximumSize(new Dimension(180, 200));
		scrollEditList.setBorder(new LineBorder(Color.BLACK));

		JList<String> deleteList = new JList<String>(wordsList);
		JScrollPane scrollDeleteList = new JScrollPane(deleteList);
		scrollDeleteList.setMinimumSize(new Dimension(180, 200));
		scrollDeleteList.setMaximumSize(new Dimension(180, 200));
		scrollDeleteList.setBorder(new LineBorder(Color.BLACK));

		// separators
		JSeparator horizontalSeparator = new JSeparator();
		horizontalSeparator.setBounds(0, 65, 600, 2);
		horizontalSeparator.setBackground(Color.BLACK);

		// buttons options
		backToMainButton.setBounds(420, 20, 120, 30);
		addWordButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		editWordButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteWordButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		// panels options
		crudPanel.setSize(600, 400);
		crudPanel.setLayout(null);
		crudPanel.setBackground(Color.white);
		addWordPanel.setBackground(Color.green);
		addWordPanel.setLayout(new BoxLayout(addWordPanel, BoxLayout.Y_AXIS));
		addWordPanel.setBounds(10, 80, 185, 280);
		addWordPanel.setBorder(new LineBorder(Color.BLACK));

		editWordPanel.setBackground(Color.yellow);
		editWordPanel.setLayout(new BoxLayout(editWordPanel, BoxLayout.Y_AXIS));
		editWordPanel.setBounds(205, 80, 185, 280);
		editWordPanel.setBorder(new LineBorder(Color.BLACK));

		deleteWordPanel.setBackground(Color.red);
		deleteWordPanel.setLayout(new BoxLayout(deleteWordPanel, BoxLayout.Y_AXIS));
		deleteWordPanel.setBounds(400, 80, 185, 280);
		deleteWordPanel.setBorder(new LineBorder(Color.BLACK));

		// labels options
		crudLabel.setBounds(40, 10, 360, 50);
		crudLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));
		addWordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		addWordLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 14));
		addWordLabel.setForeground(Color.BLACK);
		addPolishWordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		addEnglishWordLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

		// text fields options
		addPolishWordText.setMaximumSize(new Dimension(150, 50));
		addPolishWordText.setAlignmentX(Component.CENTER_ALIGNMENT);
		addPolishWordText.setToolTipText("Słowo polskie");
		addEnglishWordText.setMaximumSize(new Dimension(150, 50));
		addEnglishWordText.setAlignmentX(Component.CENTER_ALIGNMENT);
		addEnglishWordText.setToolTipText("Słowo angielskie");

		editPolishWordText.setMaximumSize(new Dimension(150, 30));
		editPolishWordText.setAlignmentX(Component.CENTER_ALIGNMENT);
		editPolishWordText.setToolTipText("Słowo polskie");
		editEnglishWordText.setMaximumSize(new Dimension(150, 30));
		editEnglishWordText.setAlignmentX(Component.CENTER_ALIGNMENT);
		editEnglishWordText.setToolTipText("Słowo angielskie");

		deletePolishWordText.setMaximumSize(new Dimension(150, 30));
		deletePolishWordText.setAlignmentX(Component.CENTER_ALIGNMENT);
		deletePolishWordText.setToolTipText("Słowo polskie");
		deleteEnglishWordText.setMaximumSize(new Dimension(150, 30));
		deleteEnglishWordText.setAlignmentX(Component.CENTER_ALIGNMENT);
		deleteEnglishWordText.setToolTipText("Słowo angielskie");

		addPolishWordText.setFont(addTextFieldsFont);
		addEnglishWordText.setFont(addTextFieldsFont);

		// set to panels
		addWordPanel.add(addWordLabel);
		addWordPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addWordPanel.add(addPolishWordLabel);
		addWordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		addWordPanel.add(addPolishWordText);
		addWordPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addWordPanel.add(addEnglishWordLabel);
		addWordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		addWordPanel.add(addEnglishWordText);
		addWordPanel.add(Box.createRigidArea(new Dimension(0, 20)));
		addWordPanel.add(addWordButton);

		editWordPanel.add(scrollEditList);
		editWordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		editWordPanel.add(editPolishWordText);
		editWordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		editWordPanel.add(editEnglishWordText);
		editWordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		editWordPanel.add(editWordButton);

		deleteWordPanel.add(scrollDeleteList);
		deleteWordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		deleteWordPanel.add(deletePolishWordText);
		deleteWordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		deleteWordPanel.add(deleteEnglishWordText);
		deleteWordPanel.add(Box.createRigidArea(new Dimension(0, 5)));
		deleteWordPanel.add(deleteWordButton);

		// action listeners
		addWordButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (addPolishWordText.getText().length() > 0 && addEnglishWordText.getText().length() > 0) {
					dbOperations.create(addPolishWordText.getText().toString(),
							addEnglishWordText.getText().toString());
					JOptionPane.showMessageDialog(null, "Poprawnie dodane słowo");
					addPolishWordText.setText("");
					addEnglishWordText.setText("");
					refreshWordsList();
					editList.setModel(wordsList);
				} else {
					JOptionPane.showMessageDialog(null, "Pola nie mogą być puste");
				}

			}
		});

		editWordButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (editList.isSelectedIndex(editList.getSelectedIndex())) {
					if (editPolishWordText.getText().length() > 0 && editEnglishWordText.getText().length() > 0) {
						dbOperations.update(editList.getSelectedIndex(), editPolishWordText.getText().toString(),
								editEnglishWordText.getText().toString());
						JOptionPane.showMessageDialog(null, "Słowo edytowane poprawnie");
						refreshWordsList();
						editList.setModel(wordsList);
					} else {
						JOptionPane.showMessageDialog(null, "Pola nie mogą być puste");
					}
				}
			}
		});

		deleteWordButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (deleteList.isSelectedIndex(deleteList.getSelectedIndex())) {
					dbOperations.delete(deleteList.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Słowo usunięte poprawnie");
					refreshWordsList();
					editList.setModel(wordsList);
				}
			}
		});

		editList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (editList.isSelectedIndex(editList.getSelectedIndex())) {
					Map<String, String> selectedWord = dbOperations.read(editList.getSelectedIndex());
					editPolishWordText.setText((String) selectedWord.keySet().toArray()[0]);
					editEnglishWordText.setText(selectedWord.get(selectedWord.keySet().toArray()[0]));
				}
			}
		});

		deleteList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {

				if (deleteList.isSelectedIndex(deleteList.getSelectedIndex())) {
					Map<String, String> selectedWord = dbOperations.read(deleteList.getSelectedIndex());
					deletePolishWordText.setText((String) selectedWord.keySet().toArray()[0]);
					deleteEnglishWordText.setText(selectedWord.get(selectedWord.keySet().toArray()[0]));
				}

			}
		});
		
		backToMainButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {		
				program.getContentPane().removeAll();
				program.getContentPane().setBackground(Color.white);				
				program.setContentPane(mainPanel);
				program.revalidate();
				program.repaint();
				
				
			}
		});

		crudPanel.add(crudLabel);
		crudPanel.add(backToMainButton);
		crudPanel.add(addWordPanel);
		crudPanel.add(horizontalSeparator);
		crudPanel.add(editWordPanel);
		crudPanel.add(deleteWordPanel);
		program.setContentPane(crudPanel);

		return crudPanel;
	}

	private static void refreshWordsList() {
		wordsList.clear();
		for (int i = 0; i < dbOperations.getWordsCount(); i++) {
			wordsList.addElement((String) dbOperations.read(i).keySet().toArray()[0]);
		}
	}

	public static void main(String[] args) {
		program = new Program();
	}

}
