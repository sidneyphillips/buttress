package Rooms;
//Made by Sid P, 10/30/17
public class utilities {
	public int a;
	public int b;
	public static room randomRoom(int a, int b)
	{
		int temp = (int) (Math.floor(Math.random()*3));
		if(temp == 0)
		{
			int temp2 = (int) Math.floor(Math.random()*2);
			return new merchantRoom((int) Math.floor(Math.random()*5)+1, temp2, a, b);
		}
		if(temp == 1)
		{
			int temp2 = (int) Math.floor(Math.random()*5);
			return new monsterRoom((int) Math.floor(Math.random()*3+1), temp2, a, b);
		}
		return new trapRoom(a, b);
	}
	public static room exitRoom(int a, int b) {
		return new exitRoom(a, b);
	}
	public static room startRoom(int a, int b) {
		return new startRoom(a, b);
	}
}
