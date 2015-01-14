package chatbot.view;

import javax.swing.JFrame;
import chatbot.controller.ChatbotAppController;
import javax.swing.JButton;

public class ChatbotFrame extends JFrame
{
	private ChatbotPanel basePanel;
	
	public ChatbotFrame(ChatbotAppController baseController)
	{
		basePanel = new ChatbotPanel(baseController);
		
		setupFrame();
	}
	

	private void setupFrame()
	{
		this.setContentPane(basePanel);
		this.setSize(420, 420);
		this.setResizable(true);
		setVisible(true);
		
	}
}