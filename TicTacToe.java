import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
/*  Gameboard placement 
 * 1|2|3
 * -+-+- 
 * 4|5|6
 * -+-+-
 * 7|8|9
 * 
 */

public class TicTacToe {
	
	static ArrayList<Integer> playerPositions = new ArrayList<Integer>();
	static ArrayList<Integer> cpuPositions = new ArrayList<Integer>();


	public static void main(String[] args) {
		
		char[][] gameBoard = {{' ', '|', ' ', '|', ' '},
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '},
							  {'-', '+', '-', '+', '-'},
							  {' ', '|', ' ', '|', ' '}};
		
		
		
		//using while loop to keep playing until there's a winner 
		while(true) {
			//user enter a number represents position on the gameboard 
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter your placement (1-9): ");
			int playerPos = scan.nextInt();
			
			/*showing message to re-enter position if:
			 * player enter the played position 
			 * OR cpu enter played position by player 
			 */
			while(playerPositions.contains(playerPos) || cpuPositions.contains(playerPos)) {
				System.out.println("Position taken! Enter a correct Position");
				playerPos = scan.nextInt();
				
			}
			
			//player turn to play 
			placePiece(gameBoard,playerPos,"player");
			
			//check result after each player turn
			String result = checkWinner();
			if(result.length() > 0 ) {
				System.out.println(result);
				break;
			}
			
			//for computer turn to play we can use random method 
			Random rand = new Random();
			int cpuPos = rand.nextInt(9) + 1;
			
			/*cpu generates a random position again if:
			 * cpu enter the played position 
			 * OR player enter played position by cpu 
			 */
			while(playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
				cpuPos = rand.nextInt(9) +1;
			}
			
			//cpu turn to play 
			placePiece(gameBoard,cpuPos,"cpu");
			
			
			//call method to print out game board 
			printGameBoard(gameBoard);
					
			//check result after each cpu turn
			result = checkWinner();
			if(result.length() > 0 ) {
				System.out.println(result);
				break;
			}
		}
		
	}
	//Methods print game board 
	public static void printGameBoard(char[][] gameBoard) {
		//printing out empty tic tac toe game board
				//for each array(row) inside of the game board 
				for(char[] row: gameBoard) {
					//for each char of gameBoard 
					for(char c: row ) {
						System.out.print(c);
					}
					System.out.println();
				}
	}
	
	//Method taking game board, initial playing position, and user 
	// @param gameBoard, pos, user
	//if user --> play X, if cpu --> play O
	public static void placePiece(char[][] gameBoard, int pos, String user) {
		
		char symbol = ' ';
		if(user.equals("player")) {
			symbol = 'X';
			playerPositions.add(pos);
		}else if (user.equals("cpu")) {
			symbol = 'O';
			cpuPositions.add(pos);
		}
		
		switch(pos) {
		case 1: gameBoard[0][0] = symbol; break;
		case 2: gameBoard[0][2] = symbol; break;
		case 3: gameBoard[0][4] = symbol; break;
		case 4: gameBoard[2][0] = symbol; break;
		case 5: gameBoard[2][2] = symbol; break;
		case 6: gameBoard[2][4] = symbol; break;
		case 7: gameBoard[4][0] = symbol; break;
		case 8:	gameBoard[4][2] = symbol; break;
		case 9: gameBoard[4][4] = symbol; break;
		default: break;
		}
		
	}
	
	//Method return the winner 
	public static String checkWinner() {
		/* List of winning scenerios */
		//3 ways to win in horizontal
		List topRow = Arrays.asList(1,2,3); //top row
		List midRow = Arrays.asList(4,5,6); //middle row
		List botRow = Arrays.asList(7,8,9); //bottom row 
		//3 ways to win in vertical 
		List lefCol = Arrays.asList(1,4,7); //left column
		List midCol = Arrays.asList(2,5,8); //middle column
		List RightCol = Arrays.asList(3,6,9); //right column 
		//2 ways to win in diagnol
		List cross1 = Arrays.asList(1,5,9);
		List cross2 = Arrays.asList(3,5,7);
		
		//add those winning conditions to a list and loop through those to check if a condition is met. 
		List<List> winning = new ArrayList<List>();
		winning.add(topRow);
		winning.add(midRow);
		winning.add(botRow);
		winning.add(lefCol);
		winning.add(lefCol);
		winning.add(midCol);
		winning.add(RightCol);
		winning.add(cross1);
		winning.add(cross2);
		
		/* 3 scenerios
		 * 1. if the player moves contain all element of a list --> player wins
		 * 2. else if cpu moves contain all element of a list --> player loses 
		 * 3. player moves + cpu Position move == 9 and the conditions above are not met --> out of move, end the game 
		 */
		
		
		//for each list in winning, loop through
		for(List li : winning) {
			if(playerPositions.containsAll(li)) {
				return "Congratualations you won!";
			}else if (cpuPositions.containsAll(li)) {
				return "Sorry, you are defeated :(";
			}
		}
		
		if(playerPositions.size() + cpuPositions.size() == 9) {
			return "Game over. Draw!";
		}
		return "";
	}

}
