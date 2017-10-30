package Rooms;
//Made by Sid P, 10/30/17
public class player {
	private static int a;
	private static int b;
	private static int[] spawnList = new int[4];
	public player(int a, int b, int gold, int heal) {
		this.a = a;
		this.b = b;
	}
	public static int playerA() {
		return a;
	}
	public static int playerB() {
		return b;
	}
	public static boolean canUp()
	{
		return(a != 0);
	}
	public static boolean canDown() {
		return(a != 4);
	}
	public static boolean canLeft() {
		return(b != 0);
	}
	public static boolean canRight() {
		return(b != 4);
	}
	public static void nextSpawn(int a, int b) {
		spawnList[0] = a;
		spawnList[1] = b;
	}
	public static void move(String string) {
		if(string == "up")
		{
			a -= 1;
		}
		if(string == "down")
		{
			a += 1;
		}
		if(string == "left")
		{
			b -= 1;
		}
		if(string == "right")
		{
			b += 1;
		}
	}
}
