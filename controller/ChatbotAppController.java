package chatbot.controller;

import javax.swing.JOptionPane;

import chatbot.model.Chatbot;
import chatbot.view.ChatbotFrame;
import chatbot.view.ChatbotPanel;
import chatbot.view.ChatbotView;

/**
 * Runs the Chatbot Project. Owns the model and associated views.
 * 
 * @author John Stewart Wells
 * @version 1.2 10/2/14
 */
public class ChatbotAppController
{
	private ChatbotView applicationView;
	private Chatbot mySillyChatbot;
	private String startMessage;
	private String quitMessage;
	private ChatbotFrame appFrame;

	public ChatbotAppController()
	{
		applicationView = new ChatbotView(this);
		appFrame = new ChatbotFrame(this);
		mySillyChatbot = new Chatbot("derf");
		startMessage = "Greetings traveler! Welcome to the " + mySillyChatbot.getName() + " chatbot. \n" +  "What is thy name? \n";
		quitMessage = " Goodbye cruel user! :'(";
	}

	public Chatbot getMySillyChatbot()
	{
		return mySillyChatbot;
	}

	public void start()
	{
		((ChatbotPanel) appFrame.getContentPane()).showMessage(startMessage);
	}
	
	public String getChatbotDialog(String Input)
	{
		String result = "";
		
		if (mySillyChatbot.quitChecker(Input))
		{
			quit();
		}
		result = mySillyChatbot.processText(Input);
		return result;
	}

	private void quit()
	{
		applicationView.showChatbotMessage(quitMessage);
		System.exit(0);
	}
}