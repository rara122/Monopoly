package AssignmentX;
import java.util.Random;
import javax.swing.*;
import java.awt.*;

/*	~~~~~~~~~~~~~~~~~~~~~~~~~~~
	::   Class Description   ::
	~~~~~~~~~~~~~~~~~~~~~~~~~~~
	  PlayerPanel is Nested.
	Player has one PlayerPanel.
	~~~~~~~~~~~~~~~~~~~~~~~~~~~ */


class Player{
	private String name;
	private double balance;
	private int position;
	private Random rando;
	private PlayerPanel pPanel;
	
	
	////////////////////////////////////////////////////
	// ***************  Constructors  *************** //
	////////////////////////////////////////////////////

	public Player(){
		name = "Player";
		balance = 1500.00;
		position = 0;
		pPanel = new PlayerPanel ();
		rando = new Random();
	}
	
	public Player(String n){
		name = n;
		balance = 1500.00;
		position = 0;
		pPanel = new PlayerPanel ();
		rando = new Random();
	}
		
		
	//////////////////////////////////////////////////////
	// *************  Accessor Functions  ************* //
	//////////////////////////////////////////////////////
	
	public String getName(){
		return name;
	}
	
	public double getBalance(){
		return balance;
	}
	
	public int getPosition(){
		return position;
	}
	
	public PlayerPanel getPlayerPanel(){
		return pPanel;
	}
	
	
	//////////////////////////////////////////////////////
	// **************  Mutator Functions  ************* //
	//////////////////////////////////////////////////////
	
	public boolean withdraw (double amount){
		if (amount < balance){
			balance -= amount;
			pPanel.repaint();
			return true;
		}
		else{
			System.out.println("Throw exception buddy: Not enough money!");
			return false;
		}
	}
	
	public boolean deposit (double amount){
		balance += amount;
		pPanel.repaint();
		return true;
	}
	
		// Set position. Return new position or -1 if bad input.
	public int setPosition(int pos){
		if(pos >= 0 && pos < 40){
			position = pos;
			return pos;
		}
		else{
			return -1;
		}
	}

	//////////////////////////////////////////////////////
	// ***************  Other Functions  ************** //
	//////////////////////////////////////////////////////

	
		// Returns 0 Implement to return 0, 1, 2, 3 for Jail
	public int takeTurn(){
		moveSpaces(rollDice());
		return 0;
	}
	
		// Returns new position
	public int moveSpaces(int spaces){
		int pos = position + spaces;
		if (pos > 39){
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$\nPassed Go, Collect $200\n$$$$$$$$$$$$$$$$$$$$$$$");
			deposit(200.00);
		}
		pos %= 40;
		return setPosition(pos);
	}
	
		// Rolls 2 dice. returns Sum
	public int rollDice (){
		int roll1,roll2;
		roll1 = (rando.nextInt() % 6 + 6) % 6 + 1;
		roll2 = (rando.nextInt() % 6 + 6) % 6 + 1;
		System.out.println("Rolled: " + roll1 + ", " + roll2);
		if(roll1 == roll2){
			//RETAKE TURN UNLESS 3 times
			System.out.println("###################\n     DOUBLES!\n###################");
		}
		return roll1 + roll2;
	}	
	
		// Returns "Pos: <position>, $<balance>"
	public String getStatus(){
		String status = "Pos: " + getPosition() + ", $" + getBalance();
		return status;
	}





	
	// public static void main (String args[]){
		// Player p1;
		// Player p2;
		// p1 = new Player();
		// p2 = new Player();
		
		// int roll;
		
		// for(int i = 0; i < 5; i++){
			// System.out.println("p1 balance: " + p1.getBalance());
			// System.out.println("p1 position: " + p1.getPosition());
			// System.out.print("p1 rolled: ");
			// roll = p1.rollDice();
			// System.out.println("p1 moving to space: " + p1.moveSpaces(roll) + "\n");
		// }
		
	// }

	
	//////////////////////////////////////////////////////
	// *****************  Nested Class **************** //
	//////////////////////////////////////////////////////
	
	class PlayerPanel extends JPanel{
		
		private JLabel nameLabel;
		private JLabel balanceLabel;
		
		public PlayerPanel(){
		
			setLayout(new BorderLayout());

			nameLabel = new JLabel (name);
			balanceLabel = new JLabel ("$" + balance);

			add(nameLabel, BorderLayout.NORTH);
			add(balanceLabel, BorderLayout.CENTER);
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			
			setBackground(Color.WHITE);
			balanceLabel.setText("$" + balance);
		}
	}
	
}


