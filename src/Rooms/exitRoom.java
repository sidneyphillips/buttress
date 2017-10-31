package Rooms;
//Made by Sid P, 10/30/17
public class exitRoom implements room {
	private boolean discovered = false;
	private int a;
	private int b;
	public exitRoom(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public String roomID() {
		// TODO Auto-generated method stub
		return "x";
	}
	public boolean isFound() {
		return this.discovered;
	}
	public int sellingGoods() {
		return 0;
	}
	public int[] indexOf() {
		int result[] = new int[] {a, b};
		return result;
	}
	@Override
	public void setFound() {
		this.discovered = true;		
	}
	public String monsterString()
	{
		return "";
	}
	public int monsterDifficulty() {
		return 0;
	}
	public int getPrice()
	{
		return 0;
	}
	@Override
	public boolean hasGoods() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void sold() {
		// TODO Auto-generated method stub
		
	}
}
