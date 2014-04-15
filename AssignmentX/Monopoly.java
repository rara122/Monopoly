package AssignmentX;

// import AssignmentX.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Monopoly {
	private int numPlayers;
	private Player players [];
	private JPanel monopolyBoard;
	private GameBoard gb;
	private PlayersPanel playersPanel;
	private int currPlayer = 0;
	
	public Monopoly(){
		this(2);
	}
	
	public Monopoly(int numP){
		numPlayers = numP;
		gb = new GameBoard ();
		players = new Player [numP];
		for (int i = 0; i < numP; i++){
			players[i] = new Player();
		}

		JPanel sidePanel = new JPanel(new BorderLayout());
		playersPanel = new PlayersPanel(players);
		JButton rollButton = new JButton("ROLL!");
		rollButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				takeTurn();
			}
		});
		
		sidePanel.add(playersPanel, BorderLayout.CENTER);
		sidePanel.add(rollButton, BorderLayout.SOUTH);

		monopolyBoard = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		monopolyBoard.add(gb);
		monopolyBoard.add(sidePanel);
		
		
		JFrame frame = new JFrame("Monopoly");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// frame.add(gb);
		frame.add(monopolyBoard);
		frame.pack();
		frame.setSize(1266, 842);
		frame.setVisible(true);
		
	}
	
	public Player[] getPlayers (){
		return players;
	}
	public JPanel getMonopolyBoard(){
		return monopolyBoard;
	}
	
		//Takes Turn & positions Player. Returns next player
	public int takeTurn(){
		String status;
		System.out.println("Player " + currPlayer);
		status = players[currPlayer].takeTurn();
		positionPlayer(currPlayer);
		
		return (currPlayer + 1) % numPlayers;
	}
	
	private void positionPlayer(int currPlayer){
		System.out.println("Placed to " + players[currPlayer].getPosition());
	}

	public static void main (String [] args){
		Monopoly m1 = new Monopoly(4);
		// for (int i = 0; i < 55; i++){
			// m1.takeTurn();
			// System.out.println();
		// }
		
		
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println(":: Player 1 ::\n" + m1.getPlayers()[0].getStatus() + "\n");
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
		System.out.println(":: Player 2 ::\n" + m1.getPlayers()[1].getStatus());
	}
}