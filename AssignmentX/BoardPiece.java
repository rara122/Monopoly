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
	private JLabel nameLabel;
	private JPanel centerPanel;
	private final static Color PURPLE = new Color (102, 0 , 102);
	protected Color color = Color.WHITE;
	protected Color textColor = Color.BLACK;

	BoardPiece(String n){
		this(n, "<html><p style='text-align:center;'>" + n + "<br/>&nbsp; </p></html>");
	}
	
	BoardPiece(String n, String htmlN){
		this(n, "<html><p style='text-align:center;'>" + n + "<br/>&nbsp; </p></html>", Color.WHITE);
	}
	
	BoardPiece(String n, String htmlN, Color c){
		name = n;
		htmlName = htmlN;
		color = c;
		nameLabel = new JLabel(htmlName);
		centerPanel = new JPanel(new GridLayout(1, 8));
		if(color == Color.BLUE || color.getRGB() == PURPLE.getRGB()){
			textColor = Color.WHITE;
		}
		
		add(nameLabel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);
		
		nameLabel.setHorizontalAlignment(JLabel.CENTER);
		nameLabel.setVerticalAlignment(JLabel.CENTER);
		nameLabel.setForeground(textColor);
		nameLabel.setBackground(color);
		nameLabel.setOpaque(true);
		centerPanel.setBackground(Color.WHITE);
		
		if(nameLabel.getBackground() != Color.WHITE){
			nameLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
		}
		
		setBorder(BorderFactory.createLineBorder(Color.BLACK));
		
		add(nameLabel, BorderLayout.NORTH);
		add(centerPanel, BorderLayout.CENTER);
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
	
	public JPanel getCenter(){
		return centerPanel;
	}
	
	@Override
	public String toString(){
		return name;
	}
}

abstract class Property extends BoardPiece{
	private int price;
	private JLabel priceLabel;
	
	Property (String n, int p){
		this(n, "<html><p style='text-align:center;'>" + n + "<br/>&nbsp; </p></html>", p, Color.WHITE);
	}
	
	Property (String n, String htmlN, int p){
		this(n, htmlN, p, Color.WHITE);
	}
	
	Property (String n, String htmlN, int p, Color c){
		super(n, htmlN, c);
		price = p;
		
		priceLabel = new JLabel("$" + price);
		priceLabel.setHorizontalAlignment(JLabel.CENTER);
		priceLabel.setVerticalAlignment(JLabel.CENTER);				
		add(priceLabel, BorderLayout.SOUTH);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		add(priceLabel, BorderLayout.SOUTH);
	}
	
	public int getPrice(){
		return price;
	}
}

class Housing extends Property{
	private int price;
	
	Housing(String n, int p, Color c){
		this(n, "<html><p style='text-align:center;'>" + n + "<br/>&nbsp; </p></html>", p, c);
	}

	Housing(String n, String htmlN, int p, Color c){
		super(n, htmlN, p, c);
	}
}

class RailRoad extends Property{

	RailRoad (String n, int p){
		this(n, "<html><p style='text-align:center;'>" + n + "<br/>&nbsp; </p></html>", p);
	}
	
	RailRoad (String n, String htmlN, int p){
		super (n, htmlN, p);
	}
}

class Utilities extends Property{

	Utilities (String n, int p){
		this(n, "<html><p style='text-align:center;'>" + n + "<br/>&nbsp; </p></html>", p);
	}
	
	Utilities (String n, String htmlN, int p){
		super(n, htmlN, p);
	}
}

class Event extends BoardPiece{

	Event (String n){
		this(n, "<html><p style='text-align:center;'>" + n + "<br/>&nbsp; </p></html>");
	}
	
	Event (String n, String htmlN){
		super (n, htmlN);
	}
}