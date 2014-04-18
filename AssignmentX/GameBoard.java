package AssignmentX;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class GameBoard extends JPanel{

	private JPanel mainPanel;
	private JPanel sidePanel;
	private java.util.List < BoardPiece > boardPieces;
	private java.util.List < JPanel > boardPiecePanels;
	private JPanel boardPiecePanelCenters [];
	private Player [] playerList;
	private JLabel [] playerTokens;
	private int numPlayers;
	private int currPlayer = 0;
	private int newPanel, prevPanel;

	
	private final static Color PURPLE = new Color (102, 0 , 102);

	
	////////////////////////////////////////////////////
	// ***************  Constructors  *************** //
	////////////////////////////////////////////////////	
	
	public GameBoard(){
		this(2);	
	}
	
	public GameBoard(int numP){
		numPlayers = numP;
		
			// UI Initialization
		setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
		mainPanel = new JPanel(new BorderLayout());
		sidePanel = new JPanel(new GridLayout(0, 1));

		loadBoardData();
		loadBoardPiecesUI();		
	}
	
	
	//////////////////////////////////////////////////////
	// *************  Accessor Functions  ************* //
	//////////////////////////////////////////////////////
	
	public java.util.List < BoardPiece > getBoardPieces(){
		return boardPieces;
	}
	
	public BoardPiece getBoardPiece(int position){
		return boardPieces.get(position);
	}
	
	
	//////////////////////////////////////////////////////
	// ***************  Other Functions  ************** //
	//////////////////////////////////////////////////////
	
		// Initialize boardPieces with data
	private void loadBoardData() {
	
		/* ~~~~~~~~~~~~~~~~~~~~~~~~ //
		//     Init Player Data     //
		// ~~~~~~~~~~~~~~~~~~~~~~~~ */		
		
			//TEMPORARY TOKENS AS JLABELS
		playerTokens = new JLabel [numPlayers];
		playerList = new Player[numPlayers];
		for (int i = 0; i < numPlayers; i++){
			playerList[i] = new Player(("[" + (i+1) + "]"));
			playerTokens[i] = new JLabel (playerList[i].getName());
			sidePanel.add(playerList[i].getPlayerPanel());
		}
		
		JButton rollButton = new JButton("ROLL!");
		sidePanel.add(rollButton);
		rollButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				prevPanel = playerList[currPlayer].getPosition();
				if (playerList[currPlayer].takeTurn() == 0){
					System.out.println(playerList[currPlayer].getStatus());
					newPanel = playerList[currPlayer].getPosition();
					repositionPlayer();
					currPlayer = (currPlayer+1) % numPlayers;
				}
			}
		});

		

		/* ~~~~~~~~~~~~~~~~~~~~~~~ //
		//     Init Board Data     //
		// ~~~~~~~~~~~~~~~~~~~~~~~ */
		
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
		boardPieces.add(new Housing("St. James Place", 180.00, Color.ORANGE));
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
		boardPiecePanelCenters = new JPanel [40];
		
		for (int i = 0; i < boardPieces.size(); i++){
			JPanel p = new JPanel (new BorderLayout());
			boardPiecePanelCenters[i] = new JPanel();
			boardPiecePanelCenters[i].setBackground(Color.WHITE);
			JLabel nameLabel = new JLabel("" + boardPieces.get(i).getHtmlName());
			Color textColor;

			if(boardPieces.get(i).getColor() == Color.BLUE || boardPieces.get(i).getColor() == PURPLE){
				textColor = Color.WHITE;
			}
			else{
				textColor = Color.BLACK;
			}			
			nameLabel.setHorizontalAlignment(JLabel.CENTER);
			nameLabel.setVerticalAlignment(JLabel.CENTER);			
			nameLabel.setForeground(textColor);
			nameLabel.setBackground(boardPieces.get(i).getColor());
			nameLabel.setOpaque(true);
			
			if(nameLabel.getBackground() != Color.WHITE){
				nameLabel.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, Color.BLACK));
			}
			
			if(boardPieces.get(i) instanceof Property){
				Property prop = (Property) boardPieces.get(i);
				JLabel priceLabel = new JLabel("$" + prop.getPrice());
				priceLabel.setHorizontalAlignment(JLabel.CENTER);
				priceLabel.setVerticalAlignment(JLabel.CENTER);				
				p.add(priceLabel, BorderLayout.SOUTH);
			}
			
			p.add(nameLabel, BorderLayout.NORTH);
			p.add(boardPiecePanelCenters[i], BorderLayout.CENTER);
			p.setBorder(BorderFactory.createLineBorder(Color.BLACK));
			p.setBackground(Color.WHITE);
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
		
		Dimension horiSize = new Dimension(90, 100);
		Dimension vertSize = new Dimension(120, 67);
		Dimension cornerSize = new Dimension(120, 100);
				
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
		
			// Place playerTokens
		for(int i = 0; i < numPlayers; i++){
			boardPiecePanelCenters[0].add(playerTokens[i]);
		}
		
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(westPanel, BorderLayout.WEST);
		
		add(mainPanel);
		add(sidePanel);
	}
	
	
		// Override paintComponent to draw
	public void paintComponent(Graphics g){
		super.paintComponent(g);

		// double subLength, subWidth;
		// Dimension panelSize = getSize();
		// subLength = (panelSize.getHeight() / 13);
		// subWidth = (panelSize.getWidth() /13);
		
		
		// Dimension horiSize = new Dimension((int) subWidth, (int) subLength*2);
		// Dimension vertSize = new Dimension((int) subWidth*2, (int) subLength);
		// Dimension cornerSize = new Dimension((int) subWidth*2, (int) subLength*2);
		
		// Dimension horiSize = new Dimension(90, 120);
		// // Dimension vertSize = new Dimension(120, 60);
		// // Dimension cornerSize = new Dimension(120, 120);
		// // System.out.println("Width: " + horiSize.getWidth() + ", Height: " + horiSize.getHeight());
		// // System.out.println("subWidth: " + subWidth + ", subheight: " + subLength + "\n");
				
		// for (int i = 0; i < boardPiecePanels.size(); i++){
				// // SOUTH
			// if(i <= 10){
				// boardPiecePanels.get(i).setPreferredSize(horiSize);
				// boardPiecePanels.get(i).setMinimumSize(horiSize);
				// boardPiecePanels.get(i).setMaximumSize(horiSize);
				// if(i == 0 | i == 10){
					// boardPiecePanels.get(i).setPreferredSize(cornerSize);
					// boardPiecePanels.get(i).setMinimumSize(cornerSize);
					// boardPiecePanels.get(i).setMaximumSize(cornerSize);
				// }
			// }
				// // WEST
			// else if(i >= 11 && i <= 19){
				// boardPiecePanels.get(i).setPreferredSize(vertSize);
				// boardPiecePanels.get(i).setMinimumSize(vertSize);
				// boardPiecePanels.get(i).setMaximumSize(vertSize);
			// }
				// // NORTH
			// else if(i >=20 && i <= 30){
				// boardPiecePanels.get(i).setPreferredSize(horiSize);
				// boardPiecePanels.get(i).setMinimumSize(horiSize);
				// boardPiecePanels.get(i).setMaximumSize(horiSize);
				// if(i == 20 | i == 30){
					// boardPiecePanels.get(i).setPreferredSize(cornerSize);
					// boardPiecePanels.get(i).setMinimumSize(cornerSize);
					// boardPiecePanels.get(i).setMaximumSize(cornerSize);
				// }
			// }
				// // EAST
			// else if(i >= 31 && i <= 39){
				// boardPiecePanels.get(i).setPreferredSize(vertSize);
				// boardPiecePanels.get(i).setMinimumSize(vertSize);
				// boardPiecePanels.get(i).setMaximumSize(vertSize);
			// }
			// else{
				// System.err.println("boardPiecesPanels Index bound exceeded!");
			// }
		// }		
	}
	
	private void repositionPlayer(){
		boardPiecePanelCenters[prevPanel].remove(playerTokens[currPlayer]);
		boardPiecePanelCenters[newPanel].add(playerTokens[currPlayer]);
		repaint();
	}
	
	// public static void main (String args []){
		// // GameBoard gb = new GameBoard();
		
		// // for (BoardPiece b : gb.boardPieces){
			// // System.out.println(gb.boardPieces.getName());
		// // }
	// }
}



