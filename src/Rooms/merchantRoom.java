package Rooms;
//Made by Sid P, 10/30/17
public class merchantRoom implements room {
	//fields
	private int a;
	private int b;
	private boolean discovered = false;
	private int price;
	private int goods;
	private boolean found;
	private boolean selling = true;
	public merchantRoom(int price, int goods, int a, int b) {
		this.price = price;
		this.goods = goods;
		this.a = a;
		this.b = b;
	}
	public boolean hasGoods() {
		return this.selling;
	}
	public void sold()
	{
		selling = false;
	}
	public String roomID() {
		return "e";
	}

	public int sellingGoods() {
		return goods;
	}
	public int getPrice()
	{
		return price;
	}
	public boolean isFound() {
		return this.discovered;
	}
	public int[] indexOf() {
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
	public int monsterDifficulty() {
		return 0;
	}
}
