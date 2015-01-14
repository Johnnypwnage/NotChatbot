package chatbot.model;

import java.util.ArrayList;

/**
 * The chatbot model class. Used for checking and manipulating strings
 * @author John Wells
 * @version 1.1 8/26/14
 */

import java.util.Random;
import java.util.Scanner;
import java.math.*;

import chatbot.view.ChatbotPanel;
import chatbot.view.ChatbotView;

public class Chatbot
{
	private ArrayList<String> memeList;
	private String name;
	private int chatCount;
	private ChatbotUser ChatbotUser;
	private Random randomGenerator;
	private int randomQuestionInt;
	private boolean askingAboutSwords;
	private int weaponQuestionCount;
	private boolean askingAboutWeapons;
	private String chatbotWeaponChoice;

	/**
	 * Creates a Chatbot object with the supplied name and initializes the
	 * current number of chats to 0
	 * 
	 * @param name
	 */

	public Chatbot(String name)
	{
		askingAboutWeapons = false;
		memeList = new ArrayList<String>();
		this.name = name;
		chatCount = 0;
		weaponQuestionCount = 0;
		ChatbotUser = new ChatbotUser();
		randomGenerator = new Random();
		fillTheMemeList();
	}

	public String getName()
	{
		return name;
	}

	// public int getChatCount()
	// {
	// return chatCount;
	// }

	public void setname(String name)
	{
		this.name = name;
	}

	private void fillTheMemeList()
	{
		memeList.add("one does not simply");
		memeList.add("Doge");
		memeList.add("Y U NO");
		memeList.add("Good Guy Greg");
		memeList.add("Sucsess Kid");
		memeList.add("Scumbag Steve");
	}

	{

	}

	public int getChatCount()
	{
		return chatCount;
	}

	public String processText(String currentInput)

	{
		String result = "";

		if (getChatCount() < 2)
		{

			if (getChatCount() == 0)
			{
				ChatbotUser.setUserName(currentInput);
				ChatbotUser.setUserQuestion("'tis a good name. " + ChatbotUser.getName() + " how old art thou?");
			}

			else if (getChatCount() == 1)
			{
				int userAge = Integer.parseInt(currentInput);
				ChatbotUser.setAge(userAge);
				if (ChatbotUser.getAge() <= 0)
				{
					ChatbotUser.setUserQuestion("Thou art lieing! 'tis not possible!");
					chatCount--;
				} else if (ChatbotUser.getAge() <= 18)
				{
					ChatbotUser.setUserQuestion("Thou art just a child! Would thou care to test thine skills in battle?");
				} else if (ChatbotUser.getAge() <= 100)
				{
					ChatbotUser.setUserQuestion("Thou might serve as a worthy opponent in a duel.. Would thou care to test thine skills in battle?");
				} else
				{
					ChatbotUser.setUserQuestion("Thou art certainly older than I and thou certainly are not human! Would thou care to test thine skills in battle?");
				}

			}

		}

		else if (getChatCount() >= 2)
		{

			if (askingAboutWeapons == true)
			{
				askAboutWeapons();
			} else if (askingAboutWeapons == false)
			{
				randomQuestionInt = (int) (Math.random() * 5);
				if (randomQuestionInt == 0)
				{
					askAboutWeapons();
				}

				else if (randomQuestionInt ==2)
				{
					ChatbotUser.setUserQuestion("Hahahaha! Thou art nothing but a lowly whench!");
				}
				
				else
				{
					ChatbotUser.setUserQuestion("I am an adherant to the Lord of Sunlight, and now that I am a chatbot, I have come to this great land in search of my very own sun!");
				}
			}
		}
		updateChatCount();
		return ChatbotUser.getQuestion();
	}

	public void askAboutWeapons()
	{
		int chatbotWeaponChoiceInt = (int) (Math.random() * 4);
		{
			if (chatbotWeaponChoiceInt == 0)
			{
				chatbotWeaponChoice = "sword";
			} else if (chatbotWeaponChoiceInt == 1)
			{
				chatbotWeaponChoice = "battle-axe";
			} else if (chatbotWeaponChoiceInt == 2)
			{
				chatbotWeaponChoice = "butter knife";
			}else if (chatbotWeaponChoiceInt == 3)
			{
				chatbotWeaponChoice = "my fists";
			}
		}

		switch (weaponQuestionCount)
		{

		case 0:
			ChatbotUser.setUserQuestion("What is thy weapon of choice?");
			askingAboutWeapons = true;
			weaponQuestionCount++;
			break;

		case 1:
			ChatbotUser.setUserQuestion("I prefer a " + chatbotWeaponChoice + ".\nHow skilled art thou with thine weapon?");
			weaponQuestionCount++;
			break;

		case 2:
			ChatbotUser.setUserQuestion("Good, thou might serve as a fantastic opponent");
			weaponQuestionCount = 0;
			askingAboutWeapons = false;

		}
	}

	public String introduceUser(String input)
	{
		String result = "";
		return result;
	}

	private void updateChatCount()
	{
		chatCount++;
	}

	private boolean memeChecker(String input)
	{
		boolean isAMeme = false;

		for (String currentMeme : memeList)
		{
			if (input.equalsIgnoreCase(currentMeme))
			{
				isAMeme = true;
			}
		}

		for (int loopCounter = 0; loopCounter < memeList.size(); loopCounter++)
		{
			if (input.equalsIgnoreCase(memeList.get(loopCounter)))
			{
				isAMeme = true;
			}
		}
		return isAMeme;
	}

	private boolean mashChecker(String input)
	{
		boolean isMashing = false;

		if (input.indexOf("sdf") > -1)
		{
			isMashing = true;
		}
		return isMashing;
	}

	private String mashingDectected(String input)
	{
		String mashed = "";

		mashed = input.substring(input.length() / 2);
		mashed = input.substring(input.length() / 2);
		mashed = input.substring(input.length() / 2);
		mashed = input.substring(input.length() / 2);

		return mashed;
	}

	private String noMashingDectected(String input)
	{
		String notMashed = "Thank you for not mashing your keyboard with ";

		if (input.length() > 1)
		{
			notMashed += input.substring(input.length() / 3, input.length() / 2);
		}

		return notMashed;
	}

	/**
	 * This checks for if the users inputs "quit" and exits the application if
	 * "quit" is entered.
	 * 
	 * @param input
	 *            The user text input into the text box.
	 * @return
	 */

	public boolean quitChecker(String input)
	{
		boolean okToQuit = false;

		if (input.equals("quit"))
		{
			okToQuit = true;
		}
		return okToQuit;

	}

}
