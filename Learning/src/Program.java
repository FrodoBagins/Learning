import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
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
//	private static JPanel mainPanel = new JPanel();
	private static Program program;
	private static DefaultListModel<String> wordsList;
	private static IDbOperations dbOperations = new DbAdapter();
	private LinkedList<Command> undoHistory = new LinkedList<Command>();
	private LinkedList<Command> redoHistory = new LinkedList<Command>();
	private static State state;
	private boolean englishPolish;
	private static int score;
	private static int questionNumber;
	private static List<String> choosedQuestions = new ArrayList<String>();
	private static List<String> correctAnswers = new ArrayList<String>();
	private static List<String[]> incorrectAnswers = new ArrayList<String[]>();
	private static int[] selectedComboBox = new int[10];
	private static int[] randomNumber = new int[10];
	private static String[] selectedTextBox = new String[10];
	private static int level;
	private static int actualQuestion;
	private Builder builder;
//	private JButton startButton;
//	private JButton exitButton;
	private static JComboBox<String> directionComboBox;
	private static JComboBox<String> modeComboBox;
	private static JComboBox<String> levelComboBox;

	private Program() {

		// default setting for frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		getContentPane().setBackground(Color.white);
		setResizable(false);
		setVisible(true);
		setBounds(200, 200, getWidth(), getHeight());
		
		setContentPane(Program.setMainPanel());

	}
	
	public static void showMainPanel(){
		
		System.out.println("DUPA");
		program.getContentPane().removeAll();
		program.getContentPane().setBackground(Color.white);
		program.setContentPane(Program.setMainPanel());
		program.revalidate();
		program.repaint();
	}
	
	public static void setSelectedComboBox(int value, int number) {
		
		
		Program.selectedComboBox[number-1]= value;
		
		
	}
	
	
	public static int getSelectedComboBox(int number){
		
		return selectedComboBox[number-1];
	}
	
	
	public static void setSelectedRandom(int value, int number) {
		
		
		Program.randomNumber[number-1]= value;
		
		
	}
	
	
	public static int getSelectedRandom(int number){
		
		return randomNumber[number-1];
	}
	
	public static void setSelectedTextBox(String value, int number) {
		
		
		Program.selectedTextBox[number-1]= value;
		
		
	}
	
	public static String getSelectedTextBox(int number){
		
		return selectedTextBox[number-1];
	}
	
	
	public static void nextLearnState() {
		
		program.setActualQuestion(Program.getActualQuestion()+1);
		
		JPanel panelLearn = new JPanel();
						
		state = new LearnState();

		state.build();
		
		panelLearn = state.getTestLayout();
		
		program.getContentPane().removeAll();
		System.out.println("powrót do menu");
		program.getContentPane().setBackground(Color.white);
		program.setContentPane(panelLearn);
		program.revalidate();
		program.repaint();
			
	}
	
	
	public static void nextTestState() {
		
		program.setActualQuestion(Program.getActualQuestion()+1);
		
		JPanel panelLearn = new JPanel();
						
		state = new TestState();

		state.build();
		
		panelLearn = state.getTestLayout();
		
		program.getContentPane().removeAll();
		System.out.println("powrót do menu");
		program.getContentPane().setBackground(Color.white);
		program.setContentPane(panelLearn);
		program.revalidate();
		program.repaint();
			
	}
	
	
	public static void previousTestState() {
		
		program.setActualQuestion(Program.getActualQuestion()-1);
		
		JPanel panelLearn = new JPanel();
						
		state = new TestState();

		state.build();
		
		panelLearn = state.getTestLayout();
		
		program.getContentPane().removeAll();
		System.out.println("powrót do menu");
		program.getContentPane().setBackground(Color.white);
		program.setContentPane(panelLearn);
		program.revalidate();
		program.repaint();
			
	}

	public static JPanel setMainPanel() {
		
		JPanel mainPanel = new JPanel();
		
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
		JLabel levelLabel = new JLabel("Poziom ");
		JLabel directionLabel = new JLabel("Kierunek ");

		modeComboBox = new JComboBox<>();
		modeComboBox.addItem("Tryb nauki"); // index 0
		modeComboBox.addItem("Tryb testu"); // index 1
		modeComboBox.setBounds(200, 200, 100, 30);

		levelComboBox = new JComboBox<>();
		levelComboBox.addItem("Łatwy");// index 0
		levelComboBox.addItem("Średni");// index 1
		levelComboBox.addItem("Trudny");// index 2

		directionComboBox = new JComboBox<>();
		directionComboBox.addItem("PL -> ANG");// index 0
		directionComboBox.addItem("ANG -> PL");// index 1

		JButton crudOperationsButton = new JButton("Baza słów");
		crudOperationsButton.setBounds(400, 300, 120, 25);

		JButton exitButton = new JButton("Wyjście");
		exitButton.setBounds(200, 300, 80, 25);

		JButton startGame = new JButton("Rozpocznij");
		startGame.setBounds(300, 270, 120, 25);

		JPanel panel = new JPanel();
		GridLayout layout = new GridLayout(0, 2);
		layout.setVgap(20);
		panel.setLayout(layout);

		panel.add(modeLabel);
		panel.add(modeComboBox);
		panel.add(levelLabel);
		panel.add(levelComboBox);
		panel.add(directionLabel);
		panel.add(directionComboBox);

		JPanel panel2 = new JPanel();
		GridLayout layout2 = new GridLayout(0, 3);
		layout2.setHgap(40);
		layout2.setVgap(40);
		panel2.setLayout(layout2);

		panel2.add(exitButton);
		panel2.add(startGame);
		panel2.add(crudOperationsButton);

		
		

		startGame.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				choosedQuestions.clear();
				correctAnswers.clear();
				incorrectAnswers.clear();
				selectedComboBox = new int[10];
				randomNumber = new int[10];
				selectedTextBox = new String[10];
				
				program.makeQuestions(10);
				program.makeWrongAnswers(10);
				program.setQuestionNumber(10);
				program.setScore(0);
				program.showMeNow();
				
			//	Program.selectedComboBox = new int[10]
				
				
				program.setActualQuestion(1);
				
		   		if(levelComboBox.getSelectedIndex()==0) program.setLevel(1);
  				if(levelComboBox.getSelectedIndex()==1) program.setLevel(2);
  				if(levelComboBox.getSelectedIndex()==2) program.setLevel(3);
				
  				JPanel panel22 = new JPanel();
  				
  				
  				if(modeComboBox.getSelectedIndex()==0)
  				{
  					
				state = new LearnState();

				state.build();

			    panel22 = state.getTestLayout(); }
  				
  				else {
  					state = new TestState();

  					state.build();

  				    panel22 = state.getTestLayout(); 
  				}
				
				
								
				program.getContentPane().removeAll();
				System.out.println("powrót do menu");
				program.getContentPane().setBackground(Color.white);
				program.setContentPane(panel22);
				program.revalidate();
				program.repaint();




			}
		});

		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			program.setVisible(false);
			program.dispose();

			}
		});


		crudOperationsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				setCrudPanel();
				System.out.println("NAPIS");
				
			}
		});


		panel.setBackground(Color.white);
		panel2.setBackground(Color.white);
		mainPanel.add(panel, BorderLayout.CENTER);
		mainPanel.add(gameLabel, BorderLayout.NORTH);
		mainPanel.add(panel2, BorderLayout.SOUTH);

	//	program.setContentPane(mainPanel);
		return mainPanel;
			
		
	}
	
	public void makeQuestions(int numberOfQuestions) {
		int dataBaseSize = dbOperations.getWordsCount();
		correctAnswers.clear();
		choosedQuestions.clear();
		if (numberOfQuestions > dataBaseSize) {
			JOptionPane.showMessageDialog(null, "Nie ma wystarczająco pytań w bazie");
		} else {

			Random random = new Random();
			Map<Integer, Integer> choosedNumbers = new HashMap<Integer, Integer>();
			for (int i = 0; i < numberOfQuestions; i++) {
				int randomNumber = random.nextInt(dataBaseSize);
				while (choosedNumbers.containsKey(randomNumber)) {
					randomNumber = random.nextInt(dataBaseSize);
				}
				Map<String, String> selectedQuestion = dbOperations.read(randomNumber);
				if (directionComboBox.getSelectedIndex() == 0) {
					choosedQuestions.add((String) selectedQuestion.keySet().toArray()[0]);
					correctAnswers.add(selectedQuestion.get((String) selectedQuestion.keySet().toArray()[0]));
				} else {
					choosedQuestions.add(selectedQuestion.get((String) selectedQuestion.keySet().toArray()[0]));
					correctAnswers.add((String) selectedQuestion.keySet().toArray()[0]);

				}
				choosedNumbers.put(randomNumber, 0);

			}
		}
	}

	public void makeWrongAnswers(int NumberOfWrongAnswers) { // for each
																// question
		int numberOfQuestions = choosedQuestions.size();
		if (numberOfQuestions == 0)
			throw new NullPointerException("Choose questions first");
		if (NumberOfWrongAnswers <= dbOperations.getWordsCount() - 1) {
			Random random = new Random();
			for (int i = 0; i < numberOfQuestions; i++) {
				// random question
				String wrongAnswers[] = new String[NumberOfWrongAnswers];
				for (int j = 0; j < NumberOfWrongAnswers; j++) {
					Map<String, String> randomQuestion = dbOperations
							.read(random.nextInt(dbOperations.getWordsCount()));
					if (directionComboBox.getSelectedIndex() == 0) {
						while (randomQuestion.keySet().toArray()[0].toString().equals(choosedQuestions.get(i))
								|| Arrays.asList(wrongAnswers).contains(
										randomQuestion.get(randomQuestion.keySet().toArray()[0].toString()))) {
							randomQuestion = dbOperations.read(random.nextInt(dbOperations.getWordsCount()));
						}
						wrongAnswers[j] = randomQuestion.get((String) randomQuestion.keySet().toArray()[0]);

					} else {
						while (randomQuestion.get((String) randomQuestion.keySet().toArray()[0])
								.equals(choosedQuestions.get(i)) || Arrays.asList(wrongAnswers).contains(randomQuestion.keySet().toArray()[0].toString())) {
							randomQuestion = dbOperations.read(random.nextInt(dbOperations.getWordsCount()));
						}
						wrongAnswers[j] = (String) randomQuestion.keySet().toArray()[0];

					}
				}
				incorrectAnswers.add(wrongAnswers);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Nie wystarczająca ilość pytań błędnych w bazie dla tego poziomu");
		}
	}

	public void showMeNow() {
		System.out.println("Choosed: ");
		for (String s : choosedQuestions) {
			System.out.println(s);
		}
		System.out.println("Correct answers");
		for (String s : correctAnswers) {
			System.out.println(s);
		}
		System.out.println("Wrong answers");
		for (String[] tab : incorrectAnswers) {
			for (String k : tab) {
				System.out.println(k);

			}
			System.out.println("----");
		}
	}
	
	
	public static List<String> getCorrectAnswers(){
		return correctAnswers;
	}
	
	public static List<String> getChoosedQuestions() {
		return choosedQuestions;
	}
	
	public static List<String[]> getIncorrectAnswers() {
		return incorrectAnswers;
	}

	public static int getLevel() {

		return level;

	}

	public void setLevel(int level) {

		Program.level = level;

	}
	
	
	public static int getScore() {
		
		int punkty=0;
		
		for(int i = 0;i<10;i++)
		{
			if(correctAnswers.get(i).equals(selectedTextBox[i])  )
				punkty++;
			
		}
		
		
		return punkty;
	}
	
	public static void setScore(int scores) {
		
		Program.score = scores;
	}
	
	public static int getActualQuestion() {

		return actualQuestion;

	}

	public void setActualQuestion(int level) {

		Program.actualQuestion = level;

	}
	
	public static int getQuestionNumber() {

		return questionNumber;

	}

	public void setQuestionNumber(int level) {

		Program.questionNumber = level;

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
				System.out.println("powrót do menu");
				program.getContentPane().setBackground(Color.white);
				program.setContentPane(setMainPanel());
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
	
	public static void setScorePanel(){
		JPanel scorePanel = new JPanel();
		scorePanel.setLayout(null);
		JLabel scoreLabel = new JLabel("Zdobyłeś " + Program.getScore() +"/ "+correctAnswers.size()+" punktów !");
		scoreLabel.setBounds(100, 150, 400, 50);
		scoreLabel.setHorizontalAlignment(JLabel.CENTER);
		scoreLabel.setVerticalAlignment(JLabel.CENTER);
		Font font = new Font("cambria", Font.BOLD, 25);
		JButton backButton = new JButton("Menu głowne");
		backButton.setBounds(250, 300, 120, 40);
		scoreLabel.setFont(font);
		scorePanel.setSize(600, 400);
		scorePanel.setBackground(Color.white);
		scorePanel.add(scoreLabel);
		scorePanel.add(backButton);
		
		backButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				program.setContentPane(setMainPanel());
				program.revalidate();
				program.repaint();
				
			}
		});
		
		program.setContentPane(scorePanel);
		program.setVisible(true);
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
