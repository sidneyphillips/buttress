package Rooms;
//Made by Sid P, 10/30/17
public class trapRoom implements room {
	private boolean discovered = false;	
	private int a;
	private int b;
	public trapRoom(int a, int b)
	{
		this.a = a;
		this.b = b;
	}
	public String roomID() {
		return "t";
	}
	public boolean isFound() {
		return this.discovered;
	}
	public boolean sellingGoods() {
		return false;
	}
	@Override
	public int[] indexOf() {
		int result[] = new int[] {a, b};
		return result;
	}
}
