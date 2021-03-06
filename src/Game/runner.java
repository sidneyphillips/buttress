package Game;
//Made by Sid P, 10/30/17
//Completed 11/1/17
import java.util.Scanner;

import Character.player;
import Rooms.room;

public class runner {
	public static void main(String[] args) {
		boolean won = false;
		boolean lost = false;
		int inc = 0;
		room[][][] roomArr;
		System.out.println();
		roomArr = new room[3][5][5];
		//builds all floors
		for(int i = 0; i < 3; i++) 
		{
			for (int j = 0; j < 5; j++)
			{
				for(int k = 0; k < 5; k++)
				{
					roomArr[i][j][k] = utilities.randomRoom(j,k);
				}
			}
			int a = (int)Math.floor(Math.random()*5);
			int b = (int)Math.floor(Math.random()*5);
			int c = (int)Math.floor(Math.random()*5);
			int d = (int)Math.floor(Math.random()*5);

			while (c == a)
			{
				c = (int)Math.floor(Math.random()*5);
				
			}
			while (d == b)
			{
				d = (int)Math.floor(Math.random()*5);
			}
			roomArr[i][a][b] = utilities.exitRoom(a, b);
			roomArr[i][c][d] = utilities.startRoom(c, d);
			if (i == 0) {
				new player(c, d, 0, 15);
			}
			else
			{
				player.nextSpawn(a,b);
			}
		}
		drawArr(roomArr, inc);
		boolean chosen;
		
		Scanner sc = new Scanner(System.in);
		while(!won&&!lost)
		{
			
			chosen = false;
			while(!chosen&&!won)
			{
				System.out.println("\nType to move in a direction.");
				String action = sc.nextLine();
				if((action.toLowerCase().equals("buy") || action.toLowerCase().equals("yes"))&&(roomArr[inc][player.playerA()][player.playerB()].roomID().equals("e")))
				{
					if(roomArr[inc][player.playerA()][player.playerB()].hasGoods())
					{
						if(player.changeGold(0) >= roomArr[inc][player.playerA()][player.playerB()].getPrice())
						{
							player.changeGold(-1*roomArr[inc][player.playerA()][player.playerB()].getPrice());
							if(roomArr[inc][player.playerA()][player.playerB()].sellingGoods()==0)
							{
								player.addArmour();
								System.out.print("\nYou purchased the armour piece. Damage taken from monsters will be reduced. You have "+player.changeGold(0)+" gold left.\n");		
							}
							else if(roomArr[inc][player.playerA()][player.playerB()].sellingGoods()==1)
							{
								player.changeHealth(10);
								if(player.changeHealth(0)==15)
								{
									System.out.print("\nYou bought the potion and it restored you to maximum health. You have "+player.changeHealth(0)+" health and "+player.changeGold(0)+" gold.\n");
								}
								else
								{
									System.out.print("\nYou bought the potion and restored 10 health. You have "+player.changeHealth(0)+" health and "+player.changeGold(0)+" gold.\n");
								}
							}
							roomArr[inc][player.playerA()][player.playerB()].sold();
						}
						else
						{
							System.out.print("\nYou can't afford it.\n");
						}
						
					}
					else
					{
						System.out.print("\nThe room is clear.");
					}
				}
				else if((action.toLowerCase().equals("leave")||action.toLowerCase().equals("yes"))&&roomArr[inc][player.playerA()][player.playerB()].roomID().equals("x"))
				{
					inc++;
					String temp = "";
					if(inc > 2)
					{
						System.out.print("\nCongratulations, you have successfully penetrated the buttress.\n");
						won = true;
						chosen = true;
					}
					else
					{
						if(inc == 1)
						{
							temp = "second";
						}
						if(inc == 2)
						{
							temp = "third";
						}
						
						roomArr[inc][player.playerA()][player.playerB()].setFound();
						for(int x = 0; x < 5; x++)
						{
							for (int y = 0; y < 5; y++)
							{
								roomArr[inc][x][y].setHidden();
							}
						}
						System.out.print("\nYou went up to the "+temp+" floor.\n");
						drawArr(roomArr, inc);
					}
				}
				else if((action.toLowerCase().equals("up") || action.toLowerCase().equals("north"))&&player.canUp())
				{
					player.move("up");
					chosen = true;
					
				}
				else if((action.toLowerCase().equals("down") || action.toLowerCase().equals("south"))&&player.canDown())
				{
					player.move("down");
					chosen = true;

				}
				else if((action.toLowerCase().equals("left") || action.toLowerCase().equals("west"))&&player.canLeft()) 
				{
					player.move("left");
					chosen = true;

				}
				else if((action.toLowerCase().equals("right") || action.toLowerCase().equals("east"))&&player.canRight()) 
				{
					player.move("right");
					chosen = true;
	
				}
				
				else {
					System.out.print("\nPlease move in another direction.\n");
				}
				
			}
			drawArr(roomArr, inc);
			if(roomArr[inc][player.playerA()][player.playerB()].roomID().equals("m")&&!roomArr[inc][player.playerA()][player.playerB()].isFound()) {
				System.out.print("\nYou encountered a "+ roomArr[inc][player.playerA()][player.playerB()].monsterString()+". ");
				int temp2 = player.changeHealth(0);
				player.changeHealth(-1*roomArr[inc][player.playerA()][player.playerB()].monsterDifficulty());
				int temp3 = player.changeHealth(0);
				
				if(player.changeHealth(0) <= 0)
				{
					System.out.print("The "+roomArr[inc][player.playerA()][player.playerB()].monsterString()+" has slain you.\nGAME OVER");
					lost = true;
				}
				else
				{
					int temp = (int) (Math.floor(Math.random()*3)-1);
					int rewardMoney = roomArr[inc][player.playerA()][player.playerB()].monsterDifficulty()+temp;
					if(rewardMoney < 1)
					{
						rewardMoney = 1;
					}
					player.changeGold(rewardMoney);
					if(temp2-temp3 == roomArr[inc][player.playerA()][player.playerB()].monsterDifficulty())
					{
						System.out.print("You defeated the "+roomArr[inc][player.playerA()][player.playerB()].monsterString()+", but it dealt you "+roomArr[inc][player.playerA()][player.playerB()].monsterDifficulty()+" damage. You have "+player.changeHealth(0)+" health remaining.\nThe "+roomArr[inc][player.playerA()][player.playerB()].monsterString()+" dropped " + rewardMoney+" gold. You have "+player.changeGold(0)+ " gold.");
					}
					else {
						System.out.print("You defeated the "+roomArr[inc][player.playerA()][player.playerB()].monsterString()+", but it dealt you a reduced "+(temp2-temp3)+" damage. You have "+player.changeHealth(0)+" health remaining.\nThe "+roomArr[inc][player.playerA()][player.playerB()].monsterString()+" dropped " + rewardMoney+" gold. You have "+player.changeGold(0)+ " gold.");

					}
				}
				
			}
			else if(roomArr[inc][player.playerA()][player.playerB()].roomID().equals("t")) {
				System.out.print("\nYou encounter a room full of traps. ");
				int temp = (int) Math.floor(Math.random()*3);
				if(temp == 0)
				{
					int temp2 = (int) Math.floor(Math.random()*4);

					String[] traps = new String[] {"shot by a flaming arrow","hurt by spikes on the floor","sliced by a swinging axe","crushed by a massive boulder"};
					String trap = traps[temp2];
					player.changeHealth(-1*(temp2+1));
					if(player.changeHealth(0) > 0)
					{
					System.out.print("\nYou were "+trap+". You took "+ (temp2+1) +" damage. You have "+player.changeHealth(0)+" health remaining.");
					}
					else
					{
						System.out.print("You died after being "+trap+".\nGAME OVER");
						lost = true;
					}
				}
				else {
					System.out.println("\nYou nimbly dodge all of the traps without recieving a scratch.");
				}
				
			}
			else if(roomArr[inc][player.playerA()][player.playerB()].roomID().equals("e")&&roomArr[inc][player.playerA()][player.playerB()].hasGoods()) {
				String temp = "";
				if(roomArr[inc][player.playerA()][player.playerB()].sellingGoods() == 0)
				{
					temp = "piece of armour";
				}
				else
				{
					temp = "healing potion";
				}
				roomArr[inc][player.playerA()][player.playerB()].setFound();
				System.out.print("\nYou encounter a wandering merchant. He is selling a "+temp+" for "+roomArr[inc][player.playerA()][player.playerB()].getPrice()+" gold.\nTo buy, type 'buy'. To leave, choose any direction.");
			}
			else if(roomArr[inc][player.playerA()][player.playerB()].roomID().equals("x")) {
				System.out.print("\nYou found the exit of this floor. Do you want to leave? ");
			}
			else
			{
				System.out.print("\nThe room is clear.");
			}
			roomArr[inc][player.playerA()][player.playerB()].setFound();
		}
		sc.close();
	}
	public static void drawArr(room[][][] roomArr, int inc)
	{
		System.out.println("---------------------------\nTHE IMPENETRABLE BUTTRESS�");
		for(int x = 0; x < 5; x++)
		{
			for (int y = 0; y < 5; y++)
			{
				if(x==0&&y==0)
				{
					System.out.print("     ");
				}
				if(x == player.playerA()&&y == player.playerB()) {
					System.out.print("[i]");
					if(!(y < 4)) {
						System.out.print("\n     ");
						}					
				}
				
				else if(y < 4) {
					
					if(roomArr[inc][x][y].isFound()&&roomArr[inc][x][y].roomID().equals("e")&&roomArr[inc][x][y].hasGoods())
					{
					System.out.print("[$]");
					}
					else if(roomArr[inc][x][y].isFound()&&roomArr[inc][x][y].roomID().equals("x"))
					{
						System.out.print("[e]");
					}
					else if(roomArr[inc][x][y].isFound()) {
						System.out.print("[ ]");
					}
					else {
						System.out.print("[X]");
					}
				}
				else {
					if(roomArr[inc][x][y].isFound()&&roomArr[inc][x][y].roomID().equals("e")&&roomArr[inc][x][y].hasGoods())
					{
					System.out.print("[$]\n     ");
					}
					else if(roomArr[inc][x][y].isFound()&&roomArr[inc][x][y].roomID().equals("x"))
					{
						System.out.print("[e]\n     ");
					}
					else if(roomArr[inc][x][y].isFound())
					{
					System.out.print("[ ]\n     ");
					}
					else {
						System.out.print("[X]\n     ");
					}
				}
			}
		}
	}
}
