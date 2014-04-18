package AssignmentX;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Monopoly {
	private int numPlayers;
	private GameBoard gb;
	
	
	////////////////////////////////////////////////////
	// ***************  Constructors  *************** //
	////////////////////////////////////////////////////
	
	public Monopoly(){
		this(2);
	}
	
	public Monopoly(int numP){
		// numPlayers = numP;
		gb = new GameBoard (numP);
		
		JFrame frame = new JFrame("Monopoly");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gb);
		frame.pack();
		frame.setSize(1266, 842);
		frame.setVisible(true);
	}
	
	
	//////////////////////////////////////////////////////
	// *************  Accessor Functions  ************* //
	//////////////////////////////////////////////////////
		
	// public Player[] getPlayers (){
		// return players;
	// }
	// public JPanel getMonopolyBoard(){
		// return monopolyBoard;
	// }
	
	
	//////////////////////////////////////////////////////
	// ***************  Other Functions  ************** //
	//////////////////////////////////////////////////////
	
		//Takes Turn & positions Player. Returns next player
	// public int takeTurn(){
		// int status;
		// System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~\nPlayer "+ (currPlayer+1));
		// status = players[currPlayer].takeTurn();
		// positionPlayer(currPlayer);
		// System.out.println("$" + players[currPlayer].getBalance() + "\n");
		
		// return (currPlayer + 1) % numPlayers;
	// }
	
	// private void positionPlayer(int currPlayer){
		// System.out.println("Placed to " + players[currPlayer].getPosition());
		// gb
	// }

	
	
	
	
	
	
	
	public static void main (String [] args){
		Monopoly m1 = new Monopoly(4);
		
	}
}