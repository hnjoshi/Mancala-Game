
public class BoardData
{
	MancalaBoard myBoard;
	int[] pits; 
	int[] pitsbackup;
	
	public BoardData()
	{
		pits = new int[14];
		pitsbackup = new int[14];
	}
	
/*	
	This method register view to data object
	@param abc view.
*/	
	public void addView(MancalaBoard abc)
	{
		myBoard = abc;
	}
	
/*
 * This method tell data's view to update.
*/
	public void notifyChange()
	{
		myBoard.notifyChange();
	}
	
	
	
}
