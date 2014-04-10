package AssignmentX;
import java.util.*;
import java.awt.*;
import javax.swing.*;


public class GameBoard extends JPanel{

	private java.util.List < BoardPiece > boardPieces;
	private java.util.List < JPanel > boardPiecePanels;
	private JPanel panel;
	
	private final static Color PURPLE = new Color (102, 0 , 102);

	public GameBoard(){
		
			// UI Initialization
		setLayout(new BorderLayout());
		setBackground(Color.WHITE);

		loadBoardData();
		loadBoardPiecesUI();		
		
		
			// // Prints Names of boardPieces
		// for (int i = 0; i < boardPieces.size(); i++){
			// // System.out.println(boardPieces.get(i) + ", Color = " + boardPieces.get(i).getColor());
			// System.out.println(boardPieces.get(i));
			// if ( (i+1) % 10 == 0 ){
				// System.out.println();
			// }
		// }
	}
	
	public java.util.List < BoardPiece > getBoardPieces(){
		return boardPieces;
	}
	
	public BoardPiece getBoardPiece(int position){
		return boardPieces.get(position);
	}
	
		// Initialize boardPieces with data
	private void loadBoardData() {
	
		boardPieces = new ArrayList < BoardPiece > (40);
		
			// SOUTH BORDER 0-10
		boardPieces.add(new Event("Go"));
		boardPieces.add(new Housing("Mediterranean Avenue","<html> <p style='text-align:center;'>Mediterranean<br/>Avenue</p></html>", 60.00, PURPLE));		
		boardPieces.add(new Event("Community Chest", "<html> <p style='text-align:center;'>Community<br/>Chest</p></html>"));
		boardPieces.add(new Housing("Baltic Avenue", 60.00, PURPLE));
		boardPieces.add(new Event("Income Tax"));
		boardPieces.add(new RailRoad("Reading Railroad", "<html> <p style='text-align:center;'>Reading<br/>Railroad</p></html>", 200.00));
		boardPieces.add(new Housing("Oriental Avenue", "<html> <p style='text-align:center;'>Oriental<br/>Avenue</p></html>", 100.00, Color.CYAN));
		boardPieces.add(new Event("Chance"));
		boardPieces.add(new Housing("Vermont Avenue", "<html> <p style='text-align:center;'>Vermont<br/>Avenue</p></html>", 100.00, Color.CYAN));
		boardPieces.add(new Housing("Connecticut Avenue", "<html> <p style='text-align:center;'>Connecticut<br/>Avenue</p></html>", 120.00, Color.CYAN));
		boardPieces.add(new Event("In Jail/ Just Visiting", "<html> <p style='text-align:center;'>In Jail<br/>Just Visiting</p></html>"));
		
			// WEST BORDER 11-19
		boardPieces.add(new Housing("St.Charles Place", 140.00, Color.PINK));
		boardPieces.add(new Utilities("Electric Company", 150.00));
		boardPieces.add(new Housing("States Avenue", 140.00, Color.PINK));
		boardPieces.add(new Housing("Virginia Avenue", 160.00, Color.PINK));
		boardPieces.add(new RailRoad("Pennsylvania Avenue", "<html> <p style='text-align:center;'>Pennsylvania<br/>Railroad</p></html>", 200.00));
		boardPieces.add(new Housing("St.James Place", 180.00, Color.ORANGE));
		boardPieces.add(new Event("Community Chest"));		
		boardPieces.add(new Housing("Tennessee Avenue", 180.00, Color.ORANGE));
		boardPieces.add(new Housing("New York Avenue", 200.00, Color.ORANGE));

			// NORTH BORDER 20-30
		boardPieces.add(new Event("Free Parking"));
		boardPieces.add(new Housing("Kentucky Avenue", "<html> <p style='text-align:center;'>Kentucky<br/>Avenue</p></html>", 220.00, Color.RED));
		boardPieces.add(new Event("Chance"));
		boardPieces.add(new Housing("Indiana Avenue", "<html> <p style='text-align:center;'>Indiana<br/>Avenue</p></html>", 220.00, Color.RED));
		boardPieces.add(new Housing("Illinois Avenue", "<html> <p style='text-align:center;'>Illinois<br/>Avenue</p></html>", 240.00, Color.RED));
		boardPieces.add(new RailRoad("B&O Railroad", "<html> <p style='text-align:center;'>B&O<br/>Railroad</p></html>", 200.00));
		boardPieces.add(new Housing("Atlantic Avenue", "<html> <p style='text-align:center;'>Atlantic<br/>Avenue</p></html>", 260.00, Color.YELLOW));
		boardPieces.add(new Housing("Ventor Avenue", "<html> <p style='text-align:center;'>Ventnor<br/>Avenue</p></html>", 260.00, Color.YELLOW));
		boardPieces.add(new Utilities("Water Works", 150.00));
		boardPieces.add(new Housing("Marvin Gardens", "<html> <p style='text-align:center;'>Marvin<br/>Gardens</p></html>", 280.00, Color.YELLOW));
		boardPieces.add(new Event("Go To Jail"));
		
			// EAST BORDER 31-39
		boardPieces.add(new Housing("Pacific Avenue", 300.00, Color.GREEN));
		boardPieces.add(new Housing("North Carolina Avenue", "<html> <p style='text-align:center;'>North Carolina<br/>Avenue</p></html>", 300.00, Color.GREEN));
		boardPieces.add(new Event("Community Chest"));		
		boardPieces.add(new Housing("Pennsylvania Avenue", "<html> <p style='text-align:center;'>Pennsylvania<br/>Avenue</p></html>", 320.00, Color.GREEN));
		boardPieces.add(new RailRoad("Short Line", 200.00));
		boardPieces.add(new Event("Chance"));
		boardPieces.add(new Housing("Park Place", 350.00, Color.BLUE));
		boardPieces.add(new Event("Luxury Tax"));		
		boardPieces.add(new Housing("Boardwalk", 400.00, Color.BLUE));
	}

	
		// Initialize boardPiecePanels with panels
	private void loadBoardPiecesUI(){
			// Drawing Panels
		boardPiecePanels =  new ArrayList < JPanel > (40);
		for (int i = 0; i < boardPieces.size(); i++){
			JPanel p = new JPanel (new BorderLayout());
			JLabel nameLabel = new JLabel("" + boardPieces.get(i).getHtmlName());
			nameLabel.setHorizontalAlignment(JLabel.CENTER);
			nameLabel.setVerticalAlignment(JLabel.CENTER);
			nameLabel.setForeground(boardPieces.get(i).getColor());
			// nameLabel.setBackground(boardPieces.get(i).getColor());
			// nameLabel.setOpaque(true);
			if(boardPieces.get(i) instanceof Property){
				Property prop = (Property) boardPieces.get(i);
				JLabel priceLabel = new JLabel("$" + prop.getPrice());
				priceLabel.setHorizontalAlignment(JLabel.CENTER);
				priceLabel.setVerticalAlignment(JLabel.CENTER);				
				p.add(priceLabel, BorderLayout.SOUTH);
			}
			
			p.add(nameLabel, BorderLayout.NORTH);
			p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			if (i % 2 == 0){
				p.setBackground(Color.WHITE);
			}
			boardPiecePanels.add(i, p);
		}
		
		JPanel northPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel westPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.LINE_AXIS));
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS));
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.LINE_AXIS));
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.PAGE_AXIS));
		
		southPanel.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		
		Dimension horiSize = new Dimension(90, 120);
		Dimension vertSize = new Dimension(120, 60);
		Dimension cornerSize = new Dimension(120, 120);
				
		for (int i = 0; i < boardPiecePanels.size(); i++){
				// SOUTH
			if(i <= 10){
				boardPiecePanels.get(i).setPreferredSize(horiSize);
				boardPiecePanels.get(i).setMinimumSize(horiSize);
				boardPiecePanels.get(i).setMaximumSize(horiSize);
				if(i == 0 | i == 10){
					boardPiecePanels.get(i).setPreferredSize(cornerSize);
					boardPiecePanels.get(i).setMinimumSize(cornerSize);
					boardPiecePanels.get(i).setMaximumSize(cornerSize);
				}
				southPanel.add(boardPiecePanels.get(i));
			}
				// WEST
			else if(i >= 11 && i <= 19){
				boardPiecePanels.get(i).setPreferredSize(vertSize);
				boardPiecePanels.get(i).setMinimumSize(vertSize);
				boardPiecePanels.get(i).setMaximumSize(vertSize);
				westPanel.add(boardPiecePanels.get(i), 0);
			}
				// NORTH
			else if(i >=20 && i <= 30){
				boardPiecePanels.get(i).setPreferredSize(horiSize);
				boardPiecePanels.get(i).setMinimumSize(horiSize);
				boardPiecePanels.get(i).setMaximumSize(horiSize);
				if(i == 20 | i == 30){
					boardPiecePanels.get(i).setPreferredSize(cornerSize);
					boardPiecePanels.get(i).setMinimumSize(cornerSize);
					boardPiecePanels.get(i).setMaximumSize(cornerSize);
				}
				northPanel.add(boardPiecePanels.get(i));
			}
				// EAST
			else if(i >= 31 && i <= 39){
				boardPiecePanels.get(i).setPreferredSize(vertSize);
				boardPiecePanels.get(i).setMinimumSize(vertSize);
				boardPiecePanels.get(i).setMaximumSize(vertSize);
				eastPanel.add(boardPiecePanels.get(i));
			}
			else{
				System.err.println("boardPiecesPanels Index bound exceeded!");
			}
		}
		
		add(northPanel, BorderLayout.NORTH);
		add(eastPanel, BorderLayout.EAST);
		add(southPanel, BorderLayout.SOUTH);
		add(westPanel, BorderLayout.WEST);
	}
	
	
		// Override paintComponent to draw
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		double subLength, subWidth;
		int top, left, bottom, right;
		// subLength = (getHeight() / 13) + (getHeight() % 13);
		// subWidth = (getWidth() /13) + (getWidth() % 13);
		Dimension panelSize = getSize();
		subLength = (panelSize.getHeight() / 13);
		subWidth = (panelSize.getWidth() /13);
		// top = bottom = subLength;
		// right = left = subWidth;
		
		
		Dimension horiSize = new Dimension((int) subLength, (int) subWidth*2);
		Dimension vertSize = new Dimension((int) subLength*2, (int) subWidth);
		Dimension cornerSize = new Dimension((int) subLength*2, (int) subWidth*2);
		
		// // Dimension horiSize = new Dimension(90, 120);
		// // Dimension vertSize = new Dimension(120, 60);
		// // Dimension cornerSize = new Dimension(120, 120);
		// System.out.println("Width: " + horiSize.getWidth() + ", Height: " + horiSize.getHeight());
		// System.out.println("subWidth: " + subWidth + ", subheight: " + subLength + "\n");
				
		for (int i = 0; i < boardPiecePanels.size(); i++){
				// SOUTH
			if(i <= 10){
				boardPiecePanels.get(i).setPreferredSize(horiSize);
				boardPiecePanels.get(i).setMinimumSize(horiSize);
				boardPiecePanels.get(i).setMaximumSize(horiSize);
				// boardPiecePanels.get(i).setPreferredSize(new Dimension (top, right*2));
				// boardPiecePanels.get(i).setMinimumSize(new Dimension (top, right*2));
				// boardPiecePanels.get(i).setMaximumSize(new Dimension (top, right*2));
				if(i == 0 | i == 10){
					boardPiecePanels.get(i).setPreferredSize(cornerSize);
					boardPiecePanels.get(i).setMinimumSize(cornerSize);
					boardPiecePanels.get(i).setMaximumSize(cornerSize);
					// boardPiecePanels.get(i).setPreferredSize(new Dimension (top*2, right*2));
					// boardPiecePanels.get(i).setMinimumSize(new Dimension (top*2, right*2));
					// boardPiecePanels.get(i).setMaximumSize(new Dimension (top*2, right*2));
				}
				// southPanel.add(boardPiecePanels.get(i));
			}
				// WEST
			else if(i >= 11 && i <= 19){
				boardPiecePanels.get(i).setPreferredSize(vertSize);
				boardPiecePanels.get(i).setMinimumSize(vertSize);
				boardPiecePanels.get(i).setMaximumSize(vertSize);
				// westPanel.add(boardPiecePanels.get(i), 0);
			}
				// NORTH
			else if(i >=20 && i <= 30){
				boardPiecePanels.get(i).setPreferredSize(horiSize);
				boardPiecePanels.get(i).setMinimumSize(horiSize);
				boardPiecePanels.get(i).setMaximumSize(horiSize);
				if(i == 20 | i == 30){
					boardPiecePanels.get(i).setPreferredSize(cornerSize);
					boardPiecePanels.get(i).setMinimumSize(cornerSize);
					boardPiecePanels.get(i).setMaximumSize(cornerSize);
				}
				// northPanel.add(boardPiecePanels.get(i));
		// System.out.println("Width: " + horiSize.getWidth() + ", Height: " + horiSize.getHeight());
		// System.out.println("CornerWidth: " + cornerSize.getWidth() + ", cornHeight: " + cornerSize.getHeight() + "\n");

			}
				// EAST
			else if(i >= 31 && i <= 39){
				boardPiecePanels.get(i).setPreferredSize(vertSize);
				boardPiecePanels.get(i).setMinimumSize(vertSize);
				boardPiecePanels.get(i).setMaximumSize(vertSize);
				// eastPanel.add(boardPiecePanels.get(i));
			}
			else{
				System.err.println("boardPiecesPanels Index bound exceeded!");
			}
		}
		
	}
	
	
	public static void main (String args []){
		// GameBoard gb = new GameBoard();
		
		// for (BoardPiece b : gb.boardPieces){
			// System.out.println(gb.boardPieces.getName());
		// }
	}
}



abstract class BoardPiece extends JPanel{
	private String name;
	private String htmlName;
	protected Color color = Color.BLACK;
	
	BoardPiece(String n){
		name = htmlName = n;	
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