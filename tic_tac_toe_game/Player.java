package tic_tac_toe_game;

public class Player {

	private String name; //it is private because to check wheter the name is empty or not
	private char symbol; 
	
	public Player(String name, char symbol){  //constructor that sets name and symbol
		setName(name);
		setSymbol(symbol);
	}
	
	public void setName(String name) {
		
		if(!name.isEmpty()) {
			this.name = name;
		}
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setSymbol(char symbol) {
		if(symbol != '\0') {
			this.symbol = symbol;
		}
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	
}