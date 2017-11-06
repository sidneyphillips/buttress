package Character;

public abstract class character {
	private static int hp;
	private static int maxHp;
	private static int a;
	private static int b;
	private static int armour = 0;
	private static int[] spawnList = new int[4];
	private static int gold = 0;
	public character(int a, int b, int gold, int hp) 
	{
		this.a = a;
		this.b = b;
		this.hp = hp;
		this.maxHp = hp;
	}
	public static int changeHealth(int change) 
	{
		if(change < 0)
		{
			hp = hp + change;
			if(armour > -1 * change )
			{
				hp = hp - change;
			}
			else
			{
				hp = hp + armour;
			}
		}
		else if(change > 0)
		{
			hp+= change;
		}
		if(hp > maxHp)
		{
			hp = maxHp;
		}
		return hp;
	}
	public static int changeGold(int change)
	{
		gold += change;
		return gold;
	}
	public static void addArmour() 
	{
		armour++;
	}
	public static int playerA() 
	{
		return a;
	}
	public static int playerB() 
	{
		return b;
	}
	public static boolean canUp()
	{
		return(a != 0);
	}
	public static boolean canDown() 
	{
		return(a != 4);
	}
	public static boolean canLeft() 
	{
		return(b != 0);
	}
	public static boolean canRight() 
	{
		return(b != 4);
	}
	public static void nextSpawn(int a, int b) 
	{
		spawnList[0] = a;
		spawnList[1] = b;
	}
	public static void move(String string) 
	{
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
