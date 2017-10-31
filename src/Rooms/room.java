package Rooms;
//Made by Sid P, 10/30/17
public interface room {
	public abstract boolean isFound();
	public abstract int sellingGoods();
	public abstract String roomID();
	public abstract int [] indexOf();
	public abstract void setFound();
	public abstract String monsterString();
	public abstract int monsterDifficulty();
	public abstract int getPrice();
	public abstract void sold();
	public abstract boolean hasGoods();
}
