import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class RadioPanelBuilder implements Builder {

	private JPanel panel = new JPanel();

	private JButton nextButton;

	private IWord answer1;
	private IWord answer2;
	private IWord answer3;
	private IWord answer4;

	private int selectedAnswerNumber;
	private String rightAnswer;

	private JPanel buttonPanel = new JPanel();
	private JRadioButton radio1 = new JRadioButton();
	private JRadioButton radio2 = new JRadioButton();
	private JRadioButton radio3 = new JRadioButton();
	private JRadioButton radio4 = new JRadioButton();

	private List<String[]> wrongAnswers;

	private ButtonGroup group;

	@Override
	public void addQuestion(String quest) {
		panel.setLayout(new BorderLayout());

		String question = new String("(Pytanie " + Program.getActualQuestion() + "/"
				+ Program.getCorrectAnswers().size() + ") Przetłumacz:  " + quest);

		JLabel gameLabel = new JLabel(question, JLabel.CENTER);
		panel.add(gameLabel, BorderLayout.NORTH);

	}

	@Override
	public void addAnswer(IWord answer) {

		rightAnswer = answer.getWord().getText();

		wrongAnswers = Program.getIncorrectAnswers();

		String[] wrongAnswer = wrongAnswers.get(Program.getActualQuestion() - 1);


		Random rand = new Random();
		int n = 0;

		answer1 = new WordDecoratorRed(new Word(wrongAnswer[0]));
		answer2 = new WordDecoratorRed(new Word(wrongAnswer[1]));
		answer3 = new WordDecoratorRed(new Word(wrongAnswer[2]));
		answer4 = new WordDecoratorRed(new Word(wrongAnswer[3]));

		if (Program.getLevel() == 2) {
			n = rand.nextInt(4);
		}

		if (Program.getLevel() == 1) {
			n = rand.nextInt(2);
		}

		if (Program.getSelectedRandom(Program.getActualQuestion()) > 0)
			n = Program.getSelectedRandom(Program.getActualQuestion()) - 1;
		else
			Program.setSelectedRandom(n + 1, Program.getActualQuestion());

		switch (n) {

		case 0:
			answer1 = new WordDecoratorGreen(new Word(answer.getWord().getText()));
			break;

		case 1:
			answer2 = new WordDecoratorGreen(new Word(answer.getWord().getText()));
			break;

		case 2:
			answer3 = new WordDecoratorGreen(new Word(answer.getWord().getText()));
			break;

		case 3:
			answer4 = new WordDecoratorGreen(new Word(answer.getWord().getText()));
			;
			break;

		}

		group = new ButtonGroup();

		JPanel controlPanel = new JPanel();
		
		controlPanel.setLayout(new GridLayout(2, 1));
		controlPanel.setPreferredSize(new Dimension(50, 50));

		JPanel buttonPanel = new JPanel();
		GridLayout layout2 = new GridLayout(3, 3);
		buttonPanel.setLayout(layout2);

		group.add(radio1);
		group.add(radio2);
		
		answer1.getWord().setBorder(BorderFactory.createEmptyBorder(50, 0, 0, 0));
		answer2.getWord().setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		radio1.setBorder(BorderFactory.createEmptyBorder(50, 250, 0, 0));
		radio2.setBorder(BorderFactory.createEmptyBorder(0, 250, 0, 0));

		controlPanel.add(radio1);
		controlPanel.add(answer1.getWord());
		controlPanel.add(radio2);
		controlPanel.add(answer2.getWord());

		if (Program.getLevel() == 2) {
			
			answer3.getWord().setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
			answer4.getWord().setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));
			
			radio3.setBorder(BorderFactory.createEmptyBorder(0, 250, 50, 0));
			radio4.setBorder(BorderFactory.createEmptyBorder(0, 250, 50, 0));

			group.add(radio3);
			group.add(radio4);
			controlPanel.setLayout(new GridLayout(4, 1));
			controlPanel.add(radio3);
			controlPanel.add(answer3.getWord());
			controlPanel.add(radio4);
			controlPanel.add(answer4.getWord());

		}
		
		

		if (Program.getAnswerRadioButton(Program.getActualQuestion()) == 1)
			radio1.setSelected(true);
		if (Program.getAnswerRadioButton(Program.getActualQuestion()) == 2)
			radio2.setSelected(true);
		if (Program.getAnswerRadioButton(Program.getActualQuestion()) == 3)
			radio3.setSelected(true);
		if (Program.getAnswerRadioButton(Program.getActualQuestion()) == 4)
			radio4.setSelected(true);

		
		controlPanel.setSize(100, 100);
		
		panel.add(controlPanel, BorderLayout.CENTER);

	}

	@Override
	public void addButton(String button) {

		// buttonPanel = new JPanel();

		if (button.equals("EXIT")) {

			JButton exitButton = new JButton();
			exitButton.setText("EXIT");

			ActionListener exitListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					System.out.println("EXIT");

					Program.showMainPanel();

				}
			};

			exitButton.addActionListener(exitListener);
			buttonPanel.add(exitButton);

		}

		if (button.equals("CHECK")) {

			JButton checkButton = new JButton();

			checkButton.setText("CHECK");

			ActionListener checkListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

					if (radio1.isSelected())
						selectedAnswerNumber = 1;
					if (radio2.isSelected())
						selectedAnswerNumber = 2;
					if (radio3.isSelected())
						selectedAnswerNumber = 3;
					if (radio4.isSelected())
						selectedAnswerNumber = 4;

					switch (selectedAnswerNumber) {

					case 1:
						answer1.decorate(answer1.getWord());
						if (answer1.getWord().getText() == rightAnswer) {
							radio1.setEnabled(false);
							radio2.setEnabled(false);
							radio3.setEnabled(false);
							radio4.setEnabled(false);
							nextButton.setEnabled(true);

						}
						break;

					case 2:
						answer2.decorate(answer2.getWord());
						if (answer2.getWord().getText() == rightAnswer) {
							radio1.setEnabled(false);
							radio2.setEnabled(false);
							radio3.setEnabled(false);
							radio4.setEnabled(false);
							nextButton.setEnabled(true);
						}
						break;

					case 3:
						answer3.decorate(answer3.getWord());
						if (answer3.getWord().getText() == rightAnswer) {
							radio1.setEnabled(false);
							radio2.setEnabled(false);
							radio3.setEnabled(false);
							radio4.setEnabled(false);
							nextButton.setEnabled(true);
						}

						break;
					case 4:
						answer4.decorate(answer4.getWord());
						if (answer4.getWord().getText() == rightAnswer) {
							radio1.setEnabled(false);
							radio2.setEnabled(false);
							radio3.setEnabled(false);
							radio4.setEnabled(false);
							nextButton.setEnabled(true);
						}
						break;

					}

					if (Program.getActualQuestion() == Program.getQuestionNumber()) {

						nextButton.setEnabled(false);

					}

					System.out.println("CHECK" + selectedAnswerNumber);
				}
			};

			checkButton.addActionListener(checkListener);
			buttonPanel.add(checkButton);
		}

		if (button.equals("NEXT")) {
			nextButton = new JButton();
			nextButton.setText("NEXT");

			ActionListener nextListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

					// if(Program.getActualQuestion()==Program.getQuestionNumber())
					// {

					// nextButton.setEnabled(false);

					// }
					// if(Program.getActualQuestion()==Program.getQuestionNumber())
					// Program.showMainPanel();

					Program.nextLearnStateQuestion();

					System.out.println("NEXT");
				}
			};

			nextButton.setEnabled(false);
			nextButton.addActionListener(nextListener);
			buttonPanel.add(nextButton);
		}

		radio1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Program.setAnswerText(answer1.getWord().getText(), Program.getActualQuestion());
				Program.setAnswerRadioButton(1, Program.getActualQuestion());
				
			}
		});
		
		radio2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Program.setAnswerText(answer2.getWord().getText(), Program.getActualQuestion());
				Program.setAnswerRadioButton(2, Program.getActualQuestion());
				
			}
		});
		
		radio3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Program.setAnswerText(answer3.getWord().getText(), Program.getActualQuestion());
				Program.setAnswerRadioButton(3, Program.getActualQuestion());
				
			}
		});
		
		radio4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Program.setAnswerText(answer4.getWord().getText(), Program.getActualQuestion());
				Program.setAnswerRadioButton(4, Program.getActualQuestion());
				
			}
		});
		if (button.equals("PREV")) {
			JButton prevButton = new JButton();

			prevButton.setText("PREV");

			ActionListener prevListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

					System.out.println(Program.getAnswerRadioButton(Program.getActualQuestion()) + "    "
							+ Program.getActualQuestion() + " "
							+ Program.getAnswerText(Program.getActualQuestion()));

					if (Program.getActualQuestion() > 1)
						Program.previousTestStateQuestion();

					System.out.println("PREV");
				}
			};

			prevButton.addActionListener(prevListener);
			buttonPanel.add(prevButton);
		}

		if (button.equals("NEXTTEST")) {
			nextButton = new JButton();
			nextButton.setText("NEXT");
			if (Program.getActualQuestion() == Program.getQuestionNumber()) {

				nextButton.setEnabled(false);

			}

			ActionListener nextListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

					System.out.println(Program.getAnswerRadioButton(Program.getActualQuestion()) + "    "
							+ Program.getActualQuestion() + " "
							+ Program.getAnswerText(Program.getActualQuestion()));

					if (Program.getActualQuestion() < Program.QUESTIONS_NUMBER)
						Program.nextTestStateQuestion();
					else {
						Program.setScorePanel();
					}

				}

			};

			nextButton.addActionListener(nextListener);
			buttonPanel.add(nextButton);
		}

		if (button.equals("SCORE")) {
			JButton prevButton = new JButton();

			prevButton.setText("SCORE");

			ActionListener prevListener = new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {

					Program.setScorePanel();

					System.out.println("SCORE");
				}
			};

			prevButton.addActionListener(prevListener);
			buttonPanel.add(prevButton);
		}

		panel.add(buttonPanel, BorderLayout.SOUTH);

	}

	public JPanel getPanel() {

		return this.panel;
	}

}
