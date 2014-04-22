package AssignmentX;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/* ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   ::               Class Description                      ::
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   |  GameBoard has at least 2 - 8 Players in a playerList  |
   |    GameBoard is made up of mainPanel and sidePanel     |
   |  mainPanel is the Monopoly board init with boardPieces |
   |  sidePanel consists of playersPanels and a rollButton  |
   |   rollButton's actionPerformed is where takeTurn() is  |
   | boardPiecePanelCenters are centers of boardPiecePanels |
   ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


public class GameBoard extends JPanel{

	private JPanel mainPanel;
	private JPanel sidePanel;
	private java.util.List < BoardPiece > boardPieces;
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
		setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));
		setBackground(Color.WHITE);
		mainPanel = new JPanel(new BorderLayout());
		sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.PAGE_AXIS));

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
			playerTokens[i].setHorizontalAlignment(JLabel.CENTER);
			playerTokens[i].setVerticalAlignment(JLabel.CENTER);
			playerTokens[i].setBackground(Color.WHITE);
			playerTokens[i].setForeground(Color.BLACK);	
			playerTokens[i].setOpaque(true);
		}
		
		JButton rollButton = new JButton("ROLL!");
		rollButton.setAlignmentX(Component.CENTER_ALIGNMENT);
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
		boardPieces.add(new Housing("Mediterranean Avenue","<html> <p style='text-align:center;'>Mediterranean<br/>Avenue</p></html>", 60, PURPLE));		
		boardPieces.add(new Event("Community Chest", "<html> <p style='text-align:center;'>Community<br/>Chest</p></html>"));
		boardPieces.add(new Housing("Baltic Avenue", 60, PURPLE));
		boardPieces.add(new Event("Income Tax"));
		boardPieces.add(new RailRoad("Reading Railroad", "<html> <p style='text-align:center;'>Reading<br/>Railroad</p></html>", 200));
		boardPieces.add(new Housing("Oriental Avenue", "<html> <p style='text-align:center;'>Oriental<br/>Avenue</p></html>", 100, Color.CYAN));
		boardPieces.add(new Event("Chance"));
		boardPieces.add(new Housing("Vermont Avenue", "<html> <p style='text-align:center;'>Vermont<br/>Avenue</p></html>", 100, Color.CYAN));
		boardPieces.add(new Housing("Connecticut Avenue", "<html> <p style='text-align:center;'>Connecticut<br/>Avenue</p></html>", 120, Color.CYAN));
		boardPieces.add(new Event("In Jail/ Just Visiting", "<html> <p style='text-align:center;'>In Jail<br/>Just Visiting</p></html>"));
		
			// WEST BORDER 11-19
		boardPieces.add(new Housing("St.Charles Place", 140, Color.PINK));
		boardPieces.add(new Utilities("Electric Company", 150));
		boardPieces.add(new Housing("States Avenue", 140, Color.PINK));
		boardPieces.add(new Housing("Virginia Avenue", 160, Color.PINK));
		boardPieces.add(new RailRoad("Pennsylvania Avenue", "<html> <p style='text-align:center;'>Pennsylvania<br/>Railroad</p></html>", 200));
		boardPieces.add(new Housing("St. James Place", 180, Color.ORANGE));
		boardPieces.add(new Event("Community Chest"));		
		boardPieces.add(new Housing("Tennessee Avenue", 180, Color.ORANGE));
		boardPieces.add(new Housing("New York Avenue", 200, Color.ORANGE));

			// NORTH BORDER 20-30
		boardPieces.add(new Event("Free Parking"));
		boardPieces.add(new Housing("Kentucky Avenue", "<html> <p style='text-align:center;'>Kentucky<br/>Avenue</p></html>", 220, Color.RED));
		boardPieces.add(new Event("Chance"));
		boardPieces.add(new Housing("Indiana Avenue", "<html> <p style='text-align:center;'>Indiana<br/>Avenue</p></html>", 220, Color.RED));
		boardPieces.add(new Housing("Illinois Avenue", "<html> <p style='text-align:center;'>Illinois<br/>Avenue</p></html>", 240, Color.RED));
		boardPieces.add(new RailRoad("B&O Railroad", "<html> <p style='text-align:center;'>B&O<br/>Railroad</p></html>", 200));
		boardPieces.add(new Housing("Atlantic Avenue", "<html> <p style='text-align:center;'>Atlantic<br/>Avenue</p></html>", 260, Color.YELLOW));
		boardPieces.add(new Housing("Ventor Avenue", "<html> <p style='text-align:center;'>Ventnor<br/>Avenue</p></html>", 260, Color.YELLOW));
		boardPieces.add(new Utilities("Water Works", 150));
		boardPieces.add(new Housing("Marvin Gardens", "<html> <p style='text-align:center;'>Marvin<br/>Gardens</p></html>", 280, Color.YELLOW));
		boardPieces.add(new Event("Go To Jail"));
		
			// EAST BORDER 31-39
		boardPieces.add(new Housing("Pacific Avenue", 300, Color.GREEN));
		boardPieces.add(new Housing("North Carolina Avenue", "<html> <p style='text-align:center;'>North Carolina<br/>Avenue</p></html>", 300, Color.GREEN));
		boardPieces.add(new Event("Community Chest"));		
		boardPieces.add(new Housing("Pennsylvania Avenue", "<html> <p style='text-align:center;'>Pennsylvania<br/>Avenue</p></html>", 320, Color.GREEN));
		boardPieces.add(new RailRoad("Short Line", 200));
		boardPieces.add(new Event("Chance"));
		boardPieces.add(new Housing("Park Place", 350, Color.BLUE));
		boardPieces.add(new Event("Luxury Tax"));		
		boardPieces.add(new Housing("Boardwalk", 400, Color.BLUE));
		
	}

	
		// Initialize boardPiecePanels with panels
	private void loadBoardPiecesUI(){
	
			// Adding Panels and adjusting their Sizes
		JPanel northPanel = new JPanel();
		JPanel eastPanel = new JPanel();
		JPanel southPanel = new JPanel();
		JPanel westPanel = new JPanel();
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.LINE_AXIS));
		eastPanel.setLayout(new BoxLayout(eastPanel, BoxLayout.PAGE_AXIS));
		southPanel.setLayout(new BoxLayout(southPanel, BoxLayout.LINE_AXIS));
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.PAGE_AXIS));
		
		southPanel.setComponentOrientation( ComponentOrientation.RIGHT_TO_LEFT );
		
		Dimension horiSize = new Dimension(100, 90);
		Dimension vertSize = new Dimension(130, 67);
		Dimension cornerSize = new Dimension(130, 90);
				
		for (int i = 0; i < boardPieces.size(); i++){
				// SOUTH
			if(i <= 10){
				boardPieces.get(i).setPreferredSize(horiSize);
				boardPieces.get(i).setMinimumSize(horiSize);
				boardPieces.get(i).setMaximumSize(horiSize);
				if(i == 0 | i == 10){
					boardPieces.get(i).setPreferredSize(cornerSize);
					boardPieces.get(i).setMinimumSize(cornerSize);
					boardPieces.get(i).setMaximumSize(cornerSize);
				}
				southPanel.add(boardPieces.get(i));
			}
				// WEST
			else if(i >= 11 && i <= 19){
				boardPieces.get(i).setPreferredSize(vertSize);
				boardPieces.get(i).setMinimumSize(vertSize);
				boardPieces.get(i).setMaximumSize(vertSize);
				westPanel.add(boardPieces.get(i), 0);
			}
				// NORTH
			else if(i >=20 && i <= 30){
				boardPieces.get(i).setPreferredSize(horiSize);
				boardPieces.get(i).setMinimumSize(horiSize);
				boardPieces.get(i).setMaximumSize(horiSize);
				if(i == 20 | i == 30){
					boardPieces.get(i).setPreferredSize(cornerSize);
					boardPieces.get(i).setMinimumSize(cornerSize);
					boardPieces.get(i).setMaximumSize(cornerSize);
				}
				northPanel.add(boardPieces.get(i));
			}
				// EAST
			else if(i >= 31 && i <= 39){
				boardPieces.get(i).setPreferredSize(vertSize);
				boardPieces.get(i).setMinimumSize(vertSize);
				boardPieces.get(i).setMaximumSize(vertSize);
				eastPanel.add(boardPieces.get(i));
			}
			else{
				System.err.println("boardPiecesPanels Index bound exceeded!");
			}
		}
		
			// Place playerTokens
		for(int i = 0; i < numPlayers; i++){
			boardPieces.get(0).getCenter().add(playerTokens[i]);
		}
		
		mainPanel.add(northPanel, BorderLayout.NORTH);
		mainPanel.add(eastPanel, BorderLayout.EAST);
		mainPanel.add(southPanel, BorderLayout.SOUTH);
		mainPanel.add(westPanel, BorderLayout.WEST);
		
		add(mainPanel);
		add(sidePanel);
	}
	
	private void repositionPlayer(){
		JPanel pPanel, nPanel;
		pPanel = boardPieces.get(prevPanel).getCenter();
		nPanel = boardPieces.get(newPanel).getCenter();
		pPanel.remove(playerTokens[currPlayer]);
		nPanel.add(playerTokens[currPlayer]);
		validate();
	}

}



