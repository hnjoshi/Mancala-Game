import javax.swing.JOptionPane;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jagrut
 */
public class MancalaTest 
{	
	public static void main (String[]args)
	{
		BoardData myData = new BoardData();
		myData.addView(new MancalaBoard(400,900,myData));
	}

}
