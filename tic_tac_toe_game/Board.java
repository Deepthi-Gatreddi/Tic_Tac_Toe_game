package tic_tac_toe_game;

public class Board {
	private char board[][];
	private int boardSize = 3;
	private char p1Symbol, p2Symbol;
	private int count;
	public final static int PLAYER_1_WINS = 1;     //as returning string and checking will be difficult we used final static
	public final static int PLAYER_2_WINS = 2;
	public final static int DRAW = 3;
	public final static int INCOMPLETE = 4;
	public final static int INVALID = 5;



	public Board(char p1Symbol, char p2Symbol){   //constructor which initializes board with spaces
		board = new char[boardSize][boardSize];
		for(int i =0; i < boardSize; i++){
			for(int j =0; j < boardSize; j++){
				board[i][j] = ' ';
			}
		}
		this.p1Symbol = p1Symbol;       //initializes user entered symbols to the symbols
		this.p2Symbol = p2Symbol;
	}
	public int move(char symbol, int x, int y) { //when user want to move based on x and y coordinates

		if(x < 0 || x >= boardSize || y < 0 || y >= boardSize || board[x][y] != ' '){
			return INVALID;
		}  //checks if that position is already filled or not or entered coordinates within range or not so that it can ask user reenter the value again

		board[x][y] = symbol;   //if it is valid we assign the value
		count++;               //it helps in draw condition to know whether all places are filled or not
		
		//if user enters at particular position we have to check particular row or particular column and both diagonals
		// Check Row
		if(board[x][0] == board[x][1] && board[x][0] == board[x][2]){
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		// Check Col
		if(board[0][y] == board[1][y] && board[0][y] == board[2][y]){
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		// for diagonal we added additional condition because initially if element is not in any diagonal then all spaces will be 
		// equal which leads to appropriate decision
		// First Diagonal
		if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[0][0] == board[2][2]){
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		// Second Diagonal
		if(board[0][2] != ' ' && board[0][2] == board[1][1] && board[0][2] == board[2][0]){
			return symbol == p1Symbol ? PLAYER_1_WINS : PLAYER_2_WINS;
		}
		if(count == boardSize * boardSize){
			return DRAW;
		}
		return  INCOMPLETE;  //means no one won and there are still empty spaces to fill

	}
	//print the board 
	public void print() {  
		System.out.println("---------------");
		for(int i =0; i < boardSize; i++){
			for(int j =0; j < boardSize; j++){
				System.out.print("| " + board[i][j] + " |");
			}
			System.out.println();
		}
		System.out.println();
		System.out.println("---------------");
	}





}