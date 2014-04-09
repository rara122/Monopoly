import java.util.*;
import java.awt.Color;

public class GameBoard {

	private List < BoardPiece > boardPieces;
	
	private final static Color PURPLE = new Color (102, 0 , 102);

	GameBoard(){
		boardPieces = new ArrayList <BoardPiece> (40);
		
		boardPieces.add(new Event("Go"));
		boardPieces.add(new Housing("Mediterranean Avenue", 60.00, PURPLE));		
		boardPieces.add(new Event("Community Chest"));
		boardPieces.add(new Housing("Baltic Avenue", 60.00, PURPLE));
		boardPieces.add(new Event("Income Tax"));
		boardPieces.add(new RailRoad("Reading Railroad", 200.00));
		boardPieces.add(new Housing("Oriental Avenue", 100.00, Color.CYAN));
		boardPieces.add(new Event("Chance"));
		boardPieces.add(new Housing("Vermont Avenue", 100.00, Color.CYAN));
		boardPieces.add(new Housing("Connecticut Avenue", 120.00, Color.CYAN));
		
		boardPieces.add(new Event("In Jail/Just Visiting"));
		boardPieces.add(new Housing("St.Charles Place", 140.00, Color.PINK));
		boardPieces.add(new Utilities("Electric Company", 150.00));
		boardPieces.add(new Housing("States Avenue", 140.00, Color.PINK));
		boardPieces.add(new Housing("Virginia Avenue", 160.00, Color.PINK));
		boardPieces.add(new RailRoad("Pennsylvania Railroad", 200.00));
		boardPieces.add(new Housing("St.James Place", 180.00, Color.ORANGE));
		boardPieces.add(new Event("Community Chest"));		
		boardPieces.add(new Housing("Tennessee Avenue", 180.00, Color.ORANGE));
		boardPieces.add(new Housing("New York Avenue", 200.00, Color.ORANGE));

		boardPieces.add(new Event("Free Parking"));
		boardPieces.add(new Housing("Kentucky Avenue", 220.00, Color.RED));
		boardPieces.add(new Event("Chance"));
		boardPieces.add(new Housing("Indiana Avenue", 220.00, Color.RED));
		boardPieces.add(new Housing("Illinois Avenue", 240.00, Color.RED));
		boardPieces.add(new RailRoad("B&O Railroad", 200.00));
		boardPieces.add(new Housing("Atlantic Avenue", 260.00, Color.YELLOW));
		boardPieces.add(new Housing("Ventnor Avenue", 260.00, Color.YELLOW));
		boardPieces.add(new Utilities("Water Works", 150.00));
		boardPieces.add(new Housing("Marvin Gardens", 280.00, Color.YELLOW));
		
		boardPieces.add(new Event("Go To Jail"));
		boardPieces.add(new Housing("Pacific Avenue", 300.00, Color.GREEN));
		boardPieces.add(new Housing("North Carolina Avenue", 300.00, Color.GREEN));
		boardPieces.add(new Event("Community Chest"));		
		boardPieces.add(new Housing("Pennsylvania Avenue", 320.00, Color.GREEN));
		boardPieces.add(new RailRoad("Short Line", 200.00));
		boardPieces.add(new Event("Chance"));
		boardPieces.add(new Housing("Park Place", 350.00, Color.BLUE));
		boardPieces.add(new Event("Luxury Tax"));		
		boardPieces.add(new Housing("Boardwalk", 400.00, Color.BLUE));

		for (int i = 0; i < boardPieces.size(); i++){
			System.out.println(boardPieces.get(i));
			if ( (i+1) % 10 == 0 ){
				System.out.println();
			}
		}
		
	}

	
	public static void main (String args []){
		GameBoard gb = new GameBoard();
		
		// for (BoardPiece b : gb.boardPieces){
			// System.out.println(gb.boardPieces.getName());
		// }
	}
}

abstract class BoardPiece {
	private String name;
	
	BoardPiece(String n){
		name = n;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
	public String toString(){
		return name;
	}
}

abstract class Property extends BoardPiece{
	private double price;
	
	Property (String n, double p){
		super(n);
		price = p;
	}
	
	public double getPrice(){
		return price;
	}
}

class Housing extends Property{
	private double price;
	private Color color;
	
	Housing(String n, double p, Color c){
		super(n, p);
		color = c;
	}
	
	public Color getColor(){
		return color;
	}
}

class RailRoad extends Property{

	RailRoad (String n, double p){
		super (n, p);
	}
}

class Utilities extends Property{

	Utilities (String n, double p){
		super(n, p);
	}
}

class Event extends BoardPiece{

	Event (String n){
		super (n);
	}
}
