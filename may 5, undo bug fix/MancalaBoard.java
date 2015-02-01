
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.PopupMenu;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

// 5/2 remove setboarddata method and move it to BoardData class, fix undo bug.
public class MancalaBoard 
{
	boolean freeTurnFlag = false; // to fix undo bug
	boolean player2Turn = false;//keep track of turn after undo button is hit.
	boolean player1Turn = false;//keep track of turn after undo button is hit.
	boolean undoFlag1 = false;  // make sure each player can only hit undo once.
	boolean undoFlag2 = false; // make sure each player can only hit undo once.
	private int height;
	private int width; 
	private int startingStones = 4; 
	GridBagConstraints constraint = new GridBagConstraints();
	JPanel boardPanel = new JPanel();
	JPanel pitsPanel = new JPanel();
	JPanel mancalaPanel1 = new JPanel();
	JPanel mancalaPanel2 = new JPanel();
	BoardTheme myTheme;

	//JLabel pitTexts;

	JLabel notifyText = new JLabel("Welcome! Player 1: Turn", SwingConstants.CENTER);
	String notifytextbackup; 
	boolean p1 = true;
	boolean p2 = false;

	int p1undo = 3;
	int p2undo = 3; 
	JButton undobtn = new JButton("UNDO");
	boolean gameBegin = true;		

	//player 1 pits
	pitIcon A1, A2, A3, A4, A5, A6;
	pitIcon[] player1Pit = {A1, A2, A3, A4, A5, A6};

	JLabel a1, a2, a3, a4, a5, a6;

	//player 2 pits
	pitIcon B1, B2, B3, B4, B5, B6;
	JLabel b1,b2, b3,b4, b5, b6;

	RectangleShape R1 = new RectangleShape(0, 0, 230, 100);	// player 1 mancala
	RectangleShape R4 = new RectangleShape(0, 0, 230, 100);	// player 2 mancala
	JLabel r1 = new JLabel(R1);
	JLabel r4 = new JLabel(R4);

	BoardData bd; //declare data.

	JLabel player1; 
	JLabel player2; 

	JLabel A1Text = new JLabel();
	JLabel A2Text = new JLabel();
	JLabel A3Text = new JLabel();
	JLabel A4Text = new JLabel();
	JLabel A5Text = new JLabel();
	JLabel A6Text = new JLabel();

	JLabel B1Text = new JLabel();
	JLabel B2Text = new JLabel();
	JLabel B3Text = new JLabel();
	JLabel B4Text = new JLabel();
	JLabel B5Text = new JLabel();
	JLabel B6Text = new JLabel();

	public MancalaBoard(int h, int w, BoardData data)
	{
		bd = data;
		height = h;
		width = w; 

		Object[] options = {"Fancy Theme",
				"Default Theme"
		};

		int n = JOptionPane.showOptionDialog(null,
				"Please choose your theme ",
				"Theme",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]);

		if(n == 1)
			this.makeBoard(new DefaultTheme());
		else
		{
			this.makeBoard(new FancyTheme());
		}
	}

	public void makeBoard(BoardTheme abc)
	{
		myTheme = abc;
		JFrame board = new JFrame("Mancala");

		//add undo button.
		board.add(undobtn, BorderLayout.NORTH);

		//add label on top of both players' macala.
		player2 = new JLabel("Player 2" + "(" + bd.pits[13] + ")");
		player1= new JLabel("Player 1" + "(" + bd.pits[6] + ")");

		// ask  user user for number of stating stones.
		Object[] options = {"3 Stones",	"4 Stones"};
		int n = JOptionPane.showOptionDialog(null,
				"Please choose number of stones ",
				"Number Of Stone",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE,
				null,
				options,
				options[1]);

		if(n == 0)
		{
			startingStones = 3;
		}

		else
		{
			startingStones = 4;
		}

		// declare player 1 and 2 pits.
		A1 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(), myTheme.getMancalaColor());
		A2 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(),myTheme.getMancalaColor());
		A3 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(),myTheme.getMancalaColor());
		A4 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(),myTheme.getMancalaColor());
		A5 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(),myTheme.getMancalaColor());
		A6 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(), myTheme.getMancalaColor());

		B1 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(), myTheme.getMancalaColor());
		B2 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(),myTheme.getMancalaColor());
		B3 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(),myTheme.getMancalaColor());
		B4 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(),myTheme.getMancalaColor());
		B5 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(),myTheme.getMancalaColor());
		B6 = new pitIcon(100, 100, 100, startingStones, (Shape)myTheme.myShape(), myTheme.getPitColor(), myTheme.getMancalaColor());

		a1 = new JLabel(A1);
		a2 = new JLabel(A2);
		a3 = new JLabel(A3);
		a4 = new JLabel(A4);
		a5 = new JLabel(A5);
		a6 = new JLabel(A6);

		b1 = new JLabel(B1);
		b2 = new JLabel(B2);
		b3 = new JLabel(B3);
		b4 = new JLabel(B4);
		b5 = new JLabel(B5);
		b6 = new JLabel(B6);

		pitsPanel.setBackground(Color.BLACK);
		pitsPanel.setLayout(new GridBagLayout());

		board.setSize(width, height);

		undobtn.setFont(new Font("Serif",Font.PLAIN,25));

		bd.setIntialStones(startingStones); // setting initial board data array

		// player 2 pits
		constraint.gridx = 0; 
		constraint.gridy = 1; 

		pitsPanel.add(b6,constraint);	// B6 pit

		constraint.gridx = 1; 
		constraint.gridy = 1; 

		pitsPanel.add(b5,constraint);	// B5 pit

		constraint.gridx = 2; 
		constraint.gridy = 1; 

		pitsPanel.add(b4,constraint);	// B4 pit

		constraint.gridx = 3; 
		constraint.gridy = 1; 

		pitsPanel.add(b3,constraint);	// B3 pit

		constraint.gridx = 4; 
		constraint.gridy = 1; 

		pitsPanel.add(b2,constraint);	// B2 pit

		constraint.gridx = 5; 
		constraint.gridy = 1; 

		pitsPanel.add(b1,constraint);	// B1 pit

		// player 1 pits

		constraint.gridx = 0; 
		constraint.gridy = 2; 

		pitsPanel.add(a1,constraint);	// A1 pit

		constraint.gridx = 1; 
		constraint.gridy = 2; 

		pitsPanel.add(a2,constraint);	// A2 pit

		constraint.gridx = 2; 
		constraint.gridy = 2; 

		pitsPanel.add(a3,constraint);	// A3 pit

		constraint.gridx = 3; 
		constraint.gridy = 2; 

		pitsPanel.add(a4,constraint);	// A4 pit

		constraint.gridx = 4; 
		constraint.gridy = 2; 

		pitsPanel.add(a5,constraint);	// A5 pit

		constraint.gridx = 5; 
		constraint.gridy = 2; 

		pitsPanel.add(a6,constraint);	// A6 pit


		mancalaPanel1.setBackground(Color.BLACK);	// player 1 mancala's frame background color
		mancalaPanel2.setBackground(Color.BLACK);	// player 2 mancala's frame background color

		//player 1 mancala

		mancalaPanel1.setLayout(new GridBagLayout());
		mancalaPanel1.setPreferredSize(new Dimension(120, 270));

		player1.setFont(new Font("Serif",Font.PLAIN,25));
		player1.setForeground(Color.yellow);

		constraint.gridx = 0; 
		constraint.gridy = 0;
		mancalaPanel1.add(player1, constraint);	// player 1 text

		constraint.gridx = 0; 
		constraint.gridy = 1;
		mancalaPanel1.add(r4, constraint);			// player 1 mancala


		mancalaPanel2.setLayout(new GridBagLayout());
		mancalaPanel2.setPreferredSize(new Dimension(120, 270));

		player2.setFont(new Font("Serif",Font.PLAIN,25));
		player2.setForeground(Color.yellow);

		constraint.gridx = 0; 
		constraint.gridy = 0;
		mancalaPanel2.add(player2, constraint);	// player 2 text

		constraint.gridx = 0; 
		constraint.gridy = 1; 
		mancalaPanel2.add(r1, constraint);			// player 2 mancala

		//player 1 texts
		A1Text.setText("A" + 1 + "(" + bd.pits[0] + ")");
		A1Text.setFont(new Font("Serif",Font.PLAIN,25));
		A1Text.setForeground(Color.YELLOW);
		constraint.gridx = 0;
		constraint.gridy = 3;
		pitsPanel.add(A1Text,constraint);

		A2Text.setText("A" + 2 + "(" + bd.pits[1] + ")");
		A2Text.setFont(new Font("Serif",Font.PLAIN,25));
		A2Text.setForeground(Color.YELLOW);
		constraint.gridx = 1;
		constraint.gridy = 3;
		pitsPanel.add(A2Text,constraint);

		A3Text.setText("A" + 3 + "(" + bd.pits[2] + ")");
		A3Text.setFont(new Font("Serif",Font.PLAIN,25));
		A3Text.setForeground(Color.YELLOW);
		constraint.gridx = 2;
		constraint.gridy = 3;
		pitsPanel.add(A3Text,constraint);

		A4Text.setText("A" + 4 + "(" + bd.pits[3] + ")");
		A4Text.setFont(new Font("Serif",Font.PLAIN,25));
		A4Text.setForeground(Color.YELLOW);
		constraint.gridx = 3;
		constraint.gridy = 3;
		pitsPanel.add(A4Text,constraint);

		A5Text.setText("A" + 5 + "(" + bd.pits[4] + ")");
		A5Text.setFont(new Font("Serif",Font.PLAIN,25));
		A5Text.setForeground(Color.YELLOW);
		constraint.gridx = 4;
		constraint.gridy = 3;
		pitsPanel.add(A5Text,constraint);

		A6Text.setText("A" + 6 + "(" + bd.pits[5] + ")");
		A6Text.setFont(new Font("Serif",Font.PLAIN,25));
		A6Text.setForeground(Color.YELLOW);
		constraint.gridx = 5;
		constraint.gridy = 3;
		pitsPanel.add(A6Text,constraint);


		//player 2 texts
		B1Text.setText("B" + 6 + "(" + bd.pits[12] + ")");
		B1Text.setFont(new Font("Serif",Font.PLAIN,25));
		B1Text.setForeground(Color.YELLOW);
		constraint.gridx = 0;
		constraint.gridy = 0;
		pitsPanel.add(B1Text,constraint);

		B2Text.setText("B" + 5 + "(" + bd.pits[11] + ")");
		B2Text.setFont(new Font("Serif",Font.PLAIN,25));
		B2Text.setForeground(Color.YELLOW);
		constraint.gridx = 1;
		constraint.gridy = 0;
		pitsPanel.add(B2Text,constraint);

		B3Text.setText("B" + 4 + "(" + bd.pits[10] + ")");
		B3Text.setFont(new Font("Serif",Font.PLAIN,25));
		B3Text.setForeground(Color.YELLOW);
		constraint.gridx = 2;
		constraint.gridy = 0;
		pitsPanel.add(B3Text,constraint);

		B4Text.setText("B" + 3 + "(" + bd.pits[9] + ")");
		B4Text.setFont(new Font("Serif",Font.PLAIN,25));
		B4Text.setForeground(Color.YELLOW);
		constraint.gridx = 3;
		constraint.gridy = 0;
		pitsPanel.add(B4Text,constraint);

		B5Text.setText("B" + 2 + "(" + bd.pits[8] + ")");
		B5Text.setFont(new Font("Serif",Font.PLAIN,25));
		B5Text.setForeground(Color.YELLOW);
		constraint.gridx = 4;
		constraint.gridy = 0;
		pitsPanel.add(B5Text,constraint);

		B6Text.setText("B" + 1 + "(" + bd.pits[7] + ")");
		B6Text.setFont(new Font("Serif",Font.PLAIN,25));
		B6Text.setForeground(Color.YELLOW);
		constraint.gridx = 5;
		constraint.gridy = 0;
		pitsPanel.add(B6Text,constraint);


		boardPanel.add(mancalaPanel2, BorderLayout.WEST);	// adding player 2 mancala on left side
		boardPanel.add(pitsPanel, BorderLayout.CENTER);		// adding pits panel in the center
		boardPanel.add(mancalaPanel1, BorderLayout.EAST);	// adding player 1 mancala on right side

		boardPanel.setBackground(Color.BLACK);

		board.add(boardPanel);


		notifyText.setFont(new Font("Serif",Font.PLAIN,25));
		board.add(notifyText, BorderLayout.SOUTH);


		//add mouse listener to undo button.
		undobtn.addMouseListener(new MouseAdapter()
		{	
			@Override
			public void mouseClicked(MouseEvent e)
			{
				
				boolean done = false;

				if(undoFlag2 || undoFlag1)
				{
					JOptionPane.showMessageDialog(null, "You can only undo once per turn");
				}
				
				if(freeTurnFlag) //this is to fix undo bug.
				{
					changeTurn();
					freeTurnFlag = false;
				}

				if(p1 && !gameBegin && !undoFlag2 && !player1Turn )
				{
					System.out.println("p2undo");
					if(p2undo > 0)
					{
						for(int i=0; i < 14; i++)
						{
							bd.pits[i] = bd.pitsbackup[i];
						}
						notifyText.setText(notifytextbackup);
						setCircleData();
						repaintBoard();
						updateText();
						p2undo--;
						changeTurn();
						done = true;
						undoFlag2 = true;
						player2Turn = true;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Player 2: You have ran out of undo");
					}
				}

				if(p2 && !gameBegin && !done && !undoFlag1 && !player2Turn)
				{
					System.out.println("p1undo");
					if(p1undo > 0)
					{
						for(int i=0; i < 14; i++)
						{
							bd.pits[i] = bd.pitsbackup[i];
						}
						//bd.pits = bd.pitsbackup;
						notifyText.setText(notifytextbackup);

						setCircleData();
						repaintBoard();
						updateText();
						p1undo--;
						changeTurn();
						undoFlag1 = true;
						player1Turn = true;
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Player 1: You have ran out of undo");
					}
				}
			}


		});

		// Listeners for player 1 pits
		a1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				//System.out.println("Stones in a1: " + A1.getStones());

				int temp = bd.pits[0];

				if(temp > 0 && p1)
				{
					player1Turn = false;
					undoFlag2 = false;
					moveStones(temp, 0);
					bd.pits[0] = 0;
					A1.setStones(0);

					bd.notifyChange();
				}
			}
		});

		a2.addMouseListener(new MouseAdapter()
		{
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				//System.out.println("Stones in a2: " + A2.getStones());

				int temp = bd.pits[1];

				if(temp > 0 && p1)
				{
					player1Turn = false;
					undoFlag2 = false;
					moveStones(temp, 1);
					bd.pits[1] = 0;
					A2.setStones(0);

					bd.notifyChange();
				}
			}
		});

		a3.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				//System.out.println("Stones in a3: " + A3.getStones());

				int temp = bd.pits[2];

				if(temp > 0 && p1)
				{
					player1Turn = false;
					undoFlag2 = false;
					moveStones(temp, 2);
					bd.pits[2] = 0;
					A3.setStones(0);

					bd.notifyChange();
				}
			}
		});

		a4.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				//System.out.println("Stones in a4: " + A4.getStones());

				int temp = bd.pits[3];

				if(temp > 0 && p1)
				{
					player1Turn = false;
					undoFlag2 = false;
					moveStones(temp, 3);
					bd.pits[3] = 0;
					A4.setStones(0);

					bd.notifyChange();
				}
			}
		});

		a5.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				//System.out.println("Stones in a5: " + A5.getStones());

				int temp = bd.pits[4];

				if(temp > 0 && p1)
				{
					player1Turn = false;
					undoFlag2 = false;
					moveStones(temp, 4);
					bd.pits[4] = 0;
					A5.setStones(0);

					bd.notifyChange();
				}
			}
		});

		a6.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				//System.out.println("Stones in a6: " + A6.getStones());

				int temp = bd.pits[5];

				if(temp > 0 && p1)
				{
					player1Turn = false;
					undoFlag2 = false;
					moveStones(temp, 5);
					bd.pits[5] = 0;
					A6.setStones(0);

					bd.notifyChange();
				}
			}
		});

		// Listeners for player 2 pits
		b6.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub

				int temp = bd.pits[12];

				if(temp > 0 && p2)
				{
					player2Turn = false;
					undoFlag1 = false;
					moveStones(temp, 12);
					bd.pits[12] = 0;
					B6.setStones(0);

					bd.notifyChange();
				}
			}
		});

		b5.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub

				int temp = bd.pits[11];

				if(temp > 0 && p2)
				{
					player2Turn = false;
					undoFlag1 = false;
					moveStones(temp, 11);
					bd.pits[11] = 0;
					B5.setStones(0);

					bd.notifyChange();
				}

			}
		});

		b4.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub

				int temp = bd.pits[10];

				if(temp > 0 && p2)
				{
					player2Turn = false;
					undoFlag1 = false;
					moveStones(temp, 10);
					bd.pits[10] = 0;
					B4.setStones(0);

					bd.notifyChange();
				}

			}
		});

		b3.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub

				int temp = bd.pits[9];

				if(temp > 0 && p2)
				{
					player2Turn = false;
					undoFlag1 = false;
					moveStones(temp, 9);
					bd.pits[9] = 0;
					B3.setStones(0);

					bd.notifyChange();
				}

			}
		});

		b2.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub

				int temp = bd.pits[8];

				if(temp > 0 && p2)
				{
					player2Turn = false;
					undoFlag1 = false;
					moveStones(temp, 8);
					bd.pits[8] = 0;
					B2.setStones(0);

					bd.notifyChange();
				}
			}
		});

		b1.addMouseListener(new MouseAdapter()
		{
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub

				int temp = bd.pits[7];

				if(temp > 0 && p2)
				{
					player2Turn = false;
					undoFlag1 = false;
					moveStones(temp, 7);
					bd.pits[7] = 0;
					B1.setStones(0);

					bd.notifyChange();
				}

			}
		});

		board.setResizable(false);
		board.setVisible(true);
		board.pack();
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
	}

	public void notifyChange()
	{
		whoIsWinner();
		setCircleData();
		repaintBoard();
		updateText();
	}


	public void repaintBoard()
	{
		a1.repaint();
		a2.repaint();
		a3.repaint();
		a4.repaint();
		a5.repaint();
		a6.repaint();

		b1.repaint();
		b2.repaint();
		b3.repaint();
		b4.repaint();
		b5.repaint();
		b6.repaint();

		r1.repaint();
		r4.repaint();

	}

	public void setCircleData()
	{
		A1.setStones(bd.pits[0]);	
		A2.setStones(bd.pits[1]);	
		A3.setStones(bd.pits[2]);	
		A4.setStones(bd.pits[3]);	
		A5.setStones(bd.pits[4]);	
		A6.setStones(bd.pits[5]);	
		R4.setStones(bd.pits[6]);
		B1.setStones(bd.pits[7]);	
		B2.setStones(bd.pits[8]);	
		B3.setStones(bd.pits[9]);	
		B4.setStones(bd.pits[10]);	
		B5.setStones(bd.pits[11]);
		B6.setStones(bd.pits[12]);
		R1.setStones(bd.pits[13]);      
	}

	public void getBoardData()
	{
		/*for(int i = 0; i < player1Pit.length; i++)
		{
			player1Pit[i].setStones(bd.pits[i]);
		}*/
		A1.setStones(bd.pits[0]);	// player1 6pits
		A2.setStones(bd.pits[1]);
		A3.setStones(bd.pits[2]);
		A4.setStones(bd.pits[3]);
		A5.setStones(bd.pits[4]);
		A6.setStones(bd.pits[5]);

		R4.setStones(bd.pits[6]);	// player1 mancala

		B1.setStones(bd.pits[6]);	// player2 6pits
		B2.setStones(bd.pits[7]);
		B3.setStones(bd.pits[8]);
		B4.setStones(bd.pits[9]);
		B5.setStones(bd.pits[10]);
		B6.setStones(bd.pits[11]);

		R1.setStones(bd.pits[13]);	// player2 mancala
	}

	public void moveStones(int numOfStones, int startPit)
	{

		gameBegin = false;
		notifytextbackup = notifyText.getText(); 
		for(int i=0; i < 14; i++)
		{
			bd.pitsbackup[i] = bd.pits[i];
		}

		while(numOfStones != 0)
		{
			if(startPit < 13)
			{
				startPit++;
			}
			else
			{
				startPit = 0;
				//again = true;
			}

			if(p1)
			{
				if(startPit != 13)
				{
					bd.pits[startPit] = bd.pits[startPit] + 1;
					numOfStones--;
				}
			}
			else if(p2)
			{
				if(startPit != 6)
				{
					bd.pits[startPit] = bd.pits[startPit] + 1;
					numOfStones--;
				}
			}
		}



		if(bd.pits[startPit] ==  1)
		{
			if(p1 && startPit>=0 && startPit<=5)
			{
				int p1pit = bd.pits[startPit];
				int p2pit = bd.pits[12-startPit]; 
				bd.pits[startPit] = 0; 
				bd.pits[12-startPit] = 0; 
				bd.pits[6]= bd.pits[6]+p1pit+p2pit;

			}
			else if(p2 && startPit>=7 && startPit<=12)
			{
				int p2pit = bd.pits[startPit];
				int p1pit = bd.pits[12-startPit]; 
				bd.pits[startPit] = 0; 
				bd.pits[12-startPit] = 0; 
				bd.pits[13]= bd.pits[13]+p1pit+p2pit;
			}
		}

		if(p1)
		{
			if(startPit == 6)
			{
				notifyText.setText("Player 1: Free Turn");
				freeTurnFlag = true;
		
			}
			else
			{
				changeTurn();
				notifyText.setText("Player 2: Turn");
			}
		}
		else if (p2)
		{
			if(startPit == 13)
			{
				notifyText.setText("Player 2: Free Turn");
				freeTurnFlag = true;
		
			}
			else
			{
				changeTurn();
				notifyText.setText("Player 1: Turn");
			}
		}
	}

	public void whoIsWinner()
	{	
		int p1PitsTotal = 0;
		int p2PitsTotal = 0;

		for(int i=0; i <= 5; i++)
		{
			p1PitsTotal = p1PitsTotal + bd.pits[i];
		}

		for(int i=7; i <= 12; i++)
		{
			p2PitsTotal = p2PitsTotal + bd.pits[i];
		}

		if(p1PitsTotal == 0)
		{
			bd.pits[13] = bd.pits[13] + p2PitsTotal;

			bd.pits[7] = 0;
			bd.pits[8] = 0;
			bd.pits[9] = 0;
			bd.pits[10] = 0;
			bd.pits[11] = 0;
			bd.pits[12] = 0;

			if(bd.pits[6] == bd.pits[13])
			{
				notifyText.setText("Tie Game. No one Win the game!");
			}
			else if(bd.pits[6] > bd.pits[13])
			{
				notifyText.setText("Player 1 Wins");
			}
			else if(bd.pits[6] < bd.pits[13])
			{
				notifyText.setText("Player 2 Wins");
			}
		}
		else if(p2PitsTotal == 0)
		{
			bd.pits[6] = bd.pits[6] + p1PitsTotal;

			bd.pits[0] = 0;
			bd.pits[1] = 0;
			bd.pits[2] = 0;
			bd.pits[3] = 0;
			bd.pits[4] = 0;
			bd.pits[5] = 0;

			if(bd.pits[6] == bd.pits[13])
			{
				notifyText.setText("Tie Game. No one Win the game!");
			}
			else if(bd.pits[6] > bd.pits[13])
			{
				notifyText.setText("Player 1 Wins");
			}
			else if(bd.pits[6] < bd.pits[13])
			{
				notifyText.setText("Player 2 Wins");
			}
		}
	}


	public void updateText()
	{
		A1Text.setText("A" + 1 + "(" + bd.pits[0] + ")");
		A2Text.setText("A" + 2 + "(" + bd.pits[1] + ")");
		A3Text.setText("A" + 3 + "(" + bd.pits[2] + ")");
		A4Text.setText("A" + 4 + "(" + bd.pits[3] + ")");
		A5Text.setText("A" + 5 + "(" + bd.pits[4] + ")");
		A6Text.setText("A" + 6 + "(" + bd.pits[5] + ")");

		player1.setText("Player 1" + "(" + bd.pits[6] + ")");

		B6Text.setText("B" + 1 + "(" + bd.pits[7] + ")");
		B5Text.setText("B" + 2 + "(" + bd.pits[8] + ")");
		B4Text.setText("B" + 3 + "(" + bd.pits[9] + ")");
		B3Text.setText("B" + 4 + "(" + bd.pits[10] + ")");
		B2Text.setText("B" + 5 + "(" + bd.pits[11] + ")");
		B1Text.setText("B" + 6 + "(" + bd.pits[12] + ")");

		player2.setText("Player 2" + "(" + bd.pits[13] + ")");

	}

	public void changeTurn()
	{
		if(p1)
		{
			p2 = true;
			p1 = false;
		}
		else if(p2)
		{
			p1 = true;
			p2 = false;
		}
	}

	public static void printArray(int[] p)					// Method to print an Array
	{
		for (int x: p){ System.out.print(x + " "); }	
	}

	private class pitIcon implements Icon
	{
		int radius; 
		int   height ; 
		int  width  ;  
		int   startingStones;
		Shape myShape;
		Color myBoardColor;
		Color mancalaColor;

		public pitIcon(int x, int y, int z, int stone,Shape myShape,Color myBoardColor, Color mancalaColor)
		{
			radius = x; 
			height = y; 
			width  = z;  
			startingStones = stone; 
			this.myShape = myShape;
			this.myBoardColor = myBoardColor;
			this.mancalaColor = mancalaColor;
		}

		public int getStones() 
		{
			return startingStones;
		}


		public void setStones(int i)
		{
			startingStones = i;
		}

		@Override
		public void paintIcon(Component c, Graphics g, int x, int y)
		{
			Graphics2D draw = (Graphics2D) g;
			Shape circle = myShape;
			draw.setColor(myBoardColor);
			draw.fill(circle);
			int random = -30 + (int)(Math.random() * ((20 - (-30)) + 1));
			Random randoming = new Random(); 

			for(int i=0; i<startingStones; i++)
			{
				int red = randoming.nextInt(255); 
				int green = randoming.nextInt(255); 
				int blue = randoming.nextInt(255); 

				Color randomColor = new Color(red, green, blue); 
				Ellipse2D.Double tempCircle = new Ellipse2D.Double 
						(circle.getBounds().getX()+(10+Math.random()*50),circle.getBounds().getY()+(10+Math.random()*50),radius/6,radius/6);
				if(randomColor.equals(Color.YELLOW))
				{
					randomColor = Color.RED;
				}
				draw.setColor(randomColor);
				draw.fill(tempCircle);
				random = -30 + (int)(Math.random() * ((20 - (-30)) + 1));
			}
		}

		@Override
		public int getIconWidth() 
		{
			return width;
		}

		@Override
		public int getIconHeight() 
		{
			// TODO Auto-generated method stub
			return height;
		}
	}

	private class RectangleShape implements Icon
	{
		private int size;
		int x,y;
		private int height;
		private int width;
		Color color = Color.YELLOW;
		private int startingStones;
		private int radius=100;

		// Constructor
		public RectangleShape()
		{
			size = 0;
			width = 0;
			height = 0;
			startingStones = 0;
		}

		/**
		 * Sets radius, width and height Constructor.
		 * 
		 * @param radii
		 * @param x
		 * @param y
		 */
		public RectangleShape(int x, int y, int height, int width)
		{
			this.x = x; 
			this.y = y;
			this.height = height; 
			this.width =  width; 
		}

		/**
		 * Sets color.
		 * 
		 * @param m
		 */
		/*public void changeTheColorTo(Color m)
		{
			this.color = m;
		}*/

		/**
		 * Gets size.
		 * 
		 * @return size
		 */
		public int getSize()
		{
			return size;
		}

		/**
		 * PaintIcon method
		 * 
		 * @param c
		 * @param g
		 * @param w
		 * @param h
		 */
		public void paintIcon(Component c, Graphics g, int w, int h)
		{
			Graphics2D g2 = (Graphics2D) g;
			Rectangle2D.Double e = new Rectangle2D.Double(x,y,width,height);
			g2.setColor(this.color);
			g2.fill(e);



			Graphics2D draw = (Graphics2D) g;
			Ellipse2D.Double circle = new Ellipse2D.Double (x,y,radius,radius);

			int random = -30 + (int)(Math.random() * ((20 - (-30)) + 1));
			Random randoming = new Random(); 

			for(int i=0; i<startingStones; i++)
			{

				int red = randoming.nextInt(255); 
				int green = randoming.nextInt(255); 
				int blue = randoming.nextInt(255); 

				Color randomColor = new Color(red, green, blue); 
				Ellipse2D.Double tempCircle = new Ellipse2D.Double 
						(circle.getCenterX()+random,circle.getCenterY()+random,radius/6,radius/6);
				if(randomColor.equals(Color.YELLOW))
				{
					randomColor = Color.RED;
				}
				draw.setColor(randomColor);
				draw.fill(tempCircle);
				random = -30 + (int)(Math.random() * ((20 - (-30)) + 1));
			}	
		}

		@Override
		/**
		 * Gets Icon Height.
		 * 
		 * @return height
		 */
		public int getIconHeight()
		{
			// TODO Auto-generated method stub
			return height;
		}

		@Override
		/**
		 * Gets Icon Width.
		 * 
		 * @return width
		 */
		public int getIconWidth()
		{
			// TODO Auto-generated method stub
			return width;
		}

		public int getStones()
		{
			return startingStones;
		}

		public void setStones(int x)
		{
			startingStones = x;
		}
	}
}