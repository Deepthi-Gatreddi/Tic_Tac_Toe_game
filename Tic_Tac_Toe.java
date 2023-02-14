package com.tic_tac_toe_game;
// Tic-Tac-Toe Game project
import java.util.*;

public class Tic_Tac_Toe {

	static String[] board;  // to store the values of each box in the game
	static String turn;     // to say whose turn is to play now
	
	static String checkWinner() {
		// to check all the cases like row,column and diagonal in each iteration it checks each case
		for (int a = 0; a < 8; a++) {
			String line = null;
            
			// to check winning condition like to check if any row or column or diagonal having same symbol
			switch (a) {
			case 0:
				line = board[0] + board[1] + board[2];
				break;
			case 1:
				line = board[3] + board[4] + board[5];
				break;
			case 2:
				line = board[6] + board[7] + board[8];
				break;
			case 3:
				line = board[0] + board[3] + board[6];
				break;
			case 4:
				line = board[1] + board[4] + board[7];
				break;
			case 5:
				line = board[2] + board[5] + board[8];
				break;
			case 6:
				line = board[0] + board[4] + board[8];
				break;
			case 7:
				line = board[2] + board[4] + board[6];
				break;
			}
			// if line==XXX then to declare X is the winner
			if (line.equals("XXX")) {
				return "X";
			}

			// if line==OOO then to declare O is the winner
			else if (line.equals("OOO")) {
				return "O";
			}
		}
        // if none of the cases works means there is no winner and there is only two possible cases to happen
        // 1.there are still some empty places to fill else
		// 2.there are no empty places and it is a draw 
		for (int a = 0; a < 9; a++) {
			// if there is at least one empty unfilled slot then it will break the loop and the null will be returned
			if (Arrays.asList(board).contains(String.valueOf(a + 1))) { 
				break;
			} else if (a == 8) {
				return "draw";
			}
		}

		// To enter the X Or O at the exact place on board.
		System.out.print(turn + "'s turn; enter a slot number to place " + turn + " in:");
		return null;
	}

	// to print the board

	static void printBoard() {
		System.out.println("|---|---|---|");
		System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[3] + " | " + board[4] + " | " + board[5] + " |");
		System.out.println("|-----------|");
		System.out.println("| " + board[6] + " | " + board[7] + " | " + board[8] + " |");
		System.out.println("|---|---|---|");
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		board = new String[9];
		turn = "X"; // to represent whose turn is now
		String winner = null; // to find winner and to check whether game is completed or not

		for (int a = 0; a < 9; a++) {
			board[a] = String.valueOf(a + 1); // to convert int to string and to store it in board array
		}

		System.out.println("Welcome to 3x3 Tic Tac Toe.");
		printBoard(); // to print the board such that users can know what are the values filled

		System.out.print("X will play first. Enter a slot number to place X in:");

		while (winner == null) {
			int numInput;
			// Exception handling.
			// numInput will take input from user like from 1 to 9.
			// If it is not in range from 1 to 9.
			// then it will show you an error "Invalid input."
			try {
 				numInput = in.nextInt();// to take input from user and to know in which box he want to insert X
				if (!(numInput > 0 && numInput <= 9)) {
					System.out.print("Invalid input; re-enter slot number:");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.print("Invalid input; re-enter slot number:");
				continue;
			}

			// This game has two player x and O.
			// Here is the logic to decide the turn.
			if (board[numInput - 1].equals(String.valueOf(numInput))) { //to check whether the value is already filled with some other value or not.
				board[numInput - 1] = turn;   

				if (turn.equals("X")) {
					turn = "O";
				} else {
					turn = "X";
				}

				printBoard();
				winner = checkWinner();
			} else {
				System.out.print("Slot already taken; re-enter slot number:");
			}
		}

		// If no one win or lose from both player x and O.
		// then here is the logic to print "draw".
		if (winner.equalsIgnoreCase("draw")) {
			System.out.println("It's a draw! Thanks for playing.");
		}

		// For winner -to display Congratulations! message.
		else {
			System.out.println("Congratulations! " + winner + "'s have won! Thanks for playing.");
		}
		in.close();
	}
}
