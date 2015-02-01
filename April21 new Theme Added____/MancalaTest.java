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

		MancalaBoard temp = new MancalaBoard(400, 900);
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
			temp.makeBoard(new DefaultTheme());
		else
		{
			temp.makeBoard(new FancyTheme());
		}
	}

}
