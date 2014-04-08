import java.util.HashMap;
import java.awt.Color;

public class GameBoard {

	private static HashMap < String, BoardPiece > boardPieces;

	GameBoard(){
	
	}

	
	public static void main (String args []){
		Housing house = new Housing("Test1", 12.99, Color.RED);
		RailRoad r1 = new RailRoad("Pennsylvania RailRoad", 100.97);
		Utilities u1 = new Utilities("WaterWorks", 25.23);
		Event e1 = new Event ("Chance Card!");
		System.out.println(house.getName() + " :: $" + house.getPrice() + " :: " + house.getColor());
		System.out.println(r1.getName() + " :: $" + r1.getPrice());
		System.out.println(u1.getName() + " :: $" + u1.getPrice());
		System.out.println(e1.getName()+ "\n\n\n");
		
		BoardPiece boardpieces[] = new BoardPiece [4];
		boardpieces[0] = house;
		boardpieces[1] = r1;
		boardpieces[2] = u1;
		boardpieces[3] = e1;
		
		for(int i = 0; i < boardpieces.length; i++){
			System.out.println(boardpieces[i].getName());
		}
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
