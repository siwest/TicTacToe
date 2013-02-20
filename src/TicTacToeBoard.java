import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.Timer;

public class TicTacToeBoard {
	static JButton[] buttons = new JButton [9];
	static Boolean player1Turn;
	static JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	static Boolean hasWon = false;
	
	static JTextField player1Name = new JTextField("Player 1");
	static JTextField player1ScoreLabel = new JTextField("0");
	static int player1Score = 0;
	
	static JTextField player2Name = new JTextField("Player 2");
	static JTextField player2ScoreLabel = new JTextField("0");
	static int player2Score = 0;
	
	static JTextField drawName = new JTextField("Draw Games");
	static JTextField drawLabel = new JTextField("0");
	static int drawScore = 0;
	
	JRadioButton tpMode = new JRadioButton("\tPlayer : Player Mode");
	static JRadioButton pcMode = new JRadioButton("\tPlayer : Computer Mode");
	JRadioButton pcVpcMode = new JRadioButton("\tComputer : Computer Mode");
	
	static String pcMarking = "O";
	
	static Boolean isPCMode = false;
	
	static JLabel playerX = new JLabel("\t\t\tX");
	static JLabel playerO = new JLabel("\t\t\tO");
	static Boolean won = false;

	

	public TicTacToeBoard() {
		// TODO Auto-generated constructor stub
	}
	
	public void createBoard() {
		
		frame.setSize(1000,700);
		frame.setLayout(new BorderLayout());
		frame.setBackground(Color.CYAN);
				
		JPanel outerPanel = new JPanel();
		outerPanel.setPreferredSize(new Dimension(1000, 700));
		outerPanel.setLayout(new BorderLayout());
		outerPanel.setBackground(Color.CYAN);
		outerPanel.setBorder(BorderFactory.createLineBorder(Color.black, 10));

		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 

		panel.setSize(600, 600);
		
		panel.setLayout(new GridLayout(3,3,5,5));		
		panel.setBackground(Color.BLACK);
		
		frame.add(outerPanel, BorderLayout.WEST);
		outerPanel.add(panel, BorderLayout.WEST);
		JPanel scoreBoard = new JPanel();
		scoreBoard.setSize(400, 700);
		scoreBoard.setPreferredSize(new Dimension(400,700));
		outerPanel.add(scoreBoard, BorderLayout.EAST);
		
		JLabel split = new JLabel();
		split.setPreferredSize(new Dimension(180, 50));
		
		JLabel spacer = new JLabel();
		spacer.setPreferredSize(new Dimension(55, 80));
		
		JPanel player1Panel = new JPanel();
		player1Panel.setPreferredSize(new Dimension(350, 100));
		JPanel player2Panel = new JPanel();
		player2Panel.setPreferredSize(new Dimension(350, 100));
		JPanel drawPanel = new JPanel();
		drawPanel.setPreferredSize(new Dimension(350, 100));
		
		playerX.setFont(new Font("", Font.BOLD, 30));
		playerX.setPreferredSize(new Dimension(60, 80));
		playerX.setForeground(Color.BLACK);
		playerO.setFont(new Font("", Font.BOLD, 30));
		playerO.setForeground(Color.BLACK);
		playerO.setPreferredSize(new Dimension(60, 80));
		
		player1Name.setPreferredSize(new Dimension(190, 80));
		player1Name.setFont(new Font("", Font.ITALIC, 19));
		player2Name.setPreferredSize(new Dimension(190, 80));
		player2Name.setFont(new Font("", Font.ITALIC, 19));
		drawName.setPreferredSize(new Dimension(190, 80));
		drawName.setFont(new Font("", Font.ITALIC, 19));
		drawName.setEditable(false);
		player1ScoreLabel.setPreferredSize(new Dimension(85, 80));
		player1ScoreLabel.setFont(new Font("", Font.ROMAN_BASELINE, 33));
		player2ScoreLabel.setPreferredSize(new Dimension(85, 80));
		player2ScoreLabel.setFont(new Font("", Font.ROMAN_BASELINE, 33));
		player1ScoreLabel.setEditable(false);
		player2ScoreLabel.setEditable(false);
		drawLabel.setEditable(false);
		drawLabel.setPreferredSize(new Dimension(85, 80));
		drawLabel.setFont(new Font("", Font.ROMAN_BASELINE, 33));
		player1Name.setToolTipText("Click to change Player 1 (X) name");
		player2Name.setToolTipText("Click to change Player 2 (O) name");
		player1Name.setHorizontalAlignment(JTextField.CENTER);
		player2Name.setHorizontalAlignment(JTextField.CENTER);
		drawName.setHorizontalAlignment(JTextField.CENTER);
		drawLabel.setHorizontalAlignment(JTextField.CENTER);
		player1ScoreLabel.setHorizontalAlignment(JTextField.CENTER);
		player2ScoreLabel.setHorizontalAlignment(JTextField.CENTER);

		
		scoreBoard.add(split);
		scoreBoard.add(split);
		scoreBoard.add(spacer);

		tpMode.setPreferredSize(new Dimension(320,130));
		tpMode.setFont(new Font("", Font.PLAIN, 23));
		pcMode.setPreferredSize(new Dimension(320,40));
		pcMode.setFont(new Font("", Font.PLAIN, 23));
		tpMode.setSelected(true);
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(tpMode);
		buttonGroup.add(pcMode);
		scoreBoard.add(split);
		scoreBoard.add(tpMode);
		scoreBoard.add(pcMode);
		scoreBoard.add(split);
		scoreBoard.add(split);
	
		tpMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isPCMode = false;
				buttons[0].setText("");
				buttons[1].setText("");
				buttons[2].setText("");
				buttons[3].setText("");
				buttons[4].setText("");
				buttons[5].setText("");
				buttons[6].setText("");
				buttons[7].setText("");
				buttons[8].setText("");
				hasWon = false;
				player1ScoreLabel.setText("0");
				player2ScoreLabel.setText("0");
				drawLabel.setText("0");
				drawScore = 0;
				player1Score = 0;
				player2Score = 0;
				player1Name.setText("Player 1");
				player2Name.setText("Player 2");
				playerX.setForeground(Color.BLUE);
				playerO.setForeground(Color.BLACK);	
				player1Turn = true;
				frame.repaint();
				
			}
		});
		
		pcMode.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				isPCMode = true;
				buttons[0].setText("");
				buttons[1].setText("");
				buttons[2].setText("");
				buttons[3].setText("");
				buttons[4].setText("");
				buttons[5].setText("");
				buttons[6].setText("");
				buttons[7].setText("");
				buttons[8].setText("");
				hasWon = false;
				player1ScoreLabel.setText("0");
				player2ScoreLabel.setText("0");
				drawLabel.setText("0");
				drawScore = 0;
				player1Score = 0;
				player2Score = 0;
				player2Name.setText("Computer");
				frame.repaint();
				playerX.setForeground(Color.BLUE);
				playerO.setForeground(Color.BLACK);	
				player1Turn = true;
			}
		});
		player1Panel.add(playerX);
		player1Panel.add(player1Name);
		player1Panel.add(player1ScoreLabel);
		player2Panel.add(playerO);
		player2Panel.add(player2Name);
		player2Panel.add(player2ScoreLabel);
		drawPanel.add(spacer);
		drawPanel.add(drawName);
		drawPanel.add(drawLabel);

		scoreBoard.add(player1Panel);
		scoreBoard.add(player2Panel);
		scoreBoard.add(drawPanel);
		
		
		
		
	
		
		for (int i=0; i<9; i++) {
			buttons[i]= new JButton();
			buttons[i].setBackground(Color.CYAN);
			buttons[i].setForeground(Color.BLACK);
			buttons[i].setFont(new Font("", Font.BOLD, 100));
			buttons[i].setOpaque(true);
			buttons[i].setSize(new Dimension(200,200));
			buttons[i].setPreferredSize(new Dimension(200,200));
			panel.add(buttons[i]);
		
		}
		
		player1Turn = true;
		for (int j=0; j<9; j++) {
			final int  thisButton = j;
			buttons[j].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (buttons[thisButton].getText() == "") {
						playerMakeMove(player1Turn, thisButton);
						
						if (player1Turn == false) {
							player1Turn = true;
						} else player1Turn = false;
						
	 					if (pcMode.isSelected()) {
	 						pcMakeMove(true, "O");
	 					}
					}
				}		
			});
		}
		
		
		frame.setTitle("Tic Tac Toe");
		frame.setLocationRelativeTo(null);
		frame.setPreferredSize(new Dimension(1000,700));
		frame.pack();
		frame.setVisible(true);
		
		
		playerX.setForeground(Color.BLUE);
		playerO.setForeground(Color.BLACK);


	}
	
	
	public static void pcMakeMove(Boolean pcMode, final String marking) {
		final String opponentMarking = "X";
	//	marking = "X";
			
			
		Timer t = new Timer(500, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
            	playerX.setForeground(Color.BLUE);
    			playerO.setForeground(Color.BLACK);
			// Play a winning move, if possible.
			if ((buttons[0].getText() == marking) && (buttons[4].getText() == marking) && (buttons[8].getText() == "")) {
				buttons[8].setText(marking);
				System.out.println("Trying to play a winning move1");
			}
			else if ((buttons[0].getText() == marking) && (buttons[8].getText() == marking) && (buttons[4].getText() == "")) {
				buttons[4].setText(marking);
				System.out.println("Trying to play a winning move2");
			}
			else if ((buttons[4].getText() == marking) && (buttons[8].getText() == marking) && (buttons[0].getText() == "")) {
				buttons[0].setText(marking);
				System.out.println("Trying to play a winning move3");
			}
			
			else if ((buttons[2].getText() == marking) && (buttons[4].getText() == marking) && (buttons[6].getText() == "")) {
				buttons[6].setText(marking);
				System.out.println("Trying to play a winning move4");
			}
			else if ((buttons[2].getText() == marking) && (buttons[6].getText() == marking) && (buttons[4].getText() == "")) {
				buttons[4].setText(marking);
				System.out.println("Trying to play a winning move5");
			}
			else if ((buttons[4].getText() == marking) && (buttons[6].getText() == marking) && (buttons[2].getText() == "")) {
				buttons[2].setText(marking);
				System.out.println("Trying to play a winning move6");
			}
			
			else if ((buttons[3].getText() == marking) && (buttons[4].getText() == marking) && (buttons[5].getText() == "")) {
				buttons[5].setText(marking);
				System.out.println("Trying to play a winning move7");
			}
			else if ((buttons[3].getText() == marking) && (buttons[5].getText() == marking) && (buttons[4].getText() == "")) {
				buttons[4].setText(marking);
				System.out.println("Trying to play a winning move8");
			}
			else if ((buttons[4].getText() == marking) && (buttons[5].getText() == marking) && (buttons[3].getText() == "")) {
				buttons[3].setText(marking);
				System.out.println("Trying to play a winning move9");
			}
	
			else if ((buttons[1].getText() == marking) && (buttons[4].getText() == marking) && (buttons[7].getText() == "")) {
				buttons[7].setText(marking);
				System.out.println("Trying to play a winning move10");
			}
			else if ((buttons[1].getText() == marking) && (buttons[7].getText() == marking) && (buttons[4].getText() == "")) {
				buttons[4].setText(marking);
				System.out.println("Trying to play a winning move11");
			}
			else if ((buttons[4].getText() == marking) && (buttons[7].getText() == marking) && (buttons[1].getText() == "")) {
				buttons[1].setText(marking);
				System.out.println("Trying to play a winning move12");
			}
			
			else if ((buttons[1].getText() == marking) && (buttons[0].getText() == marking) && (buttons[2].getText() == "")) {
				buttons[2].setText(marking);
				System.out.println("Trying to play a winning move13");
			}
			else if ((buttons[1].getText() == marking) && (buttons[2].getText() == marking) && (buttons[0].getText() == "")) {
				buttons[0].setText(marking);
				System.out.println("Trying to play a winning move14");
			}
			else if ((buttons[0].getText() == marking) && (buttons[2].getText() == marking) && (buttons[1].getText() == "")) {
				buttons[1].setText(marking);
				System.out.println("Trying to play a winning move15");
			}
			
			else if ((buttons[3].getText() == marking) && (buttons[0].getText() == marking) && (buttons[6].getText() == "")) {
				buttons[6].setText(marking);
				System.out.println("Trying to play a winning move16");
			}
			else if ((buttons[3].getText() == marking) && (buttons[6].getText() == marking) && (buttons[0].getText() == "")) {
				buttons[0].setText(marking);
				System.out.println("Trying to play a winning move17");
			}
			else if ((buttons[0].getText() == marking) && (buttons[6].getText() == marking) && (buttons[3].getText() == "")) {
				buttons[3].setText(marking);
				System.out.println("Trying to play a winning move18");
			}
			
			else if ((buttons[7].getText() == marking) && (buttons[8].getText() == marking) && (buttons[6].getText() == "")) {
				buttons[6].setText(marking);
			}
			else if ((buttons[7].getText() == marking) && (buttons[6].getText() == marking) && (buttons[8].getText() == "")) {
				buttons[8].setText(marking);
			}
			else if ((buttons[8].getText() == marking) && (buttons[6].getText() == marking) && (buttons[7].getText() == "")) {
				buttons[7].setText(marking);
			}
			
			else if ((buttons[2].getText() == marking) && (buttons[8].getText() == marking) && (buttons[5].getText() == "")) {
				buttons[5].setText(marking);
			}
			else if ((buttons[2].getText() == marking) && (buttons[5].getText() == marking) && (buttons[8].getText() == "")) {
				buttons[8].setText(marking);
			}
			else if ((buttons[8].getText() == marking) && (buttons[5].getText() == marking) && (buttons[2].getText() == "")) {
				buttons[2].setText(marking);
			}
						
			// If winning move cannot be played this turn, play a move that blocks opponent from winning.
			
			else if ((buttons[0].getText() == opponentMarking) && (buttons[4].getText() == opponentMarking) && (buttons[8].getText() == "")) {
				 buttons[8].setText(marking);
			}
			else if ((buttons[0].getText() == opponentMarking) && (buttons[8].getText() == opponentMarking) && (buttons[4].getText() == "")) {
				buttons[4].setText(marking);
			}

			else if ((buttons[4].getText() == opponentMarking) && (buttons[8].getText() == opponentMarking) && (buttons[0].getText() == "")) {
				buttons[0].setText(marking);
			}
			
			else if ((buttons[2].getText() == opponentMarking) && (buttons[4].getText() == opponentMarking) &&(buttons[6].getText() == "")) {
				buttons[6].setText(marking);
			}
			else if ((buttons[2].getText() == opponentMarking) && (buttons[6].getText() == opponentMarking) && (buttons[4].getText() == "")) {
				buttons[4].setText(marking);
			}
			else if ((buttons[4].getText() == opponentMarking) && (buttons[6].getText() == opponentMarking) && (buttons[2].getText() == "")) {
				buttons[2].setText(marking);
			}
			else if ((buttons[3].getText() == opponentMarking) && (buttons[4].getText() == opponentMarking) && (buttons[5].getText() == "")) {
				buttons[5].setText(marking);
			}
			else if ((buttons[3].getText() == opponentMarking) && (buttons[5].getText() == opponentMarking) && (buttons[4].getText() == "")) {
				buttons[4].setText(marking);
			}
			else if ((buttons[4].getText() == opponentMarking) && (buttons[5].getText() == opponentMarking) && (buttons[3].getText() == "")) {	
				buttons[3].setText(marking);
			}
			else if ((buttons[1].getText() == opponentMarking) && (buttons[4].getText() == opponentMarking) && (buttons[7].getText() == "")) {
				buttons[7].setText(marking);
			}
			else if ((buttons[1].getText() == opponentMarking) && (buttons[7].getText() == opponentMarking) && (buttons[4].getText() == "")) {			
				buttons[4].setText(marking);
			}
			else if ((buttons[4].getText() == opponentMarking) && (buttons[7].getText() == opponentMarking) && (buttons[1].getText() == "")) {
				buttons[1].setText(marking);
			}
			else if ((buttons[1].getText() == opponentMarking) && (buttons[0].getText() == opponentMarking) && (buttons[2].getText() == "")) {				
				buttons[2].setText(marking);
			}
			else if ((buttons[1].getText() == opponentMarking) && (buttons[2].getText() == opponentMarking) && (buttons[0].getText() == "")) {
				buttons[0].setText(marking);
			}
			else if ((buttons[0].getText() == opponentMarking) && (buttons[2].getText() == opponentMarking) && (buttons[1].getText() == "")) {
				buttons[1].setText(marking);
			}
			else if ((buttons[3].getText() == opponentMarking) && (buttons[0].getText() == opponentMarking) && (buttons[6].getText() == "")) {
				buttons[6].setText(marking);
			}
			else if ((buttons[3].getText() == opponentMarking) && (buttons[6].getText() == opponentMarking) && (buttons[0].getText() == "")) {
				buttons[0].setText(marking);					
			}
			else if ((buttons[0].getText() == opponentMarking) && (buttons[6].getText() == opponentMarking) && (buttons[3].getText() == "")) {
				buttons[3].setText(marking);
			}
			else if ((buttons[7].getText() == opponentMarking) && (buttons[8].getText() == opponentMarking) && (buttons[6].getText() == "")) {
				buttons[6].setText(marking);
			}
			else if ((buttons[7].getText() == opponentMarking) && (buttons[6].getText() == opponentMarking) && (buttons[8].getText() == "")) {
					buttons[8].setText(marking);
			}
			else if ((buttons[8].getText() == opponentMarking) && (buttons[6].getText() == opponentMarking) && (buttons[7].getText() == "")) {
				buttons[7].setText(marking);
			}
			else if ((buttons[2].getText() == opponentMarking) && (buttons[8].getText() == opponentMarking) && (buttons[5].getText() == "")) {
				buttons[5].setText(marking);
			}
			else if ((buttons[2].getText() == opponentMarking) && (buttons[5].getText() == opponentMarking) && (buttons[8].getText() == "")) {
				buttons[8].setText(marking);
			}
			else if ((buttons[8].getText() == opponentMarking) && (buttons[5].getText() == opponentMarking) && (buttons[2].getText() == "")) {
				buttons[2].setText(marking);
			}
						
			//The board is closing up, play thr best possible move to win.
			else if ( ((buttons[0].getText() == ("")) | (buttons[0].getText() == marking) && 
					(buttons[4].getText() == ("")) | (buttons[4].getText() == marking) &&
					(buttons[8].getText() == ("")) | (buttons[8].getText() == marking)) ) {
				if (buttons[4].getText() == ("")) {
					buttons[4].setText(marking);
				}
				else if (buttons[0].getText() == ("")) {
					buttons[0].setText(marking);
				}
				else {
					buttons[8].setText(marking);
				}
			}
			else if ( ((buttons[2].getText() == ("")) | (buttons[2].getText() == marking) && 
					(buttons[4].getText() == ("")) | (buttons[4].getText() == marking) &&
					(buttons[6].getText() == ("")) | (buttons[6].getText() == marking)) ) {
				if (buttons[4].getText() == ("")) {
					buttons[4].setText(marking);
				}
				else if (buttons[6].getText() == ("")) {
					buttons[6].setText(marking);
				}
				else {
					buttons[2].setText(marking);
				}
			}
			else if ( ((buttons[3].getText() == ("")) | (buttons[3].getText() == marking) && 
					(buttons[4].getText() == ("")) | (buttons[4].getText() == marking) &&
					(buttons[5].getText() == ("")) | (buttons[5].getText() == marking)) ) {
				if (buttons[4].getText() == ("")) {
					buttons[4].setText(marking);
				}
				else if (buttons[3].getText() == ("")) {
					buttons[3].setText(marking);
				}
				else {
					buttons[5].setText(marking);
				}
			}
			
			else if ( ((buttons[1].getText() == ("")) | (buttons[1].getText() == marking) && 
					(buttons[4].getText() == ("")) | (buttons[4].getText() == marking) &&
					(buttons[7].getText() == ("")) | (buttons[7].getText() == marking)) ) {
				if (buttons[4].getText() == ("")) {
					buttons[4].setText(marking);
				}
				else if (buttons[1].getText() == ("")) {
					buttons[1].setText(marking);
				}
				else {
					buttons[7].setText(marking);
				}
			}
			
			else if ( ((buttons[0].getText() == ("")) | (buttons[0].getText() == marking) && 
					(buttons[1].getText() == ("")) | (buttons[1].getText() == marking) &&
					(buttons[2].getText() == ("")) | (buttons[2].getText() == marking)) ) {
				if (buttons[1].getText() == ("")) {
					buttons[1].setText(marking);
				}
				else if (buttons[2].getText() == ("")) {
					buttons[2].setText(marking);
				}
				else {
					buttons[1].setText(marking);
				}
			}
			
			else if ( ((buttons[0].getText() == ("")) | (buttons[0].getText() == marking) && 
					(buttons[3].getText() == ("")) | (buttons[3].getText() == marking) &&
					(buttons[6].getText() == ("")) | (buttons[6].getText() == marking)) ) {
				if (buttons[0].getText() == ("")) {
					buttons[0].setText(marking);
				}
				else if (buttons[6].getText() == ("")) {
					buttons[6].setText(marking);
				}
				else {
					buttons[3].setText(marking);
				}
			}
			else if ( ((buttons[6].getText() == ("")) | (buttons[6].getText() == marking) && 
					(buttons[7].getText() == ("")) | (buttons[7].getText() == marking) &&
					(buttons[8].getText() == ("")) | (buttons[8].getText() == marking)) ) {
				if (buttons[6].getText() == ("")) {
					buttons[6].setText(marking);
				}
				else if (buttons[8].getText() == ("")) {
					buttons[8].setText(marking);
				}
				else {
					buttons[7].setText(marking);
				}
			}
			
			else if ( ((buttons[2].getText() == ("")) | (buttons[2].getText() == marking) && 
					(buttons[5].getText() == ("")) | (buttons[5].getText() == marking) &&
					(buttons[8].getText() == ("")) | (buttons[8].getText() == marking)) ) {
				if (buttons[2].getText() == ("")) {
					buttons[2].setText(marking);
				}
				else if (buttons[8].getText() == ("")) {
					buttons[8].setText(marking);
				}
				else {
					buttons[5].setText(marking);
				}
			}
			
			// PLay anything to finish up the game
			else if (buttons[4].getText() == "") {
				buttons[4].setText(marking);
			} 
			else if (buttons[3].getText() == "") {
				buttons[3].setText(marking);
			}
			else if (buttons[5].getText() == "") {
				buttons[5].setText(marking);
			}
			else if (buttons[7].getText() == "") {
				buttons[7].setText(marking);
			}
			else if (buttons[1].getText() == "") {
				buttons[1].setText(marking);
			}
			else if (buttons[8].getText() == "") {
				buttons[8].setText(marking);
			}
			else if (buttons[6].getText() == "") {
				buttons[6].setText(marking);
			}
			else if (buttons[2].getText() == "") {
				buttons[2].setText(marking);
			}
			else if (buttons[0].getText() == "") {
				buttons[0].setText(marking);
			} 
			
			hasWon = didWin(false);
	
			if (hasWon) {
				System.out.println("This is working...");
				String whoWins;
				whoWins = player2Name.getText();
				player2Score++;
				player2ScoreLabel.setText(player2Score + "");
				
				JOptionPane.showMessageDialog(null,
					    "Game over!",
					    whoWins + " Wins!",
					    JOptionPane.PLAIN_MESSAGE);	
				buttons[0].setText("");
				buttons[1].setText("");
				buttons[2].setText("");
				buttons[3].setText("");
				buttons[4].setText("");
				buttons[5].setText("");
				buttons[6].setText("");
				buttons[7].setText("");
				buttons[8].setText("");
				
				frame.pack();
				frame.repaint();
				hasWon = false;
				}
		    }
		});
		t.setRepeats(false);
		t.start();
		
		
		

		frame.pack();
		frame.repaint();
		player1Turn = true;
		playerX.setForeground(Color.BLACK);
		playerO.setForeground(Color.BLUE);
	}
	
	
	
	
	void playerMakeMove(Boolean player1Turn, int thisButton) {
			
		if (player1Turn == true) {
			playerX.setForeground(Color.BLACK);
			playerO.setForeground(Color.BLUE);
			frame.pack();
			frame.repaint();
			
			buttons[thisButton].setText("X");
			
			
			hasWon = didWin(true);
			
			if (hasWon) {
				String whoWins;
				whoWins = player1Name.getText();
				player1Score++;
				player1ScoreLabel.setText(player1Score + "");
				
				JOptionPane.showMessageDialog(null,
					    "Game over!",
					    whoWins + " Wins!",
					    JOptionPane.PLAIN_MESSAGE);	
				buttons[0].setText("");
				buttons[1].setText("");
				buttons[2].setText("");
				buttons[3].setText("");
				buttons[4].setText("");
				buttons[5].setText("");
				buttons[6].setText("");
				buttons[7].setText("");
				buttons[8].setText("");
				
				frame.pack();
				frame.repaint();
				hasWon = false;
			}
			player1Turn = false;
		}
		
		else if (player1Turn == false) {
			if (pcMode.isSelected() == false) {
				playerX.setForeground(Color.BLUE);
				playerO.setForeground(Color.BLACK);
				frame.pack();
				frame.repaint();
				
				buttons[thisButton].setText("O");
			
			
				hasWon = didWin(false);
			
				if (hasWon) {
					String whoWins;
					whoWins = player2Name.getText();
					player2Score++;
					player2ScoreLabel.setText(player2Score + "");
					
					JOptionPane.showMessageDialog(null,
						    "Game over!",
						    whoWins + " Wins!",
						    JOptionPane.PLAIN_MESSAGE);	
					buttons[0].setText("");
					buttons[1].setText("");
					buttons[2].setText("");
					buttons[3].setText("");
					buttons[4].setText("");
					buttons[5].setText("");
					buttons[6].setText("");
					buttons[7].setText("");
					buttons[8].setText("");
					
					frame.pack();
					frame.repaint();
					hasWon =false;
				}
			player1Turn = true;
			}
		}
		
	 }
		 	
	
	 
	static boolean didWin(Boolean player1Turn) {
		String c = "foo";
		
		if (player1Turn == true) {
			c = "X";
		}
		else {
			c = "O";
		}
	
		
		//top
		if ((buttons[0].getText().contentEquals(c)) && 
				(buttons[1].getText().contentEquals(c)) &&
				(buttons[2].getText().contentEquals(c))) {
			hasWon = true;
		}
		//left	
		if ((buttons[0].getText().contentEquals(c)) && 
			(buttons[3].getText().contentEquals(c)) &&
			(buttons[6].getText().contentEquals(c)))   {
			hasWon = true;
		}
		//backslash	
		if ((buttons[0].getText().contentEquals(c)) && 
			(buttons[4].getText().contentEquals(c)) &&
			(buttons[8].getText().contentEquals(c)))   {
			hasWon = true;
		}
		//right	
		if ((buttons[2].getText().contentEquals(c)) && 
			(buttons[5].getText().contentEquals(c)) &&
			(buttons[8].getText().contentEquals(c))) {
			hasWon = true;
		}
		//forwardslash	
		if ((buttons[2].getText().contentEquals(c)) && 
			(buttons[4].getText().contentEquals(c)) &&
			(buttons[6].getText().contentEquals(c))) {
			hasWon = true;
		}
		//bottom	
		if ((buttons[6].getText().contentEquals(c)) && 
			(buttons[7].getText().contentEquals(c)) &&
			(buttons[8].getText().contentEquals(c))) {
			hasWon = true;
		}
		//xcenter	
		if ((buttons[3].getText().contentEquals(c)) && 
			(buttons[4].getText().contentEquals(c)) &&
			(buttons[5].getText().contentEquals(c))) {
			hasWon = true;
		}
		//ycenter
		if ((buttons[1].getText().contentEquals(c)) && 
			(buttons[4].getText().contentEquals(c)) &&
			(buttons[7].getText().contentEquals(c))) {
			hasWon = true;
		}
		
		if ( (hasWon != true) && ( 
				(buttons[0].getText().contentEquals("X") | buttons[0].getText().contentEquals("O")) &&
				(buttons[1].getText().contentEquals("X") | buttons[1].getText().contentEquals("O")) &&
				(buttons[2].getText().contentEquals("X") | buttons[2].getText().contentEquals("O")) &&
				(buttons[3].getText().contentEquals("X") | buttons[3].getText().contentEquals("O")) &&
				(buttons[4].getText().contentEquals("X") | buttons[4].getText().contentEquals("O")) &&
				(buttons[5].getText().contentEquals("X") | buttons[5].getText().contentEquals("O")) &&
				(buttons[6].getText().contentEquals("X") | buttons[6].getText().contentEquals("O")) &&
				(buttons[7].getText().contentEquals("X") | buttons[7].getText().contentEquals("O")) &&
				(buttons[8].getText().contentEquals("X") | buttons[8].getText().contentEquals("O")) 
				) ) {

			JOptionPane.showMessageDialog(null,
				    "Game over!",
				    "It's a draw!",
				    JOptionPane.PLAIN_MESSAGE);	
			
			drawScore ++;
			drawLabel.setText(drawScore + "");
			buttons[0].setText("");
			buttons[1].setText("");
			buttons[2].setText("");
			buttons[3].setText("");
			buttons[4].setText("");
			buttons[5].setText("");
			buttons[6].setText("");
			buttons[7].setText("");
			buttons[8].setText("");
			frame.pack();
			frame.repaint();
			
		}
		
		return hasWon;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final TicTacToeBoard myGame = new TicTacToeBoard();
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	myGame.createBoard();
            }
		});
	}	
}