package Rooms;
//Made by Sid P, 10/30/17
public class monsterRoom implements room{
	private boolean discovered = false;
	private int difficulty;
	private int monsterType;
	private int a;
	private int b;
	public monsterRoom(int difficulty, int monsterType, int a, int b) {
		this.difficulty = difficulty;
		this.monsterType = monsterType;
		this.a = a;
		this.b = b;
	}
	public String roomID() {
		return "m";
	}
	public boolean isFound() {
		return this.discovered;
	}
	public boolean sellingGoods() {
		return false;
	}
	@Override
	public int[] indexOf() {
		// TODO Auto-generated method stub
		return null;
	}
}
