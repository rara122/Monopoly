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
		frame.setSize(1280, 822);
		frame.setVisible(true);
	}
	
	public static void main (String [] args){
		Monopoly m1 = new Monopoly(8);
		
	}
}