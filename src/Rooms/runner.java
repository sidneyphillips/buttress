package Rooms;
//Made by Sid P, 10/30/17
import java.util.Scanner;
import Rooms.room;
import Rooms.utilities;

public class runner {
	public static void main(String[] args) {
		boolean won = false;
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
				player Player1 = new player(c, d, 0, 0);
			}
			else
			{
				player.nextSpawn(a,b);
			}
		}
		System.out.println("THE IMPENETRABLE BUTTRESS™");
		for(int x = 0; x < 5; x++)
		{
			for (int y = 0; y < 5; y++)
			{
				if(x==0&&y==0)
				{
					System.out.print("     ");
				}
				if(y < 4) {
					
					if(roomArr[0][x][y].isFound()&&roomArr[0][x][y].roomID()=="e"&&roomArr[0][x][y].sellingGoods())
					{
					System.out.print("["+roomArr[inc][x][y].roomID()+"]");
					}
					else if(roomArr[0][x][y].isFound()) {
						System.out.print("[ ]");
					}
					else {
						System.out.print("[X]");
					}
				}
				else {
					if(roomArr[0][x][y].isFound())
					{
					System.out.print("[ ]\n     ");
					}
					else {
						System.out.print("[X]\n     ");
					}
				}
			}
		}
		boolean chosen = false;
		
		Scanner sc = new Scanner(System.in);
		while(!won)
		{
			System.out.println("\nType to move in a direction.");
			chosen = false;
			while(!chosen)
			{
				
				String direction = sc.nextLine();
				if((direction.toLowerCase().equals("up") || direction.toLowerCase().equals("north"))&&player.canUp())
				{
					player.move("up");
					chosen = true;
					roomArr[inc][player.playerA()][player.playerB()].setFound();
				}
				else if((direction.toLowerCase().equals("down") || direction.toLowerCase().equals("south"))&&player.canDown())
				{
					player.move("down");
					chosen = true;
					roomArr[inc][player.playerA()][player.playerB()].setFound();
				}
				else if((direction.toLowerCase().equals("left") || direction.toLowerCase().equals("west"))&&player.canLeft()) 
				{
					player.move("left");
					chosen = true;
					roomArr[inc][player.playerA()][player.playerB()].setFound();
				}
				else if((direction.toLowerCase().equals("right") || direction.toLowerCase().equals("east"))&&player.canRight()) 
				{
					player.move("right");
					chosen = true;
					roomArr[inc][player.playerA()][player.playerB()].setFound();
				}
				
				else {
					System.out.print("\nPlease move in another direction.\n");
				}
				
			}
			System.out.println("---------------------------\nTHE IMPENETRABLE BUTTRESS™");
			for(int x = 0; x < 5; x++)
			{
				for (int y = 0; y < 5; y++)
				{
					if(x==0&&y==0)
					{
						System.out.print("     ");
					}
					if(x == player.playerA()&&y == player.playerB()) {
						if(y < 4) {
								System.out.print("[i]");
							}
						else {
								System.out.print("[i]\n     ");
							}
						
					}
					
					else if(y < 4) {
						
						if(roomArr[inc][x][y].isFound()&&roomArr[inc][x][y].roomID()=="e"&&roomArr[inc][x][y].sellingGoods())
						{
						System.out.print("["+roomArr[inc][x][y].roomID()+"]");
						}
						else if(roomArr[inc][x][y].isFound()) {
							System.out.print("[ ]");
						}
						else {
							System.out.print("[X]");
						}
					}
					else {
						if(roomArr[inc][x][y].isFound())
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
		sc.close();
	}
}
