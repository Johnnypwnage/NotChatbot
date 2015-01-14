package chatbot.model;

public class ChatbotUser
{
	private String UserQuestion;
	private String UserName;
	private int age;

	
	public ChatbotUser()
	{
	this.age = -69;
	this.UserName = "";
	this.UserQuestion = "";
	}
	
	public void setUserQuestion(String Input)
	{
		this.UserQuestion = Input;
	}
	
	public String getQuestion()
	{
		return UserQuestion;
	}
	
	public void setUserName(String Input)
	{
		this.UserName = Input;
		
	}
	
	public String getName()
	{
		return UserName;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void setAge(int Input)
	{
		this.age = Input;
	}
	
}