
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.PopupMenu;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jagrut
 */
public class MancalaBoard 
{
   private int height;
   private int width; 
   private int startingStones = 4; 
   GridBagConstraints constraint = new GridBagConstraints();
   JPanel boardPanel = new JPanel();
   JLabel pitTexts;
   
   
   
   //player 1 pits
   
   CircleShape A1 = new CircleShape(100, 100, 100,startingStones);
   CircleShape A2 = new CircleShape(100, 100, 100,startingStones);
   CircleShape A3 = new CircleShape(100, 100, 100,startingStones);
   CircleShape A4 = new CircleShape(100, 100, 100,startingStones);
   CircleShape A5 = new CircleShape(100, 100, 100,startingStones);
   CircleShape A6 = new CircleShape(100, 100, 100,startingStones);
   
   
   JLabel a1 = new JLabel(A1);
   JLabel a2 = new JLabel(A2);
   JLabel a3 = new JLabel(A3);
   JLabel a4 = new JLabel(A4);
   JLabel a5 = new JLabel(A5);
   JLabel a6 = new JLabel(A6);
   
   
   //player 2 pits
   
   CircleShape B1 = new CircleShape(100, 100, 100,startingStones);
   CircleShape B2 = new CircleShape(100, 100, 100,startingStones);
   CircleShape B3 = new CircleShape(100, 100, 100,startingStones);
   CircleShape B4 = new CircleShape(100, 100, 100,startingStones);
   CircleShape B5 = new CircleShape(100, 100, 100,startingStones);
   CircleShape B6 = new CircleShape(100, 100, 100,startingStones);
   
   
   JLabel b1 = new JLabel(B1);
   JLabel b2 = new JLabel(B2);
   JLabel b3 = new JLabel(B3);
   JLabel b4 = new JLabel(B4);
   JLabel b5 = new JLabel(B5);
   JLabel b6 = new JLabel(B6);
   
   
   //player 2 mancala
   RectangleShape R1 = new RectangleShape(0, 0, 100, 100);
   RectangleShape R2 = new RectangleShape(0, 0, 100, 100);
   
   //player 1 manacala 
   RectangleShape R3 = new RectangleShape(0, 0, 100, 100);
   RectangleShape R4 = new RectangleShape(0, 0, 100, 100);
   
   
   JLabel r1 = new JLabel(R1);
   JLabel r2 = new JLabel(R2);
   JLabel r3 = new JLabel(R3);
   JLabel r4 = new JLabel(R4);
   
   BoardData bd = new BoardData();
   
   JLabel player1 = new JLabel("Player 1" + "(" + bd.pits[6] + ")");
   JLabel player2 = new JLabel("Player 2" + "(" + bd.pits[13] + ")");
   
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
   
   
   
   
   public MancalaBoard(int h, int w)
   {
      height = h;
      width = w; 
   }
   
   public void makeBoard()
   {
      
      JFrame board = new JFrame("Mancala");
      
      Object[] possibilities = {"3", "4"};
      Icon icon = new Icon() {

         @Override
         public void paintIcon(Component c, Graphics g, int x, int y) 
         {
         }

         @Override
         public int getIconWidth() 
         {
            return 0;
         }

         @Override
         public int getIconHeight() 
         {
            return 0;
         }
      };
      
      String choices = (String)JOptionPane.showInputDialog(
                    board,
                    "Choose starting numbers of stones:\n",
                    "Choose Numbers Stones",
                    JOptionPane.PLAIN_MESSAGE,
                    icon,
                    possibilities,
                    "4");
      
      if(choices.equals("3"))
      {
      	startingStones = 3;
      	
      	A1 = new CircleShape(100, 100, 100,startingStones);
         A2 = new CircleShape(100, 100, 100,startingStones);
         A3 = new CircleShape(100, 100, 100,startingStones);
         A4 = new CircleShape(100, 100, 100,startingStones);
         A5 = new CircleShape(100, 100, 100,startingStones);
         A6 = new CircleShape(100, 100, 100,startingStones);
         
         B1 = new CircleShape(100, 100, 100,startingStones);
         B2 = new CircleShape(100, 100, 100,startingStones);
         B3 = new CircleShape(100, 100, 100,startingStones);
         B4 = new CircleShape(100, 100, 100,startingStones);
         B5 = new CircleShape(100, 100, 100,startingStones);
         B6 = new CircleShape(100, 100, 100,startingStones);
         
      	
      }
      
      boardPanel.setBackground(Color.BLACK);
      boardPanel.setLayout(new GridBagLayout());
      board.setSize(width, height);
      
      setBoardData(); // setting initial board data
      
      // player 1 pits
      
      constraint.gridx = 1; 
      constraint.gridy = 1; 
       
      boardPanel.add(b6,constraint);
      
      constraint.gridx = 2; 
      constraint.gridy = 1; 
       
      boardPanel.add(b5,constraint);
      
      constraint.gridx = 3; 
      constraint.gridy = 1; 
       
      boardPanel.add(b4,constraint);
      
      constraint.gridx = 4; 
      constraint.gridy = 1; 
       
      boardPanel.add(b3,constraint);
      
      constraint.gridx = 5; 
      constraint.gridy = 1; 
       
      boardPanel.add(b2,constraint);
      
      constraint.gridx = 6; 
      constraint.gridy = 1; 
       
      boardPanel.add(b1,constraint);
    
      // player 2 pits
      
      constraint.gridx = 1; 
      constraint.gridy = 2; 
       
      boardPanel.add(a1,constraint);
      
      constraint.gridx = 2; 
      constraint.gridy = 2; 
       
      boardPanel.add(a2,constraint);
      
      constraint.gridx = 3; 
      constraint.gridy = 2; 
       
      boardPanel.add(a3,constraint);
      
      constraint.gridx = 4; 
      constraint.gridy = 2; 
       
      boardPanel.add(a4,constraint);
      
      constraint.gridx = 5; 
      constraint.gridy = 2; 
       
      boardPanel.add(a5,constraint);
      
      constraint.gridx = 6; 
      constraint.gridy = 2; 
       
      boardPanel.add(a6,constraint);
      
      //player 2 mancala
      
      constraint.gridx = 0; 
      constraint.gridy = 1; 
       
      boardPanel.add(r1,constraint);
      
      constraint.gridx = 0; 
      constraint.gridy = 2; 
      
      boardPanel.add(r2,constraint);
      
      // player 1 mancala
      
      constraint.gridx = 7; 
      constraint.gridy = 1; 
      
      boardPanel.add(r3,constraint);
      
      constraint.gridx = 7; 
      constraint.gridy = 2; 
      
      boardPanel.add(r4,constraint);
      
      //JLabel player1 = new JLabel("Player 1" + "(" + bd.pits[6] + ")");
      player1.setFont(new Font("Serif",Font.PLAIN,25));
      player1.setForeground(Color.yellow);
      //JLabel player2 = new JLabel("Player 2" + "(" + bd.pits[13] + ")");
      player2.setFont(new Font("Serif",Font.PLAIN,25));
      player2.setForeground(Color.yellow);
   
      //adding player2 label 
      constraint.gridx = 0; 
      constraint.gridy = 0; 
      boardPanel.add(player2,constraint); 
      //adding player1 label 
      constraint.gridx = 7; 
      constraint.gridy = 3; 
      boardPanel.add(player1,constraint);
      
      //player 1 texts
      A1Text.setText("A" + 1 + "(" + bd.pits[0] + ")");
      A1Text.setFont(new Font("Serif",Font.PLAIN,25));
      A1Text.setForeground(Color.YELLOW);
      constraint.gridx = 1;
      constraint.gridy = 3;
      boardPanel.add(A1Text,constraint);
      
      A2Text.setText("A" + 2 + "(" + bd.pits[1] + ")");
      A2Text.setFont(new Font("Serif",Font.PLAIN,25));
      A2Text.setForeground(Color.YELLOW);
      constraint.gridx = 2;
      constraint.gridy = 3;
      boardPanel.add(A2Text,constraint);
      
      A3Text.setText("A" + 3 + "(" + bd.pits[2] + ")");
      A3Text.setFont(new Font("Serif",Font.PLAIN,25));
      A3Text.setForeground(Color.YELLOW);
      constraint.gridx = 3;
      constraint.gridy = 3;
      boardPanel.add(A3Text,constraint);
      
      A4Text.setText("A" + 4 + "(" + bd.pits[3] + ")");
      A4Text.setFont(new Font("Serif",Font.PLAIN,25));
      A4Text.setForeground(Color.YELLOW);
      constraint.gridx = 4;
      constraint.gridy = 3;
      boardPanel.add(A4Text,constraint);
      
      A5Text.setText("A" + 5 + "(" + bd.pits[4] + ")");
      A5Text.setFont(new Font("Serif",Font.PLAIN,25));
      A5Text.setForeground(Color.YELLOW);
      constraint.gridx = 5;
      constraint.gridy = 3;
      boardPanel.add(A5Text,constraint);
      
      A6Text.setText("A" + 6 + "(" + bd.pits[5] + ")");
      A6Text.setFont(new Font("Serif",Font.PLAIN,25));
      A6Text.setForeground(Color.YELLOW);
      constraint.gridx = 6;
      constraint.gridy = 3;
      boardPanel.add(A6Text,constraint);
      
      
      /*for(int i=1; i<=6; i++)
      {
         String temp = "A" + i + "(" + bd.pits[i-1] + ")"; 
         pitTexts = new JLabel (temp);
         pitTexts.setFont(new Font("Serif",Font.PLAIN,25));
         pitTexts.setForeground(Color.YELLOW);
         constraint.gridx = i;
         constraint.gridy = 3;
         boardPanel.add(pitTexts,constraint);
      }*/
      
      //player 2 texts
      B1Text.setText("B" + 6 + "(" + bd.pits[12] + ")");
      B1Text.setFont(new Font("Serif",Font.PLAIN,25));
      B1Text.setForeground(Color.YELLOW);
      constraint.gridx = 1;
      constraint.gridy = 0;
      boardPanel.add(B1Text,constraint);
      
      B2Text.setText("B" + 5 + "(" + bd.pits[11] + ")");
      B2Text.setFont(new Font("Serif",Font.PLAIN,25));
      B2Text.setForeground(Color.YELLOW);
      constraint.gridx = 2;
      constraint.gridy = 0;
      boardPanel.add(B2Text,constraint);
      
      B3Text.setText("B" + 4 + "(" + bd.pits[10] + ")");
      B3Text.setFont(new Font("Serif",Font.PLAIN,25));
      B3Text.setForeground(Color.YELLOW);
      constraint.gridx = 3;
      constraint.gridy = 0;
      boardPanel.add(B3Text,constraint);
      
      B4Text.setText("B" + 3 + "(" + bd.pits[9] + ")");
      B4Text.setFont(new Font("Serif",Font.PLAIN,25));
      B4Text.setForeground(Color.YELLOW);
      constraint.gridx = 4;
      constraint.gridy = 0;
      boardPanel.add(B4Text,constraint);
      
      B5Text.setText("B" + 2 + "(" + bd.pits[8] + ")");
      B5Text.setFont(new Font("Serif",Font.PLAIN,25));
      B5Text.setForeground(Color.YELLOW);
      constraint.gridx = 5;
      constraint.gridy = 0;
      boardPanel.add(B5Text,constraint);
      
      B6Text.setText("B" + 1 + "(" + bd.pits[7] + ")");
      B6Text.setFont(new Font("Serif",Font.PLAIN,25));
      B6Text.setForeground(Color.YELLOW);
      constraint.gridx = 6;
      constraint.gridy = 0;
      boardPanel.add(B6Text,constraint);
      
      
      /*int counter = 1;
      for(int i=6; i>=1; i--)
      {
         String temp = "B" + i + "(" + bd.pits[i-1] + ")"; 
         pitTexts = new JLabel (temp);
         pitTexts.setFont(new Font("Serif",Font.PLAIN,25));
         pitTexts.setForeground(Color.YELLOW);
         constraint.gridx = counter;
         constraint.gridy = 0;
         boardPanel.add(pitTexts,constraint);
         counter++;
      }*/
      
      board.add(boardPanel);
      
      
      
      
      // Listeners for player 1 pits
      a1.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				//System.out.println("Stones in a1: " + A1.getStones());
				
				int temp = bd.pits[0];
				
				if(temp > 0)
				{
					bd.pits[0] = 0;
					moveStones(temp, 0);
			      A1.setStones(0);
			      //repaintBoard();
				}
			}
		});
      
      a2.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				//System.out.println("Stones in a2: " + A2.getStones());
				
				int temp = bd.pits[1];
				
				if(temp > 0)
				{
					bd.pits[1] = 0;
					moveStones(temp, 1);
					A2.setStones(0);
			      //repaintBoard();
				}
			}
		});
      
      a3.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				//System.out.println("Stones in a3: " + A3.getStones());
				
				int temp = bd.pits[2];
				
				if(temp > 0)
				{
					bd.pits[2] = 0;
					moveStones(temp, 2);
			      A3.setStones(0);
			      //repaintBoard();
				}
			}
		});
      
      a4.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				//System.out.println("Stones in a4: " + A4.getStones());
				
				int temp = bd.pits[3];
				
				if(temp > 0)
				{
					bd.pits[3] = 0;
					moveStones(temp, 3);
			      A4.setStones(0);
			      //repaintBoard();
				}
			}
		});
      
      a5.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				//System.out.println("Stones in a5: " + A5.getStones());
				
				int temp = bd.pits[4];
				
				if(temp > 0)
				{
					bd.pits[4] = 0;
					moveStones(temp, 4);
			      A5.setStones(0);
			      //repaintBoard();
				}
			}
		});
      
      a6.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				//System.out.println("Stones in a6: " + A6.getStones());
				
				int temp = bd.pits[5];
				
				if(temp > 0)
				{
					bd.pits[5] = 0;
					moveStones(temp, 5);
			      A6.setStones(0);
			      //repaintBoard();
				}
			}
		});

      
      // Listeners for player 2 pits
      b6.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
				int temp = bd.pits[12];
				
				if(temp > 0)
				{
					bd.pits[12] = 0;
					moveStones(temp, 12);
			      B6.setStones(0);
			      //repaintBoard();
				}
				
			}
		});
      
      b5.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
				int temp = bd.pits[11];
				
				if(temp > 0)
				{
					bd.pits[11] = 0;
					moveStones(temp, 11);
			      B5.setStones(0);
			      //repaintBoard();
				}
				
			}
		});
      
      b4.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
				int temp = bd.pits[10];
				
				if(temp > 0)
				{
					bd.pits[10] = 0;
					moveStones(temp, 10);
			      B4.setStones(0);
			      //repaintBoard();
				}
				
			}
		});
      
      b3.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
				int temp = bd.pits[9];
				
				if(temp > 0)
				{
					bd.pits[9] = 0;
					moveStones(temp, 9);
			      B3.setStones(0);
			      //repaintBoard();
				}
				
			}
		});
      
      b2.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
				int temp = bd.pits[8];
				
				if(temp > 0)
				{
					bd.pits[8] = 0;
					moveStones(temp, 8);
			      B2.setStones(0);
			      //repaintBoard();
				}
				
			}
		});
      
      b1.addMouseListener(new MouseListener()
		{
			
			@Override
			public void mouseReleased(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e)
			{
				// TODO Auto-generated method stub
				
				int temp = bd.pits[7];
				
				if(temp > 0)
				{
					bd.pits[7] = 0;
					moveStones(temp, 7);
			      B1.setStones(0);
			      //repaintBoard();
				}
				
			}
		});
      
      
      
      
      
      System.out.println();
      printArray(bd.pits);
      System.out.println();
      
      board.setVisible(true);
      //board.pack();
      board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
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
   
   public void setBoardData()
   {
   	bd.pits[0] = A1.getStones();	// player1 6pits
      bd.pits[1] = A2.getStones();
      bd.pits[2] = A3.getStones();
      bd.pits[3] = A4.getStones();
      bd.pits[4] = A5.getStones();
      bd.pits[5] = A6.getStones();
      
      bd.pits[6] = R4.getStones();	// player1 mancala
      
      bd.pits[7] = B1.getStones();	// player2 6pits
      bd.pits[8] = B2.getStones();
      bd.pits[9] = B3.getStones();
      bd.pits[10] = B4.getStones();
      bd.pits[11] = B5.getStones();
      bd.pits[12] = B6.getStones();
      
      bd.pits[13] = R1.getStones(); // player2 mancala
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
   	//System.out.println();
   	//System.out.println(numOfStones);
   	//System.out.println(startPit);
   	//System.out.println();
      //printArray(bd.pits);
      //System.out.println();
   	
   	boolean p1 = false;
   	boolean p2 = false;
   	
   	if(startPit >= 0 && startPit <=5)
   	{
   		p1 = true;
   	}
   	else if (startPit >=7 && startPit <=12)
   	{
   		p2 = true;
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
   	
   	setCircleData();
   	repaintBoard();
   	updateText();
   	
   	//System.out.println();
      //printArray(bd.pits);
      //System.out.println();
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
   
   public static void printArray(int[] p)					// Method to print an Array
   {
	   for (int x: p){ System.out.print(x + " "); }	
   }
}