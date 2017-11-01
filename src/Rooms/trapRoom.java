package Rooms;
//Made by Sid P, 10/30/17
public class trapRoom implements room 
{
	private boolean discovered = false;	
	private int a;
	private int b;
	public trapRoom(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public String roomID() 
	{
		return "t";
	}
	public boolean isFound() 
	{
		return this.discovered;
	}
	public int sellingGoods() 
	{
		return 0;
	}
	public void setFound() {
		this.discovered = true;
	}
	public int monsterDifficulty() 
	{
		return 0;
	}
	public String monsterString() 
	{
		return "";
	}
	public int getPrice()
	{
		return 0;
	}
	public boolean hasGoods() 
	{
		return false;
	}
	public void sold() 
	{
		
	}
	public void setHidden() 
	{
		this.discovered = false;
	}
}
