package chatbot.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.SpringLayout;
import javax.swing.text.StyleConstants;

import chatbot.controller.ChatbotAppController;
import chatbot.model.ChatbotUser;

public class ChatbotPanel extends JPanel
{
	private ChatbotAppController baseController;

	public JButton firstButton;
	public JTextField firstTextField;
	private SpringLayout baseLayout;
	public  JTextArea chatArea;
	private JScrollPane chatPane;

	public ChatbotPanel(ChatbotAppController baseController)
	{
		this.baseController = baseController;
		firstButton = new JButton("Click me");
		firstTextField = new JTextField(25);
		baseLayout = new SpringLayout();
		chatArea = new JTextArea(4, 20);
		chatPane = new JScrollPane(chatArea);

		setupPanel();
		setupPane();
		setupLayout();
		setupListeners();
	}

	public void showMessage(String userInput)
	{
		chatArea.append(userInput);
	}
	

	private void setupPane()
	{
		chatArea.setLineWrap(true);
		chatArea.setWrapStyleWord(true);
		chatArea.setEditable(false);
	}

	private void setupPanel()
	{
		this.setBackground(Color.BLUE);
		this.setSize(400, 400);
		this.setLayout(baseLayout);
		this.add(firstButton);
		this.add(firstTextField);
		this.add(chatPane);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, firstTextField, 0, SpringLayout.SOUTH, firstButton);
		baseLayout.putConstraint(SpringLayout.NORTH, firstButton, 45, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, firstTextField, 46, SpringLayout.SOUTH, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, firstTextField, 256, SpringLayout.WEST, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, firstButton, 0, SpringLayout.EAST, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, firstTextField, 0, SpringLayout.WEST, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 45, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 20, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -100, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -20, SpringLayout.EAST, this);
	}

	private void setupListeners()
	{

		firstButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			
			{
				String currentInput = firstTextField.getText();
				String result = baseController.getChatbotDialog(currentInput);
				showMessage(currentInput + "\n");
				showMessage(result + "\n");
				firstTextField.setText("");
				firstTextField.requestFocus();
			}
		});
	}
}