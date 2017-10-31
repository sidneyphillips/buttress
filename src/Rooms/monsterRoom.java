package Rooms;
//Made by Sid P, 10/30/17
public class monsterRoom implements room{
	private boolean discovered = false;
	private int difficulty;
	private String monsterType;
	private int a;
	private int b;
	String[] names = new String[] {"Rat","Snake","Lizard","Spider","Bat"};
	public monsterRoom(int difficulty, int monsterInt, int a, int b) {
		this.difficulty = difficulty;
		this.monsterType = names[monsterInt];
		this.a = a;
		this.b = b;
	}
	public String roomID() {
		return "m";
	}
	public String monsterString() {
		return this.monsterType;
	}
	public boolean isFound() {
		return this.discovered;
	}
	public int sellingGoods() {
		return 0;
	}
	public int monsterDifficulty() {
		return this.difficulty;
	}
	public int[] indexOf() {
		// TODO Auto-generated method stub
		return null;
	}
	public void setFound() {
		this.discovered = true;
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
