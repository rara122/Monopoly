package AssignmentX;

// import AssignmentX.*;
import javax.swing.*;

public class Monopoly {

	public static void main (String [] args){
		JFrame frame = new JFrame("Monopoly");
		GameBoard gb = new GameBoard ();
		Player p1 = new Player();
		
		String status;
		for (int i = 0; i< 20; i++){
			// System.out.println(p1.getStatus() + ", on " + gb.getBoardPiece(p1.getPosition()));
			status = p1.takeTurn();
			status += ", on " + gb.getBoardPiece(p1.getPosition()) + "\n\n";
			System.out.println(status);
		}

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(gb);
		frame.pack();
		frame.setSize(1066, 819);
		frame.setVisible(true);

	}
}