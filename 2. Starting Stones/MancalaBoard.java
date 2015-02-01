
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.PopupMenu;
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
      }
      GridBagConstraints constraint = new GridBagConstraints();
      JPanel boardPanel = new JPanel(); 
      boardPanel.setBackground(Color.GRAY);
      boardPanel.setLayout(new GridBagLayout());
      board.setSize(width, height);
      //player 1 pits
      CircleShape A1 = new CircleShape(100, 100, 100,startingStones);
      CircleShape A2 = new CircleShape(100, 100, 100,startingStones);
      CircleShape A3 = new CircleShape(100, 100, 100,startingStones);
      CircleShape A4 = new CircleShape(100, 100, 100,startingStones);
      CircleShape A5 = new CircleShape(100, 100, 100,startingStones);
      CircleShape A6 = new CircleShape(100, 100, 100,startingStones);
      
      constraint.gridx = 1; 
      constraint.gridy = 1; 
      JLabel a1 = new JLabel(A1); 
      boardPanel.add(a1,constraint);
      
      constraint.gridx = 2; 
      constraint.gridy = 1; 
      JLabel a2 = new JLabel(A2); 
      boardPanel.add(a2,constraint);
      
      constraint.gridx = 3; 
      constraint.gridy = 1; 
      JLabel a3 = new JLabel(A3); 
      boardPanel.add(a3,constraint);
      
      constraint.gridx = 4; 
      constraint.gridy = 1; 
      JLabel a4 = new JLabel(A4); 
      boardPanel.add(a4,constraint);
      
      constraint.gridx = 5; 
      constraint.gridy = 1; 
      JLabel a5 = new JLabel(A5); 
      boardPanel.add(a5,constraint);
      
      constraint.gridx = 6; 
      constraint.gridy = 1; 
      JLabel a6 = new JLabel(A6); 
      boardPanel.add(a6,constraint);

      //player 2 pits
      CircleShape B1 = new CircleShape(100, 100, 100,startingStones);
      CircleShape B2 = new CircleShape(100, 100, 100,startingStones);
      CircleShape B3 = new CircleShape(100, 100, 100,startingStones);
      CircleShape B4 = new CircleShape(100, 100, 100,startingStones);
      CircleShape B5 = new CircleShape(100, 100, 100,startingStones);
      CircleShape B6 = new CircleShape(100, 100, 100,startingStones);
      
      constraint.gridx = 1; 
      constraint.gridy = 2; 
      JLabel b1 = new JLabel(B1); 
      boardPanel.add(b1,constraint);
      
      constraint.gridx = 2; 
      constraint.gridy = 2; 
      JLabel b2 = new JLabel(B2); 
      boardPanel.add(b2,constraint);
      
      constraint.gridx = 3; 
      constraint.gridy = 2; 
      JLabel b3 = new JLabel(B3); 
      boardPanel.add(b3,constraint);
      
      constraint.gridx = 4; 
      constraint.gridy = 2; 
      JLabel b4 = new JLabel(B4); 
      boardPanel.add(b4,constraint);
      
      constraint.gridx = 5; 
      constraint.gridy = 2; 
      JLabel b5 = new JLabel(B5); 
      boardPanel.add(b5,constraint);
      
      constraint.gridx = 6; 
      constraint.gridy = 2; 
      JLabel b6 = new JLabel(B6); 
      boardPanel.add(b6,constraint);
      
      //player 2 manacala
      RectangleShape R1 = new RectangleShape(0, 0, 100, 100);
      RectangleShape R2 = new RectangleShape(0, 0, 100, 100);
      
      constraint.gridx = 0; 
      constraint.gridy = 1; 
      JLabel r1 = new JLabel(R1); 
      boardPanel.add(r1,constraint);
      
      constraint.gridx = 0; 
      constraint.gridy = 2; 
      JLabel r2 = new JLabel(R2); 
      boardPanel.add(r2,constraint);
      
      //player 1 manacala 
      RectangleShape R3 = new RectangleShape(0, 0, 100, 100);
      RectangleShape R4 = new RectangleShape(0, 0, 100, 100);
      
      constraint.gridx = 7; 
      constraint.gridy = 1; 
      JLabel r3 = new JLabel(R3); 
      boardPanel.add(r3,constraint);
      
      constraint.gridx = 7; 
      constraint.gridy = 2; 
      JLabel r4 = new JLabel(R4); 
      boardPanel.add(r4,constraint);
      
      JLabel player1 = new JLabel("Player 1");
      player1.setFont(new Font("Serif",Font.PLAIN,25));
      player1.setForeground(Color.yellow);
      JLabel player2 = new JLabel("Player 2");
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
      for(int i=1; i<=6; i++)
      {
         String temp = "A" + i + ""; 
         JLabel pitTexts = new JLabel (temp);
         pitTexts.setFont(new Font("Serif",Font.PLAIN,25));
         pitTexts.setForeground(Color.YELLOW);
         constraint.gridx = i;
         constraint.gridy = 3;
         boardPanel.add(pitTexts,constraint);
      }
      //player 2 texts
      int counter = 1;
      for(int i=6; i>=1; i--)
      {
         String temp = "B" + i + ""; 
         JLabel pitTexts = new JLabel (temp);
         pitTexts.setFont(new Font("Serif",Font.PLAIN,25));
         pitTexts.setForeground(Color.YELLOW);
         constraint.gridx = counter;
         constraint.gridy = 0;
         boardPanel.add(pitTexts,constraint);
         counter++;
      }
      
      board.add(boardPanel);
      board.setVisible(true);
      board.pack();
      board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
   }  
}