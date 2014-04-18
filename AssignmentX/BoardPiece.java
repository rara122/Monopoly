package AssignmentX;
import java.util.*;
import java.awt.*;
import javax.swing.*;


/*	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    ::     Inheritance/Polymorphism Hierarchy        ::
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	      BoardPiece can be a Property or Event.
	-> Property can be Housing, RailRoad, or Utilities. 
	~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~  */
	
abstract class BoardPiece extends JPanel{
	private String name;
	private String htmlName;
	protected Color color = Color.WHITE;
	
	BoardPiece(String n){
		name = n;
		htmlName = "<html><p style='text-align:center;'>" + n + "<br/>&nbsp; </p></html>";
	}
	BoardPiece(String n, String htmlN){
		name = n;
		htmlName = htmlN;
	}
	
	public String getName(){
		return name;
	}
	
	public String getHtmlName(){
		return htmlName;
	}
	
	public Color getColor(){
		return color;
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
	
	Property (String n, String htmlN, double p){
		super(n, htmlN);
		price = p;
	}
	
	public double getPrice(){
		return price;
	}
}

class Housing extends Property{
	private double price;
	
	Housing(String n, double p, Color c){
		super(n, p);
		color = c;
	}

	Housing(String n, String htmlN, double p, Color c){
		super(n, htmlN, p);
		color = c;
	}
}

class RailRoad extends Property{

	RailRoad (String n, double p){
		super (n, p);
	}
	
	RailRoad (String n, String htmlN, double p){
		super (n, htmlN, p);
	}
}

class Utilities extends Property{

	Utilities (String n, double p){
		super(n, p);
	}
	
	Utilities (String n, String htmlN, double p){
		super(n, htmlN, p);
	}
}

class Event extends BoardPiece{

	Event (String n){
		super (n);
	}
	
	Event (String n, String htmlN){
		super (n, htmlN);
	}
}