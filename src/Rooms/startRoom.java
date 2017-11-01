package Rooms;
//Made by Sid P, 10/30/17
public class startRoom implements room 
{
	private boolean discovered = true;
	private int a;
	private int b;
	
	public startRoom(int a, int b) 
	{
		this.a = a;
		this.b = b;
	}
	public String roomID() 
	{
		return "s";
	}
	public boolean isFound() 
	{
		return this.discovered;
	}
	public int sellingGoods() 
	{
		return 0;
	}
	public int[] indexOf() 
	{
		int result[] = new int[] {a, b};
		return result;
	}
	public void setFound() {
		this.discovered = true;
	}
	public String monsterString()
	{
		return "";
	}
	public int monsterDifficulty() 
	{
		return 0;
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
